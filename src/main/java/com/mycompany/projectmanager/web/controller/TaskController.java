package com.mycompany.projectmanager.web.controller;

import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.entities.TaskLog;
import com.mycompany.projectmanager.repo.ResourceNotFoundException;
import com.mycompany.projectmanager.repo.TaskRepo;
import com.mycompany.projectmanager.service.ProjectService;
import com.mycompany.projectmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/task")
public class TaskController{

    private final TaskService taskService;
    private final TaskRepo taskRepo;
    private  final ProjectService projectService;

    @Autowired
    public TaskController(TaskService taskService, TaskRepo taskRepo, ProjectService projectService) {
        this.taskService = taskService;
        this.taskRepo = taskRepo;
        this.projectService = projectService;
    }

        @GetMapping("/tasksList")
        public ResponseEntity<List<Task>> taskList(){
            List<Task> tasks = taskService.findAll();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/tasksList/{idProject}")
        public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable("idProject") Integer idProject){
            List<Task> tasks = taskService.findAllTasksByProjectId(idProject);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/tasksListById/{idTask}")
        public ResponseEntity<Task> getTasksById(@PathVariable(value = "idTask") Integer idTask)throws ResourceNotFoundException{
            Task tasks = taskService.findTaskById(idTask);
            return ResponseEntity.ok().body(tasks);
        }


        @PostMapping("/addTask")
        public ResponseEntity <Task>addTask(@RequestBody Task task){
            Task task1 = taskService.save(task);
            return new ResponseEntity<>(task1, HttpStatus.CREATED);
        }


        @PutMapping("/updateTask/{idTask}")
            public ResponseEntity<Task>  updateTask(@Valid @RequestBody Task taskDetails, @PathVariable(value = "idTask") Integer idTask)throws ResourceNotFoundException{
                List <TaskLog> taskLogs = new ArrayList<>();
                Task task = taskRepo.findById(idTask).orElseThrow(()-> new IllegalStateException("idTask not found"));
                Project project = this.projectService.findProjectById(task.getPojectId());

                task.setTaskLogs(taskLogs);
    //            task.setIdTask(taskDetails.getIdTask());
                task.setTaskName(taskDetails.getTaskName());
                task.setProject(project);

                final Task updateTask = taskRepo.save(task);
                return ResponseEntity.ok(updateTask);
        }


        @DeleteMapping("/deleteTask/{idTask}")
        public Map<String, Boolean> deleteTask(@PathVariable(value = "idTask") Integer idTask) throws ResourceNotFoundException{
            Task task = taskRepo.findById(idTask).orElseThrow(()-> new IllegalStateException("idTask not found"));
            taskRepo.delete(task);
            Map<String, Boolean> response = new HashMap<>();
            response.put("supprimer", Boolean.TRUE);
            return  response;
        }


        @GetMapping("/tasksSize")
        public ResponseEntity<Long> taskSize(){
            Long taskSize = taskService.count();
            return new ResponseEntity<>(taskSize,HttpStatus.OK);
        }


}
