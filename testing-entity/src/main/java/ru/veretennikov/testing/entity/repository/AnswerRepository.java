package ru.veretennikov.testing.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.veretennikov.testing.entity.db.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {}