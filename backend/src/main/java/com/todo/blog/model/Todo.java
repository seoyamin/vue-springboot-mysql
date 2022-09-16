package com.todo.blog.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@DynamicInsert
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "todo_id")
    private Long id;

    private String item;

    private String date;

    private boolean completed;

    private String time;

    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String useYn;
}
