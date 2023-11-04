public class Main {
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(2, 100000);
        System.out.println("mean = " + percolationStats.mean());
        System.out.println("stddev = " + percolationStats.stddev());
        System.out.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");

    }
}