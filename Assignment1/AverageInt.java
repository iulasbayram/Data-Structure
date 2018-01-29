//ID: Ulas Bayram NO: 220201040
public class AverageInt {
        public static void main (String[] args) {
        	double first , second , third , average;
        	for(int i=0 ; i < 1000 ; i++ ) {
        	first= StdIn.readDouble();
        	second= StdIn.readDouble();
        	third= StdIn.readDouble();
        	average = (first * 0.2) + (second * 0.4) + (third * 0.4);
        	StdOut.println("Result is " + average);
        }
	}
}