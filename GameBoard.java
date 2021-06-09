/*
 * The GameBoard class for the Tic-Tac-Toe Game
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard
{
    /* Instance Variables */
    private static String[][][] board = {{{"1"}, {"|"}, {"2"}, {"|"}, {"3"}}, 
                                         {{"-"}, {"+"}, {"-"}, {"+"}, {"-"}}, 
                                         {{"4"}, {"|"}, {"5"}, {"|"}, {"6"}}, 
                                         {{"-"}, {"+"}, {"-"}, {"+"}, {"-"}}, 
                                         {{"7"}, {"|"}, {"8"}, {"|"}, {"9"}}};
    
    private static ArrayList<Integer> takenMoves = new ArrayList<Integer>(); 

    /** Resets the Game Board and taken moves Arraylist. */
    public static void resetGame()
    {
        board[0][0][0] = "1";
        board[0][2][0] = "2";
        board[0][4][0] = "3";
        board[2][0][0] = "4";
        board[2][2][0] = "5";
        board[2][4][0] = "6";
        board[4][0][0] = "7";
        board[4][2][0] = "8";
        board[4][4][0] = "9";
        
        takenMoves.clear();
    }

    /** Prints the Game Board. */
    public static void printBoard()
    {
        for (String[][] row : board)
        {
            for (String[] pieces : row)
            {
                for (String piece : pieces)
                {
                    System.out.print(piece);
                } 
            }
            System.out.println();
        }
    }

    /** Checks if someone has Tic-Tac-Toe. */
    public static boolean gameEnd(String symbol)
    {
        if ((board[0][0][0].equals(symbol) && board[0][2][0].equals(symbol) && board[0][4][0].equals(symbol)) 
         || (board[2][0][0].equals(symbol) && board[2][2][0].equals(symbol) && board[2][4][0].equals(symbol)) 
         || (board[4][0][0].equals(symbol) && board[4][2][0].equals(symbol) && board[4][4][0].equals(symbol)) 
         || (board[0][0][0].equals(symbol) && board[2][0][0].equals(symbol) && board[4][0][0].equals(symbol))
         || (board[0][2][0].equals(symbol) && board[2][2][0].equals(symbol) && board[4][2][0].equals(symbol))
         || (board[0][4][0].equals(symbol) && board[2][4][0].equals(symbol) && board[4][4][0].equals(symbol))
         || (board[0][0][0].equals(symbol) && board[2][2][0].equals(symbol) && board[4][4][0].equals(symbol))
         || (board[4][0][0].equals(symbol) && board[2][2][0].equals(symbol) && board[0][4][0].equals(symbol)))
         {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    /** Adds the Player's symbol at the given position. */
    public static boolean addSymbol(int position, String symbol)
    {
        Scanner input = new Scanner(System.in);

        while (takenMoves.contains(position))
        {
            System.out.println("Please enter an availble position.");
            position = input.nextInt();
        }

        takenMoves.add(position);

        switch (position)
        {
            case 1:
                board[0][0][0] = symbol;
                break;
            case 2:
                board[0][2][0] = symbol;
                break;
            case 3:
                board[0][4][0] = symbol;
                break;
            case 4:
                board[2][0][0] = symbol;
                break;
            case 5:
                board[2][2][0] = symbol;
                break;
            case 6:
                board[2][4][0] = symbol;
                break;
            case 7:
                board[4][0][0] = symbol;
                break;
            case 8:
                board[4][2][0] = symbol;
                break;
            case 9:
                board[4][4][0] = symbol;
                break;
        }
        return gameEnd(symbol);
    }

    /** Returns the ArrayList containing taken moves. */
    public static ArrayList<Integer> getTakenMoves()
    {
        return takenMoves;
    }
}