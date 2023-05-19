import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class Cage {
	
	// Variables - all attributes declared
	private String cageId;
	private String cageSize;
	private String cageType;
	private int maxAnimals;
	private int maxKeepers;
	private LinkedList<Animal> cagedAnimals;
	private LinkedList<Keeper> cagedKeepers;
	private ArrayList<Keeper> allKeepers;
	private ArrayList<Cage> allCages;
	private FileIO data;

	// Constructor - initialise linkedlist, arraylist and FileIO
	public Cage() {
		cagedAnimals = new LinkedList<Animal>();
		cagedKeepers = new LinkedList<Keeper>();
		data = new FileIO();
		allKeepers = new ArrayList<Keeper>();
		allCages = new ArrayList<Cage>(); 

	}
	
	/*
	 * New Cage method
	 * Takes a blank cage as parameter
	 * User to enter cage details
	 * Inputs assign to Keeper attributes with
	 * setters
	 * Switch used to set cage size, maxAnimal, and maxKeeper, based
	 * on choice, and cageId is automatically generated
	 * Cage Type set to "None" as default
	 */
	public Cage NewCage(Cage cage) {
		String size = "";
		int maxAnimal = 0;
		int maxKeeper = 4;
		boolean correct = true;
		
		while(correct) {
				try {
				System.out.println("Please enter cage size: ");
				cageSizeMenu();
				int choice = (int)Validate.validateInteger();
				switch(choice) {
				case 1:
					size = "Small";
					maxAnimal = 1;
					maxKeeper = 1;
					break;
				case 2:
					size = "Medium";
					maxAnimal = 5;
					maxKeeper = 2;
					break;
				case 3:
					size = "Large";
					maxAnimal = 10;
					maxKeeper = 4;
					break;
					default:
					Validate.errorMessage("selection");
					NewCage(cage);
				}
			} catch (InputMismatchException e) {
				Validate.errorMessage("input");
				NewCage(cage);
			}
			if(correct) {
				break;
			}
			
		}
		
		cage.setCageId(Validate.UniqueId("CG"));
		cage.setCageSize(size);
		cage.setCageType("None");
		cage.setMaxAnimals(maxAnimal);
		cage.setMaxKeepers(maxKeeper);
		return cage;
	}
	
	/*
	 * cage Size Menu method
	 * Prints the different Cage sizes available
	 */
	public void cageSizeMenu() {
		System.out.println("\t1. Small Cage (1 Animal, 1 Keeper)");
		System.out.println("\t2. Medium Cage (5 Animals, 2 Keeper)");
		System.out.println("\t3. Large Cage (10 Animals, 4 Keeper)");
		System.out.println("\t4. Return to main menue)");
	}
	
	/*
	 * Assign Animal method
	 * Takes a cage and animal object as parameters
	 * Check if cage is full
	 * Check if animal already exists in cage
	 * Check animal has valid category for cage
	 * Adds Animal to Cage, sets Cage type (if "None"),
	 * sets Animal CageAssignment
	 * Prints confirmation to user
	 */
	public void assignAnimal(Cage cage, Animal animal) {
		if(cage.cagedAnimals.size() >= cage.getMaxAnimals()) {
			System.err.println("This cage is full");
		} else if(cage.cagedAnimals.contains(animal)){
			System.err.println("This animal is already in this cage");
			}
		else {
			if((animal.getAnimalCategory().equals("predator")) && (cage.getCageSize().equals("Small"))) {
				cage.cagedAnimals.add(animal);
				animal.setCageAssignment(cage.getCageId());
				cage.setCageType(animal.getAnimalType());
				System.out.println(animal.getAnimalName() + " the " + animal.getAnimalClass() + " was successfully added to cage " + cage.getCageId());
			
			}else if((animal.getAnimalCategory().equals("prey")) && (!cage.getCageSize().equals("Small"))) {
				cage.cagedAnimals.add(animal);
				cage.setCageType(animal.getAnimalClass());
				animal.setCageAssignment(cage.getCageId());
				System.out.println(animal.getAnimalName() + " the " + animal.getAnimalClass() + " was successfully added to cage " + cage.getCageId());
			
			}else {
				System.out.println("The" + animal.getAnimalName() + " can't add to this cage.");
			}
			
		}
	}

	/*
	 * Assign keeper method
	 * Takes a Cage and Keeper object as parameters
	 * Checks if Cage is assigned max Keepers or keeper is already exist.
	 * Checks if Keeper is assigned max (4) cages
	 * Adds Keeper to Cage, sets Keeper cageAssignment to
	 * Cage ID (for next "None" in cageAssignment ArrayList)
	 * Prints confirmation to user
	 */
	public void assignKeeper(Cage cage, Keeper keeper) {
		if(cage.getCagedKeepers().size() >= cage.getMaxKeepers()) {
			System.err.println("This cage can't be assigned any more keepers");
		} else if(cage.getCagedKeepers().contains(keeper)) {
			System.err.println("This keeper is already assigned to this cage");
		} else if(!keeper.getcageAssignment().contains("None")) {
			System.err.println("This keeper can't be assigned any more cages");
		} else {
			cage.getCagedKeepers().add(keeper);
			var i = 0;
			for(String cageId : keeper.getcageAssignment()) {
				i++;
				if(cageId.equals("None")) {
					cageId = cage.getCageId();
					var CageAssignment = keeper.getcageAssignment();
					CageAssignment.set(i -1, cageId);
					keeper.setcageAssignment(CageAssignment);
					allKeepers.add(keeper);
					data.writeKeeperDetails(allKeepers);
					System.out.println(keeper.getFirstName() + " " + keeper.getSurName() + " was successfully assigned to cage " + cage.getCageId());
					return;
				}
			}
	
		}
	}
	
	/*
	 * Unassign animal method
	 * Cage and Animal object are parameters
	 * Checks Cage and Animal are not null
	 * Loops through Cage's cagedAnimals LinkedList
	 * If input animalId matches an animalId in the list, remove animal from list
	  * Set the Animal cageAssignment to "None"
	 * Prints confirmation to user
	 */
	public void unassignAnimal(Cage cage, Animal animal) {
		if(cage != null && animal != null) {
			for(Animal i : cage.getCagedAnimals()) {
				if(i.getAnimalId().equals(animal.getAnimalId())) {
					cage.getCagedAnimals().remove(i);
					animal.setCageAssignment("None");
					System.out.println(animal.getAnimalName() + " the " + animal.getAnimalClass() + " successfully removed from " + cage.getCageId());
					if(cage.getCagedAnimals().isEmpty()) {
						cage.setCageType("None");
					}
				}
			}
		} else {
			System.err.println("Unable to unassign animal");
		}
	}
	
	/*
	 * Unassign keeper method
	 * Cage and Keeper object are parameters
	 * Checks Cage and Keeper are not null
	 * Loops cagedKeepers LinkedList
	 * If input keeperId matches a keeperId in the list, remove the keeper form list
	 * Set the Keeper cageAssignment (where = Cage ID) to "None"
	 * Prints confirmation to user
	 */
	public void unassignKeeper(Cage cage, Keeper keeper) {
		if(cage != null && keeper != null) {
			for(Keeper i : cage.getCagedKeepers()) {
				if(i.getKeeperId().equals(keeper.getKeeperId())) {
					cage.getCagedKeepers().remove(i);
					System.out.println(keeper.getFirstName() + " " + keeper.getSurName() + " successfully removed from " + cage.getCageId());
			
							var k = 0; 
							for(String cageId : keeper.getcageAssignment()) {
								k++;
							     	if(cageId.equals(cage.getCageId())) {
									var newCageId = "None"; 
								    var CageAssignment = keeper.getcageAssignment();
									CageAssignment.set(k -1, newCageId);
									keeper.setcageAssignment(CageAssignment);
									allKeepers.add(keeper);
									data.writeKeeperDetails(allKeepers);
									return;
								}
							}
				}
			}
		} else {
			System.err.println("Unable to assign keeper");
		}
	}
	
	// Getters and Setters
	public String getCageId() {
		return cageId;
	}
	public void setCageId(String cageId) {
		this.cageId = cageId;
	}
	public String getCageSize() {
		return cageSize;
	}
	public void setCageSize(String cageSize) {
		this.cageSize = cageSize;
	}
	public String getCageType() {
		return cageType;
	}
	public void setCageType(String cageType) {
		this.cageType = cageType;
	}
	public int getMaxAnimals() {
		return maxAnimals;
	}
	public void setMaxAnimals(int maxAnimals) {
		this.maxAnimals = maxAnimals;
	}
	public int getMaxKeepers() {
		return maxKeepers;
	}
	public void setMaxKeepers(int maxKeepers) {
		this.maxKeepers = maxKeepers;
	}
	public LinkedList<Animal> getCagedAnimals() {
		return cagedAnimals;
	}
	public void setCagedAnimals(LinkedList<Animal> cagedAnimals) {
		this.cagedAnimals = cagedAnimals;
	}
	public LinkedList<Keeper> getCagedKeepers() {
		return cagedKeepers;
	}
	public void setCagedKeepers(LinkedList<Keeper> cagedKeepers) {
		this.cagedKeepers = cagedKeepers;
	}

}
