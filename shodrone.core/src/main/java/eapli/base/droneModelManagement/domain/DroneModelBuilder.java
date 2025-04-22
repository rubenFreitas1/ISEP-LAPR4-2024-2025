package eapli.base.droneModelManagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Calendar;

public class DroneModelBuilder implements DomainFactory<DroneModel> {


    private String modelName;

    private String manufacturer;

    private Calendar createdOn;

    private SystemUser createdBy;

    public DroneModelBuilder withModelName(final String modelName) {
        this.modelName = modelName;
        return this;
    }

    public DroneModelBuilder withManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public DroneModelBuilder createdOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public DroneModelBuilder createdBy(final SystemUser createdBy) {
        this.createdBy = createdBy;
        return this;
    }
    @Override
    public DroneModel build() {
        return new DroneModel(modelName, manufacturer, createdOn, createdBy);
    }
}
