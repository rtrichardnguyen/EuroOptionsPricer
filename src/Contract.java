import java.lang.Math;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
/**
 * Contract class for each individual options contract,
 * taking 5 variables needed for BSM formula
 * 
 * @author Richard Nguyen (richardn03)
 */
public class Contract {
    private double strikePrice;
    private double stockPrice;
    private double timeToExp; // number of years (percent decimal)
    private double riskFreeRate; // percent decimal
    private double volatility; //rho (percent decimal)

    /**
     * final calculation of call price using BSM
     * @return
     */
    public double getCallPrice() {

        double log = Math.log(stockPrice / strikePrice);
        double secondGrouping = riskFreeRate + (0.5 * Math.pow(volatility, 2.0));
        double time = timeToExp / 365;

        double d1 = ((log + (secondGrouping * time))) / (volatility * Math.sqrt(time));
        double d2 = d1 - (volatility * Math.sqrt(time));

        double callPrice = 0;
        //NEED TO DO, double value of final call price to return *********

        return callPrice;
    }

    /**
     * Method to return area under normal distribution curve by key, d1/d2
     * @param key double to retrieve corresponding value
     * @return distribution value for final call price
     */
    public double getNormalDistribution(double key) {
        
        File standardND = new File("/C:/Users/rtric/Desktop/ResumeProjects/EuroOptionsPricer/orderedCurve.txt/");
        Scanner read;
        try {
            read = new Scanner(standardND);
            HashMap<Double, Double> normalDist = new HashMap<>();

            while (read.hasNextLine()) {
                String first = read.next();
                String second = read.next();
                normalDist.put(Double.parseDouble(first), Double.parseDouble(second));
                read.nextLine();
            }

            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("normal distribution not read");
            e.printStackTrace();
        }
        return 0.0;
    }

}
// https://www.youtube.com/watch?v=i0sGAds8ztI&ab_channel=KevinBracker