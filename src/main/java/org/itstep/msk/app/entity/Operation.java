package org.itstep.msk.app.entity;

import org.itstep.msk.app.enums.OperationType;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class Operation {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private OperationType operationType;

    @Column
    private Integer operationAmmount;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "target_account_id", referencedColumnName = "id")
    private Account targetAccount;

    //TODO сделать конструктор
    //TODO переопределить hashCode(), equals(), toString()

    public Integer getId() {
        return id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Integer getOperationAmmount() {
        return operationAmmount;
    }

    public Account getAccount() {
        return account;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setOperationAmmount(Integer operationAmmount) {
        this.operationAmmount = operationAmmount;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }
}
