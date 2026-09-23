import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String branch;
    double cgpa;
    String status;

    Student(int id, String name, String branch, double cgpa) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
        this.status = "Not Placed";
    }

    void display() {
        System.out.println("----------------------------");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Branch     : " + branch);
        System.out.println("CGPA       : " + cgpa);
        System.out.println("Status     : " + status);
    }
}

class Company {
    String name;
    double packageLPA;

    Company(String name, double packageLPA) {
        this.name = name;
        this.packageLPA = packageLPA;
    }

    void display() {
        System.out.println("----------------------------");
        System.out.println("Company : " + name);
        System.out.println("Package : " + packageLPA + " LPA");
    }
}

public class PlacementManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Company> companies = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        students.add(new Student(id, name, branch, cgpa));
        System.out.println("Student added successfully!");
    }

    static void addCompany() {
        sc.nextLine();

        System.out.print("Enter Company Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Package (LPA): ");
        double packageLPA = sc.nextDouble();

        companies.add(new Company(name, packageLPA));
        System.out.println("Company added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void viewCompanies() {
        if (companies.isEmpty()) {
            System.out.println("No companies available.");
            return;
        }

        for (Company c : companies) {
            c.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                s.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void updatePlacementStatus() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter Placement Status (Placed/Not Placed): ");
                s.status = sc.nextLine();

                System.out.println("Placement status updated!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== PLACEMENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Company");
            System.out.println("3. View Students");
            System.out.println("4. View Companies");
            System.out.println("5. Search Student");
            System.out.println("6. Update Placement Status");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCompany();
                    break;
                case 3:
                    viewStudents();
                    break;
                case 4:
                    viewCompanies();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    updatePlacementStatus();
                    break;
                case 7:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
