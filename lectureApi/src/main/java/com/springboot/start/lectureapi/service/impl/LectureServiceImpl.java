package com.springboot.start.lectureapi.service.impl;

import com.springboot.start.lectureapi.common.GeneralException;
import com.springboot.start.lectureapi.entity.Lecture;
import com.springboot.start.lectureapi.repository.ILectureRepository;
import com.springboot.start.lectureapi.service.ILectureService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements ILectureService {
   private final ILectureRepository lectureRepository;

    public LectureServiceImpl(ILectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture Save(Lecture lecture) {

        if(StringUtils.isEmpty(lecture.getName())) {
            throw new GeneralException("İsim bilgisi boş olamaz !");
        }
        if(lecture.getTeacher() == null) {
            throw new GeneralException("Öğretmen bilgisi boş olamaz!");
        }
        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture getById(Integer id) {
        return lectureRepository.findById(id).orElseThrow(()-> new GeneralException("Bilgisi getiriecek bir ders bulunamadı."));
    }

    @Override
    public List<Lecture> getAll() {
        return lectureRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (!lectureRepository.existsById(id)) {
            throw new GeneralException("Silinecek ders kaydı bulunamadı.");
        }
        lectureRepository.deleteById(id);
    }
}
