public class CalculateArea {
    public double area(double r)
    {
       return r * r * 3.14;
    }   

    public double area(double len, double b)
    {
        return len * b;
    }

    public static void main(String[] args)
    {
        CalculateArea f1 = new CalculateArea();
        System.out.println("Area of Circle : " + f1.area(10));
        System.out.println("Area of Rectangle : " + f1.area(10, 20));
        
    }
}
