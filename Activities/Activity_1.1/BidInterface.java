/**
 * An interface for a bid of an air conditioning unit installation.
 * 
 * @author Raymond Karyshyn
 */
public interface BidInterface {
    /**
     * Gets the name of the company posting the bid.
     * 
     * @return Name of the company posting the bid.
     */
    public String getCompanyName();

    /**
     * Gets the description of the air conditioning unit in the bid posting.
     * 
     * @return Description of the air conditioning unit.
     */
    public String getUnitDescription();

    /**
     * Gets the performance of the air conditioning unit in the bid posting.
     * 
     * @return Performance of the air conditioning unit.
     */
    public double getUnitPerformance();

    /**
     * Gets the cost of the air conditioning unit in the bid posting.
     * 
     * @return Cost of the air conditioning unit.
     */
    public double unitCost();

    /**
     * Gets the cost of installing the air conditioning unit in the bid posting.
     * 
     * @return Cost of installing the air conditioning unit.
     */
    public double installationCost();
}