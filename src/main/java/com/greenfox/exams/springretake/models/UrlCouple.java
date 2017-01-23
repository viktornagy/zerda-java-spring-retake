package com.greenfox.exams.springretake.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

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

    private Random rng = new Random();
    private String characters = "0123456789abcdefghijklmnopqrstuvwxyz";
    private int length = 6;

    public void generateSixLongRandomString() {
        char[] text = new char[this.length];
        for (int i = 0; i < this.length; i++) {
            text[i] = this.characters.charAt(this.rng.nextInt(this.characters.length()));
        }
        this.sixLongRandomString = new String(text);
    }

    public void completeUrlIfNeeded() {
        StringBuilder sb=new StringBuilder(originalUrlAddress);
        if (!(originalUrlAddress.contains("http") || originalUrlAddress.contains("https"))) {
                this.originalUrlAddress=(sb.append("http")).toString();
        }
    }



}