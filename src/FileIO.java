import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	// Variables - declared all attribute and files
	private Scanner sc;
	private File animalFile;
	private File keeperFile;
	private File cageFile;
	private File ReportFile;
	private FileReader in;
	private FileWriter write;
	private PrintWriter out;
	
	// Initialise the files
	public FileIO() {
		this.animalFile = new File("data/animalData.txt");
		this.keeperFile = new File("data/keeperData.txt");
		this.cageFile = new File("data/cageData.txt");
		this.ReportFile = new File("data/Report.txt");
	}
	
	// Write all Animal attributes to Animal File
	public void writeAnimaDetails(ArrayList<Animal> animalList) {
		try {
			write = new FileWriter(animalFile);
			out = new PrintWriter(write);
			
			for(Animal i : animalList) {
				if(animalList != null) {
					out.write(i.getAnimalId() + "\n");
					out.write(i.getAnimalName() + "\n");
					out.write(i.getAnimalSex() + "\n");
					out.write(i.getAnimalType() + "\n");
					out.write(i.getAnimalCategory() + "\n");
					out.write(i.getAnimalDOB() + "\n");
//					out.write(i.getAnimalDateOfAcquisition() + "\n");
					out.write(i.getAnimalClass() + "\n");
					out.write(i.getCageAssignment() + "\n");
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
	}
	
	// Write all Keeper attributes to Keeper File
	public void writeKeeperDetails(ArrayList<Keeper> keeperList) {
		try {
			write = new FileWriter(keeperFile);
			out = new PrintWriter(write);
			
			for(Keeper i : keeperList) {
				if(keeperList != null) {
					out.write(i.getKeeperId() + "\n");
					out.write(i.getFirstName() + "\n");
					out.write(i.getSurName() + "\n");
					out.write(i.getAddress() + "\n");
					out.write(i.getContactNo() + "\n");
					out.write(i.getKeeperPosition() + "\n");
					for(String j : i.getcageAssignment()) {
						out.write(j + "\n");
					}
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
	}
	
	// Write all Cage attributes to Cage File
	public void writeCageDetails(ArrayList<Cage> cageList) {
		try {
			write = new FileWriter(cageFile);
			out = new PrintWriter(write);
			
			for(Cage i : cageList) {
				if(cageList != null) {
					out.write(i.getCageId() + "\n");
					out.write(i.getCageSize() + "\n");
					out.write(i.getCageType() + "\n");
					out.write(i.getMaxAnimals() + "\n");
					out.write(i.getMaxKeepers() + "\n");
					
					
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
	}
	
	// Generate report base on arraylist
	public void generateReport(ArrayList<Animal> animalList, ArrayList<Keeper> keeperList, ArrayList<Cage> cageList) {
		try {
			write = new FileWriter(ReportFile);
			out = new PrintWriter(write);
			Object day = LocalDateTime.now().getDayOfWeek();
			Object date = LocalDateTime.now().getDayOfMonth();
			Object month = LocalDateTime.now().getMonth();
			Object year = LocalDateTime.now().getYear();
			Object week = ((LocalDateTime.now().getDayOfYear()) / 7) + 1;
			
			out.write("CLYDE CONSERVATION\n");
			out.write("WEEKLY REPORT\n");
			out.write(day + " " + date + " " + month + " " + year + " (WEEK " + week + ")\n\n");
			for(Cage i : cageList) {
				out.write("CAGE\n");
				out.write("\tCage ID: " + i.getCageId() + "\n");
				out.write("\tCage Size: " + i.getCageSize() + "\n");
				out.write("\tCage Type: " + i.getCageType() + "\n");
				out.write("\tCage Animal Capacity: " + i.getMaxAnimals() + "\n");
				out.write("\tCage Keeper Capacity: " + i.getMaxKeepers() + "\n\n");
				out.write("\tANIMALS\n");
				for(Animal a : i.getCagedAnimals()) {
					out.write("\t\tAnimal ID: " + a.getAnimalId() + "\n");
					out.write("\t\tAnimal Name: " + a.getAnimalName() + "\n");
					out.write("\t\tAnimal Sex: " + a.getAnimalSex() + "\n");
					out.write("\t\tAnimal Type: " + a.getAnimalType() + "\n");
					out.write("\t\tAnimal Category: " + a.getAnimalCategory() + "\n\n");
					out.write("\t\tAnimal DOB: " + a.getAnimalDOB() + "\n\n");
//					out.write("\t\tAnimal Date of Acquisition: " + a.getAnimalDateOfAcquisition() + "\n\n");
					out.write("\t\tAnimal Class: " + a.getAnimalClass() + "\n\n");
				}
				out.write("\tKEEPERS\n");
				for(Keeper k : i.getCagedKeepers()) {
					out.write("\t\tKeeper ID: " + k.getKeeperId() + "\n");
					out.write("\t\tKeeper First Name: " + k.getFirstName() + "\n");
					out.write("\t\tKeeper Last Name: " + k.getSurName() + "\n\n");
					out.write("\t\tKeeper Contact No: " + k.getContactNo() + "\n\n");
					out.write("\t\tKeeper Position: " + k.getKeeperPosition() + "\n\n");
					out.write("\t\tKeeper Address: " + k.getAddress() + "\n\n");
				}
			}

			out.write("\nANIMALS NOT ASSIGNED TO A CAGE\n\n");
			for(Animal j : animalList) {
				if(j.getCageAssignment().equals("None")) {
					out.write("\tAnimal ID: " + j.getAnimalId() + "\n");
					out.write("\tAnimal Name: " + j.getAnimalName() + "\n");
					out.write("\tAnimal Sex: " + j.getAnimalSex() + "\n");
					out.write("\tAnimal Type: " + j.getAnimalType() + "\n");
					out.write("\tAnimal Class: " + j.getAnimalClass() + "\n\n");
				}
			}
			out.write("KEEPERS NOT ASSIGNED TO MAX CAGES\n\n");
			for(Keeper x : keeperList) {
				if(x.getcageAssignment().contains("None")) {
					out.write("\tKeeper ID: " + x.getKeeperId() + "\n");
					out.write("\tKeeper First Name: " + x.getFirstName() + "\n");
					out.write("\tKeeper Last Name: " + x.getSurName() + "\n\n");
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid file");
			e.printStackTrace();
		}		
	}
	
	// Read animal data- Initialise scanner with fileReader,read through Animal File and Scan each line
	public void readAnimalData(ArrayList<Animal> animalList) {
		try {
			in = new FileReader(animalFile);
			sc = new Scanner(in);
			while(sc.hasNextLine()) {
				Animal animal = new Animal();
				animal.setAnimalId(sc.nextLine());
				animal.setAnimalName(sc.nextLine());
				animal.setAnimalSex(sc.nextLine());
				animal.setAnimalType(sc.nextLine());
				animal.setAnimalCategory(sc.nextLine());
				animal.setAnimalDOB(sc.nextLine());
//				animal.setAnimalDateOfAcquisition(sc.nextLine());
				animal.setAnimalClass(sc.nextLine());
				animal.setCageAssignment(sc.nextLine());			
				animalList.add(animal);
			}
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
		
	}
	
	//Read keeper data - Initialise scanner with FileReader, read through Keeper File and Scan each line
	public void readKeeperData(ArrayList<Keeper> keeperList) {
		try {
			in = new FileReader(keeperFile);
			sc = new Scanner(in);
			
				
			while(sc.hasNextLine()) {
				Keeper keeper = new Keeper();
				keeper.setKeeperId(sc.nextLine());
				keeper.setFirstName(sc.nextLine());
				keeper.setSurName(sc.nextLine());
				keeper.setAddress(sc.nextLine());
				keeper.setContactNo(sc.nextLine());
				keeper.setKeeperPosition(sc.nextLine());
				keeper.getcageAssignment().add(sc.nextLine());
				keeper.getcageAssignment().add(sc.nextLine());
				keeper.getcageAssignment().add(sc.nextLine());
				keeper.getcageAssignment().add(sc.nextLine());
				keeperList.add(keeper);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Read cage data - Initialise scanner with FileReader, read through cage File and Scan each line
	public void readCageData(ArrayList<Cage> cageList) {
		try {
			in = new FileReader(cageFile);
			sc = new Scanner(in);
			
			while(sc.hasNextLine()) {
				Cage cage = new Cage();
				cage.setCageId(sc.nextLine());
				cage.setCageSize(sc.nextLine());
				cage.setCageType(sc.nextLine());
				cage.setMaxAnimals(Integer.parseInt(sc.nextLine()));
				cage.setMaxKeepers(Integer.parseInt(sc.nextLine()));
				cageList.add(cage);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
