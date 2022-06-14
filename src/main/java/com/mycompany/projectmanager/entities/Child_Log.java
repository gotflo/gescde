package com.mycompany.projectmanager.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "child_Log")
public class Child_Log extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "num_benef_log")
    private String numeroBeneficiaireLog;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name_child_log")
    private String firstNameChildLog;


    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name_child_log")
    private String lastNameChildLog;

    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "parrain_name_log")
    private String parrainNameLog;

    @Nullable
    @Size(min = 1, max = 10)
    @Column(name = "num_parrain_log")
    private String numeroParrainLog;


    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status_log")
    private String statusLog;

    @Nullable
    @Size(min = 1, max = 200)
    @Column(name = "observation_log")
    private String observationLog;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "jour_naiss_log")
    private Integer jourNaissLog;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "mois_naiss_log")
    private Integer moisNaissLog;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "anne_naiss_log")
    private Integer anneNaissLog;
    @Nullable
    @Column(name = "date_entry_log")
    private Integer dateEntryLog;

    @Nullable
    @Column(name = "date_out_log")
    private Integer dateOutLog;

    @Basic(optional = false)
    @NotNull
    @Column(name = "gender_log")
    private Character genderLog;

    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "first_project")
    private String Firstproject;

    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "last_project")
    private String Lastproject;

    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "start_class")
    private String startClass;

    @Nullable
    @Size(min = 1, max = 100)
    @Column(name = "end_class")
    private String endClass;

    public Child_Log() {
    }

    public Child_Log(String numeroBeneficiaireLog, String firstNameChildLog, String lastNameChildLog, @Nullable String parrainNameLog, @Nullable String numeroParrainLog, String statusLog, @Nullable String observationLog, Integer jourNaissLog, Integer moisNaissLog, Integer anneNaissLog, @Nullable Integer dateEntryLog, @Nullable Integer dateOutLog, Character genderLog, @Nullable String firstproject, @Nullable String lastproject, @Nullable String startClass, @Nullable String endClass) {
        this.numeroBeneficiaireLog = numeroBeneficiaireLog;
        this.firstNameChildLog = firstNameChildLog;
        this.lastNameChildLog = lastNameChildLog;
        this.parrainNameLog = parrainNameLog;
        this.numeroParrainLog = numeroParrainLog;
        this.statusLog = statusLog;
        this.observationLog = observationLog;
        this.jourNaissLog = jourNaissLog;
        this.moisNaissLog = moisNaissLog;
        this.anneNaissLog = anneNaissLog;
        this.dateEntryLog = dateEntryLog;
        this.dateOutLog = dateOutLog;
        this.genderLog = genderLog;
        this.Firstproject = firstproject;
        this.Lastproject = lastproject;
        this.startClass = startClass;
        this.endClass = endClass;
    }

    public String getNumeroBeneficiaireLog() {
        return numeroBeneficiaireLog;
    }

    public void setNumeroBeneficiaireLog(String numeroBeneficiaireLog) {
        this.numeroBeneficiaireLog = numeroBeneficiaireLog;
    }

    public String getFirstNameChildLog() {
        return firstNameChildLog;
    }

    public void setFirstNameChildLog(String firstNameChildLog) {
        this.firstNameChildLog = firstNameChildLog;
    }

    public String getLastNameChildLog() {
        return lastNameChildLog;
    }

    public void setLastNameChildLog(String lastNameChildLog) {
        this.lastNameChildLog = lastNameChildLog;
    }

    @Nullable
    public String getParrainNameLog() {
        return parrainNameLog;
    }

    public void setParrainNameLog(@Nullable String parrainNameLog) {
        this.parrainNameLog = parrainNameLog;
    }

    @Nullable
    public String getNumeroParrainLog() {
        return numeroParrainLog;
    }

    public void setNumeroParrainLog(@Nullable String numeroParrainLog) {
        this.numeroParrainLog = numeroParrainLog;
    }

    public String getStatusLog() {
        return statusLog;
    }

    public void setStatusLog(String statusLog) {
        this.statusLog = statusLog;
    }

    @Nullable
    public String getObservationLog() {
        return observationLog;
    }

    public void setObservationLog(@Nullable String observationLog) {
        this.observationLog = observationLog;
    }

    public Integer getJourNaissLog() {
        return jourNaissLog;
    }

    public void setJourNaissLog(Integer jourNaissLog) {
        this.jourNaissLog = jourNaissLog;
    }

    public Integer getMoisNaissLog() {
        return moisNaissLog;
    }

    public void setMoisNaissLog(Integer moisNaissLog) {
        this.moisNaissLog = moisNaissLog;
    }

    public Integer getAnneNaissLog() {
        return anneNaissLog;
    }

    public void setAnneNaissLog(Integer anneNaissLog) {
        this.anneNaissLog = anneNaissLog;
    }

    @Nullable
    public Integer getDateEntryLog() {
        return dateEntryLog;
    }

    public void setDateEntryLog(@Nullable Integer dateEntryLog) {
        this.dateEntryLog = dateEntryLog;
    }

    @Nullable
    public Integer getDateOutLog() {
        return dateOutLog;
    }

    public void setDateOutLog(@Nullable Integer dateOutLog) {
        this.dateOutLog = dateOutLog;
    }

    public Character getGenderLog() {
        return genderLog;
    }

    public void setGenderLog(Character genderLog) {
        this.genderLog = genderLog;
    }

    @Nullable
    public String getFirstproject() {
        return Firstproject;
    }

    public void setFirstproject(@Nullable String firstproject) {
        Firstproject = firstproject;
    }

    @Nullable
    public String getLastproject() {
        return Lastproject;
    }

    public void setLastproject(@Nullable String lastproject) {
        Lastproject = lastproject;
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
        return "Child_Log{" +
                "numeroBeneficiaireLog='" + numeroBeneficiaireLog + '\'' +
                ", firstNameChildLog='" + firstNameChildLog + '\'' +
                ", lastNameChildLog='" + lastNameChildLog + '\'' +
                ", parrainNameLog='" + parrainNameLog + '\'' +
                ", numeroParrainLog='" + numeroParrainLog + '\'' +
                ", statusLog='" + statusLog + '\'' +
                ", observationLog='" + observationLog + '\'' +
                ", jourNaissLog=" + jourNaissLog +
                ", moisNaissLog=" + moisNaissLog +
                ", anneNaissLog=" + anneNaissLog +
                ", dateEntryLog=" + dateEntryLog +
                ", dateOutLog=" + dateOutLog +
                ", genderLog=" + genderLog +
                ", Firstproject='" + Firstproject + '\'' +
                ", Lastproject='" + Lastproject + '\'' +
                ", startClass='" + startClass + '\'' +
                ", endClass='" + endClass + '\'' +
                '}';
    }
}
