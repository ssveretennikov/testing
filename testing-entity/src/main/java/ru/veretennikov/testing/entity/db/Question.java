package ru.veretennikov.testing.entity.db;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.veretennikov.testing.entity.db.enums.QuestionType;
import ru.veretennikov.testing.entity.meta.DbMeta;

import java.util.List;

@Data
@Entity
@Table(schema = DbMeta.schema, name = DbMeta.question.name)
public class Question {

    @Id
    @Column(name = DbMeta.question.fld.id)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DbMeta.question.fld.test_id)
    private Test test;

    @Column(name = DbMeta.question.fld.order_number)
    private Integer orderNumber;

    @Column(name = DbMeta.question.fld.weight)
    private Integer weight;

    @Column(name = DbMeta.question.fld.description)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = DbMeta.question.fld.question_type)
    private QuestionType type;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

}
