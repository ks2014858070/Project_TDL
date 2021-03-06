package com.taegyun.tdl.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Table
@NoArgsConstructor
@Entity
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

    @Builder
    public ToDoList(Boolean status, String description, LocalDateTime createdDate, LocalDateTime completedDate) {
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
    }
}
