package org.itstep.msk.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class Operation {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Column
    private String blank;

    //TODO сделать конструктор
    //TODO переопределить hashCode(), equals(), toString()

    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getBlank() {
        return blank;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }
}
