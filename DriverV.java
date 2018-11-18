import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class DriverV {
  private int seed;
  private Random randgen;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;
  private char[][] data;

  public ArrayList getfile(String fileName) throws FileNotFoundException{//is this right???
    File f = new File(fileName);
    Scanner in = new Scanner(f);
    ArrayList<String> cat = new ArrayList<String>();
    while (in.hasNext()){
      cat.add(in.next());
    }
    return cat;
  }

  public static void foo(String fileName) throws FileNotFoundException{
      File f = new File(fileName);//can combine
      Scanner in = new Scanner(f);//into one line
      while(in.hasNext()){
        String word = in.next();
        //do something with word
        System.out.println(word);
}
    }

  public static void main(String[]args){

    String fileName = "file.txt";//if you get rid of the comment , turn the file.txt to fileName down there

    try{

       //ArrayList<String> scanFile = getfile(fileName);
 foo(fileName);
    //for (int i = 0; getfile(fileName).size() > i; i++){
    //System.out.println(getfile(fileName).get(i));
  }
      
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      //e.printStackTrace();
      System.exit(1);
    }
  }
}

