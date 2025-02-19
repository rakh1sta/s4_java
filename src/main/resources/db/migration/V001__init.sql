CREATE TABLE student
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT FALSE
);

CREATE TABLE course
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    active   BOOLEAN DEFAULT FALSE,
    start_at TIMESTAMP    NULL,
    end_at   TIMESTAMP    NULL
);

CREATE TABLE department
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE discipline
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
ALTER TABLE student
    ADD COLUMN department_id BIGINT,
    ADD CONSTRAINT fk_student_department FOREIGN KEY (department_id) REFERENCES department (id);

CREATE TABLE discipline_course
(
    course_id     BIGINT NOT NULL,
    discipline_id BIGINT NOT NULL,
    grading       INTEGER DEFAULT 0,
    PRIMARY KEY (course_id, discipline_id),
    CONSTRAINT fk_discipline_course_course FOREIGN KEY (course_id) REFERENCES course (id),
    CONSTRAINT fk_discipline_course_discipline FOREIGN KEY (discipline_id) REFERENCES discipline (id)
);
CREATE TABLE grade
(
    student_id    BIGINT NOT NULL,
    discipline_id BIGINT NOT NULL,
    value         INT CHECK (value BETWEEN 0 AND 100),
    PRIMARY KEY (student_id, discipline_id),
    CONSTRAINT fk_grade_student FOREIGN KEY (student_id) REFERENCES student (id),
    CONSTRAINT fk_grade_discipline FOREIGN KEY (discipline_id) REFERENCES discipline (id)
);
