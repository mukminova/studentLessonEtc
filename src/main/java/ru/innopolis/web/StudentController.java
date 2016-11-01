package ru.innopolis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.service.StudentService;
import ru.innopolis.server.model.Students;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@Component
public class StudentController {
    @Autowired
    StudentService studentService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * список студентов
     *
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public ModelAndView studentList() throws ClassNotFoundException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentList");
        mv.addObject("mapWithCounts", studentService.getMapWithCounts());
        mv.addObject("list", studentService.getList());
        return mv;
    }

    /**
     * форма добавления студента
     *
     * @return
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudentGet() throws ClassNotFoundException, ParseException {
        return "addStudent";
    }

    /**
     * сохранение данных с формы добавления студента
     *
     * @param request
     * @return
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudentPost(HttpServletRequest request) throws ClassNotFoundException, ParseException {
        Students student = new Students();
        student.setName(request.getParameter("studentName"));
        student.setLname(request.getParameter("studentLastName"));
        student.setSex(request.getParameter("studentSex"));
        student.setBirthday(new java.sql.Date(sdf.parse(request.getParameter("studentBirthday")).getTime()));
        studentService.addStudent(student);
        return this.studentList();
    }

    /**
     * отображение конкретного студента
     *
     * @param request
     * @param studentId
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/viewStudent/{studentId}")
    public ModelAndView viewStudent(HttpServletRequest request, @PathVariable("studentId") Integer studentId) throws ClassNotFoundException {
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
     * @param request
     * @param studentId
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/updateStudent/{studentId}", method = RequestMethod.GET)
    public ModelAndView viewUpdateStudent(HttpServletRequest request, @PathVariable("studentId") Integer studentId) throws ClassNotFoundException {
        ModelAndView mv = new ModelAndView();
        Students student = studentService.getStudentById(studentId);
        request.setAttribute("studentId", studentId);
        request.setAttribute("studentName", student.getName());
        request.setAttribute("studentLastName", student.getLname());
        request.setAttribute("studentSex", student.getSex());
        request.setAttribute("studentBirthday", student.getBirthday());
        mv.setViewName("updateStudent");
        return mv;
    }

    /**
     * сохранение данных с формы редактирования
     *
     * @param request
     * @param studentId
     * @return
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    @RequestMapping(value = "/updateStudent/{studentId}", method = RequestMethod.POST)
    public ModelAndView updateStudent(HttpServletRequest request, @PathVariable("studentId") Integer studentId) throws ClassNotFoundException, ParseException {
        Students student = new Students();
        student.setStudentId(studentId);
        student.setName(request.getParameter("studentName"));
        student.setLname(request.getParameter("studentLastName"));
        student.setSex(request.getParameter("studentSex"));
        student.setBirthday(new java.sql.Date(sdf.parse(request.getParameter("studentBirthday")).getTime()));
        studentService.updateStudent(student);
        return this.studentList();
    }

    /**
     * удаление конкретного студента
     *
     * @param studentId
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/deleteStudent/{studentId}")
    public ModelAndView deleteStudent(@PathVariable("studentId") Integer studentId) throws ClassNotFoundException {
        studentService.deleteStudentById(studentId);
        return this.studentList();
    }

    /**
     * фильтр по имени
     *
     * @param request
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView filterStudentList(HttpServletRequest request) throws ClassNotFoundException {
        ModelAndView mv = new ModelAndView();
        Students student = new Students();
        student.setName(request.getParameter("filterByName"));
        mv.setViewName("studentList");
        mv.addObject("list", studentService.filterStudent(student));
        return mv;
    }

    /**
     * сортировка по полю
     *
     * @param sortField
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/sortStudent/{sortField}")
    public ModelAndView filterStudentList(@PathVariable("sortField") String sortField) throws ClassNotFoundException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentList");
        mv.addObject("mapWithCounts", studentService.getMapWithCounts());
        mv.addObject("list", studentService.sortStudentsByField(sortField));
        return mv;
    }
}
