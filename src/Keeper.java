import java.util.ArrayList;
public class Keeper {
	
	// Variables - all attributes declared
	private String keeperId;
	private String firstName;
	private String surName;
	private String address;
	private String contactNo;
	private String keeperPosition;
	private ArrayList<String> cageAssignment;
	
	
	// Constructor - initialised array list
	public Keeper() {
		cageAssignment = new ArrayList<String>();
	}

	/*
	 * Add new Keeper method
	 * Prompts user to enter Keeper details
	 * Assigns these inputs to Keeper attributes with setter
	 */
	public Keeper AddKeeper(Keeper keeper) {
		System.out.println("Please enter keeper first name: ");
		keeper.setFirstName(Validate.validateString());
		System.out.println("Please enter keeper last name: ");
		keeper.setSurName(Validate.validateString());
		System.out.println("Please enter keeper Address: ");
		keeper.setAddress(Validate.validateString());
		System.out.println("Please enter keeper Contact Number: ");
		keeper.setContactNo(Validate.validateString());
		System.out.println("Please enter keeper Position: ");
		keeper.setKeeperPosition(Validate.validateString());
		keeper.setKeeperId(Validate.UniqueId("KP"));
		
		for(int i = 0; i < 4; i++) {
			keeper.cageAssignment.add("None");
		}
		return keeper;
	}

	/*
	 * Edit Keeper Details method
	 * Prints edit menu
	 * Takes user input for each case and sets new Keeper
	 * details.
	 */
	public void editKeeperDetails(Keeper keeper) {
		boolean run = true;
		while(run) {
			try {
				if(keeper != null) {
					System.out.println("\nPlease choose an option: \n");
					System.out.println("1. Edit Keeper First Name");
					System.out.println("2. Edit Keeper Last Name");
					System.out.println("3. Edit Keeper Address");
					System.out.println("4. Edit Keeper Contact Number");
					System.out.println("5. Edit Keeper Position");
					System.out.println("6. Exit");
					int choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						System.out.println("Enter new first name: ");
						String newFirstName = Validate.validateString();
						keeper.setFirstName(newFirstName);
						break;
					case 2:
						System.out.println("Enter new last name: ");
						String newLastName = Validate.validateString();
						keeper.setSurName(newLastName);
						break;
					case 3:
						System.out.println("Enter new address: ");
						String newAddress = Validate.validateString();
						keeper.setAddress(newAddress);
						break;
					case 4:
						System.out.println("Enter new contact number: ");
						String newContactNo = Validate.validateString();
						keeper.setContactNo(newContactNo);
						break;
					case 5:
						System.out.println("Enter new position: ");
						String newPosition = Validate.validateString();
						keeper.setKeeperPosition(newPosition);
						break;
					case 6:
						System.out.println("Keeper Details udated\n");
						run = false;
						break;
					default:
						Validate.errorMessage("selection");
						editKeeperDetails(keeper);
					}
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				editKeeperDetails(keeper);
			}
		}
	}
	
	
	// Getter and Setter
	public String getKeeperId() {
		return keeperId;
	}


	public void setKeeperId(String keeperId) {
		this.keeperId = keeperId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSurName() {
		return surName;
	}


	public void setSurName(String surName) {
		this.surName = surName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactno) {
		this.contactNo = contactno;
	}


	public String getKeeperPosition() {
		return keeperPosition;
	}


	public void setKeeperPosition(String keeperPosition) {
		this.keeperPosition = keeperPosition;
	}


	public ArrayList<String> getcageAssignment() {
		return cageAssignment;
	}


	public void setcageAssignment(ArrayList<String> cageAssignment) {
		this.cageAssignment = cageAssignment;
	}


	
}
