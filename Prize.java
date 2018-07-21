import java.util.HashMap;
import java.util.Map;
/**
 * Prize class determines the prizes and the prizeworth of the wins 
 *
 * @author Anjali Varghese
 * @version 05/09/2017
 */
public class Prize
{

    //Method to find the prize that the player has won
    public String prize(String number)
    {
        HashMap<String, String> prize = new HashMap<String, String>();

        prize.put("1", "Pen");      //putting prizes in hashmap 
        prize.put("2", "Book");
        prize.put("3", "DVD");
        prize.put("4", "Mouse");
        prize.put("5", "Keyboard");
        
        return prize.get(number);       //returning the corresponding prize
    }
   
    //Method to find the prizeworth of the win 
    public int prizeWorth(String number)
    {
        HashMap<String,Integer > prizeWorth = new HashMap<String,Integer >();

        prizeWorth.put("1",10);     //putting prizeworth in hashmap 
        prizeWorth.put("2",20);
        prizeWorth.put("3",30);
        prizeWorth.put("4",40);
        prizeWorth.put("5",50);
        
        return prizeWorth.get(number);      //returning the corresponding prizeworth
    }
    
}
