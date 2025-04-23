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
        if (modelName == null || modelName.trim().isEmpty())
            throw new IllegalArgumentException("Model name must not be null or empty");

        if (manufacturer == null || manufacturer.trim().isEmpty())
            throw new IllegalArgumentException("Manufacturer must not be null or empty");

        if (createdOn == null)
            throw new IllegalArgumentException("Creation date must not be null");

        if (createdBy == null)
            throw new IllegalArgumentException("CreatedBy SystemUser must not be null");

        return new DroneModel(modelName, manufacturer, createdOn, createdBy);
    }
}
