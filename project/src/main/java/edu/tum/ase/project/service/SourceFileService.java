package edu.tum.ase.project.service;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.model.SourceFile;
import edu.tum.ase.project.repository.ProjectRepository;
import edu.tum.ase.project.repository.SourceFileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class SourceFileService {
    @Autowired
    private SourceFileRepository sourceFileRepository;

    public SourceFile createSourceFile(SourceFile sourceFile) {

        return sourceFileRepository.saveAndFlush(sourceFile);
    }

    public SourceFile findByFilename(String filename) {
        return sourceFileRepository.findByFilename(filename);
    }

    public SourceFile update(SourceFile newSourceFile) {
        Optional<SourceFile> result = sourceFileRepository.findById(newSourceFile.getId());
        if(!result.isPresent())
            return null;
        SourceFile modified = result.get();
        modified.setFilename(newSourceFile.getFilename());
        modified.setCode(newSourceFile.getCode());
        sourceFileRepository.saveAndFlush(modified);
        return modified;
    }

    public boolean delete(SourceFile sourceFile){
        Optional<SourceFile> result = sourceFileRepository.findById(sourceFile.getId());
        if(!result.isPresent())
            return false;
        SourceFile modified = result.get();
        sourceFileRepository.delete(modified);
        return true;
    }
}
