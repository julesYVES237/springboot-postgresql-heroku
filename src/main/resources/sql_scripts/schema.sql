--DROP TABLE IF EXISTS task;
--DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
    id SERIAL  PRIMARY KEY,
    first_name varchar(255)    NOT NULL,
    last_name  varchar(255)    NOT NULL,
    email      varchar(255)    NOT NULL,
    password   varchar(255)    NOT NULL,
    salary      integer        NOT NULL,
    occupation       varchar(255)    NOT NULL,
    emp_auth_level  varchar(255)    NOT NULL,
    current_month_working_hours       integer   NOT NULL DEFAULT 168,
    remaining_day_offs              integer NOT NULL DEFAULT 26
);

CREATE TABLE task
(
    id SERIAL  PRIMARY KEY,
    description varchar(255)    NOT NULL,
    status varchar(255)    NOT NULL,
    start_date date   NOT NULL,
    end_date date  NOT NULL,
    employee_id integer references employee(id)
);

--Insert into employee (first_name,
--                      last_name,
--                      email,
--                      password,
--                      salary,
--                      occupation,
--                      emp_auth_level,
--                      current_month_working_hours,
--                      remaining_day_offs)
--values ('Janina',
--        'Nowak',
--        'janinanowak@example.com',
--        '$2y$12$URV906A58Zv4MPb34EB5NedrbgIJCER6atE.r0YUoykn59oNTg3S.',
--        7500,
--        'managing board',
--        'ROLE_ADMIN',
--        168,
--        22
--        );
--Insert into employee (first_name,
--                      last_name,
--                      email,
--                      password,
--                      salary,
--                      occupation,
--                      emp_auth_level,
--                      current_month_working_hours,
--                      remaining_day_offs)
--values ('Marek',
--        'Gladysz',
--        'marekgladysz@example.com',
--        '$2y$12$Z/qia1RjzRxIH1xT09Kppe6oMHXG4l8TLzXZVN.whgbOTUxjImKBS',
--        2000,
--        'cleaner',
--        'ROLE_USER',
--        155,
--        10);
--
--Insert into employee (first_name,
--                      last_name,
--                      email,
--                      password,
--                      salary,
--                      occupation,
--                      emp_auth_level,
--                      current_month_working_hours,
--                      remaining_day_offs)
--values ('Mieczyslaw',
--        'Nowak',
--        'mnowak@example.com',
--        '$2y$12$XVIXPvoAkFTRePcHPKyoTurUN3u7cfTFtMkjONDULU8S/Ebt.FwGS',
--        2700,
--        'graphic designer',
--        'ROLE_USER',
--        160,
--        13);
--
---- Ass1
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date,
--                 employee_id)
--values('Preapare new APP UI design',
--       'NEW',
--       '2020-09-05',
--       '2020-08-10',
--       3
--      );
----Ass2
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date,
--                 employee_id)
-- values('Clean the office floor',
--          'NEW',
--         '2020-08-28',
--         '2020-08-29',
--        2
--         );
----Ass3
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date,
--                 employee_id)
--values('Take out the rubbish',
--       'DONE',
--       '2020-09-01',
--       '2020-09-02',
--       2
--      );
--
--
---- Ass4
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date,
--                 employee_id)
--values('Preapare new APP UI ',
--       'DONE',
--       '2020-09-05',
--       '2020-08-10',
--       3
--      );
----Ass5
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date,
--                 employee_id)
--values('Clean the floor',
--       'NEW',
--       '2020-08-28',
--       '2020-08-29',
--       2
--      );
--
--
--
--
----UNASIGNED
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date)
--values('Order no 1 to be realized',
--       'NEW',
--       '2020-09-01',
--       '2020-09-02'
--      );
--
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date)
--values('Order no 2 to be sent',
--       'NEW',
--       '2020-09-03',
--       '2020-09-04'
--      );
--
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date)
--values('Order no 3 to be realized',
--       'NEW',
--       '2020-09-01',
--       '2020-09-02'
--      );
--
--INSERT INTO task(description,
--                 status,
--                 start_date,
--                 end_date)
--values('Order no 4 to be sent',
--       'NEW',
--       '2020-09-03',
--       '2020-09-04'
--      );
--
