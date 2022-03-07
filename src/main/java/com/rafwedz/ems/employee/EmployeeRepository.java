package com.rafwedz.ems.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e " +
            "where lower(e.firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(e.lastName) like lower(concat('%', :searchTerm, '%'))") //
    List<Employee> search(@Param("searchTerm") String searchTerm); //

    @Query(value = "select e from Employee e where e.email = ?1")
    Optional<Employee> findUserByUsername(String s);

    @Query(value = "select e.id from Employee e where e.email = ?1")
    Long findIdByUsername(String s);

    @Query(value = "select e.firstName from Employee e where e.email = ?1")
    String findFirstNameByUsername(String s);

    @Query(value = "select e.lastName from Employee e where e.email = ?1")
    String findLastNameByUsername(String s);

    @Query(value = "select e.empAuthLevel from Employee e where e.email = ?1")
    String findRoleByUsername(String s);

    @Query(value = "select count(e) from Employee e")
    int getEmployeeCount();

    @Query(value = "select sum(e.salary) from Employee e")
    int getWagesCount();




}
