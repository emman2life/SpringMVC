package sda.group1.miniprojectgroup1.task;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks") //this tells the controller to add this path to all the method paths
public class TaskController {
    @Autowired
  private TaskService service;
   /** @GetMapping("")
    public List<Task> getAllTask() {
        return service.getAllTask();
    }*/
   @GetMapping("")
   public List<Task> getAllTask(@RequestParam(required =false) String sort,
                                @RequestParam(required = false) Long projectId) {
       if(sort==null){
           sort ="name";
       }
       if(projectId ==null){
           return service.getAllTask(sort);
       }
       else{
           return service.getAllByProjectId(projectId);
       }

   }
    @GetMapping("/{id}")
    public Task getId(@PathVariable Long id){
        Task task = service.getId(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        return task;
    }
    @PostMapping("")
    public Task create(@RequestBody Task newTask){
       return service.create(newTask);
    }
    @PutMapping("")
    public Task update(@RequestBody Task newTask){
    return service.update(newTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
