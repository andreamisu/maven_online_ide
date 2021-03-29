package edu.tum.ase.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.tum.ase.project.model.SourceFile;
import edu.tum.ase.project.service.SourceFileService;

@RestController
public class SourceFileController {

    @Autowired
    private SourceFileService sourceFileService;

    @RequestMapping(path = "/project/sourcefile/create", method = RequestMethod.POST)
    public SourceFile Create(@RequestBody SourceFile sourceFile) {
        return sourceFileService.createSourceFile(sourceFile);
    }

    @RequestMapping(path = "/project/sourcefile/find", method = RequestMethod.POST)
    public SourceFile FindByName(@RequestBody String fileName) {
        return sourceFileService.findByFilename(fileName);
    }
    
    @RequestMapping(path = "/project/sourcefile", method = RequestMethod.PATCH)
    public SourceFile Update(@RequestBody SourceFile sourceFile) {
        return sourceFileService.update(sourceFile);
    }

    @RequestMapping(path = "/project/sourcefile", method = RequestMethod.DELETE)
    public boolean Delete(@RequestBody SourceFile sourceFile) {
        return sourceFileService.delete(sourceFile);
    }

}
