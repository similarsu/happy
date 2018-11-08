package net.similarsu.happyjpa.repository;

import net.similarsu.happyjpa.HappyJpaApplicationTests;
import net.similarsu.happyjpa.entity.Classroom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ClassroomRepositoryTest extends HappyJpaApplicationTests {
    @Autowired
    private ClassroomRepository classroomRepository;

    private String classFormat="%d年%d班";

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

}
