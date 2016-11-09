package ru.innopolis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.service.LessonService;
import ru.innopolis.common.service.StudentLessonService;
import ru.innopolis.common.service.StudentService;
import ru.innopolis.server.entity.StudentsLessonEntity;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentLessonController {
    @Autowired
    LessonService lessonService;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentLessonService studentLessonService;

    /**
     * форма отображения списка студентов и уроков
     *
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/studentWithLesson", method = RequestMethod.GET)
    public ModelAndView studentGetList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentWithLesson");
        mv.addObject("lessonList", lessonService.getLessonList());
        mv.addObject("studentList", studentService.getList());
        return mv;
    }

    /**
     * добавление связи
     *
     * @param request
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/addStudentLesson")
    public String studentPostList(HttpServletRequest request) {
        StudentsLessonEntity studentsLessonEntity = new StudentsLessonEntity();
        studentsLessonEntity.setStudentsByStudentId(studentService.getStudentById(Integer.parseInt(request.getParameter("studentId"))));
        studentsLessonEntity.setLessonsByLessonId(lessonService.getLessonByLessonId(Integer.parseInt(request.getParameter("lessonId"))));
        studentLessonService.addStudentLesson(studentsLessonEntity);
        return "index";
    }
}
