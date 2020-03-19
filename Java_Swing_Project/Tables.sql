CREATE TABLE Manager(
empno number not null,
ManagerID varchar2(100) UNIQUE,
ManagerPwd varchar2(100),
PRIMARY KEY(empno)
);

CREATE SEQUENCE manager_seq
INCREMENT BY 1
START WITH 1
NOCACHE;

DESCRIBE MANAGER;
SELECT * FROM MANAGER;

CREATE TABLE Buyer(
Buyerno number not null,
BuyerID varchar2(100) UNIQUE,
BuyerPwd varchar2(100),
BuyerName varchar2(100),
BuyerBirth varchar2(100),
BuyerGender varchar2(20),
BuyerEmail varchar2(100),
BuyerTel varchar2(100),
BuyerAddr varchar2(1000),
BuyerPref varchar2(1000),
PRIMARY KEY(buyerno)
);

CREATE SEQUENCE buyer_seq
INCREMENT BY 1
START WITH 1
NOCACHE;

SELECT * FROM WareHouseStock;

CREATE TABLE WareHouseStock(
Product_Num number NOT NULL,
Category VARCHAR2(100),
Name VARCHAR2(100),
Info VARCHAR2(1000),
Stock_Date DATE DEFAULT SYSDATE,
Stock_Num number DEFAULT 0,
Price number DEFAULT 0,
Quantity number DEFAULT 0,
Sales_Num number,
PRIMARY KEY(Product_Num)
);


commit;

INSERT INTO WareHouseStock VALUES (warehousestock_seq.NEXTVAL,'스마트폰','갤럭시s9','최신 스마트폰', SYSDATE, 10, 1000000, 10 ,9999,1);
SELECT * FROM WAREHOUSESTOCK;
SELECT empno FROM manager where managerid='shicks';
select * from manager;
DELETE FROM WareHouseStock
WHERE product_num=1;


ALTER TABLE WareHouseStock
ADD empno number;

ALTER TABLE WareHouseStock
ADD Stock_Price number;

INSERT INTO WareHouseStock VALUES warehousestock_seq.NEXTVAL,9999,1,'Desktop','삼성 데스크탑','삼성 일체형 pc',SYSDATE,10,?,?;
SELECT * FROM WareHouseStock WHERE name='갤럭시s9';

Rollback;
CREATE SEQUENCE warehousestock_seq
INCREMENT BY 1
START WITH 20190001
NOCACHE;

SELECT * FROM WareHouseStock;

UPDATE WareHouseStock SET STOCK_NUM = ((SELECT STOCK_NUM FROM WareHouseStock)+1) WHERE Product_Num=20190002;

ALTER TABLE WareHouseStock
ADD CONSTRAINT  whs_sn_fk FOREIGN KEY (Sales_Num) REFERENCES SalesStock (Sales_Num);

ALTER TABLE WareHouseStock
DROP COLUMN QUANTITY;

ALTER TABLE WareHouseStock
DROP COLUMN STOCK_NUM;

DELETE FROM WareHouseStock
WHERE PRODUCT_NUM=20190003;


ALTER TABLE WareHouseStock
ADD STOCK_P NUMBER;

ALTER TABLE WareHouseStock
ADD CONSTRAINT  whs_en_fk FOREIGN KEY (empno) REFERENCES Manager (empno);

INSERT INTO WAREHOUSESTOCK (STOCK_PRICE) VALUES (800000)
WHERE PRODUCT_NUM=20190003;

UPDATE WAREHOUSESTOCK 
SET STOCK_PRICE=900000
WHERE PRODUCT_NUM=20190004;

COMMIT;


DESCRIBE warehousestock;


CREATE TABLE SalesStock(
Sales_Num number NOT NULL,
Product_Num number,
Sales_Date DATE DEFAULT SYSDATE,
Sales_Quantity number DEFAULT 0,
Sales_Price number DEFAULT 0,
PRIMARY KEY(Sales_Num)
);


DESCRIBE salesstock;


ALTER TABLE SalesStock
ADD CONSTRAINT  ss_pn_fk FOREIGN KEY (Product_Num) REFERENCES WareHouseStock (Product_Num);

DELETE FROM SalesStock
WHERE sales_num=1;

INSERT INTO SalesStock(Sales_Num)
VALUES (9999);

CREATE SEQUENCE salesstock_seq
INCREMENT BY 1
START WITH 20190001
NOCACHE;


CREATE TABLE ShoppingBasket(
Buy_Num number NOT NULL,
Buyerno number,
Sales_Num number,
Product_Num number,
Buying_Quantity number DEFAULT 0,
PRIMARY KEY(Buy_Num)
);

DROP TABLE shoppingbasket;

ALTER TABLE ShoppingBasket
ADD CONSTRAINT  sb_bn_fk FOREIGN KEY (Buyerno) REFERENCES Buyer (Buyerno);


ALTER TABLE ShoppingBasket
ADD CONSTRAINT  sb_sn_fk FOREIGN KEY (Sales_Num) REFERENCES SalesStock (Sales_Num);


ALTER TABLE ShoppingBasket
ADD CONSTRAINT  sb_pn_fk FOREIGN KEY (Product_Num) REFERENCES WareHouseStock (Product_Num);


CREATE SEQUENCE shoppingbasket_seq
INCREMENT BY 1
START WITH 1
NOCACHE;


COMMIT;


SELECT *
FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'MANAGER';


SELECT *
FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'BUYER';


SELECT *
FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'WAREHOUSESTOCK';


SELECT *
FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'SALESSTOCK';


SELECT *
FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = 'SHOPPINGBASKET';

INSERT INTO (sb, ss)
VALUES (sb.BuyNum = shoppingbasket_seq.NEXTVAL, sb.Buyerno=1,sb.SalesNum=salesstock_seq.NEXTVAL, sb.Product_num=20190003, sb.Buying_Quantity=10, 
                    ss.SalesNum=salesstock_seq.CURRVAL, ss.Product_num=20190003, ss.Sales_Date=SYSDATE, ss.Sales_Quantity=0, Sales_Price=0)
FROM SalesStock ss
JOIN ShoppingBasket sb
ON sb.Sales_Num = ss.Sales_Num;

INSERT ALL
INTO SHOPPINGBASKET VALUES(s_num, s_bnum, s_snum, s_pnum, s_bq)
INTO SALESSTOCK VALUES(s_num, s_pnum, s_sd, s_sq, s_sp)
SELECT s_num, s_bnum, s_snum, s_pnum, s_bq, s_sd, s_sq, s_sp
FROM
(
    SELECT
       shoppingbasket_seq.NEXTVAL s_num,
       1 s_bnum,
        salesstock_seq.NEXTVAL s_snum,
       20190003 s_pnum,
       10 s_bq,
        SYSDATE s_sd,
        0 s_sq,
        0 s_sp
        FROM dual
) ;

ALTER TABLE shoppingbasket
DROP COLUMN SALES_NUM;

ALTER TABLE SALESSTOCK
ADD buy_num number;

ALTER TABLE SALESSTOCK
ADD CONSTRAINT  sb_bnn_fk FOREIGN KEY (Buy_Num) REFERENCES ShoppingBasket (Buy_Num);

INSERT INTO ShoppingBasket
VALUES (shoppingbasket_seq.NEXTVAL,1,20190003,10);

SELECT * 
FROM ShoppingBasket sb
JOIN WareHouseStock whs
ON sb.product_num=whs.product_num;

DELETE FROM SHOPPINGBASKET
WHERE BUY_NUM=1;

SELECT * FROM WAREHOUSESTOCK;

select CONSTRAINT_NAME, TABLE_NAME, R_CONSTRAINT_NAME
from user_constraints
where CONSTRAINT_NAME = 'SB_BNN_FK' ;

DELETE FROM SHOPPINGBASKET
WHERE BUY_NUM=1;

DELETE FROM SHOPPINGBASKET
WHERE BUY_NUM=1;

INSERT INTO SalesBasket
VALUES (sales_num, product_num, buy_num, sales_date, sales_quantity, sales_price);

SELECT * FROM SalesStock;



DELETE SalesStock
where sales_num=9999;

DELETE SalesStock
where sales_num=20190007;

DELETE SalesStock
where sales_num=20190005;

ALTER TABLE SalesStock
ADD CONSTRAINT  ss_bn_fk UNIQUE (Buy_Num);