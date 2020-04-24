package sda.group1.miniprojectgroup1.task;

import sda.group1.miniprojectgroup1.project.Project;

import javax.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "Date")
    private  String date;
    @ManyToOne
    private Project project;
    public Task() {

    }
    public Task(Long id, String name, String date, Project project) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.project = project;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
