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
     *
     * @param policyNumber policy number
     * @param providerName  provider/insurer name
     * @param firstName     policyholder first name
     * @param lastName      policyholder last name
     * @param age           policyholder age in years
     * @param smokingStatus "smoker" or "non-smoker"
     * @param height        policyholder height in inches
     * @param weight        policyholder weight in pounds
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
     
    
    // @return the policy number
    public int getPolicyNumber() { return policyNumber; }
    
    
    // @return the provider name
    public String getProviderName() { return providerName; }
   
     
    //@return the policyholder first name
    public String getFirstName() { return firstName; }
  
    
    //@return the policyholder last name
    public String getLastName() { return lastName; }
    
    
    //@return the policyholder age (years)
    public int getAge() { return age; }
    
    // @return the smoking status ("smoker" or "non-smoker")
    public String getSmokingStatus() { return smokingStatus; }
    
    
    // @return the height (inches)
    public double getHeight() { return height; }
    
    
    //@return the weight (pounds)
    public double getWeight() { return weight; }

    //  Setters (Mutators) 
    
    
    //@param policyNumber new policy number
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
    
    //@param providerName new provider name
    public void setProviderName(String providerName) { this.providerName = providerName; }
    
    //@param firstName new first name
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    //@param lastName new last name
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    //@param age new age (years)
    public void setAge(int age) { this.age = age; }
    
    //@param smokingStatus new smoking status ("smoker" or "non-smoker")
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    
    //@param height new height (inches)
    public void setHeight(double height) { this.height = height; }
    
    //@param weight new weight (pounds)
    public void setWeight(double weight) { this.weight = weight; }

    /**
     * Calculates the BMI of the policyholder.
     * Formula: BMI = (Weight * 703) / (Height^2)
     @return BMI value; 0.0 if height is not positive
     */
    public double calculateBMI() {
        if (height <= 0) return 0.0;
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the total policy price.
     * Avoids stale data.
     * @return total policy price
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
     * @return formatted details string
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
