package ru.innopolis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.innopolis.config.AppServerConfig;


public class AppServer {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppServerConfig.class);
        ctx.refresh();
    }
}
