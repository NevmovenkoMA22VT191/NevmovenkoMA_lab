package bank;

import bank.entity.status.StatusATM;
import bank.entity.status.StatusOffice;
import bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final int countMaxBank = 5;
        final int countMaxBankOffice = 3;
        final int countMaxEmployee = 5;
        final int countMaxPaymentAccount = 2;


        ArrayList<BankServiceImpl> banks = new ArrayList<>();
        ArrayList<UserServiceImpl> users = new ArrayList<>();

        //TODO Разобрать вариант списка, который будет нормально генериться
        // banks = Arrays.<String>asList("Сбербанк", "Тинькоф", "ВТБ");

        //TODO Может как-то усовершенствовать конструкцию?!



        for (int countBank = 0; countBank < countMaxBank; countBank++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(countBank, String.format("Банк %d", countBank));
            for (int countBankOffice = 0; countBankOffice < countMaxBankOffice; countBankOffice++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(countBankOffice + countBank, String.format("Офис %d", countBankOffice), bankService.getBank(),
                        String.format("60 лет октября, дом %d", countBankOffice), StatusOffice.OPEN, 3500.0);
                for (int countEmployee = 0; countEmployee < countEmployee; countEmployee++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(countEmployee + countBankOffice + countBank, String.format("Невмовенко %d", countEmployee + countBankOffice + countBank), "Невмовенко",
                            LocalDate.of(2001, 10, 11), bankService.getBank(),
                            bankOfficeService.getBankOffice(), String.format("Менеджер %d", countEmployee), 40000.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(countBankOffice + countBank, String.format("Банкомат SWIFT %d", countBankOffice + countBank), StatusATM.OPEN, Boolean.TRUE, Boolean.TRUE,
                        250.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(countBank, String.format("Тинкоф %d", countBank), "Тинькоф", LocalDate.of(1873,
                    05, 07), String.format("Предприниматель %d", countBank));
            for (int countPaymentAccount = 0; countPaymentAccount < countMaxPaymentAccount; countPaymentAccount++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(countPaymentAccount + countBank, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(countPaymentAccount + countBank, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 12, 5), 12, 5700.0);

                userService.addPayAcc(paymentAccountService);
                userService.addCreditAcc(creditAccountService);
            }
            bankService.addUser(userService);
            banks.add(bankService);
            users.add(userService);
        }

        System.out.println("Банк");
        System.out.println(banks.get(0).getInfo());
        System.out.println("\n\nКлиент");
        System.out.println(users.get(0).getInfo());
    }

}