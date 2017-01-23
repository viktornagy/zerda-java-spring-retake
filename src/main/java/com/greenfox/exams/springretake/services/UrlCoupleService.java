package com.greenfox.exams.springretake.services;

import com.greenfox.exams.springretake.models.UrlCouple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;


/**
 * Created by Viktor on 2017.01.23..
 */
@Service
public class UrlCoupleService {

    @Autowired
    UrlCoupleRepository repository;

    public void makeFields(UrlCouple urlcouple) {
        this.completeUrlIfNeeded(urlcouple);
        this.generateSixLongRandomString(urlcouple);

    }

    public Iterable<UrlCouple> list() {
        return repository.findAll();
    }

    public UrlCouple find(String sixLongRandomString) {
        return repository.findOne(sixLongRandomString);
    }

    public void saveUrlCouple(UrlCouple urlCouple) {
        repository.save(urlCouple);
    }

    public UrlCouple findRealUrl(String shortAddress){
        return repository.findOneBySixLongRandomString(shortAddress);
    }


    public void generateSixLongRandomString(UrlCouple urlCouple) {
        Random rng = new Random();
        String characters = "0123456789abcdefghijklmnopqrstuvwxyz";
        int stringLength = 6;

        char[] text = new char[stringLength];
        for (int i = 0; i < stringLength; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        urlCouple.setSixLongRandomString(new String(text));
    }
    public void completeUrlIfNeeded(UrlCouple urlCouple) {
        StringBuilder sb=new StringBuilder(urlCouple.getOriginalUrlAddress());
        if (!(urlCouple.getOriginalUrlAddress().contains("http") || urlCouple.getOriginalUrlAddress().contains("https"))) {
            urlCouple.setOriginalUrlAddress(("http://")+sb.toString());
        }
    }

}