package sda.group1.miniprojectgroup1.task;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceWithList {
    private static Long idCounter=1L;
    private static List<Task> allTask = new ArrayList<>();
    static {
        addTask(new Task(null,"name 1","2020-04-04",null));
        addTask(new Task(null,"name 2","2020-04-05",null));
    }

    public List<Task> getAllTask() {
        return allTask;
    }

    public Optional<Task> getId(Long id){
        return allTask.stream()
                .filter(n->n.getId().equals(id))
                .findFirst();
    }

    public Task create(Task newTask) {
        addTask(newTask);
        return newTask;
    }

    static private boolean addTask(Task newTask) {
        newTask.setId(idCounter);
        idCounter++;
        return allTask.add(newTask);
    }

    public void deleteTask(Long id) {
        allTask = allTask.stream()
                .filter(n->!n.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Task> getAllTask(String sort) {
        return allTask.stream()
                .sorted(Comparator.comparing(sort.equals("name")? Task::getName: Task::getDate))
                .collect(Collectors.toList());
    }
}
