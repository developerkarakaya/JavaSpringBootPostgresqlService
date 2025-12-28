package com.springboot.start.lectureapi.service;
import com.springboot.start.lectureapi.entity.User;
import com.springboot.start.lectureapi.entity.enums.Role;

import java.util.List;

public interface IUserService  extends  IService<User>{
    List<User> getUsersByRole(Role role);
    List<User> getPotentialUsers(List<Integer> idList);
}
