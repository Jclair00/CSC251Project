/**
 * The Policy class models an insurance policy for one person.
 */

public class Policy {

    // Instance variables (attributes)
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height; // in inches
    private double weight; // in pounds

    /**
     * No-arg constructor to default
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor that accepts arguments
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    //  Getters (Accessors) 
    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    //  Setters (Mutators) 
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }

    /**
     * Calculates the BMI of the policyholder.
     * Formula: BMI = (Weight * 703) / (Height^2)
     */
    public double calculateBMI() {
        if (height <= 0) return 0;
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the total policy price.
     * Avoids stale data.
     */
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        // Age-based additional fee
        if (age > 50)
            additionalFee += 75.0;

        // Smoking status additional fee
        if (smokingStatus.equalsIgnoreCase("smoker"))
            additionalFee += 100.0;

        // BMI-based additional fee
        double bmi = calculateBMI();
        if (bmi > 35)
            additionalFee += (bmi - 35) * 20;

        return baseFee + additionalFee;
    }

    /**
     * Returns a formatted String representing the policy.
     */
    @Override
    public String toString() {
        return String.format("""
                Policy Number: %d
                Provider Name: %s
                Policyholder’s First Name: %s
                Policyholder’s Last Name: %s
                Policyholder’s Age: %d
                Policyholder’s Smoking Status: %s
                Policyholder’s Height: %.1f inches
                Policyholder’s Weight: %.1f pounds
                Policyholder’s BMI: %.2f
                Policy Price: $%.2f
                """,
                policyNumber, providerName, firstName, lastName, age, smokingStatus,
                height, weight, calculateBMI(), calculatePolicyPrice());
    }
}
