package File;

import java.io.*;
import java.util.Random;
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

        else if(Option == 2){
            int count = getNumberOfStudent();

            File file = new File(Constants.TEXT_FILE_NAME);
            BufferedReader bufferedReader = null;

            try{
                bufferedReader = new BufferedReader(new FileReader(file));
            }catch (Exception e){
                System.out.println("Exception :" +e.toString());
            }

            String []id = new String[count];

            int i = 0;
            String string;
            while ((string = bufferedReader.readLine())!= null){
                if (string.equals("")){
                    continue;
                }

                id[i] = string;
                i++;
            }

            int randNumber =randInt(0,id.length-1);

            System.out.println("Random Students:"+id[randNumber]);
        }

        else if(Option == 3){
            File file = new File(Constants.TEXT_FILE_NAME);
            BufferedReader bufferedReader = null;

            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            }catch (FileNotFoundException e){
                System.out.println("Exception :"+e.toString());
            }

            String string;
            int count = 0;

            while ((string = bufferedReader.readLine()) != null){
                count ++;
            }

            System.out.println("Number of Students :"+count);
        }

        else if(Option == 4){
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("E:\\Demo1\\src\\File\\Student_list.txt",true));

            System.out.println("Enter your new student name :");
            String add = scanner.next();

            fileWriter.newLine();
            fileWriter.write(add);
            fileWriter.close();
        }
    }
    public static int randInt(int min,int max){
        Random random = new Random();
        int randomNum = random.nextInt((max-min)+1)+min;

        return randomNum;
    }

    public static int getNumberOfStudent() throws IOException{
        File file = new File(Constants.TEXT_FILE_NAME);
        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(file));
        }catch (Exception e){
            System.out.println("Exception :"+e.toString());
        }

        String string;
        int count = 0;
        while ((string = bufferedReader.readLine())!= null){
            if (string.equals("")){
                continue;
            }
            count++;
        }

        return count;
    }
}
