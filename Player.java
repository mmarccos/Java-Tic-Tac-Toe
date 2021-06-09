/*
 * The Player class for the Tic-Tac-Toe Game
 */
import java.util.Scanner;

public class Player
{
    /* Instance Variables */
    private String name;
    private String symbol;
    private String result;

    /** Creates a Player object. */
    public Player()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name: ");
        this.name = input.nextLine();
        this.symbol = "";
        this.result = "";
    }

    /** Creates a Player object, with the given name. */
    public Player(String n)
    {
        this.name = n;
    }

    /** Returns the Player's name. */
    public String getName()
    {
        return this.name;
    }
    
    /** Returns the Player's result. */
    public String getResult()
    {
        return this.result;
    }

    /** Returns the Player's symbol. */
    public String getSymbol()
    {
        return this.symbol;
    }

    /** Sets the Player's name. */
    public void setName(String n)
    {
        this.name = n;
    }

    /** Sets the Player's symbol. */
    public void setSymbol(String s)
    {
        this.symbol = s;
    }

    /** Sets the Player's result. */
    public void setResult(String r)
    {
        this.result = r;
    }

    /** Asks the Player to enter the position to place their symbol, returns position. */
    public int takeTurn()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Position to Place Symbol:");
        int position = input.nextInt();
        return position;
    }
}