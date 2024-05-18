package dev.skyherobrine.server.controllers.management.impl;

import dev.skyherobrine.server.controllers.management.IManagement;
import dev.skyherobrine.server.messages.send.ManagementProducer;
import dev.skyherobrine.server.models.CourseClass;
import dev.skyherobrine.server.models.CourseClassScheduled;
import dev.skyherobrine.server.models.Response;
import dev.skyherobrine.server.repositories.CourseClassScheduledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/course-class-scheduled")
public class CourseClassScheduledManagementController implements IManagement<CourseClassScheduled,Long> {

    @Autowired
    private CourseClassScheduledRepository ccsr;
    @Autowired
    private ManagementProducer producer;

    @PutMapping("add")
    @Override
    public ResponseEntity add(@RequestBody CourseClassScheduled courseClassScheduled) {
        try {
            CourseClassScheduled ccs = ccsr.save(courseClassScheduled);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Add successfully!",
                    new HashMap<>(){{
                        put("data", ccs);
                    }}
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Add failed!",
                    new HashMap<>() {{
                        put("error", e.getCause());
                        put("data", null);
                    }}
            ));
        }
    }

    @Override
    public ResponseEntity update(CourseClassScheduled courseClassScheduled) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long aLong) {
        return null;
    }

    @GetMapping("get/{id}")
    @Override
    public ResponseEntity getById(@PathVariable Long id) {
        CourseClassScheduled ccs = ccsr.findById(id).orElse(null);
        return ResponseEntity.ok(new Response(
                ccs != null ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value(),
                ccs != null ? "Find successfully!" : "Can't found the course class scheduled!",
                new HashMap<>(){{
                    put("data", ccs);
                }}
        ));
    }

    @GetMapping("get-all")
    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all course class scheduled!",
                new HashMap<>(){{
                    put("data", ccsr.findAll());
                }}
        ));
    }

    @GetMapping("get-by-course-class/{id}")
    public ResponseEntity getAllByCourseClassID(@PathVariable String id) {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all course class scheduled by course class id",
                new HashMap<>(){{
                    put("data", ccsr.findByCourseClassID_CourseClassIdOrderByGroupPracticeAsc(id).toList());
                }}
        ));
    }
}
