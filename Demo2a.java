import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Demo2a {

    //Effectively this would NOT handle the exception
    //This would pass it to the JVM which shows the stack trace
    public static void main(String[]args)throws FileNotFoundException{
        String fileName = "file.txt";
        File f = new File(fileName);//can combine
        Scanner in = new Scanner(f);//into one line
    }
    while(in.hasNext()){
        String line = in.nextLine();
        //do something with line
        System.out.println(line);
}
}


