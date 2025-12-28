package com.springboot.start.lectureapi.service;
import java.util.List;

public interface IService <T>{

    T Save(T t);
    T getById(Integer id);
    List<T> getAll();
    void delete(Integer id);
}
