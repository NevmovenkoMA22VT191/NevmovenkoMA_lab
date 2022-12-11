package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;

import java.time.LocalDate;

/**
 * Интерфейс Employee
 * @param <T>
 */
public interface EmployeeService<T> {
    /**
     * Create <T>Employee</T>
     * @param id
     * @param name
     * @param surname
     * @param birthday
     * @param bank
     * @param bankOffice
     * @param profession
     * @param salary
     * @return
     */
    T create(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice,
                String profession, Double salary);

    /**
     * Update <T>Employee</T>
     * @param employee
     */
    void update(Employee employee);

    /**
     * Delete <T>Employee</T>
     */
    void delete();

    /**
     * Return Employee
     * @return
     */
    T getEmployee();

    /**
     * Метод DistantWork - сотрудник работает удаленно/дистанционно
     */
    void DistantWork();

    /**
     * Метод DistantWork - сотрудник работает очно/офис
     */
    void OfficeWork();

    /**
     * Метод IssueOn - сотрудник может выдавать кредиты
     */
    void IssueOn();

    /**
     * Метод IssueOff - сотрудник не может выдавать кредиты
     */
    void IssueOff();
}