package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentImpl")  //this annotation is used if @Bean is not present in JdbcConfig class to define the Bean
public class StudentImpl implements IStudent {
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired  //If we use @Autowire, then no need to define StudentImpl Bean in JdBcConfig class using @Bean annotation
    private JdbcTemplate jdbcTemplate;

    public int insertStudent(Student student){
        String query = "INSERT INTO student(id,NAME,city)VALUES(?,?,?)";
        int count = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return count;
    }

    public int updateStudent(Student student){
        String query = "update student set name=?,city=? where id=?";
        int count = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return count;
    }

    public int deleteStudent(int studentId){
        String query = "delete from student where id=?";
        int count = this.jdbcTemplate.update(query,studentId);
        return count;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
        return students;
    }
}
