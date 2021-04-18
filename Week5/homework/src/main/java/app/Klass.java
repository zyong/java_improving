package app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "klass")
@Setter
@Getter
public class Klass {

    @Autowired
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
