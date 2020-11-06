package bank.customers;

import bank.CreditCard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Customer {
    private int id;
    private String name;
    private String surname;
    private int accountNumber;
    private float savings;
    private CreditCard creditCard;

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
        if (this.withdraw(amount) != amount){
            throw new Error("Not enough money");
        }
    }

    public void payCreditCard(float amount){

    }
}
