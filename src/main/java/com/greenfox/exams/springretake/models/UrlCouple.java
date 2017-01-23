package com.greenfox.exams.springretake.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Viktor on 2017.01.23..
 */
@Entity
@Table(name="html_couple")
@Getter
@Setter
@NoArgsConstructor
public class UrlCouple {
    @Id
    @GeneratedValue
    private long id;
    private String originalUrlAddress;
    private String sixLongRandomString;

}