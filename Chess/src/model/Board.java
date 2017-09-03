package model;

public class Board {
    private final int dimension = 8;
    private Tile[][] tiles;

    public Board() {
        tiles = new Tile[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                tiles[i][j] = new Tile(i, j);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < dimension; i++)
            sb.append("__");
        sb.append("\n");

        for (int i = dimension - 1; i >= 0; i--) {
            sb.append(i + 1 + "|");
            for (int j = 0; j < dimension; j++)
                sb.append(tiles[i][j] + " ");
            sb.append("\n");
        }
        sb.append("  ");
        char col = 'A';
        for (int i = 0; i < dimension; i++, col++)
            sb.append(col + " ");

        return sb.toString();
    }

    public Tile getTile(int row, int col) {
        try {
            return tiles[row][col];
        } catch (Exception e) {
            System.err.println("Wrong index for board tile.");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Tile getTile(String tile) throws Exception {
        if (tile.length() == 2) {
            tile = tile.toUpperCase();
            char colChar = tile.charAt(0);
            char rowChar = tile.charAt(1);
            if (colChar < 'A' || colChar > 'H' || rowChar < '1' || rowChar > '8')
                throw new Exception("Wrong tile representation.");

            int row = rowChar - '1';
            int col = colChar - 'A';

            return getTile(row, col);
        } else {
            throw new Exception("Tile format has wrong size");
        }
    }

    public int getDistance(Tile start, Tile end) {
        int rowDistance = Math.abs(getRowDistance(start, end));
        int colDistance = Math.abs(getColDistance(start, end));
        return rowDistance > colDistance ? rowDistance : colDistance;
    }

    public int getRowDistance(Tile start, Tile end) {
        return end.getRow() - start.getRow();
    }

    public int getColDistance(Tile start, Tile end) {
        return end.getCol() - start.getCol();
    }

    /*
    public int getRow(Tile tile) {
        return tile.getPosition() / dimension + 1;
    }

    public int getCol(Tile tile) {
        return tile.getPosition() % dimension + 1;
    }
    */

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getDimension() {
        return dimension;
    }

    public int getSize() {
        return dimension * dimension;
    }
}
