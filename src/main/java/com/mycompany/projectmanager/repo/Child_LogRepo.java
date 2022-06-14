package com.mycompany.projectmanager.repo;


import com.mycompany.projectmanager.entities.Child_Log;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootApplication
public interface Child_LogRepo extends JpaRepository<Child_Log, String> {

    @Query(value = "SELECT * FROM child_log ORDER BY num_benef_log ASC", nativeQuery = true)
    public List<Child_Log> findChildLogByNumeroBeneficiaire();

    @Query(value = "SELECT * FROM child_Log ORDER BY last_name_child_log ASC", nativeQuery = true)
    public List<Child_Log> findChildLogByLastNameChild();

    @Query(value = "select * from child_Log WHERE gender_log = 'M'", nativeQuery = true)
    public List<Child_Log> findChildLogByGenderM();

    @Query(value = "select * from child_Log WHERE status_log = 'Sponsorisé'", nativeQuery = true)
    public List<Child_Log> findChildLogBySponsore();

    @Query(value = "select * from child_Log WHERE status_log = 'Non sponsorisé'", nativeQuery = true)
    public List<Child_Log> findChildLogByNoSponsor();

    @Query(value = "select * from child_Log WHERE gender_log = 'F'", nativeQuery = true)
    public List<Child_Log> findChildLogByGenderF();

    @Query(value = "SELECT COUNT(*) FROM child_Log WHERE gender_log = 'M'", nativeQuery = true)
    public Long ChildLogMSize();

    @Query(value = "SELECT COUNT(*) FROM child_Log WHERE gender_log = 'F'", nativeQuery = true)
    public Long ChildLogFSize();

    @Query(value = "SELECT COUNT(*) FROM child_Log WHERE status_log = 'Sponsorisé'", nativeQuery = true)
    public Long ChildLogSponsorSize();

    @Query(value = "SELECT COUNT(*) FROM child_Log WHERE status_log = 'Non sponsorisé'", nativeQuery = true)
    public Long ChildLogNoSponsorSize();

    @Query(value = "SELECT * FROM child_Log WHERE num_benef_log = ?", nativeQuery = true)
    Child_Log findChildLogByNumBnf(String numeroBeneficiaireLog);
}
