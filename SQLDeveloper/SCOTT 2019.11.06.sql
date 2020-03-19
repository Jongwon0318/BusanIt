--����1)�μ���ȣ�� 10���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶�.

SELECT empno, ename, sal
FROM emp
WHERE deptno=10;

--����2)�����ȣ�� 7369�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����϶�.

SELECT ename, hiredate, deptno
FROM emp
WHERE empno=7369;

--����3)�̸��� ALLEN�� ����� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN DEPT d
        ON e.deptno=d.deptno
WHERE ename='ALLEN';

--����4)�Ի����� 81/02/20�� ����� �̸�, �μ���ȣ, ������ ����϶�.

SELECT ename, deptno, sal
FROM emp
WHERE hiredate='81/02/20';

--����5) ������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE job!='MANAGER';

--����6) �Ի����� 81/04/02 ���Ŀ� �Ի��� ����� ������ ����϶�.

SELECT *
FROM emp
WHERE hiredate>'81/04/02';

--����7) �޿��� $800�̻��� ����� �̸�,�޿�,�μ���ȣ�� ����϶�.

SELECT ename, sal, deptno
FROM emp
WHERE sal>800;

--����8) �μ���ȣ�� 20�� �̻��� ����� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno>=20;

--����9) �̸��� K�� �����ϴ� ������� ���� �̸��� ���� ����� ��� ������ ����϶�(���ڿ� �񱳽� ���ĺ������� ö�� ��)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename>'L';

--���� 10) �Ի����� 81/12/09���� ���� �Ի��� ������� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE hiredate<'81/12/09';

--���� 11)������ȣ�� 7698���� �۰ų� ���� ������� ������ȣ�� �̸��� ����϶�.

SELECT empno, ename
FROM emp
WHERE empno<=7698;

--���� 12)�Ի����� 81/04/02 ���� ���ų� �ʰ� 82/12/09���� ���ų� ���� ����� �̸�,����,�μ���ȣ�� ����϶�.

SELECT ename, sal, deptno
FROM emp
WHERE hiredate BETWEEN '81/04/02'AND'82/12/09';

--���� 13)�޿��� $1,600���� ũ�� $3,000���� ���� ������ �̸�,����,�޿��� ����϶�.

SELECT ename, job, sal
FROM emp
WHERE sal!=1600 AND sal!=3000 AND sal BETWEEN 1600 AND 3000;

--���� 14)������ȣ�� 7654�� 7782 ���� �̿��� ������ ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.empno NOT BETWEEN 7654 AND 7782;

--���� 15)�̸��� B�� J ������ ��� ������ ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE ename BETWEEN 'B%' AND 'J%';

--���� 16)�Ի����� 81�� �̿ܿ� �Ի��� ������ ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE hiredate NOT BETWEEN '81/01/01' AND '81/12/31';

--���� 17)������ MANAGER�̰ų� SALESMAN�� ������ ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE job='MANAGER' OR job='SALESMAN' ;

--���� 18)�μ���ȣ�� 20, 30���� ������ ��� ������ �̸�,�����ȣ,�μ���ȣ�� ����϶�.

SELECT ename, empno, deptno
FROM emp
WHERE deptno!=20 OR deptno!=30;

--���� 19)�̸��� S�� �����ϴ� ������ �����ȣ,�̸�,�Ի���,�μ���ȣ�� ����϶�.

SELECT empno, ename, hiredate, deptno
FROM emp
WHERE ename LIKE 'S%';

--���� 20)�Ի����� 81�⵵�� ����� ��� ������ ����϶�

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE hiredate BETWEEN '81/01/01' AND '81/12/31';

--���� 21)�̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE ename LIKE '%S%';

--���� 22) �̸��� M�ڷ� �����ϰ� ������ ���ڰ� N�� ����� ��� ������ ����϶�.(��,�̸��� ��ü 6�ڸ��̴�, �ڸ����� �̿��� ���ϵ�ī�� _�� �̿�)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE ename LIKE 'M____N';

--���� 23) �̸��� ù��° ���ڴ� �������, �ι�° ���ڰ� A�� ����� ������ ����϶�.

SELECT *
FROM emp
WHERE ename LIKE '_A%';

--���� 24) Ŀ�̼��� NULL�� ����� ������ ����϶�. (IS NULL �Ǵ� IS NOT NULL ���)

SELECT *
FROM emp
WHERE comm IS NULL;

--���� 25) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����϶�.(IS NULL �Ǵ� IS NOT NULL ���)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE comm IS NOT NULL;

--���� 26) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�,�μ�,������ ����϶�.

SELECT e.ename, d.deptno, d.dname, e.sal
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno=30 AND e.sal>=1500;

--���� 27) �̸��� ù ���ڰ� K�� �����ϰų� �μ���ȣ�� 30�� ����� �����ȣ,�̸�,�μ���ȣ�� ����϶�.

SELECT empno, ename, deptno
FROM emp
WHERE ename LIKE 'K%' OR deptno=30;

--���� 28) �޿��� $1.500 �̻��̰� �μ���ȣ�� 30���� ��� �� ������ MANAGER�� ����� ������ ����϶�.

SELECT *
FROM emp
WHERE sal>=1500 AND deptno=30 AND job='MANAGER';

--���� 29) �μ���ȣ�� 30�� ����� ��� ������ ����ϰ� ������ȣ�� SORT(����)�϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno=30
ORDER BY e.empno;

--���� 30) �������� �޿��� ���� ������ SORT(����) �϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
ORDER BY e.sal DESC;

--���� 31) �μ���ȣ�� ASCENDING SORT�� �� �޿��� ���� ��� ������ ����϶�

SELECT *
FROM emp
ORDER BY deptno ASC, sal DESC;

--���� 32) �μ���ȣ�� DESCENDING SORT�ϰ�, �̸������� ����, �޿������� ��������

SELECT *
FROM emp
ORDER BY deptno DESC, ename ASC, sal DESC;

--���� 33) 10���μ� ������� 13%���ʽ� �̸�,�޿�,���ʽ�,�μ���ȣ ���

SELECT ename, sal, sal*0.13 AS bonus, deptno
FROM emp
WHERE deptno=10;

--���� 34) �̸�,�޿�,Ŀ�̼�,�Ѿ�(�޿�+Ŀ�̼�)�� ���Ͽ� �Ѿ��� ���� ������ ���

SELECT ename, sal, NVL(comm,0) AS Ŀ�̼�, NVL2(comm, sal+comm, sal) AS �Ѿ�
FROM emp
ORDER BY 4 DESC;

--���� 35) �޿��� 1500~3000���� ����� ���ؼ��� �޿� 15%ȸ�� ����, �̸�,�޿�,ȸ��(�Ҽ�2�ڸ��ݿø�)
--ȸ�� $, �Ҽ��� 1�ڸ�

SELECT ename, sal, TO_CHAR(ROUND(sal*0.15,1), '$999.9') AS ȸ��
FROM emp
WHERE sal BETWEEN 1500 AND 3000;

--���� 36)������� 5���� �Ѵ� �μ��� �μ���� ����� ��ȸ

SELECT d.dname, COUNT(e.empno)  --�⺻Ű�� null�� Ȥ�� �ߺ��� �� �� ����.
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
GROUP BY d.dname
HAVING COUNT(e.empno)>5;

--���� 37)������ �޿��հ谡 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �� �޿� �հ踦 ��ȸ, 
--�� �Ǹſ�('SALESMAN')�� �����ϰ� �� �޿� �հ�� �������� ����

SELECT job, SUM(sal)
FROM emp
WHERE job!='SALESMAN'
GROUP BY job
HAVING SUM(sal)>5000
ORDER BY 2 DESC;

--���� 38)������� �����ȣ(empno), �����(ename), �޿�(sal), �޿����(grade)�� ����Ͻÿ�. 
--���̺� salgrade ����

SELECT e.empno, e.ename, e.sal, s.grade
FROM emp e 
JOIN salgrade s  
ON e.sal BETWEEN s.losal AND s.hisal;

--���� 39) �μ���(deptno)�� ����� ���� Ŀ�̼�(comm)�� ���� ����� ���� ����Ͽ� ���ÿ�.

SELECT deptno, COUNT(*),  COUNT(comm)
FROM emp
GROUP BY deptno;

--���� 40) �μ���ȣ(deptno)�� 10�� '�ѹ���', 20�� '���ߺ�', 30�� '������'��� �Ͽ� �̸�,�μ���ȣ,�μ��� ������ ����Ͽ� ���ÿ�.

SELECT ename, deptno,
    DECODE (deptno,  10, '�ѹ���',
                                    20, '���ߺ�',
                                    30, '������'
                                    ) "�μ���"
FROM emp;

SELECT ename,
                deptno,
                CASE WHEN deptno>=30 THEN '������'
                            WHEN deptno>=20 THEN '���ߺ�'
                            ELSE '�ѹ���'
                            END "�μ���"
FROM emp
ORDER BY deptno;
