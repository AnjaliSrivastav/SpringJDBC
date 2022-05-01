package com.spring.jdbc;

import com.spring.jdbc.dao.IStudent;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //to run using config.xml file
       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        //to run using Annotation
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
        IStudent student= applicationContext.getBean("studentImpl", IStudent.class);

        Student student1 = new Student();
        student1.setId(105);
        student1.setName("Abhi");
        student1.setCity("Banglore");
        //int row = student.insertStudent(student1);
      //  System.out.println("Rows inserted : "+row);

        Student student2 = new Student();
        student2.setId(101);
        student2.setName("Ansh");
        student2.setCity("Banglore");

        //int rowsUpdated = student.updateStudent(student2);
       // System.out.println("Rows updated : "+rowsUpdated);


        // int rowsDeleted= student.deleteStudent(101);
         //System.out.println("Rows deleted : "+rowsDeleted);


        List<Student> studentList = student.getAllStudent();
        for(Student s:studentList){
            System.out.println(s);
        }


    }
}
