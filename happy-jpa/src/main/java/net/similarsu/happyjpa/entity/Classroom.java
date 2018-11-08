package net.similarsu.happyjpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Classroom extends Id{

    @Column(name = "name", length = 20, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "classroom",cascade = CascadeType.ALL)
    private List<Student> studentList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
