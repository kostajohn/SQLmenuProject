package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.AnimalsDao;
import entity.Animals;

public class Menu {
	
	private AnimalsDao animalsDao = new AnimalsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Animals",
			"Create Animals", 
			"Delete Animals",
			"Show a Specific Animal");
	
	public void start() { 
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
			if (selection.equals("1")) {
				displayAnimals();
			} else if (selection.equals("2")) {
				createAnimals();
			} else if (selection.equals("3")) {
				deleteAnimals();
			} else if (selection.equals("4")) {
				showSpecificAnimal();
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
					
			System.out.println("Press Enter to Continue....");
			scanner.nextLine();	
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n--------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayAnimals() throws SQLException {
		List<Animals> animals = animalsDao.getAnimals();
		for (Animals animal : animals) {
			System.out.println("id: " + animal.getAnimalId() + " " + "Name: " + animal.getName() + " " + "Species: " + animal.getType() + " " + "Favorite Food: " + animal.getFood());
		}
	}
	private void showSpecificAnimal() throws SQLException {
		System.out.println("Enter Animal id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Animals animals = animalsDao.getAnimalsByID(id);
		System.out.println(animals.getAnimalId() + ": " + animals.getName());
		
	}
	
	private void createAnimals() throws SQLException {
		System.out.print("Enter new Animal type, name, and food:");
		String animaltype = scanner.nextLine();
		String animalName = scanner.nextLine();
		String animalFood = scanner.nextLine();
		animalsDao.createAnimals(animaltype, animalName, animalFood);
	}
	
	private void deleteAnimals() throws SQLException {
		System.out.println("Enter Animal ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		animalsDao.deleteAnimalById(id);
	}
}
