package com.greenfox.exams.springretake.services;

import com.greenfox.exams.springretake.models.UrlCouple;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Viktor on 2017.01.23..
 */
public interface UrlCoupleRepository extends CrudRepository<UrlCouple, String> {

    UrlCouple findOneBySixLongRandomString(String sixLongRandomString);

}