package com.course.service;

import com.course.model.Course;
import com.course.model.Student;
import com.course.exception.CourseFullException;
import com.course.exception.CourseNotFoundException;
import com.course.exception.DuplicateEnrollmentException;


import java.util.ArrayList;
import java.io.*;

public class CourseService {

    private ArrayList <Course> courses = new ArrayList<>();

    public void addCourse(Course jap)
    {
        courses.add(jap);
    }

    public void enrollStudent(int courseId, Student jap) throws CourseFullException, CourseNotFoundException, DuplicateEnrollmentException
    {
        Course found = null;

        for(Course c : courses)
        {
            if(c.getCourseId() == courseId)
            {
                found = c;
                break;
            }
        }

        if(found == null)
        {
            throw new CourseNotFoundException("Course not found");
        }

        if(found.getEnrolledStudents().size() >= found.getMaxSeats())
        {
            throw new CourseFullException("Course is full");
        }

        for(Student s : found.getEnrolledStudents())
        {
            if(s.getStudentId() == jap.getStudentId())
            {
                throw new DuplicateEnrollmentException("Student already enrolled");
            }
        }

        found.getEnrolledStudents().add(jap);

        try
        {
            BufferedWriter jp = new BufferedWriter(new FileWriter("courses.txt", true));
            jp.write(found.getCourseId() + ", " + found.getCourseName() + ", " + jap.getStudentId() + ", " + jap.getStudentName());
            jp.newLine();
            jp.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void viewCourses()
    {
        try
        {
            BufferedReader jp = new BufferedReader(new FileReader("courses.txt"));
            String line;

            while((line = jp.readLine()) != null)
            {
                System.out.println(line + " ");
            }

            jp.close();
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }    
}
