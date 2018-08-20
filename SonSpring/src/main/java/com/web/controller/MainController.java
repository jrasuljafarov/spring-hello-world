package com.web.controller;


import com.web.DaoServices.ServiceLessonDao;
import com.web.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {


	private ServiceLessonDao serviceLessonDao;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
	public ModelAndView getStudentList(){

		ModelAndView model=new ModelAndView();
		model.setViewName("student/studentList");
		try {
			List<Student> studentList=serviceLessonDao.getStudentList();
			model.addObject("studentList",studentList);
		}catch (Exception ex){
			ex.printStackTrace();
		}

		return model;
	}


}