
public class Main {

	public static void main(String[] args) {
		
		display userInterface = new display();
		
		userInterface.mainMenu();
	
	}
	
	static class display{
		
		userInterfaceFunction obj = new userInterfaceFunction();
		
		/*
		 * Main menu method
		 * Prints the main menu options
		 */
		public void mainMenu() {
			int choice = 0;
			while(true) {
				try {displayMainMenu();
					
					choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						addMenu();
						break;
					case 2:
						assignMenu();
						break;
					case 3:
						viewMenu();
						break;
					case 4:
						editMenu();
						break;
					case 5:
						removeMenu();
						break;
					case 6:
						reportsMenu();
						break;
					case 7:
						obj.saveData();
						System.out.println("Exiting...");
						System.exit(0);
						break;
					default:
						Validate.errorMessage("selection");
						break;
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					mainMenu();
				}
			}
		}
		/*Add Menu
		 * Prints add menu options
		 */
		public void addMenu() {
			int choice = 0;
			while(true) {
				try {
					displayAddMenu();
					choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						obj.addCage();
						break;
					case 2:
						obj.addAnimal();
						break;
					case 3:
						obj.addKeeper();
						break;
					case 4:
						mainMenu();
						break;
					default:
						Validate.errorMessage("selection");
						break;
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					addMenu();
				}
			}
		}
		
		/*Assign Menu
		 * Prints assign menu options
		 */
		public void assignMenu() {
			int choice = 0;
			while(true) {
				try {
					displayAssignMenu();
					choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						obj.assignAnimalCage();
						break;
					case 2:
						obj.assignKeeperCage();
						break;
					case 3:
						mainMenu();
						break;
					default:
						Validate.errorMessage("selection");
						break;
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					assignMenu();
				}
			}
		}
		
		/*View Menu
		 * Prints view menu options
		 */
		public void viewMenu() {
			int choice = 0;
			while(true) {
				try {
					displayViewMenu();
					choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						obj.displayAllCages();
						break;
					case 2:
						obj.displayAllAnimals();
						break;
					case 3:
						obj.displayAllKeepers();
						break;
					case 4:
						mainMenu();
						break;
					default:
						Validate.errorMessage("selection");
						break;
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					viewMenu();
				}
			}
		}
		
		/*Edit Menu
		 * Prints edit menu options
		 */
		public void editMenu() {
			int choice = 0;
			while(true) {
				try {
					displayEditMenu();
					choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						obj.editAnimal();
						break;
					case 2:
						obj.editKeeper();
						break;
					case 3:
						mainMenu();
						break;
					default:
						Validate.errorMessage("selection");
						break;
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					editMenu();
				}
			}
		}
		
		/*Remove Menu method
		 * Prints remove menu options
		 */
		public void removeMenu() {
			int choice = 0;
			while(true) {
				try {
					displayRemoveMenu();
					choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						obj.removeAnimal();
						break;
					case 2:
						obj.removeKeeper();
						break;
					case 3:
						mainMenu();
						break;
					default:
						Validate.errorMessage("selection");
						break;
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					removeMenu();
				}
			}
		}
		
		/*Report Menu method
		 * Prints report menu options
		 */
		public void reportsMenu() {
			int choice = 0;
			while(true) {
				try {
					displayReportsMenu();
					choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						obj.Report();
						break;
					case 2:
						mainMenu();
						break;
					default:
						Validate.errorMessage("selection");
						break;
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					reportsMenu();
				}
			}
		}

		
		/*
		 * Method for printing Main Menu
		 */
		public void displayMainMenu() {
			System.out.println(" --------------------------------------");
			System.out.println(" CLYDE CONSERVATION COMPUTER SYSTEM ");
			System.out.println(" -------------------------------------- \n");
			System.out.println("\n             * MAIN MENU * \n");
			System.out.println("	1.  Add");
			System.out.println("	2.  Assign");
			System.out.println("	3.  View");
			System.out.println("	4.  Edit");
			System.out.println("	5.  Remove");
			System.out.println("	6.  Report");
			System.out.println("	7.  Exit \n");
			System.out.println("\n --------------------------------------");
			System.out.println("	\nPlease choose an option:");
			System.out.flush();
		}
		
		/*
		 * Method for printing Add Menu
		 */
		public void displayAddMenu() {
			System.out.println("\n============ ADD MENU ============\n");
			System.out.println("	1.  Add new Cage");
			System.out.println("	2.  Add new Animal");
			System.out.println("	3.  Add new Keeper");
			System.out.println("	4.  Return to Main Menu");
			System.out.println("	\n\nPlease choose an option:");
			System.out.flush();
		}
		
		/*
		 * Method for printing Assign Menu
		 */
		public void displayAssignMenu() {
			System.out.println("\n=========== ASSIGN MENU ===========\n");
			System.out.println("	1.  Assign Animal to Cage");
			System.out.println("	2.  Assign Keeper to Cage");
			System.out.println("	3.  Return to Main Menu");
			System.out.println("	\n\nPlease choose an option:");
			System.out.flush();
		}
		
		/*
		 * Method for printing View Menu
		 */
		public void displayViewMenu() {
			System.out.println("\n=========== VIEW MENU ===========\n");
			System.out.println("	1.  View Cage Details");
			System.out.println("	2.  View Animal Details");
			System.out.println("	3.  View Keeper Details");
			System.out.println("	4.  Return to Main Menu");
			System.out.println("	\n\nPlease choose an option:");
			System.out.flush();
		}
		
		/*
		 * Method for printing Edit Menu
		 */
		public void displayEditMenu() {
			System.out.println("\n=========== EDIT MENU ===========\n");
			System.out.println("	1.  Edit Animal Details");
			System.out.println("	2.  Edit Keeper Details");
			System.out.println("	3.  Return to Main Menu");
			System.out.println("	\n\nPlease choose an option:");
			System.out.flush();
		}
		
		/*
		 * Method for printing Remove Menu
		 */
		public void displayRemoveMenu() {
			System.out.println("\n=========== REMOVE MENU ===========\n");
			System.out.println("	1.  Remove Animal from Cage");
			System.out.println("	2.  Remove Keeper from Cage");
			System.out.println("	3.  Return to Main Menu");
			System.out.println("	\n\nPlease choose an option:");
			System.out.flush();
		}
		
		/*
		 * Method for printing Reports Menu
		 */
		public void displayReportsMenu() {
			System.out.println("\n============ REPORT ============\n");
			System.out.println("	1.  Generate Report");
			System.out.println("	2.  Return to Main Menu");
			System.out.println("	\n\nPlease choose an option:");
		}
		
	}
	
}
