import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads policy records from PolicyInformation.txt (8 lines per policy),
 * stores them in an ArrayList, prints each policy, and reports smoker counts.
 */
public class jamal_clair.java {

    public static void main(String[] args) {
        final String FILE_NAME = "PolicyInformation.txt";
        List<Policy> policies = new ArrayList<>();

        //Read all policies from file (any size) 
        try (Scanner file = new Scanner(new File(FILE_NAME))) {

            while (file.hasNextLine()) {
                // Skip any leading blank lines between records
                String line = nextNonEmptyLine(file);
                if (line == null) break;

                int policyNumber = Integer.parseInt(line.trim());
                String providerName = nextNonEmptyLine(file);
                String firstName    = nextNonEmptyLine(file);
                String lastName     = nextNonEmptyLine(file);
                int age             = Integer.parseInt(nextNonEmptyLine(file).trim());
                String smoking      = nextNonEmptyLine(file);
                double height       = Double.parseDouble(nextNonEmptyLine(file).trim());
                double weight       = Double.parseDouble(nextNonEmptyLine(file).trim());

                policies.add(new Policy(
                        policyNumber, providerName, firstName, lastName,
                        age, smoking, height, weight
                ));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + FILE_NAME + ". Place it next to your .java files.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number in the input file. Check ages/heights/weights and try again.");
            return;
        }

        // ---- Print each policy ----
        int smokers = 0;
        int nonSmokers = 0;

        for (Policy p : policies) {
            System.out.println(p.toString());

            if ("smoker".equalsIgnoreCase(p.getSmokingStatus())) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }

        // ---- Summary counts ----
        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }

    /**
     * Reads lines until a non-empty line is found, or returns null on EOF.
     *
     * @param sc the scanner reading the file
     * @return a non-empty line, or null if no more lines
     */
    private static String nextNonEmptyLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (!s.trim().isEmpty()) return s;
        }
        return null;
    }
}
