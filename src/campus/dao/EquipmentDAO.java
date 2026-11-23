//@author Knobs
package campus.dao;

import campus.database.DBConnection;
import campus.model.Equipment;
import java.sql.*;
import java.util.ArrayList;

public class EquipmentDAO {
    public ArrayList<Equipment> getAllEquipment() throws SQLException{
        ArrayList<Equipment> equipmentList = new ArrayList<>();
        String sql = "SELECT * FROM Equipment";
        
        try(Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()){
                Equipment equipment = new Equipment();
                
                equipment.setEquipmentID(resultSet.getInt("EquipmentID"));
                equipment.setEquipmentName(resultSet.getString("EquipmentName"));
                equipment.setCategory(resultSet.getString("Category"));
                equipment.setConditionStatus(resultSet.getString("ConditionStatus"));
                equipment.setQuantity(resultSet.getInt("Quantity"));
                equipment.setAvailable(resultSet.getBoolean("Available"));
                
                equipmentList.add(equipment);
            }//end while            
        }//end try
        return equipmentList;
    }//end getAllEquipment method
    
    public void addEquipment(Equipment equipment) throws SQLException{
        String sql = "INSERT INTO Equipment "
                + "(EquipmentName, Category, ConditionStatus, Quantity, Available) "
                + "VALUES (?, ?, ?, ?, ?)";
        try(Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, equipment.getEquipmentName());
            statement.setString(2, equipment.getCategory());
            statement.setString(3, equipment.getConditionStatus());
            statement.setInt(4, equipment.getQuantity());
            statement.setBoolean(5, equipment.isAvailable());
            statement.executeUpdate();
        }//end try
    }//end addEquipment method
    
    public void updateEquipment(Equipment equipment) throws SQLException{
        String sql = "UPDATE Equipment SET "
                + "EquipmentName = ?, "
                + "Category = ?, "
                + "ConditionStatus = ?, "
                + "Quantity = ?, "
                + "Available = ? "
                + "WHERE EquipmentID = ?";
        try(Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, equipment.getEquipmentName());
            statement.setString(2, equipment.getCategory());
            statement.setString(3, equipment.getConditionStatus());
            statement.setInt(4, equipment.getQuantity());
            statement.setBoolean(5, equipment.isAvailable());
            statement.setInt(6, equipment.getEquipmentID());
            statement.executeQuery();
        }//end try
    }//end updateEquipment method
    
    public void deleteEquipment(int equipmentID) throws SQLException{
        String sql = "DELETE FROM Equipment WHERE EquipmentID = ?";
        try(Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, equipmentID);
            statement.executeUpdate();
        }//end try
    }//end deleteEquipment method
}//end class
