package PracticeProject3;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.*; 
public class FileHandling
{ 
	public static String str1="";
  public static void FileRead() {
    
    try{
    	System.out.println("The contents of the file are:");
    	//Create the path for the file
        File F=new File("G://textfile1.txt");
        //If the file exist the read the contents
        if(! F.exists())
        F.createNewFile();
        //file reader and buffer reader to read file text 
        FileReader f1=new FileReader(F);
        BufferedReader bf=new BufferedReader(f1);
        //For reading till end word
        while((str1=bf.readLine())!=null){
            System.out.println(str1);
        }
        f1.close();
        }catch(Exception e){
        System.out.println("Error : " );
        e.printStackTrace();
    }
  }
  public static void writeFile(String s)
  {
    Scanner in=null;
    try
    {
        String source = "";
        File f=new File("G://textfile1.txt");
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        //It will take new content everytime it is runned
        FileWriter f0 =null;
        if(s.equalsIgnoreCase("w"))
        {
            f0 = new FileWriter(f,false);
            System.out.println("Write will overwrite the contents of the file ");
            System.out.println("Select:\nYes to continue\nNo to exit");
            //It takes the text that is to be written
            in=new Scanner(System.in);
            String s1=in.nextLine();
            //Check wheather to perform the operation or not
            if(s1.equalsIgnoreCase("no"))
            System.exit(0);
            else if(s1.equalsIgnoreCase("yes")) {System.out.println("Type exit when you finish writing");
            f.delete();
            f.createNewFile();
            while(!(source=bf.readLine()).equalsIgnoreCase("exit")){
                f0.write(source + System.getProperty("line.separator"));
            } 
            }
            else {
            	System.out.println("Unrecognized statement");
            	System.exit(0);
            }in.close();
        }
        //Condition for appending text content
        else
        {  f0 = new FileWriter(f,true);
            System.out.println("Type exit when you finish writing");
            while(!(source=bf.readLine()).equalsIgnoreCase("exit")){
                f0.append(source+ System.getProperty("line.separator"));
            }
        }
        f0.close();
        
    }
    catch(Exception e){
        System.out.println("Error : " );
        e.printStackTrace();
    }
    
    
  }
  public static void deleteFile() {
	try {
		System.out.println("It deletes the content");
		Path path= Paths.get("G:\\textfile1.txt");
		if(Files.deleteIfExists(path))
			System.out.println("File  deleted");
		else
			System.out.println("File not deleted. Please check if file exist or not");
	} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty");
	}
	catch (IOException e) {
			System.out.println("Invalid Permission");
	}
  } 
    public static void main(String args[]) throws FileNotFoundException, IOException {

    	System.out.println("You are performing file operations");
        System.out.println("Select the operation:\nr for read\nw for write\na for append\nd for delete");
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the operation:");
        String s=in.nextLine();
        if(s.equalsIgnoreCase("r"))
        {
            FileRead();
        }
        else if(s.equalsIgnoreCase("w")||s.equalsIgnoreCase("a"))
        {
            writeFile(s);      
        }
        else if(s.equalsIgnoreCase("d"))
        {
            deleteFile();
        }
        else {
        	System.out.println("Please enter above operations");
        }
        in.close();
        
    }
  
   
    
}

