package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.PaymentAccount;
import bank.entity.man.User;

/**
 * Интерфейс PaymentAccount
 * @param <T>
 */
public interface PaymentAccountService<T> {

    /**
     * Create <T>PaymentAccount</T>
     * @param id
     * @param user
     * @param bank
     * @return
     */
    T create(Integer id, User user, Bank bank);

    /**
     * Update <T>PaymentAccount</T>
     * @param payAcc
     */
    void update(PaymentAccount payAcc);

    /**
     * Delete <T>PaymentAccount</T>
     */
    void delete();

    /**
     * Return PaymentAccount
     * @return
     */
    T getPayAcc();

    /**
     * Метод addMoney - добавление денег на счет клиента
     * @param sumMoney
     */
    void addMoney(Double sumMoney);

    /**
     * Метод subtractMoney - вычет денег со счета клиента
     * @param sumMoney
     * @return
     */
    Boolean subtractMoney(Double sumMoney);
}