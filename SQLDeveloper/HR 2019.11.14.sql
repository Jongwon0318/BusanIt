--예제1)employees 테이블과 emp_details_view 뷰를 조인하여 employee_id가 100인 직원의 
--employee_id, hire_date, department_name, job_title을 출력하세요.(employee_id 컬럼 조인)


SELECT e.employee_id, e.hire_date, t.department_name, t.job_title
FROM employees e
JOIN emp_details_view t
        ON e.employee_id=t.employee_id
WHERE e.employee_id=100;

SELECT e.employee_id, e.hire_date, t.department_name, t.job_title
FROM employees e,
    emp_details_view t
WHERE e.employee_id=100;

CREATE VIEW emp_dep_loc AS
SELECT e.employee_id 직원번호, d.department_name 부서이름, l.city 도시
FROM employees e
JOIN departments d
        ON e.department_id=d.department_id
JOIN locations l
        ON d.location_id=l.location_id;
         
CREATE VIEW emp_dep_loc AS --둘의 차이는 뭘까?         
SELECT e.employee_id 직원번호, d.department_name 부서이름, l.city 도시
FROM employees e,
         departments d,
         locations l;
        
SELECT e.employee_id 직원번호, d.department_name 부서이름, l.city 도시
FROM employees e
JOIN departments d
        ON e.department_id=d.department_id
JOIN locations l
        ON d.location_id=l.location_id;

SELECT e.employee_id 직원번호, d.department_name 부서이름, l.city 도시
FROM employees e,
         departments d,
         locations l;


SELECT * FROM emp_dep_loc;

DESCRIBE emp_dep_loc;

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='emp_dep_loc';

DROP VIEW emp_dep_loc;

SELECT 
    TABLE_NAME 테이블명,
    INDEX_NAME 인덱스이름,
    COLUMN_NAME 컬럼이름
FROM ALL_IND_COLUMNS
WHERE TABLE_NAME='EMPLOYEES';

DROP TABLE members;

CREATE TABLE members(
        member_id INT,
        first_name VARCHAR2(100) NOT NULL,
        last_name VARCHAR2(100) NOT NULL,
        gender CHAR(1) NOT NULL,
        dob DATE NOT NULL,
        email VARCHAR2(255) NOT NULL,
        PRIMARY KEY(member_id)
        );
        
SELECT TABLE_NAME 테이블명,
                 INDEX_NAME 인덱스이름,
                 COLUMN_NAME 컬럼이름
FROM ALL_IND_COLUMNS
WHERE TABLE_NAME='MEMBERS';

SELECT * FROM members
WHERE last_name = 'Harse';

EXPLAIN PLAN FOR
SELECT * FROM members
WHERE last_name='Harse';

SELECT
            PLAN_TABLE_OUTPUT
FROM
            TABLE(DBMS_XPLAN.DISPLAY());
            --TABLE ACCESS FULL : 전체 테이블을 검색한다(인덱스가 없다.)
            
CREATE INDEX members_last_name_i
ON members(last_name);

DROP INDEX members_name_I;

--예제2)MEMBERS 테이블의 first_name과 last_name의 멀티 인덱스를 만들어서 인덱스들의 조회 및 
--성능평가결과를 출력하라
CREATE INDEX members_name_iI
ON members(last_name||' '||first_name);

SELECT 
    TABLE_NAME 테이블명,
    INDEX_NAME 인덱스이름,
    COLUMN_NAME 컬럼이름
FROM ALL_IND_COLUMNS
WHERE TABLE_NAME='MEMBERS';

EXPLAIN PLAN FOR 
SELECT * FROM members
WHERE  last_name LIKE 'A%' AND first_name LIKE 'M%' ;

EXPLAIN PLAN FOR 
SELECT * FROM members
WHERE  last_name||' '||first_name LIKE 'A%M%' ;

SELECT * FROM MEMBERS;

SELECT
            PLAN_TABLE_OUTPUT
FROM
            TABLE(DBMS_XPLAN.DISPLAY());

--CREATE SEQUENCE sequence_name
--        [START WITH n]
--        [INCREMENT BY n]
--        [MAXVALUE n | NOMAXVALUE]
--        [MINVALUE n | NOMINVALUE]

--ALTER SEQUENCE sequence_name
--        [INCREMENT BY n]
--        [MAXVALUE n | NOMAXVALUE]
--        [MIN VALUE n } NOMINVALUE]

CREATE SEQUENCE test_seq
START WITH 1
INCREMENT BY 1;

SELECT test_seq.NEXTVAL FROM DUAL;
SELECT test_seq.CURRVAL FROM DUAL;

CREATE TABLE test_table(
        seq NUMBER PRIMARY KEY,
        title VARCHAR2(20) NOT NULL
        );

INSERT INTO test_table VALUES (test_seq.nextval,'hello1');
INSERT INTO test_table VALUES (test_seq.nextval,'hello2');
INSERT INTO test_table VALUES (test_seq.nextval,'hello3');

SELECT * FROM test_table;

ALTER SEQUENCE test_seq
INCREMENT BY -10;

DROP TABLE test_table;

DROP SEQUENCE test_seq;

