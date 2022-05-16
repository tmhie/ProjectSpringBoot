package com.todoExam.ToDo.services;

import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServices {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProject(){
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id).get();
    }

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

    public void deleteProject(Long id){
        projectRepository.findById(id)
                .map((project) -> project.getId())
                .ifPresent(projectRepository::deleteById);
    }

    public void updateProject(Project project){
        Project pj = projectRepository.findById(project.getId())
                .orElseThrow(RuntimeException::new);
        pj.setName(project.getName());
    }

}
