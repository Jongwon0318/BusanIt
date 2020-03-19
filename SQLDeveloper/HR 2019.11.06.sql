SELECT e.last_name 직원, e.department_id 부서번호, d.department_name 부서명
FROM employees e
LEFT OUTER JOIN departments d
        ON e.department_id = d.department_id;

SELECT e.last_name 직원, d.department_id 부서번호, d.department_name 부서명
FROM employees e
RIGHT OUTER JOIN departments d
        ON e.department_id = d.department_id;

SELECT e.last_name 직원, e.department_id 부서번호, d.department_name 부서명
FROM employees e
FULL OUTER JOIN departments d
        ON e.department_id=d.department_id;

--예제 1) countries, locations 테이블을 조인하여 아래와 같이 출력하시오.(지역번호로 DESC 정렬)

SELECT c.country_name, c.country_id, l.location_id, l.city
FROM countries c
FULL OUTER JOIN locations l
        ON c.country_id=l.country_id
ORDER BY 3 DESC;

--예제2)countries, regions 테이블을 크로스 조인하여 아래와 같이 각각의 테이블의 25행x4행 =>100행의 결과가 나오도록 하세요.

SELECT c.country_name, r.region_name
FROM countries c
CROSS JOIN regions r
ORDER BY c.country_name, r.region_name;

--예제3) departments 테이블에 있는 manager_id와 employees 테이블의 employee_id를 이용하여 조인하여 부서명,매니저번호,매니저이름,전화번호를 나타내이러ㅏ

SELECT d.department_name, d.manager_id, e.last_name||' '||e.first_name, e.phone_number
FROM departments d
JOIN employees e
        ON d.manager_id=e.employee_id;

--예제4) 조인을 이용하여 사원들의 직원번호(employee_id),고용일자(hire_date), 직종(job_id), 직책(job_title)을 출력하시오.

SELECT e.employee_id, e.hire_date, j.job_id, j.job_title
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id;

--예제5) job_title이 'Sales Manager'인 사원들의 입사년도 그룹 별 평균 급여를 출력하시오, 입사년도를 기준으로 오름차순 정렬, (jobs 테이블과 조인 job_id를 이용)

SELECT TO_CHAR(e.hire_date, 'YYYY') AS 입사년도, AVG(e.salary) AS 평균급여
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id
WHERE j.job_title='Sales Manager'
GROUP BY TO_CHAR(hire_date, 'YYYY')
ORDER BY 1 ASC;

--예제6) 각각의 도시에 있는 모든 부서직원들의 평균급여를 조회하고자 한다. 평균급여가 가장 낮은 도시부터 도시명,평균연봉,해당도시의 직원수를 출력하시오, 단,도시에 근무하는 직원이 10명이상인 곳은 제외하고 조회하시오.

SELECT l.city 도시명, ROUND(AVG(e.salary)) 평균급여 , COUNT(*) 인원수
FROM employees e
JOIN departments d
        ON d.department_id=e.department_id 
        --ON d.manager_id=e.manager_id
JOIN locations l
        ON l.location_id=d.location_id
GROUP BY l.city
HAVING COUNT(*)<10
ORDER BY 2 ASC;

SELECT *
FROM employees e
JOIN departments d
        ON d.manager_id=e.employee_id
JOIN locations l
        ON l.location_id=d.location_id;

SELECT *
FROM employees e
JOIN departments d
        ON d.department_id=e.department_id
JOIN locations l
        ON l.location_id=d.location_id;

SELECT COUNT(manager_id)
FROM departments;

SELECT COUNT(department_id)
FROM departments;

--예제7) 자신의 매니저보다 급여를 많이 받는 직원들의 성, 급여와 매니저의 성,급여를 출력하라

SELECT e.employee_id, e.last_name||' '||e.first_name 직원이름 , e.salary 직원급여, m.last_name||' '||m.first_name 매니저이름, m.salary 매니저급여
FROM employees e
JOIN employees m
        ON e.manager_id=m.employee_id
WHERE e.salary>m.salary;