
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Random;

public class DiceGame {
  
    //Main Die class 
    static class Die {
      private Random random;
      private int sides;
    
    //Default constructor     
    public Die() {
     sides = 6;
     random = new Random();
    }
    
    //Paramaterized constructor
    public  Die(int sides) {
      this.sides = sides;
      random = new Random();
      if (sides < 4) {
        throw new IllegalArgumentException("A Die cannot have less than 4 sides");
      } return;
    }
    
    //Method to get num sides 
    public int getNumSides() { 
        return sides;
    }
    
    //Method to roll the dice 
    public int roll() {
      return random.nextInt(sides) +1;
    }
    
    }
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        //Ask user how many faces die 2 should have 
        System.out.println("How many sides should the second die have?");

        //Storing user response in die2 variable
        int die2 = input.nextInt();

        //Ask user how many times to roll the dice 
        
         System.out.println("How many times should we roll the dice?");

        //Store response in rollCount variable
        int rollCount = input.nextInt();

        //Ask user how often to display results 
         System.out.println("How often should we print results?");

         //Store response in results variable 
        int results = input.nextInt();

        //Flush lingering eol character 
        input.nextLine(); 

        //Get users name 
         System.out.println("What is your name?");

        //Users name variable 
         String uName = input.nextLine();

        //Display experiment by user name, only displaying the first 5 characters of name 
         String cutString = uName.substring(0,5);
        System.out.println("\nExperiment by: " + cutString);
        
        //Close Scanner
        input.close();

        //Calling default constructor 
           Die dice = new Die();
            // System.out.println(dice.getNumSides());

        //Calling paramaterized constructor 
            Die dice2 = new Die(die2);
            // System.out.println(dice2.getNumSides());
        
        //Roll counter variable 
        int counter = 0; 
        float total = 0; 
       

        //While loop to continue rolling dice until user designated rolls is met 
        while (counter <= rollCount) {
            dice.roll();
            dice2.roll();
            counter++;

        //Creating sum variable to calculate dice sum
            int sum = dice.roll() + dice2.roll(); 

         //Conditions for how much money is won or lost 

         //Sum less than 5,  user wins $3
            if (sum < 5) {
                total += 3;
                }
        //Sum equals 5, user wins $8
             else if (sum == 5) {
                 total += 8;
                 }
        //sum greater than 5, user loses $2
             else if (sum > 5) {
                total -= 2;
                 }

        //Display results at designated rolls 
             if (counter % results == 0 ) {
                 //Convert total winnings to proper currency formatting 
                 NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
                 System.out.println("Rolls: " + counter +"   Average winning per roll: " + defaultFormat.format(total / counter));
             }
}
    }
}

