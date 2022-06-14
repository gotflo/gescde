package com.mycompany.projectmanager.service;

import com.mycompany.projectmanager.entities.Child;
import com.mycompany.projectmanager.repo.ChildRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ChildService implements ChildRepo {
   private final ChildRepo childRepo;

    @Autowired
    public ChildService(ChildRepo childRepo) {
        this.childRepo = childRepo;
    }

    @Override
    public List<Child> findAll() {
        return childRepo.findAll();
    }

    @Override
    public List<Child> findChildByNumeroBeneficiaire() {
     return childRepo.findChildByNumeroBeneficiaire();
    }

    @Override
    public List<Child> findChildByLastNameChild() {
    return childRepo.findChildByLastNameChild();
    }

    @Override
    public List<Child> findChildByGenderM() {
     return childRepo.findChildByGenderM();
    }

    @Override
    public List<Child> findChildBySponsore() {
        return childRepo.findChildBySponsore();
    }

    @Override
    public List<Child> findChildByNoSponsor() {
        return childRepo.findChildByNoSponsor();
    }

    @Override
    public List<Child> findChildByAnniv(Integer mois) {
        return childRepo.findChildByAnniv(mois);
    }

    @Override
    public List<Child> findChildByGenderF() {
    return childRepo.findChildByGenderF();
    }

    @Override
    public Long ChildAnnivSize(Integer mois) {
        return childRepo.ChildAnnivSize(mois);
    }

    @Override
    public Long ChildMSize() {
        return childRepo.ChildMSize();
    }

    @Override
    public Long ChildFSize() {
        return childRepo.ChildFSize();
    }

    @Override
    public Long ChildSponsorSize() {
        return childRepo.ChildSponsorSize();
    }

    @Override
    public Long ChildNoSponsorSize() {
        return childRepo.ChildNoSponsorSize();
    }

 @Override
    public long count() {
        return childRepo.count();
//        return findChildByGenderF().size();
    }

    @Override
    public Child save(Child child) {
        return childRepo.save(child);
    }

    @Override
    public Child findChildByNumBnf(String numeroBeneficiaire) {
      return childRepo.findChildByNumBnf(numeroBeneficiaire);
    }
    @Override
    public List<Child> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Child> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Child> findAllById(Iterable<String> strings) {
        return null;
    }


    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Child entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Child> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Child> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Child> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Child> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Child> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Child> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Child getOne(String s) {
        return null;
    }

    @Override
    public Child getById(String s) {
        return null;
    }

    @Override
    public <S extends Child> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Child> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Child> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Child> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Child> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Child> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Child, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }


}
