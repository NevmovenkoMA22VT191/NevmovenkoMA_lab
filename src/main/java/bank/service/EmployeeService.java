package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    void create(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice,
                String profession, Double salary);
    void update(Employee employee);
    void delete();
    Employee getEmployee();

    void DistantWork();
    void OfficeWork();
    void IssueOn();
    void IssueOff();
}