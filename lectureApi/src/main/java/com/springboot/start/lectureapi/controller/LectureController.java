package com.springboot.start.lectureapi.controller;

import com.springboot.start.lectureapi.entity.Lecture;
import com.springboot.start.lectureapi.entity.User;
import com.springboot.start.lectureapi.entity.enums.Role;
import com.springboot.start.lectureapi.service.ILectureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {
        private final ILectureService lectureService;


    public LectureController(ILectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    ResponseEntity<List<Lecture>> getAll() {
        return ResponseEntity.ok(lectureService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Lecture> getLectureById(@PathVariable Integer id) {
        return  ResponseEntity.ok(lectureService.getById(id));
    }

    @PostMapping
    ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture) {
        return  ResponseEntity.ok(lectureService.Save(lecture));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteLectures(@PathVariable Integer id) {
        lectureService.delete(id);
        return ResponseEntity.ok().build();
    }

}

