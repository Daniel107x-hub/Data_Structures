import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    private final boolean[] sites;
    private int openSites;
    private final int size;
    private final WeightedQuickUnionUF uf;

    public Percolation(int n){
        if(n <= 0) throw new IllegalArgumentException("Unable to construct 0-sized lattice");
        this.sites = new boolean[n * n + 2];
        this.sites[0] = true;
        this.sites[n * n + 1] = true;
        this.openSites = 0;
        this.uf = new WeightedQuickUnionUF(n * n + 2);
        this.size = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException{
        validateRange(row, col);
        int top = getIndex(row - 1, col);
        int left = getIndex(row, col - 1);
        int right = getIndex(row, col + 1);
        int bottom = getIndex(row + 1, col);
        int current = getIndex(row, col);
        if(this.sites[current]) return;
        this.sites[current] = true;
        this.openSites++;
        if(top != -1 && this.sites[top]) this.uf.union(top, current);
        if(left != -1 && this.sites[left]) this.uf.union(left, current);
        if(right != -1 && this.sites[right]) this.uf.union(right, current);
        if(bottom != -1 && this.sites[bottom]) this.uf.union(bottom, current);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) throws IllegalArgumentException{
        validateRange(row, col);
        int index = getIndex(row, col);
        return this.sites[index];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) throws IllegalArgumentException{
        validateRange(row, col);
        int index = getIndex(row, col);
        return this.uf.find(0) == this.uf.find(index);
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return this.openSites;
    }

    // does the system percolate?
    public boolean percolates(){
        return this.uf.find(0) == this.uf.find(size * size + 1);
    }

    private int getIndex(int row, int col){
        if(row == 0) return 0;
        if(row == size + 1) return size * size + 1;
        if(row < 1 || row > this.size) return -1;
        if(col < 1 || col > this.size) return -1;
        return size * (row - 1) + (col - 1) + 1;
    }

    private void validateRange(int row, int col) throws IllegalArgumentException{
        if(row < 1 || row > this.size || col < 1 || col > this.size) throw new IllegalArgumentException("Row and column combination out of bounds");
    }

    // test client (optional)
    public static void main(String[] args){}
}
