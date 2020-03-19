SELECT last_name, salary
FROM employees
WHERE salary > (SELECT salary
                                    FROM employees
                                    WHERE last_name='Abel');

SELECT last_name, salary
FROM employees
WHERE salary >(SELECT salary
                                FROM employees
                                WHERE last_name='Bull')
AND department_id = (SELECT department_id
                                            FROM employees
                                            WHERE last_name='Bull');

SELECT last_name, salary, manager_id
FROM employees
WHERE manager_id=(SELECT employee_id
                                            FROM employees
                                            WHERE last_name='Russell');

SELECT *
FROM employees
WHERE job_id=(SELECT job_id
                                FROM jobs
                                WHERE job_title='Stock Manager');
                                
SELECT *
FROM employees
WHERE manager_id IN (SELECT manager_id
                                            FROM employees
                                            WHERE department_id=20)
AND department_id!=20;

SELECT *
FROM employees
WHERE salary < ANY(SELECT salary
                                            FROM employees
                                            WHERE job_id='ST_MAN')
AND job_id!='ST_MAN';

SELECT *
FROM employees
WHERE salary < ALL(SELECT salary
                                            FROM employees
                                            WHERE job_id='IT_PROG');

SELECT first_name, job_id, salary, department_id
FROM employees
WHERE (job_id,salary) IN (SELECT job_id,MIN(salary)
                                    FROM employees
                                    GROUP BY job_id)
ORDER BY salary DESC;

SELECT department_id
FROM departments
MINUS
SELECT department_id
FROM employees;

DROP TABLE copy_departments;

commit;

CREATE TABLE copy_departments(department_id number(4,0),
                                                                    department_name varchar2(30byte),
                                                                    manager_id number(6,0),
                                                                    location_id number(4,0));

INSERT INTO departments
VALUES (271, 'Sample Dept 1',200,1700);

INSERT INTO departments
VALUES (272, 'Sample Dept 2',200,1700);

INSERT INTO departments
VALUES (273, 'Sample Dept 3',200,1700);

SELECT *
FROM departments;

DELETE FROM departments
WHERE department_id BETWEEN 271 AND 273;

ROLLBACK;
COMMIT;