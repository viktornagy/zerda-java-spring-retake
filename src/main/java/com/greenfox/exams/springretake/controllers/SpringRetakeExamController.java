package com.greenfox.exams.springretake.controllers;

import com.greenfox.exams.springretake.models.UrlCouple;
import com.greenfox.exams.springretake.services.UrlCoupleRepository;
import com.greenfox.exams.springretake.services.UrlCoupleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Viktor on 2017.01.23..
 */
@Controller
public class SpringRetakeExamController {

        UrlCoupleService urlCoupleService;
        UrlCoupleRepository urlCoupleRepository;

    @Autowired
    public SpringRetakeExamController(UrlCoupleService urlCoupleService, UrlCoupleRepository urlCoupleRepository) {
        this.urlCoupleService = urlCoupleService;
        this.urlCoupleRepository = urlCoupleRepository;
    }

    @GetMapping("")
        public String displayForm(UrlCouple urlCouple) {
            return "index";
        }

        @PostMapping("")
        public String saveHtmlAddresses(UrlCouple urlCouple, Model model) {
               urlCoupleService.makeFields(urlCouple);
                urlCoupleService.saveUrlCouple(urlCouple);
                   model.addAttribute("urlCoupleTwo", urlCouple);
            return "show";
            }

    @RequestMapping("/shorten/{someID}")
    public String getAttr(@PathVariable(value="someID") String someID) {

        UrlCouple act = urlCoupleRepository.findOneBySixLongRandomString(someID);
        if (act != null) {

            String redirectUrl="redirect:"+act.getOriginalUrlAddress();
            return redirectUrl;
        }
        else {

            return "index";
        }
    }
}





