import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    final private int[][] board;
    final private int size;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = title at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null) {
            throw new NullPointerException();
        }

        this.size = tiles[0].length;
        this.board = copyBoard(tiles);
    }

    // string representation of this board
    public String toString() {
        StringBuilder boardString = new StringBuilder(Integer.toString(size) + "\n");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                boardString.append(Integer.toString(board[row][col]));
                if (col < size - 1)
                    boardString.append(" ");
            }
            if (row < size - 1)
                boardString.append("\n");
        }
        return boardString.toString();
    }

    // board dimension n
    public int dimension() {
        return size;
    }

    // number of tiles out of place
    public int hamming() {
        int sumHamming = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int tmp = board[row][col];
                if (tmp == 0)
                    continue;
                if (tmp != (row * size + col + 1))
                    sumHamming++;
            }
        }
        return sumHamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int sumManhattan = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int tmp = board[row][col];
                if (tmp != 0 && tmp != (row * size + col + 1)) {
                    sumManhattan += Math.abs((tmp - 1) / size - row);
                    sumManhattan += Math.abs((tmp - 1) % size - col);
                }
            }
        }
        return sumManhattan;
    }

    // is this board the goad board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {

        if (y == this)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass())
            return false;
        Board other = (Board) y;
        return Arrays.deepEquals(this.board, other.board);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        int blankRow = 0;
        int blankCol = 0;
        boolean isFound = false;
        for (blankRow = 0; blankRow < size; blankRow++) {
            for (blankCol = 0; blankCol < size; blankCol++) {
                if (board[blankRow][blankCol] == 0) {
                    isFound = true;
                    break;
                }
            }
            if (isFound)
                break;
        }
        ArrayList<Board> neighbors = new ArrayList<>();
        if (blankRow > 0)
            neighbors.add(swapTilesInBoard(blankRow, blankCol, blankRow - 1, blankCol));
        if (blankRow < size - 1)
            neighbors.add(swapTilesInBoard(blankRow, blankCol, blankRow + 1, blankCol));
        if (blankCol > 0)
            neighbors.add(swapTilesInBoard(blankRow, blankCol, blankRow, blankCol - 1));
        if (blankCol < size - 1)
            neighbors.add(swapTilesInBoard(blankRow, blankCol, blankRow, blankCol + 1));

        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        if (size < 2)
            return this;
        int firstRow = 0, firstCol = 0, secondRow = size - 1, secondCol = size - 1;
        if (board[firstRow][firstCol] == 0)
            firstCol++;
        if (board[secondRow][secondCol] == 0)
            secondCol--;

        return swapTilesInBoard(firstRow, firstCol, secondRow, secondCol);
    }

    // unit testing (not grade)
    public static void main(String[] args) {
        int[][] tiles = { { 8, 1, 3 }, { 4, 0, 2 }, { 7, 6, 5 } };
        Board board = new Board(tiles);
        Board board2 = new Board(tiles);
        System.out.println(board);
        System.out.println(board.hamming());
        System.out.println(board.manhattan());
        ArrayList<Board> lst = (ArrayList<Board>) board.neighbors();
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }

        System.out.println(board.equals(board2));
        board2 = board.twin();
        System.out.println(board2);
        int[][] tilesGoal = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };
        Board board3 = new Board(tilesGoal);
        System.out.println(board3.isGoal());
    }

    // copy board
    private int[][] copyBoard(int[][] board) {
        int[][] copyBoard = new int[size][];
        for (int row = 0; row < size; row++) {
            copyBoard[row] = new int[size];
            for (int col = 0; col < size; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }
        return copyBoard;
    }

    // swap 2 pair tiles in board
    private Board swapTilesInBoard(int firstRow, int firstCol, int secondRow, int secondCol) {
        int[][] copyTiles = copyBoard(board);
        int tmp = copyTiles[firstRow][firstCol];
        copyTiles[firstRow][firstCol] = copyTiles[secondRow][secondCol];
        copyTiles[secondRow][secondCol] = tmp;
        return new Board(copyTiles);
    }
}