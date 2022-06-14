package com.mycompany.projectmanager.service;

import com.mycompany.projectmanager.entities.Child_Log;
import com.mycompany.projectmanager.repo.Child_LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class Child_LogService implements Child_LogRepo {


    private final Child_LogRepo childLogRepo;

    @Autowired
    public Child_LogService(Child_LogRepo childLogRepo) {
        this.childLogRepo = childLogRepo;
    }


    @Override
    public List<Child_Log> findChildLogByNumeroBeneficiaire() {
        return childLogRepo.findChildLogByNumeroBeneficiaire();
    }

    @Override
    public List<Child_Log> findChildLogByLastNameChild() {
        return childLogRepo.findChildLogByLastNameChild();
    }

    @Override
    public List<Child_Log> findChildLogByGenderM() {
        return childLogRepo.findChildLogByGenderM();
    }

    @Override
    public List<Child_Log> findChildLogBySponsore() {
        return childLogRepo.findChildLogBySponsore();
    }

    @Override
    public List<Child_Log> findChildLogByNoSponsor() {
        return childLogRepo.findChildLogByNoSponsor();
    }

    @Override
    public List<Child_Log> findChildLogByGenderF() {
        return childLogRepo.findChildLogByGenderF();
    }

    @Override
    public Long ChildLogMSize() {
        return childLogRepo.ChildLogMSize();
    }

    @Override
    public Long ChildLogFSize() {
        return childLogRepo.ChildLogFSize();
    }

    @Override
    public Long ChildLogSponsorSize() {
        return childLogRepo.ChildLogSponsorSize();
    }

    @Override
    public Long ChildLogNoSponsorSize() {
        return childLogRepo.ChildLogNoSponsorSize();
    }

    @Override
    public Child_Log findChildLogByNumBnf(String numeroBeneficiaireLog) {
        return childLogRepo.findChildLogByNumBnf(numeroBeneficiaireLog);
    }
    @Override
    public List<Child_Log> findAll() {
        return null;
    }

    @Override
    public List<Child_Log> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Child_Log> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Child_Log> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return childLogRepo.count();
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Child_Log entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Child_Log> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Child_Log save(Child_Log chlidLog) {
        return childLogRepo.save(chlidLog);
    }

    @Override
    public <S extends Child_Log> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Child_Log> findById(String s) {
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
    public <S extends Child_Log> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Child_Log> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Child_Log> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Child_Log getOne(String s) {
        return null;
    }

    @Override
    public Child_Log getById(String s) {
        return null;
    }

    @Override
    public <S extends Child_Log> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Child_Log> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Child_Log> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Child_Log> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Child_Log> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Child_Log> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Child_Log, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }


}
