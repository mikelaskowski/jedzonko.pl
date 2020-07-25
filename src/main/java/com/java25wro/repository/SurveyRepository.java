package com.java25wro.repository;
import com.java25wro.model.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {
    Survey save(Survey survey);
    
    List <Survey> findAll();
    
    List<Object> findById(long surveyId);

    void delete(Survey surveyById);
}
