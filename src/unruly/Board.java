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

    public char getTile(int row, int col){
        return tiles[row][col];
    }

    public void setTile(int row,int col,char value){
        this.tiles[row][col] = value;
    }
    
    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getCols(){
        return cols;
    }

    public void setCols(int cols){
        this.cols = cols;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (char[] row : tiles) {
            for (char ch : row) {
                builder.append(ch == '.' ? '.' : ch);
            }
            builder.append(System.lineSeparator()); // Newline after each row
        }
        return builder.toString();
    }


    
}
