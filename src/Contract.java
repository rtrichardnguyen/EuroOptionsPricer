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
    private double timeToExp;
    private double riskFreeRate; 
    private double volatility; 

    /**
     * Options contract setting call arguments
     * @param strikePrice excercise price
     * @param stockPrice share price
     * @param timeToExp time to expiration, expressed in years
     * @param riskFreeRate time to expiration, expressed in years
     * @param volatility percent decimal of rho
     */
    public Contract(double strikePrice, double stockPrice, 
        double timeToExp, double riskFreeRate, double volatility) {
        
        this.strikePrice = strikePrice;
        this.stockPrice = stockPrice;
        this.timeToExp = timeToExp / 365;
        this.riskFreeRate = riskFreeRate / 100;
        this.volatility = volatility / 100;

    }

    /**
     * final calculation of call price using BSM
     * @return
     */
    public double getCallPrice() {

        double log = Math.log(stockPrice / strikePrice);
        double secondGrouping = riskFreeRate + (0.5 * Math.pow(volatility, 2.0));

        double d1 = ((log + (secondGrouping * timeToExp))) /
            (volatility * Math.sqrt(timeToExp));
        double d2 = d1 - (volatility * Math.sqrt(timeToExp));

        double n1 = this.getNormalDistribution(d1);
        double n2 = this.getNormalDistribution(d2);

        double callPrice = (this.stockPrice * n1) - 
            (strikePrice / ((Math.exp(riskFreeRate * timeToExp))) * n2);

        return callPrice;
    }

    /**
     * Method to return area under normal distribution curve by key, d1/d2
     * @param key double to retrieve corresponding value
     * @return distribution value for final call price
     */
    public double getNormalDistribution(double key) {
        
        File standardND = new File("/C:/Users/rtric/Desktop" + 
            "/ResumeProjects/EuroOptionsPricer/orderedCurve.txt/");
        Scanner read;
        double roundedKey = Math.round(key * 100.0) / 100.0;
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

            return (normalDist.get(roundedKey));

        } catch (FileNotFoundException e) {
            System.out.println("rounded key (derivative 1 or 2)" + 
                " did not match a key in the HashMap");
            e.printStackTrace();
        }
        return 0.0;
    }

}
// https://www.youtube.com/watch?v=i0sGAds8ztI&ab_channel=KevinBracker