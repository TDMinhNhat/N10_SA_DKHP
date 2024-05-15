package dev.skyherobrine.server.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Table(name = "CourseClassScheduled")
@Getter @Setter @NoArgsConstructor
public class CourseClassScheduled {
    @Id @Column(name = "ScheduledID") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Room", length = 10, nullable = false)
    private String room;
    @Column(name = "FromLessonTime", nullable = false)
    private int fromLessonTime;
    @Column(name = "ToLessonTime", nullable = false)
    private int toLessonTime;
    @Column(name = "FromDate", nullable = false)
    private LocalDate fromDate;
    @Column(name = "ToDate", nullable = false)
    private LocalDate toDate;
    @Column(name = "GroupPractice")
    private Integer groupPractice;
    @Column(name = "MaxStudents", nullable = false)
    private int maxStudents;
    @ManyToOne @JoinColumn(name = "TeacherID", nullable = false)
    private Teacher teacherId;
    @ManyToOne @JoinColumn(name = "CourseClassID", nullable = false)
    private CourseClass courseClassID;

    public CourseClassScheduled(long id, String room, int fromLessonTime, int toLessonTime, LocalDate fromDate, LocalDate toDate, int groupPractice, int maxStudents, Teacher teacherId, CourseClass courseClassID) {
        this.id = id;
        this.room = room;
        this.fromLessonTime = fromLessonTime;
        this.toLessonTime = toLessonTime;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.groupPractice = groupPractice;
        this.maxStudents = maxStudents;
        this.teacherId = teacherId;
        this.courseClassID = courseClassID;
    }
}