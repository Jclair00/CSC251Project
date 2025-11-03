import java.util.Scanner;

public class Project_jamal_clair {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Collect input from user
        System.out.print("Please enter the Policy Number: ");
        int number = input.nextInt();
        input.nextLine();

        System.out.print("Please enter the Provider Name: ");
        String provider = input.nextLine();

        System.out.print("Please enter the Policyholder's First Name: ");
        String firstName = input.nextLine();

        System.out.print("Please enter the Policyholder's Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Please enter the Policyholder's Age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String status = input.nextLine();

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        double height = input.nextDouble();

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        double weight = input.nextDouble();

        // Create Policy object
        Policy policy = new Policy(number, provider, firstName, lastName, age, status, height, weight);

        // Display all information
        System.out.println("\n" + policy.toString());

        input.close();
    }
}
