package ru.innopolis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.innopolis.common.service.LessonService;

/**
 * test for lesson controller
 */
@Component
public class LessonControllerTest {
    /**
     *
     */
    @Autowired
    LessonService lessonService;

//    @Test
//    public void lessonList() throws Exception {
//        List<Lessons> expectedLessons = asList(new Lessons(), new Lessons(), new Lessons());
//        // Фиктивный объект LessonService
//        LessonService lessonService = mock(LessonService.class);
//        when(lessonService.getLessonList()).thenReturn(expectedLessons);
//        // Создать контроллер
//        LessonController controller = new LessonController();
////        Map<String, Object> entity = new HashMap<String, Object>();
//        // Вызвать обработчик
//        ModelAndView view = controller.lessonList();
//        assertEquals("lessonList", view.getViewName());
//        // Проверить результаты
////        assertSame(expectedLessons, entity.get("spittles"));
//        verify(lessonService).getLessonList();
//    }


}
