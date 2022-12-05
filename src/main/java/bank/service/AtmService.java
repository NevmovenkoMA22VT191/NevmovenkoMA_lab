package bank.service;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.entity.additions.StatusATM;

public interface AtmService {
    void create(Integer id, String name, StatusATM status, Boolean workPayMoney, Boolean workDepositMoney,
                Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee);
    void update(BankAtm bankAtm);
    void delete();
    BankAtm getBankAtm();

    // Возврат экземпляра банкомата
    BankAtm getBankATM();

    Boolean addMoney(Double sumMoney);
    Boolean subtractMoney(Double sumMoney);
    void IssuanceMoneyOn();
    void IssuanceMoneyOff();
    void DepositMoneyOn();
    void DepositMoneyOff();
}
