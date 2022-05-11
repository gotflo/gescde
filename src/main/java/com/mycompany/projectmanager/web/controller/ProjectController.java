package com.mycompany.projectmanager.web.controller;


import com.mycompany.projectmanager.entities.Company;
import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.repo.ProjectRepo;
import com.mycompany.projectmanager.repo.ResourceNotFoundException;
import com.mycompany.projectmanager.service.CompanyService;
import com.mycompany.projectmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectRepo projectRepo;
    private final CompanyService companyService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectRepo projectRepo, CompanyService companyService) {
        this.projectService = projectService;
        this.projectRepo = projectRepo;
        this.companyService = companyService;
    }

    @PostMapping("/addProject")
    public ResponseEntity<Project>addProject(@RequestBody Project project){
        Project project1 = projectService.save(project);
        return new  ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/projectsList")
    public ResponseEntity<List<Project>> projectList(){
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/projectsList/{idProject}")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "idProject") Integer idProject)throws ResourceNotFoundException {
        Project project = projectService.findProjectById(idProject);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }


    @PutMapping("/updateProject/{idProject}")
    public ResponseEntity<Project>  updateProjct(@Valid @RequestBody Project projectDetails, @PathVariable(value = "idProject") Integer idProject)
            throws ResourceNotFoundException{
        List <Task> taskList = new ArrayList<>();
        Project project = projectRepo.findById(idProject).orElseThrow(()-> new IllegalStateException("idProject not found"));
        Company company = this.companyService.findCompanyById(project.getCompanyId());

        project.setTaskList(taskList);
        project.setProjectName(projectDetails.getProjectName());
        project.setCompany(company);

        final Project updateProject = projectRepo.save(project);
        return ResponseEntity.ok(updateProject);
    }


    @DeleteMapping("/deleteProject/{idProject}")
    public Map<String, Boolean> deleteTask(@PathVariable(value = "idProject") Integer idProject) throws ResourceNotFoundException{
        Project project = projectRepo.findById(idProject).orElseThrow(()-> new IllegalStateException("idProject not found"));
        projectRepo.delete(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimer", Boolean.TRUE);
        return  response;
    }


//    @GetMapping("/projectsSize")
//    public ResponseEntity<Long> projectSize(){
//        Long projSize = projectService.projectSize();
//        return new ResponseEntity<>(projSize,HttpStatus.OK);
//    }
    
//    @GetMapping("/projectsTaskSize")
//    public ResponseEntity<String> projectTaskSize(){
//        Long projTaskSize = projectRepo.projectTaskSize();
////        System.out.println("projTaskSize " +projTaskSize);
////        return "projTaskSize:" +projTaskSize;
//        return new ResponseEntity<>("projTaskSize " +projTaskSize,HttpStatus.OK);
//    }
}
