package com.rafwedz.ems.task;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getAllTask(){

        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<Task> getAllUnassignedTasks(){
        return taskRepository.findAllUnassignedTasks();
    }

    public List<Task> getAllassignedTasks(){
        return taskRepository.findAllassignedTasks();
    }

    public Optional<Task> getTaskById(Long task_id){
        return taskRepository.findById(task_id);
    }

    public Optional<List<Task>> getEmployeeTask(Long id){
        return taskRepository.findEmployeeTask(id);
    };

    public void save(final Task task){taskRepository.save(task);
    }

    public List<TaskDto> getTasksDtos() {
        List<TaskDto> TaskDto=new ArrayList<>();
        List<Task> AssignedTask=taskRepository.findAllassignedTasks();
        AssignedTask.forEach(t->TaskDto.add(new TaskDto(t.getId(),
                t.getDescription(),
                t.getStatus(),
                t.getStartDate(),
                t.getEndDate(),
                t.getEmployee().getFirstName(),
                t.getEmployee().getLastName())));

        return TaskDto;
    }
    public void deleteTaskById(Long task_id){
        taskRepository.deleteById(task_id);
    }

    public  int getEmployeeTaskDone(Long id) {
        return taskRepository.findEmployeeTaskDone(id);
    }

    public  int getEmployeeTaskNew(Long id) {
        return taskRepository.findEmployeeTaskNew(id);
    }

    public  int getEmployeeTaskAll(Long id) {
        return taskRepository.findEmployeeTaskAll(id);
    }

    public int getAllTaskCounter(){return taskRepository.getAllTaskCount();}

    public int getAllUnassignedTasksCount(){return taskRepository.getAllUnassignedTaskCount(); }

    public int getAllassignedTasksCount(){return taskRepository.getAllassignedTaskCount(); }

    public int getAllDoneTasksCount(){return taskRepository.getAllDoneTaskCount(); }

    public int getAllNewTasksCount(){return taskRepository.getAllNewTaskCount(); }
/*    public int getAllNewEmployeeTaskCount(Integer id){return taskRepository.getAllNewEmployeeTaskCount(id); }*/
    }

