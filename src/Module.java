import java.util.Scanner;

public class Module {
    private String moduleCode;
    private String grade;
    private double mc;
    private double gradePoint;

    public Module() {

        System.out.print("Module Code: ");
        this.moduleCode = new Scanner(System.in).nextLine();

        System.out.print("Grade Attained: ");
        this.grade = new Scanner(System.in).nextLine();

        System.out.print("MC: ");
        this.mc = new Scanner(System.in).nextDouble();

        computeGradePoint(grade);
    }

    public String getModuleCode() { return moduleCode; }
    public double getMC() { return mc; }
    public double getGradePoint() { return gradePoint; }

    public void change() {
        int choice;

        while(true) {
            System.out.println();
            System.out.println("-Select component to change-");
            System.out.println("1. Module Code");
            System.out.println("2. Grade");
            System.out.println("3. MC");
            System.out.println("0. No more changes to make");
            System.out.print("Selected option: ");
            choice = new Scanner(System.in).nextInt();

            if(choice == 1) {
                System.out.print("New Module Code: ");
                this.moduleCode = new Scanner(System.in).nextLine();
            } else if(choice == 2) {
                System.out.print("Amended grade: ");
                this.grade = new Scanner(System.in).nextLine();
            } else if(choice == 3) {
                System.out.print("Amended MC: ");
                this.mc = new Scanner(System.in).nextDouble();
            } else {
                break;
            }
        }
        computeGradePoint(grade);
    }

    public void printDetails() {
        System.out.println(moduleCode + " | " + grade + " | " + mc);
    }

    private void computeGradePoint(String grade) {
        if (grade.equals("A") || grade.equals("A+")) {
            this.gradePoint = 5.0;
        } else if (grade.equals("A-")) {
            this.gradePoint = 4.5;
        } else if (grade.equals("B+")) {
            this.gradePoint = 4.0;
        } else if (grade.equals("B")) {
            this.gradePoint = 3.5;
        } else if (grade.equals("B-")) {
            this.gradePoint = 3.0;
        } else if (grade.equals("C+")) {
            this.gradePoint = 2.5;
        } else if (grade.equals("C-")) {
            this.gradePoint = 2.0;
        } else if (grade.equals("D+")) {
            this.gradePoint = 1.5;
        } else if (grade.equals("D")) {
            this.gradePoint = 1.0;
        } else if(grade.equals("F")) {
            this.gradePoint = 0.0;
        } else {
            this.gradePoint = 0.0;
            this.mc = 0.0;
        }
    }

}
