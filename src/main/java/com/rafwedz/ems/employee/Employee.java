package com.rafwedz.ems.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafwedz.ems.task.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private int salary;
    @NonNull
    private String empAuthLevel;
    @NonNull
    private String occupation;

    private int currentMonthWorkingHours;

    private int remainingDayOffs;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<Task> tasks;

    public Employee(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.password = employee.getPassword();
        this.salary = employee.getSalary();
        this.occupation = employee.getOccupation();
        this.currentMonthWorkingHours = employee.getCurrentMonthWorkingHours();
        this.empAuthLevel = employee.getEmpAuthLevel();
        this.remainingDayOffs = employee.getRemainingDayOffs();
        this.tasks = employee.getTasks();
    }

}
