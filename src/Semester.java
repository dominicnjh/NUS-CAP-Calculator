import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Semester {
    private List<Module> modules = new ArrayList<>();
    private double sap;
    private int numMods = 0;
    private double totalMC = 0.0;

    public Semester() {
        int choice;

        while (true) {
            System.out.println();
            System.out.println("-Fill up modules taken for the current semester-");
            System.out.println("1. Add modules");
            System.out.println("2. Done adding");
            System.out.print("Selected option: ");
            choice = new Scanner(System.in).nextInt();

            if (choice == 1) {
                addModule();
            } else {
                break;
            }
        }
    }

    public int searchModule(String moduleCode) {
        for(int i = 0; i < numMods; i++) {
            if(modules.get(i).getModuleCode().equals(moduleCode)) {
                return i;
            }
        }
        return -1;
    }

    public void changeModule(int index) {
        modules.get(index).change();
        computeTotalMC();
        computeSAP();
    }

    public void removeModule(int index) {
        modules.remove(index);
        numMods--;
        computeTotalMC();
        computeSAP();
    }

    public void addModule() {
        modules.add(new Module());
        numMods++;
        computeTotalMC();
        computeSAP();
    }

    public void printDetails() {
        DecimalFormat df = new DecimalFormat("##.##");

        System.out.println("Current Semester Details: ");
        System.out.println("Module Code | Grade | MC");
        for (int i = 0; i < numMods; i++) {
            modules.get(i).printDetails();
        }
        System.out.println("SAP: " + df.format(sap));
    }

    public double getTotalMC() {
        return totalMC;
    }

    public double getSAP() {
        return sap;
    }

    private void computeTotalMC() {
        double newMC = 0.0;

        for(int i = 0; i < numMods; i++) {
            newMC += modules.get(i).getMC();
        }

        totalMC = newMC;
    }

    private void computeSAP() {
        double numerator = 0.0;

        if (numMods == 0) {
            sap = 0.0;
        }

        for(int i = 0; i < numMods; i++) {
            numerator += modules.get(i).getGradePoint() * modules.get(i).getMC();
        }

        sap = (numerator / totalMC);
    }
}