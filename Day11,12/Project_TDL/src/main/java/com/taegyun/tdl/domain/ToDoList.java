package com.taegyun.tdl.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table
@NoArgsConstructor
@Entity
@Setter
public class ToDoList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private Boolean status;

    @Column
    private String description;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime completedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "toDoList", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    public void add(Comment comment) {
        comment.setToDoList(this);
        getComments().add(comment);
    }

    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

    public void update(String content) {
        this.status = this.getStatus();
        this.description = content;
        this.createdDate = LocalDateTime.now();
    }

    public void update2(ToDoList toDoList) {
        this.status = toDoList.getStatus();
        this.description = this.description;
        this.createdDate = LocalDateTime.now();
        this.completedDate = LocalDateTime.now();
    }

    public void status() {
        this.status = true;
        this.completedDate = LocalDateTime.now();
    }

    public void status2() {
        this.status = false;
        this.completedDate = null;
    }
    @Builder
    public ToDoList(Boolean status, String description, LocalDateTime createdDate, LocalDateTime completedDate, User user) {
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.user = user;
    }
}
