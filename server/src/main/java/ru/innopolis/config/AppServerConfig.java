package ru.innopolis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ru.innopolis.service.*;

@Configuration
@ComponentScan("ru.innopolis")
public class AppServerConfig {
    @Autowired
    StudentService studentService;
    @Autowired
    LessonService lessonService;
    @Autowired
    StudentLessonService studentLessonService;


    @Bean
    public RmiServiceExporter registerStudentService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("studentService");
        rmiServiceExporter.setService(studentService);
        rmiServiceExporter.setServiceInterface(StudentService.class);
        rmiServiceExporter.setRegistryPort(5000);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter registerLessonService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("lessonService");
        rmiServiceExporter.setService(lessonService);
        rmiServiceExporter.setServiceInterface(LessonService.class);
        rmiServiceExporter.setRegistryPort(5000);
        return rmiServiceExporter;
    }

    @Bean
    public RmiServiceExporter registerStudentLessonService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("studentLessonService");
        rmiServiceExporter.setService(studentLessonService);
        rmiServiceExporter.setServiceInterface(StudentLessonService.class);
        rmiServiceExporter.setRegistryPort(5000);
        return rmiServiceExporter;
    }


}
