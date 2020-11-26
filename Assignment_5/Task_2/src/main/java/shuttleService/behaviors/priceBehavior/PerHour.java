package shuttleService.behaviors.priceBehavior;

/**
 * Per Hour price model
 */
public class PerHour implements PriceBehavior {
    private int amount;

    /**
     * @param amount Set price per hour
     */
    public PerHour(int amount) {
        this.amount = amount;

        if (amount < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    /**
     * Get price per hour
     * @return
     */
    @Override
    public String getPrice() {
        return amount + " CHF/h";
    }
}
