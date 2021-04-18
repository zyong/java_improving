package app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student implements Serializable {


    private int id;
    private String name;

    public void init() {
        System.out.println("hello...........");
    }

    public void print() {
        System.out.println("  student id: " + id + " student name: " + name + " \n");
    }


}
