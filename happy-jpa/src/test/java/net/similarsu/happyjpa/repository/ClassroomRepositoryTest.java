package net.similarsu.happyjpa.repository;

import net.similarsu.happyjpa.HappyJpaApplicationTests;
import net.similarsu.happyjpa.entity.Classroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private int perCount = 12;

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

    @Test
    public void findByName(){
        String name = "1年1班";
        Classroom classroom = classroomRepository.findByName(name);
        Assertions.assertNotNull(classroom);
    }

    @Test
    public void findByNameLike(){
        String name = "1年%";
        List<Classroom> classroomList = classroomRepository.findByNameLike(name);
        Assertions.assertEquals(perCount, classroomList.size());
    }

    @Test
    public void findByOrderByNameDesc(){
        String name = "1年%";
        List<Classroom> classroomList = classroomRepository.findByNameLikeOrderByNameDesc(name);
        Assertions.assertEquals(perCount, classroomList.size());
    }

    @Test
    public void findDistrictByNameLike(){
        String name = "1年%";
        List<Classroom> classroomList = classroomRepository.findDistinctByNameLike(name);
        Assertions.assertEquals(perCount, classroomList.size());
    }


}
