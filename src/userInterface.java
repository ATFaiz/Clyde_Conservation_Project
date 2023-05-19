
public interface userInterface {
	
	public Cage searchCage();
	public Animal searchAnimal();
	public Keeper searchKeeper();
	public void addCage();
	public void addAnimal();
	public void addKeeper();
	public void assignAnimalCage();
	public void assignKeeperCage();
	public void displayAllCages();
	public void displayCageDetails(Cage cage);
	public void displayAllAnimals();
	public void displayAnimalDetails(Animal animal);
	public void displayAllKeepers();
	public void displayKeeperDetails(Keeper keeper);
	public void editAnimal();
	public void editKeeper();
	public void removeAnimal();
	public void removeKeeper();
	public String searchId(String type);
	public void saveData();
	public void readData();
	public void Report();

}
