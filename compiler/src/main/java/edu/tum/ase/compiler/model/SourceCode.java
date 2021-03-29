package edu.tum.ase.compiler.model;

public class SourceCode {
    private String code;
    private String filename;
    private String stdout;
    private String stderr;
    private boolean compilable = false;

    public SourceCode() {
    }    
    
    public SourceCode(String code, String filename, String stdout, String stderr, boolean compilable) {
        this.code = code;
        this.filename = filename;
        this.stderr = stderr;
        this.stdout = stdout;
        this.compilable = compilable;
    }

    public boolean isCompilable() {
        return compilable;
    }

    public void setCompilable(boolean compilable) {
        this.compilable = compilable;
    }

    public String getStderr() {
        return stderr;
    }

    public void setStderr(String stderr) {
        this.stderr = stderr;
    }

    public String getStdout() {
        return stdout;
    }

    public void setStdout(String stdout) {
        this.stdout = stdout;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}