class JapNotfound extends Exception
{
    public JapNotfound(String message)
    {
        System.out.println(message);
    }
}

public class JapTries
{
    public static void main(String[] args)
    {
        try
        {
            int a = 10 / 0; 
        }
        catch (ArithmeticException jp)
        {
            System.out.println("Caught an exception: " + jp.getMessage());
        }

        try
        {
            int[] japsarr = new int[5];
            System.out.println(japsarr[10]); 
        }
        catch (ArrayIndexOutOfBoundsException jp)
        {
            System.out.println("Caught an exception: " + jp.getMessage());
        }

        try
        {
            String str = null;
            System.out.println(str.length()); 
        }
        catch (NullPointerException jp)
        {
            System.out.println("Caught an exception: " + jp.getMessage());
        }

        try
        {
            throw new JapNotfound("This is a custom exception.");
        }
        catch (JapNotfound jp)
        {
            System.out.println("Caught an exception: " + jp.getMessage());
        }
    }
}

