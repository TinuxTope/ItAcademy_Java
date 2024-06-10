package TascaS1_01.N3.n3exercici1CristinaTomas;

import java.util.ArrayList;

public class Editor {
    private String name;
    private final String DNI;
    private static double salary;
    private ArrayList<New> news;

    public Editor(String name, String DNI){
        this.name = name;
        this.DNI = DNI;
        salary = 1500;
        this.news = new ArrayList<New>();
    }


    public String getName() { return this.name; }
    public String getDNI() { return this.DNI; }
    public static double getSalary() { return salary; }
    public ArrayList<New> getNews() { return this.news; }
@Override
    public String toString(){
        return "The editor " + this.name + " with ID number " + this.DNI
                + ", whith salary of " + salary + "€, has written " + news + " article(s).";
    }
}
