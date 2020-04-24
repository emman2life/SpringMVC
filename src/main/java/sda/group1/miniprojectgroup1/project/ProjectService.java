package sda.group1.miniprojectgroup1.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;
    public List<Project> getAll(){
        return repository.findAll();
    }
    public Optional<Project> getById(Long id){
        return repository.findById(id);

    }
    public Project create(Project newProject){
        return repository.save(newProject);
    }
    public Project update(Project updateProject){
        return repository.save(updateProject);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
