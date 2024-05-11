package dev.skyherobrine.server.services;

import dev.skyherobrine.server.dto.AchieveStudy;
import dev.skyherobrine.server.repositories.EnrollCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {

    @Autowired
    private EnrollCourseRepository ecr;

    public List<AchieveStudy> getAchieveStudyInfo(String id) {
        return ecr.findByStudent_IdOrderByCcsID_CourseClassID_SemesterYearAsc(id)
                .stream()
                .map(ec -> new AchieveStudy(
                     ec.getCcsID().getCourseClassID().getSemester(),
                     ec.getCcsID().getCourseClassID().getSemesterYear(),
                     ec.getCcsID().getCourseClassID().getCourseClassId(),
                     ec.getCcsID().getCourseClassID().getCourseID().getCourseName(),
                     ec.getCcsID().getCourseClassID().getCourseID().getCredits(),
                     ec.getMiddleExam(),
                     ec.getRs1(),
                     ec.getRs2(),
                     ec.getRs3(),
                     ec.getPs1(),
                     ec.getPs2(),
                     ec.getPs3(),
                     ec.getFinalExam(),
                     ec.getAverage(),
                     ec.getScoreFollow4(),
                     ec.scoreLetter(),
                     ec.getRanks()
               ))
                .toList();
    }
}
