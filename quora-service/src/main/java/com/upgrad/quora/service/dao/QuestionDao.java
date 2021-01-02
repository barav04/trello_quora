package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public QuestionEntity createQuestion(QuestionEntity questionEntity){
        entityManager.persist(questionEntity);
        return questionEntity;
    }

    public List<QuestionEntity> getAllQuestions(){
        return entityManager.createNamedQuery("getAllQuestions", QuestionEntity.class).getResultList();
    }

    /*
    public QuestionEntity getQuestionByUuid(final String uuid) {
        try {
            return entityManager.createNamedQuery("questionEntityByUuid", QuestionEntity.class).setParameter("uuid",uuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public QuestionEntity editQuestionContent(final QuestionEntity questionEntity) {
        return entityManager.merge(questionEntity);
    }

    public QuestionEntity deleteQuestion(QuestionEntity questionEntity) {
        entityManager.remove(questionEntity);
        return questionEntity;
    }

    public List<QuestionEntity> getAllQuestionsByUser(UserEntity user){
        try {
            return entityManager.createNamedQuery("questionListByUuid", QuestionEntity.class).setParameter("user",user).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    */
}
