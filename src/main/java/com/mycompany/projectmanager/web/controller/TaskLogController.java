package com.mycompany.projectmanager.web.controller;


import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.entities.TaskLog;
import com.mycompany.projectmanager.repo.ResourceNotFoundException;
import com.mycompany.projectmanager.repo.TaskLogRepo;
import com.mycompany.projectmanager.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/taskLog")
public class TaskLogController {

    private final TaskLogService taskLogService;
    private  final TaskLogRepo taskLogRepo;

    @Autowired
    public TaskLogController(TaskLogService taskLogService, TaskLogRepo taskLogRepo) {

        this.taskLogService = taskLogService;
        this.taskLogRepo = taskLogRepo;
    }

    @GetMapping("/taskLogList")
    public ResponseEntity<List<TaskLog>> taskLogList(){
        List<TaskLog> taskLogs = taskLogService.findAll();
        return new ResponseEntity<>(taskLogs,HttpStatus.OK);
    }

    @GetMapping("/tasksLogSize")
    public ResponseEntity<Long> tasksLogSize(){
        Long tasksLogSize = taskLogService.count();
        return new ResponseEntity<>(tasksLogSize,HttpStatus.OK);
    }

    @PostMapping("/addTaskLog")
    public ResponseEntity <TaskLog>addTaskLog(@RequestBody TaskLog taskLog){
        TaskLog taskLog1 = taskLogService.save(taskLog);
        return new ResponseEntity<>(taskLog1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTaskLog/{idTaskLog}")
    public Map<String, Boolean> deleteTaskLog(@PathVariable(value = "idTaskLog") Integer idTaskLog) throws ResourceNotFoundException {
        TaskLog taskLog = taskLogRepo.findById(idTaskLog).orElseThrow(()-> new IllegalStateException("idTaskLog not found"));
        taskLogRepo.delete(taskLog);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimer", Boolean.TRUE);
        return  response;
    }

}
