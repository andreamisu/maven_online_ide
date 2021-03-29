package edu.tum.ase.project.service;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.model.SourceFile;
import edu.tum.ase.project.repository.ProjectRepository;
import edu.tum.ase.project.repository.SourceFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SourceFileRepository sourceFileRepository;

    public Project createProject (Project project) {
        return projectRepository.saveAndFlush(project);
    }

    public Project findByName(String name) {
        return projectRepository.findByName(name);
    }

    public List<Project> getProjects() {
        var projectsList = (List<Project>) projectRepository.findAll();
        return projectsList;
    }

    public Project update(Project newProject){
        Optional<Project> result = projectRepository.findById(newProject.getId());
        if(result.isPresent()){
            Project changedProject = result.get();
            changedProject = newProject;
            projectRepository.saveAndFlush(changedProject);
            return changedProject;
        }
        return null;
    }

    public boolean delete(Project project) {
        Project result = projectRepository.findByName(project.getName());
        if (result != null) {
            projectRepository.delete(result);
            return true;
        }
        return false;
    }

    public List<SourceFile> getSourcefiles(Project project) {
        List<SourceFile> sourcefilesList = new ArrayList<>();
        sourcefilesList.addAll(sourceFileRepository.findAllByProject(project));

        return sourcefilesList;
    }
}
