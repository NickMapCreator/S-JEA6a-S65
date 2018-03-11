/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DatabaseCleaner;

/**
 *
 * @author Nick de Kort
 */
public class StudentDaoJpaIT {
    
    /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentTestPU");
    private EntityManager em;
    private EntityTransaction tx;
    private UserDAOJPA studentDao;
    
    public StudentDaoJpaIT() {
    }
    
    @Before
    public void setUp() {
        try {
            new DatabaseCleaner(emf.createEntityManager()).clean();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoJpaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        em = emf.createEntityManager();
        tx = em.getTransaction();

        studentDao = new UserDAOJPA();
        studentDao.setEm(em);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void savingStudentSucceesful() {
        Integer expectedResult = 1;
        User student = new User("Frank", 49, "Java");
        tx.begin();
        studentDao.addStudent(student);
        tx.commit();
        tx.begin();
        int aantal = studentDao.aantal();
        tx.commit();
        assertThat(aantal, is(expectedResult));
    }

    @Test(expected = RollbackException.class)
    public void savingStudentFall() {
        User student = new User("Frank", 49, "Java");
        User student1 = new User("Frank", 49, "JavaScript");
        tx.begin();
        studentDao.addStudent(student);
        studentDao.addStudent(student1);
        tx.commit();
        assertThat(studentDao.aantal(), is(2));
    }

    @Test
    public void findStudentSucceesful() {
        User student = new User("Frank", 49, "Java");
        tx.begin();
        studentDao.addStudent(student);
        User stud = studentDao.findByName("Frank");
        tx.commit();
        assertThat(stud, is(student));
    }*/
}
