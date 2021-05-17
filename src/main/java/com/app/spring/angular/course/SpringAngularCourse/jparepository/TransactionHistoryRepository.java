package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.TransactionHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by jose de leon on 5/17/2021.
 */
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    @Query("select t from TransactionHistory t where lower(t.userDebt) like lower(concat('%', ?1,'%')) or lower(t.userReceive) like lower(concat('%', ?1,'%'))")
    List<TransactionHistory> findByTransactionUser(String name, Pageable page);
}
