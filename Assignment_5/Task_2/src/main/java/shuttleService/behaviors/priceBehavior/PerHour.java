package shuttleService.behaviors.priceBehavior;

public class PerHour implements PriceBehavior {
    private int amount;

    public PerHour(int amount) {
        this.amount = amount;
    }

    @Override
    public String getPrice() {
        return amount + " CHF/h";
    }
}
