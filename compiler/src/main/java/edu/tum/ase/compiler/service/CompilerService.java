package edu.tum.ase.compiler.service;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import edu.tum.ase.compiler.model.SourceCode;

@Service
public class CompilerService {

    private File fileInstance; 
    
    public SourceCode compile (SourceCode sourceCode) throws IOException, InterruptedException {
        try{
            String[] fileName = sourceCode.getFilename().split(Pattern.quote("."));
            if(fileName.length == 1)
                return null;
            String fileExtension = fileName[fileName.length-1];
            
            if(!fileExtension.equalsIgnoreCase("java") && !fileExtension.equalsIgnoreCase("c")){
                sourceCode.setCompilable(false);
                return sourceCode;
            }
    
            fileInstance = new File("./"+ sourceCode.getFilename());
            if (fileInstance.createNewFile()) {
                System.out.println("File created: " + fileInstance.getName());
                } else {
                System.out.println("File already exists.");
                }
            FileWriter myWriter = new FileWriter(fileInstance);
            myWriter.write(sourceCode.getCode());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
    
            String command = null;
    
            switch(fileExtension.toUpperCase()){
                case "JAVA":
                    command = "javac " + sourceCode.getFilename();
                    break;
                case "C":
                    command = "gcc " + sourceCode.getFilename();
                    break;
                default:
                    sourceCode.setCompilable(false);
                    return sourceCode;
            }
    
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);
    
            BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(process.getInputStream()));
        
            BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(process.getErrorStream()));
            
            //standard output
            String output = null;
            String aux = null;
            while ((output = stdInput.readLine()) != null) {
                aux = aux + output + "\n";
            }
            sourceCode.setStdout(aux);
            
            // Read any errors from the attempted command
            String error = null;
            aux = null;
            while ((error = stdError.readLine()) != null) {
                aux = aux + error + "\n";;
            }
            sourceCode.setStderr(aux);
    
            int exitVal = process.waitFor();
            sourceCode.setCompilable(exitVal != 0 ? false : true);
            return sourceCode;
            
        }
        catch(Exception m){
            System.out.println(m.getMessage() + "\n");
            System.out.println(m.getStackTrace());
            return null;
        }        

        finally{
            fileInstance.delete();
        }
    }
}
