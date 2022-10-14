package kodlamaIO.business;

import kodlamaIO.core.Logger;
import kodlamaIO.dataAccess.InstructorDao;
import kodlamaIO.entities.Instructor;

public class InsructorManager {
    private InstructorDao instructorDao;
    private Logger[] loggers;

    public InsructorManager(InstructorDao instructorDao,Logger[] loggers){
        this.instructorDao=instructorDao;
        this.loggers=loggers;
    }
    public void add(Instructor instructor){
        instructorDao.add(instructor);

        for (Logger logger: loggers){
            logger.log(instructor.getFirstName() +"" + instructor.getLastNmae());
        }
    }
}
