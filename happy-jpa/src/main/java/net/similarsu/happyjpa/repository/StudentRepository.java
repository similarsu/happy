package net.similarsu.happyjpa.repository;


import net.similarsu.happyjpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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

    /**
     * select
     * student0_.id as id1_1_, student0_.age as age2_1_, student0_.c_id as c_id4_1_, student0_.name as name3_1_
     * from student student0_
     * where student0_.name=? order by student0_.age asc limit ?, ?
     *
     * select
     * count(student0_.id) as col_0_0_
     * from student student0_
     * where student0_.name=?
     * @param name
     * @param pageable
     * @return
     */
    Page<Student> findByName(String name, Pageable pageable);

    /**
     * select
     * student0_.id as id1_1_, student0_.age as age2_1_, student0_.c_id as c_id4_1_, student0_.name as name3_1_
     * from
     * student student0_
     * where student0_.age=? order by student0_.age asc limit ?, ?
     * @param age
     * @param pageable
     * @return
     */
    Slice<Student> findByAge(int age, Pageable pageable);

    /**
     * select
     * student0_.id as id1_1_, student0_.age as age2_1_, student0_.c_id as c_id4_1_, student0_.name as name3_1_
     * from
     * student student0_
     * order by student0_.age asc limit ?
     * @return
     */
    Student findFirstByOrderByAgeAsc();

    /**
     * select
     * student0_.id as id1_1_, student0_.age as age2_1_, student0_.c_id as c_id4_1_, student0_.name as name3_1_
     * from
     * student student0_
     * order by student0_.age asc limit ?
     * @return
     */
    Student findTopByOrderByAgeAsc();

    /**
     * select
     * student0_.id as id1_1_, student0_.age as age2_1_, student0_.c_id as c_id4_1_, student0_.name as name3_1_
     * from
     * student student0_
     * order by student0_.age asc
     * limit ?
     * @return
     */
    List<Student> findFirst10ByOrderByAgeAsc();
}
