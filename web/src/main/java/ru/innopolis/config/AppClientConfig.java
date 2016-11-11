package ru.innopolis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ru.innopolis.service.LessonService;
import ru.innopolis.service.StudentLessonService;
import ru.innopolis.service.StudentService;

@Configuration
public class AppClientConfig {

    @Bean
    public StudentService getStudentServiceBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:5000/studentService");
        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (StudentService) rmiProxyFactoryBean.getObject();
    }

    @Bean
    public LessonService getLessonServiceBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:5000/lessonService");
        rmiProxyFactoryBean.setServiceInterface(LessonService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (LessonService) rmiProxyFactoryBean.getObject();
    }

    @Bean
    public StudentLessonService getStudentLessonServiceBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:5000/studentLessonService");
        rmiProxyFactoryBean.setServiceInterface(StudentLessonService.class);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.afterPropertiesSet();
        return (StudentLessonService) rmiProxyFactoryBean.getObject();
    }
}
