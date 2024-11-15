package com.example.schedules.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedules")
public class Schedules extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(255)")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    public Schedules() {
    }
    public Schedules(String contents, String title) {
        this.contents = contents;
        this.title = title;
    }

    public void updateSchedules(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
