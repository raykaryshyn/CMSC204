/**
 * A class of items for sale on an online store.
 * 
 * @author Raymond Karyshyn
 */
public class Item {
    private String description;
    private int price;

    public Item(String descriptionIn, int priceIn) {
        description = descriptionIn;
        price = priceIn;
    }

    /**
     * Gets the item description.
     * 
     * @return The item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the item price.
     * 
     * @return The item price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the item represented as a string.
     * <p>
     * Formatted as "description\t$price".
     * 
     * @return The string representation of the item.
     */
    public String toString() {
        return description + "\t$" + price / 100 + "." + price % 100;
    }
}
