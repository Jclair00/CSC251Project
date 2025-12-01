import java.util.Scanner;

public class Project_jamal_clair {
    
    public static void main(String[] args) {

        ArrayList<Policy> policies = new ArrayList<>();
        int smokers = 0;
        int nonSmokers = 0;

        try {
            Scanner file = new Scanner(new File("PolicyInformation.txt"));

            while (file.hasNextLine()) {

                int policyNumber = Integer.parseInt(file.nextLine().trim());
                String providerName = file.nextLine().trim();
                String firstName = file.nextLine().trim();
                String lastName = file.nextLine().trim();
                int age = Integer.parseInt(file.nextLine().trim());
                String smokingStatus = file.nextLine().trim();
                double height = Double.parseDouble(file.nextLine().trim());
                double weight = Double.parseDouble(file.nextLine().trim());

                if (file.hasNextLine()) {
                    file.nextLine(); // Skip blank line
                }

                PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                Policy policy = new Policy(policyNumber, providerName, holder);

                policies.add(policy);
            }

            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt not found.");
            return;
        }

        for (Policy p : policies) {
            System.out.println(p); // Calls toString implicitly

            if ("smoker".equalsIgnoreCase(p.getPolicyHolder().getSmokingStatus())) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }

        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.\n");
        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }
}
