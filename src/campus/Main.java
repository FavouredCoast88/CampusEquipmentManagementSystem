//@author Knobs
package campus;

import java.sql.Connection;
import campus.database.DBConnection;
import java.sql.SQLException;
import campus.gui.CampusEquipmentGUI;
import javax.swing.SwingUtilities;

import campus.dao.EquipmentDAO;
import campus.model.Equipment;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        EquipmentDAO dao = new EquipmentDAO();
        try{
            ArrayList<Equipment> equipmentList = dao.getAllEquipment();
            
            for(Equipment equipment : equipmentList){
                System.out.println(equipment);
            }//end for
        }catch(SQLException e){
            System.out.println("Database error: " + e.getMessage());
        }//end catch
        */
        
        SwingUtilities.invokeLater(()->{
            CampusEquipmentGUI gui = new CampusEquipmentGUI();
            gui.setVisible(true);});
        
        try{
            Connection connection = DBConnection.getConnection();
            System.out.println("Successfully connected to CampusEquipmentDB!");
            connection.close();
        }catch(SQLException e){
            System.out.println("Database Connection failed!" + e.getMessage());
        }//end catch
    }//end main
}//end class
