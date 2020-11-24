package shuttleService.behaviors.priceBehavior;

public class Constant implements PriceBehavior {
    private int amount;

    public Constant(int amount) {
        this.amount = amount;
    }

    @Override
    public String getPrice() {
        return amount + " CHF";
    }
}
