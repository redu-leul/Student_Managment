import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


public class FileManager {

    //attribute for file manager
    private File folder;
    private File textFile;

    //method for creating new file and folder
    public FileManager(){
        folder = new File("Records");
        textFile = new File(folder, "students.txt");

        try{
            if (!folder.exists()){
                folder.mkdirs();
            }
            if (!textFile.exists()){
                textFile.createNewFile();
            }

        } catch (Exception e) {
            IO.println("Error creating file.");
        }
    }
    public void saveToTextFile(ArrayList<Student>students){
        try{

            PrintWriter pw = new PrintWriter(textFile);

            //for loop for writing students list
            for (Student student : students){
                pw.println(student.getName() + "," + student.getStudentid() + "," +  student.getDepartment() +"," + student.getGPA());
            }
            pw.close();
            IO.println("Students saved successfully.");
        }catch (Exception e){
            IO.println("Error saving students.");
        }
    }
    public ArrayList<Student>loadFromTextFile(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            Scanner sc = new Scanner(textFile);

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data = line.split(",");

                String name = data[0];
                String id = data[1];
                String department = data[2];
                double gpa = Double.parseDouble(data[3]);

                students.add(new Student( name, id, department, gpa));
            }
            sc.close();
        }catch (Exception e){
            IO.println("Error loading students.");
        }
        return students;
    }
    public void showFileProperties(){
        IO.println("File Name: " + textFile.getName());
        IO.println("File path: " + textFile.getAbsolutePath());
        IO.println("File Size: " + textFile.length() + " bytes");
        IO.println("Last Modified: "+ textFile.lastModified());
    }
    public void saveToBinaryFile(ArrayList<Student> students) {
        try {
            DataOutputStream output = new DataOutputStream(new FileOutputStream("Records/students.dat"));

            output.writeInt(students.size());

            for (Student student : students) {

                output.writeUTF(student.getName());
                output.writeUTF(student.getStudentid());
                output.writeUTF(student.getDepartment());
                output.writeDouble(student.getGPA());

            }
            output.close();
            IO.println("Binary file saved successfully.");
        } catch (Exception e) {
            IO.println("Error saving binary file.");
        }
    }
    public ArrayList<Student> loadFromBinaryFile() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            DataInputStream input = new DataInputStream(new FileInputStream("Records/students.dat"));
            int total = input.readInt();

            for (int i = 0; i < total; i++) {
                String name = input.readUTF();
                String id = input.readUTF();
                String department = input.readUTF();
                double gpa = input.readDouble();

                students.add(new Student(name, id, department, gpa));

            }
            input.close();
        } catch (Exception e) {
            IO.println("Error loading binary file.");
        }
        return students;
    }
    public void saveObjects(ArrayList<Student> students) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Records/students.obj"));
            output.writeObject(students);
            output.close();

            IO.println("Objects saved successfully.");

        } catch (Exception e) {
            IO.println("Serialization error.");
        }
    }
    @SuppressWarnings("unchecked")
    public ArrayList<Student> loadObjects() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Records/students.obj"));
            students = (ArrayList<Student>) input.readObject();

            input.close();
        } catch (Exception e) {
            IO.println("Error loading serialized objects.");
        }
        return students;
    }
    public void backupTextFile() {
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream("Records/students.txt"));

            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("Records/students_backup.txt"));

            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
            input.close();
            output.close();

            IO.println("Backup completed successfully.");

        } catch (Exception e) {
            IO.println("Backup failed.");
        }
    }
}