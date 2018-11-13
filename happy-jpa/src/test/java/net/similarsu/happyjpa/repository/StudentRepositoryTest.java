package net.similarsu.happyjpa.repository;

import net.similarsu.happyjpa.HappyJpaApplicationTests;
import net.similarsu.happyjpa.entity.Classroom;
import net.similarsu.happyjpa.entity.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StudentRepositoryTest extends HappyJpaApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    private List<String> nameList = new ArrayList<>();

    private List<Integer> ageList = new ArrayList<>();

    @Before
    public void setUp(){
        nameList.add("杨朝来");
        nameList.add("蒋平");
        nameList.add("唐灿华");
        nameList.add("马达");
        nameList.add("赵小雪");
        nameList.add("薛文泉");
        nameList.add("丁建伟");
        nameList.add("凡小芬");
        nameList.add("文明");
        nameList.add("文彭凤");
        nameList.add( "王丽");
        nameList.add("王建华");
        nameList.add("王梓人");
        nameList.add("王震");
        nameList.add("王保真");
        nameList.add("王景亮");
        nameList.add("王丹");
        nameList.add("邓志勇");
        nameList.add("邓婕");

        ageList.add(8);
        ageList.add(9);
        ageList.add(10);
        ageList.add(11);
        ageList.add(12);
        ageList.add(13);
        ageList.add(14);
    }

    @Test
    public void initStudents() {
        List<Classroom> classroomList = classroomRepository.findAll(Sort.by(Sort.Order.asc("name")));
        classroomList.stream().forEach((classroom) -> {
            int students = 35 + toRandom(6);
            IntStream.rangeClosed(1,students).forEach(i -> {
                Student student = new Student();
                student.setName(nameList.get(toRandom(nameList.size())));
                student.setAge(ageList.get(toRandom(ageList.size())));
                student.setClassroom(classroom);
                studentRepository.save(student);
            });
        });

    }

    @Test
    public void findByClassroom_nameAndAgeBetween(){
        String className = "1年1班";
        int minAge = 12;
        int maxAge = 15;
        List<Student> studentList= studentRepository.findByClassroom_nameAndAgeBetween(className, minAge ,maxAge);
        Assertions.assertNotEquals(studentList.size(),0);
    }

    @Test
    public void findByName(){
        String name = nameList.get(toRandom(nameList.size()));
        Page<Student> studentPage = studentRepository.findByName(name, PageRequest.of(1,10,Sort.by(Sort.Order.asc("age"))));
        Assertions.assertAll(()->{
            Assertions.assertNotNull(studentPage.getContent().size());
        });
    }

    @Test
    public void findByAge(){
        int age = ageList.get(toRandom(ageList.size()));
        Slice<Student> studentPage = studentRepository.findByAge(age, PageRequest.of(1,10,Sort.by(Sort.Order.asc("age"))));
        Assertions.assertAll(()->{
            Assertions.assertNotNull(studentPage.getContent().size());
        });
    }

    private int toRandom(int max){
        return new Random().nextInt(max);
    }
}
