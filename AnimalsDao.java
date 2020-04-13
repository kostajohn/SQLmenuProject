package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Animals;



public class AnimalsDao {
	
	private Connection connection;
	private final String GET_ANIMALS_QUERY = "SELECT * FROM animals";
	private final String GET_ANIMALS_BY_ID_QUERY = "SELECT * FROM animals WHERE id = ?";
	private final String CREATE_NEW_ANIMAL_QUERY = "INSERT INTO animals(type_of_animal, name, food) VALUES(?, ?, ?)";
	private final String DELETE_ANIMAL_BY_ID_QUERY = "DELETE FROM animals WHERE id = ?";
	
	public AnimalsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Animals> getAnimals() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ANIMALS_QUERY).executeQuery();
		List<Animals> animals = new ArrayList<Animals>();
		
		while (rs.next()) {
			animals.add(populateAnimals(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		return animals;
	}
	
	public Animals getAnimalsByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_ANIMALS_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateAnimals(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}
	
	public void createAnimals(String animalType, String animalName, String animalFood) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_ANIMAL_QUERY);
		ps.setString(1, animalType);
		ps.setString(2, animalName);
		ps.setString(3, animalFood);
		ps.executeUpdate();
	}
	
	public void deleteAnimalById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ANIMAL_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	private Animals populateAnimals(int id, String type, String name, String food) {
		return new Animals(id, type, name, food);
	}
	
	
}
