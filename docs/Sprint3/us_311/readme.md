# US 311 - Add drones to a proposal

## 1. Context

*This user story focuses on enabling CRM collaborators to configure the drone list for a proposal, ensuring that only valid models (i.e., those that exist in Shodrone's inventory)
can be selected. At this stage, there is no requirement to verify whether drones are already allocated to another show on the same date.*

## 2. Requirements

**US311** As a CRM Collaborator, I want to configure the list of drone models (number of drones and model) of
a show proposal.
The drones in the proposal must be compatible with the drones in the Shodrone’s inventory. As such,
the number of drones of a given type in a proposal cannot exceed the total number of active drones
of that type in the inventory. There is no need to verify if these drones are used in another show on
the same date.

**Acceptance Criteria:**

- US311.1 The drone models in the proposal must be compatible with the drones in the Shodrone’s inventory.
- US311.2 The system does not need to validate the availability of drones for a specific date.
- US311.3 The user must be able to add multiple drone models with corresponding quantities to a single proposal.

**Dependencies/References:**

*There is a dependency on the US310, since this US creates a show proposal.*

**Forum Insight:**

>> Uma maneira de configurar a lista de drones num proposal seria, por exemplo, pedir ao utilizador o modelo do drone e em seguida pedir o número de drones para esse mesmo modelo, continuando assim para todos os modelos que ele quiser. Acha correto?
>
> Pode ser. Tenha em atenção que "the number of drones of a given type in a proposal cannot exceed the total number of active drones of that type in the inventory."

>> Na US310, é referido que um número total de drones será incluído no show proposal, e que todas as figuras irão utilizar esses drones. Assim, ao configurar a lista de modelos de drones num show proposal, devo ter em atenção que a soma do número de drones de cada modelo não deve ultrapassar o número total de drones associado ao show proposal, correto?
>
> Claro...

>> Nesta funcionalidade também é possível remover drone models do proposal?
>
> Não tenho nada contra poder remover modelos de drones durante a US311. Mas note que mexer na proposta tem de eliminar o teste e aprovação/validação.
> Também não pode ser possível, de forma alguma, mexer numa proposta que já foi enviada ao cliente.

>> Na US310, é referido que um número total de drones será incluído no show proposal, e que todas as figuras irão utilizar esses drones. Assim, ao configurar a lista de modelos de drones num show proposal, devo ter em atenção que a soma do número de drones de cada modelo não deve ultrapassar o número total de drones associado ao show proposal, correto?
>
> Claro...


## 3. Analysis

![System Sequence Diagram ](images/system-sequence-diagram-US311.svg)

## 4. Design

### 4.1. Sequence Diagram

![Sequence Diagram](images/sequence-diagram-US311.svg)

### 4.3. Applied Patterns

- Controller
- Creator
- Polymorphism
- Indirection
- DTO

### 4.4. Acceptance Tests

**Test 1:** *Tests that adding valid drone models with positive quantities to the proposal succeeds and the total quantities are updated accordingly.*

```
    @Test
    void addDroneToList_Succeed() {
        boolean result1 = proposal.addDroneToList(modelA, 3);
        assertTrue(result1);
        assertEquals(3, proposal.allDroneModels_Quantity());

        boolean result2 = proposal.addDroneToList(modelB, 2);
        assertTrue(result2);
        assertEquals(5, proposal.allDroneModels_Quantity());
    }

````

**Test 2:** *Tests failure cases for adding drone models to the proposal: when the drone model is null, quantity is non-positive, total quantity was exceeded, or the drone model has already been added.*

```
@Test
    void addDroneToList_Fail_DroneModelIsNull() {
        boolean result = proposal.addDroneToList(null, 2);
        assertFalse(result);
    }

    @Test
    void addDroneToList_Fail_QuantityIsNonPositive() {
        boolean resultZero = proposal.addDroneToList(modelA, 0);
        boolean resultNegative = proposal.addDroneToList(modelA, -1);

        assertFalse(resultZero);
        assertFalse(resultNegative);
    }

    @Test
    void addDroneToList_Fail_ExceedingTotalLimit() {
        assertTrue(proposal.addDroneToList(modelA, 4));
        assertFalse(proposal.addDroneToList(modelB, 2)); // Total é 5
    }

    @Test
    void addDroneToList_Fail_ModelAlreadyAdded() {
        assertTrue(proposal.addDroneToList(modelA, 3));
        assertFalse(proposal.addDroneToList(modelA, 1));
    }
````

**Test 3:** *Tests that the service successfully adds a drone model to a valid show proposal.*

```
   @Test
    void addDroneModelToProposal_success() {
        Drone drone1 = mock(Drone.class);
        Drone drone2 = mock(Drone.class);
        Drone drone3 = mock(Drone.class);
        when(repo.findByDroneModel(modelA)).thenReturn(List.of(drone1, drone2, drone3));
        boolean result = service.addDroneModelToProposal(proposal, modelA, 1);
        assertTrue(result);
    }

````

**Test 4:** *Tests that the service throws an IllegalArgumentException when attempting to add a drone model that don't have the quantity of drones registered in the system required.*

```
   @Test
    void addDroneModelToProposal_notEnoughDrones_throwsException() {
        Drone drone1 = mock(Drone.class);
        when(repo.findByDroneModel(modelA)).thenReturn(List.of(drone1));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                service.addDroneModelToProposal(proposal, modelA, 3));
        assertEquals("Not enough Drones with this Drone Model Registered in the System!", ex.getMessage());
    }

````




**Test 5:** *Tests that the service throws an IllegalArgumentException when attempting to add a drone model to a null proposal or when the drone model itself is null.*

```
   @Test
    void addDroneModelToProposal_nullProposal_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.addDroneModelToProposal(null, modelA, 3));
    }

    @Test
    void addDroneModelToProposal_nullDroneModel_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.addDroneModelToProposal(proposal, null, 3));
    }

````


## 5. Implementation

**AddDronesToProposalAction**

```java
public class AddDronesToProposalAction implements Action {
    @Override
    public boolean execute() {
        return new AddDronesToProposalUI().show();
    }
}
```
**AddDronesToProposalUI**
```java
public class AddDronesToProposalUI extends AbstractUI {

    private final AddDronesToProposalController controller = new AddDronesToProposalController();
    @Override
    protected boolean doShow() {
        Iterable<ShowProposalDTO> showProposalList = this.controller.getListShowProposals();
        if (!showProposalList.iterator().hasNext()) {
            System.out.println("There are no registered Show Proposals in the system to add Drone Models!");
            return false;
        }
        String headerModel = String.format("Select Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION","PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
        SelectWidget<ShowProposalDTO> selectorShowProposal = new SelectWidget<>(headerModel, showProposalList, new ShowProposalDTOPrinter());
        selectorShowProposal.show();
        ShowProposalDTO showProposalDTO = selectorShowProposal.selectedElement();
        if(showProposalDTO == null){
            System.out.println("Show Proposal cannot be null!");
            return false;
        }
        if(addingDroneModels(showProposalDTO)){
            if (this.controller.save(showProposalDTO)){
                System.out.println("Show Proposal successfully saved with Drone Models!");
            }else {
                System.out.println("Show Proposal error saving!");
            }
        }

        return true;
    }


    public boolean addingDroneModels(ShowProposalDTO showProposal){
        List<DroneModelDTO> availableDroneModels = new ArrayList<>();
        Iterable<DroneModelDTO> droneModels = this.controller.getListDroneModels();
        for (DroneModelDTO model : droneModels) {
            availableDroneModels.add(model);
        }
        while(true){
            int numberOfDronesLeft = showProposal.getTotalDroneNumber() - controller.allDronesInDroneList(showProposal);
            if(numberOfDronesLeft == 0){
                System.out.println("\n--- Drone Models Successfully Added! ---\n");
                return true;
            }
            System.out.println("\n--- Number of Drones Left " + numberOfDronesLeft + " ---");
            if (availableDroneModels.isEmpty()) {
                System.out.println("No more Drone Models available to select.");
                break;
            }
            String headerdroneModel = String.format("Select Drone Model\n#  %-30s%-30s%-30s%-30s", "MODEL NAME", "MANUFACTURER", "STATUS", "CREATED BY");
            SelectWidget<DroneModelDTO> droneModelSelectWidget = new SelectWidget<>(headerdroneModel, availableDroneModels, new DroneModelDTOPrinter());
            droneModelSelectWidget.show();
            DroneModelDTO droneModel = droneModelSelectWidget.selectedElement();
            if(droneModel == null){
                System.out.println("The Drone Model cannot be null!");
                break;
            }
            int quantity = Console.readInteger("Quantity:");
            try{
                if(controller.addDroneModelToProposal(showProposal, droneModel, quantity)){
                    System.out.printf("\n--- Drone Model: %s added successfully! ---\n", droneModel.getModelName());
                    availableDroneModels.remove(droneModel);
                }else{
                    System.out.println("Error adding Drone Model!");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Add Drone Models to the Show Proposal";
    }
}
```

**AddDronesToProposalController**
```java
@UseCaseController
public class AddDronesToProposalController {


    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();

    private final DroneModelRepository droneModelRepository = PersistenceContext.repositories().droneModels();

    private final DroneRepository droneRepository = PersistenceContext.repositories().drones();
    private final AddDroneModelsToProposalService addDroneModelsToProposalService = new AddDroneModelsToProposalService(droneRepository);

    private final DroneModelDTOParser droneModelDTOParser = new DroneModelDTOParser();

    private final ShowProposalDTOParser showProposalDTOParser = new ShowProposalDTOParser();

    public Iterable<DroneModelDTO> getListDroneModels(){
        Iterable<DroneModel> list =  this.droneModelRepository.findByActive(true);
        return droneModelDTOParser.transformToDroneModelDTO(list);
    }

    public Iterable<ShowProposalDTO> getListShowProposals(){
        Iterable<ShowProposal> showProposals = this.showProposalRepository.findByStatusAndEmptyDroneList(ShowStatus.PENDING);
        return showProposalDTOParser.transformToShowProposalDTOlist(showProposals);
    }

    public boolean addDroneModelToProposal(ShowProposalDTO showProposalDTO,DroneModelDTO droneModelDTO, int quantity){
        Optional<DroneModel> droneModel = droneModelDTOParser.getDroneModelFromDTO(droneModelDTO);
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        if(droneModel.isPresent() & showProposal.isPresent()){
            return addDroneModelsToProposalService.addDroneModelToProposal(showProposal.get(),droneModel.get(), quantity);
        }
        return false;
    }

    public boolean save(ShowProposalDTO showProposalDTO){
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        if (showProposal.isPresent()){
            this.showProposalRepository.save(showProposal.get());
            return true;
        }
        return false;
    }

    public int allDronesInDroneList(ShowProposalDTO showProposalDTO){
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        return showProposal.get().allDroneModels_Quantity();
    }



}

```

**AddDroneModelsToProposalService**

```Java
public class AddDroneModelsToProposalService {

    private final DroneRepository droneRepository;

    public AddDroneModelsToProposalService(final DroneRepository droneRepository){
        this.droneRepository = droneRepository;
    }

    public boolean addDroneModelToProposal(ShowProposal showProposal, DroneModel droneModel, int quantity){
        if(showProposal == null){
            throw new IllegalArgumentException("Show Proposal cannot be null!");
        }
        if(droneModel == null){
            throw new IllegalArgumentException("Drone Model cannot be null!");
        }
        if(numberDronesOfDroneModel(droneModel) < quantity){
            throw new IllegalArgumentException("Not enough Drones with this Drone Model Registered in the System!");
        }
        return showProposal.addDroneToList(droneModel, quantity);
    }



    private int numberDronesOfDroneModel(DroneModel droneModel){
        int numberOfDrones = 0;
        Iterable<Drone> drones = this.droneRepository.findByDroneModel(droneModel);
        for (Drone drone : drones){
            numberOfDrones++;
        }
        return  numberOfDrones;
    }
}
```

**ShowProposal**
```Java
@Entity
public class ShowProposal implements AggregateRoot<Long>, DTOable<ShowProposalDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long showProposalId;

    @ManyToOne
    private ShowRequest showRequest;

    @Column(nullable = false)
    private GeoLocation location;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int totalDroneNumber;

    @Column(nullable = false)
    private double insuranceAmount;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @Column(nullable = false)
    private int proposalNumber;

    @ManyToOne
    private SystemUser createdBy;
    @Enumerated(EnumType.STRING)
    private ShowStatus status;

    @OneToMany(mappedBy = "showProposal", cascade = CascadeType.ALL)
    private List<DroneListItem> droneModelList;

    @Column (nullable = true)
    private String videoLink;

    @ManyToOne
    private Template template;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id", referencedColumnName = "documentId")
    private Document document;

    @Embedded
    private ProposalAnswerFeedback proposalAnswerFeedback;

    protected ShowProposal() {}

    public ShowProposal(ShowRequest showRequest, GeoLocation location, Calendar date, LocalTime time, int duration, int totalDroneNumber, int proposalNumber, SystemUser createdBy, Template template, double insuranceAmount) {
        this.showRequest = validateShowRequest(showRequest);
        this.location = validateLocation(location);
        this.date = validateDate(date);
        this.time = validateTime(time);
        this.duration = validateDuration(duration);
        this.totalDroneNumber = validateTotalDroneNumber(totalDroneNumber);
        this.proposalNumber = validateProposalNumber(proposalNumber);
        this.template = validateTemplate(template);
        this.createdBy = validateCreatedBy(createdBy);
        this.createdOn = Calendar.getInstance();
        this.status = ShowStatus.PENDING;
        this.droneModelList = new ArrayList<>();
        this.document = null;
        this.proposalAnswerFeedback = null;
        this.insuranceAmount = insuranceAmount;
    }

    public boolean addDroneToList(DroneModel droneModel, int quantity){
        if (droneModel == null || quantity <= 0) return false;

        int currentTotal = 0;
        for (DroneListItem item : droneModelList) {
            currentTotal += item.numberOfDrones();
        }

        if (currentTotal + quantity > totalDroneNumber) {
            return false;
        }

        for (DroneListItem item : droneModelList) {
            if (item.droneModel().equals(droneModel)) {
                return false;
            }
        }

        DroneListItem newItem = new DroneListItem(droneModel, this, quantity);
        droneModelList.add(newItem);
        return true;
    }

    public int allDroneModels_Quantity(){
        int currentTotal = 0;
        for (DroneListItem item : droneModelList) {
            currentTotal += item.numberOfDrones();
        }
        return currentTotal;
    }

    public List<DroneListItem> droneListItem (){
        return this.droneModelList;
    }

    public boolean addVideoToProposal(String video) {
        if (isValidVideoLink(video)) {
            this.videoLink = video;
            return true;
        }
        return false;
    }

    public Template template() {return this.template;}

    public ShowStatus status(){return  this.status;}

    public ShowRequest showRequest() { return this.showRequest; }

    public Calendar createdOn() { return this.createdOn; }

    public GeoLocation location() { return this.location; }

    public Calendar date() { return this.date; }

    public int totalDroneNumber() { return this.totalDroneNumber; }

    public int duration() { return this.duration; }

    public int proposalNumber() { return this.proposalNumber; }

    public SystemUser createdBy() { return this.createdBy; }

    public LocalTime time() { return this.time; }

    public String videoLink() { return this.videoLink; }

    public double insuranceAmount() { return this.insuranceAmount; }

    public ProposalAnswerFeedback proposalAnswerFeedback(){ return this.proposalAnswerFeedback; }

    public Document document(){return this.document;}

    public ShowRequest validateShowRequest(ShowRequest showRequest) {
        if (showRequest == null)
            throw new IllegalArgumentException("ShowRequest cannot be null");
        return showRequest;
    }

    public GeoLocation validateLocation(GeoLocation location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        double latitude = location.latitude();
        double longitude = location.longitude();
        int altitude = location.altitude();

        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees.");
        }

        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180 degrees.");
        }

        if (altitude <= 0) {
            throw new IllegalArgumentException("Altitude must be a positive number.");
        }
        return location;
    }

    public Calendar validateDate(Calendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date;
    }

    public LocalTime validateTime(LocalTime time) {
        if (time == null)
            throw new IllegalArgumentException("Time cannot be null");
        return time;
    }

    public int validateDuration(Integer duration) {
        if (duration == null) {
            throw new IllegalArgumentException("Duration cannot be null.");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0.");
        }
        return duration;
    }

    public int validateTotalDroneNumber(Integer totalDroneNumber) {
        if (totalDroneNumber == null) {
            throw new IllegalArgumentException("Total drone number cannot be null.");
        }
        if (totalDroneNumber <= 0) {
            throw new IllegalArgumentException("Total drone number must be greater than 0.");
        }
        return totalDroneNumber;
    }

    public int validateProposalNumber(int proposalNumber) {
        if (proposalNumber < 0)
            throw new IllegalArgumentException("Proposal number cannot be negative");
        return proposalNumber;
    }

    public SystemUser validateCreatedBy(SystemUser createdBy) {
        if (createdBy == null)
            throw new IllegalArgumentException("CreatedBy (SystemUser) cannot be null");
        return createdBy;
    }

    public boolean isValidVideoLink(String videoLink) {
        if (videoLink == null) {
            throw new IllegalArgumentException("Video link cannot be null");
        }
        final String videoLinkPattern = "^(https?://|www\\.)[a-zA-Z0-9][-a-zA-Z0-9&',./_=?%#:~]*$";
        return videoLink.matches(videoLinkPattern);
    }

    public Template validateTemplate(Template template) {
        if (template == null) {
            throw new IllegalArgumentException("Template cannot be null");
        }
        return template;
    }
    public boolean updateProposalAnswer(ProposalAnswerFeedback answer){
        if(answer != null & answer.answer() != null){
            this.proposalAnswerFeedback = answer;
            return true;
        }
        return false;
    }

    public boolean markShowProposal(){
        if(proposalAnswerFeedback != null && proposalAnswerFeedback.answer() == ProposalAnswerFeedback.Answer.ACCEPTED){
            status = ShowStatus.ACCEPTED;
            return true;
        }
        return false;
    }

    public boolean addDocument(Document document){
        if(document != null){
            this.document = document;
            return true;
        }
        return false;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (!(other instanceof ShowProposal)) return false;
        ShowProposal that = (ShowProposal) other;
        return showProposalId != null && showProposalId.equals(that.showProposalId);
    }

    @Override
    public Long identity() {
        return this.showProposalId;
    }

    @Override
    public ShowProposalDTO toDTO() {
        Long docId = document != null ? document.identity() : null;
        return new ShowProposalDTO(showProposalId,showRequest.identity(),showRequest().customer().customerName().toString(),showRequest.description(), location, date,
                time,duration,totalDroneNumber,insuranceAmount,createdOn,proposalNumber,createdBy.name().toString(), status,videoLink,droneModelList,template.name(), docId, proposalAnswerFeedback);
    }
}
```

**DroneListItem**

```Java
@Entity
public class DroneListItem implements DTOable<DroneListItemDTO> {

    @EmbeddedId
    private DroneListItemId droneListItemId;

    @ManyToOne
    @MapsId("showProposalId")
    private ShowProposal showProposal;

    @ManyToOne
    @MapsId("droneModelId")
    private DroneModel droneModel;


    private int numberOfDrones;



    protected  DroneListItem(){
    }

    public DroneListItem(DroneModel droneModel, ShowProposal showProposal,int numberOfDrones){
        Preconditions.noneNull(new Object[] {droneModel, showProposal,numberOfDrones});
        Preconditions.ensure(numberOfDrones > 0, "Number of drones can't be negative!");
        this.droneModel = droneModel;
        this.showProposal = showProposal;
        this.numberOfDrones = numberOfDrones;
        this.droneListItemId = new DroneListItemId(droneModel.identity(), showProposal.identity());
    }

    public ShowProposal showProposal() {
        return showProposal;
    }

    public DroneModel droneModel() {
        return droneModel;
    }

    public int numberOfDrones() {
        return numberOfDrones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DroneListItem that = (DroneListItem) o;
        return Objects.equals(showProposal, that.showProposal) && Objects.equals(droneModel, that.droneModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showProposal, droneModel);
    }

    @Override
    public DroneListItemDTO toDTO() {
        return new DroneListItemDTO(droneModel.identity(), showProposal.identity(), droneModel.modelName(), numberOfDrones);
    }
}
```

**DroneListItemId**

```Java
@Embeddable
public class DroneListItemId implements Serializable {


    private Long droneModelId;


    private Long showProposalId;

    protected DroneListItemId(){
    }


    public DroneListItemId( Long droneModelId, Long showProposalId){
        this.droneModelId = droneModelId;
        this.showProposalId = showProposalId;
    }

    public Long droneModelId() {
        return droneModelId;
    }

    public Long showProposalId() {
        return showProposalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DroneListItemId that = (DroneListItemId) o;
        return Objects.equals(droneModelId, that.droneModelId) && Objects.equals(showProposalId, that.showProposalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droneModelId, showProposalId);
    }

    @Override
    public String toString() {
        return "DroneListItemId{" +
                "droneModelId=" + droneModelId +
                ", showProposalId=" + showProposalId +
                '}';
    }
}
```


## 6. Integration/Demonstration

**Adding Drone Models to Proposal**

![Adding-Drone-Models-to-Proposal-Parte1](images/demonstration/adding-droneModels-p1.png)

![Adding-Drone-Models-to-Proposal-Parte2](images/demonstration/adding-droneModels-p2.png)

**Database Result**

![Database](images/demonstration/database.png)
