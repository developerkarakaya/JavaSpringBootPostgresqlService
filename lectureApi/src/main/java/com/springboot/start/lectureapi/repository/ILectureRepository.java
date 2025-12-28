package com.springboot.start.lectureapi.repository;

import com.springboot.start.lectureapi.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILectureRepository  extends JpaRepository<Lecture,Integer> {
}
