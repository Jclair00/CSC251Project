public class PolicyHolder {

    // Fields that belong to the PERSON
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;   // "smoker" or "non-smoker"
    private double height;          // in inches
    private double weight;          // in pounds

    // No-arg constructor
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    // Full constructor
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }

    // BMI calculation (moved from Policy)
    public double calculateBMI() {
        if (height <= 0) {
            return 0.0;
        }
        return (weight * 703) / (height * height);
    }
    
    @Override
    public String toString() {
       return String.format(
            "Policyholder's First Name: %s%n%n" +
            "Policyholder's Last Name: %s%n%n" +
            "Policyholder's Age: %d%n%n" +
            "Policyholder's Smoking Status (Y/N): %s%n%n" +
            "Policyholder's Height: %.1f inches%n%n" +
            "Policyholder's Weight: %.1f pounds%n%n" +
            "Policyholder's BMI: %.2f%n%n",
            firstName,
            lastName,
            age,
            smokingStatus,
            height,
            weight,
            calculateBMI()
    );
}

}
