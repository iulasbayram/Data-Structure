//ID: Ulas Bayram NO: 220201040
public class DrawHistogram {
    public static int[] makeHistogram(double [] numbers, int N, double l, double r) {
        int[] h = new int[N];

        double step = (r-l) / N; // size of a histogram bin
        for (int i = 0; i < numbers.length; ++i) {
            int b = (int)Math.floor((numbers[i] - l) / step); // numbers between [l,l+step) --> 0, [l+step, l+2*step) --> 1, ...
            if (b >= 0 && b < N)
                h[b] += 1;
        }

        return h;
    }
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // Number of histogram bins
        double l = Double.parseDouble(args[1]); // Lower limit of histogram range
        double r = Double.parseDouble(args[2]); // Highest limit of histogram range
        int counter = 0;
        double[] add_gauss_Arr = new double[1000];
        while (counter < 1000) {
            double unknown = StdRandom.gaussian(70,15);
            add_gauss_Arr[counter] = unknown ;
            counter += 1;
        }

        int [] histogram = makeHistogram(add_gauss_Arr, N, l, r);

        // Print out histogram bins for debugging
        for (int i = 0; i < histogram.length; i += 1) {
            StdOut.printf("%d ", histogram[i]);
        }
        StdOut.println();

        int maxBin = StdStats.max(histogram);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, maxBin);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < histogram.length; i += 1) {
            double x = i+0.5;
            double y = histogram[i]/2.0;
            double rw = 0.48;
            double rh = histogram[i]/2.0;
            StdDraw.filledRectangle(y, x, rh, rw);
        }
        
            
        
    }
}
