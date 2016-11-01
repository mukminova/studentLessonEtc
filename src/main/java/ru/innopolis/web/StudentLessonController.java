package ru.innopolis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.service.LessonService;
import ru.innopolis.common.service.StudentLessonService;
import ru.innopolis.common.service.StudentService;

import javax.servlet.http.HttpServletRequest;

@Controller
@Component
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
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/studentWithLesson", method = RequestMethod.GET)
    public ModelAndView studentGetList() throws ClassNotFoundException {
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
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/addStudentLesson")
    public String studentPostList(HttpServletRequest request) throws ClassNotFoundException {
        studentLessonService.addStudentLesson(Integer.parseInt(request.getParameter("studentId")), Integer.parseInt(request.getParameter("lessonId")));
        return "index";
    }
}
