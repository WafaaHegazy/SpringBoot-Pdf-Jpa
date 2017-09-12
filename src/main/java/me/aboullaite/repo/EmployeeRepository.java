package me.aboullaite.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.aboullaite.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


}
