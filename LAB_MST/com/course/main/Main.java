package com.course.main;

import com.course.model.Course;
import com.course.model.Student;
import com.course.service.CourseService;
import com.course.exception.CourseFullException;
import com.course.exception.CourseNotFoundException;
import com.course.exception.DuplicateEnrollmentException;

public class Main
{
    public static void main(String[] args)
    {
        CourseService service = new CourseService();

        Course c1 = new Course(1, "OOPS with Java", 2);
        Course c2 = new Course(2, "Full Stack - I",3);

        service.addCourse(c1);
        service.addCourse(c2);

        Student s1 = new Student(10785, "Japjit Singh");
        Student s2 = new Student(10039, "Abhineet");
        Student s3 = new Student(10239, "Saini");

        try
        {
            service.enrollStudent(1,s1);
            service.enrollStudent(1,s2);
            service.enrollStudent(1,s3);
        }

        catch(CourseNotFoundException jp)
        {
            System.out.println(jp.getMessage());
        }

        catch(CourseFullException jp)
        {
            System.out.println(jp.getMessage());
        }

        catch(DuplicateEnrollmentException jp)
        {
            System.out.println(jp.getMessage());
        }

        service.viewCourses();
    }
}