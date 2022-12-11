package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.status.StatusOffice;

/**
 * Интерфейс BankOfficeService
 * @param <T>
 */
public interface BankOfficeService<T> {
    /**
     * Create <T>BankOffice</T>
     * @param id
     * @param name
     * @param bank
     * @param address
     * @param status
     * @param rentCost
     * @return
     */
    T create(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost);

    /**
     * Update <T>BankOffice</T>
     * @param bankOffice
     */
    void update(BankOffice bankOffice);

    /**
     * Delete <T>BankOffice</T>
     */
    void delete();

    /**
     * Return BankOffice
     * @return
     */
    T getBankOffice();


    /**
     * Метод addMoney - добавление суммы денег к счету офиса
     * @param sumMoney
     */
    void addMoney(Double sumMoney);

    /**
     * Метод subtractMoney - вычесть сумму денег со счета офиса
     * @param sumMoney
     * @return
     */
    Boolean subtractMoney(Double sumMoney);

    /**
     * Метод addATM - добавляет банкомат в офис
     * @return
     */
    Boolean addATM();

    /**
     * Метод subtractATM - убирает банкомат в офисе
     * @param bankATM
     */
    void subtractATM(BankAtm bankATM);

    /**
     * Метод SetATMOn - установка банкомата разрешена/возможна
     */
    void SetATMOn();

    /**
     * Метод SetATMOff - установка банкомата запрещена/невозможна
     */
    void SetATMOff();

    /**
     * Метод WithdrawMoneyOn - вывод денег со счета офиса запрещен/невозможен
     */
    void WithdrawMoneyOn();

    /**
     * Метод WithdrawMoneyOff - вывод денег со счета офиса разрешен/возможен
     */
    void WithdrawMoneyOff();

    /**
     * Метод DepositMoneyOn - внос денег на счет офиса разрешен/возможен
     */
    void DepositMoneyOn();

    /**
     * Метод DepositMoneyOff - внос денег на счет офиса запрещен/невозможен
     */
    void DepositMoneyOff();

    /**
     * Метод ApplyLoanOn - подача заявки на кредит разрешена/возможна
     */
    void ApplyLoanOn();

    /**
     * Метод ApplyLoanOff - подача заявки на кредит запрещена/невозможна
     */
    void ApplyLoanOff();


    Boolean addBankATM(AtmService atm);
    Boolean delBankATM(AtmService atm);
    Boolean addEmployee(EmployeeService employee);
    Boolean delEmployee(EmployeeService employee);
}
