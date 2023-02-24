package com.todo.todolistnextgen.Service;

import com.todo.todolistnextgen.Model.TaskDetails;
import com.todo.todolistnextgen.Model.TaskStatus;
import com.todo.todolistnextgen.taskrepo.TaskDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskDetailImpl implements TaskDetailService {

    @Autowired
    private TaskDetailRepository taskDetailRepository;

    @Override
    public TaskDetails addTaskInfo(TaskDetails taskDetails) {
        System.out.println("we are in add task method");
        System.out.println("ok");
        if (taskDetails.getStatus() == null) {
            taskDetails.setStatus(TaskStatus.NOT_STARTED);
        }
        return taskDetailRepository.save(taskDetails);
    }

    @Override
    public TaskDetails updateTaskDetails(TaskDetails taskDetails) {
        System.out.println("we are in a task update method : ");
        Optional<TaskDetails> dbTaskData = taskDetailRepository.findById(taskDetails.getId());
        if (dbTaskData.isPresent()) {
            dbTaskData.get().setTaskDetails(taskDetails.getTaskDetails());
            dbTaskData.get().setTaskStartTime(taskDetails.getTaskStartTime());
            dbTaskData.get().setTaskEndTime(taskDetails.getTaskEndTime());
            if (taskDetails.getStatus() == null) {
                dbTaskData.get().setStatus(TaskStatus.NOT_STARTED);
            } else {
                dbTaskData.get().setStatus(taskDetails.getStatus());
            }
            return taskDetailRepository.save(dbTaskData.get());
        } else
            throw new RuntimeException("This user is not present in Database : ");

    }

    @Override
    public TaskDetails deleteTaskDetails(Integer id) {
        System.out.println("this is a delete method : ");
        Optional<TaskDetails> taskDbData = taskDetailRepository.findById(id);
        if (taskDbData.isPresent() ){
            taskDbData.get().setStatus(TaskStatus.DELETED);
            return taskDetailRepository.save(taskDbData.get());
        }else{
            throw new RuntimeException("This user is not present in Database : ");
        }


    }

    @Override
    public List<TaskDetails> getTaskByContactNumber(String contactNumber) {
        List<TaskDetails> taskDetailsList = taskDetailRepository.findAll();


        List<TaskDetails> taskDetailsList1 = taskDetailsList.stream().filter(taskDetails -> taskDetails.getUsername().equals(contactNumber)).collect(Collectors.toList());
        return taskDetailsList1;
    }


}
