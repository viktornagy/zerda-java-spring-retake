package com.greenfox.exams.springretake.controllers;

import com.greenfox.exams.springretake.models.UrlCouple;
import com.greenfox.exams.springretake.services.UrlCoupleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Viktor on 2017.01.23..
 */
@Controller
public class SpringRetakeExamController {

        @Autowired
        UrlCoupleService urlCoupleService;

        @GetMapping("")
        public String displayForm(UrlCouple urlCouple) {
            return "index";
        }

        @PostMapping("")
        public String saveHtmlAddresses(UrlCouple urlCouple) {
                urlCoupleService.makeFields();
                urlCoupleService.saveUrlCouple(urlCouple);
                return "redirect:/showr";
            }

        @RequestMapping("/showr")
        public String listHtmlAddresses(Model model) {
            model.addAttribute("urlcouple", urlCoupleService.list());
            return "show";
        }
    }
