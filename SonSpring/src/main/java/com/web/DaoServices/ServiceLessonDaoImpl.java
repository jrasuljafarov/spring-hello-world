package com.web.DaoServices;

import com.web.Model.Student;
import com.web.dao.LessonDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceLessonDaoImpl implements ServiceLessonDao {

    @Autowired
    private LessonDao lessonDao;

    @Override
    public List<Student> getStudentList() {

        return lessonDao.getStudentList();
        
    }
}
