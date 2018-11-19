import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Demo2a
{
  public static void main(String[] args) 
  { 
 String fileName = "file.txt";
try{

    System.out.println("testing Constructor");
    WordSearch testCase = new WordSearch(4, 4, "file.txt");
    System.out.println(testCase.toString()); 
}catch(FileNotFoundException e){
          System.out.println("File not found: " + fileName);
          System.exit(1);
        }
   
  }
}