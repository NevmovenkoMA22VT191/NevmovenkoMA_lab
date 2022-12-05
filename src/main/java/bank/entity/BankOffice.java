package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import bank.entity.additions.StatusOffice;

// BankOffice - объект офис банка, содержит поля:
// id банковского офиса, название офиса, адрес офиса, статус, можно ли разместить банкомат, кол-во банкоматов в офисе,
// молжно ли взять кредит, работает ли выдача денег, кол-во денег в банковском офисе, стоимость аренды банковского офиса
@Setter
@Getter
public class BankOffice {
    private Integer id;
    private String name;
    private Bank bank;
    private String address;
    private StatusOffice status;
    private Boolean maySetATM;
    private Integer countATM;
    private Boolean mayApplyLoan;
    private Boolean mayWithdrawMoney;
    private Boolean mayDepositMoney;
    private Double money;
    private Double rentCost;

    public BankOffice(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost) {
        this.id = id;
        this.name = name;
        this.bank = bank;
        this.address = address;
        this.status = status;
        this.maySetATM = true;
        this.countATM = 0;
        this.mayApplyLoan = true;
        this.mayWithdrawMoney = true;
        this.mayDepositMoney = true;
        this.money = 0.0;
        this.rentCost = rentCost;
    }

    @Override
    public String toString() {
        String str =  "Название офиса: " + name + "\nИмя банка: " + bank.getName() + "\nАдрес: " + address +
                "\nСтатус: ";
        // Проверка на статус
        if (status == StatusOffice.Work)
            str+= " работает";
        else
            str+= " не работает";

        // Проверка на добавление банкомата
        if (maySetATM)
            str += "\nМожно добавить банкомат";
        else
            str += "\nНельзя добавить банкомат";

        // Проверка на кол-во банкоматов в офисе
        if (maySetATM)
            str += "\nКоличество банкоматов: " + countATM;

        // Проверка на выдачу денег
        if (mayWithdrawMoney)
            str += "\nРаботает на выдачу денег";
        else
            str += "\nНе работает на выдачу денег";

        // Проверка на  выдачу кредитов
        if (mayApplyLoan)
            str += "\nРаботает на выдачу кредитов";
        else
            str += "\nНе работает на выдачу кредитов";

        // Проверка на возможность внести деньги
        if (mayDepositMoney)
            str += "\nМожно внести деньги";
        else
            str += "\nНельзя внести деньги";
        str += "\nДенежная сумма: " + money + "\nАрендная плата: " + rentCost;
        return str;
    }
}
