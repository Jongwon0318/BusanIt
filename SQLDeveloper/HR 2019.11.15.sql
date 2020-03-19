--���� 1) countries, locations ���̺��� �����Ͽ� �Ʒ��� ���� ����Ͻÿ�.(������ȣ�� DESC ����)

SELECT c.country_name ����, c.country_id ������ȣ, l.location_id ������ȣ, l.city ����
FROM countries c
LEFT OUTER JOIN locations l
        ON c.country_id=l.country_id;

--����2)countries, regions ���̺��� ũ�ν� �����Ͽ� �Ʒ��� ���� ������ ���̺��� 25��x4�� =>100���� ����� �������� �ϼ���.

SELECT c.country_name ����, r.region_name �����̸�
FROM countries c
CROSS JOIN regions r;

--����3) departments ���̺� �ִ� manager_id�� employees ���̺��� employee_id�� �̿��Ͽ� 
--�����Ͽ� �μ���,�Ŵ�����ȣ,�Ŵ����̸�,��ȭ��ȣ�� ��Ÿ���̷���

SELECT d.department_name �μ���, 
                 d.manager_id �Ŵ�����ȣ, 
                 e.last_name||' '||e.first_name "�Ŵ����̸�(�����̸�)", 
                 e.phone_number ��ȭ��ȣ
FROM departments d
JOIN employees e
        ON d.manager_id=e.employee_id;

--����4) ������ �̿��Ͽ� ������� ������ȣ(employee_id),�������(hire_date), ����(job_id), ��å(job_title)�� ����Ͻÿ�.

SELECT e.employee_id ������ȣ, e.hire_date �������, e.job_id ����, j.job_title ��å
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id;

--����5) job_title�� 'Sales Manager'�� ������� �Ի�⵵ �׷� �� ��� �޿��� ����Ͻÿ�, �Ի�⵵�� �������� �������� ����, (jobs ���̺�� ���� job_id�� �̿�)

SELECT TO_CHAR(e.hire_date, 'YYYY') �Ի�⵵, AVG(e.salary)
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id
WHERE j.job_title='Sales Manager'
GROUP BY TO_CHAR(e.hire_date, 'YYYY')
ORDER BY 1 ;

--����6) ������ ���ÿ� �ִ� ��� �μ��������� ��ձ޿��� ��ȸ�ϰ��� �Ѵ�. ��ձ޿��� ���� ���� ���ú��� ���ø�,��տ���,�ش絵���� �������� ����Ͻÿ�, ��,���ÿ� �ٹ��ϴ� ������ 10���̻��� ���� �����ϰ� ��ȸ�Ͻÿ�.

SELECT l.city, ROUND(AVG(e.salary)), COUNT(*)
FROM departments d
JOIN employees e
        ON e.department_id=d.department_id
JOIN locations l
        ON l.location_id=d.location_id
GROUP BY l.city
HAVING COUNT(*)<10;
        
--����7) �ڽ��� �Ŵ������� �޿��� ���� �޴� �������� ��, �޿��� �Ŵ����� ��,�޿��� ����϶�

SELECT e.last_name, e.salary, m.last_name, m.salary
FROM employees e
JOIN employees m
        ON e.manager_id=m.employee_id
WHERE e.salary>m.salary;

--����1)��� 'Abel'(last_name)���� �޿��� ���� ����� last_name, salary�� ��Ÿ�����(�������� ���)

SELECT last_name, salary
FROM employees
WHERE salary> (SELECT salary
                                FROM employees
                                WHERE last_name='Abel');

--����2) 'Bull'�̶� last_name�� ���� ����� �μ����� Bull���� ���� �޿��� �޴� ������� ����϶�(�����������)

SELECT last_name, salary, department_id
FROM employees
WHERE salary>(SELECT salary
                            FROM employees
                            WHERE last_name='Bull')
ORDER BY 2 DESC;

--����3)'Russell'�̶� last_name�� ���� ��ȣ�� manager_id�� ������ �������� last_name, salary, manager_id�� ���

SELECT last_name, salary, manager_id
FROM employees
WHERE manager_id =(SELECT employee_id
                                            FROM employees
                                            WHERE last_name='Russell');

--����4)jobs ���̺� job_title�� 'Stock Manager'�� job_id�� ���� �������� ������ Employees���̺��� ã�Ƽ� ���

SELECT j.job_title, e.*
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id
WHERE j.job_id=(SELECT job_id
                                FROM jobs
                                WHERE job_title='Stock Manager');

--����5) �μ���ȣ(department_id)�� 20���� �������� �Ŵ������̵�(manager_id)�� ���� �Ŵ����� ������ �������� ���
--(��, 20�� �μ��� ������ ����!)

SELECT *
FROM employees
WHERE manager_id IN(SELECT manager_id
                                            FROM employees
                                            WHERE department_id=20)
AND department_id!=20;

--����6) job_id�� 'ST_MAN'�� �������� ��� ������ ���ٵ� �޿��� ���� �������� ����϶�(ANY)

SELECT *
FROM employees
WHERE salary < ANY(SELECT salary
                                            FROM employees
                                            WHERE job_id='ST_MAN')
AND job_id!='ST_MAN';

--����7) ��å�� 'IT_PROG'�� �����麸�� �޿��� ���� �������� ����Ͻÿ�.(ALL)

SELECT *
FROM employees
WHERE salary < ALL(SELECT salary
                                            FROM employees
                                            WHERE job_id='IT_PROG');

--����8) employees ���̺��� job_id���� ���� ���� salary�� ������ ã�ƺ���, ã�Ƴ� job_id�� salary�� �ش��ϴ� ������
--first_name, job_id, salary, department_id�� ����Ͻÿ�,(salary �������� ����)

SELECT first_name, job_id, salary, department_id
FROM employees
WHERE (job_id, salary) IN (SELECT job_id,MIN(salary)
                                            FROM employees
                                            GROUP BY job_id)
ORDER BY salary DESC, job_id;

--����9) employees ���̺��� department_id ���հ� departments ���̺��� department_id ������ UNION�����ڸ� �̿��� ���ĺ�����

SELECT department_id
FROM employees
UNION
SELECT department_id
FROM departments;

--����10) employees ���̺��� department_id ���հ� departments ���̺��� department_id ������ UNION ALL�����ڸ� �̿��� ���ĺ�����.

SELECT department_id
FROM employees
UNION ALL
SELECT department_id
FROM departments;

--����11)employees ���̺��� department_id ���հ� departments ���̺��� department_id ������ �������� INTERSECT�����ڸ� �̿���

SELECT department_id
FROM employees
INTERSECT
SELECT department_id
FROM departments;

--����12)departments ���̺��� department_id ���տ��� employees ���̺��� department_id ������ MINUS�����ڸ� �̿��� ��������

SELECT department_id
FROM departments
MINUS
SELECT department_id
FROM employees;

--����13) departments ���̺� ������ ���� ������ department_id, department_name, manager_id�� 200, location_id�� 1700�� ���� 3�� �Է��ϼ���

INSERT INTO departments VALUES(271,'Sample Dept 1',200,1700);
INSERT INTO departments VALUES(272,'Sample Dept 2',200,1700);
INSERT INTO departments VALUES(273,'Sample Dept 3',200,1700);
SELECT * FROM departments;
ROLLBACK;

--����14)�Ʒ��� ���� ���̺��� ���� �� SELECT���� �̿��Ͽ� departments ���̺� ������ ���� �Է��Ͻÿ�.(���� scott���� 3��° ���)
CREATE TABLE copy_departments( department_id number(4,0),
                                                                    department_name varchar2(30 byte),
                                                                    manager_id number(6,0),
                                                                    location_id number(4,0));
INSERT INTO copy_departments
SELECT * FROM departments;

SELECT * FROM copy_departments;
ROLLBACK;

--����15)departments ���̺��� 'Music'�μ��� �Ŵ����� location ID�� 100, 1800���� ������Ʈ.
INSERT INTO departments(department_id,department_name)
VALUES (280, 'Music');

UPDATE departments
SET manager_id=100 ,location_id=1800
WHERE department_id=280;

SELECT * FROM departments;
ROLLBACK;

--���� 16) copy_departments ���̺��� department_id 150���� 200���� �μ���ȣ�� manager_id�� 100���� �����϶�.

UPDATE copy_departments
SET manager_id=100
WHERE department_id BETWEEN 150 AND 200;

--����1)  product_id(number Ÿ��), product_name(varchar2 Ÿ��, 20�ڸ�), menu_date(date Ÿ��) ���� �ִ� sample_product �̸��� ���̺��� ������ ������.

CREATE TABLE sample_product(
            product_id NUMBER,
            product_name VARCHAR2(20),
            menu_date DATE);
DESCRIBE sample_product;

--����2) ������ ���� ���̺��� ������ ������. DESCRIBE ���� ���̺��� �� �����Ǿ����� Ȯ���ϼ���.

DROP TABLE sample_product;

--����3) members��� �� ���̺��� ����ϴ�. (�������� �̸��� ��������)
�÷��� : member_id , ������Ÿ�� : NUMBER , 	ũ��(byte) :2 , 	�������� : P 
�÷��� : first_name , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 50 , 	�������� : C(NN) 
�÷��� : last_name , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 50 , 	�������� :  C(NN)
�÷��� : gender , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 5 , 	�������� : C('MAN' OR 'WOMAN')
�÷��� : birth_day , 	������Ÿ�� : DATE , 		ũ��(byte) : , 	�������� : DEFAULT SYSDATE
�÷��� : email , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 200 , 	�������� : U, C(NN)

CREATE TABLE members(
        member_id NUMBER(2) PRIMARY KEY,
        first_name VARCHAR2(50) NOT NULL,
        last_name VARCHAR2(50) NOT NULL,
        gender VARCHAR2(5) CHECK (gender IN ('MAN','WOMAN')),
        birth_day DATE DEFAULT SYSDATE,
        email VARCHAR2(200) NOT NULL,
        UNIQUE (email)
        );

DESCRIBE members;



--����4) employees ���̺��� job_id�� 'ST_MAN'�� �������� �� ���̺� stmans�� ����� �Է��϶�.
--�� ���̺��� �÷� �̸��� id, job, sal(���� ���̺��� employee_id, job_id, salary)

CREATE TABLE stmans(id,job,sal)
AS
SELECT employee_id, job_id, salary
FROM employees
WHERE job_id='ST_MAN';

SELECT * FROM stmans;
ROLLBACK;

--����1)employees ���̺�� emp_details_view �並 �����Ͽ� employee_id�� 100�� ������ 
--employee_id, hire_date, department_name, job_title�� ����ϼ���.(employee_id �÷� ����)

SELECT e.employee_id, e.hire_date, v.department_name, v.job_title
FROM employees e
JOIN emp_details_view v
        ON e.employee_id=v.employee_id;

--����2)MEMBERS ���̺��� first_name�� last_name�� ��Ƽ �ε����� ���� �ε������� ��ȸ �� 
--�����򰡰���� ����϶�

CREATE INDEX members_name_i
ON members(first_name,last_name);

CREATE TABLE members(
        member_id INT,
        first_name VARCHAR2(100) NOT NULL,
        last_name VARCHAR2(100) NOT NULL,
        gender CHAR(1) NOT NULL,
        dob DATE NOT NULL,
        email VARCHAR2(255) NOT NULL,
        PRIMARY KEY(member_id)
        );

SELECT * FROM members;

SELECT TABLE_NAME, INDEX_NAME, COLUMN_NAME
FROM ALL_IND_COLUMNS
WHERE TABLE_NAME='MEMBERS';

EXPLAIN PLAN FOR 
SELECT * FROM members
WHERE first_name='%' AND last_name = 'Harse';

SELECT PLAN_TABLE_OUTPUT
FROM TABLE(DBMS_XPLAN.DISPLAY());

CREATE VIEW emp_dep_loc AS
SELECT employee_id ������ȣ, department_name �μ��̸�, city ����
FROM employees e
JOIN departments d
        ON e.department_id=d.department_id
JOIN locations l
        ON d.location_id=l.location_id;
        
SELECT * FROM emp_dep_loc;

CREATE SEQUENCE to_seq
START WITH 1
INCREMENT BY 3;

SELECT to_seq.CURRVAL FROM DUAL;

SELECT to_seq.NEXTVAL FROM DUAL;

DROP SEQUENCE to_seq;

CREATE TABLE test_table(
        seq NUMBER PRIMARY KEY,
        title VARCHAR2(20) NOT NULL
        );
        
INSERT INTO test_table VALUES (to_seq.NEXTVAL, 'hello1');
INSERT INTO test_table VALUES (to_seq.NEXTVAL, 'hello2');
INSERT INTO test_table VALUES (to_seq.NEXTVAL, 'hello3');

SELECT * FROM test_table;

ROLLBACK;

--����1) employees���̺��� employee_id, first_name, last_name�� ����ϼ���.

SELECT employee_id, first_name, last_name
FROM employees;

--����2) employees���̺�κ��� first_name, salary, new_salary(salary*1.1)

SELECT first_name, salary, salary*1.1 new_salary
FROM employees;

--����3) employees���̺��� employee_id�� '�����ȣ', first_name�� '�̸�', last_name�� '��'���� ����ϼ���.

SELECT employee_id �����ȣ, first_name �̸�, last_name ��
FROM employees;

--����4) employees���̺��� employee_id�� ����ϰ�, first_name�� last_name�� �ٿ��� ����ϵ� ��� 
--�� ĭ�� ����ּ���. ���� ������ email�� ����ϵ� @company.com ������ �ٿ��� ����ϼ���.

SELECT employee_id, first_name||' '||last_name name, email||'@company.com' email
FROM employees;

--����5) employees���̺��� employee_id�� 100�� ���� ������ ����ϼ���

SELECT *
FROM employees
WHERE employee_id=100;

--����6) employees���̺��� first_name�� David�� ���� ������ ����ϼ���.

SELECT *
FROM employees
WHERE first_name='David';

--����7) employees���̺��� employee_id�� 105������

SELECT *
FROM employees
WHERE employee_id<=105;

--����8) job_history���̺��� start_date�� 2006�� 3�� 3�� ������ 

SELECT *
FROM job_history
WHERE start_date>TO_DATE('06/03/03');

--����9) departments���̺��� location_id�� 1700�� �ƴ� ��� �μ��� ���

SELECT *
FROM departments
WHERE location_id!=1700;

--����10) employees���̺��� salary>4000, job_id =IT_PROG�� ��� ���

SELECT *
FROM employees
WHERE salary>4000 AND job_id='IT_PROG';

--����11) employees���̺��� salary>4000, job_id=IT_PROG OR FI_ACCOUNT

SELECT *
FROM employees
WHERE salary>4000 AND job_id IN('IT_PROG','FI_ACCOUNT');

--���� 12) employees���̺��� salary�� 10000,17000,24000�� ����

SELECT *
FROM employees
WHERE salary IN (10000,17000,24000);

--���� 13) employees���̺��� department_ID�� 30,50,80,100,110�� �ƴ� ����

SELECT *
FROM employees
WHERE department_id NOT IN (30,50,80,100,110);

--���� 14) employees���̺��� salary�� 10,000 �̻��̰� 20,000 ������ ���� ������ ����ϼ���.

SELECT *
FROM employees
WHERE salary BETWEEN 10000 AND 20000;

--���� 15) employees���̺��� hire_date�� 2004�� 1�� 1�Ϻ��� 2004�� 12�� 30�� ������

SELECT *
FROM employees
WHERE hire_date BETWEEN TO_DATE('04/01/01') AND TO_DATE('04/12/30');

--���� 16) employees���̺��� salary�� 7000 �̸��̰ų�, 17000���� ���� ���

SELECT *
FROM employees
WHERE salary NOT BETWEEN 7000 AND 17000;

--���� 17)  employees���̺��� job_id ���� AD�� �����ϴ� ��� ������

SELECT *
FROM employees
WHERE job_id LIKE '%AD%';

--���� 18)  employees���̺��� job_id ���� AD��  �����ϸ鼭 AD�ڿ� ������� ���ڿ��� 3�ڸ�

SELECT *
FROM employees
WHERE job_id LIKE '%AD___';

--���� 19)  employees���̺��� ��ȭ��ȣ ���ڸ��� 1234�� ������

SELECT *
FROM employees
WHERE phone_number LIKE '%1234';

--���� 20)  employees���̺��� ��ȭ������ 3�� ���� �����鼭 ��ȭ��ȣ ���ڸ��� 9��

SELECT *
FROM employees
WHERE phone_number NOT LIKE '%3%' AND phone_number LIKE '%9';

--���� 21)  employees���̺��� job_id�� MGR�� �����ϰų�, ASST�� �����ϴ� ����

SELECT *
FROM employees
WHERE job_id LIKE '%MGR%' OR job_id LIKE '%ASST%';

--���� 22) employees���̺��� manager_id�� null ���� ���� -- �����̴�!

SELECT *
FROM employees
WHERE manager_id IS NULL;

--���� 23) employees���̺��� employee_id, first_name, last_name�� ���, employee_id�� �������� �������� ����

SELECT employee_id, first_name, last_name
FROM employees
ORDER BY employee_id DESC;

--���� 24) employees���̺��� job_id�� CLERK�� �ܾ ���� �������� salary �������� ����

SELECT *
FROM employees
WHERE job_id LIKE '%CLERK%'
ORDER BY salary DESC;

--���� 25) employees���̺��� employee_id(������ȣ)�� 120���� 150������ ������ �μ���ȣ(department_id)�� 
--ū������ ����, �μ���ȣ�� ���ٸ� ����(salary)�� ū������ ����

SELECT *
FROM employees
WHERE employee_id BETWEEN 120 AND 150
ORDER BY department_id DESC, salary DESC;


--���� 1) employees���̺��� last_name�� �ҹ��ڿ� �빮�ڷ� ���� ����ϰ�, email�� ù��°���ڴ� �빮�ڷ�

SELECT last_name, LOWER(last_name), UPPER(last_name), INITCAP(email)
FROM employees;

--���� 2) employees���̺��� job_id ������ ���� ù°�ڸ����� �����ؼ� �ΰ��� ���ڸ� ����ϼ���

SELECT job_id, SUBSTR(job_id,1,2)
FROM employees;

--����3) employees ���̺��� salary�� 30���� ���� �� ���� ���� ����� �ݿø��Ͽ� ����,�Ҽ���ù°�ڸ�,10���ڸ���

SELECT salary, ROUND(salary/30), ROUND(salary/30,1), ROUND(salary/30,-1)
FROM employees;

--����4) employees ���̺��� department_id�� 100�� ������ ���� ���� ��¥, hire_date, 
--���ó�¥�� hire_date������ �������� ����ϼ���

SELECT SYSDATE, hire_date, ROUND(MONTHS_BETWEEN(SYSDATE,hire_date))
FROM employees;

--����5) employees ���̺� ���� employee_id�� 100�� 105 ������ ������ hire_date�� 3������ ���� ��,
 --hire_date�� 3������ �� ���� ����ϼ���.

SELECT hire_date, ADD_MONTHS(hire_date,3), ADD_MONTHS(hire_date,-3)
FROM employees;

--���� 6) employees ���̺��� department_id�� 100�� ������� �Ի����� �̿��Ͽ� �Ʒ��� ���� ��Ÿ�����.

SELECT  employee_id, TO_CHAR(hire_date, 'MM/YY') �Ի��
FROM employees
WHERE department_id=100;

--���� 7) employees ���̺��� salary�� 10000�޷��� �Ѵ� ������� �̸��� ������ ������ ���� ������ ��Ÿ�����.

SELECT last_name, TO_CHAR(salary,'$99,999.99')
FROM employees
WHERE salary>10000
ORDER BY salary DESC;

--����8) employees ���̺��� �Ʒ��Ͱ��� �̸�,����,Ŀ�̼��� NVL�Լ� ���, ������ (����*12)+(����*12*Ŀ�̼�)�̴�.
--����9) ���� ������ ���Ͽ� ��������� NVL2 �Լ��� ����Ͽ� Ŀ�̼��� �������� ������ ������� ��Ÿ���ϴ�.

SELECT last_name, salary, NVL(commission_pct,0), NVL2(commission_pct, salary*12+salary*12*commission_pct, salary*12)
FROM employees
ORDER BY 4 DESC;

--����10) employees ���̺��� first_name �� last_name�� ���� LENGTH�� ���ؼ� ������ null���� �ƴϸ�
 --LENGTH(first_name)���� ����϶�.



--���� 11) employees ���̺��� DECODE �Լ��� �̿��ؼ� ���޿� ���� ������ ��Ÿ������.
--���� : $0.00~$1,999.99 00%, $2,000.00~$3,999.99 09%, $4,000.00~$5,999.99 20%, $6,000.00~$7,999.99 30%
-- $8,000.00~$9,999.99 40%, $10,000.00~$11,999.99 42%, $12,200.00~$13,999.99 44%, $14,000.00~ 45%



--���� 12) employees ���̺��� job_id�� IT_PROG��� employ_id, first_name, last_name, 
--salary�� ����ϵ� salary�� 9000�̻��̸� '�����޿�', 6000�� 8999���̸� '�����޿�', �� �ܴ� '�����޿�'��� ����ϼ���.



--����1) �μ��� �����, �ִ�޿�, �ּұ޿�, �޿��հ�, ��ձ޿��� �޿��հ� ū ������ ��ȸ.



--����2)�μ���,������,����ȣ���� �׷��� ���� salary�հ�� �׷캰 ������ ���ڸ� ����϶�.



--����3)�μ����� �ְ� ������ �̾Ƽ� ����� ����, �������� ���� ����� ���� ����϶�.



--����4) �μ��� ��տ����� 10000�� �ʰ��ϴ� ������ ���ؼ� job_id�� ���޿��հ踦 ��ȸ, 
--AC_MGR���� ���޿��հ�� ��������



--����5) �μ���ȣ 40�� ������ �μ��� ��� �޿��� 7000 ������ �μ����� ��� �޿��� ���



--����6) �������� ������ �հ谡 13000�̻��� ������ ����϶�. �޿��Ѿ����� ������������, ������ REP����ִ� ���� ����



--����7) �μ��� ��տ����� 10000�� �ʰ��ϴ� ������ ���ؼ� job_id�� ���޿��հ踦 ��ȸ, AC_MGR���� ���޿��հ�� ��������



--����8) �μ���ȣ 40�� ������ �μ��� ��� �޿��� 7000 ������ �μ����� ��� �޿��� ���



--����9) �������� ������ �հ谡 13000�̻��� ������ ����϶�. �޿��Ѿ����� ������������, ������ REP����ִ� ���� ����



--���� 10) �μ���(department_name),��Ƽ��(city),������(country_name)�� ��Ÿ���� ���̺��� ����մϴ�. 
--���̺���� countries�� departments�� locations�� �����մϴ�. 
--������, ��Ƽ�� 'Seattle' Ȥ�� 'London'�̾�� �ϰ� �������� ���ʿ� 'United'�� ���� �մϴ�.



--���� 1) countries, locations ���̺��� �����Ͽ� �Ʒ��� ���� ����Ͻÿ�.(������ȣ�� DESC ����)
*


--����2)countries, regions ���̺��� ũ�ν� �����Ͽ� �Ʒ��� ���� ������ ���̺��� 25��x4�� =>100���� ����� �������� �ϼ���.



--����3) departments ���̺� �ִ� manager_id�� employees ���̺��� employee_id�� �̿��Ͽ� �����Ͽ� �μ���,�Ŵ�����ȣ,�Ŵ����̸�,��ȭ��ȣ�� ��Ÿ���̷���



--����4) ������ �̿��Ͽ� ������� ����ʹ�ȣ(employee_id),�������(hire_date), ����(job_id), ��å(job_title)�� ����Ͻÿ�.



--����5) job_title�� 'Sales Manager'�� ������� �Ի�⵵ �׷� �� ��� �޿��� ����Ͻÿ�, �Ի�⵵�� �������� �������� ����, (jobs ���̺�� ���� job_id�� �̿�)



--����6) ������ ���ÿ� �ִ� ��� �μ��������� ��ձ޿��� ��ȸ�ϰ��� �Ѵ�. ��ձ޿��� ���� ���� ���ú��� ���ø�,��տ���,�ش絵���� �������� ����Ͻÿ�, ��,���ÿ� �ٹ��ϴ� ������ 10���̻��� ���� �����ϰ� ��ȸ�Ͻÿ�.



--����7) �ڽ��� �Ŵ������� �޿��� ���� �޴� �������� ��, �޿��� �Ŵ����� ��,�޿��� ����϶�



--����1)��� 'Abel'(last_name)���� �޿��� ���� ����� last_name, salary�� ��Ÿ�����(�������� ���)



--����2) 'Bull'�̶� last_name�� ���� ����� �μ����� Bull���� ���� �޿��� �޴� ������� ����϶�(�����������)



--����3)'Russell'�̶� last_name�� ���� ��ȣ�� manager_id�� ������ �������� last_name, salary, manager_id�� ���



--����4)jobs ���̺� job_title�� 'Stock Manager'�� job_id�� ���� �������� ������ Employees���̺��� ã�Ƽ� ���



--����5) �μ���ȣ(department_id)�� 20���� �������� �Ŵ������̵�(manager_id)�� ���� �Ŵ����� ������ �������� ���
--(��, 20�� �μ��� ������ ����!)



--����6) job_id�� 'ST_MAN'�� �������� ��� ������ ���ٵ� �޿��� ���� �������� ����϶�(ANY)



--����7) ��å�� 'IT_PROG'�� �����麸�� �޿��� ���� �������� ����Ͻÿ�.(ALL)



--����8) employees ���̺��� job_id���� ���� ���� salary�� ������ ã�ƺ���, ã�Ƴ� job_id�� salary�� �ش��ϴ� ������
--first_name, job_id, salary, department_id�� ����Ͻÿ�,(salary �������� ����)



--����9) employees ���̺��� department_id ���հ� departments ���̺��� department_id ������ UNION�����ڸ� �̿��� ���ĺ�����



--����10) employees ���̺��� department_id ���հ� departments ���̺��� department_id ������ UNION ALL�����ڸ� �̿��� ���ĺ�����.



--����11)employees ���̺��� department_id ���հ� departments ���̺��� department_id ������ �������� INTERSECT�����ڸ� �̿���



--����12)departments ���̺��� department_id ���տ��� employees ���̺��� department_id ������ MINUS�����ڸ� �̿��� ��������



--����13) departments ���̺� ������ ���� ������ department_id, department_name, manager_id�� 200, location_id�� 1700�� ���� 3�� �Է��ϼ���



--����14)�Ʒ��� ���� ���̺��� ���� �� SELECT���� �̿��Ͽ� departments ���̺� ������ ���� �Է��Ͻÿ�.(���� scott���� 3��° ���)
CREATE TABLE copy_departments( department_id number(4,0),
                                                                    department_name varchar2(30 byte),
                                                                    manager_id number(6,0),
                                                                    location_id number(4,0));



--����15)departments ���̺��� 'Music'�μ��� �Ŵ����� location ID�� 100, 1800���� ������Ʈ.
INSERT INTO departments(department_id,department_name)
VALUES (280, 'Music');



--���� 16) copy_departments ���̺��� department_id 150���� 200���� �μ���ȣ�� manager_id�� 100���� �����϶�.




--����1)  product_id(number Ÿ��), product_name(varchar2 Ÿ��, 20�ڸ�), menu_date(date Ÿ��) ���� �ִ� sample_product �̸��� ���̺��� ������ ������.



--����2) ������ ���� ���̺��� ������ ������. DESCRIBE ���� ���̺��� �� �����Ǿ����� Ȯ���ϼ���.


--����3) members��� �� ���̺��� ����ϴ�. (�������� �̸��� ��������)
�÷��� : member_id , ������Ÿ�� : NUMBER , 	ũ��(byte) :2 , 	�������� : P 
�÷��� : first_name , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 50 , 	�������� : C(NN) 
�÷��� : last_name , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 50 , 	�������� :  C(NN)
�÷��� : gender , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 5 , 	�������� : C('MAN' OR 'WOMAN')
�÷��� : birth_day , 	������Ÿ�� : DATE , 		ũ��(byte) : , 	�������� : DEFAULT SYSDATE
�÷��� : email , 	������Ÿ�� : VARCHAR2 , 	ũ��(byte) : 200 , 	�������� : U, C(NN)





--����4) employees ���̺��� job_id�� 'ST_MAN'�� �������� �� ���̺� stmans�� ����� �Է��϶�.
--�� ���̺��� �÷� �̸��� id, job, sal(���� ���̺��� employee_id, job_id, salary)




--����1)employees ���̺�� emp_details_view �並 �����Ͽ� employee_id�� 100�� ������ 
--employee_id, hire_date, department_name, job_title�� ����ϼ���.(employee_id �÷� ����)




--����2)MEMBERS ���̺��� first_name�� last_name�� ��Ƽ �ε����� ���� �ε������� ��ȸ �� 
--�����򰡰���� ����϶�














