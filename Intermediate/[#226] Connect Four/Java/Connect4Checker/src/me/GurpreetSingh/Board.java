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
    public void placePlayerInColumn(int x, Player player)
    {
        columnHeight[x]++;
        field[x][columnHeight[x]] = player;
    }//End of placePlayerInColumn
}//End of board
