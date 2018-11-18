import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
  /*public ArrayList getfile(File fileName){
    ArrayList scanFile = new ArrayList<String>();
    File f = new File(fileName);
    Scanner in = new Scanner(f);
    while(in.hasNext()){
      String word = in.nextLine();
      scanFile.add(word);
    }
    return scanFile;
  }*/
      
  
  //public WordSearch( int rows, int cols, String fileName) {
  //  data = new char[rows][cols];
  //  clear();
  //  wordsToAdd = getfile(fileName);//write that
  //  wordsAdded = new ArrayList<String>();
  //  randgen = new Random();//uhh 0-10k
  //}
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
    //twoD += "\nWords:";
    //for (int i = 0; i < wordsAdded.size(); i++){//don't do this if this is null
    //  twoD += wordsAdded.get(i);//maybe try the easy way
    //}
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
    for(int i = 0; wordsToAdd.size() > 0; i++){//from 0 to size?
      int rInc = 0;
      int cInc = 0;
      //i = randgen.nextInt(Integer.MAX_VALUE)%wordsToAdd.size();
      while (rInc == 0 && cInc == 0){
        rInc = randgen.nextInt()%2;
        cInc = randgen.nextInt()%2;
      }

      String randWord = wordsToAdd.get(i);
      int c;
      boolean added;
      for ( c = 0,added = false; c < 50 && added == false; c++){
        if (addWord(randWord, randgen.nextInt()%data.length, randgen.nextInt()%data[0].length, rInc, cInc) == true){
          added = true;
          wordsToAdd.remove(i);
        } 
        if (c == 50){
          wordsToAdd.remove(i);
        }
      }
    }
  }
}

        
  
    
