//@author Knobs
package campus.files;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorLogger {
    private static final String LOG_FILE = "application.log";
    public void log(String action){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);
            
            writer.write(timestamp + " | " + action);
            writer.newLine();
        }catch(IOException e){
            e.printStackTrace();
        }//end catch
    }//end log method
}//end class
