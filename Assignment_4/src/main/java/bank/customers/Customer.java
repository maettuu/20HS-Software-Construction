package bank.customers;

import bank.CreditCard;
import bank.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends Person {
    private int accountNumber;
    private float savings;
    private CreditCard creditCard;
    private Level level;

    public Customer(Level level){
        this.setLevel(level);
    }

    /**
     * Overwrite from default Lombok setter
     * @param level
     */
    public void setLevel(Level level){
        this.level = level;
        switch (level){
            case REGULAR: this.setCreditCard(new CreditCard(2000));
                break;
            case GOLDEN:this.setCreditCard(new CreditCard(5000));
                break;
            case PLATINUM:this.setCreditCard(new CreditCard(10000));
                break;
        }
    }

    public float deposit(float amount){
        this.savings += amount;
        return this.savings;
    }

    public float withdraw(float amount){
        float possible = Math.min(this.savings, amount);
        this.savings -= possible;
        return possible;
    }

    public void pay(float amount){
        if (this.savings < amount){
            System.out.println("Not enough savings");
            return;
        }
        this.withdraw(amount);
    }

    public void payCreditCard(float amount){
        this.creditCard.pay(amount);
    }
}
