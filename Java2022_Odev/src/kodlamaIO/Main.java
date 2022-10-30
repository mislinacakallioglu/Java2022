package kodlamaIO;

import kodlamaIO.business.CategoryManager;
import kodlamaIO.business.CourseManager;

import kodlamaIO.business.InsructorManager;
import kodlamaIO.core.Logger;
import kodlamaIO.core_logging.DatabaseLogger;
import kodlamaIO.core_logging.FileLogger;
import kodlamaIO.dataAccess.HibernateCategoryDao;
import kodlamaIO.dataAccess.JdbcCourseDao;
import kodlamaIO.dataAccess.JdbcInstructorDao;
import kodlamaIO.entities.Category;
import kodlamaIO.entities.Course;
import kodlamaIO.entities.Instructor;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception{

        Course course1=new Course(1,"Java Kampi",123);
        Category category1=new Category(1,"Yazilim ve Programlama");
        Instructor instructor1=new Instructor(1,"Engin" ,"Demirog");

        //List<Course> courses = new ArrayList<Course>();
       // List<Category> categories = new ArrayList<Category>();
        Course[] courses = {
                new Course(3,"Python ile yazılımcı yetiştirme kampı",1)

        };


        Category[] categories = {
                new Category(2,"Otomasyon")

        };


        Logger[] loggers = {new DatabaseLogger(),new FileLogger()};

        CourseManager courseManager = new CourseManager(new JdbcCourseDao(),loggers,courses);
        courseManager.add(course1);

        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(),loggers,categories);
        categoryManager.add(category1);

        InsructorManager insructorManager= new InsructorManager(new JdbcInstructorDao(),loggers);
        insructorManager.add(instructor1);

    }
}
