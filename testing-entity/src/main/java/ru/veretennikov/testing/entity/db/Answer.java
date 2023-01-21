package ru.veretennikov.testing.entity.db;

import jakarta.persistence.*;
import lombok.Data;
import ru.veretennikov.testing.entity.meta.DbMeta;

@Data
@Entity
@Table(schema = DbMeta.schema, name = DbMeta.answer.name)
public class Answer {

    @Id
    @Column(name = DbMeta.answer.fld.id)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = DbMeta.answer.fld.question_id)
    private Question question;

    @Column(name = DbMeta.answer.fld.left_part)
    private String leftPart;

    @Column(name = DbMeta.answer.fld.description)
    private String description;

    @Column(name = DbMeta.answer.fld.correct)
    private boolean correct;

    @Column(name = DbMeta.answer.fld.order_number)
    private Integer orderNumber;

}
