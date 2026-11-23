//@author Knobs
package campus.files;

import java.io.*;
import java.util.ArrayList;
import campus.model.Equipment;

public class FileManager {
    private static final String EQUIPMENT_FILE = "equipment.txt";
    
    public static void saveEquipments(ArrayList<Equipment> equipments) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(EQUIPMENT_FILE));
        
        for(Equipment equipment : equipments){
            writer.write(equipment.getEquipmentID() + "," + equipment.getEquipmentName()
            + "," + equipment.getCategory() + "," + equipment.getConditionStatus()
            + "," + equipment.getQuantity() + "," + equipment.isAvailable());
            writer.newLine();
        }//end for
        writer.close();
    }//end save Equipments method
    
    public static ArrayList<Equipment> loadEquipments() throws IOException{
        ArrayList<Equipment> equipments = new ArrayList<>();
        File file = new File(EQUIPMENT_FILE);
        
        if(!file.exists()){
            return equipments;
        }//end if
        
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
        
            while((line = reader.readLine())!= null){
                String[] tool = line.split(",");
                if(tool.length == 6){
                    int equipmentID = Integer.parseInt(tool[0]);
                    int quantity = Integer.parseInt(tool[4]);
                    boolean available = Boolean.parseBoolean(tool[5]);
                    equipments.add(new Equipment(equipmentID,tool[1],tool[2],tool[3],quantity,available));
                }//end if
            }//end while
        }//end try
        return equipments;
    }//end loadEquipments method
}//end class
