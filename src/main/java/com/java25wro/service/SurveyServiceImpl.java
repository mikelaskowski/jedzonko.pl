package com.java25wro.service;

import com.java25wro.model.Survey;
import com.java25wro.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyServiceInterface {

    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository){
        this.surveyRepository = surveyRepository;
    }

    @Transactional
    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Transactional
    @Override
    public Survey updateSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Transactional
    @Override
    public List<Survey> getAllSurvey() {
        List<Survey> list = new ArrayList<>();
        surveyRepository.findAll().forEach(e->list.add((Survey) e));
        return list;
    }

    @Transactional
    @Override
    public Survey getSurveyById(long surveyId) {
        Survey survey = (Survey) surveyRepository.findById(surveyId);
        return survey;
    }
    @Transactional
    @Override
    public void deleteSurvey(long id) {
        surveyRepository.delete(getSurveyById(id));
    }
}
