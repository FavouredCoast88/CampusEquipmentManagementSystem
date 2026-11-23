//@author Knobs
package campus.model;

import java.io.Serializable;

public class Equipment implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int equipmentID;
    private String equipmentName;
    private String category;
    private String conditionStatus;
    private int quantity;
    private boolean available;
    
    public Equipment(){
    }//end default constructor
    
    public Equipment(int equipmentID, String equipmentName, String category, String conditionStatus, int quantity, boolean available){
        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
        this.category = category;
        this.conditionStatus = conditionStatus;
        this.quantity = quantity;
        this.available = available;
    }//end constructor
    
    public int getEquipmentID(){
        return equipmentID;
    }//end getEquipmentID method
    public void setEquipmentID(int equipmentID){
        this.equipmentID = equipmentID;
    }//end setEquipmentID method
    
    public String getEquipmentName(){
        return equipmentName;
    }//end getEquipmentName method
    public void setEquipmentName(String equipmentName){
        this.equipmentName = equipmentName;
    }//end setEquipmentName method
    
    public String getCategory(){
        return category;
    }//end getCategory method
    public void setCategory(String category){
        this.category = category;
    }//end setCategory method
    
    public String getConditionStatus(){
        return conditionStatus;
    }//end getConditionStatus method
    public void setConditionStatus(String conditionStatus){
        this.conditionStatus = conditionStatus;
    }//end setConditionStatus method
    
    public int getQuantity(){
        return quantity;
    }//end getQuantity method
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }//end setQuantity method
    
    public boolean isAvailable(){
        return available;
    }//end getAvailable method
    public void setAvailable(boolean available){
        this.available = available;
    }//end setAvailable method
    
    @Override
    public String toString(){
        return "Equipment ID: " + equipmentID
                + ", Equipment Name: " + equipmentName
                + ", Category: " + category
                + ", Condition Status: " + conditionStatus
                + ", Quantity: " + quantity
                + ", Available: " + available;
    }//end toString method
}//end class
