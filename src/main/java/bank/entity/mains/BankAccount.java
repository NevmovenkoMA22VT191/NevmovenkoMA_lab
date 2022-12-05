package bank.entity.mains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import bank.entity.Bank;
import bank.entity.User;

@Setter
@Getter
abstract public class BankAccount {
        private Integer id;
        private User user;
        private Bank bank;

        public BankAccount(Integer id, User user, Bank bank){
            this.id = id;
            this.user = user;
            this.bank = bank;
        }
}

