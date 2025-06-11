package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Optional;

@Component
public class RepresentativeManagementService {

    private final RepresentativeRepository representativeRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordPolicy passwordPolicy;

    public RepresentativeManagementService(final RepresentativeRepository representativeRepository, final CustomerRepository customerRepository, final PasswordEncoder passwordEncoder, final PasswordPolicy passwordPolicy) {
        this.representativeRepository = representativeRepository;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordPolicy = passwordPolicy;
    }

    public void registerNewRepresentative(final String representativeFirstName, final String representativeLastName, final String representativeEmail, final Calendar createdOn, final String password, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition, final SystemUser createdBy){

        Name representativeName = Name.valueOf(representativeFirstName, representativeLastName);

        EmailAddress representativeEmailAddress = EmailAddress.valueOf(representativeEmail);
        //if (isEmailUsed(representativeEmailAddress.toString())) {
          //  throw new IllegalArgumentException("Email already in use");
        //}
        Optional<Password> representativePassword = Password.encodedAndValid(password, passwordPolicy, passwordEncoder);

        if(representativePassword.isEmpty()){
            throw new IllegalArgumentException("Representative Password cannot be null or empty!");
        }
        if(representativePhoneNumber == null || representativePhoneNumber.isEmpty()){
            throw new IllegalArgumentException("Representative Phone Number cannot be null or empty!");
        }
        if(associatedCustomer == null){
            throw new IllegalArgumentException("Associated Customer cannot be null!");
        }
        if(representativePosition == null || representativePosition.isEmpty()){
            throw new IllegalArgumentException("Representative Position cannot be null or empty!");
        }
        if(createdBy == null){
            throw new IllegalArgumentException("Created By cannot be null!");
        }

        Representative newRepresentative = new Representative(representativeName, representativeEmailAddress, createdOn, representativePassword, representativePhoneNumber, associatedCustomer, representativePosition, createdBy);
        associatedCustomer.addRepresentative(newRepresentative);
        this.customerRepository.save(associatedCustomer);
    }

    public void registerNewRepresentative(final String representativeFirstName,final String representativeLastName, final String representativeEmail,final String representativePassword, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition, final SystemUser createdBy){
        registerNewRepresentative(representativeFirstName, representativeLastName, representativeEmail, CurrentTimeCalendars.now(), representativePassword, representativePhoneNumber, associatedCustomer, representativePosition, createdBy);
    }

    public void editRepresentative(final Representative representative, final String newFirstName,final String newLastName, final String newEmail, final String newPassword, final String newPhoneNumber, final String newPosition){
        boolean edited = false;
        if(newFirstName == null || newFirstName.isEmpty()){
            throw new IllegalArgumentException("Representative Name cannot be null or empty!");
        }else if(!newFirstName.equals("N")){
            edited = true;
            String previousLastName = representative.representativeName().lastName();
            Name newRepresentativeName = Name.valueOf(newFirstName, previousLastName);
            representative.changeName(newRepresentativeName);
        }
        if(newLastName == null || newLastName.isEmpty()){
            throw new IllegalArgumentException("Representative Name cannot be null or empty!");
        }else if(!newLastName.equals("N")){
            edited = true;
            String previousFirstName = representative.representativeName().firstName();
            Name newRepresentativeName = Name.valueOf(previousFirstName, newLastName);
            representative.changeName(newRepresentativeName);
        }
        if(newEmail == null || newEmail.isEmpty()){
            throw new IllegalArgumentException("Representative Email cannot be null or empty!");
        } else if(!newEmail.equals("N") && !newEmail.equals(representative.representativeEmail().toString()) && isEmailUsed(newEmail)){
            throw new IllegalArgumentException("Representative Email is already in use!");
        } else if(!newEmail.equals("N")){
            edited = true;
            EmailAddress representativeEmailAddress = EmailAddress.valueOf(newEmail);
            representative.changeEmail(representativeEmailAddress);
        }
        if(newPassword == null || newPassword.isEmpty()){
            throw new IllegalArgumentException("Representative Password cannot be null or empty!");
        }else if(!newPassword.equals("N")){
            edited = true;
            Optional<Password> representativePassword = Password.encodedAndValid(newPassword, passwordPolicy, passwordEncoder);
            representative.changePassword(representativePassword);
        }
        if(newPhoneNumber == null || newPhoneNumber.isEmpty()){
            throw new IllegalArgumentException("Representative Phone Number cannot be null or empty!");
        }else if(!newPhoneNumber.equals("N")){
            edited = true;
            representative.changePhoneNumber(newPhoneNumber);
        }
        if(newPosition == null || newPosition.isEmpty()){
            throw new IllegalArgumentException("Representative Position cannot be null or empty!");
        }else if(!newPosition.equals("N")){
            edited = true;
            representative.changePosition(newPosition);
        }

        if (edited) {
            representative.changeChangedOn();
            this.representativeRepository.save(representative);
        }
    }

    public boolean isEmailUsed(String representativeEmail) {
        return this.representativeRepository.isEmailUsed(representativeEmail);
    }

    public boolean isPhoneNumberUsed(String representativePhoneNumber) {
        return this.representativeRepository.isPhoneNumberUsed(representativePhoneNumber);
    }

    public Optional<Representative> findById(final Long id){
        return this.representativeRepository.findById(id);
    }
    public Iterable<Representative> findByActive(final boolean active){
        return this.representativeRepository.findByActive(active);
    }
    public Iterable<Representative> findAll(){
        return this.representativeRepository.findAll();
    }
    public Iterable<Representative> findByAssociatedCustomer(final Customer associatedCustomer){
        return this.representativeRepository.findByAssociatedCustomer(associatedCustomer);
    }

    public Representative deactivateCustomerRepresentative(final Representative representative) {
        representative.deactivate(CurrentTimeCalendars.now());
        return (Representative) this.representativeRepository.save(representative);
    }
    public Representative activateRepresentative(final Representative representative) {
        representative.activate();
        return (Representative) this.representativeRepository.save(representative);
    }
}
