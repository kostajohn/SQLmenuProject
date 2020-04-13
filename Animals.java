package entity;

public class Animals {
	private int animalId;
	private String type;
	private String name;
	private String food;
	
	public Animals(int animalId, String type, String name, String food) {
		this.setAnimalId(animalId);
		this.setType(type);
		this.setName(name);
		this.setFood(food);
}

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
}