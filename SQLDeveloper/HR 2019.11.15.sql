--예제 1) countries, locations 테이블을 조인하여 아래와 같이 출력하시오.(지역번호로 DESC 정렬)

SELECT c.country_name 국가, c.country_id 국가번호, l.location_id 지역번호, l.city 도시
FROM countries c
LEFT OUTER JOIN locations l
        ON c.country_id=l.country_id;

--예제2)countries, regions 테이블을 크로스 조인하여 아래와 같이 각각의 테이블의 25행x4행 =>100행의 결과가 나오도록 하세요.

SELECT c.country_name 국가, r.region_name 지역이름
FROM countries c
CROSS JOIN regions r;

--예제3) departments 테이블에 있는 manager_id와 employees 테이블의 employee_id를 이용하여 
--조인하여 부서명,매니저번호,매니저이름,전화번호를 나타내이러ㅏ

SELECT d.department_name 부서명, 
                 d.manager_id 매니저번호, 
                 e.last_name||' '||e.first_name "매니저이름(직원이름)", 
                 e.phone_number 전화번호
FROM departments d
JOIN employees e
        ON d.manager_id=e.employee_id;

--예제4) 조인을 이용하여 사원들의 직원번호(employee_id),고용일자(hire_date), 직종(job_id), 직책(job_title)을 출력하시오.

SELECT e.employee_id 직원번호, e.hire_date 고용일자, e.job_id 직종, j.job_title 직책
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id;

--예제5) job_title이 'Sales Manager'인 사원들의 입사년도 그룹 별 평균 급여를 출력하시오, 입사년도를 기준으로 오름차순 정렬, (jobs 테이블과 조인 job_id를 이용)

SELECT TO_CHAR(e.hire_date, 'YYYY') 입사년도, AVG(e.salary)
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id
WHERE j.job_title='Sales Manager'
GROUP BY TO_CHAR(e.hire_date, 'YYYY')
ORDER BY 1 ;

--예제6) 각각의 도시에 있는 모든 부서직원들의 평균급여를 조회하고자 한다. 평균급여가 가장 낮은 도시부터 도시명,평균연봉,해당도시의 직원수를 출력하시오, 단,도시에 근무하는 직원이 10명이상인 곳은 제외하고 조회하시오.

SELECT l.city, ROUND(AVG(e.salary)), COUNT(*)
FROM departments d
JOIN employees e
        ON e.department_id=d.department_id
JOIN locations l
        ON l.location_id=d.location_id
GROUP BY l.city
HAVING COUNT(*)<10;
        
--예제7) 자신의 매니저보다 급여를 많이 받는 직원들의 성, 급여와 매니저의 성,급여를 출력하라

SELECT e.last_name, e.salary, m.last_name, m.salary
FROM employees e
JOIN employees m
        ON e.manager_id=m.employee_id
WHERE e.salary>m.salary;

--예제1)사원 'Abel'(last_name)보다 급여가 많은 사원의 last_name, salary를 나타내어라(서브쿼리 사용)

SELECT last_name, salary
FROM employees
WHERE salary> (SELECT salary
                                FROM employees
                                WHERE last_name='Abel');

--예제2) 'Bull'이란 last_name을 가진 사원의 부서에서 Bull보다 높은 급여를 받는 사원들을 출력하라(서브쿼리사용)

SELECT last_name, salary, department_id
FROM employees
WHERE salary>(SELECT salary
                            FROM employees
                            WHERE last_name='Bull')
ORDER BY 2 DESC;

--예제3)'Russell'이란 last_name의 직원 번호를 manager_id로 가지는 직원들의 last_name, salary, manager_id를 출력

SELECT last_name, salary, manager_id
FROM employees
WHERE manager_id =(SELECT employee_id
                                            FROM employees
                                            WHERE last_name='Russell');

--예제4)jobs 테이블에 job_title이 'Stock Manager'의 job_id를 가진 직원들의 정보를 Employees테이블에서 찾아서 출력

SELECT j.job_title, e.*
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id
WHERE j.job_id=(SELECT job_id
                                FROM jobs
                                WHERE job_title='Stock Manager');

--예제5) 부서번호(department_id)가 20번인 직원들의 매니저아이디(manager_id)와 같은 매니저를 가지는 직원들을 출력
--(단, 20번 부서의 직원은 제외!)

SELECT *
FROM employees
WHERE manager_id IN(SELECT manager_id
                                            FROM employees
                                            WHERE department_id=20)
AND department_id!=20;

--예제6) job_id가 'ST_MAN'인 직원들중 어느 한직원 보다도 급여가 작은 직원들을 출력하라(ANY)

SELECT *
FROM employees
WHERE salary < ANY(SELECT salary
                                            FROM employees
                                            WHERE job_id='ST_MAN')
AND job_id!='ST_MAN';

--예제7) 직책이 'IT_PROG'인 직원들보다 급여가 작은 직원들을 출력하시오.(ALL)

SELECT *
FROM employees
WHERE salary < ALL(SELECT salary
                                            FROM employees
                                            WHERE job_id='IT_PROG');

--예제8) employees 테이블에서 job_id별로 가장 낮은 salary가 얼마인지 찾아보고, 찾아낸 job_id별 salary에 해당하는 직원의
--first_name, job_id, salary, department_id를 출력하시오,(salary 내림차순 정렬)

SELECT first_name, job_id, salary, department_id
FROM employees
WHERE (job_id, salary) IN (SELECT job_id,MIN(salary)
                                            FROM employees
                                            GROUP BY job_id)
ORDER BY salary DESC, job_id;

--예제9) employees 테이블의 department_id 집합과 departments 테이블의 department_id 집합을 UNION연산자를 이용해 합쳐보세요

SELECT department_id
FROM employees
UNION
SELECT department_id
FROM departments;

--예제10) employees 테이블의 department_id 집합과 departments 테이블의 department_id 집합을 UNION ALL연산자를 이용해 합쳐보세요.

SELECT department_id
FROM employees
UNION ALL
SELECT department_id
FROM departments;

--예제11)employees 테이블의 department_id 집합과 departments 테이블의 department_id 집합의 교집합을 INTERSECT연산자를 이용해

SELECT department_id
FROM employees
INTERSECT
SELECT department_id
FROM departments;

--예제12)departments 테이블의 department_id 집합에서 employees 테이블의 department_id 집합을 MINUS연산자를 이용해 빼보세요

SELECT department_id
FROM departments
MINUS
SELECT department_id
FROM employees;

--예제13) departments 테이블에 다음과 같이 각각의 department_id, department_name, manager_id가 200, location_id가 1700인 행을 3개 입력하세요

INSERT INTO departments VALUES(271,'Sample Dept 1',200,1700);
INSERT INTO departments VALUES(272,'Sample Dept 2',200,1700);
INSERT INTO departments VALUES(273,'Sample Dept 3',200,1700);
SELECT * FROM departments;
ROLLBACK;

--예제14)아래와 같이 테이블을 만든 후 SELECT문을 이용하여 departments 테이블 내용을 전부 입력하시오.(위의 scott예제 3번째 방법)
CREATE TABLE copy_departments( department_id number(4,0),
                                                                    department_name varchar2(30 byte),
                                                                    manager_id number(6,0),
                                                                    location_id number(4,0));
INSERT INTO copy_departments
SELECT * FROM departments;

SELECT * FROM copy_departments;
ROLLBACK;

--예제15)departments 테이블의 'Music'부서의 매니저와 location ID를 100, 1800으로 업데이트.
INSERT INTO departments(department_id,department_name)
VALUES (280, 'Music');

UPDATE departments
SET manager_id=100 ,location_id=1800
WHERE department_id=280;

SELECT * FROM departments;
ROLLBACK;

--예제 16) copy_departments 테이블에서 department_id 150부터 200까지 부서번호의 manager_id를 100으로 수정하라.

UPDATE copy_departments
SET manager_id=100
WHERE department_id BETWEEN 150 AND 200;

--예제1)  product_id(number 타입), product_name(varchar2 타입, 20자리), menu_date(date 타입) 열이 있는 sample_product 이름의 테이블을 생성해 보세요.

CREATE TABLE sample_product(
            product_id NUMBER,
            product_name VARCHAR2(20),
            menu_date DATE);
DESCRIBE sample_product;

--예제2) 위에서 만든 테이블을 삭제해 보세요. DESCRIBE 절로 테이블이 잘 삭제되었는지 확인하세요.

DROP TABLE sample_product;

--예제3) members라는 새 테이블을 만듭니다. (제약조건 이름은 생략가능)
컬럼명 : member_id , 데이터타입 : NUMBER , 	크기(byte) :2 , 	제약조건 : P 
컬럼명 : first_name , 	데이터타입 : VARCHAR2 , 	크기(byte) : 50 , 	제약조건 : C(NN) 
컬럼명 : last_name , 	데이터타입 : VARCHAR2 , 	크기(byte) : 50 , 	제약조건 :  C(NN)
컬럼명 : gender , 	데이터타입 : VARCHAR2 , 	크기(byte) : 5 , 	제약조건 : C('MAN' OR 'WOMAN')
컬럼명 : birth_day , 	데이터타입 : DATE , 		크기(byte) : , 	제약조건 : DEFAULT SYSDATE
컬럼명 : email , 	데이터타입 : VARCHAR2 , 	크기(byte) : 200 , 	제약조건 : U, C(NN)

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



--예제4) employees 테이블의 job_id가 'ST_MAN'인 직원들을 새 테이블 stmans를 만들어 입력하라.
--단 테이블의 컬럼 이름은 id, job, sal(직원 테이블의 employee_id, job_id, salary)

CREATE TABLE stmans(id,job,sal)
AS
SELECT employee_id, job_id, salary
FROM employees
WHERE job_id='ST_MAN';

SELECT * FROM stmans;
ROLLBACK;

--예제1)employees 테이블과 emp_details_view 뷰를 조인하여 employee_id가 100인 직원의 
--employee_id, hire_date, department_name, job_title을 출력하세요.(employee_id 컬럼 조인)

SELECT e.employee_id, e.hire_date, v.department_name, v.job_title
FROM employees e
JOIN emp_details_view v
        ON e.employee_id=v.employee_id;

--예제2)MEMBERS 테이블의 first_name과 last_name의 멀티 인덱스를 만들어서 인덱스들의 조회 및 
--성능평가결과를 출력하라

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
SELECT employee_id 직원번호, department_name 부서이름, city 도시
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

--예제1) employees테이블에서 employee_id, first_name, last_name을 출력하세요.

SELECT employee_id, first_name, last_name
FROM employees;

--예제2) employees테이블로부터 first_name, salary, new_salary(salary*1.1)

SELECT first_name, salary, salary*1.1 new_salary
FROM employees;

--예제3) employees테이블에서 employee_id는 '사원번호', first_name은 '이름', last_name은 '성'으로 출력하세요.

SELECT employee_id 사원번호, first_name 이름, last_name 성
FROM employees;

--예제4) employees테이블에서 employee_id를 출력하고, first_name과 last_name을 붙여서 출력하되 가운데 
--한 칸을 띄워주세요. 다음 열에는 email을 출력하되 @company.com 문구를 붙여서 출력하세요.

SELECT employee_id, first_name||' '||last_name name, email||'@company.com' email
FROM employees;

--예제5) employees테이블에서 employee_id가 100인 직원 정보를 출력하세요

SELECT *
FROM employees
WHERE employee_id=100;

--예제6) employees테이블에서 first_name이 David인 직원 정보를 출력하세요.

SELECT *
FROM employees
WHERE first_name='David';

--예제7) employees테이블에서 employee_id가 105이하인

SELECT *
FROM employees
WHERE employee_id<=105;

--예제8) job_history테이블에서 start_date가 2006년 3월 3일 이후인 

SELECT *
FROM job_history
WHERE start_date>TO_DATE('06/03/03');

--예제9) departments테이블에서 location_id가 1700이 아닌 모든 부서를 출력

SELECT *
FROM departments
WHERE location_id!=1700;

--예제10) employees테이블에서 salary>4000, job_id =IT_PROG인 결과 출력

SELECT *
FROM employees
WHERE salary>4000 AND job_id='IT_PROG';

--예제11) employees테이블에서 salary>4000, job_id=IT_PROG OR FI_ACCOUNT

SELECT *
FROM employees
WHERE salary>4000 AND job_id IN('IT_PROG','FI_ACCOUNT');

--예제 12) employees테이블에서 salary가 10000,17000,24000인 직원

SELECT *
FROM employees
WHERE salary IN (10000,17000,24000);

--예제 13) employees테이블에서 department_ID가 30,50,80,100,110이 아닌 직원

SELECT *
FROM employees
WHERE department_id NOT IN (30,50,80,100,110);

--예제 14) employees테이블에서 salary가 10,000 이상이고 20,000 이하인 직원 정보를 출력하세요.

SELECT *
FROM employees
WHERE salary BETWEEN 10000 AND 20000;

--예제 15) employees테이블에서 hire_date가 2004년 1월 1일부터 2004년 12월 30일 사이인

SELECT *
FROM employees
WHERE hire_date BETWEEN TO_DATE('04/01/01') AND TO_DATE('04/12/30');

--예제 16) employees테이블에서 salary가 7000 미만이거나, 17000보다 많은 사원

SELECT *
FROM employees
WHERE salary NOT BETWEEN 7000 AND 17000;

--예제 17)  employees테이블에서 job_id 값이 AD를 포함하는 모든 데이터

SELECT *
FROM employees
WHERE job_id LIKE '%AD%';

--예제 18)  employees테이블에서 job_id 값이 AD를  포함하면서 AD뒤에 따라오는 문자열이 3자리

SELECT *
FROM employees
WHERE job_id LIKE '%AD___';

--예제 19)  employees테이블에서 전화번호 뒷자리가 1234로 끝나는

SELECT *
FROM employees
WHERE phone_number LIKE '%1234';

--예제 20)  employees테이블에서 전화번오에 3이 들어가지 않으면서 전화번호 끝자리가 9로

SELECT *
FROM employees
WHERE phone_number NOT LIKE '%3%' AND phone_number LIKE '%9';

--예제 21)  employees테이블에서 job_id에 MGR을 포함하거나, ASST를 포함하는 직원

SELECT *
FROM employees
WHERE job_id LIKE '%MGR%' OR job_id LIKE '%ASST%';

--예제 22) employees테이블에서 manager_id가 null 값인 직원 -- 사장이다!

SELECT *
FROM employees
WHERE manager_id IS NULL;

--예제 23) employees테이블에서 employee_id, first_name, last_name을 출력, employee_id를 기준으로 내림차순 정렬

SELECT employee_id, first_name, last_name
FROM employees
ORDER BY employee_id DESC;

--예제 24) employees테이블에서 job_id에 CLERK란 단어가 들어가는 직원들의 salary 내림차순 정렬

SELECT *
FROM employees
WHERE job_id LIKE '%CLERK%'
ORDER BY salary DESC;

--예제 25) employees테이블에서 employee_id(직원번호)가 120에서 150번까지 직원을 부서번호(department_id)가 
--큰순으로 정렬, 부서번호가 같다면 월급(salary)이 큰순으로 정렬

SELECT *
FROM employees
WHERE employee_id BETWEEN 120 AND 150
ORDER BY department_id DESC, salary DESC;


--예제 1) employees테이블에서 last_name을 소문자와 대문자로 각각 출력하고, email의 첫번째문자는 대문자로

SELECT last_name, LOWER(last_name), UPPER(last_name), INITCAP(email)
FROM employees;

--예제 2) employees테이블에서 job_id 데이터 값의 첫째자리부터 시작해서 두개의 문자를 출력하세요

SELECT job_id, SUBSTR(job_id,1,2)
FROM employees;

--예제3) employees 테이블에서 salary를 30으로 나눈 후 나눈 값의 결과를 반올림하여 정수,소수점첫째자리,10의자리로

SELECT salary, ROUND(salary/30), ROUND(salary/30,1), ROUND(salary/30,-1)
FROM employees;

--예제4) employees 테이블에서 department_id가 100인 직원에 대해 오늘 날짜, hire_date, 
--오늘날짜와 hire_date사이의 개월수를 출력하세요

SELECT SYSDATE, hire_date, ROUND(MONTHS_BETWEEN(SYSDATE,hire_date))
FROM employees;

--예제5) employees 테이블 에서 employee_id가 100과 105 사이인 직원의 hire_date에 3개월을 더한 값,
 --hire_date에 3개월을 뺀 값을 출력하세요.

SELECT hire_date, ADD_MONTHS(hire_date,3), ADD_MONTHS(hire_date,-3)
FROM employees;

--예제 6) employees 테이블에서 department_id가 100인 사원들의 입사일을 이용하여 아래와 같이 나타내어라.

SELECT  employee_id, TO_CHAR(hire_date, 'MM/YY') 입사월
FROM employees
WHERE department_id=100;

--예제 7) employees 테이블에서 salary가 10000달러가 넘는 사원들의 이름과 월급을 월급이 많은 순으로 나타내어라.

SELECT last_name, TO_CHAR(salary,'$99,999.99')
FROM employees
WHERE salary>10000
ORDER BY salary DESC;

--예제8) employees 테이블에서 아래와같이 이름,월급,커미션을 NVL함수 사용, 연봉은 (월급*12)+(월급*12*커미션)이다.
--예제9) 위의 예제에 더하여 연봉계산은 NVL2 함수를 사용하여 커미션이 있을때와 없을때 계산방법을 나타냅니다.

SELECT last_name, salary, NVL(commission_pct,0), NVL2(commission_pct, salary*12+salary*12*commission_pct, salary*12)
FROM employees
ORDER BY 4 DESC;

--예제10) employees 테이블에서 first_name 과 last_name의 길이 LENGTH를 비교해서 같으면 null값을 아니면
 --LENGTH(first_name)값을 출력하라.



--예제 11) employees 테이블에서 DECODE 함수를 이용해서 월급에 따른 세율을 나타내세요.
--세율 : $0.00~$1,999.99 00%, $2,000.00~$3,999.99 09%, $4,000.00~$5,999.99 20%, $6,000.00~$7,999.99 30%
-- $8,000.00~$9,999.99 40%, $10,000.00~$11,999.99 42%, $12,200.00~$13,999.99 44%, $14,000.00~ 45%



--예제 12) employees 테이블에서 job_id가 IT_PROG라면 employ_id, first_name, last_name, 
--salary를 출력하되 salary가 9000이상이면 '상위급여', 6000과 8999사이면 '중위급여', 그 외는 '하위급여'라고 출력하세요.



--예제1) 부서별 사원수, 최대급여, 최소급여, 급여합계, 평균급여를 급여합계 큰 순으로 조회.



--예제2)부서별,직업별,상사번호별로 그룹을 지어 salary합계와 그룹별 직원의 숫자를 출력하라.



--예제3)부서별로 최고 월급을 뽑아서 평균을 내고, 최저월급 또한 평균을 내어 출력하라.



--예제4) 부서별 평균월급이 10000을 초과하는 직종에 대해서 job_id와 월급여합계를 조회, 
--AC_MGR제외 월급여합계로 내림차순



--예제5) 부서번호 40을 제외한 부서별 평균 급여가 7000 이하인 부서들의 평균 급여를 출력



--예제6) 직종별로 월급의 합계가 13000이상인 직종을 출력하라. 급여총액으로 내림차순정렬, 직종에 REP들어있는 직종 제외



--예제7) 부서별 평균월급이 10000을 초과하는 직종에 대해서 job_id와 월급여합계를 조회, AC_MGR제외 월급여합계로 내림차순



--예제8) 부서번호 40을 제외한 부서별 평균 급여가 7000 이하인 부서들의 평균 급여를 출력



--예제9) 직종별로 월급의 합계가 13000이상인 직종을 출력하라. 급여총액으로 내림차순정렬, 직종에 REP들어있는 직종 제외



--예제 10) 부서명(department_name),시티명(city),국가명(country_name)을 나타내는 테이블을 출력합니다. 
--테이블들은 countries와 departments와 locations를 조인합니다. 
--조건은, 시티가 'Seattle' 혹은 'London'이어야 하고 국가명은 앞쪽에 'United'가 들어가야 합니다.



--예제 1) countries, locations 테이블을 조인하여 아래와 같이 출력하시오.(지역번호로 DESC 정렬)
*


--예제2)countries, regions 테이블을 크로스 조인하여 아래와 같이 각각의 테이블의 25행x4행 =>100행의 결과가 나오도록 하세요.



--예제3) departments 테이블에 있는 manager_id와 employees 테이블의 employee_id를 이용하여 조인하여 부서명,매니저번호,매니저이름,전화번호를 나타내이러ㅏ



--예제4) 조인을 이용하여 사원들의 직우너번호(employee_id),고용일자(hire_date), 직종(job_id), 직책(job_title)을 출력하시오.



--예제5) job_title이 'Sales Manager'인 사원들의 입사년도 그룹 별 평균 급여를 출력하시오, 입사년도를 기준으로 오름차순 정렬, (jobs 테이블과 조인 job_id를 이용)



--예제6) 각각의 도시에 있는 모든 부서직원들의 평균급여를 조회하고자 한다. 평균급여가 가장 낮은 도시부터 도시명,평균연봉,해당도시의 직원수를 출력하시오, 단,도시에 근무하는 직원이 10명이상인 곳은 제외하고 조회하시오.



--예제7) 자신의 매니저보다 급여를 많이 받는 직원들의 성, 급여와 매니저의 성,급여를 출력하라



--예제1)사원 'Abel'(last_name)보다 급여가 많은 사원의 last_name, salary를 나타내어라(서브쿼리 사용)



--예제2) 'Bull'이란 last_name을 가진 사원의 부서에서 Bull보다 높은 급여를 받는 사원들을 출력하라(서브쿼리사용)



--예제3)'Russell'이란 last_name의 직원 번호를 manager_id로 가지는 직원들의 last_name, salary, manager_id를 출력



--예제4)jobs 테이블에 job_title이 'Stock Manager'의 job_id를 가진 직원들의 정보를 Employees테이블에서 찾아서 출력



--예제5) 부서번호(department_id)가 20번인 직원들의 매니저아이디(manager_id)와 같은 매니저를 가지는 직원들을 출력
--(단, 20번 부서의 직원은 제외!)



--예제6) job_id가 'ST_MAN'인 직원들중 어느 한직원 보다도 급여가 작은 직원들을 출력하라(ANY)



--예제7) 직책이 'IT_PROG'인 직원들보다 급여가 작은 직원들을 출력하시오.(ALL)



--예제8) employees 테이블에서 job_id별로 가장 낮은 salary가 얼마인지 찾아보고, 찾아낸 job_id별 salary에 해당하는 직원의
--first_name, job_id, salary, department_id를 출력하시오,(salary 내림차순 정렬)



--예제9) employees 테이블의 department_id 집합과 departments 테이블의 department_id 집합을 UNION연산자를 이용해 합쳐보세요



--예제10) employees 테이블의 department_id 집합과 departments 테이블의 department_id 집합을 UNION ALL연산자를 이용해 합쳐보세요.



--예제11)employees 테이블의 department_id 집합과 departments 테이블의 department_id 집합의 교집합을 INTERSECT연산자를 이용해



--예제12)departments 테이블의 department_id 집합에서 employees 테이블의 department_id 집합을 MINUS연산자를 이용해 빼보세요



--예제13) departments 테이블에 다음과 같이 각각의 department_id, department_name, manager_id가 200, location_id가 1700인 행을 3개 입력하세요



--예제14)아래와 같이 테이블을 만든 후 SELECT문을 이용하여 departments 테이블 내용을 전부 입력하시오.(위의 scott예제 3번째 방법)
CREATE TABLE copy_departments( department_id number(4,0),
                                                                    department_name varchar2(30 byte),
                                                                    manager_id number(6,0),
                                                                    location_id number(4,0));



--예제15)departments 테이블의 'Music'부서의 매니저와 location ID를 100, 1800으로 업데이트.
INSERT INTO departments(department_id,department_name)
VALUES (280, 'Music');



--예제 16) copy_departments 테이블에서 department_id 150부터 200까지 부서번호의 manager_id를 100으로 수정하라.




--예제1)  product_id(number 타입), product_name(varchar2 타입, 20자리), menu_date(date 타입) 열이 있는 sample_product 이름의 테이블을 생성해 보세요.



--예제2) 위에서 만든 테이블을 삭제해 보세요. DESCRIBE 절로 테이블이 잘 삭제되었는지 확인하세요.


--예제3) members라는 새 테이블을 만듭니다. (제약조건 이름은 생략가능)
컬럼명 : member_id , 데이터타입 : NUMBER , 	크기(byte) :2 , 	제약조건 : P 
컬럼명 : first_name , 	데이터타입 : VARCHAR2 , 	크기(byte) : 50 , 	제약조건 : C(NN) 
컬럼명 : last_name , 	데이터타입 : VARCHAR2 , 	크기(byte) : 50 , 	제약조건 :  C(NN)
컬럼명 : gender , 	데이터타입 : VARCHAR2 , 	크기(byte) : 5 , 	제약조건 : C('MAN' OR 'WOMAN')
컬럼명 : birth_day , 	데이터타입 : DATE , 		크기(byte) : , 	제약조건 : DEFAULT SYSDATE
컬럼명 : email , 	데이터타입 : VARCHAR2 , 	크기(byte) : 200 , 	제약조건 : U, C(NN)





--예제4) employees 테이블의 job_id가 'ST_MAN'인 직원들을 새 테이블 stmans를 만들어 입력하라.
--단 테이블의 컬럼 이름은 id, job, sal(직원 테이블의 employee_id, job_id, salary)




--예제1)employees 테이블과 emp_details_view 뷰를 조인하여 employee_id가 100인 직원의 
--employee_id, hire_date, department_name, job_title을 출력하세요.(employee_id 컬럼 조인)




--예제2)MEMBERS 테이블의 first_name과 last_name의 멀티 인덱스를 만들어서 인덱스들의 조회 및 
--성능평가결과를 출력하라














