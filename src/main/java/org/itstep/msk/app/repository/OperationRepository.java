package org.itstep.msk.app.repository;


import org.itstep.msk.app.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 22.11.2019.
 */
public interface OperationRepository extends JpaRepository<Operation, Integer> {
}
