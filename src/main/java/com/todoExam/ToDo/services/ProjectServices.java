package com.todoExam.ToDo.services;

import com.todoExam.ToDo.exception.EntityNotFound;
import com.todoExam.ToDo.models.Project;
import com.todoExam.ToDo.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class ProjectServices {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Project> getProject(){
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

    public void deleteProject(Long id){
        projectRepository.findById(id)
                .map((project) -> project.getId())
                .ifPresent(projectRepository::deleteById);
    }

    public Project updateProjectId(@PathVariable("id") long id , @RequestBody Project project){
        Project updateProject = projectRepository.findById(id).get();
        modelMapper.map(project,updateProject);
        projectRepository.save(updateProject);
        return updateProject;
    }

}
