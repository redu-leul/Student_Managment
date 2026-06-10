import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int Studentid;
    private String Department;
    private double GPA;

    public Student(String name, int Studentid, String Department, double GPA) {
        this.name = name;
        this.Studentid = Studentid;
        this.Department = Department;
        this.GPA = GPA;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getStudentid(){
        return Studentid;   
    } 
    public void setStudentid(int Studentid){
        this.Studentid = Studentid;
    }
    public String getDepartment(){
        return Department;
    }
    public void setDepartment(String Department){
        this.Department = Department;
    }
    public double getGPA(){
        return GPA;
    }
    public void setGPA(double GPA){
        this.GPA = GPA;
    }
    @Override
    public String toString(){
        return "Student Name: " + name + ", Student ID: " + Studentid + ", Department: " + Department + ", GPA: " + GPA;
    }
}
