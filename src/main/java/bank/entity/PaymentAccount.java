package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import bank.entity.mains.BankAccount;

// PaymentAccount - объект платежный счет, содержит поля:
// id платежного счета, пользователь чей счет, название банка, сумма на счету.
@Setter
@Getter
public class PaymentAccount extends BankAccount {
    private Double amount;

    public PaymentAccount(Integer id, User user, Bank bank) {
        super(id,user,bank);
        this.amount = 0.0;
    }

    @Override
    public String toString() {
        return "Имя банка: " + super.getBank().getName() + "\nФИО пользователя: " + super.getUser().getFullName()
                + "\nСумма денег: " + amount;
    }
}