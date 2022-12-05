package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.entity.additions.StatusATM;
import bank.service.AtmService;

import java.util.Objects;

public class AtmServiceImpl implements AtmService {
    private BankAtm bankAtm = null;

    // Создание экземпляра банкомата
    @Override
    public void create(Integer id, String name, StatusATM status, Boolean workPayMoney, Boolean workDepositMoney,
                       Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee) {
        bank.setCountATM(bank.getCountATM() + 1);
        bankOffice.setCountATM(bankOffice.getCountATM() + 1);
        this.bankAtm = new BankAtm(id, name, status, workPayMoney, workDepositMoney, maintenanceCost, bank,
                bankOffice, employee);
    }

    // Обновление экземпляра банкомата
    @Override
    public void update(BankAtm bankATM) {
        this.bankAtm = bankATM;
    }

    // Обнуление экземпляра банкомата
    @Override
    public void delete() {
        this.bankAtm = null;
    }

    @Override
    public BankAtm getBankAtm() {
        return null;
    }

    // Возврат экземпляра банкомата
    @Override
    public BankAtm getBankATM() {
        return this.bankAtm;
    }

    // При работе банкомата деньги совершают путь: банкомат -> офис банкомата -> банк;
    // Возращается true, иначе false
    @Override
    public Boolean addMoney(Double sumMoney) {
        if (!Objects.equals(this.bankAtm.getStatus(), StatusATM.Work)) {
            return Boolean.FALSE;
        }
        this.bankAtm.setMoney(this.bankAtm.getMoney() + sumMoney);
        this.bankAtm.getBankOffice().setMoney(this.bankAtm.getBankOffice().getMoney() + sumMoney);
        this.bankAtm.getBank().setMoney(this.bankAtm.getBank().getMoney() + sumMoney);
        return Boolean.TRUE;
    }

    // При работе банкомата и наличии денег, деньги выдаются путем: банкомат отдает -> офис банкамата отдает ->
    // банк отдает;
    // Возращается true, иначе false
    @Override
    public Boolean subtractMoney(Double sumMoney) {
        if ((Objects.equals(this.bankAtm.getStatus(), StatusATM.NotWork)) || (Objects.equals(this.bankAtm.getStatus(),
                StatusATM.NoMoney)) || (this.bankAtm.getMoney() < sumMoney))
            return Boolean.FALSE;
        if (Objects.equals(this.bankAtm.getMoney(), sumMoney))
            this.bankAtm.setStatus(StatusATM.NoMoney);
        this.bankAtm.setMoney(this.bankAtm.getMoney() - sumMoney);
        this.bankAtm.getBankOffice().setMoney(this.bankAtm.getBankOffice().getMoney() - sumMoney);
        this.bankAtm.getBank().setMoney(this.bankAtm.getBank().getMoney() - sumMoney);
        return Boolean.TRUE;
    }


    // Банкомат может выдавать деньги(разрешено)
    @Override
    public void IssuanceMoneyOn() {
        this.bankAtm.setWorkIssuanceMoney(Boolean.TRUE);
    }

    // Банкомат не может выдавать деньги(запрещено)
    @Override
    public void IssuanceMoneyOff() {
        this.bankAtm.setWorkIssuanceMoney(Boolean.TRUE);
    }

    // Банкомат может получать деньги(разрешено)
    @Override
    public void DepositMoneyOn() {
        this.bankAtm.setWorkDepositMoney(Boolean.TRUE);
    }

    /*Запретить банкому получать деньги*/
    @Override
    public void DepositMoneyOff() {
        this.bankAtm.setWorkDepositMoney(Boolean.TRUE);
    }
}