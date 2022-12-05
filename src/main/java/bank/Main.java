package bank;

import bank.entity.additions.StatusATM;
import bank.entity.additions.StatusOffice;
import bank.service.impl.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Bank
        System.out.println("Банк:");
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.create(1, "Сбербанк");
        System.out.println(bankService.getBank());

        //Bank Office
        System.out.println("\n\nОфис:");
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.create(1, "Офис №1", bankService.getBank(), "Улица Костюкова 36г",
                StatusOffice.Work, 47500.0);
        System.out.println(bankOfficeService.getBankOffice());

        //Employee
        System.out.println("\n\nРаботник:");
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.create(1, "Михаил", "Невмовенко", LocalDate.of(2001, 10, 11),
                bankService.getBank(), bankOfficeService.getBankOffice(), "Менеджер", 15000.0);
        System.out.println(employeeService.getEmployee());

        //Bank ATM
        System.out.println("\n\nБанкомат:");
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.create(1, "Сбер", StatusATM.Work, Boolean.TRUE, Boolean.TRUE,
                500.0, bankService.getBank(), bankOfficeService.getBankOffice(),
                employeeService.getEmployee());
        System.out.println(atmService.getBankATM());

        //User
        System.out.println("\n\nКлиент банка::");
        UserServiceImpl userService = new UserServiceImpl();
        userService.create(1, "Павел", "Невмовенко", LocalDate.of(1995, 9, 2),
                "Архитектор ПО");
        System.out.println(userService.getUser());

        //Payment Account
        System.out.println("\n\nПлатежный счет:");
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.create(1, userService.getUser(), bankService.getBank());
        System.out.println(paymentAccountService.getPayAcc());

        //Credit Account
        System.out.println("\n\nКредитный аккаунт:");
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        creditAccountService.create(1, userService.getUser(), bankService.getBank(), employeeService.getEmployee(),
                paymentAccountService.getPayAcc(), LocalDate.of(2022, 11, 25), 20,
                150000.0);
        System.out.println(creditAccountService.getCreditAcc());

    }
}