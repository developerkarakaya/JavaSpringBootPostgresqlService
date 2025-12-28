package com.springboot.start.lectureapi.repository;

import com.springboot.start.lectureapi.entity.User;
import com.springboot.start.lectureapi.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    boolean existsByIdentityNo(String identityNo);
    List<User> findAllByRole(Role role);
    List<User> findAllByRoleAndIdIsNotIn(Role role,List<Integer> idList);
}
