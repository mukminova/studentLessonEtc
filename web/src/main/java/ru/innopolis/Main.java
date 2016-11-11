package ru.innopolis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.innopolis.config.AppClientConfig;
import ru.innopolis.service.LessonService;

/**
 * Created by Li on 10.11.16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        new AnnotationConfigApplicationContext(AppClientConfig.class);
    }
}
