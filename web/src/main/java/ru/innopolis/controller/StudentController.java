package ru.innopolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.service.StudentService;
import ru.innopolis.model.Students;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * список студентов
     *
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public ModelAndView studentList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentList");
        mv.addObject("list", studentService.getList());
        return mv;
    }

    /**
     * форма добавления студента
     *
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudentGet() {
        return "addStudent";
    }

    /**
     * сохранение данных с формы добавления студента
     *
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute("studentForm") @Validated Students student, BindingResult bindingResult) throws ParseException {
        studentService.updateStudent(student);
        return this.studentList();
    }

    /**
     * отображение конкретного студента
     *
     * @param request
     * @param studentId
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/viewStudent/{studentId}")
    public ModelAndView viewStudent(HttpServletRequest request, @PathVariable("studentId") Integer studentId) {
        ModelAndView mv = new ModelAndView();
        Students student = studentService.getStudentById(studentId);
        request.setAttribute("studentName", student.getName());
        request.setAttribute("studentLastName", student.getLname());
        request.setAttribute("studentSex", student.getSex());
        request.setAttribute("studentBirthday", student.getBirthday());
        mv.setViewName("viewStudent");
        return mv;
    }

    /**
     * форма редактирования данных студента
     *
     * @param studentId
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/updateStudent/{studentId}", method = RequestMethod.GET)
    public ModelAndView viewUpdateStudent(@PathVariable("studentId") Integer studentId) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", studentService.getStudentById(studentId));
        mv.setViewName("updateStudent");
        return mv;
    }

    /**
     * сохранение данных с формы редактирования
     *
     * @return
     * @throws ParseException
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/updateStudent/{studentId}", method = RequestMethod.POST)
    public ModelAndView updateStudent(@ModelAttribute("studentForm") @Validated Students student, BindingResult bindingResult) throws ParseException {
        studentService.updateStudent(student);
        return this.studentList();
    }

    /**
     * удаление конкретного студента
     *
     * @param studentId
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/deleteStudent/{studentId}")
    public ModelAndView deleteStudent(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudentById(studentId);
        return this.studentList();
    }

    /**
     * фильтр по имени
     *
     * @param request
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView filterStudentList(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentList");
        mv.addObject("list", studentService.filterStudent(request.getParameter("filterByName")));
        return mv;
    }

    /**
     * сортировка по полю
     *
     * @param sortField
     * @return
     */
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/sortStudent/{sortField}")
    public ModelAndView filterStudentList(@PathVariable("sortField") String sortField) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentList");
//        mv.addObject("list", studentService.sortStudentsByField(sortField));
        return mv;
    }
}
