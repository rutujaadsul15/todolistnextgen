package com.todo.todolistnextgen.Service;


import com.todo.todolistnextgen.Model.TaskDetails;

import java.util.List;

public interface TaskDetailService {
    TaskDetails addTaskInfo(TaskDetails taskDetails);

    TaskDetails updateTaskDetails(TaskDetails taskDetails);

    TaskDetails deleteTaskDetails(Integer id);

    List<TaskDetails> getTaskByContactNumber(String contactNumber);
}
