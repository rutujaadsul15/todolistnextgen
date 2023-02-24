package com.todo.todolistnextgen.taskrepo;


import com.todo.todolistnextgen.Model.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDetailRepository extends JpaRepository<TaskDetails, Integer> {
}
