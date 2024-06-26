package com.in28Minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Build a Rest API so that one someone hits the url /Courses
 * 
 * it will return the Course: id, name, and author 
 * 
 * [
 * 	{
 * 		"id":1,
 * 		"name": "Learn AWS",
 * 		"author": "in28minutes"
 * 	}
 * ]
 * 
 * */
@RestController
public class CourseController {

	
	@RequestMapping("/courses")
	public List<Course> retriveAllCourses(){
		
		return Arrays.asList(
					new Course(1, "Learn AWS", "in28minutes"),
					new Course(2, "Learn DevOps", "in28minutes"),
					new Course(3, "Learn Azure", "in28minutes"),
					new Course(4, "Learn GCP", "in28minutes")
				);
	}
}
