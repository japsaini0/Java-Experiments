import java.io.*;
import java.util.Scanner;

class FileHandling
{
    public static void main(String[] args)
    {
        Scanner jp = new Scanner(System.in);

        System.out.print("Enter Student Name : ");
        String name = jp.nextLine();

        System.out.print("Enter Roll Number : ");
        int uid = jp.nextInt();
        
        jp.nextLine();

        System.out.print("Enter Course : ");
        String course = jp.nextLine();

        System.out.println();

        File file = new File("student.txt");
        
        try
        {
            file.createNewFile();
        }
        
        catch(IOException japp)
        {
            japp.printStackTrace();
        }


        try
        {
            FileWriter jap = new FileWriter("student.txt");

            System.out.println("Data Written Successfully.\n");
            jap.write("Student Name : " + name + "\n");
            jap.write("Roll Number : " + uid + "\n");
            jap.write("Course : " + course);

            jap.close();
        }

        catch(IOException e)
        {
            System.err.println("File Not Found" + e.getMessage());
        }

        try
        {
            Scanner smth = new Scanner(file);

            while(smth.hasNextLine())
            {
                String line = smth.nextLine();
                System.out.println(line);  
            }
        }

        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}