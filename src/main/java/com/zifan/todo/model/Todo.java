package com.zifan.todo.model;


import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

/**
 * 2025, March 02, Sunday, 5:44 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private int id;

    private String username;

    @Size(min = 5, message = "min = 5")
    private String description;

    private LocalDate targetDate;



    @Setter
    @Getter
    private boolean done;

}
