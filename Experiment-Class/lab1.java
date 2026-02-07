import java.util.Scanner;

public class lab1
{
    public static void main(String args[])
    {
        Scanner jp = new Scanner(System.in);

        int num1 = jp.nextInt();
        long num2 = jp.nextLong();
        float num3 = jp.nextFloat();
        double num4 = jp.nextDouble();

        jp.nextLine();
        String s = jp.nextLine();

        boolean ans = jp.nextBoolean();
        
        System.out.println();
        System.out.println("You entered  : ");
        
        System.out.println(num1);                
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(s);
        System.out.println(ans);

    }
}