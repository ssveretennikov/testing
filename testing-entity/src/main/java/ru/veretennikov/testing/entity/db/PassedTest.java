package ru.veretennikov.testing.entity.db;

import jakarta.persistence.*;
import lombok.Data;
import ru.veretennikov.testing.entity.meta.DbMeta;

import java.time.LocalDateTime;

@Data
@Entity
@Table(schema = DbMeta.schema, name = DbMeta.passed_test.name)
public class PassedTest {

    @Id
    @Column(name = DbMeta.passed_test.fld.id)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    один тест может быть пройден некоторое количество раз
//    но обратное неверно, т.к. каждый пройденный тест относится только к одному конкретному тесту
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DbMeta.passed_test.fld.test_id)
    private Test test;

    @Column(name = DbMeta.passed_test.fld.user_name)
    private String userName;

    @Column(name = DbMeta.passed_test.fld.date_start)
    private LocalDateTime dateStart;

    @Column(name = DbMeta.passed_test.fld.date_end)
    private LocalDateTime dateEnd;

    @Column(name = DbMeta.passed_test.fld.total_question)
    private int totalQuestion;

    @Column(name = DbMeta.passed_test.fld.num_correct)
    private int numCorrect;

    @Column(name = DbMeta.passed_test.fld.total_weight)
    private int totalWeight;

    @Column(name = DbMeta.passed_test.fld.gained_weight)
    private int gainedWeight;

}
