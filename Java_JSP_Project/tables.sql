SELECT * FROM follower;

SELECT * FROM PHOTOS 
WHERE USERID= ANY
                                    (SELECT FOLLOWING
                                     FROM FOLLOWING
                                     WHERE USERID='tree')
ORDER BY PHOTONUM DESC;

SELECT * FROM PHOTOS 
WHERE USERID='puppy'
ORDER BY PHOTONUM DESC;

SELECT * FROM PHOTOS 
WHERE USERID='filmmaker'
ORDER BY PHOTONUM DESC;



SELECT FOLLOWING FROM FOLLOWING WHERE USERID='tree';

select * from follower;
delete from follower where userid='filmmaker';
delete from following where userid='tree';

delete from users where userid='architecture';

SELECT * FROM follower;

SELECT COUNT(*) FROM PHOTOLIKE WHERE PHOTONUM=12;

SELECT * FROM collections;
SELECT * FROM PHOTOS WHERE PHOTONUM=(SELECT PHOTONUM FROM COLLECTIONS WHERE USERID='A') ORDER BY PHOTONUM DESC;
INSERT INTO USERS (USERID,PWD,NAME,FOLLOWING,PI_FILEPATH,EMAIL) VALUES ('A','123','C','A','https://previews.123rf.com/images/dstarky/dstarky1701/dstarky170101131/69423991-dog-icon-or-logo-in-modern-line-style-high-quality-black-outline-pictogram-for-web-site-design-and-m.jpg','A@naver.com');

INSERT INTO USERS (FOLLOWING) VALUES ('D') WHERE USERID='A';

UPDATE USERS
SET PI_FILEPATH='DEFAULT'
WHERE USERID='A';

INSERT INTO FOLLOWING(USERID,FOLLOWING) VALUES('A','C');
INSERT INTO FOLLOWING(USERID,FOLLOWING) VALUES('A','B');
INSERT INTO FOLLOWING(USERID,FOLLOWING) VALUES('A','D');



SELECT * FROM FOLLOWING;

SELECT COUNT(*) FROM FOLLOWING WHERE USERID='A';

SELECT FOLLOWING FROM FOLLOWING WHERE USERID='A';


select * from users where userid='A';

select * from users where userid='B';

select * from users where userid='C';
DELETE FROM PHOTOS WHERE PHOTONUM=10;
UPDATE PHOTOS
SET LIKES=LIKES+1
WHERE PHOTONUM=8;

UPDATE USERS
SET PI_FILEPATH='DEFAULT';

UPDATE PHOTOS
SET LIKEDPEOPLE=(SELECT LIKEDPEOPLE FROM PHOTOS WHERE PHOTONUM=8) || ', A'
WHERE PHOTONUM=8;

--A�� B�� �ȷ����Ѵ�.

UPDATE USERS 
SET FOLLOWER=(SELECT FOLLOWER FROM USERS WHERE USERID='B') || ' A'
WHERE USERID='B';

UPDATE USERS
SET FOLLOWING=(SELECT FOLLOWING FROM USERS WHERE USERID='A') || ' B'
WHERE USERID='A';

UPDATE USERS 
SET FOLLOWER='DEFAULT', FOLLOWING='DEFAULT'
WHERE USERID='B';

INSERT INTO TEST (USERID) VALUES ('A');
INSERT INTO TEST (USERID) VALUES ('B');
INSERT INTO TEST (USERID) VALUES ('C');
INSERT INTO TEST (USERID) VALUES ('D');
INSERT INTO TEST (USERID) VALUES ('E');

UPDATE TEST SET FOLLOWER = 'B' WHERE USERID='A';

UPDATE TEST 
SET FOLLOWER = (SELECT FOLLOWER 
                                     FROM TEST 
                                     WHERE USERID='A') || ', C' 
WHERE USERID='A';

INSERT INTO USERS (USERID)  VALUES ('a');

DROP TABLE GROUPS;

CREATE SEQUENCE  "HR"."PHOTO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

DELETE FROM PHOTOS;

select * from comments;

delete from comments;

select follower from users where userid='a';