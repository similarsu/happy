package net.similarsu.happyjpa.repository;


import net.similarsu.happyjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    /**
     * select
     * student0_.id as id1_1_, student0_.age as age2_1_, student0_.c_id as c_id4_1_, student0_.name as name3_1_
     * from student student0_ left outer join classroom classroom1_ on student0_.c_id=classroom1_.id
     * where classroom1_.name=? and (student0_.age between ? and ?)
     * @param name
     * @param minAge
     * @param maxAge
     * @return
     */
    List<Student> findByClassroom_nameAndAgeBetween(String name,int minAge,int maxAge);
}
