package com.greenfox.exams.springretake.controllers;

import com.greenfox.exams.springretake.models.UrlCouple;
import com.greenfox.exams.springretake.services.UrlCoupleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        public String saveHtmlAddresses(UrlCouple urlCouple, Model model) {
               urlCoupleService.makeFields(urlCouple);
                urlCoupleService.saveUrlCouple(urlCouple);
                   model.addAttribute("urlCoupleTwo", urlCouple);
            return "show";
            }

        @RequestMapping("/showr")
        public String listHtmlAddresses(Model model) {
            model.addAttribute("urlcouple", urlCoupleService.list());
            return "show";
        }

    @RequestMapping("/shorten/{someID}")
    public @ResponseBody
    String getAttr(@PathVariable(value="someID") String shorturl, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {

        UrlCouple act = urlCoupleService.findRealUrl(shorturl);

        if (act != null) {
            try
            {
                httpServletResponse.sendRedirect(act.getOriginalUrlAddress());
            }
            catch(Exception e)
            {

            }
            String redirectUrl="redirect:"+act.getOriginalUrlAddress();
            return redirectUrl;
        }
        else {
            httpServletResponse.sendRedirect("http://localhost:8080");
            return "http://localhost:8080";
        }
    }
}
