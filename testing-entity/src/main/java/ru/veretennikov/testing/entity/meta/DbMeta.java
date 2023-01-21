package ru.veretennikov.testing.entity.meta;

public class DbMeta {

    private DbMeta() {}

    public static final String schema = "testing";

    /**
     * Таблица тестов
     */
    public static final class test {
        public static final String name = "test";

        //region Атрибуты
        public static final class fld {
            /**
             * Идентификатор записи
             */
            public static final String id = "id";
            /**
             * Наименование теста. Например "тест по информатике за 9 класс"
             */
            public static final String name = "name";
            /**
             * Автор теста
             */
            public static final String author = "author";
            /**
             * Дата загрузки теста в систему
             */
            public static final String upload_date = "upload_date";
        }
        //endregion
    }

    /**
     * Таблица вопросов
     */
    public static final class question {
        public static final String name = "question";

        //region Атрибуты
        public static final class fld {
            /**
             * Идентификатор записи
             */
            public static final String id = "id";
            /**
             * Идентификатор теста
             */
            public static final String test_id = "test_id";
            /**
             * Порядковый номер вопроса
             * ведь некоторые тесты нужно подавать всегда в одном и том же порядке
             * поэтому при загрузке если не указаны номера для вопросов (ни для одного), то генерировать автоматически в том порядке, в котором они загружаются
             */
            public static final String order_number = "order_number";
            /**
             * Вес вопроса. От 0 до 100. По умолчанию 1
             */
            public static final String weight = "weight";
            /**
             * Текст вопроса
             */
            public static final String description = "description";
            /**
             * Тип вопроса
             */
            public static final String question_type = "question_type";
        }
        //endregion
    }

    /**
     * Таблица вариантов ответов на вопросы
     */
    public static final class answer {
        public static final String name = "answer";

        //region Атрибуты
        public static final class fld {
            /**
             * Идентификатор записи
             */
            public static final String id = "id";
            /**
             * Идентификатор вопроса
             */
            public static final String question_id = "question_id";
            /**
             * Левая часть ответа в случае типа вопроса - сопоставление
             */
            public static final String left_part = "left_part";
            /**
             * Текст ответа. (правая часть сопоставления в случае типа вопроса - сопоставление)
             */
            public static final String description = "description";
            /**
             * Признак правильности ответа
             */
            public static final String correct = "correct";
            /**
             * Порядковый номер вопроса
             */
            public static final String order_number = "order_number";
        }
        //endregion
    }

    /**
     * Таблица пройденных тестов пользователей
     */
    public static final class passed_test {
        public static final String name = "passed_test";

        //region Атрибуты
        public static final class fld {
            /**
             * Идентификатор записи
             */
            public static final String id = "id";
            /**
             * Идентификатор теста
             */
            public static final String test_id = "test_id";
            /**
             * Имя испытуемого
             */
            public static final String user = "user";
            /**
             * Дата начала прохождения теста
             */
            public static final String date_start = "date_start";
            /**
             * Дата окончания прохождения теста
             */
            public static final String date_end = "date_end";
            /**
             * Всего вопросов
             */
            public static final String total_question = "total_question";
            /**
             * Отвечено правильно
             */
            public static final String num_correct = "num_correct";
            /**
             * Максимально возможный вес
             */
            public static final String total_weight = "total_weight";
            /**
             * Набранный вес
             */
            public static final String gained_weight = "gained_weight";
        }
        //endregion
    }

    /**
     * Таблица пользовательских ответов
     */
    public static final class user_answer {
        public static final String name = "user_answer";

        //region Атрибуты
        public static final class fld {
            /**
             * Идентификатор записи
             */
            public static final String id = "id";
            /**
             * Идентификатор пройденного теста
             */
            public static final String passed_test_id = "passed_test_id";
            /**
             * Идентификатор вопроса
             */
            public static final String question_id = "question_id";
             /**
             * Идентификатор ответа
             */
            public static final String answer_id = "answer_id";
            /**
             * Левая часть ответа в случае типа вопроса - сопоставление
             */
            public static final String left_part = "left_part";
            /**
             * Текст ответа. (правая часть сопоставления в случае типа вопроса - сопоставление)
             */
            public static final String description = "description";
        }
        //endregion
    }

}
