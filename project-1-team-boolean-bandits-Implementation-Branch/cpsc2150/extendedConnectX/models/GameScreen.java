package cpsc2150.extendedConnectX.models;
import java.util.Scanner;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Gabriel Hillesheim @ghilles23


 */
public class GameScreen {

  private GameBoard conectX = new GameBoard();
        
    /*public static void main(String[] args)
    {  
     


      GameBoard gameBoard = new GameBoard();
        Scanner Input = new Scanner(System.in);
        char PlayerX = 'X';
         GameScreen newGame = new GameScreen();
        
         System.out.print(newGame.conectX);
         System.out.print("Enter a Column player X: ");
         int chosenCol = Input.nextInt(); 

         if(chosenCol >= 0 && chosenCol < gameBoard.getNumColumns()){
            gameBoard.dropToken(PlayerX, chosenCol);
         }
         else{
            System.out.println("invalid choice");
         }
        
          System.out.println(gameBoard);
        }*/
        private static GameBoard gameBoard = new GameBoard();
        public static void main(String[] args) {
            
            Scanner input = new Scanner(System.in);
            char currentPlayer = 'X';
    
            while (true) {
                System.out.println(gameBoard);
                System.out.print("Enter a Column for Player " + currentPlayer + ": ");
                int chosenCol = input.nextInt();
    
                if (chosenCol >= 0 && chosenCol < gameBoard.getNumColumns()) {
                    if (gameBoard.checkIfFree(chosenCol)) {
                        gameBoard.dropToken(currentPlayer, chosenCol);

                        // Switch to the other player
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    } else {
                        System.out.println("Column is full. Please choose a different column.");
                    }
                } else {
                    System.out.println("Invalid column choice. Please choose a valid column.");
                }
                
            }
        }

    
}