package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// Bank - объект банк, содержит поля:
// Id банка, Имя банка, Кол-во офисов, кол-во банкоматов, кол-во сотрудников, кол-во клиентов, рейтинг банка,
// всего денег в банке, процентная ставка
@Getter
@Setter
public class Bank {
    private Integer id;
    private String name;
    private Integer countOffice;
    private Integer countATM;
    private Integer countEmployees;
    private Integer countClients;
    private Integer rating;
    private Double money;
    private Double interestRate;


    public Bank(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.countOffice = 0;
        this.countATM = 0;
        this.countEmployees = 0;
        this.countClients = 0;
        this.rating = null;
        this.money = null;
        this.interestRate = null;
    }

    @Override
    public String toString() {
        return "Имя банка: " + name + "\nКоличество офисов: " + countOffice + "\nКоличество банкоматов: " + countATM +
                "\nКоличество сотрудников: " + countEmployees + "\nКоличество клиентов: " + countClients +
                "\nРейтинг: " + rating + "\nКоличество денег: " + money + "\nПроцентная ставка: " + interestRate;
    }
}
