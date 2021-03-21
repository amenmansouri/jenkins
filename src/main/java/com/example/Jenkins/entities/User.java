package com.example.Jenkins.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Timestamp creationDate;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Timestamp updateDate;
    private String FirstName;
    private String LastName;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Timestamp BirthDayDate;

}
