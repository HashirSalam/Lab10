package pk.edu.nust.seecs.gradebook;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.dao.GradeDao;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;

import pk.edu.nust.seecs.gradebook.entity.*;

/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) throws ParseException {
        CloDao clodao = new CloDao();
        ContentDao contentDao = new ContentDao();
        CourseDao courseDao = new CourseDao();
        GradeDao gradeDao = new GradeDao();
        StudentDao studentDao = new StudentDao();
        TeacherDao teacherDao = new TeacherDao();

        String inputString = "11-11-2012";
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date inputDate = dateFormat.parse(inputString);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
      System.out.println("Welcome to Gradebook\n");
        System.out.println("1) Add CLO\n");
        System.out.println("2) Add Teacher\n");
        System.out.println("3) Add Course\n");
        System.out.println("4) Add Content\n");
        System.out.println("5) Add Student\n");
        System.out.println("6) Add Grade\n");
        System.out.println("7) Print all information :\n");

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int choice = reader.nextInt();
        // Add new clo
        if(choice == 1)
        {
            Clo clo = new Clo();
            clo.setName("CLO 1");
            clo.setDescription("Design efficient solutions for algorithmic problems");
            clo.setPlo("2");
            clodao.addClo(clo);
        }
        else if(choice == 2)
        {

            System.out.println("Enter Teacher name: ");
            String name = reader.next();
            Teacher teacher = new Teacher(name);
            teacherDao.addTeacher(teacher);
        }
        else if(choice == 3)
        {
            System.out.println("Enter Teacher name: ");
            String name = reader.next();
            Teacher teacher = new Teacher(name);
            teacherDao.addTeacher(teacher);
            // Add new course
            Course course = new Course();
            System.out.println("Enter Class Title: ");
            String title = reader.next();
            course.setClasstitle(title);
            System.out.println("Enter Credit Hours: ");
            int credit = reader.nextInt();
            course.setCreditHours(credit);

            course.setEndsOn(inputDate);
            course.setStartsOn(inputDate);
            course.setTeacher(teacher);

            courseDao.addCourse(course);
        }
        else if(choice == 4)
        {
            Course course = new Course();
            // Add new content
            Content content = new Content();
            content.setDescription("Blah Blah");
            content.setEndtime(inputDate);
            content.setStarttime(inputDate);
            content.setEndtime(inputDate);
            content.setTitle("Title");
            content.setCourse(course);

            contentDao.addContent(content);
        }
        else if(choice == 5)
        {
            Student student = new Student();
            System.out.println("Enter Student name: ");
            String name = reader.next();
            student.setName(name);
            studentDao.addStudent(student);
        }
        else if(choice == 6)
        {
            Course course = new Course();
            // Add new content

            Content content = new Content();
            System.out.println("Enter Course Title: ");
            String name = reader.next();
            content.setTitle(name);
            System.out.println("Enter Course Description: ");
            String desc = reader.next();
            content.setDescription(desc);
            content.setEndtime(inputDate);
            content.setStarttime(inputDate);
            content.setEndtime(inputDate);

            content.setCourse(course);

            contentDao.addContent(content);
            Grade grade = new Grade();
            grade.setName("Test");
            grade.setScore(100);
            grade.setContentItem(content);

            gradeDao.addGrade(grade);

        }
        else if (choice == 7)
        {
            System.out.println("\nALL CLOS :\n");
            for (Clo iter : clodao.getAllClos()) {
                System.out.println(iter);
            }
            System.out.println("\nALL Teachers :\n");
            for (Teacher iter :  teacherDao.getAllTeachers()) {
                  System.out.println(iter);
            }
            System.out.println("\nALL Students :\n");
            for (Student iter :  studentDao.getAllStudents()) {
            System.out.println(iter);
          }

        }


    }

}