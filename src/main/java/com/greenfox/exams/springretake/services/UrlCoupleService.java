package com.greenfox.exams.springretake.services;

import com.greenfox.exams.springretake.models.UrlCouple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Viktor on 2017.01.23..
 */
@Service
public class UrlCoupleService {

    @Autowired
    UrlCoupleRepository repository;

    @Autowired
    UrlCouple urlCouple;

    public void makeFields() {
        urlCouple.completeUrlIfNeeded();
        urlCouple.generateSixLongRandomString();
    }

    public Iterable<UrlCouple> list() {
        return repository.findAll();
    }

    public void saveUrlCouple(UrlCouple urlCouple) {
        repository.save(urlCouple);
    }
}