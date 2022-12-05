package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import bank.entity.additions.StatusATM;

// BankAtm - объект банкомат, содержит поля:
// id банкомата, имя банкомата, адрес, статус, банк, расположение банкомата, обслуживает сотрудник,
// работает ли на выдачу денег, можно ли внести деньги, кол-во денег в банкомате, стоимость обслуживания.
@Setter
@Getter
public class BankAtm {
    private Integer id;
    private String name;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private StatusATM status;
    private Boolean workIssuanceMoney;
    private Boolean workDepositMoney;
    private Double money;
    private Double maintenanceCost;

    public BankAtm(Integer id, String name, StatusATM status, Boolean workIssuanceMoney, Boolean workDepositMoney,
                   Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.workIssuanceMoney = workIssuanceMoney;
        this.workDepositMoney = workDepositMoney;
        this.maintenanceCost = maintenanceCost;
        this.bank = bank;
        this.employee = employee;
        this.money = 0.0;
        this.bankOffice = bankOffice;
    }

    @Override
    public String toString() {
        String str = "Имя банкомата: " + name + "\nАдрес: " + bankOffice.getAddress() + "\nСтатус: ";
        // Выбор статуса работы банкомата
        switch (status) {
            case Work -> str += "работает";
            case NotWork -> str += "Не работает";
            case NoMoney -> str += "Нет денег";
        }
        str += "\nИмя банка: " + bank.getName() + "\nИмя офиса: " + bankOffice.getName() +
                "\nИмя обслуживающего сотрудника: " + employee.getFullName();

        // Проверка на выдачу денег
        if (workIssuanceMoney)
            str += "\nРаботает на выдачу денег";
        else
            str += "\nНе работает на выдачу денег";

        // Проверка на внос денег
        if (workDepositMoney)
            str += "\nМожно внести деньги";
        else
            str += "\nНельзя внести деньги";

        str += "\nДенежная сумма: " + money + "\nСтоимость обслуживания: " + maintenanceCost;
        return str;
    }
}
