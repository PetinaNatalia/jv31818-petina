package org.itstep.msk.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column
    private Integer ammount;

    //TODO сделать конструктор
    //TODO переопределить hashCode(), equals(), toString()

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }
}
