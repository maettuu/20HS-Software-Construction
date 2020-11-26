package shuttleService.behaviors.priceBehavior;

/**
 * Price behaviour interface
 */
public interface PriceBehavior {
    /**
     * Get the current price
     * @return price in CHf or Chf/h
     */
    public String getPrice();
}
