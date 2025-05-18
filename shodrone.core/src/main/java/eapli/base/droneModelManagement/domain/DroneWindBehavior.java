package eapli.base.droneModelManagement.domain;

import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class DroneWindBehavior implements DomainEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long droneWindBehaviorId;

    @ElementCollection
    @CollectionTable(name = "DRONEWINDBEHAVIOR_XWINDTOLERANCES", joinColumns = @JoinColumn(name = "droneWindBehaviorId"))
    private List<WindInterval> xWindTolerances = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "DRONEWINDBEHAVIOR_YWINDTOLERANCES", joinColumns = @JoinColumn(name = "droneWindBehaviorId"))
    private List<WindInterval> yWindTolerances = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "DRONEWINDBEHAVIOR_ZWINDTOLERANCES", joinColumns = @JoinColumn(name = "droneWindBehaviorId"))
    private List<WindInterval> zWindTolerances = new ArrayList<>();



    public boolean addTolerance(Axis axis, double minWind, double maxWind, double tolerance) {
        if (minWind >= maxWind) {
            System.out.println("Error: min wind must be less than max wind.");
            return false;
        }
        WindInterval newInterval = new WindInterval(minWind, maxWind, tolerance);
        switch(axis) {
            case X:
                if(!itOverlaps(xWindTolerances, newInterval)) {
                    if(isToleranceLower(tolerance, xWindTolerances)){
                        System.out.println("Error: Tolerance must be higher than the existing ones.");
                        return false;
                    }
                    xWindTolerances.add(newInterval);
                    return true;
                }else{
                    System.out.println("Error: Wind interval overlaps with existing intervals.");
                    return false;
                }
            case Y:
                if(!itOverlaps(yWindTolerances, newInterval)) {
                    if(isToleranceLower(tolerance, yWindTolerances)){
                        System.out.println("Error: Tolerance must be higher than the existing ones.");
                        return false;
                    }
                    yWindTolerances.add(newInterval);
                    return true;
                }else{
                    System.out.println("Error: Wind interval overlaps with existing intervals.");
                    return false;
                }
            case Z:
                if(!itOverlaps(zWindTolerances, newInterval)) {
                    if(isToleranceLower(tolerance, zWindTolerances)){
                        System.out.println("Error: Tolerance must be higher than the existing ones.");
                        return false;
                    }
                    zWindTolerances.add(newInterval);
                    return true;
                }else{
                    System.out.println("Error: Wind interval overlaps with existing intervals.");
                    return false;
                }


            default:
                System.out.println("Error: Axis not recognised.");
                return false;
        }
    }

    private boolean itOverlaps(List<WindInterval> list, WindInterval newInterval) {
        for (WindInterval existing : list) {
            if (existing.overlaps(newInterval)) {
                return true;
            }
        }
        return false;
    }

    private boolean isToleranceLower(double tolerance,List<WindInterval> list) {
        for(WindInterval windInterval : list){
            if(tolerance <= windInterval.tolerance()){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}
