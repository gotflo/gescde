package com.mycompany.projectmanager.service;

import com.mycompany.projectmanager.entities.Activity;
import com.mycompany.projectmanager.repo.ActivityRepo;
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
public class ActivityService implements ActivityRepo {

    @Autowired
    private final ActivityRepo activityRepo;

    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }


    @Override
    public List<Activity> findActivityByMonth() {
        return activityRepo.findActivityByMonth();
    }

    @Override
    public List<Activity> findActivityByNameActivity() {
        return activityRepo.findActivityByNameActivity();
    }

    @Override
    public List<Activity> findActivityByIsFinishTrue() {
        return activityRepo.findActivityByIsFinishTrue();
    }

    @Override
    public List<Activity> findActivityByIsFinishFalse() {
        return activityRepo.findActivityByIsFinishFalse();
    }

    @Override
    public Long ActivityFinishSize() {
        return activityRepo.ActivityFinishSize();
    }

    @Override
    public Long ActivityNoFinishSize() {
        return activityRepo.ActivityNoFinishSize();
    }

    @Override
    public Activity findActivityByMonthActivity(Integer monthActivity) {
        return activityRepo.findActivityByMonthActivity(monthActivity);
    }

    @Override
    public long count() {
        return activityRepo.count();
    }

    @Override
    public Optional<Activity> findById(Integer idActivity) {
        return activityRepo.findById(idActivity);
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Activity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Activity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Activity save(Activity activity) {
        return activityRepo.save(activity);
    }


    @Override
    public List<Activity> findAll() {
        return null;
    }

    @Override
    public List<Activity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Activity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Activity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public <S extends Activity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }



    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Activity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Activity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Activity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Activity getOne(Integer integer) {
        return null;
    }

    @Override
    public Activity getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Activity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Activity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Activity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Activity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Activity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Activity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Activity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
