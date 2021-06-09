/*
 * The Game class for the Tic-Tac-Toe Game
 */
import java.util.Scanner;

public class Game 
{
    /* Instance Variables */
    private Player player1;
    private Player player2;

    /** Creates the Game object. */
    public Game()
    {
        System.out.println("----------------------------------------\nRules:\n    * Turn order is determined randomly.\n    * First player picks symbol.\n    * The numbers on the game board are availible spots.\n----------------------------------------");
        player1 = new Player();
        System.out.println("Welcome " + player1.getName() + " to Tic-Tac-Toe!\n----------------------------------------");
        player2 = new Player();
        System.out.println("Welcome " + player2.getName() + " to Tic-Tac-Toe!\n----------------------------------------");   
    }

    /** Sets both player's symbols. */
    public void setPlayerSymbols(Player player1, Player player2)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(player1.getName() + " select symbol: ");
        player1.setSymbol(input.nextLine().toUpperCase());
        while (!(player1.getSymbol().toLowerCase().equals("x")) && !(player1.getSymbol().toLowerCase().equals("o")))
        {
            System.out.println("Please select the symbol X or O.");
            player1.setSymbol(input.nextLine().toUpperCase());
        }
        if (player1.getSymbol().toLowerCase().equals("x"))
        {
            player2.setSymbol("O");
        }
        else
        {
            player2.setSymbol("X");
        }
        System.out.println(player1.getName() + "'s symbol is " + player1.getSymbol() + ".");
        System.out.println(player2.getName() + "'s symbol is " + player2.getSymbol() + ".\n----------------------------------------");
    }

    /** Starts the Game. */
    public void start()
    {
        Scanner input = new Scanner(System.in);
        Player firstPlayer;
        Player secondPlayer;
        boolean play = true;
        String playAgain;

        while (play)
        {
            if ((int) (Math.random() * 2) == 0)
            {
                firstPlayer = player1;
                secondPlayer = player2;
            }
            else
            {
                firstPlayer = player2;
                secondPlayer = player1;
            }

            System.out.println("First player is " + firstPlayer.getName() + ".\nSecond player is " + secondPlayer.getName() + ".\n----------------------------------------");
            setPlayerSymbols(firstPlayer, secondPlayer);
        
            while (true)
            {
                GameBoard.printBoard();
                System.out.print(firstPlayer.getName() + "'s turn, ");

                if (GameBoard.addSymbol(firstPlayer.takeTurn(), firstPlayer.getSymbol()) == true)
                {
                    firstPlayer.setResult("w");
                    System.out.println("----------------------------------------");
                    break;
                }
                else if (GameBoard.getTakenMoves().size() == 9)
                {
                    firstPlayer.setResult("t");
                    System.out.println("----------------------------------------");
                    break;
                }
                System.out.println("----------------------------------------");
            
                GameBoard.printBoard();
                System.out.print(secondPlayer.getName() + "'s turn, ");

                if (GameBoard.addSymbol(secondPlayer.takeTurn(), secondPlayer.getSymbol()) == true)
                {
                    secondPlayer.setResult("w");
                    System.out.println("----------------------------------------");
                    break;
                }
                else if (GameBoard.getTakenMoves().size() == 9)
                {
                    firstPlayer.setResult("t");
                    System.out.println("----------------------------------------");
                    break;
                }
                System.out.println("----------------------------------------");
            }
            GameBoard.printBoard();
            System.out.println("Game Over!");
            System.out.println("----------------------------------------");

            if (firstPlayer.getResult().equals("w"))
            {
                System.out.println(firstPlayer.getName() + " won the game!");
                System.out.println("Better luck next time, " + secondPlayer.getName() + ".");
            }
            else if(secondPlayer.getResult().equals("w"))
            {
                System.out.println(secondPlayer.getName() + " won the game!");
                System.out.println("Better luck next time, " + firstPlayer.getName() + ".");   
            }
            else
            {
                System.out.println("No one won! It was a tie!");
            }
            System.out.println("----------------------------------------");

            System.out.println("Play again? (y/n)");
            playAgain = input.nextLine();

            if (playAgain.toLowerCase().equals("y"))
            {
                System.out.println("Resetting game...");
                GameBoard.resetGame();
            }
            else
            {
                System.out.println("Exiting game, thanks for playing!");
                play = false;
            }
            System.out.println("----------------------------------------");
        }
    }
}