package ru.innopolis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.innopolis.config.AppClientConfig;

/**
 * Created by Li on 10.11.16.
 */
public class Main {

    public static void main(String[] args)  {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppClientConfig.class);
        ctx.refresh();
    }
}
