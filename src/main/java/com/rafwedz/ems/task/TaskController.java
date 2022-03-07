package com.rafwedz.ems.task;

import com.rafwedz.ems.employee.Employee;
import com.rafwedz.ems.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks")
@CrossOrigin
public class TaskController {

    private final TaskService taskService;
    private final EmployeeService employeeService;

    @GetMapping("")
    public List<Task> taskList() {
        return taskService.getAllTask();
    }

    @GetMapping("/count")
    public int getAllTaskCount() {
        return taskService.getAllTaskCounter();
    }

    @GetMapping("/tasksdto")
    public List<TaskDto> getTaskDto() {
        return taskService.getTasksDtos();

    }

    @GetMapping("/unassigned")
    public List<Task> notAssignedTaskList() {
        return taskService.getAllUnassignedTasks();

    }

    @GetMapping("/unassigned/count")
    public int notAssignedTaskCount() {
        return taskService.getAllUnassignedTasksCount();

    }

    @GetMapping("/assigned/count")
    public int assignedTaskCount() {
        return taskService.getAllassignedTasksCount();

    }

    @GetMapping("/done")
    public int doneTaskCount() {
        return taskService.getAllDoneTasksCount();

    }

    @GetMapping("/new")
    public int newTaskCount() {
        return taskService.getAllNewTasksCount();

    }
/*
    @GetMapping("/nn/{emp_id2}")
    public int getAllNewEmployeeTaskCounter(@PathVariable(value = "emp_id2") Integer emp_id2) {
        return taskService.getAllNewEmployeeTaskCount(emp_id2);

    }*/
    @GetMapping("/assigned")
    public List<Task> assignedTaskList() {
        return taskService.getAllassignedTasks();

    }

    @GetMapping("/{task_id}")
    public Task getTaskById(@PathVariable(value = "task_id") String task_id) {
        return taskService.getTaskById(Long.parseLong(task_id)).orElseThrow(EntityExistsException::new);
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.save(task);
    }

    @PutMapping(value = "/{task_id}")
    public void update(@PathVariable(value = "task_id") String task_id, @RequestBody Task task) {
        Task tempTask = taskService.getTaskById(Long.parseLong(task_id)).orElseThrow(EntityExistsException::new);
        tempTask.setDescription(task.getDescription());
        tempTask.setStatus(task.getStatus());
        tempTask.setStartDate(task.getStartDate());
        tempTask.setEndDate(task.getEndDate());
        taskService.save(tempTask);

    }

    @PatchMapping("/{task_id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Task partial updated!")
    public void updateTask(@RequestBody Map<String, String> updates, @PathVariable(value = "task_id") String task_id) {
        Task task = taskService.getTaskById(Long.parseLong(task_id)).orElseThrow(EntityExistsException::new);

        if (updates.containsKey("status")) {
            task.setStatus(updates.get("status"));
        }
        if (updates.containsKey("assigned")) {
            task.setEmployee(null);
        }
        if (updates.containsKey("employeeId")) {
            Employee employee = employeeService.getEmployeeById(Long.parseLong(updates.get("employeeId"))).orElseThrow(EntityExistsException::new);
            task.setEmployee(employee);
        }
        this.taskService.save(task);
    }

    @DeleteMapping(value = "/{task_id}")
    public void delete(@PathVariable(value = "task_id") String task_id) {
        taskService.deleteTaskById(Long.parseLong(task_id));
    }
}
