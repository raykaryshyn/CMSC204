/**
 * An interface for a collection of bids of air conditioning unit installations.
 * 
 * @author Raymond Karyshyn
 */
public interface BidCollectionInterface {
    /**
     * Adds a bid to the collection.
     * 
     * @param bid Bid to be added to the collection.
     */
    public void add(BidInterface bid);

    /**
     * Removed a bid from the collection.
     * 
     * @param bid Bid to be removed from the collection.
     */
    public void remove(BidInterface bid);

    /**
     * Removes all bids from the collection.
     */
    public void clear();

    /**
     * Gets the number of bids in the collection.
     * 
     * @return Number of bids in the collection.
     */
    public int length();

    /**
     * Determines if there are no bids in the collection.
     * 
     * @return "True" if there are no bids in the collection, "False" if there is at least one bid.
     */
    public boolean isEmpty();

    /**
     * Gets the bid with the best price in the collection.
     * 
     * @return Bid with the best price in the collection.
     */
    public BidInterface bestPrice();

    /**
     * Gets the bid with the best performance in the collection.
     * 
     * @return Bid with the best performance in the collection.
     */
    public BidInterface bestPerformance();
}