import java.lang.Math;
import java.util.Scanner;

/**
 * Contract class for each individual options contract,
 * taking 5 variables needed for BSM formula
 * 
 * @author Richard Nguyen (richardn03)
 */
public class Contract {
    private double strikePrice;
    private double stockPrice;
    private double timeToExp; //number of years
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

        return stockPrice;
    }

    /**
     * Method to return area under normal distribution curve by key, d1/d2
     * @param key double to retrieve corresponding value
     * @return distribution value for final call price
     */
    public double getNormalDistribution(double key) {
        Scanner read = new Scanner("StandardNormalDistribution.txt");

        while (read.hasNext()) {
            read.nextLine();
        }

        read.close();
        return 0.0;
    }

}
// https://www.youtube.com/watch?v=i0sGAds8ztI&ab_channel=KevinBracker