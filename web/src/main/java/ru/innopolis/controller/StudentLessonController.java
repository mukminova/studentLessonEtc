package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.service.LessonService;
import ru.innopolis.service.StudentLessonService;
import ru.innopolis.service.StudentService;
import ru.innopolis.model.StudentsLesson;

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
        StudentsLesson studentsLesson = new StudentsLesson();
        studentsLesson.setStudentId(Integer.parseInt(request.getParameter("studentId")));
        studentsLesson.setLessonId(Integer.parseInt(request.getParameter("lessonId")));
        studentLessonService.addStudentLesson(studentsLesson);
        return "index";
    }
}
