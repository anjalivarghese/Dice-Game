import java.util.Random;
/**
 * LuckyGuessGenerator Class generates a random number between 1-5
 *
 * @Anjali Varghese
 * @created on 30/08/2017
 */
public class LuckyGuessGenerator
{
    Random rand = new Random();
    private int randomNumber;

    public LuckyGuessGenerator()
    {
        randomNumber = 0;      // initialising value to 0
    }

    //numberGenerator method generates a random number between 1 and 5 using the Math.random function
    public int numberGenerator()
    {
        return 1 + (int)(Math.random() * 5);       // generates a random number between 1 and 5 
    }
}
