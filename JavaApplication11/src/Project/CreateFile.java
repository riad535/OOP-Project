
package Project;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class CreateFile {
    
    private static Formatter output;
    private static FileWriter fileWriter;
    private static PrintWriter printWriter;
    
    public static void openFile() throws IOException
    {
        try
        {
            fileWriter = new FileWriter("clients.txt",true);
            printWriter = new PrintWriter(fileWriter);
        }
        
        catch(SecurityException dSecurityException)
        {
            System.out.println("Permission ok");
            System.exit(1);
                    
        }
        
        catch(FileNotFoundException fileNotFoundException)
        {
            System.out.println("File Not Found");
            System.exit(1);
        }
       
    }
    
    public static void addRecords(int id,String name,int mobile,String course,String gender)
    {
        try
        {
            printWriter.println(id+" / "+name+" / "+mobile+" / "+course+" / "+gender);
        }
        
        catch(FormatterClosedException formatterClosedException)
        {
            System.out.println("Error writing to the file.Terminating");
                    
        }
        
        catch(NoSuchElementException noSuchElementException)
        {
            System.out.println("Invalid input.Please Try again");
        }           
    }
    
    public static void closeFile() throws IOException
    {
        if(output != null)
        {
            output.close();
        }
        
        fileWriter.close();
        printWriter.close();
    }  
    
}/*String firstLine = br.readLine().trim();
        String[] columnsName = firstLine.split(",");
        DefaultTableModel model =(DefaultTableModel)jTable1.getModel(); 
        model.setColumnIdentifiers(columnsName);*/
        
