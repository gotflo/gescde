package com.mycompany.projectmanager.repo;

import com.mycompany.projectmanager.entities.Child;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public interface ChildRepo extends JpaRepository<Child, String> {

//    Date date = new Date();
//    SimpleDateFormat s = new SimpleDateFormat("MM");
//    int mois = Integer.parseInt((s.format(date)));


//    (s.format(date))
    @Query(value = "SELECT * FROM child ORDER BY num_benef ASC", nativeQuery = true)
    public List<Child> findChildByNumeroBeneficiaire();

    @Query(value = "SELECT * FROM child ORDER BY last_name_child ASC", nativeQuery = true)
    public List<Child> findChildByLastNameChild();

    @Query(value = "select * from child WHERE gender = 'M'", nativeQuery = true)
    public List<Child> findChildByGenderM();

    @Query(value = "select * from child WHERE status = 'Sponsorisé'", nativeQuery = true)
    public List<Child> findChildBySponsore();


    @Query(value = "select * from child WHERE status = 'Non sponsorisé'", nativeQuery = true)
    public List<Child> findChildByNoSponsor();


    @Query(value = "select * from child WHERE mois_naiss = ?", nativeQuery = true)
    public List<Child> findChildByAnniv(Integer mois);

    @Query(value = "select * from child WHERE gender = 'F'", nativeQuery = true)
    public List<Child> findChildByGenderF();


    @Query(value = "SELECT COUNT(*) FROM child WHERE mois_naiss = ?", nativeQuery = true)
    public Long ChildAnnivSize(Integer mois);

    @Query(value = "SELECT COUNT(*) FROM child WHERE gender = 'M'", nativeQuery = true)
    public Long ChildMSize();

    @Query(value = "SELECT COUNT(*) FROM child WHERE gender = 'F'", nativeQuery = true)
    public Long ChildFSize();

    @Query(value = "SELECT COUNT(*) FROM child WHERE status = 'Sponsorisé'", nativeQuery = true)
    public Long ChildSponsorSize();

    @Query(value = "SELECT COUNT(*) FROM child WHERE status = 'Non sponsorisé'", nativeQuery = true)
    public Long ChildNoSponsorSize();

    @Query(value = "SELECT * FROM child WHERE num_benef = ?", nativeQuery = true)
    Child findChildByNumBnf(String numeroBeneficiaire);


}
