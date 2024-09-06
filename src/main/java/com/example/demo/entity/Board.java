package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;
    @JoinColumn(name = "username")
    @ManyToOne
    private Myuser user;
    private String title;
    @Lob
    private String content;
    @CreationTimestamp
    private Date regdate;
}
