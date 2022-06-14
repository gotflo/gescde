package com.mycompany.projectmanager.repo;


import com.mycompany.projectmanager.entities.Activity;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootApplication
public interface ActivityRepo extends JpaRepository<Activity, Integer> {

    @Query(value = "SELECT * FROM activity ORDER BY month_activity ASC", nativeQuery = true)
    public List<Activity> findActivityByMonth();

    @Query(value = "SELECT * FROM activity ORDER BY name_activity ASC", nativeQuery = true)
    public List<Activity> findActivityByNameActivity();

    @Query(value = "SELECT * FROM activity WHERE is_finish = '1'", nativeQuery = true)
    public List<Activity> findActivityByIsFinishTrue();

    @Query(value = "SELECT * FROM activity WHERE is_finish = '0'", nativeQuery = true)
    public List<Activity> findActivityByIsFinishFalse();

    @Query(value = "SELECT COUNT(*) FROM activity WHERE is_finish = '1'", nativeQuery = true)
    public Long ActivityFinishSize();

    @Query(value = "SELECT COUNT(*) FROM activity WHERE is_finish = '0'", nativeQuery = true)
    public Long ActivityNoFinishSize();

    @Query(value = "SELECT * FROM activity WHERE month_activity = ?", nativeQuery = true)
    Activity findActivityByMonthActivity(Integer monthActivity);
}
