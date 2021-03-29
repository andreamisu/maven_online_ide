package edu.tum.ase.project.controller;

import java.util.List;
import java.util.Optional;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import edu.tum.ase.project.model.SourceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.service.ProjectService;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService ProjectService;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @RequestMapping(path = "/project/create", method = RequestMethod.POST)
    public Project Create(@RequestBody Project project) {
//        List<InstanceInfo> serviceInstanceList = discoveryClient.getInstancesById("project-server");
//        serviceInstanceList.forEach( (InstanceInfo instanceInfo) -> {
//            System.out.println("Info: " + instanceInfo.getIPAddr());
//        });
        return ProjectService.createProject(project);
    }

    @RequestMapping(path = "/project/find", method = RequestMethod.POST)
    public Project FindByName(@RequestBody String Name) {
        return ProjectService.findByName(Name);
    }

    @RequestMapping(path = "/project", method = RequestMethod.PATCH)
    public Project Update(@RequestBody Project project) {
        return ProjectService.update(project);
    }

    @RequestMapping(path = "/project", method = RequestMethod.DELETE)
    public boolean Delete(@RequestBody Project project) {
        return ProjectService.delete(project);
    }

    @RequestMapping(path = "/project", method = RequestMethod.GET)
    public List<Project> FindAll() {
        return ProjectService.getProjects();
    }

    @RequestMapping(path = "/project/sourcefiles", method = RequestMethod.POST)
    public List<SourceFile> FindAllSourcefiles(@RequestBody Project project) {
        return ProjectService.getSourcefiles(project);
    }

}
