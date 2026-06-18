import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();
    final String TEXT_FILE = "students.txt";
    final String BINARY_FILE = "students.dat";
    final String OBJECT_FILE = "students.ser";

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.menu();
    }
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            IO.println("\n=======STUDENT RECORD MANAGEMENT SYSTEM ========");
            IO.println("|              1. Add Student                    |");
            IO.println("=================================================");
            IO.println("|              2. Search Student                 |");
            IO.println("=================================================");
            IO.println("|              3. Update Student                 |");
            IO.println("=================================================");
            IO.println("|              4. Delete Student                 |");
            IO.println("=================================================");
            IO.println("|              5. Display All Students           |");
            IO.println("=================================================");
            IO.println("|              6. Generate Report                |");
            IO.println("=================================================");
            IO.println("|              7. Save To Text File              |");
            IO.println("=================================================");
            IO.println("|              8. Load From Text File            |");
            IO.println("=================================================");
            IO.println("|              9. Save To Binary File            |");
            IO.println("=================================================");
            IO.println("|              10. Load From Binary File         |");
            IO.println("=================================================");
            IO.println("|              11. Save To Object File           |");
            IO.println("=================================================");
            IO.println("|              12. Load From Object File         |");
            IO.println("================================================");
            IO.println("|              13. Exit                          |");
            IO.println("=================================================");
            IO.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    searchStudent(sc);
                    break;
                case 3:
                    updateStudent(sc);
                    break;
                case 4:
                    deleteStudent(sc);
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    generateReport();
                    break;
                case 7:
                    saveTextFile();
                    break;
                case 8:
                    loadTextFile();
                    break;
                case 9:
                    saveBinaryFile();
                    break;
                case 10:
                    loadBinaryFile();
                    break;
                case 11:
                    saveObjectFile();
                    break;
                case 12:
                    loadObjectFile();
                    break;
                case 13:
                    IO.println("Thank You!");
                    break;
                default:
                    IO.println("Invalid Choice!");
            }
        } while (choice != 13);
        sc.close();
    }
    public void addStudent(Scanner sc) {
        IO.print("Enter ID: ");
        String id = sc.nextLine();
        IO.print("Enter Name: ");
        String name = sc.nextLine();
        IO.print("Enter Department: ");
        String department = sc.nextLine();
        IO.print("Enter GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(id, name, department, gpa));
        IO.println("Student Added Successfully.");
    }
    public void searchStudent(Scanner sc) {
        IO.print("Enter Student ID: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.getStudentid().equals(id)) {
                IO.println(s);
                return;
            }
        }
        IO.println("Student Not Found.");
    }
    public void updateStudent(Scanner sc) {
        IO.print("Enter Student ID: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.getStudentid().equals(id)) {
                IO.print("Enter New Name: ");
                s.setName(sc.nextLine());
                IO.print("Enter New Department: ");
                s.setDepartment(sc.nextLine());
                IO.print("Enter New GPA: ");
                s.setGPA(sc.nextDouble());
                sc.nextLine();
                IO.println("Student Updated.");
                return;
            }
        }
        IO.println("Student Not Found.");
    }
    public void deleteStudent(Scanner sc) {
        IO.print("Enter Student ID: ");
        String id = sc.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentid().equals(id)) {
                students.remove(i);
                IO.println("Student Deleted.");
                return;
            }
        }
        IO.println("Student Not Found.");
    }
    public void displayAllStudents() {
        if (students.isEmpty()) {
            IO.println("No Students Available.");
            return;
        }
        IO.println("\n===== STUDENTS =====");
        for (Student s : students) {
            IO.println(s);
        }
    }
    public void generateReport() {
        if (students.isEmpty()) {
            IO.println("No Students Available.");
            return;
        }
        int total = students.size();
        double highest = students.get(0).getGPA();
        double lowest = students.get(0).getGPA();
        double sum = 0;
        for (Student s : students) {
            sum += s.getGPA();
            if (s.getGPA() > highest)
                highest = s.getGPA();
            if (s.getGPA() < lowest)
                lowest = s.getGPA();
        }
        double average = sum / total;
        IO.println("\n===== REPORT =====");
        IO.println("Total Students : " + total);
        IO.println("Highest GPA    : " + highest);
        IO.println("Lowest GPA     : " + lowest);
        IO.println("Average GPA    : " + average);
    }
    public void saveTextFile() {
        try {
            PrintWriter pw = new PrintWriter(TEXT_FILE);
            for (Student s : students) {
                pw.println(
                        s.getStudentid() + "," +
                                s.getName() + "," +
                                s.getDepartment() + "," +
                                s.getGPA()
                );
            }
            pw.close();
            IO.println("Saved To Text File.");
        } catch (Exception e) {
            IO.println("Error Saving Text File.");
        }
    }
    public void loadTextFile() {
        try {
            Scanner file = new Scanner(new File(TEXT_FILE));
            students.clear();
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split(",");
                students.add(
                        new Student(
                                parts[0],
                                parts[1],
                                parts[2],
                                Double.parseDouble(parts[3])
                        )
                );
            }
            file.close();
            IO.println("Loaded From Text File.");
        } catch (Exception e) {
            IO.println("Error Loading Text File.");
        }
    }
    public void saveBinaryFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(BINARY_FILE));

            dos.writeInt(students.size());
            for (Student s : students) {
                dos.writeUTF(s.getStudentid());
                dos.writeUTF(s.getName());
                dos.writeUTF(s.getDepartment());
                dos.writeDouble(s.getGPA());
            }
            dos.close();
            IO.println("Saved To Binary File.");
        } catch (Exception e) {
            IO.println("Error Saving Binary File.");
        }
    }
    public void loadBinaryFile() {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(BINARY_FILE));
            students.clear();
            int count = dis.readInt();
            for (int i = 0; i < count; i++) {
                String id = dis.readUTF();
                String name = dis.readUTF();
                String department = dis.readUTF();
                double gpa = dis.readDouble();
                students.add(
                        new Student(id, name, department, gpa)
                );
            }
            dis.close();
            IO.println("Loaded From Binary File.");
        } catch (Exception e) {
            IO.println("Error Loading Binary File.");
        }
    }
    public void saveObjectFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OBJECT_FILE));
            oos.writeObject(students);
            oos.close();
            IO.println("Saved To Object File.");
        } catch (Exception e) {
            IO.println("Error Saving Object File.");
        }
    }
    @SuppressWarnings("unchecked")
    public void loadObjectFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OBJECT_FILE));
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
            IO.println("Loaded From Object File.");
        } catch (Exception e) {
            IO.println("Error Loading Object File.");
        }
    }
}