package com.mycompany.projectmanager.entities;



import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "child")
public class Child extends AbstractEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "num_benef")
    private String numeroBeneficiaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name_child")
    private String firstNameChild;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name_child")
    private String lastNameChild;


    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "jour_naiss")
    private Integer jourNaiss;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "mois_naiss")
    private Integer moisNaiss;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "anne_naiss")
    private Integer anneNaiss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;

    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "parrain_name")
    private String parrainName;

    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "num_parrain")
    private String numeroParrain;

    @Nullable
    @Size(min = 1, max = 200)
    @Column(name = "observation")
    private String observation;

    @Nullable
    @Column(name = "date_entry")
    private Integer dateEntry;

    @Nullable
    @Column(name = "date_out")
    private Integer dateOut;

    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private Character gender;


    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project1")
    private String project1;


    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project2")
    private String project2;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project3")
    private String project3;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project4")
    private String project4;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project5")
    private String project5;


//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project6")
    private String project6;


//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project7")
    private String project7;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project8")
    private String project8;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project9")
    private String project9;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project10")
    private String project10;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project11")
    private String project11;


//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "project12")
    private String project12;


//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "start_class")
    private String startClass;

//    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 10)
    @Column(name = "end_class")
    private String endClass;

    public Child() {
    }


    public Child(String numeroBeneficiaire, String firstNameChild, String lastNameChild, Integer jourNaiss, Integer moisNaiss, Integer anneNaiss, String status, @Nullable String parrainName, @Nullable String numeroParrain, @Nullable String observation, @Nullable Integer dateEntry, @Nullable Integer dateOut, Character gender, @Nullable String project1, @Nullable String project2, @Nullable String project3, @Nullable String project4, @Nullable String project5, @Nullable String project6, @Nullable String project7, @Nullable String project8, @Nullable String project9, @Nullable String project10, @Nullable String project11, @Nullable String project12, @Nullable String startClass, @Nullable String endClass) {
        this.numeroBeneficiaire = numeroBeneficiaire;
        this.firstNameChild = firstNameChild;
        this.lastNameChild = lastNameChild;
        this.jourNaiss = jourNaiss;
        this.moisNaiss = moisNaiss;
        this.anneNaiss = anneNaiss;
        this.status = status;
        this.parrainName = parrainName;
        this.numeroParrain = numeroParrain;
        this.observation = observation;
        this.dateEntry = dateEntry;
        this.dateOut = dateOut;
        this.gender = gender;
        this.project1 = project1;
        this.project2 = project2;
        this.project3 = project3;
        this.project4 = project4;
        this.project5 = project5;
        this.project6 = project6;
        this.project7 = project7;
        this.project8 = project8;
        this.project9 = project9;
        this.project10 = project10;
        this.project11 = project11;
        this.project12 = project12;
        this.startClass = startClass;
        this.endClass = endClass;
    }


    public String getNumeroBeneficiaire() {
        return numeroBeneficiaire;
    }

    public void setNumeroBeneficiaire(String numeroBeneficiaire) {
        this.numeroBeneficiaire = numeroBeneficiaire;
    }

    public String getFirstNameChild() {
        return firstNameChild;
    }

    public void setFirstNameChild(String firstNameChild) {
        this.firstNameChild = firstNameChild;
    }

    public String getLastNameChild() {
        return lastNameChild;
    }

    public void setLastNameChild(String lastNameChild) {
        this.lastNameChild = lastNameChild;
    }

    public Integer getJourNaiss() {
        return jourNaiss;
    }

    public void setJourNaiss(Integer jourNaiss) {
        this.jourNaiss = jourNaiss;
    }

    public Integer getMoisNaiss() {
        return moisNaiss;
    }

    public void setMoisNaiss(Integer moisNaiss) {
        this.moisNaiss = moisNaiss;
    }

    public Integer getAnneNaiss() {
        return anneNaiss;
    }

    public void setAnneNaiss(Integer anneNaiss) {
        this.anneNaiss = anneNaiss;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Nullable
    public String getParrainName() {
        return parrainName;
    }

    public void setParrainName(@Nullable String parrainName) {
        this.parrainName = parrainName;
    }

    @Nullable
    public String getNumeroParrain() {
        return numeroParrain;
    }

    public void setNumeroParrain(@Nullable String numeroParrain) {
        this.numeroParrain = numeroParrain;
    }

    @Nullable
    public String getObservation() {
        return observation;
    }

    public void setObservation(@Nullable String observation) {
        this.observation = observation;
    }

    @Nullable
    public Integer getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(@Nullable Integer dateEntry) {
        this.dateEntry = dateEntry;
    }

    @Nullable
    public Integer getDateOut() {
        return dateOut;
    }

    public void setDateOut(@Nullable Integer dateOut) {
        this.dateOut = dateOut;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Nullable
    public String getProject1() {
        return project1;
    }

    public void setProject1(@Nullable String project1) {
        this.project1 = project1;
    }

    @Nullable
    public String getProject2() {
        return project2;
    }

    public void setProject2(@Nullable String project2) {
        this.project2 = project2;
    }

    @Nullable
    public String getProject3() {
        return project3;
    }

    public void setProject3(@Nullable String project3) {
        this.project3 = project3;
    }

    @Nullable
    public String getProject4() {
        return project4;
    }

    public void setProject4(@Nullable String project4) {
        this.project4 = project4;
    }

    @Nullable
    public String getProject5() {
        return project5;
    }

    public void setProject5(@Nullable String project5) {
        this.project5 = project5;
    }

    @Nullable
    public String getProject6() {
        return project6;
    }

    public void setProject6(@Nullable String project6) {
        this.project6 = project6;
    }

    @Nullable
    public String getProject7() {
        return project7;
    }

    public void setProject7(@Nullable String project7) {
        this.project7 = project7;
    }

    @Nullable
    public String getProject8() {
        return project8;
    }

    public void setProject8(@Nullable String project8) {
        this.project8 = project8;
    }

    @Nullable
    public String getProject9() {
        return project9;
    }

    public void setProject9(@Nullable String project9) {
        this.project9 = project9;
    }

    @Nullable
    public String getProject10() {
        return project10;
    }

    public void setProject10(@Nullable String project10) {
        this.project10 = project10;
    }

    @Nullable
    public String getProject11() {
        return project11;
    }

    public void setProject11(@Nullable String project11) {
        this.project11 = project11;
    }

    @Nullable
    public String getProject12() {
        return project12;
    }

    public void setProject12(@Nullable String project12) {
        this.project12 = project12;
    }

    @Nullable
    public String getStartClass() {
        return startClass;
    }

    public void setStartClass(@Nullable String startClass) {
        this.startClass = startClass;
    }

    @Nullable
    public String getEndClass() {
        return endClass;
    }

    public void setEndClass(@Nullable String endClass) {
        this.endClass = endClass;
    }

    @Override
    public String toString() {
        return "Child{" +
                "numeroBeneficiaire='" + numeroBeneficiaire + '\'' +
                ", firstNameChild='" + firstNameChild + '\'' +
                ", lastNameChild='" + lastNameChild + '\'' +
                ", jourNaiss=" + jourNaiss +
                ", moisNaiss=" + moisNaiss +
                ", anneNaiss=" + anneNaiss +
                ", status='" + status + '\'' +
                ", parrainName='" + parrainName + '\'' +
                ", numeroParrain='" + numeroParrain + '\'' +
                ", observation='" + observation + '\'' +
                ", dateEntry=" + dateEntry +
                ", dateOut=" + dateOut +
                ", gender=" + gender +
                ", project1='" + project1 + '\'' +
                ", project2='" + project2 + '\'' +
                ", project3='" + project3 + '\'' +
                ", project4='" + project4 + '\'' +
                ", project5='" + project5 + '\'' +
                ", project6='" + project6 + '\'' +
                ", project7='" + project7 + '\'' +
                ", project8='" + project8 + '\'' +
                ", project9='" + project9 + '\'' +
                ", project10='" + project10 + '\'' +
                ", project11='" + project11 + '\'' +
                ", project12='" + project12 + '\'' +
                ", startClass='" + startClass + '\'' +
                ", endClass='" + endClass + '\'' +
                '}';
    }
}
