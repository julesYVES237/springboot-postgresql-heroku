package com.rafwedz.ems.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private long id;
    private String description;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String employeeFirstName;
    private String employeeLastName;
}
