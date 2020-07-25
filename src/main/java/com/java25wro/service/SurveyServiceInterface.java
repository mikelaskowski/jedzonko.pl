package com.java25wro.service;

import com.java25wro.model.Survey;

import java.util.List;

public interface SurveyServiceInterface {
    Survey createSurvey (Survey survey);

    Survey updateSurvey (Survey survey);

    List<Survey> getAllSurvey();

    Survey getSurveyById(long surveyId);

    void deleteSurvey(long id);
}
