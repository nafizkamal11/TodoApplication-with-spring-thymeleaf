package com.zifan.todo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

/**
 * 2025, March 02, Sunday, 5:44 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Size(min = 5, message = "min = 5")
    private String description;

    private LocalDate targetDate;

    @Setter
    @Getter
    private boolean done;

}
