package net.similarsu.happyjpa.entity;

import javax.persistence.*;

@MappedSuperclass
public class Id {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
