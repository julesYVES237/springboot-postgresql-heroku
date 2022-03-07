package com.rafwedz.ems.employee;


import com.google.common.collect.ImmutableList;
import com.rafwedz.ems.task.Task;
import com.rafwedz.ems.task.TaskService;
import lombok.RequiredArgsConstructor;


//import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employees")


public class EmployeeController {

    private final EmployeeService employeeService;
    private final TaskService taskService;
  //  private final PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<Employee> employeeList() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/{emp_id}")
    public Employee getEmployeeById(@PathVariable(value="emp_id") String emp_id){
        return employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
    }



    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
       // employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.save(employee);
    }

    @PutMapping(value = "/{emp_id}")
    public void update(@PathVariable(value = "emp_id") String emp_id, @RequestBody Employee employee) {
        Employee empTemp = employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
        empTemp.setFirstName(employee.getFirstName());
        empTemp.setLastName(employee.getLastName());
        empTemp.setEmail(employee.getEmail());
        empTemp.setSalary(employee.getSalary());
        empTemp.setOccupation(employee.getOccupation());
        empTemp.setEmpAuthLevel(employee.getEmpAuthLevel());
        empTemp.setCurrentMonthWorkingHours(employee.getCurrentMonthWorkingHours());
        empTemp.setRemainingDayOffs(employee.getRemainingDayOffs());
        employeeService.save(empTemp);

    }


    @DeleteMapping(value="/{emp_id}")
    public void delete(@PathVariable(value="emp_id") String emp_id) {
        List<Task> tasks = taskService.getEmployeeTask(Long.parseLong(emp_id)).orElse(new ArrayList<>());
        tasks.forEach(t->{t.setEmployee(null);
        taskService.save(t);});
        employeeService.deleteEmployeeById(Long.parseLong(emp_id));
    }

    @GetMapping("/{emp_id}/tasks")
    public List<Task> getEmployeeTasks(@PathVariable(value="emp_id") String emp_id){
        return taskService.getEmployeeTask(Long.parseLong(emp_id)).orElse(new ArrayList<>());
    }

    @GetMapping("/count")
    public int getEmployeeCount(){
        return employeeService.getAllEmployeesCount();

    }

    @GetMapping("/wages")
    public int getEmployeeWagesCount(){
        return employeeService.getAllEmployeesWagesCount();

    }

    @GetMapping("/{emp_id}/tasks/all")
    public int getEmployeeTasksAll(@PathVariable(value="emp_id") String emp_id){
        return taskService.getEmployeeTaskAll(Long.parseLong(emp_id));
    }

    @GetMapping("/{emp_id}/tasks/done")
    public int getEmployeeTasksDone(@PathVariable(value="emp_id") String emp_id){
        return taskService.getEmployeeTaskDone(Long.parseLong(emp_id));
    }

    @GetMapping("/{emp_id}/tasks/new")
    public int getEmployeeTasksNew(@PathVariable(value="emp_id") String emp_id){
        return taskService.getEmployeeTaskNew(Long.parseLong(emp_id));
    }

    @PatchMapping("/{emp_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Employee partial updated!")
    public void updatePatchEmployee(@RequestBody Map<String, String> updates, @PathVariable(value="emp_id") String emp_id) {
        Employee empTemp = employeeService.getEmployeeById(Long.parseLong(emp_id)).orElseThrow(EntityExistsException::new);
        empTemp.setFirstName(updates.get("firstName"));
        empTemp.setLastName(updates.get("lastName"));
        empTemp.setEmail(updates.get("email"));
        if (!updates.get("password").isEmpty()) {
        //    empTemp.setPassword(passwordEncoder.encode(updates.get("password")));
        }
        this.employeeService.save(empTemp);
    }


}
