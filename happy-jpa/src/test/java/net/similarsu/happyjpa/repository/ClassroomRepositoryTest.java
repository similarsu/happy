package net.similarsu.happyjpa.repository;

import net.similarsu.happyjpa.HappyJpaApplicationTests;
import net.similarsu.happyjpa.entity.Classroom;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ClassroomRepositoryTest extends HappyJpaApplicationTests {
    @Autowired
    private ClassroomRepository classroomRepository;

    private String classFormat="%d年%d班";

    private int pageNo = 1;
    private int pageSize = 10;
    private int totalCount = 72;


    @Test
    public void saveAll(){
        List<Classroom> classroomList = new ArrayList<>();
        IntStream.rangeClosed(1,6).forEach( i -> {
            IntStream.rangeClosed(1,12).forEach(j ->{
                String className = String.format(classFormat,i,j);
                Classroom classroom = new Classroom();
                classroom.setName(className);
                classroomList.add(classroom);
            });
        });
        classroomRepository.saveAll(classroomList);
    }

    @Test
    public void findAll(){
        List<Classroom> classroomList=classroomRepository.findAll();
        Assertions.assertEquals(classroomList.size(),totalCount);
    }

    @Test
    public void findPage(){
        Page<Classroom> classroomPage=classroomRepository.findAll(PageRequest.of(pageNo,pageSize));
        Assertions.assertAll(()->{
            Assertions.assertEquals(classroomPage.getTotalPages(),totalCount/pageSize+1);
            Assertions.assertEquals(classroomPage.getContent().size(),pageSize);
        });
    }

    @Test
    public void findPageWithSort(){
        Page<Classroom> classroomPage=classroomRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by(Sort.Order.asc("id"))));
        Assertions.assertAll(()->{
            Assertions.assertEquals(classroomPage.getTotalPages(),totalCount/pageSize+1);
            Assertions.assertEquals(classroomPage.getContent().size(),pageSize);
        });
    }

}
