package net.similarsu.happyjpa.entity;

import javax.persistence.*;

@Entity
public class Student extends Id{

    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "age" , length = 3)
    private int age;
    @ManyToOne
    @JoinColumn(name = "c_id")
    private Classroom classroom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}