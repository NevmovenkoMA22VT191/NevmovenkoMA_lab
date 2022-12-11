package bank;

import bank.entity.status.StatusATM;
import bank.entity.status.StatusOffice;
import bank.service.impl.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankServiceImpl> banks = new ArrayList<>();
        ArrayList<UserServiceImpl> users = new ArrayList<>();
        for (int i_1 = 0; i_1 < 5; i_1++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(i_1, String.format("bank_№%d", i_1));
            for (int i_2 = 0; i_2 < 3; i_2++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(i_2 + i_1, String.format("office_№%d", i_2), bankService.getBank(),
                        String.format("address_%d", i_2), StatusOffice.Work, 15000.0);
                for (int i_3 = 0; i_3 < 5; i_3++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(i_3 + i_2 + i_1, String.format("Ivan_%d", i_3 + i_2 + i_1), "Ivanov",
                            LocalDate.of(2000, 10, 11), bankService.getBank(),
                            bankOfficeService.getBankOffice(), String.format("job_%d", i_3), 100.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(i_2 + i_1, String.format("ATM_%d", i_2 + i_1), StatusATM.Work, Boolean.TRUE, Boolean.TRUE,
                        100.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(i_1, String.format("Maxim_%d", i_1), "Maximovich", LocalDate.of(2000,
                    10, 11), String.format("work_%d", i_1));
            for (int i_2 = 0; i_2 < 2; i_2++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(i_2 + i_1, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(i_2 + i_1, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 11, 11), 12, 150.0);

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