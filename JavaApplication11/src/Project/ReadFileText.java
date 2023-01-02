
package Project;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFileText {
    private static Scanner input;

    public static void openFile() 
    {
        try 
        {
            input= new Scanner(Paths.get("clients.txt"));
        } 
        catch(IOException iosException) 
        {
            System.out.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static String readRecords() {
        String headText= String.format("%-15s%-15s%-15s%-15s%-15s%n", "Id", "Student Name", "Mobile No", "Course","Gender");


        while(input.hasNext()) {
            try 
            {
                headText+= String.format("%n%-20d%-20s%-15d%-15s%-15s%n", input.nextInt(),input.next(), input.nextInt(), input.next(),input.next());
            }
            
            catch (NoSuchElementException elementException)
            {
                System.err.println("File improperly formed. Terminating.");
            }
            
            catch (IllegalStateException stateException)
            {
                System.err.println("Error reading from file. Terminating.");
            }
        }

        return headText;
    }


    public static void CloseFile() 
    {
        if(input!=null)
        {
            input.close();
        }
    }
}