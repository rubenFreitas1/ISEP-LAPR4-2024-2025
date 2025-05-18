
# US 222

## 1. Context

*As a CRM Collaborator, I want to list all customer representatives.*

### 1.1 List of issues

Analysis:

Design:

Implement:

Test:


## 2. Requirements

**US G222** As a CRM Collaborator, I want to list all customer representatives.

**Acceptance Criteria:**

- US222.1 It should not list disabled representatives.

**Dependencies/References:**

*There is a dependency with US220 and US221, since a customer must exist and must have representatives assigned.*

**Forum Insight:**

* Still no questions related to this user story on forum.

## 3. Analysis

![System Sequence Diagram ](images/system-sequence-diagram-US222.svg)

## 4. Design

### 4.1. Sequence Diagram

![Sequence Diagram](images/sequence-diagram-US222.svg)
### 4.3. Applied Patterns

- Information Expert
- Controller
- Low Coupling
- High Cohesion
- Polymorphism
- Pure Fabrication
- Indirection
- Protected Variations

### 4.4. Acceptance Tests

**Test 1:** *Verifies that all representatives are returned*

```
    @Test
    void findAll_shouldReturnAllRepresentatives() {
        List<Representative> expected = List.of(representative);
        when(representativeRepository.findAll()).thenReturn(expected);

        Iterable<Representative> result = service.findAll();

        assertNotNull(result);
        assertEquals(expected, result);
        verify(representativeRepository).findAll();
    }

````

**Test 2:** *Verifies that all customer representatives are returned*

```
    @Test
    void findByAssociatedCustomer_shouldReturnCustomerRepresentatives() {
        List<Representative> expected = List.of(representative);
        when(representativeRepository.findByAssociatedCustomer(customer)).thenReturn(expected);

        Iterable<Representative> result = service.findByAssociatedCustomer(customer);

        assertNotNull(result);
        assertEquals(expected, result);
        verify(representativeRepository).findByAssociatedCustomer(customer);
    }

````

## 5. Implementation



**ListRepresentativesAction**

```java
public class ListRepresentativesAction implements Action {

    @Override
    public boolean execute() {
        return new ListRepresentativesUI().show();
    }
}


```
**ListRepresentativesUI**
```java
public class ListRepresentativesUI extends AbstractListUI<Representative> {

    private final ListRepresentativesController theController = new ListRepresentativesController();
    private Customer selectedCustomer;

    @Override
    public String headline() {
        return "List Representatives";
    }

    @Override
    protected Iterable<Representative> elements() {
        if (selectedCustomer == null) {
            selectCustomer();
        }
        return theController.allRepresentatives(selectedCustomer);
    }

    @Override
    protected Visitor<Representative> elementPrinter() {
        return new RepresentativePrinter();
    }

    @Override
    protected String elementName() {
        return "Representative";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-30s%-30s%-30s%-30s", "REPRESENTATIVE NAME", "REPRESENTATIVE EMAIL", "REPRESENTATIVE PASSWORD", "REPRESENTATIVE PHONE NUMBER", "REPRESENTATIVE POSITION");
    }

    @Override
    protected String emptyMessage() {
        return "No representatives found for the selected customer.";
    }

    private void selectCustomer() {
        System.out.println("Select a Customer:");
        Iterable<Customer> customers = theController.allCustomers();
        int index = 1;
        for (Customer customer : customers) {
            System.out.printf("%d - %s%n", index++, customer.customerName());
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        index = 1;
        for (Customer customer : customers) {
            if (index == choice) {
                selectedCustomer = customer;
                break;
            }
            index++;
        }
    }
}

```

**ListRepresentativesController**
```java
public class ListRepresentativesController {

    private final TransactionalContext autoTx = PersistenceContext.repositories().newTransactionalContext();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final RepresentativeRepository repreRepo = PersistenceContext.repositories().representatives(autoTx);

    private final CustomerRepository customerRepo = PersistenceContext.repositories().customers(autoTx);

    private final RepresentativeManagementService representativesvc = new RepresentativeManagementService(repreRepo, customerRepo);

    private final CustomerManagementService customersvc = new CustomerManagementService(customerRepo);

    public Iterable<Representative> allRepresentatives(Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return representativesvc.findByAssociatedCustomer(customer);
    }

    public Iterable<Customer> allCustomers() {
        authz.ensureAuthenticatedUserHasAnyOf(Roles.CRM_COLLABORATOR);
        return customersvc.findAllCustomers();
    }
}

```

**RepresentativeManagementService**
```Java
public class RepresentativeManagementService {

    private final RepresentativeRepository representativeRepository;
    private final CustomerRepository customerRepository;

    public RepresentativeManagementService(final RepresentativeRepository representativeRepository, final CustomerRepository customerRepository) {
        this.representativeRepository = representativeRepository;
        this.customerRepository = customerRepository;
    }

    public void registerNewRepresentative(final String representativeName, final String representativeEmail, final Calendar createdOn, final String representativePassword, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition, final SystemUser createdBy){
        if(representativeName == null || representativeName.isEmpty()){
            throw new IllegalArgumentException("Representative Name cannot be null or empty!");
        }
        if(representativeEmail == null || representativeEmail.isEmpty() || isEmailUsed(representativeEmail)){
            throw new IllegalArgumentException("Representative Email is already in use. (Also it cannot be null or empty!)");
        }
        if(representativePassword == null || representativePassword.isEmpty()){
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

        Representative newRepresentative = new Representative(representativeName, representativeEmail, createdOn, representativePassword, representativePhoneNumber, associatedCustomer, representativePosition, createdBy);
        associatedCustomer.addRepresentative(newRepresentative);
        this.customerRepository.save(associatedCustomer);
    }

    public void registerNewRepresentative(final String representativeName, final String representativeEmail,final String representativePassword, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition, final SystemUser createdBy){
        registerNewRepresentative(representativeName, representativeEmail, CurrentTimeCalendars.now(), representativePassword, representativePhoneNumber, associatedCustomer, representativePosition, createdBy);
    }

    public void editRepresentative(final Representative representative, final String newName, final String newEmail, final String newPassword, final String newPhoneNumber, final String newPosition){
        boolean edited = false;
        if(newName == null || newName.isEmpty()){
            throw new IllegalArgumentException("Representative Name cannot be null or empty!");
        }else if(!newName.equals("N")){
            edited = true;
            representative.changeName(newName);
        }
        if(newEmail == null || newEmail.isEmpty() || isEmailUsed(newEmail) || isEmailUsed(newEmail)){
            throw new IllegalArgumentException("Representative Email is already in use. (Also it cannot be null or empty!)");
        }else if(!newEmail.equals("N")){
            edited = true;
            representative.changeEmail(newEmail);
        }
        if(newPassword == null || newPassword.isEmpty()){
            throw new IllegalArgumentException("Representative Password cannot be null or empty!");
        }else if(!newPassword.equals("N")){
            edited = true;
            representative.changePassword(newPassword);
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

```

**Representative**

```Java
public class Representative implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long representativeId;
    @Column
    private String representativeName;
    @Column
    private String representativeEmail;
    @Column
    private String representativePassword;
    @Column
    private String representativePhoneNumber;

    @ManyToOne
    private Customer associatedCustomer;
    @Column
    private String representativePosition;

    private boolean active;
    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @Temporal(TemporalType.DATE)
    private Calendar changedOn;
    @ManyToOne
    private SystemUser createdBy;

    protected Representative() {
    }

    public Representative(final String representativeName, final String representativeEmail, final Calendar createdOn, final String representativePassword, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition, final SystemUser createdBy) {
        this.representativeName = representativeName;
        this.representativeEmail = representativeEmail;
        this.representativePassword = representativePassword;
        this.representativePhoneNumber = representativePhoneNumber;
        this.associatedCustomer = associatedCustomer;
        this.representativePosition = representativePosition;
        this.createdBy = createdBy;
        this.createdOn = createdOn == null ? CurrentTimeCalendars.now() : createdOn;
        this.changedOn = createdOn == null ? CurrentTimeCalendars.now() : createdOn;
        this.active = true;
    }

    public String representativeName() {
        return this.representativeName;
    }
    public String representativeEmail() {
        return this.representativeEmail;
    }
    public String representativePassword() {
        return this.representativePassword;
    }
    public String representativePhoneNumber() {
        return this.representativePhoneNumber;
    }
    public Customer associatedCustomer() {
        return this.associatedCustomer;
    }
    public String representativePosition() {
        return this.representativePosition;
    }
    public SystemUser createdBy() {
        return this.createdBy;
    }
    public Calendar createdOn() {
        return this.createdOn;
    }
    public Calendar changedOn() {return this.changedOn;}
    public boolean isActive() {
        return this.active;
    }
    public Calendar deactivatedOn(){
        return this.deactivatedOn;
    }
    public void deactivate(final Calendar deactivatedOn) {
        if (deactivatedOn != null && !deactivatedOn.before(this.createdOn)) {
            if (!this.active) {
                throw new IllegalStateException("Cannot deactivate an inactive Drone Model!");
            } else {
                this.active = false;
                this.deactivatedOn = deactivatedOn;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void changeName(final String representativeName) {
        this.representativeName = representativeName;
    }
    public void changeEmail(final String representativeEmail) {
        this.representativeEmail = representativeEmail;
    }
    public void changePassword(final String representativePassword) {
        this.representativePassword = representativePassword;
    }
    public void changePhoneNumber(final String representativePhoneNumber) {
        this.representativePhoneNumber = representativePhoneNumber;
    }
    public void changePosition(final String representativePosition) {
        this.representativePosition = representativePosition;
    }
    public void changeChangedOn() {
        this.changedOn = Calendar.getInstance();
    }

    public void activate() {
        if (!this.isActive()) {
            this.active = true;
            this.deactivatedOn = null;
        }
    }
    @Override
    public boolean sameAs(final Object other) {
        if (this == other) return true;
        if (!(other instanceof Representative)) return false;
        Representative that = (Representative) other;
        return representativeId != null && representativeId.equals(that.representativeId);
    }
    @Override
    public String toString() {
        return "Representative{" +
                "representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                ", representativePassword='" + representativePassword + '\'' +
                ", representativePhoneNumber='" + representativePhoneNumber + '\'' +
                ", associatedCustomer=" + associatedCustomer +
                ", representativePosition='" + representativePosition + '\'' +
                ", active=" + active +
                '}';
    }
    @Override
    public Long identity() {
        return this.representativeId;
    }
}
```
## 6. Integration/Demonstration

**Customer Selection**

![Customer-selection](images/demonstration/customerSelection.png)

**Listing Representatives**

![Listing-representative](images/demonstration/listingRepresentatives.png)

