import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class WordSearch{
  private int seed;
  private Random randgen;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;
  private char[][] data;
  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    clear();
  }
  public ArrayList getfile(String fileName) throws FileNotFoundException{//is this right???
    File f = new File(fileName);
    Scanner in = new Scanner(f);
    ArrayList<String> scanFile = new ArrayList<String>();
    while (in.hasNext()){
      scanFile.add(in.next());
    }
    return scanFile;
  }
      
  public WordSearch( int rows, int cols, String fileName) throws FileNotFoundException{//throw it here right???
    data = new char[rows][cols];
    clear();
    wordsToAdd = getfile(fileName);
    wordsAdded = new ArrayList<String>();
    seed = (int)(Math.random()*10000);
    randgen = new Random(seed);//uhh 0-10k
    addAllWords();
  }

  public WordSearch( int rows, int cols, String fileName, int see) throws FileNotFoundException{//throw it here right???
    data = new char[rows][cols];
    clear();
    wordsToAdd = getfile(fileName);
    wordsAdded = new ArrayList<String>();
    seed = see;
    randgen = new Random(seed);//uhh 0-10k
    addAllWords();
  }

  private void clear(){
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        data[i][j] = '_';
      }
    }
  }
  public String toString(){
    String twoD = "|";
    for (int i = 0; i < data.length; i++){
      twoD += data[i][0];
      for (int j = 1; j < data[i].length; j++){
        twoD += " " + data[i][j];
      }
      if(i+1 != data.length){
        twoD = twoD + "|\n|";
      }
      else{
        twoD += "|";
      }
    }
    twoD += "\nWords:";
    for (int i = 0; i < wordsAdded.size(); i++){//don't do this if this is null
      twoD += " " + wordsAdded.get(i);//maybe try the easy way
    }
    twoD += " (seed: " + seed +")";
    return twoD;
  }

  //I think I need to make this thing -1 cuz length is one more than
  //the last index!!!!
  public boolean addWordHorizontal(String word,int row, int col){
    if ((col + word.length()) > data[row].length){
      return false;
    }

    for (int i = 0; i < word.length(); i ++){
      if (Character.isLetter(data[row][col+i]) && (! (data[row][col+i] == word.charAt(i)))){
        return false;
      }
    }

    for(int i = 0; i<word.length(); i++){
      if ((data[row][i+col] == '_') || (word.charAt(i) == data[row][i+col])){
        data[row][i+col] = word.charAt(i);
      }
    }
    return true;
  }
  public boolean addWordVertical(String word,int row, int col){
    if ((row + word.length()) > data.length){
      return false;
    }

    for (int i = 0; i < word.length(); i ++){
      if (Character.isLetter(data[row + i][col]) && (! (data[row + i][col] == word.charAt(i)))){
        return false;
      }
    }

    for(int i = 0; i<word.length(); i++){
      if ((data[row+i][col] == '_') || (word.charAt(i) == data[row+i][col])){
        data[row+i][col] = word.charAt(i);
      }
    }
    return true;
  }

  public boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
    if (word.length()* rowIncrement + row * rowIncrement > data.length || word.length()* colIncrement + col * colIncrement > data[0].length || word.length()* rowIncrement + row + 1< 0 || word.length()* colIncrement + col + 1< 0 ){
      return false;
    }
    for (int i = 0; i < word.length(); i ++){
      if (Character.isLetter(data[i * rowIncrement + row][i * colIncrement + col]) && (! (data[i * rowIncrement + row][i * colIncrement + col] == word.charAt(i)))){
        return false;
      }
    }//I know this part is good
    for(int i = 0; i<word.length(); i++){
      if ((data[row+i*rowIncrement][col+i*colIncrement] == '_') || (word.charAt(i) == data[row+i*rowIncrement][col+i*colIncrement])){
        data[row+i*rowIncrement][col+i*colIncrement] = word.charAt(i);
      }
    }
    return true;
  }
  public void addAllWords(){
    for(int i = 0; wordsToAdd.size() > 0; i++){//REPLACE i WITH 0!! TAKES TOO LONG THO!!!
      int rInc = 0;
      int cInc = 0;
      i = randgen.nextInt(Integer.MAX_VALUE)%wordsToAdd.size();//REMOVE THIS!!
      while (rInc == 0 && cInc == 0){
        rInc = randgen.nextInt()%2;
        cInc = randgen.nextInt()%2;
      }
      String randWord = wordsToAdd.get(i);
      int c = 0;
      boolean added;
      for (added = false; c < 10 && added == false; c++){
        if (addWord(randWord, randgen.nextInt(Integer.MAX_VALUE)%data.length, randgen.nextInt(Integer.MAX_VALUE)%data[0].length, rInc, cInc) == true){
          added = true;
          wordsToAdd.remove(i);
          wordsAdded.add(randWord);
          i = i-1;
          c = 0;
        } 
        if (c == 10){
          wordsToAdd.remove(i);
          i = i-1;
        }
      }
    }
  }
  public static boolean isANum(String str){  
    try{  
      int d = Integer.parseInt(str);  
    }catch(NumberFormatException e){  
      return false;  
    }  
    return true;  
  }
  
  //FILL METHOD
  public static void fill(WordSearch a){
    for (i = 0;

  public static void main(String[] args){

    if (args.length < 3) {
      System.out.println("usage: java WordSearch [rows cols filename [randomSeed [answers]]]");
      System.exit(1);
    }
    if (args.length > 3 && (Integer.parseInt(args[3]) > 10000 || Integer.parseInt(args[3]) < 0)) {
      System.out.println("usage: java WordSearch [rows cols filename [randomSeed [answers]]]");
      System.exit(1);
    }
    if (!(isANum(args[0])) || !(isANum(args[1]))){
      System.out.println("usage: java WordSearch [rows cols filename [randomSeed [answers]]]");
      System.exit(1);
    }
    if (Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0) {
      System.out.println("usage: java WordSearch [rows cols filename [randomSeed [answers]]]");
      System.exit(1);
    }

    String fileName = args[2];
    try{
      if (args.length == 3){
        WordSearch perfectAvg = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
        System.out.println(perfectAvg.toString()); 
      }
      if (args.length == 4){
        WordSearch perfectAvg = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
        System.out.println(perfectAvg.toString()); 
      }
      if (args.length > 4 && args[4].equals("key")){
        WordSearch perfectAvg = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
        System.out.println(perfectAvg.toString()); 
        System.out.println("fill _ with  ");
      }
      if (args.length > 4 && !(args[4].equals("key"))){
        WordSearch perfectAvg = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
        System.out.println(perfectAvg.toString()); 
        System.out.println("same as when length == 4!!");
      }
       

    }catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
   
  }
}

        
  
    
