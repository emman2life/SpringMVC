package sda.group1.miniprojectgroup1.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;



    public List<Task> getAllTask() {
        return repository.findAll();
    }

    public Optional<Task> getId(Long id){
        return repository.findById(id);
    }

    public Task create(Task newTask) {

        return repository.save(newTask);
    }



    public void deleteTask(Long id) {
      repository.deleteById(id);
    }

    public List<Task> getAllTask(String sort) {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("name")? Task::getName: Task::getDate))
                .collect(Collectors.toList());
    }

    public Task update(Task updatedTask) {
        return repository.save(updatedTask);
    }

    public List<Task> getAllByProjectId(Long projectId) {
        return repository.findAllByProjectId(projectId);
    }
}
