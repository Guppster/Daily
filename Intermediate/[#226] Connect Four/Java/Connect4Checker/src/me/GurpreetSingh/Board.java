package me.GurpreetSingh;

public class Board
{
    private Player[][] field;       //Stores the playing field
    private int[] columnHeight;     //Stores the highest lowest in each column of field

    /**
     * Le Constructor
     */
    public Board(int x, int y)
    {
        field = new Player[x][y];
        columnHeight = new int[y];
    }//End of constructor

    /**
     * Gets the player at a specific location
     */
    public Player getPlayerAt(int col, int row)
    {
        return field[col][row];
    }//End of getPlayerAt

    /**
     * Places a player in the specified column.
     */
    public boolean placePlayerInColumn(int x, Player player)
    {

        columnHeight[x]++;
        field[x][columnHeight[x]] = player;
        return checkforWin(x, player);
    }//End of placePlayerInColumn

    private boolean checkforWin(int x, Player player)
    {
        try{
            return  //RIGHT
                    ((field[x+1][columnHeight[x]] == player) &&
                            (field[x+2][columnHeight[x]] == player) &&
                            (field[x+3][columnHeight[x]] == player)) ||
                    //LEFT
                            ((field[x-1][columnHeight[x]] == player) &&
                                    (field[x-2][columnHeight[x]] == player) &&
                                    (field[x-3][columnHeight[x]] == player)) ||
                     //UP
                            ((field[x][columnHeight[x]+1] == player) &&
                                    (field[x][columnHeight[x]+2] == player) &&
                                    (field[x][columnHeight[x]+3] == player)) ||
                    //DOWN
                            ((field[x][columnHeight[x]-1] == player) &&
                                    (field[x][columnHeight[x]-2] == player) &&
                                    (field[x][columnHeight[x]-3] == player)) ||
                    //UP RIGHT
                            ((field[x+1][columnHeight[x]+1] == player) &&
                                    (field[x+2][columnHeight[x]+2] == player) &&
                                    (field[x+3][columnHeight[x]+3] == player)) ||
                    //DOWN RIGHT
                            ((field[x-1][columnHeight[x]-1] == player) &&
                                    (field[x-2][columnHeight[x]-2] == player) &&
                                    (field[x-3][columnHeight[x]-3] == player)) ||
                    //UP LEFT
                            ((field[x-1][columnHeight[x]+1] == player) &&
                                    (field[x-2][columnHeight[x]+2] == player) &&
                                    (field[x-3][columnHeight[x]+3] == player)) ||
                    //DOWN LEFT
                            ((field[x-1][columnHeight[x]-1] == player) &&
                                    (field[x-2][columnHeight[x]-2] == player) &&
                                    (field[x-3][columnHeight[x]-3] == player)) ||
                    //2 <- 1 ->
                            ((field[x-1][columnHeight[x]] == player) &&
                                    (field[x-2][columnHeight[x]] == player) &&
                                    (field[x+1][columnHeight[x]] == player)) ||
                    //1 <- 2 ->
                            ((field[x-1][columnHeight[x]] == player) &&
                                    (field[x+1][columnHeight[x]] == player) &&
                                    (field[x+2][columnHeight[x]] == player)) ||
                    //1 down left 2 up right
                            ((field[x-1][columnHeight[x]-1] == player) &&
                                    (field[x+1][columnHeight[x]+1] == player) &&
                                    (field[x+2][columnHeight[x]+2] == player)) ||
                    //2 down left 1 up right
                            ((field[x-1][columnHeight[x]-1] == player) &&
                                    (field[x-2][columnHeight[x]-2] == player) &&
                                    (field[x+1][columnHeight[x]+1] == player)) ||
                    //1 up left 2 down right
                            ((field[x-1][columnHeight[x]+1] == player) &&
                                    (field[x+1][columnHeight[x]-1] == player) &&
                                    (field[x+2][columnHeight[x]+2] == player)) ||
                    //2 up left 1 down right
                            ((field[x-1][columnHeight[x]+1] == player) &&
                                    (field[x-2][columnHeight[x]+2] == player) &&
                                    (field[x+1][columnHeight[x]-1] == player));
        }catch(ArrayIndexOutOfBoundsException ignored){}
        return false;
    }
}//End of board
