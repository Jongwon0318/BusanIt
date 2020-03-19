--����1)�μ���ȣ�� 10���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶�.

SELECT empno, ename, sal
FROM emp
WHERE deptno=10;


--����2)�����ȣ�� 7369�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����϶�.

SELECT ename,hiredate,deptno
FROM emp
WHERE empno=7369;

--����3)�̸��� ALLEN�� ����� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename='ALLEN';

--����4)�Ի����� 81/02/20�� ����� �̸�, �μ���ȣ, ������ ����϶�.

SELECT ename,deptno,sal
FROM emp
WHERE hiredate=TO_DATE('81/02/20');

--����5) ������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.job!='MANAGER';

--����6) �Ի����� 81/04/02 ���Ŀ� �Ի��� ����� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE hiredate>TO_DATE('81/04/02');

--����7) �޿��� $800�̻��� ����� �̸�,�޿�,�μ���ȣ�� ����϶�.

SELECT ename,sal,deptno
FROM emp
WHERE sal>=800;

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
WHERE e.ename > 'L%';

--���� 10) �Ի����� 81/12/09���� ���� �Ի��� ������� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.hiredate<TO_DATE('81/12/09');

--���� 11)������ȣ�� 7698���� �۰ų� ���� ������� ������ȣ�� �̸��� ����϶�.

SELECT empno, ename
FROM emp
WHERE empno<=7698;

--���� 12)�Ի����� 81/04/02 ���� ���ų� �ʰ� 82/12/09���� ���ų� ���� ����� �̸�,����,�μ���ȣ�� ����϶�.

SELECT ename, sal, deptno
FROM emp
WHERE hiredate BETWEEN TO_DATE('81/04/02') AND TO_DATE('82/12/09');

--���� 13)�޿��� $1,600���� ũ�� $3,000���� ���� ������ �̸�,����,�޿��� ����϶�.

SELECT ename, job, sal
FROM emp
WHERE sal > 1600 AND sal<3000;

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
WHERE e.ename > 'B%' AND e.ename<'J%';

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
WHERE e.job='MANAGER' OR e.job='SALESMAN';

--���� 18)�μ���ȣ�� 20, 30���� ������ ��� ������ �̸�,�����ȣ,�μ���ȣ�� ����϶�.

SELECT ename, empno, deptno
FROM emp
WHERE deptno!=20 AND deptno!=30;

--���� 19)�̸��� S�� �����ϴ� ������ �����ȣ,�̸�,�Ի���,�μ���ȣ�� ����϶�.

SELECT empno,ename,hiredate,deptno
FROM emp
WHERE ename LIKE 'S%';

--���� 20)�Ի����� 81�⵵�� ����� ��� ������ ����϶�

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.hiredate BETWEEN '81/01/01' AND '81/12/31';

--���� 21)�̸� �� S�ڰ� �� �մ� ����� ��� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename LIKE '%S%';

--���� 22) �̸��� M�ڷ� �����ϰ� ������ ���ڰ� N�� ����� ��� ������ ����϶�.(��,�̸��� ��ü 6�ڸ��̴�, �ڸ����� �̿��� ���ϵ�ī�� _�� �̿�)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename LIKE 'M____N';

--���� 23) �̸��� ù��° ���ڴ� �������, �ι�° ���ڰ� A�� ����� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename LIKE '_A%';

--���� 24) Ŀ�̼��� NULL�� ����� ������ ����϶�. (IS NULL �Ǵ� IS NOT NULL ���)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.comm IS NULL;

--���� 25) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����϶�.(IS NULL �Ǵ� IS NOT NULL ���)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.comm IS NOT NULL;

--���� 26) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�,�μ�,������ ����϶�.

SELECT e.ename, d.dname, e.sal
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno=30 AND sal>=1500;

--���� 27) �̸��� ù ���ڰ� K�� �����ϰų� �μ���ȣ�� 30�� ����� �����ȣ,�̸�,�μ���ȣ�� ����϶�.

SELECT empno, ename, deptno
FROM emp
WHERE ename LIKE 'K%' OR deptno=30;

--���� 28) �޿��� $1.500 �̻��̰� �μ���ȣ�� 30���� ��� �� ������ MANAGER�� ����� ������ ����϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.sal>=1500 AND e.deptno=30 AND e.job='MANAGER';

--���� 29) �μ���ȣ�� 30�� ����� ��� ������ ����ϰ� ������ȣ�� SORT(����)�϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno =30
ORDER BY e.empno;

--���� 30) �������� �޿��� ���� ������ SORT(����) �϶�.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
ORDER BY e.sal DESC;

--���� 31) �μ���ȣ�� ASCENDING SORT�� �� �޿��� ���� ��� ������ ����϶�

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
ORDER BY e.deptno ASC,e.sal DESC;

--���� 32) �μ���ȣ�� DESCENDING SORT�ϰ�, �̸������� ����, �޿������� ��������

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
ORDER BY e.deptno DESC, e.ename ASC, e.sal DESC;

--���� 33) 10���μ� ������� 13%���ʽ� �̸�,�޿�,���ʽ�,�μ���ȣ ���

SELECT ename, sal, TRUNC(sal*0.13) BONUS, deptno
FROM emp
WHERE deptno=10;

--���� 34) �̸�,�޿�,Ŀ�̼�,�Ѿ�(�޿�+Ŀ�̼�)�� ���Ͽ� �Ѿ��� ���� ������ ���

SELECT ename, sal, NVL(comm,0), NVL2(comm, sal+comm, sal) �Ѿ�
FROM emp
ORDER BY 4 DESC;

--���� 35) �޿��� 1500~3000���� ����� ���ؼ��� �޿� 15%ȸ�� ����, �̸�,�޿�,ȸ��(�Ҽ�2�ڸ��ݿø�)
--ȸ�� $, �Ҽ��� 1�ڸ�

SELECT ename, sal, TO_CHAR(ROUND(sal*0.15,2),'$99,999.9') ȸ��
FROM emp
WHERE sal BETWEEN 1500 AND 3000;

--���� 36)������� 5���� �Ѵ� �μ��� �μ���� ����� ��ȸ

SELECT d.dname, COUNT(*)
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
GROUP BY d.dname
HAVING COUNT(*)>5;

--���� 37)������ �޿��հ谡 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �� �޿� �հ踦 ��ȸ, 
--�� �Ǹſ�('SALESMAN')�� �����ϰ� �� �޿� �հ�� �������� ����

SELECT job, SUM(sal)
FROM emp
WHERE job!='SALESMAN'
GROUP BY job
HAVING SUM(sal)>5000
ORDER BY 2 DESC;

--���� 38)������� �����ȣ(empno), �����(ename), �޿�(sal), �޿����(grade)�� ����Ͻÿ�. ���̺� salgrade ����

SELECT e.empno, e.ename,e.sal,s.grade
FROM emp e
JOIN salgrade s 
        ON e.sal BETWEEN losal AND hisal;

--���� 39) �μ���(deptno)�� ����� ���� Ŀ�̼�(comm)�� ���� ����� ���� ����Ͽ� ���ÿ�.

SELECT deptno, COUNT(*)
FROM emp
WHERE comm IS NOT NULL
GROUP BY deptno;


--���� 40) �μ���ȣ(deptno)�� 10�� '�ѹ���', 20�� '���ߺ�', 30�� '������'��� �Ͽ� �̸�,�μ���ȣ,�μ��� ������ ����Ͽ� ���ÿ�.

SELECT ename, deptno,
            DECODE(deptno, 10, '�ѹ���',
                                            20, '���ߺ�',
                                            30, '������',
                                            '�μ�����') "�μ���"
FROM emp;
