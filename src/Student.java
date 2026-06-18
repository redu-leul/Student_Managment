import java.io.Serializable;

public class Student implements Serializable {
   private String name;
   private String Studentid;
   private String Department;
   private double GPA;

    public Student(String Studentid, String name, String Department, double GPA){
        this.Studentid = Studentid;
        this.name = name;
        this.Department = Department;
        this.GPA = GPA;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStudentid() {
        return Studentid;
    }
    public void setStudentid(String Studentid) {

        this.Studentid = Studentid;
    }
    public String getDepartment(){
        return Department;
    }
    public void setDepartment(String Department){
        this.Department = Department;
    }
    public double getGPA() {
        return GPA;
    }
    public void setGPA(double GPA) {

        this.GPA = GPA;
    }
    @Override
    public String toString(){

        return "NAME:" + name +
                "  |  ID:" + Studentid +
                "  |  DEPARTMENT:" + Department +
                "  |  GPA:" + GPA ;
    }
}
