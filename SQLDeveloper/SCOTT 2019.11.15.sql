--문제1)부서번호가 10번인 부서의 사람 중 사원번호, 이름, 월급을 출력하라.

SELECT empno, ename, sal
FROM emp
WHERE deptno=10;


--문제2)사원번호가 7369인 사람 중 이름, 입사일, 부서번호를 출력하라.

SELECT ename,hiredate,deptno
FROM emp
WHERE empno=7369;

--문제3)이름이 ALLEN인 사람의 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename='ALLEN';

--문제4)입사일이 81/02/20인 사원의 이름, 부서번호, 월급을 출력하라.

SELECT ename,deptno,sal
FROM emp
WHERE hiredate=TO_DATE('81/02/20');

--문제5) 직업이 MANAGER가 아닌 사람의 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.job!='MANAGER';

--문제6) 입사일이 81/04/02 이후에 입사한 사원의 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE hiredate>TO_DATE('81/04/02');

--문제7) 급여가 $800이상인 사람의 이름,급여,부서번호를 출력하라.

SELECT ename,sal,deptno
FROM emp
WHERE sal>=800;

--문제8) 부서번호가 20번 이상인 사원의 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno>=20;

--문제9) 이름이 K로 시작하는 사람보다 높은 이름을 가진 사람의 모든 정보를 출력하라(문자열 비교시 알파벳순으로 철자 비교)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename > 'L%';

--문제 10) 입사일이 81/12/09보다 먼저 입사한 사람들의 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.hiredate<TO_DATE('81/12/09');

--문제 11)직원번호가 7698보다 작거나 같은 사람들의 직원번호와 이름을 출력하라.

SELECT empno, ename
FROM emp
WHERE empno<=7698;

--문제 12)입사일이 81/04/02 보다 같거나 늦고 82/12/09보다 같거나 빠른 사원의 이름,월급,부서번호를 출력하라.

SELECT ename, sal, deptno
FROM emp
WHERE hiredate BETWEEN TO_DATE('81/04/02') AND TO_DATE('82/12/09');

--문제 13)급여가 $1,600보다 크고 $3,000보다 작은 직원의 이름,직업,급여를 출력하라.

SELECT ename, job, sal
FROM emp
WHERE sal > 1600 AND sal<3000;

--문제 14)직원번호가 7654와 7782 사이 이외의 직원의 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.empno NOT BETWEEN 7654 AND 7782;

--문제 15)이름이 B와 J 사이의 모든 직원의 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename > 'B%' AND e.ename<'J%';

--문제 16)입사일이 81년 이외에 입사한 직원의 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE hiredate NOT BETWEEN '81/01/01' AND '81/12/31';

--문제 17)직업이 MANAGER이거나 SALESMAN인 직원의 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.job='MANAGER' OR e.job='SALESMAN';

--문제 18)부서번호가 20, 30번을 제외한 모든 직원의 이름,사원번호,부서번호를 출력하라.

SELECT ename, empno, deptno
FROM emp
WHERE deptno!=20 AND deptno!=30;

--문제 19)이름이 S로 시작하는 직원의 사원번호,이름,입사일,부서번호를 출력하라.

SELECT empno,ename,hiredate,deptno
FROM emp
WHERE ename LIKE 'S%';

--문제 20)입사일이 81년도인 사람의 모든 정보를 출력하라

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.hiredate BETWEEN '81/01/01' AND '81/12/31';

--문제 21)이름 중 S자가 들어가 잇는 사람만 모든 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename LIKE '%S%';

--문제 22) 이름이 M자로 시작하고 마지막 글자가 N인 사람의 모든 정보를 출력하라.(단,이름은 전체 6자리이다, 자리수를 이용한 와일드카드 _를 이용)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename LIKE 'M____N';

--문제 23) 이름의 첫번째 문자는 관계없고, 두번째 문자가 A인 사람의 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.ename LIKE '_A%';

--문제 24) 커미션이 NULL인 사람의 정보를 출력하라. (IS NULL 또는 IS NOT NULL 사용)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.comm IS NULL;

--문제 25) 커미션이 NULL이 아닌 사람의 모든 정보를 출력하라.(IS NULL 또는 IS NOT NULL 사용)

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.comm IS NOT NULL;

--문제 26) 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름,부서,월급을 출력하라.

SELECT e.ename, d.dname, e.sal
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno=30 AND sal>=1500;

--문제 27) 이름의 첫 글자가 K로 시작하거나 부서번호가 30인 사람의 사원번호,이름,부서번호를 출력하라.

SELECT empno, ename, deptno
FROM emp
WHERE ename LIKE 'K%' OR deptno=30;

--문제 28) 급여가 $1.500 이상이고 부서번호가 30번인 사원 중 직업이 MANAGER인 사람의 정보를 출력하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.sal>=1500 AND e.deptno=30 AND e.job='MANAGER';

--문제 29) 부서번호가 30인 사람의 모든 정보를 출력하고 직원번호로 SORT(정렬)하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
WHERE e.deptno =30
ORDER BY e.empno;

--문제 30) 직원들의 급여가 많은 순으로 SORT(정렬) 하라.

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
ORDER BY e.sal DESC;

--문제 31) 부서번호로 ASCENDING SORT한 후 급여가 많은 사람 순으로 출력하라

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
ORDER BY e.deptno ASC,e.sal DESC;

--문제 32) 부서번호가 DESCENDING SORT하고, 이름순으로 오름, 급여순으로 내림차순

SELECT e.*, d.dname, d.loc
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
ORDER BY e.deptno DESC, e.ename ASC, e.sal DESC;

--문제 33) 10번부서 모든직원 13%보너스 이름,급여,보너스,부서번호 출력

SELECT ename, sal, TRUNC(sal*0.13) BONUS, deptno
FROM emp
WHERE deptno=10;

--문제 34) 이름,급여,커미션,총액(급여+커미션)을 구하여 총액이 많은 순서로 출력

SELECT ename, sal, NVL(comm,0), NVL2(comm, sal+comm, sal) 총액
FROM emp
ORDER BY 4 DESC;

--문제 35) 급여가 1500~3000사이 사원에 대해서만 급여 15%회비 지불, 이름,급여,회비(소수2자리반올림)
--회비 $, 소수점 1자리

SELECT ename, sal, TO_CHAR(ROUND(sal*0.15,2),'$99,999.9') 회비
FROM emp
WHERE sal BETWEEN 1500 AND 3000;

--문제 36)사원수가 5명이 넘는 부서의 부서명과 사원수 조회

SELECT d.dname, COUNT(*)
FROM emp e
JOIN dept d
        ON e.deptno=d.deptno
GROUP BY d.dname
HAVING COUNT(*)>5;

--문제 37)직업별 급여합계가 5000을 초과하는 각 직무에 대해서 직무와 월 급여 합계를 조회, 
--단 판매원('SALESMAN')은 제외하고 월 급여 합계로 내림차순 정렬

SELECT job, SUM(sal)
FROM emp
WHERE job!='SALESMAN'
GROUP BY job
HAVING SUM(sal)>5000
ORDER BY 2 DESC;

--문제 38)사원들의 사원번호(empno), 사원명(ename), 급여(sal), 급여등급(grade)을 출력하시오. 테이블 salgrade 조인

SELECT e.empno, e.ename,e.sal,s.grade
FROM emp e
JOIN salgrade s 
        ON e.sal BETWEEN losal AND hisal;

--문제 39) 부서별(deptno)로 사원의 수와 커미션(comm)을 받은 사원의 수를 출력하여 보시오.

SELECT deptno, COUNT(*)
FROM emp
WHERE comm IS NOT NULL
GROUP BY deptno;


--문제 40) 부서번호(deptno)가 10은 '총무부', 20은 '개발부', 30은 '영업부'라고 하여 이름,부서번호,부서명 순으로 출력하여 보시오.

SELECT ename, deptno,
            DECODE(deptno, 10, '총무부',
                                            20, '개발부',
                                            30, '영업부',
                                            '부서없음') "부서명"
FROM emp;
