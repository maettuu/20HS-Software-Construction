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

    public Customer(String name, String surname, int accountNumber, Level level, CreditCard creditCard){
        super(name, surname);
        this.accountNumber = accountNumber;
        this.creditCard = new CreditCard(creditCard);
        this.creditCard.setCustomer(this);
        this.setLevel(level);
    }

    /**
     * Overwrite from default Lombok setter
     * @param level
     */
    public void setLevel(Level level){
        this.level = level;
        this.creditCard.setLevel(level);
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
