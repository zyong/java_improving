package app;

import aop.ISchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@Configuration
@Import(Student.class)
@ConfigurationProperties(prefix = "school")
public class School implements ISchool {

    @Autowired
    Klass class1;

    @Resource
    Student student100;
    
    @Override
    public void ding(){

        System.out.println( "Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        
    }
    
}
