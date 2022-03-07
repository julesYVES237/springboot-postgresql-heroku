package com.rafwedz.ems.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "select t from Task t where t.employee.id = ?1 order by t.id")
    Optional<List<Task>> findEmployeeTask(Long id);

    @Query(value = "select t from Task t where t.employee.id is null order by t.id")
    List<Task> findAllUnassignedTasks();

    @Query(value = "select t from Task t where t.employee.id is not null order by t.id")
    List<Task> findAllassignedTasks();

    @Query(value = "select count(t) from Task t where t.employee.id = ?1 and t.status='DONE'")
    int findEmployeeTaskDone(Long id);

    @Query(value = "select count(t) from Task t where t.employee.id = ?1 and t.status='NEW'")
    int findEmployeeTaskNew(Long id);

    @Query(value = "select count(t) from Task t where t.employee.id = ?1")
    int findEmployeeTaskAll(Long id);

    @Query(value = "select count(t) from Task t")
    int getAllTaskCount();

    @Query(value = "select count(t) from Task t where t.employee is null ")
    int getAllUnassignedTaskCount();

    @Query(value = "select count(t) from Task t where t.employee is not null ")
    int getAllassignedTaskCount();

    @Query(value = "select count(t) from Task t where t.status ='NEW'")
    int getAllNewTaskCount();


    @Query(value = "select count(t) from Task t where t.status ='DONE'")
    int getAllDoneTaskCount();

   /* @Query(value = "select count(t) from Task t where t.employee.id = ?1 and t.status='NEW'")
    int getAllNewEmployeeTaskCount(int id);*/
}
