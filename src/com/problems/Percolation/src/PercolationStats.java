import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] results;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0) throw new IllegalArgumentException("Either n or trials is invalid");
        results = new double[trials];
        for(int i = 0 ; i < trials ; i++){
            Percolation lattice = new Percolation(n);
            int row = StdRandom.uniformInt(n) + 1;
            int col = StdRandom.uniformInt(n) + 1;
            while(!lattice.percolates()){
                while(lattice.isOpen(row, col)){
                    row = StdRandom.uniformInt(n) + 1;
                    col = StdRandom.uniformInt(n) + 1;
                }
                lattice.open(row, col);
            }
            double sites = lattice.numberOfOpenSites();
            results[i] =  sites / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        double mean = this.mean();
        double stddev = this.stddev();
        return mean - 1.96 * stddev / Math.sqrt(results.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        double mean = this.mean();
        double stddev = this.stddev();
        return mean + 1.96 * stddev / Math.sqrt(results.length);
    }

    // test client (see below)
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println("mean = " + percolationStats.mean());
        System.out.println("stddev = " + percolationStats.stddev());
        System.out.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");
    }
}
