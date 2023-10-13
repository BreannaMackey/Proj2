package cpsc2150.extendedConnectX.models;

public interface IGameBoard{
    // Primary methods 
    public int getNumRows();
    public int getNumColumns();
    public int getNumToWin();
    public void dropToken(char p, int c);
    public char whatsAtPos(BoardPosition pos);
    //Secondary methods
    
        /*
     * Checks if column has available space to accept another token
     *
     * @param [Check if there is availible space for c column]
     *
     * @pre 0 <= c <= MAX.COL
     * @post checkIfFree = [returns true if there is space for another token to be placed and false if there is not space for another token. The top-most row for the column contains a blank space AND boardLength = #boardLength]
     * 
     */
    public default boolean checkIfFree(int c)
    { 
        
        //returns true if the column can accept another token; false otherwise.
            
        for(int i = 0; i < getNumRows(); i++){
            BoardPosition pos = new BoardPosition(i, c);
            if(whatsAtPos(pos) == ' '){
                return true;
            }
            }
            return false;
            
        }
        
        
    
        
      /* if (gameBoard[0][c] == ' '){
                //check if top most row has a blank space
                return true;
            }
            else{
                return false;
            }
        }
 */
       
 
 
    //DEVCOM: if current column is less than MAX_COL return true else false
    
    /*
    *Checks if the player won after placing token
    *
    * @param c [column position that will be checked for a player win as int type]
    *
    * @pre 0 <= c <= MAX.COL
    * 
    * @post checkForWin = [if last token == last token placed to a consecutive win for vertical, horizontal, or diagonal win AND self = #self]
    * @return [returns true if the last token placed in column c results in a win false if not]
     */
    public default boolean checkForWin(int c)
    {
        /*this function will check to see if the last token placed in column c resulted in the player winning the game.
        If so it will return true, otherwise false. Note: this is not checking the entire board for a win, it is just
        checking if the last token placed results in a win. You may call other methods to complete this method */

      BoardPosition latest = new BoardPosition(getNumRows() - 1, c); //we can also use zero
        char lastP = whatsAtPos(latest);

        if(checkHorizWin(latest, lastP) || checkVertWin(latest, lastP) || checkDiagWin(latest, lastP)){
            return true;
        }
        else{
            return false;
        }  


    }

    /*
    *Checks for a tie between players
    * @param None
    * @pre None
    * @post checkTie = [returns true if game all gameboard positions are filled and checkForWin function is false, otherwise returns false]
    * @return [returns true if all game board positions are filled]
     */
    public default boolean checkTie()
    {
        /*this function will check to see if the game has resulted in a tie. A game is tied if there are no free board
        positions remaining. You do not need to check for any potential wins because we can assume that the players
        were checking for win conditions as they played the game. It will return true if the game is tied and
        false otherwise.*/ 
        boolean check = true;
        for(int i = 0; i < getNumColumns(); i++){
            if(checkForWin(i) == true){
                check = false;
            }
        }
        return check;
    }

        
    

    public default boolean checkHorizWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in
        a row horizontally. Returns true if it does, otherwise false*/
        int row = pos.getRow();
        int column = pos.getColumn();
        int numToWin = getNumToWin();
        int counter = 0;

            for(int i = -numToWin + 1; i < numToWin; i++){
                int colCheckR = column + i;
                if(colCheckR >= 0 && colCheckR <= getNumColumns() && whatsAtPos(new BoardPosition(row, colCheckR)) == p){
                    counter ++;
                    
                }
                else{
                    counter = 0;
                }
                if(counter >= numToWin){
                    return true;
                }
            }
            for(int j = -numToWin + 1; j < numToWin; j++){
                int colCheckL = column - j;
                if(colCheckL >= 0 && colCheckL <= getNumColumns() && whatsAtPos(new BoardPosition(row, colCheckL)) == p){
                    counter ++;
                }
                else{
                    counter = 0;
                }
                if(counter >= numToWin){
                    return true;
                }
            }
               /* if(counter == numToWin - 1){
                    return true;
                }
                else{
                    return false;
                }
                 */
                
                return false;
            }


            
        /*for (row = 0; row < getNumRows() - 2; row++){
            for(column = 0; column < getNumColumns() -2; column++){
               if(row == p && column == p && column + 1 == p && column +2 == p && column + 3 == p){
                   return true;
               }
               
               else{
                    return false;
                }
            }
        }
        */
        
    

    /*
     *Checks if there is 5 in a vertical line win
     *
     * @param pos [position of token based on BoardPosition]
     * @param p [player as character type]
     *
     * @pre p =! ' ' [character p cannot equal a blank space]
     *
     * @post checkVertWin = [if last token placed makes 5 in a row vertically return true, otherwise return false] AND self = #self
     * @return [If there is a vertical win return true, otherwise return false]
     */
    public default boolean checkVertWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
        vertically. Returns true if it does, otherwise false*/
        int row = pos.getRow();
        int column = pos.getColumn();
        int numToWin = getNumToWin();
        int counter = 0;

            for(int i = 0; i <= numToWin; i++){ //For loop for iterating down the column
                int rowCheckD = row + i;
                if(rowCheckD >= 0 && rowCheckD <= getNumRows() && whatsAtPos(new BoardPosition(rowCheckD, column)) == p){ //check to make sure player is X or O
                    counter ++;
                    //raise the number for how many are in a row
                }
                else{
                    break;
                }
            }

                if(counter == numToWin - 1){
                    return true;
                }
                else{
                    return false;
                }
                }

      /*  for (row = 0; row < getNumRows() - 4; row++){
            for(column = 0; column < getNumColumns(); column++){
                if (row == p && row + 1 == p && row + 2 == p && row + 3 == p && column == p){
                    return true;
                }
              
                else{
                    return false;
                }

            }
        }*/

        


    
        /*
     * Checks if there is 5 in a diagonal line win
     *
     * @param pos position of token based on BoardPosition
     * @param p player as character type
     *
     * @pre p =! ' ' [character p cannot equal a blank space]
     *
     * @post checkDiagWin = [Returns ' ' AND self = #self]
     * @return [True if there is a diagonal win, otherwise retrun false]
     */
    public default boolean checkDiagWin(BoardPosition pos, char p)
    {
        int numToWin = getNumToWin();

            int[][] directions = {
                {1, 1},  // bottom-right
                {1, -1}, // bottom-left
                {-1, 1}, // top-right
                {-1, -1} // top-left
            };
        
            for (int[] dir : directions) {
                int row = pos.getRow();
                int col = pos.getColumn();
                int counter = 1;
                
            
                for (int i = 1; i < numToWin; i++) {
                    int newRow = row + dir[0] * i;
                    int newCol = col + dir[1] * i;
                    
                    if (newRow >= 0 && newRow <= 8 && newCol >= 0 && newCol <= 7) {
                        if (isPlayerAtPos(new BoardPosition(newRow, newCol), p)) {
                            counter++;
                        } else {
                            break;
                        }
                    } else {
                        break; // Stop if outside the board bounds
                    }
                }
                
                if (counter == numToWin) {
                    return true; 
                }
            }
        
            return false; 
                
    }

        /** 
    * @param pos [an object of board position]
    * @param player [The character that the player has chosen]
    * 
    * @pre [player must be a character]
    * @post isPlayerAtPos = [self = #self, The state of GameBoard is unchanged]
    * @return returns true if player is at position false if not
    * 
    */
    public default boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        /*returns true if the player is at pos; otherwise, it returns false. Note: this method will be implemented very
        similarly to whatsAtPos, but it's asking a different question. We only know they will be similar because we
        know GameBoard will contain a 2D array. If the data structure were to change in the future,
        these two methods could be radically different.*/
        return whatsAtPos(pos) == player;
        

    }

}
