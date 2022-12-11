package bank.service;

import bank.entity.finance.Bank;

/**
 * Интерфейс BankService
 * @param <T>
 */
public interface BankService<T> {
    /**
     * Create <T>Bank</T>
     * @param id
     * @param name
     * @return
     */
    T create(Integer id, String name);

    /**
     * Update <T>Bank</T>
     * @param bank
     */
    void update(Bank bank);

    /**
     * Delete <T>Bank</T>
     */
    void delete();

    /**
     * Return Bank
     * @return
     */
    T getBank();

    /**
     * Метод addMoney - добавление суммы денег на счет банка
     * @param bank
     * @param sumMoney
     */
    void addMoney(Bank bank, Double sumMoney);

    /**
     * Метод subtractMoney - вычесть сумму денег со счета банка
     * @param bank
     * @param sumMoney
     * @return
     */
    Boolean subtractMoney(Bank bank, Double sumMoney);

    Boolean addBankOffice(BankOfficeService bankOffice);
    Boolean delBankOffice(BankOfficeService bankOffice);
    Boolean addBankATM(AtmService bankAtm);
    Boolean delBankATM(AtmService bankAtm);
    Boolean addEmployee(EmployeeService employee);
    Boolean delEmployee(EmployeeService employee);
    Boolean addUser(UserService user);
    Boolean delUser(UserService user);
}