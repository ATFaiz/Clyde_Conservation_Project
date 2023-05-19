
public class Animal {
	
	// Variables - all attributes declared
	private String animalId;
	private String animalName;
	private String animalSex;
	private String animalType;
	private String animalCategory;
	private String animalDOB;
	private String animalDateOfAcquisition;
	private String animalClass;
	private String cageAssignment;

	/*
	 * Add new animal method
	 * Prompts user to enter Animal details
	 * Assigns these inputs to Animal attributes through
	 * setters
	 * animalId is automatically generated
	 */
	public Animal AddAnimal(Animal animal) {
		System.out.println("Please enter animal name: ");
		animal.setAnimalName(Validate.SC.nextLine());
		System.out.println("Please enter animal sex: ");
		animal.setAnimalSex(Validate.SC.nextLine());
		System.out.println("Please enter animal date of birth: ");
		animal.setAnimalDOB(Validate.SC.nextLine());
		System.out.println("Please enter animal category (predator/prey) : ");
		animal.setAnimalCategory(Validate.SC.nextLine());
//		System.out.println("Please enter Animal Date of Acquisition: ");
//		animal.setAnimalDateOfAcquisition(Validate.SC.nextLine());
		System.out.println("Please enter animal class: ");
		animal.setAnimalClass(animalClassSelector());
		System.out.println("Please enter animal type: ");
		animal.setAnimalType(animalTypeSelector(animal.getAnimalClass()));
		animal.setAnimalId(Validate.UniqueId(animal.getAnimalType().substring(0, 2).toUpperCase()));
		animal.setCageAssignment("None");
		return animal;
	}
	
	// Animal family (class) selector method
	public String animalClassSelector() {
		int choice;
		String AnimalClass = "";
		System.out.println("\t1. Mammal");
		System.out.println("\t2. Bird");
		System.out.println("\t3. Reptile");
		choice = Validate.validateInteger();
		try {
			if(choice == 1) {
				AnimalClass = "Mammal";
			} else if(choice == 2) {
				AnimalClass = "Bird";
			} else if(choice == 3) {
				AnimalClass = "Reptile";
			} else {
				Validate.errorMessage("selection");
				animalClassSelector();
			}
		} catch(NumberFormatException e) {
			Validate.errorMessage("input");			
		}
		return AnimalClass;
	}
	
	/*
	 * Animal type selector method
	 * Takes String class as parameter which determines
	 * sets type based on user input
	 */
	public String animalTypeSelector(String family) {
		int choice;
		String type = "";
		if(family.equals("Mammal")) {
			System.out.println("\t1. Ape");
			System.out.println("\t2. Zebra");
			System.out.println("\t3.Marmoset-Monkey");
			System.out.println("\t4. Tiger");
			System.out.println("\t5. Rabbit");
			System.out.println("\t6. Guinea-Pig");
			choice = Validate.validateInteger();
			try {
				switch(choice) {
				case 1:
					type = "Ape";
					break;
				case 2: 
					type = "Zebra";
					break;
				case 3:
					type = "Marmoset-Monkey";
					break;
				case 4:
					type = "Tiger";
					break;
				case 5:
					type = "Rabbit";
					break;
				case 6:
					type = "Guinea-Pig";
					break;
				default:
					Validate.errorMessage("selection");
					choice = Validate.validateInteger();
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
			}
			return type;
			
		} else if (family.equals("Bird")) {
			System.out.println("\t1. Eagle");
			System.out.println("\t2. Vulture");
			System.out.println("\t3. Owls");
			System.out.println("\t4. Emu's");
			System.out.println("\t5. Penguin");
			choice = Validate.validateInteger();
			try {
				switch(choice) {
				case 1:
					type = "Eagle";
					break;
				case 2:
					type = "Vulture";
					break;
				case 3:
					type = "Owls";
					break;
				case 4:
					type = "Emu's";
					break;
				case 5:
					type = "Penguin";
					break;
				default:
					Validate.errorMessage("selection");
					choice = Validate.validateInteger();
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
			}
			return type;
			
		} else {
			System.out.println("\t1. Bearded Dragon");
			System.out.println("\t2. Lizard");
			System.out.println("\t3. Chameleon");
			choice = Validate.validateInteger();
			try {
				switch(choice) {
				case 1:
					type = "Bearded Dragon";
					break;
				case 2:
					type = "Lizard";
					break;
				case 3:
					type = "Chameleon";
					break;
				default:
					Validate.errorMessage("selection");
					choice = Validate.validateInteger();
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
			}
			return type;
		}
	}
	
	/*
	 * Edit animal details method
	 * Takes an Animal object as parameter
	 * Prints edit menu
	 * Takes user input for each case and sets new Animal
	 * details.
	 */
	public void editAnimalDetails(Animal animal) {
		boolean run = true;
		while(run) {
			if(animal != null) {
				System.out.println("\nPlease choose an option: \n");
				System.out.println("1. Edit animal name");
				System.out.println("2. Edit animal sex");
				System.out.println("3. Edit animal type");
				System.out.println("4. Edit animal category");
				System.out.println("5. Edit animal date of birth");
//				System.out.println("6. Edit animal Date of Acquisition");
				System.out.println("6. Edit animal class");
				System.out.println("7. Exit");
				int choice = Validate.validateInteger();
				try {
					switch(choice) {
					case 1:
						System.out.println("Enter new Animal Name: ");
						String newName = Validate.validateString();
						animal.setAnimalName(newName);
						break;
					case 2:
						System.out.println("Enter new Animal Sex: ");
						String newSex = Validate.validateString();
						animal.setAnimalSex(newSex);
					case 3:
						System.out.println("Enter new Animal Type: ");
						String newType = Validate.validateString();
						animal.setAnimalType(newType);
						break;
					case 4:
						System.out.println("Enter new Animal Category: ");
						String newCategory = Validate.validateString();
						animal.setAnimalCategory(newCategory);
						break;
					case 5:
						System.out.println("Enter new Animal Date of Birth: ");
						String newDOB = Validate.validateString();
						animal.setAnimalDOB(newDOB);
						break;
//					case 6:
//						System.out.println("Enter new Animal Date of Acquisition: ");
//						String newDOAcquisition = Validate.validateString();
//						animal.setAnimalDateOfAcquisition(newDOAcquisition);
//						break;
					case 6:
						System.out.println("Enter new Animal Class: ");
						String newClass = Validate.validateString();
						animal.setAnimalClass(newClass);
						break;
						
					case 7:
						System.out.println("Animal Details updated\n");
						run = false;
						break;
						default:
						Validate.errorMessage("selection");
						editAnimalDetails(animal);
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					editAnimalDetails(animal);
				}
			}
		}
	}
	
	// Getters and Setters
	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}
	
	
	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalSex() {
		return animalSex;
	}

	public void setAnimalSex(String animalSex) {
		this.animalSex = animalSex;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalCategory() {
		return animalCategory;
	}

	public void setAnimalCategory(String animalCategory) {
		this.animalCategory = animalCategory;
	}

	public String getAnimalDOB() {
		return animalDOB;
	}

	public void setAnimalDOB(String animalDOB) {
		this.animalDOB = animalDOB;
	}

//	public String getAnimalDateOfAcquisition() {
//		return animalDateOfAcquisition;
//	}
//
//	public void setAnimalDateOfAcquisition(String animalDateOfAcquisition) {
//		this.animalDateOfAcquisition = animalDateOfAcquisition;
//	}

	public String getAnimalClass() {
		return animalClass;
	}

	public void setAnimalClass(String animalClass) {
		this.animalClass = animalClass;
	}

	public String getCageAssignment() {
		return cageAssignment;
	}

	public void setCageAssignment(String cageAssignment) {
		this.cageAssignment = cageAssignment;
	}
	
	
}
