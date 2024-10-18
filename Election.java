import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Election {
    static Scanner input = new Scanner(System.in);
    private String name ;
    private String fatherName;
    private String address;
    private long phoneNo;
    private boolean hasVoted;

    // Prompt for age
    // Call ageLimit(age)

    public void voteNow(){

        System.out.println("Fill the given details in the below section");
        System.out.print("Enter the Age :");
        int a = input.nextInt();
        input.nextLine();
        ageLimit(a);

    }

    // If age >= 18, call details()
    // Else, display "not eligible"

    void ageLimit(int age) {
         if(age>=18) {
            details();
         }
         else {
             System.out.println("Sorry you are not eligible for the voting...");
             System.out.println("---------------------------------------------");
         }
    }

    // Collect name, father's name, address, phone number
    // Check phone number length
    // If valid, call DisplayUserDetail()
    // Else, display "invalid phone number"

     void details() {
        System.out.print("Please enter the Name : ");
        this.name =input.nextLine();
        System.out.print("Enter your Father name : ");
        this.fatherName = input.nextLine();
        System.out.print("Enter Your Address : ");
        this.address = input.nextLine();
        System.out.print("Enter your Phone Number : ");
        this.phoneNo = input.nextLong();
        input.nextLine();

        String phoneNoStr = String.valueOf(this.phoneNo);
        System.out.println("---------------------------------");
        if(phoneNoStr.length() ==10){
            System.out.println("Your Phone number is valid.... ");
            DisplayUserDetail();
        }
        else{
            System.out.println("Invalid Phone Number, its must contains of 10 digits number...");
        }
    }


    // Display collected details
    // Ask if user wants to continue
    // If yes, call votingParties()
    // Else, display "continue next time"

    void DisplayUserDetail(){
        System.out.println("---------------------------------");
        System.out.println("Name :" + this.name);
        System.out.println("Father Name : " + this.fatherName);
        System.out.println("Address : " + this.address);
        System.out.println("Phone Number : " + this.phoneNo);
        System.out.println();

        hasVoted =false;

        System.out.println("Do you want to continue (Y/N) ?");
        String confirmation = input.nextLine();
        if(confirmation.equalsIgnoreCase("Y")){
            votingParties();
        }
        else {
            System.out.println("Ok continue next time...");
        }
    }

    // Create a list of parties
    // Create a map to count votes
    // Loop to collect votes until 'exit' is entered
    // If valid party, increment vote count
    // Ask if user wants to see results
    // If yes, display vote counts for each party

    void votingParties() {
        ArrayList<String> party = new ArrayList<>();

        party.add("DMK");
        party.add("AIADMK");
        party.add("BJP");
        party.add("INC");
        party.add("TNCC");
        party.add("DMDK");
        party.add("MNM");

        HashMap<String , Integer> comp = new HashMap<String, Integer> ();

        for(String p : party){
            comp.put(p.toLowerCase(),0);
        }

        String vote ;
        System.out.println("Vote for your favorite party!. Type 'exit' to stop voting!... ");
        System.out.println("The following parties are participating in the election:\n- DMK\n- BJP\n- INC\n- TNCC\n- DMDK\n- MNM");

        while(true) {
            System.out.print("Enter your party name : ");
            vote = input.nextLine().trim().toLowerCase();


            if (vote.equalsIgnoreCase("exit")) {
                break;
            }
            if (comp.containsKey(vote)) {
                comp.put(vote, comp.get(vote) + 1);
                System.out.println("Thanks for voting " + vote + "!");
                hasVoted = true;
                break;
            }
            else {
                System.out.println("Invalid party name!. Please try again...");
            }
        }

        System.out.print("Do you want to see the result ? (Y/N)");
        String resultDisplay = input.nextLine();
        if(resultDisplay.equalsIgnoreCase("y")) {
            System.out.println("/nDisplaying voting result!");
            for(String p : party) {
                System.out.println(p + " : " + comp.get(p) + " votes");
                System.out.println("Thank you for participating! ...");
            }
        }
        else {
            System.out.println("Thank you for participating! ...");
        }
    }

    public static void main(String[] args) {

        // Create Election object
        // Loop to ask if user wants to vote
        // If yes, call voteNow()
        // Else, display "continue next time"

        Election obj = new Election();
        while(true) {
            System.out.print("Do you want to vote (Y/N) ? ");
            String option = input.nextLine();
            if(option.equalsIgnoreCase("Y")){
                obj.voteNow();
            }
            else{
                System.out.println("Ok Continue next time...");
                System.out.println("--------------------------------------------");
                break;
            }
        }

    }

}
