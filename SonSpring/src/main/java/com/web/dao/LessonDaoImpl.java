package com.web.dao;

import com.web.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class LessonDaoImpl implements LessonDao {

    @Autowired
    private DataSource dataSource;
    
    @Override
    public List<Student> getStudentList() {
        List<Student> studentList=null;
        try{
            JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
            String sql="select id,name,surname,dob,adress from webdb.student where active=1";
            studentList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
            System.out.println(studentList);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return studentList;

    }
}
