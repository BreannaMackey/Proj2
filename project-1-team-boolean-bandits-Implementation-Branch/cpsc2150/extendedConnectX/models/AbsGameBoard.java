package cpsc2150.extendedConnectX.models;

public abstract class AbsGameBoard implements IGameBoard{
    
         /** 
    * Returns a string of the gameBoard object
    * @pre None
    * @post toString = [self = #self, The state of the GameBoard is unchanged]
    * @return [String representing the state of the GameBoard]
    */
    @Override
    public String toString(){
        String connectBoard = "";
        for(int i = 0; i <= getNumColumns() - 1; i++){
           connectBoard += "|" + i ;
        } 
        connectBoard += "|\n";
         for(int i = getNumRows() - 1; i >= 0; i--){
                connectBoard +="|";
            for(int j = 0; j < getNumColumns(); j++){
                    BoardPosition pos = new BoardPosition(i, j);
                    //connectBoard += " " + (whatsAtPos(pos)) + " |";
                    connectBoard += (whatsAtPos(pos)+ "|");

                }
                connectBoard += "\n";
            
            }
            return connectBoard.toString();
        } 
        
}