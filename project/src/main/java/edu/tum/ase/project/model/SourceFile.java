package edu.tum.ase.project.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import edu.tum.ase.project.repository.ProjectRepository;

import javax.persistence.*;

@Entity
@Table(name = "project_source_file")
public class SourceFile {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "file_id")
    private String id;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "source_code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;
    
    protected SourceFile() {
// no-args constructor required by JPA spec
// this one is protected since it shouldn't be used directly
    }

    public SourceFile(String filename, String code, Project project) {
        this.filename = filename;
        this.code = code;
        this.project = project;
    }

// getters and setters
    public String getId() {
        return id;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename){
        this.filename = filename;
    }    
    public String getCode() {
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}