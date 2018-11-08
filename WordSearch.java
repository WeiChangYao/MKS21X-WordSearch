public class WordSearch{
  private char[][] data;
  public WordSearch(int rows,int cols){
    char[][]data = new char[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        data[i][j] = '_';
      }
    }
  }
  private void clear(){
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        data[i][j] = '_';
      }
    }
  }
  public String toString(){
    String twoD = "";
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data[i].length; j++){
        twoD += " " + data[i][j];
      }
      twoD = twoD + "\n";
    }
    return twoD;
  }
  //I think I need to make this thing -1 cuz length is one more than
  //the last index!!!!
  public boolean addWordHorizontal(String word,int row, int col){
    if ((col + word.length()) > data[row].length){
      return false;
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
    for(int i = 0; i<word.length(); i++){
      if ((data[row+i][col] == '_') || (word.charAt(i) == data[row+i][col])){
        data[row+i][col] = word.charAt(i);
      }
    }
    return true;
  }
}

        
  
    
