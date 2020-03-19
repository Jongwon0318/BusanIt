SELECT e.last_name ����, e.department_id �μ���ȣ, d.department_name �μ���
FROM employees e
LEFT OUTER JOIN departments d
        ON e.department_id = d.department_id;

SELECT e.last_name ����, d.department_id �μ���ȣ, d.department_name �μ���
FROM employees e
RIGHT OUTER JOIN departments d
        ON e.department_id = d.department_id;

SELECT e.last_name ����, e.department_id �μ���ȣ, d.department_name �μ���
FROM employees e
FULL OUTER JOIN departments d
        ON e.department_id=d.department_id;

--���� 1) countries, locations ���̺��� �����Ͽ� �Ʒ��� ���� ����Ͻÿ�.(������ȣ�� DESC ����)

SELECT c.country_name, c.country_id, l.location_id, l.city
FROM countries c
FULL OUTER JOIN locations l
        ON c.country_id=l.country_id
ORDER BY 3 DESC;

--����2)countries, regions ���̺��� ũ�ν� �����Ͽ� �Ʒ��� ���� ������ ���̺��� 25��x4�� =>100���� ����� �������� �ϼ���.

SELECT c.country_name, r.region_name
FROM countries c
CROSS JOIN regions r
ORDER BY c.country_name, r.region_name;

--����3) departments ���̺� �ִ� manager_id�� employees ���̺��� employee_id�� �̿��Ͽ� �����Ͽ� �μ���,�Ŵ�����ȣ,�Ŵ����̸�,��ȭ��ȣ�� ��Ÿ���̷���

SELECT d.department_name, d.manager_id, e.last_name||' '||e.first_name, e.phone_number
FROM departments d
JOIN employees e
        ON d.manager_id=e.employee_id;

--����4) ������ �̿��Ͽ� ������� ������ȣ(employee_id),�������(hire_date), ����(job_id), ��å(job_title)�� ����Ͻÿ�.

SELECT e.employee_id, e.hire_date, j.job_id, j.job_title
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id;

--����5) job_title�� 'Sales Manager'�� ������� �Ի�⵵ �׷� �� ��� �޿��� ����Ͻÿ�, �Ի�⵵�� �������� �������� ����, (jobs ���̺�� ���� job_id�� �̿�)

SELECT TO_CHAR(e.hire_date, 'YYYY') AS �Ի�⵵, AVG(e.salary) AS ��ձ޿�
FROM employees e
JOIN jobs j
        ON e.job_id=j.job_id
WHERE j.job_title='Sales Manager'
GROUP BY TO_CHAR(hire_date, 'YYYY')
ORDER BY 1 ASC;

--����6) ������ ���ÿ� �ִ� ��� �μ��������� ��ձ޿��� ��ȸ�ϰ��� �Ѵ�. ��ձ޿��� ���� ���� ���ú��� ���ø�,��տ���,�ش絵���� �������� ����Ͻÿ�, ��,���ÿ� �ٹ��ϴ� ������ 10���̻��� ���� �����ϰ� ��ȸ�Ͻÿ�.

SELECT l.city ���ø�, ROUND(AVG(e.salary)) ��ձ޿� , COUNT(*) �ο���
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

--����7) �ڽ��� �Ŵ������� �޿��� ���� �޴� �������� ��, �޿��� �Ŵ����� ��,�޿��� ����϶�

SELECT e.employee_id, e.last_name||' '||e.first_name �����̸� , e.salary �����޿�, m.last_name||' '||m.first_name �Ŵ����̸�, m.salary �Ŵ����޿�
FROM employees e
JOIN employees m
        ON e.manager_id=m.employee_id
WHERE e.salary>m.salary;