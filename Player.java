import java.util.Scanner;
import java.util.HashMap;
/**
 * Player class stores details of player like name , prize , priceworth and moneyspend
 * 
 * @Anjali Varghese
 * @created on 30/08/2017
 */
public class Player
{
    private String name;
    private HashMap prize = new HashMap();
    private int prizeworth;
    private int moneyspend;

    public Player()
    {
       name = " ";               //intialise name to null
       prizeworth = 0;           //intialise prizeworth to null
       moneyspend = 0;           //intialise moneyspend to null
       prize = new HashMap<String,Integer>();       //initialising hashmap
    }
    
    //Method to get the Moneyspend
    public int getMoneyspend()
    {
        return moneyspend;
    }
    
    //Method to get the player name
    public String getName()
    {
        return name;
    }
    
    //Method to get the Prize
    public HashMap<String,Integer> getPrize()
    {
        return prize;
    }
    
    //Method to get the Prizeworth
    public int getPrizeworth()
    {
        return prizeworth;
    }

    //Method to set the Moneyspend
    public void setMoneyspend(int newMoneyspend)
    {
        moneyspend = newMoneyspend;
    }
    
    //Method to set the player name
    public void setName(String newName)
    {
        name = newName;
    }
    
    //Method to set the prize 
    public void setPrize(HashMap<String,Integer>newPrize)
    {
        prize = newPrize;
    }
    
    //Method to set the Prizeworth 
    public void setPrizeworth(int newPrizeworth)
    {
        prizeworth = newPrizeworth;
    }

}
