/**
 * The Policy class models an insurance policy for one person.
 */

public class Policy {

   // Instance variables (attributes)
   private int policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;
   private static int policyCount = 0;

   /**
    * No-arg constructor to default
    */
   public Policy() {
      policyNumber = 0;
      providerName = "";
      policyHolder = new PolicyHolder();
      policy count++;
   }

   /**
    * Constructor that accepts arguments
    */
   public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.policyHolder = new PolicyHolder(
         policyHolder.getFirstName(),
         policyHolder.getLastName(),
         policyHolder.getAge(),
         policyHolder.getSmokingStatus(),
         policyHolder.getHeight(),
         policyHolder.getWeight()
         );
         
         policyCount==;
   }

   //  Getters (Accessors) 
   public int getPolicyNumber() { 
      return policyNumber; }
   public String getProviderName() { 
      return providerName; }
   public PolicyHolder getPolicyHolder() {
      return policyHolder;}
   public static int getPolicyCount() { 
      return policyCount; }
      

   //  Setters (Mutators) 
   public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
   public void setProviderName(String providerName) { this.providerName = providerName; }
  
  
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
      return String.format(
             """
             Policy Number: %d
             Provider Name: %s
             Policy Price: $%.2f
             """,
             policyNumber, providerName, policyHolder.toString(), calculatePolicyPrice()
     );
   }
}
