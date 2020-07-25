package com.java25wro.controller;

import com.java25wro.service.SurveyServiceInterface;
import com.java25wro.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {


    private SurveyServiceInterface surveyServiceInterface;

    @Autowired
    public SurveyController(SurveyServiceInterface surveyServiceInterface){
        this.surveyServiceInterface = surveyServiceInterface;
    }

    @GetMapping("/all")
    public List<Survey>findAll(){
        return surveyServiceInterface.getAllSurvey();
    }

    @GetMapping(value = "/{surveyid}")
    public Survey findSurveyBySurveyId(@PathVariable Long surveyId){
        return surveyServiceInterface.getSurveyById(surveyId);
    }

    @PostMapping(value = "")
    public Survey createSurvey(@RequestBody Survey newSurvey){
        surveyServiceInterface.createSurvey(newSurvey);
        return newSurvey;
    }

    @DeleteMapping(value = "delete/{surveyid}")
    public String deleteSurvey(@PathVariable Long surveyId){
        surveyServiceInterface.deleteSurvey(surveyId);
        return "";
    }
}

