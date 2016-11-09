package ru.innopolis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.common.service.LessonService;


@Controller
public class LessonController {
    @Autowired
    LessonService lessonService;

    /**
     * список занятий
     *
     * @return
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/lessonList", method = RequestMethod.GET)
    public ModelAndView lessonList()  {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("lessonList");
        mv.addObject("list", lessonService.getLessonList());
        return mv;
    }
}
