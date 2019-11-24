package org.itstep.msk.app.repository;

import org.itstep.msk.app.entity.Account;
import org.itstep.msk.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by User on 22.11.2019.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByUser (User user);
}
