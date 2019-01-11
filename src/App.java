import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int choice;
        double cap;
        double mcTaken;
        double ungradedMC;

        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##.##");

        System.out.println("------------------------------------");
        System.out.println("Welcome to Dom's NUS CAP Calculator!");
        System.out.println("------------------------------------");
        System.out.println();
        System.out.println("Please indicate:");
        System.out.println("Current CAP?");
        cap = in.nextDouble();
        System.out.println("Graded MCs counted towards CAP?");
        mcTaken = in.nextDouble();
        System.out.println("Graded MCs not counted towards CAP?");
        ungradedMC = in.nextDouble();

        Semester sem = new Semester();

        while (true) {
            System.out.println();
            System.out.println("-Please select an option below-");
            System.out.println("1. Current CAP");
            System.out.println("2. Total MC Taken");
            System.out.println("3. Current Semester Details");
            System.out.println("4. Makes changes to current modules");
            System.out.println("5. Add another module");
            System.out.println("6. Remove a module");
            System.out.println("0. Terminate this program");
            System.out.print("Selected option: ");
            choice = in.nextInt();

            if (choice == 1) {
                System.out.println();
                System.out.println("CAP: " + df.format(computeCAP(cap, mcTaken, sem.getSAP(), sem.getTotalMC())));
                System.out.println();
            } else if (choice == 2) {
                double totalCredit = sem.getTotalMC() + mcTaken + ungradedMC;
                System.out.println();
                System.out.println("Total MCs Taken: " + totalCredit);
                System.out.println();
            } else if (choice == 3) {
                System.out.println();
                sem.printDetails();
                System.out.println();
            } else if (choice == 4) {
                System.out.println();
                System.out.print("Module code of module to change: ");
                String moduleCode = new Scanner(System.in).nextLine();

                if(sem.searchModule(moduleCode) < 0) {
                    System.out.println("Module not found!");
                } else {
                    int position = sem.searchModule(moduleCode);
                    sem.changeModule(position);
                }
                System.out.println();
            } else if(choice == 5) {
                System.out.println();
                sem.addModule();
                System.out.println();
            } else if(choice == 6) {
                System.out.println();
                System.out.print("Module code of module to remove: ");
                String moduleCode = new Scanner(System.in).nextLine();

                if(sem.searchModule(moduleCode) < 0) {
                    System.out.println("Module not found!");
                } else {
                    int position = sem.searchModule(moduleCode);
                    sem.removeModule(position);
                }
            } else {
                break;
            }
        }
        in.close();
    }

    public static double computeCAP(double cap, double mcTaken, double sap, double semMC) {
        return ((cap * mcTaken) + (sap * semMC)) / (mcTaken + semMC);
    }
}
