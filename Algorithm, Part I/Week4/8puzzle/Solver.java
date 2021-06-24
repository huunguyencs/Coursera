import java.util.ArrayList;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    private BoardNode solutionBoard;
    private boolean solvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException();

        solvable = true;
        solutionBoard = null;

        MinPQ<BoardNode> boardQueue = new MinPQ<BoardNode>();
        boardQueue.insert(new BoardNode(initial, null, 0));

        MinPQ<BoardNode> twinQueue = new MinPQ<BoardNode>();
        twinQueue.insert(new BoardNode(initial.twin(), null, 0));

        while (true) {
            BoardNode currBoardNode = boardQueue.delMin();
            if (currBoardNode.currBoard.isGoal()) {
                solutionBoard = currBoardNode;
                return;
            }
            for (Board neighbor : currBoardNode.currBoard.neighbors()) {
                if (currBoardNode.preBoard == null || !neighbor.equals(currBoardNode.preBoard.currBoard)) {
                    boardQueue.insert(new BoardNode(neighbor, currBoardNode, currBoardNode.move + 1));
                }
            }

            BoardNode currTwinBoardNode = twinQueue.delMin();
            if (currTwinBoardNode.currBoard.isGoal()) {
                solvable = false;
                return;
            }
            for (Board neighbor : currTwinBoardNode.currBoard.neighbors()) {
                if (currTwinBoardNode.preBoard == null || !neighbor.equals(currTwinBoardNode.preBoard.currBoard)) {
                    twinQueue.insert(new BoardNode(neighbor, currTwinBoardNode, currTwinBoardNode.move + 1));
                }
            }
        }

    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable())
            return -1;
        return solutionBoard.move;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable())
            return null;
        BoardNode currBoard = solutionBoard;
        ArrayList<Board> solutionList = new ArrayList<>();
        while (currBoard != null) {
            solutionList.add(0, currBoard.currBoard);
            currBoard = currBoard.preBoard;
        }
        return solutionList;
    }

    // test client (see below)
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    // board node class
    private class BoardNode implements Comparable<BoardNode> {

        public BoardNode preBoard;
        public Board currBoard;
        public int move;

        public BoardNode(Board currBoard, BoardNode preBoard, int move) {
            this.currBoard = currBoard;
            this.preBoard = preBoard;
            this.move = move;
        }

        public int cost() {
            return currBoard.manhattan() + move;
        }

        public int compareTo(BoardNode that) {
            return this.cost() - that.cost();
        }
    }
}
