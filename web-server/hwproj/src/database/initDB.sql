DROP SCHEMA IF EXISTS hwproj CASCADE;
CREATE SCHEMA hwproj;

CREATE TABLE hwproj.homeworks(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR(20) NOT NULL,
    task_description TEXT        NOT NULL,
    publication_time TIMESTAMP   NOT NULL,
    deadline         TIMESTAMP
);

CREATE TABLE hwproj.hw_submission(
    id              SERIAL PRIMARY KEY,
    hw_id           INT REFERENCES hwproj.homeworks (id),
    solution        TEXT      NOT NULL,
    created_at      TIMESTAMP NOT NULL,
    mark            INT,
    comment         TEXT,
    checker_verdict TEXT
);

INSERT into hwproj.homeworks(title, task_description, publication_time, deadline)
values ('kek', 'alall', '2021-01-01', '2021-02-02');