
// import edu.princeton.cs.algs4.StdRandom;
// import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] sites;
    private final WeightedQuickUnionUF ufForPercolate;
    private final WeightedQuickUnionUF ufForisFull;
    private int numberOfOpenSites;
    private final int size;
    private final int numberOfSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        size = n;
        numberOfSites = n * n;
        sites = new boolean[numberOfSites + 1];
        ufForPercolate = new WeightedQuickUnionUF(numberOfSites + 2);
        ufForisFull = new WeightedQuickUnionUF(numberOfSites + 1);

        int virtualTop = 0;
        int virtualBottom = numberOfSites + 1;
        int bottomRow = siteIndex(size, 1);

        for (int i = 0; i < size; i++) {
            ufForPercolate.union(virtualTop, i + 1);
            ufForPercolate.union(virtualBottom, bottomRow + i);

            ufForisFull.union(virtualTop, i + 1);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int siteIndex = siteIndex(row, col);
        if (sites[siteIndex]) {
            return;
        }

        sites[siteIndex] = true;
        numberOfOpenSites++;

        if (row > 1 && isOpen(row - 1, col)) {
            ufForPercolate.union(siteIndex - size, siteIndex);
            ufForisFull.union(siteIndex - size, siteIndex);
        }
        if (row < size && isOpen(row + 1, col)) {
            ufForPercolate.union(siteIndex + size, siteIndex);
            ufForisFull.union(siteIndex + size, siteIndex);
        }
        if (col > 1 && isOpen(row, col - 1)) {
            ufForPercolate.union(siteIndex - 1, siteIndex);
            ufForisFull.union(siteIndex - 1, siteIndex);
        }
        if (col < size && isOpen(row, col + 1)) {
            ufForPercolate.union(siteIndex + 1, siteIndex);
            ufForisFull.union(siteIndex + 1, siteIndex);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int siteIndex = siteIndex(row, col);
        return sites[siteIndex];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int siteIndex = siteIndex(row, col);
        return isOpen(row, col) && (ufForisFull.find(siteIndex) == ufForisFull.find(0));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return (ufForPercolate.find(numberOfSites + 1) == ufForPercolate.find(0)) && numberOfOpenSites > 0;
    }

    private int siteIndex(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException();
        }
        return (row - 1) * size + col;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(3, 1);
        percolation.open(2, 1);
        System.out.println(percolation.percolates());
        percolation.open(1, 1);
        System.out.println(percolation.isOpen(1, 2));
        System.out.println(percolation.isFull(2, 1));
        System.out.println(percolation.percolates());
    }
}
