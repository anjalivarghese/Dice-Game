import java.util.*;    
/**
 * Game class displays the menu,
 *lets players select the options they want to choose to play , 
 *contains the methods that creates a player , checks if the guess is correct 
 *and decides the price that the player has won 
 *it also computes the prizes and the money spend by the player 
 * @Anjali Varghese
 * @created on 18/08/2017
 */
public class Game
{
    String choice;
    Player player;
    Prize prize;
    Scanner console; 
    LuckyGuessGenerator trial;
    int count;

    public Game()
    {
        choice = " ";
        console = new Scanner(System.in);
        trial = new LuckyGuessGenerator();      //LuckyGuessGenrator object 
        count = 0;
    }

    //Display menu print that shows the options the player has 
    public void displayMenu()
    {
        do
        {    
            System.out.print("\n ---------------------------------------------------MENU------------------------------------------------\n");
            System.out.print("                                      Welcome to the Lucky Vending Machine                             \n");
            System.out.print("=======================================================================================================\n");
            System.out.print("                                            \n(1) Set Up New Player                                    \n");
            System.out.print("                                                \n(2) Guess A Prize                                    \n");
            System.out.print("                                      \n(3) What Have I Won So Far?                                    \n");
            System.out.print("                                            \n(4) Display Game Help                                    \n");
            System.out.print("                                                    \n(5) Exit Game                                    \n");
            System.out.println("                                               \nEnter your choice:                                    ");
            choice = console.nextLine();

            if(!isStringnumeric(choice.trim()))     //to check if the choice is between 1 and 5 
                System.out.println("\n YOU have not entered a number between 1-5!!! Please enter a number again ");
            else
            {
                switch (choice)
                {
                    case "1" :
                    playerDetails();        //method to input player details
                    break;
                    
                    case "2" :
                    guessPrice();           //method to guess a price
                    break;
                    
                    case "3" :
                    status();               //method to check the current status of prices won 
                    break;
                    
                    case "4" :
                    instructions();         //method to show game instructions
                    break;
                    
                    case "5" :        
                    System.out.println("\n Thank you , You have exited the game");
                    break;
                    
                    default:
                    System.out.print("\n Invalid option ! Please Enter your choice again:"); 
                }
            }
        }
        while(!choice.equals("5"));     //checks if the choice is  less than 5 and repeats the menu 
    }

    //method to guess a number and to check if the player has won 
    private void guessPrice()
    { 
        int number = 0;
        String guessedNumber = " ";
        int moneySpend = 0;

        if(player == null)      //checks if the player has been setup
            System.out.println("\n ERROR : Player has not been set up !! Please set up a player to play \n ");
        else
        {
            System.out.println("\n Guess a price between 1-5:");
            guessedNumber = console.nextLine();

            if(!isStringnumeric(guessedNumber.trim()))      //evaluates if the guessed number is between 1-5
                System.out.println("\n YOU have not entered a number between 1-5 !!! Please enter a number again ");
            else
            {
                System.out.println("\n Your guess is "+guessedNumber);
                
                number = trial.numberGenerator();       //random number is guessed 
                System.out.println("\n My guess is "+number);

                moneySpend = player.getMoneyspend()+Integer.parseInt(guessedNumber);        //to calculate the money spend by the player 
                player.setMoneyspend(moneySpend);                                           //the money spend by the player is set to the player class 

                if (Integer.parseInt(guessedNumber) == number)                              //to compare of the guess by the player and the random number generated is the same 
                {
                    System.out.println("\n Wow ! You are lucky ! You have won "+prize.prize(guessedNumber));
                    checkPrize(guessedNumber);    
                }
                else
                    System.out.println("\n Oops! Looks like you have no luck ! You lose \n ");
            }
        }
    }
    
    //method to determine which prize the player  has won 
    private void checkPrize(String guessedNumber)
    {   
        int prizeWorth = 0;
        HashMap prizes = new HashMap<String,Integer>();         //hasmap to input the prizes won 
        
        prizeWorth = player.getPrizeworth()+(prize.prizeWorth(guessedNumber));     //to determine the prizeworth that the player gets
        player.setPrizeworth(prizeWorth);
        
        prizes=player.getPrize();
        
        if(prizes.get(prize.prize(guessedNumber)) == null)
        {
            prizes.put(prize.prize(guessedNumber),1);
            count = 1;
        }
        else
        {
            count=count+1;
            prizes.put(prize.prize(guessedNumber),count);
        }
        
        player.setPrize(prizes);
    }
    
    //method to set up a new player and enter the name
    private void playerDetails()
    {   
        System.out.print("\n Enter name of Player:");
        String name = console.nextLine(); 
        if(!isNameaccepted(name.trim()))        //to check if the name only contains alphabets 
            System.out.println("\n Name entered not accepted !! Please enter a name consisting only of Alphabets ");
        else
        {
            player = new Player(); //new player object
            prize = new Prize();
            player.setName(name.trim());        //to remove spaces before after the name 
            System.out.println("\n Welcome to the GAME " +player.getName());
        }
    }

    //to print the instructions that the player has to follow to play the game 
    private void instructions()
    {
        System.out.println("Welcome to the help section of Lucky Vending Machine");
        System.out.println("\n----------------------INSTRUCTIONS------------------");
        
        System.out.println("\nWhen you open the game you can see five options on the screen");
        System.out.println("\n 1)Chose option 1 to set up a player.If you do not set up a player you cannot play the game");
        System.out.println("\n 2)Chose option 2 to Guess a price . Select a number between 1 to 5. ");
        System.out.println("\n 3)If the number that you have guessed matches the lucky machine number , then you win !!");
        System.out.println("\n The following are the prices that you can win depending on the number you have guessed:");
        System.out.println("\n  Number Generated   |  Price won   |    Price Worth  |  Cost to Player ");
        System.out.println("          1          |     Pen      |       10$       |      1$          ");
        System.out.println("          2          |     Book     |       20$       |      2$          ");
        System.out.println("          3          |     DVD      |       30$       |      3$          ");
        System.out.println("          4          |     Mouse    |       40$       |      4$          ");
        System.out.println("          5          |     Keyboard |       50$       |      5$          ");
        System.out.println("\n 4)Chose option 4 to know the prices that you have won and their money worth . You can also know the amount that you have spend till now.");
        System.out.println("\n 5)Chose option 5 to exit the game.");
    } 

     //to check if the string entered only contains alphabets 
    private boolean isNameaccepted(String name)
    {

        if (name.length() == 0)     //to check the length of the string 
            return false;
        int i = 0;
        while (i < name.length())
        {
            if (name.charAt(i) == '\n')     //to check if the input is enter
                return false;
            else
            if (!(Character.isLetter(name.charAt(i)) || name.charAt(i) == ' '))    
                return false;
            i++;
        }
        return true;
    }

    //to check if the string entered has only numbers between 1-5
    private boolean isStringnumeric(String y)
    {
        if (y.length() != 1)        //to check the length of the string 
            return false;
        if (y.charAt(0)< '1' || y.charAt(0) > '5')  
            return false;
        else
            return true;
    }
    
    //to display the current winnings of the player 
    private void status()
    {
        if(player == null)      //to check if the player has been set up 
            System.out.println("ERROR : Player has not been set up !! Please set up a player to play \n ");
        else
        {
            if(player.getPrize().isEmpty())     //to check if Prize hashmap is empty 
                System.out.println("\n Sorry you have not won anything yet \n");
            else
           {
           
               Set<String> set = player.getPrize().keySet();       //to get the unique Keys of the hashmap 
        
               System.out.println("Hey " +player.getName() +" CONGRATS !!\n");
               System.out.println("You have won the following prizes \n");
               for ( String key : set)             //to print the prizes won so far
               {
                   int value = player.getPrize().get(key);
                   System.out.println(key +" "+ value + "\n");
               }
           }
           System.out.println("Your prizes are worth: " + player.getPrizeworth() + "\n");      //to show the worth of the Orizes that the player has won
           System.out.println("You have spend an amount of : " + player.getMoneyspend() + "\n");      //to show the money that the player has spend 
        }
    }
}