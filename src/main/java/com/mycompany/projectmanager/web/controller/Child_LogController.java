package com.mycompany.projectmanager.web.controller;

import com.lowagie.text.DocumentException;
import com.mycompany.projectmanager.entities.Child_Log;
import com.mycompany.projectmanager.pdf.ChildLogPdf;
import com.mycompany.projectmanager.repo.Child_LogRepo;
import com.mycompany.projectmanager.repo.ResourceNotFoundException;
import com.mycompany.projectmanager.service.Child_LogService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/childLog")
public class Child_LogController  implements Serializable {

    private final Child_LogService childLogService;

    public static long allChildLogSize;
    public static long childLogMSize;
    public static long childLogFSize;
    public static long childLogSponsorSize;
    public static long childLogNoSponsorSize;

//    private final Child_LogRepo childLogRepo;


    @Autowired
    public Child_LogController(Child_LogService childLogService) {
        this.childLogService = childLogService;
        this.allChildLogSize();
        this.childLogMSize();
        this.ChildLogFSize();
        this.childLogSponsorSize();
        this.ChildLogNoSponsorSize();
//        this.childLogRepo = childLogRepo;
    }


    @GetMapping("/childLogListByNum")
    public ResponseEntity<List<Child_Log>> findChildLogByNumeroBeneficiaire(){
        List<Child_Log> childs = childLogService.findChildLogByNumeroBeneficiaire();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }

    @GetMapping("/childLogListByLastName")
    public ResponseEntity<List<Child_Log>>findChildLogByLastNameChild(){
        List<Child_Log> childs = childLogService.findChildLogByLastNameChild();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }

    @GetMapping("/childLogListByGnderM")
    public ResponseEntity<List<Child_Log>>findChildLogByGenderM(){
        List<Child_Log> childs = childLogService.findChildLogByGenderM();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/childLogListByGnderF")
    public ResponseEntity<List<Child_Log>>findChildLogByGenderF(){
        List<Child_Log> childs = childLogService.findChildLogByGenderF();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/childLogListBySponsor")
    public ResponseEntity<List<Child_Log>>findChildLogBySponsore(){
        List<Child_Log> childs = childLogService.findChildLogBySponsore();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/childLogListByNoSponsor")
    public ResponseEntity<List<Child_Log>>findChildLogByNoSponsor(){
        List<Child_Log> childs = childLogService.findChildLogByNoSponsor();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }

    @GetMapping("/getChildLog/{numeroBeneficiaireLog}")
    public ResponseEntity<Child_Log> findChildLogByNumBnf(@PathVariable(value = "numeroBeneficiaireLog") String numeroBeneficiaireLog)throws ResourceNotFoundException {
        Child_Log child = childLogService.findChildLogByNumBnf(numeroBeneficiaireLog);
        return ResponseEntity.ok().body(child);
    }


    @GetMapping("/allChildLogSize")
    public ResponseEntity<Long> allChildLogSize(){
        Long childLogAllSize = childLogService.count();
        allChildLogSize = childLogService.count();
        return new ResponseEntity<>(childLogAllSize,HttpStatus.OK);
    }


    @GetMapping("/childLogMSize")
    public ResponseEntity<Long> childLogMSize(){
        Long childMSize = childLogService.ChildLogMSize();
        childLogMSize = childLogService.ChildLogMSize();
        return new ResponseEntity<>(childMSize,HttpStatus.OK);
    }

    @GetMapping("/childLogFSize")
    public ResponseEntity<Long> ChildLogFSize(){
        Long childFSize = childLogService.ChildLogFSize();
        childLogFSize = childLogService.ChildLogFSize();
        return new ResponseEntity<>(childFSize,HttpStatus.OK);
    }

    @GetMapping("/childLogSponsorSize")
    public ResponseEntity<Long> childLogSponsorSize(){
        Long childSponsorSize = childLogService.ChildLogSponsorSize();
        childLogSponsorSize = childLogService.ChildLogSponsorSize();
        return new ResponseEntity<>(childSponsorSize,HttpStatus.OK);
    }

    @GetMapping("/childLogNoSponsorSize")
    public ResponseEntity<Long> ChildLogNoSponsorSize(){
        Long childNoSponsorSize = childLogService.ChildLogNoSponsorSize();
        childLogNoSponsorSize = childLogService.ChildLogNoSponsorSize();
        return new ResponseEntity<>(childNoSponsorSize,HttpStatus.OK);
    }

    @PostMapping("/addChildLog")
    public ResponseEntity <Child_Log>addChildLog(@RequestBody Child_Log childLog){
        Child_Log child1 = childLogService.save(childLog);
        return new ResponseEntity<>(child1, HttpStatus.CREATED);
    }


//    @PutMapping("/updateChildLog/{numeroBeneficiaireLog}")
//    public ResponseEntity<Child_Log>  updateChildLog(@Valid @RequestBody Child_Log childDetails, @PathVariable(value = "numeroBeneficiaireLog") String numeroBeneficiaireLog)throws ResourceNotFoundException {
//
//        Child_Log child = childLogRepo.findChildLogByNumBnf(numeroBeneficiaireLog);
//
//        child.setFirstNameChildLog(childDetails.getFirstNameChildLog());
//        child.setLastNameChildLog(childDetails.getLastNameChildLog());
//        child.setGenderLog(childDetails.getGenderLog());
//        child.setJourNaissLog(childDetails.getJourNaissLog());
//        child.setMoisNaissLog(childDetails.getMoisNaissLog());
//        child.setAnneNaissLog(childDetails.getAnneNaissLog());
//        child.setEndClass(childDetails.getEndClass());
//        child.setDateOutLog(childDetails.getDateOutLog());
//        child.setDateEntryLog(childDetails.getDateEntryLog());
//        child.setStatusLog(childDetails.getStatusLog());
//        child.setParrainNameLog(childDetails.getParrainNameLog());
//        child.setNumeroParrainLog(childDetails.getNumeroParrainLog());
//        child.setObservationLog(childDetails.getObservationLog());
//        child.setStartClass(childDetails.getStartClass());
//        child.setFirstproject(childDetails.getFirstproject());
//        child.setLastproject(childDetails.getLastproject());
//
//        final Child_Log updateChildLog = childLogRepo.save(child);
//        return ResponseEntity.ok(updateChildLog);
//    }
//
//    @DeleteMapping("/deleteChildLog/{numeroBeneficiaireLog}")
//    public Map<String, Boolean> deleteChildLog(@PathVariable(value = "numeroBeneficiaireLog") String numeroBeneficiaireLog) throws ResourceNotFoundException{
//        Child_Log child = childLogRepo.findChildLogByNumBnf(numeroBeneficiaireLog);
//        childLogRepo.delete(child);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("Child supprimer", Boolean.TRUE);
//        return  response;
//    }

    @GetMapping("/exportChildLogByNum")
    public void exportChildByNum(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childByNum_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child_Log> listChildLogByNum = childLogService.findChildLogByNumeroBeneficiaire();

        ChildLogPdf exporter = new ChildLogPdf(listChildLogByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildLogByLastName")
    public void exportChildByLastName(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childByLastName_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child_Log> listChildLogByNum = childLogService.findChildLogByLastNameChild();

        ChildLogPdf exporter = new ChildLogPdf(listChildLogByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildLogByGenderM")
    public void exportChildByGenderM(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childLogByGenderM_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child_Log> listChildLogByNum = childLogService.findChildLogByGenderM();

        ChildLogPdf exporter = new ChildLogPdf(listChildLogByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildLogByGenderF")
    public void exportChildByGenderF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=ChildLogByGenderF_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child_Log> listChildLogByNum = childLogService.findChildLogByGenderF();

        ChildLogPdf exporter = new ChildLogPdf(listChildLogByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildLogBySponsor")
    public void exportChildBySponsor(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childLogBySponsor_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child_Log> listChildLogByNum = childLogService.findChildLogBySponsore();

        ChildLogPdf exporter = new ChildLogPdf(listChildLogByNum);
        exporter.export(response);
    }


    @GetMapping("/exportChildLogByNoSponsor")
    public void exportChildByNoSponsor(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childLogByNoSponsor_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child_Log> listChildLogByNum = childLogService.findChildLogByNoSponsor();

        ChildLogPdf exporter = new ChildLogPdf(listChildLogByNum);
        exporter.export(response);
    }
}
