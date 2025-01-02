package unruly;
public class Board {
    
    protected int rows;
    protected int cols;
    char[][] tiles;

    public Board(int rows,int cols){
        this.rows = rows;
        this.cols = cols;

        this.tiles = new char[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                this.tiles[i][j] = '.';
            }
        }
    }

    
}
