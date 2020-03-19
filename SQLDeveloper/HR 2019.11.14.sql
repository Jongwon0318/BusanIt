--����1)employees ���̺�� emp_details_view �並 �����Ͽ� employee_id�� 100�� ������ 
--employee_id, hire_date, department_name, job_title�� ����ϼ���.(employee_id �÷� ����)


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
SELECT e.employee_id ������ȣ, d.department_name �μ��̸�, l.city ����
FROM employees e
JOIN departments d
        ON e.department_id=d.department_id
JOIN locations l
        ON d.location_id=l.location_id;
         
CREATE VIEW emp_dep_loc AS --���� ���̴� ����?         
SELECT e.employee_id ������ȣ, d.department_name �μ��̸�, l.city ����
FROM employees e,
         departments d,
         locations l;
        
SELECT e.employee_id ������ȣ, d.department_name �μ��̸�, l.city ����
FROM employees e
JOIN departments d
        ON e.department_id=d.department_id
JOIN locations l
        ON d.location_id=l.location_id;

SELECT e.employee_id ������ȣ, d.department_name �μ��̸�, l.city ����
FROM employees e,
         departments d,
         locations l;


SELECT * FROM emp_dep_loc;

DESCRIBE emp_dep_loc;

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME='emp_dep_loc';

DROP VIEW emp_dep_loc;

SELECT 
    TABLE_NAME ���̺��,
    INDEX_NAME �ε����̸�,
    COLUMN_NAME �÷��̸�
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
        
SELECT TABLE_NAME ���̺��,
                 INDEX_NAME �ε����̸�,
                 COLUMN_NAME �÷��̸�
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
            --TABLE ACCESS FULL : ��ü ���̺��� �˻��Ѵ�(�ε����� ����.)
            
CREATE INDEX members_last_name_i
ON members(last_name);

DROP INDEX members_name_I;

--����2)MEMBERS ���̺��� first_name�� last_name�� ��Ƽ �ε����� ���� �ε������� ��ȸ �� 
--�����򰡰���� ����϶�
CREATE INDEX members_name_iI
ON members(last_name||' '||first_name);

SELECT 
    TABLE_NAME ���̺��,
    INDEX_NAME �ε����̸�,
    COLUMN_NAME �÷��̸�
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

