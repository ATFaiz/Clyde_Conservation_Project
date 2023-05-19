import java.util.ArrayList;
public class userInterfaceFunction implements userInterface {
	
	/* declared array list for keeper, animal and cage.
	* also declared FileIO object
	*/
	private ArrayList<Cage> allCages;
	private ArrayList<Animal> allAnimals;
	private ArrayList<Keeper> allKeepers;
	private FileIO data;

	/* initialised array list and FileIO object
	 * call readData method
	 */
	public  userInterfaceFunction() {
		allCages = new ArrayList<>();
		allAnimals = new ArrayList<>();
		allKeepers = new ArrayList<>();
		data = new FileIO();
		readData();
		
	}

	/* search cage method
	 *  search cage by entering cageId
	 */
	@Override
	public Cage searchCage() {
		String id = searchId("Cage");
		Cage thisCage = null;
		for(Cage i : allCages) {
			if(id.equals(i.getCageId())) {
				thisCage = i;
			}
		}
		return thisCage;
		
	}
	
	/* search animal method
	 *  search animal by entering animalId
	 */
	@Override
	public Animal searchAnimal() {
		// TODO Auto-generated method stub
		String id = searchId("Animal");
		Animal thisAnimal = null;
		for(Animal i : allAnimals) {
			if(id.equals(i.getAnimalId())) {
				thisAnimal = i;
			}
		}
		return thisAnimal;
	}
	
	/* search keeper method
	 *  search keeper by entering keeperlId
	 */
	@Override
	public Keeper searchKeeper() {
		// TODO Auto-generated method stub
		String id = searchId("Keeper");
		Keeper thisKeeper = null;
		for(Keeper i : allKeepers) {
			if(id.equals(i.getKeeperId())) {
				thisKeeper = i;
			}
		}
		return thisKeeper;
	}
	
	/* add cage Method
	 * create new cage and add it to allCages array list
	 * display new cage details
	 */
	@Override
	public void addCage() {
	
		Cage cage = new Cage();
		cage = cage.NewCage(cage);
		allCages.add(cage);
		System.out.println("Cage successfully added");
		displayCageDetails(cage);
		
	}
	
	/* add animal Method
	 * create new animal object and add it to allAnimals array list
	 * display new animal object details
	 */
	@Override
	public void addAnimal() {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		animal = animal.AddAnimal(animal);
		allAnimals.add(animal);
		System.out.println("Animal successfully added");
		displayAnimalDetails(animal);
		
	}
	
	/* add keeper Method
	 * create new keeper object and add it to allKeepers array list
	 * print new keeper details
	 */
	@Override
	public void addKeeper() {
		Keeper keeper = new Keeper();
		keeper = keeper.AddKeeper(keeper);
		allKeepers.add(keeper);
		System.out.println("Keeper successfully added");
		displayKeeperDetails(keeper);
		
	}
	
	/* Assign animal method
	 * through Id search for animal and cage
	 * and by if statement assign animal into the cage
	 */
	@Override
	public void assignAnimalCage() {
		Animal animal = searchAnimal();
		Cage cage = searchCage();
		if(animal == null) {
			Validate.errorMessage("Animal ID");
			assignAnimalCage();
		} else if(cage == null) {
			Validate.errorMessage("Cage ID");
			assignAnimalCage();
		} else {
			cage.assignAnimal(cage, animal);
		}
		
	}
	
	/* Assign animal method
	 * through Id search for animal and cage
	 * and by if statement assign animal into the cage
	 */
	@Override
	public void assignKeeperCage() {
		Keeper keeper = searchKeeper();
		Cage cage = searchCage();
		if(keeper == null) {
			Validate.errorMessage("Keeper ID");
			assignKeeperCage();
		} else if(cage == null) {
			Validate.errorMessage("Cage ID");
			assignKeeperCage();
		} else {
			cage.assignKeeper(cage, keeper);
		}
		
	}
	
	/*display all cages details method
	 * loop allCages array list
	 * pass cage object to displayCageDetails()
	 */
	@Override
	public void displayAllCages() {
		for(Cage i : allCages) {
			displayCageDetails(i);
		}
		
	}
	
	/*display cage details method
	 * print cage object details
	 */
	@Override
	public void displayCageDetails(Cage cage) {
		// TODO Auto-generated method stub
		System.out.println("Cage ID: " + cage.getCageId());
		System.out.println("Cage Size: " + cage.getCageSize());
		System.out.println("Cage Type: " + cage.getCageType());
		System.out.println("Cage Animal Capacity: " + cage.getMaxAnimals());
		System.out.println("Cage Keeper Capacity: " + cage.getMaxKeepers() + "\n");
		System.out.println("Animals: ");
		for(Animal i : cage.getCagedAnimals()) {
			System.out.println("\t" + i.getAnimalName() + " the " + i.getAnimalClass());
		}
		System.out.println("\nKeepers:");
		for(Keeper i : cage.getCagedKeepers()) {
			System.out.println("\t" + i.getFirstName() + " " + i.getSurName());
		}
		System.out.println("\n");
		
	}
	
	/*display all animal object details method
	 * loop allAnimals array list
	 * pass cage object to displayAnimalDetails()
	 */
	@Override
	public void displayAllAnimals() {
		for(Animal i : allAnimals) {
			displayAnimalDetails(i);
		}
		
	}
	
	/*display animals details method
	 * print animal object details
	 */
	@Override
	public void displayAnimalDetails(Animal animal) {
		// TODO Auto-generated method stub
		System.out.println("Animal ID: " + animal.getAnimalId());
		System.out.println("Animal Name: " + animal.getAnimalName());
		System.out.println("Animal Sex: " + animal.getAnimalSex());
		System.out.println("Animal Date of Birth: " + animal.getAnimalDOB());
		System.out.println("Animal Category: " + animal.getAnimalCategory());
		System.out.println("Animal Type: " + animal.getAnimalType());
		System.out.println("Animal Class: " + animal.getAnimalClass());
		System.out.println("Cage: " + animal.getCageAssignment() + "\n");
		
	}
	
	/*display all animal object details method
	 * loop allKeepers array list
	 * pass keeper object to displayKeeperDetails()
	 */
	@Override
	public void displayAllKeepers() {
		// TODO Auto-generated method stub
		for(Keeper i : allKeepers) {
			displayKeeperDetails(i);
		}
		
	}
	
	/*display keeper details method
	 * print keeper object details
	 */
	@Override
	public void displayKeeperDetails(Keeper keeper) {
		
		System.out.println("Keeper ID: " + keeper.getKeeperId());
		System.out.println("Keeper First Name: " + keeper.getFirstName());
		System.out.println("Keeper Last Name: " + keeper.getSurName());
		System.out.println("Keeper Contact No: " + keeper.getContactNo());
		System.out.println("Keeper Address: " + keeper.getAddress());
		System.out.println("Keeper Position: " + keeper.getKeeperPosition() +"\n");
		
		for(String i  : keeper.getcageAssignment()) {
			System.out.println("Cage Assignment: " + i);
			}
		System.out.println("\n");
		
	
	}
	
	/*
	 * Edit animal details method
	 * Pass Animal object to editAnimalDetails() method in Animal class
	 * Prints new Animal details after editing
	 */
	@Override
	public void editAnimal() {
		Animal animal = searchAnimal();
		if(animal != null) {
			animal.editAnimalDetails(animal);
			displayAnimalDetails(animal);
		} else {
			Validate.errorMessage("Animal ID");
		}
		
	}
	
	/*
	 * Edit keeper details method
	 * Pass keeper object to editKeeperDetails() method in Keeper class
	 * Prints new Animal details after editing
	 */
	@Override
	public void editKeeper() {
		Keeper keeper = searchKeeper();
		if(keeper != null) {
			keeper.editKeeperDetails(keeper);
			displayKeeperDetails(keeper);
		} else {
			Validate.errorMessage("Keeper ID");
		}
		
	}
	
	/* Remove animal method
	 * search for animal and Cage
	 * Passes both objects to the unassignAnimal() method in Cage class
	 */
	@Override
	public void removeAnimal() {
		Animal animal = searchAnimal();
		Cage cage = searchCage();
		if(animal == null) {
			Validate.errorMessage("Animal ID");
			assignAnimalCage();
		} else if(cage == null) {
			Validate.errorMessage("Cage ID");
			assignAnimalCage();
		} else {
			cage.unassignAnimal(cage, animal);
		}
	
		
	}
	
	/* Remove animal method
	 * search for keeper and Cage
	 * Passes both objects to the unassignKeeper() method in Cage class
	 */
	@Override
	public void removeKeeper() {
		Keeper keeper = searchKeeper();
		Cage cage = searchCage();
		if(keeper == null) {
			Validate.errorMessage("Animal ID");
			assignAnimalCage();
		} else if(cage == null) {
			Validate.errorMessage("Cage ID");
			assignAnimalCage();
		} else {
			cage.unassignKeeper(cage, keeper);
		}
	
	}
	
	// Search Id method
	@Override
	public String searchId(String type) {
		System.out.println("Please enter " + type + " ID: ");
		String id = Validate.SC.nextLine();
		return id;
	}
	
	// Save data method
	@Override
	public void saveData() {
		data.writeAnimaDetails(allAnimals);
		data.writeKeeperDetails(allKeepers);
		data.writeCageDetails(allCages);
		
	}
	
	/* Read data method
	 * read data method from FileIO class
	 */
	@Override
	public void readData() {
		data.readAnimalData(allAnimals);
		data.readKeeperData(allKeepers);
		data.readCageData(allCages);
		for(Cage cage : allCages) {
			for(Animal animal : allAnimals) {
				if(animal.getCageAssignment().equals(cage.getCageId())) {
					cage.getCagedAnimals().add(animal);
				}
			}
			for(Keeper keeper : allKeepers) {
				if(keeper.getcageAssignment().contains(cage.getCageId())) {
					cage.getCagedKeepers().add(keeper);
				}
			}
		}
		
		
	}
	
	/*Report method
	 * Pass ArrayLists into the generateReport() method in FileIO class
	 * Inform user that report has been generated after
	 */
	@Override
	public void Report() {
		data.generateReport(allAnimals, allKeepers, allCages);
		System.out.println("Report Generated\n");
		
	}
	
}
