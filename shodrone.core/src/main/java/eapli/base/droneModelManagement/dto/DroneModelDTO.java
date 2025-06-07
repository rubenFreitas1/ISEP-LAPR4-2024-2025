package eapli.base.droneModelManagement.dto;

import eapli.framework.representations.dto.DTO;

import java.util.Calendar;

@DTO
public class DroneModelDTO {

    private Long droneModelId;
    private String modelName;
    private String manufacturer;
    private Calendar createdOn;
    private boolean active;
    private Calendar deactivatedOn;
    private String createdBy;
    private Long windBehavior;

    public DroneModelDTO(){}

    public DroneModelDTO(Long droneModelId, String modelName, String manufacturer, Calendar createdOn, boolean active, Calendar deactivatedOn, String createdBy, Long windBehavior) {
        this.droneModelId = droneModelId;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.createdOn = createdOn;
        this.active = active;
        this.deactivatedOn = deactivatedOn;
        this.createdBy = createdBy;
        this.windBehavior = windBehavior;
    }

    public Long getDroneModelId() {
        return droneModelId;
    }

    public String getModelName() {
        return modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public boolean isActive() {
        return active;
    }

    public Calendar getDeactivatedOn() {
        return deactivatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Long getWindBehavior() {
        return windBehavior;
    }
}
