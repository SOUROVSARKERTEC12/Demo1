package File;

import java.io.*;
import java.util.Scanner;

public class Software_DL {
    public static void main(String[] args) throws IOException {
        System.out.println("1.Show all student");
        System.out.println("2.Show random student");
        System.out.println("3.Show number of students");
        System.out.println("4.Add a student");
        System.out.println("5.Find a student");
        System.out.println("Enter Option between (1-5):");

        Scanner scanner = new Scanner(System.in);

        int Option = scanner.nextInt();

        if(Option == 1) {
            File file = new File(Constants.TEXT_FILE_NAME);
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            }
            catch(FileNotFoundException e) {
                System.out.println("Exception"+e.toString());
            }

            String string;
            while ((string = bufferedReader.readLine())!=null){
                System.out.println(string);
            }
        }
    }
}
