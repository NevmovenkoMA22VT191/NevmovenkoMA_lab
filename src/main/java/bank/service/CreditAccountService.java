package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.CreditAccount;
import bank.entity.finance.PaymentAccount;
import bank.entity.man.Employee;
import bank.entity.man.User;

import java.time.LocalDate;

/**
 * Интерфейс CreditAccountService
 * @param <T>
 */
public interface CreditAccountService<T> {
    /**
     * Create <T>CreditAccount</T>
     * @param id
     * @param user
     * @param bank
     * @param employee
     * @param paymentAccount
     * @param startDate
     * @param countMonth
     * @param amount
     * @return
     */
    T create(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                LocalDate startDate, Integer countMonth, Double amount);

    /**
     * Update <T>CreditAccount</T>
     * @param creditAcc
     */
    void update(CreditAccount creditAcc);

    /**
     * Delete <T>CreditAccount</T>
     */
    void delete();

    /**
     * Return CreditAccount
     * @return
     */
    T getCreditAcc();

    /**
     * Метод applyLoan - одобрение заявки на кредитование
     * @param paymentAccount
     * @param employee
     * @return
     */
    Boolean applyLoan(PaymentAccount paymentAccount, Employee employee);
}