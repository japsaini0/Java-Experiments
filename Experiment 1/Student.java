public class Student {
    
    String name;
    int UID;
    
    public Student()
    {
        this.name = "Japjit";
        this.UID = 10785;

        System.out.println(name);
        System.out.println(UID);
    }    

    public Student(String name, int UID)
    {
        this.name = name;
        this.UID = UID;

        System.out.println(name);
        System.out.println(UID);
    }

    public static void main(String[] args)
    {
        Student s1 = new Student();
        Student s2 = new Student("Singh", 10785);
    }
    
}
