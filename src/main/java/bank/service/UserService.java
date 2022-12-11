package bank.service;

import bank.entity.finance.Bank;
import bank.entity.man.User;

import java.time.LocalDate;

/**
 * Интерфейс User
 * @param <T>
 */
public interface UserService<T> {
    /**
     * Create <T>User</T>
     * @param id
     * @param name
     * @param surname
     * @param birthDay
     * @param work
     * @return
     */
    T create(Integer id, String name, String surname, LocalDate birthDay, String work);

    /**
     * Update <T>User</T>
     * @param user
     */
    void update(User user);

    /**
     * Delete <T>User</T>
     */
    void delete();

    /**
     * Return User
     * @return
     */
    T getUser();

    /**
     * Метод changeWork - позволяет изменить данные о рабочей должности пользователя
     * @param newWork
     * @param newMonthSalary
     */
    void changeWork(String newWork, Double newMonthSalary);

    /**
     * Метод changeMonthSalary - позволяет изменить данные о заработной плате пользователя
     * @param newMonthSalary
     */
    void changeMonthSalary(Double newMonthSalary);

    void addBank(Bank bank);
    void delBank(Bank bank);
    Boolean addCreditAcc(CreditAccountService creditAcc);
    Boolean delCreditAcc(CreditAccountService creditAcc);
    Boolean addPayAcc(PaymentAccountService payAcc);
    Boolean delPayAcc(PaymentAccountService payAcc);
}