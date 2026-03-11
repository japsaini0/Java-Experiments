
class MyThread extends Thread
{
    @Override
    public void run()
    {
        System.out.println("Thread is running");  
        for(int i = 0; i < 5; i++)
        {
            System.out.println(i);
        }      
    }

    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.start();

        try
        {
            t.sleep(1000);
        }

        catch(Exception e)
        {
            System.out.println(e);
        }

        MyThread2 th = new MyThread2();
        th.start();
    }
}   

class MyThread2 extends Thread
{
    public void run()
    {        
        System.out.println("Thread 2 is running");
        for(int i = 0; i < 5; i++)
        {
            System.out.println(i);
        }
    }
}