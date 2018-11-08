package net.similarsu.happyjpa.repository;

import net.similarsu.happyjpa.HappyJpaApplicationTests;
import net.similarsu.happyjpa.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRepositoryTest extends HappyJpaApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void contextLoads() {
        Student student = new Student();
        student.setName("xx");
        student.setAge(10);
        studentRepository.save(student);

        Student stu = studentRepository.getOne(student.getId());
        System.out.println(stu);
    }
}
