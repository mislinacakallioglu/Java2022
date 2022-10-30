package kodlamaIO.business;

import kodlamaIO.core.Logger;
import kodlamaIO.dataAccess.CourseDao;
import kodlamaIO.entities.Course;

import java.util.List;

public class CourseManager {

    private CourseDao courseDao;
    private Logger[] loggers;
    private Course[] courses;

    public CourseManager(CourseDao courseDao,Logger[] loggers,Course[] courses){
        this.courseDao=courseDao;
        this.loggers=loggers;
        this.courses=courses;
    }

    public void add(Course course) throws Exception{
       for (Course course1:courses){
           if (course1.getCourseName()==course.getCourseName()){
               throw new Exception("Girdiginiz kurs adi kullanilmaktadir, lutfen baska bir kurs adi giriniz! ");
           }
       }
       if (course.getCoursePrice()<0){
           throw new Exception("Kurs ucreti 0'dan kucuk olamaz. ");
       }
       courseDao.add(course);

       for (Logger logger:loggers){
           logger.log(course.getCourseName());
       }
    }

}
