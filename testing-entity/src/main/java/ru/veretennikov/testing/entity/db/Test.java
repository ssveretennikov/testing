package ru.veretennikov.testing.entity.db;

import jakarta.persistence.*;
import lombok.Data;
import ru.veretennikov.testing.entity.meta.DbMeta;

import java.time.LocalDate;

@Data
@Entity
@Table(schema = DbMeta.schema, name = DbMeta.test.name)
public class Test {

    @Id
    @Column(name = DbMeta.test.fld.id)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = DbMeta.test.fld.name)
    private String name;

    @Column(name = DbMeta.test.fld.author)
    private String author;

    @Column(name = DbMeta.test.fld.upload_date)
    private LocalDate uploadDate;

//    + возможна какая-то условно-постоянная или переменная информация
}
