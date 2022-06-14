package com.mycompany.projectmanager.web.controller;


import com.lowagie.text.DocumentException;
import com.mycompany.projectmanager.entities.Child;
import com.mycompany.projectmanager.pdf.ChildPdfByNum;
import com.mycompany.projectmanager.pdf.ChildProjectPdfByLastName;
import com.mycompany.projectmanager.repo.ChildRepo;
import com.mycompany.projectmanager.repo.ResourceNotFoundException;
import com.mycompany.projectmanager.service.ChildService;
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
@RequestMapping("/child")
public class ChildController implements Serializable {

    private final ChildRepo childRepo;
    private final ChildService childService;

    public static long allChild2Size;
    public static long child2MSize;
    public static long child2FSize;
    public static long child2SponsorSize;
    public static long child2NoSponsorSize;

    @Autowired
    public ChildController(ChildRepo childRepo, ChildService childService) {
        this.childRepo = childRepo;
        this.childService = childService;

        this.allChildSize();
        this.childMSize();
        this.ChildFSize();
        this.childSponsorSize();
        this.ChildNoSponsorSize();
    }

    @GetMapping("/childListByNum")
    public ResponseEntity<List<Child>>findChildByNumeroBeneficiaire(){
        List<Child> childs = childService.findChildByNumeroBeneficiaire();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }

    @GetMapping("/childListByLastName")
    public ResponseEntity<List<Child>>findChildByLastNameChild(){
        List<Child> childs = childService.findChildByLastNameChild();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }

    @GetMapping("/childListByGnderM")
    public ResponseEntity<List<Child>>findChildByGenderM(){
        List<Child> childs = childService.findChildByGenderM();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/childListByGnderF")
    public ResponseEntity<List<Child>>findChildByGenderF(){
        List<Child> childs = childService.findChildByGenderF();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/childListBySponsor")
    public ResponseEntity<List<Child>>findChildBySponsore(){
        List<Child> childs = childService.findChildBySponsore();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/childListByNoSponsor")
    public ResponseEntity<List<Child>>findChildByNoSponsor(){
        List<Child> childs = childService.findChildByNoSponsor();
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/childListByAnniv/{mois}")
    public ResponseEntity<List<Child>>findChildByAnniv(@PathVariable(value = "mois")Integer mois){
        List<Child> childs = childService.findChildByAnniv(mois);
        return new ResponseEntity<>(childs, HttpStatus.OK);
    }


    @GetMapping("/allChildSize")
    public ResponseEntity<Long> allChildSize(){
        Long childAllSize = childService.count();
        allChild2Size = childService.count();
        return new ResponseEntity<>(childAllSize,HttpStatus.OK);
    }

    @GetMapping("/childAnnivSize/{mois}")
    public ResponseEntity<Long> childAnnivSize(@PathVariable(value = "mois")Integer mois){
        Long childMSize = childService.ChildAnnivSize(mois);
        return new ResponseEntity<>(childMSize,HttpStatus.OK);
    }
    @GetMapping("/childMSize")
    public ResponseEntity<Long> childMSize(){
        Long childMSize = childService.ChildMSize();
        child2MSize = childService.ChildMSize();
        return new ResponseEntity<>(childMSize,HttpStatus.OK);
    }

    @GetMapping("/childFSize")
    public ResponseEntity<Long> ChildFSize(){
        Long childFSize = childService.ChildFSize();
        child2FSize = childService.ChildFSize();
        return new ResponseEntity<>(childFSize,HttpStatus.OK);
    }

    @GetMapping("/childSponsorSize")
    public ResponseEntity<Long> childSponsorSize(){
        Long childSponsorSize = childService.ChildSponsorSize();
        child2SponsorSize = childService.ChildSponsorSize();
        return new ResponseEntity<>(childSponsorSize,HttpStatus.OK);
    }

    @GetMapping("/childNoSponsorSize")
    public ResponseEntity<Long> ChildNoSponsorSize(){
        Long childNoSponsorSize = childService.ChildNoSponsorSize();
        child2NoSponsorSize = childService.ChildNoSponsorSize();
        return new ResponseEntity<>(childNoSponsorSize,HttpStatus.OK);
    }

    @PostMapping("/addChild")
    public ResponseEntity <Child>addChild(@RequestBody Child child){
        Child child1 = childService.save(child);
        return new ResponseEntity<>(child1, HttpStatus.CREATED);
    }


            @PutMapping("/updateChild/{numeroBeneficiaire}")
            public ResponseEntity<Child>  updateChild(@Valid @RequestBody Child childDetails, @PathVariable(value = "numeroBeneficiaire") String numeroBeneficiaire)throws ResourceNotFoundException {

                Child child = childRepo.findChildByNumBnf(numeroBeneficiaire);

                child.setFirstNameChild(childDetails.getFirstNameChild());
                child.setLastNameChild(childDetails.getLastNameChild());
                child.setGender(childDetails.getGender());
                child.setJourNaiss(childDetails.getJourNaiss());
                child.setMoisNaiss(childDetails.getMoisNaiss());
                child.setAnneNaiss(childDetails.getAnneNaiss());
                child.setEndClass(childDetails.getEndClass());
                child.setDateOut(childDetails.getDateOut());
                child.setDateEntry(childDetails.getDateEntry());
                child.setStatus(childDetails.getStatus());
                child.setParrainName(childDetails.getParrainName());
                child.setNumeroParrain(childDetails.getNumeroParrain());
                child.setObservation(childDetails.getObservation());
                child.setStartClass(childDetails.getStartClass());
                child.setProject1(childDetails.getProject1());
                child.setProject2(childDetails.getProject2());
                child.setProject3(childDetails.getProject3());
                child.setProject4(childDetails.getProject4());
                child.setProject5(childDetails.getProject5());
                child.setProject6(childDetails.getProject6());
                child.setProject7(childDetails.getProject7());
                child.setProject8(childDetails.getProject8());
                child.setProject9(childDetails.getProject9());
                child.setProject10(childDetails.getProject10());
                child.setProject11(childDetails.getProject11());
                child.setProject12(childDetails.getProject12());


                final Child updateChild = childRepo.save(child);
                return ResponseEntity.ok(updateChild);
    }

    @GetMapping("/getChild/{numeroBeneficiaire}")
        public ResponseEntity<Child> getChilsById(@PathVariable(value = "numeroBeneficiaire") String numeroBeneficiaire)throws ResourceNotFoundException{
            Child child = childService.findChildByNumBnf(numeroBeneficiaire);
            return ResponseEntity.ok().body(child);
        }


    @DeleteMapping("/deleteChild/{numeroBeneficiaire}")
        public Map<String, Boolean> deleteChild(@PathVariable(value = "numeroBeneficiaire") String numeroBeneficiaire) throws ResourceNotFoundException{
        Child child = childRepo.findChildByNumBnf(numeroBeneficiaire);
            childRepo.delete(child);
            Map<String, Boolean> response = new HashMap<>();
            response.put("Child supprimer", Boolean.TRUE);
            return  response;
        }

    @GetMapping("/exportChildByNum")
    public void exportChildByNum(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childByNum_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child> listChildByNum = childService.findChildByNumeroBeneficiaire();

        ChildPdfByNum exporter = new ChildPdfByNum(listChildByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildByLastName")
    public void exportChildByLastName(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childByLastName_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child> listChildByNum = childService.findChildByLastNameChild();

        ChildPdfByNum exporter = new ChildPdfByNum(listChildByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildByGenderM")
    public void exportChildByGenderM(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childByGenderM_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child> listChildByNum = childService.findChildByGenderM();

        ChildPdfByNum exporter = new ChildPdfByNum(listChildByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildByGenderF")
    public void exportChildByGenderF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childByGenderF_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child> listChildByNum = childService.findChildByGenderF();

        ChildPdfByNum exporter = new ChildPdfByNum(listChildByNum);
        exporter.export(response);
    }

    @GetMapping("/exportChildBySponsor")
    public void exportChildBySponsor(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childBySponsor_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child> listChildByNum = childService.findChildBySponsore();

        ChildPdfByNum exporter = new ChildPdfByNum(listChildByNum);
        exporter.export(response);
    }


    @GetMapping("/exportChildByNoSponsor")
    public void exportChildByNoSponsor(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childByNoSponsor_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child> listChildByNum = childService.findChildByNoSponsor();

        ChildPdfByNum exporter = new ChildPdfByNum(listChildByNum);
        exporter.export(response);
    }


    @GetMapping("/exportChildProjectByLastName")
    public void exportChildProjectByLastName(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
        String currentDateTime = dateFormat.format(new Date());

        String headerkey = "Content-Disposition";
        String headerValue = "attachment; filename=childProjectByLastName_"+currentDateTime+".pdf";

        response.setHeader(headerkey, headerValue);

        List<Child> listChildProjectByLastName = childService.findChildByLastNameChild();

        ChildProjectPdfByLastName exporter = new ChildProjectPdfByLastName(listChildProjectByLastName);
        exporter.export(response);
    }




}
