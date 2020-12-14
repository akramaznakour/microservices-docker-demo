package com.okta.developer.docker_microservices.service.services;

import com.okta.developer.docker_microservices.service.dao.CourseDao;
import com.okta.developer.docker_microservices.service.dao.StudentDao;
import com.okta.developer.docker_microservices.service.dao.TeacherDao;
import com.okta.developer.docker_microservices.service.dao.TeachingClassDao;
import com.okta.developer.docker_microservices.service.entities.Student;
import com.okta.developer.docker_microservices.service.entities.Course;
import com.okta.developer.docker_microservices.service.entities.Teacher;
import com.okta.developer.docker_microservices.service.entities.TeachingClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class DataFillerService {

    private final CourseDao courseDAO;
    private final TeacherDao teacherDAO;
    private final TeachingClassDao teachingClassDAO;
    private final StudentDao studentDAO;

    public DataFillerService(CourseDao courseDAO, TeacherDao teacherDAO, TeachingClassDao teachingClassDAO, StudentDao studentDAO) {
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
        this.teachingClassDAO = teachingClassDAO;
        this.studentDAO = studentDAO;
    }


    @PostConstruct
    @Transactional
    public void fillData(){


        Teacher pj = new Teacher(
                "Profesor P1",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/",
                "Profesor1@yahoo_.com"
        );

        Teacher px = new Teacher(
                "Professor P2",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-",
                "Profesor2@yahoo_..com"

        );

        teacherDAO.save(pj);
        teacherDAO.save(px);

        // create courses
        Course mathematics = new Course("Course Y", 20, (short) 10);
        Course spanish = new Course("Course Z", 20, (short) 10);
        Course dealingWithUnknown = new Course("Course A", 10, (short) 100);
        Course handlingYourMentalPower = new Course("Course B", 50, (short) 100);
        Course introductionToPsychology = new Course("Course C", 90, (short) 100);

        courseDAO.save(mathematics);
        courseDAO.save(spanish);
        courseDAO.save(dealingWithUnknown);
        courseDAO.save(handlingYourMentalPower);
        courseDAO.save(introductionToPsychology);

        // classes

        Student studendChaves = studentDAO.save(new Student("Student S1", (short) 34));
        Student studendQuico = studentDAO.save(new Student("Student S2", (short) 35));
        Student studendCyclops = studentDAO.save(new Student("Student S3", (short) 25));
        Student studentIceman = studentDAO.save(new Student("Student S4", (short) 30));
        Student studendArchangel = studentDAO.save(new Student("Student S5", (short) 29));

        teachingClassDAO.save(
                new TeachingClass(mathematics, pj, Arrays.asList(studendChaves, studendQuico), 1988)
        );

        teachingClassDAO.save(
                new TeachingClass(spanish, pj, Arrays.asList(studendChaves, studendQuico), 1988)
        );

        teachingClassDAO.save(
                new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendCyclops, studentIceman), 1995)
        );

        teachingClassDAO.save(
                new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendArchangel), 1996)
        );


    }
}
