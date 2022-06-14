package com.mycompany.projectmanager.entities;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "activity")
public class Activity extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_activity")
    private Integer idActivity;


    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name_activity")
    private String nameActivity;

    @Nullable
    @Size(min = 1, max = 1500)
    @Column(name = "description_activity")
    private String descriptionActivity;

    @Nullable
    @Size(min = 1, max = 1500)
    @Column(name = "description_activity_final")
    private String descriptionActivityFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "day_activity")
    private Integer dayActivity;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "month_activity")
    private Integer monthActivity;


    @Nullable
    @Size(min = 1, max = 5)
    @Column(name = "is_finish")
    private Boolean isFinish;

    @Nullable
    @Column(name = "image_activity")
    private String imageActivity;

    public Activity() {
    }

    public Activity(Integer idActivity, String nameActivity, String descriptionActivity, String descriptionActivityFinal, Integer dayActivity, Integer monthActivity, Boolean isFinish, String imageActivity) {
        this.idActivity = idActivity;
        this.nameActivity = nameActivity;
        this.descriptionActivity = descriptionActivity;
        this.descriptionActivityFinal = descriptionActivityFinal;
        this.dayActivity = dayActivity;
        this.monthActivity = monthActivity;
        this.isFinish = isFinish;
        this.imageActivity = imageActivity;
    }

    public Integer getIdActivity() {
        return idActivity;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public String getDescriptionActivity() {
        return descriptionActivity;
    }

    public String getDescriptionActivityFinal() {
        return descriptionActivityFinal;
    }

    public Integer getDayActivity() {
        return dayActivity;
    }

    public Integer getMonthActivity() {
        return monthActivity;
    }



    public Boolean isFinish() {
        return isFinish;
    }

    public String getImageActivity() {
        return imageActivity;
    }

    public void setIdActivity(Integer idActivity) {
        this.idActivity = idActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public void setDescriptionActivity(String descriptionActivity) {
        this.descriptionActivity = descriptionActivity;
    }

    public void setDescriptionActivityFinal(String descriptionActivityFinal) {
        this.descriptionActivityFinal = descriptionActivityFinal;
    }

    public void setDayActivity(Integer dayActivity) {
        this.dayActivity = dayActivity;
    }

    public void setMonthActivity(Integer monthActivity) {
        this.monthActivity = monthActivity;
    }


    public void setFinish(Boolean finish) {
        isFinish = finish;
    }

    public void setImageActivity(String imageActivity) {
        this.imageActivity = imageActivity;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "idActivity=" + idActivity +
                ", nameActivity='" + nameActivity + '\'' +
                ", descriptionActivity='" + descriptionActivity + '\'' +
                ", descriptionActivityFinal='" + descriptionActivityFinal + '\'' +
                ", dayActivity=" + dayActivity +
                ", monthActivity=" + monthActivity +
                ", isFinish=" + isFinish +
                ", imageActivity='" + imageActivity + '\'' +
                '}';
    }
}
