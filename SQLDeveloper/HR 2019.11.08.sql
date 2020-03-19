CREATE TABLE comp(
                char_col CHAR(4),
                varchar2_col VARCHAR2(4)
                );
INSERT INTO comp VALUES ('AA', 'AA');
INSERT INTO comp VALUES ('AAAA', 'AAAA');

SELECT *
FROM comp
WHERE char_col = varchar2_col;

DESCRIBE employees;

SELECT hire_date, TO_CHAR(hire_date, 'YYYY-MM-DD') "날짜=>문자 형변환"
FROM employees;

SELECT *
FROM employees
WHERE hire_date <'2002/03/03';
--와
SELECT *
FROM employees
WHERE hire_date <TO_DATE('2002/03/03');
--의 비교 , 아래쪽 형식이 더 빠르다.

CREATE TABLE ex_date(
                            ex_id NUMBER(2),
                            start_date DATE DEFAULT SYSDATE
);

DESCRIBE ex_date;

INSERT INTO ex_date(ex_id) VALUES(1);
INSERT INTO ex_date(ex_id) VALUES(2);
INSERT INTO ex_date(ex_id) VALUES(3);

SELECT * FROM ex_date;

DROP TABLE comp;
DROP TABLE ex_date;

CREATE TABLE sample_product(
                            product_id NUMBER,
                            product_name VARCHAR2(20),
                            menu_date DATE
);

DESCRIBE sample_product;

DROP TABLE sample_product;

CREATE TABLE emp(
                    eno     NUMBER(3) CONSTRAINT emp_eno_pk PRIMARY KEY,
                    emp_name VARCHAR2(20)
);

DROP TABLE emp CASCADE CONSTRAINT;

CREATE TABLE emp(
                eno NUMBER(3),
                emp_name VARCHAR2(20),
                CONSTRAINT emp_eno_pk PRIMARY KEY (eno)
);;

DESCRIBE departments;

INSERT INTO departments(department_id, manager_id, location_id)
VALUES (400,200,1700);
--오류발생(NOT NULL 제약조건 충족 X)

CREATE TABLE emp1(
                eno NUMBER(3),
                emp_name VARCHAR2(20) CONSTRAINT emp1_ename_nn NOT NULL,
                email VARCHAR2(30) CONSTRAINT emp1_email_uk UNIQUE 
);

INSERT INTO emp1 VALUES (208,'Kang', 'KJS');
INSERT INTO emp1 VALUES (209, 'Kim', 'Kjs');
--오류발생(UNIQUE 제약조건 충족 X)

INSERT INTO emp1 VALUES (208,'Kang', 'KJS');
INSERT INTO emp1 VALUES (209, 'Kim', 'Kjs2');

SELECT *
FROM emp1;

CREATE TABLE emp(
                eno NUMBER(3),
                emp_name VARCHAR2(20),
                sal NUMBER(10),
                CONSTRAINT emp_sal_check check (sal>1000)
);

DESCRIBE emp;

INSERT INTO emp VALUES (200,'Kim', 1200);
INSERT INTO emp VALUES (208,'Kang', 800);
--오류 발생 CHECK 제약조건을 충족 X

INSERT INTO emp VALUES (200,'Kim', 1200);
INSERT INTO emp VALUES (208,'Kang', 1800);

SELECT *
FROM emp;

DROP TABLE emp;

CREATE TABLE members (
                member_id    NUMBER(2) CONSTRAINT mem_memid_pk PRIMARY KEY,
                first_name   VARCHAR2(50) CONSTRAINT mem_firna_nn NOT NULL,
                last_name    VARCHAR2(50) CONSTRAINT mem_lana_nn NOT NULL,
                gender   VARCHAR2(5) CONSTRAINT mem_gen_c CHECK (gender IN ('Man', 'Woman')),
                birth_day    DATE DEFAULT SYSDATE,
                email    VARCHAR2(200) CONSTRAINT mem_email_nn NOT NULL,
                CONSTRAINT mem_email_uni1 UNIQUE (email)
                );

DESCRIBE members;

CREATE TABLE dept(
                dno NUMBER(4) CONSTRAINT depr_dno_pk PRIMARY KEY,
                dname VARCHAR2(20)
                );
                
INSERT INTO dept VALUES(1,'first');
UPDATE dept SET dname='First' WHERE dno=1;
INSERT INTO dept VALUES(2,'second');
UPDATE dept SET dname='Second' WHERE dno=2;
SELECT * FROM dept;

CREATE TABLE emp(
                eno NUMBER(4),
                emp_name VARCHAR2(20),
                sal NUMBER(10),
                dno NUMBER(4),
                CONSTRAINT emo_eno_pk PRIMARY KEY (eno),
                CONSTRAINT emp_dno_fk FOREIGN KEY (dno) REFERENCES dept (dno)
                );
                
INSERT ALL
INTO dept VALUES (10, 'Test1')
INTO dept VALUES (20, 'Test2')
INTO dept VALUES (30, 'Test3')
INTO dept VALUES (40, 'Test4')
INTO dept VALUES (50, 'Test5')
SELECT * FROM DUAL;
SELECT * FROM dept;

INSERT ALL
INTO emp VALUES (1010, 'Kim', 200, 10)
INTO emp VALUES (1020, 'Lee', 180, 20)
INTO emp VALUES (1030, 'Jung', 220, 30)
INTO emp VALUES (1040, 'Oh', 250, 40)
INTO emp VALUES (1050, 'King', 300, 50)
SELECT * FROM DUAL;
SELECT * FROM emp;

SELECT *
FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'EMP';

CREATE TABLE class(
            cno VARCHAR2(2),
            cname VARCHAR2(50)
            );
INSERT INTO class VALUES ('01','데이터베이스');
INSERT INTO class VALUES ('02','프로그래밍');

CREATE TABLE student(
                sno VARCHAR2(4),
                sname VARCHAR2(50),
                cno VARCHAR2(2)
                );
                
INSERT ALL
INTO student VALUES ('0414', '홍길동', '01')
INTO student VALUES ('0415', '임꺽정', '02')
INTO student VALUES ('0416', '이순신', '03')
SELECT * FROM DUAL;
COMMIT;

ALTER TABLE class
ADD CONSTRAINT class_cno_pk PRIMARY KEY (cno);

ALTER TABLE class
ADD CONSTRAINT class_cname_uk UNIQUE (cname);

ALTER TABLE student
ADD CONSTRAINT student_sno_pk PRIMARY KEY(sno);

ALTER TABLE student
MODIFY sname CONSTRAINT student_sname_nn NOT NULL;

ALTER TABLE student
ADD CONSTRAINT student_cno_fk FOREIGN KEY (cno) REFERENCES CLASS (cno);

UPDATE student SET cno='01'
WHERE sno='0416';

ALTER TABLE student
ADD CONSTRAINT student_cno_fk FOREIGN KEY (cno) REFERENCES CLASS (cno);

commit;

SELECT c.table_name, c.constraint_name, c.constraint_type, s.column_name
FROM user_constraints c JOIN user_cons_columns s
        ON c.constraint_name=s.constraint_name
AND c.table_name IN ('CLASS', 'STUDENT')
ORDER BY c.table_name;

ALTER TABLE class
DROP CONSTRAINT class_cno_pk;

ALTER TABLE class
DROP CONSTRAINT class_cno_pk CASCADE;

ALTER TABLE class
DROP UNIQUE (cname);

ALTER TABLE student
DROP PRIMARY KEY;

ALTER TABLE student
DROP CONSTRAINT student_sname_nn;

CREATE TABLE example1(
                depno NUMBER(2),
                dname VARCHAR2(14)
                );
                
ALTER TABLE example1
ADD loc VARCHAR2(13);

ALTER TABLE example1
ADD start_date DATE DEFAULT SYSDATE;

DESCRIBE example1;

ALTER TABLE example1
MODIFY loc CHAR(13);

ALTER TABLE example1
MODIFY depno NUMBER(5);

DESCRIBE example1;

ALTER TABLE example1
DROP COLUMN loc;

ALTER TABLE example1
DROP COLUMN dname;

DESCRIBE example1;

CREATE TABLE dept80
AS
SELECT employee_id, last_name, salary*12 ANNUAL, hire_date
FROM  employees
WHERE department_id=80;

SELECT * FROM dept80;

DESCRIBE dept80;

CREATE TABLE emp30 (emp_id, name, sal, hireDate)
AS
SELECT employee_id, last_name||' '||first_name, salary, hire_date
FROM employees
WHERE department_id =30;

SELECT * FROM emp30;

CREATE TABLE stmans (id,job,sal)
AS
SELECT employee_id, job_id, salary
FROM employees
WHERE job_id='ST_MAN';

SELECT * FROM stmans;