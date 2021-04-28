package com.app.spring.angular.course.SpringAngularCourse.jparepository;

import com.app.spring.angular.course.SpringAngularCourse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by jose de leon on 4/28/2021.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<List<User>> findByStatus(String status);

    Optional<User> findByUsernameOrEmailAndStatus(String username, String email, String status);

    Optional<User> findByUsernameOrEmail(String username, String email);

}
