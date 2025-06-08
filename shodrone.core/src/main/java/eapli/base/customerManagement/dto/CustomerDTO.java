package eapli.base.customerManagement.dto;

import eapli.base.customerManagement.domain.Customer;
import eapli.framework.representations.dto.DTO;

import java.util.Calendar;
import java.util.List;

@DTO
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerVatNumber;
    private List<String> representatives;
    private String createdBy;
    private Calendar createdOn;
    private Customer.CustomerStatus status;

    public CustomerDTO(){}
    public CustomerDTO(Long customerId, String customerName, String customerAddress, String customerEmail, String customerPhoneNumber, String customerVatNumber, List<String> representatives, String createdBy, Calendar createdOn, Customer.CustomerStatus status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerVatNumber = customerVatNumber;
        this.representatives = representatives;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public String getCustomerVatNumber() {
        return customerVatNumber;
    }

    public List<String> getRepresentatives() {
        return representatives;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public Customer.CustomerStatus getStatus() {
        return status;
    }
}
