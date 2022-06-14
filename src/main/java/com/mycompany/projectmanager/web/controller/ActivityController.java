package com.mycompany.projectmanager.web.controller;

import com.lowagie.text.DocumentException;
import com.mycompany.projectmanager.entities.Activity;
import com.mycompany.projectmanager.pdf.ActivityPdf;
import com.mycompany.projectmanager.repo.ActivityRepo;
import com.mycompany.projectmanager.repo.ResourceNotFoundException;
import com.mycompany.projectmanager.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/activity")
public class ActivityController implements Serializable {


    private final ActivityRepo activityRepo;
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityRepo activityRepo, ActivityService activityService) {
        this.activityRepo = activityRepo;
        this.activityService = activityService;
    }

    @GetMapping("/allActivityByMonth")
    public ResponseEntity<List<Activity>> findAllActivityByMonth(){
        List<Activity> activity = activityService.findActivityByMonth();
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping("/activityByNameActivity")
    public ResponseEntity<List<Activity>> findActivityByNameActivity(){
        List<Activity> activity = activityService.findActivityByNameActivity();
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping("/activityByIsFinishTrue")
    public ResponseEntity<List<Activity>> findActivityByIsFinishTrue(){
        List<Activity> activity = activityService.findActivityByIsFinishTrue();
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping("/activityByIsFinishFalse")
    public ResponseEntity<List<Activity>> findActivityByIsFinishFalse(){
        List<Activity> activity = activityService.findActivityByIsFinishFalse();
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

//    @GetMapping("/activityById/{idActivity}")
//    public ResponseEntity<Activity> findActivityById(@PathVariable(value = "idActivity") Integer idActivity)throws ResourceNotFoundException {
//        Activity activity = activityService.findById(idActivity).orElseThrow(()-> new IllegalStateException("idActivity not found"));
//        return ResponseEntity.ok().body(activity);
//    }

    @GetMapping("/activityByMonth/{monthActivity}")
    public ResponseEntity<Activity> findActivityByMonthActivity(@PathVariable(value = "monthActivity") Integer monthActivity)throws ResourceNotFoundException {
        Activity activity = activityService.findActivityByMonthActivity(monthActivity);
        return ResponseEntity.ok().body(activity);
    }

    @PostMapping("/addActivity")
    public ResponseEntity <Activity>addActivity(@RequestBody Activity activity){
        Activity activity1 = activityService.save(activity);
        return new ResponseEntity<>(activity1, HttpStatus.CREATED);
    }

    @GetMapping("/activityFinishSize")
    public ResponseEntity<Long> activityFinishSize(){
        Long activityFinishSize = activityService.ActivityFinishSize();
        return new ResponseEntity<>(activityFinishSize,HttpStatus.OK);
    }

    @GetMapping("/activityNoFinishSize")
    public ResponseEntity<Long> activityNoFinishSize(){
        Long activityNoFinishSize = activityService.ActivityNoFinishSize();
        return new ResponseEntity<>(activityNoFinishSize,HttpStatus.OK);
    }

    @GetMapping("/allActivitySize")
    public ResponseEntity<Long> allActivitySize(){
        Long allActivitySize = activityService.count();
        return new ResponseEntity<>(allActivitySize,HttpStatus.OK);
    }

    @DeleteMapping("/deleteActivity/{idActivity}")
    public Map<String, Boolean> deleteChild(@PathVariable(value = "idActivity") Integer idActivity) throws ResourceNotFoundException{
        Activity activity = activityRepo.findById(idActivity).orElseThrow(()-> new IllegalStateException("idActivity not found"));
        activityRepo.delete(activity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Activité supprimer", Boolean.TRUE);
        return  response;
    }


    @PutMapping("/updateActivity/{idActivity}")
    public ResponseEntity<Activity> updateActivity(@Valid @RequestBody Activity activityDetails, @PathVariable(value = "idActivity") Integer idActivity)throws ResourceNotFoundException {

        Activity activity = activityRepo.findById(idActivity).orElseThrow(()-> new IllegalStateException("idActivity not found"));

        activity.setNameActivity(activityDetails.getNameActivity());
        activity.setDescriptionActivity(activityDetails.getDescriptionActivity());
        activity.setDescriptionActivityFinal(activityDetails.getDescriptionActivityFinal());
        activity.setDayActivity(activityDetails.getDayActivity());
        activity.setMonthActivity(activityDetails.getMonthActivity());        
        activity.setImageActivity(activityDetails.getImageActivity());
        activity.setFinish(activityDetails.isFinish());

        final Activity updateActivity = activityRepo.save(activity);
        return ResponseEntity.ok(updateActivity);
    }

    @GetMapping("/activityById/{idActivity}")
        public ResponseEntity<Optional<Activity>> getActivityById(@PathVariable(value = "idActivity") Integer idActivity)throws ResourceNotFoundException{
            Optional<Activity> activity = activityService.findById(idActivity);
            return ResponseEntity.ok().body(activity);
        }


    @GetMapping("/exportActivity")
    public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=activity_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Activity> listActivitys = activityService.findActivityByMonth();

        ActivityPdf exporter = new ActivityPdf(listActivitys);
        exporter.export(response);
    }

}
