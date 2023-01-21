package ru.veretennikov.testing.entity.db;

import jakarta.persistence.*;
import lombok.Data;
import ru.veretennikov.testing.entity.meta.DbMeta;

@Data
@Entity
@Table(schema = DbMeta.schema, name = DbMeta.user_answer.name)
public class UserAnswer {

    @Id
    @Column(name = DbMeta.user_answer.fld.id)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    один пройденный тест содержит некоторое количество пользовательских ответов
//    но обратное неверно, т.к. каждый пользовательский ответ относится только к одному конкретному пройденному тесту
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DbMeta.user_answer.fld.passed_test_id)
    private PassedTest passedTest;

//    на один вопрос может быть получено некоторое количество пользовательских ответов
//    но обратное неверно, т.к. каждый пользовательский ответ относится только к одному конкретному вопросу
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DbMeta.user_answer.fld.question_id)
    private Question question;

//    для одного пользовательского ответа может быть указан любой вариант ответа
//    а также для нескольких пользовательских ответов может быть указан один и тот же вариант ответа
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DbMeta.user_answer.fld.answer_id)
    private Answer answer;

    @Column(name = DbMeta.user_answer.fld.left_part)
    private String leftPart;

    @Column(name = DbMeta.user_answer.fld.description)
    private String description;

}
