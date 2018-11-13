package net.similarsu.happyjpa.repository;

import net.similarsu.happyjpa.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    /**
     *select
     * classroom0_.id as id1_0_, classroom0_.name as name2_0_ from classroom classroom0_
     * where classroom0_.name=?
     * @param name
     * @return
     */
    Classroom findByName(String name);

    /**
     *select
     * classroom0_.id as id1_0_, classroom0_.name as name2_0_ from classroom classroom0_
     * where classroom0_.name like ?
     * @param name
     * @return
     */
    List<Classroom> findByNameLike(String name);

    /**
     *select
     * classroom0_.id as id1_0_, classroom0_.name as name2_0_ from classroom classroom0_
     * where classroom0_.name like ?
     * order by classroom0_.name desc
     * @return
     */
    List<Classroom> findByNameLikeOrderByNameDesc(String name);

    /**
     * select distinct
     * classroom0_.id as id1_0_, classroom0_.name as name2_0_ from classroom classroom0_
     * where classroom0_.name like ?
     * @param name
     * @return
     */
    List<Classroom> findDistinctByNameLike(String name);
}
