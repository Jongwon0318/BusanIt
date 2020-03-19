USE sql_store;

SELECT *
FROM customers
WHERE customer_id=1
ORDER BY first_name;

SELECT last_name, first_name
FROM customers;

SELECT
	last_name,
    first_name,
    points,
    (points+10)*100 포인트
FROM customers;

SELECT DISTINCT state
FROM customers;

SELECT name,
		unit_price,
        unit_price*1.1 가격
FROM products;

SELECT *
FROM customers
WHERE points>3000;

SELECT *
FROM customers
WHERE state='Va';

SELECT *
FROM orders
WHERE order_date BETWEEN '19/01/01' AND '19/12/31';

SELECT *
FROM customers
WHERE birth_date > '1990-01-01' OR (points >1000 AND state='VA');

SELECT *
FROM customers
WHERE NOT (birth_date >'1990-01-01' OR points>1000);

SELECT *, unit_price*quantity 매출
FROM order_items
WHERE order_id=6 AND (unit_price*quantity) >30;

SELECT *
FROM customers
WHERE state = 'va' OR state= 'ga' OR state ='fl';

SELECT *
FROM products
WHERE quantity_in_stock IN (49,38,72);

SELECT *
FROM customers
WHERE points BETWEEN 1000 AND 3000;

SELECT *
FROM customers
WHERE birth_date BETWEEN '90/01/01' AND '00/01/01';

SELECT *
FROM customers
WHERE last_name LIKE '%b%';

SELECT *
FROM customers
WHERE address LIKE '%trail%' OR address LIKE '%avenue%';

SELECT *
FROM customers
WHERE phone NOT LIKE '%3%' AND phone LIKE '%9';

SELECT *
FROM customers
WHERE last_name REGEXP 'field';

SELECT *
FROM customers
WHERE last_name REGEXP '^b';

SELECT *
FROM customers
WHERE last_name REGEXP '^brush';

SELECT *
FROM customers
WHERE last_name REGEXP 'ey$';

SELECT *
FROM customers
WHERE last_name REGEXP 'field|mac';

SELECT *
FROM customers
WHERE last_name REGEXP 'ey$|rose|^b';

SELECT *
FROM customers
WHERE last_name REGEXP '[gim]e';

SELECT *
FROM customers
WHERE last_name REGEXP 'a[a-h]';

SELECT *
FROM customers
WHERE first_name REGEXP'ELKA|AMBUR';

SELECT *
FROM customers
WHERE last_name REGEXP 'EY$|ON$';

SELECT *
FROM customers
WHERE last_name REGEXP 'MY$|SE';

SELECT *
FROM customers
WHERE last_name REGEXP 'B[R|U]';

SELECT *
FROM customers
WHERE phone IS NULL;

SELECT *
FROM orders
WHERE shipper_id IS NULL;

SELECT *
FROM customers;

SELECT customer_id, first_name, last_name, state
FROM customers
ORDER BY state, first_name;

SELECT *, quantity*unit_price "total_price"
FROM order_items
ORDER BY quantity*unit_price;

SELECT *
FROM customers
LIMIT 3;

SELECT *
FROM customers
LIMIT 6,3;

SELECT *
FROM customers
ORDER BY points DESC
LIMIT 3;

SELECT *
FROM orders o
JOIN customers c
	ON o.customer_id=c.customer_id;

SELECT o.order_id, o.customer_id, o.order_date, c.first_name, c.last_name
FROM orders o
JOIN customers c
	ON o.customer_id = c.customer_id;

SELECT *
FROM order_items o
JOIN products p
	ON o.product_id=p.product_id;

SELECT *
FROM sql_hr.employees;

SELECT sql_hr.e.employee_id, sql_hr.e.first_name, sql_hr.m.first_name AS manager
FROM sql_hr.employees e
JOIN sql_hr.employees m
	ON sql_hr.e.reports_to = sql_hr.m.employee_id;

SELECT o.order_id, o.order_date, c.first_name, os.name AS 주문상태
FROM orders o
JOIN customers c ON o.customer_id=c.customer_id
JOIN order_statuses os ON o.status=os.order_status_id;

USE sql_invoicing;

SELECT p.date, 
		p.invoice_id, 
        p.amount, 
        c.name, 
        pa.name 결제방법
FROM payments p
JOIN clients c ON p.client_id=c.client_id
JOIN payment_methods pa ON pa.payment_method_id=p.payment_method;

SELECT c.customer_id, c.first_name, o.order_id
FROM customers c
JOIN orders o	ON c.customer_id=o.customer_id
ORDER BY c.customer_id;

SELECT c.customer_id, c.first_name, o.order_id
FROM customers c
LEFT JOIN orders o ON c.customer_id=o.customer_id
ORDER BY c.customer_id;

SELECT c.customer_id, c.first_name, o.order_id
FROM customers c
RIGHT JOIN orders o ON c.customer_id = o.customer_id
ORDER BY c.customer_id;

SELECT p.product_id, p.name, o.quantity
FROM products p
LEFT JOIN order_items o ON p.product_id=o.product_id
ORDER BY 3;

SELECT c.customer_id,
		c.first_name,
		o.order_id,
		sh.name
FROM customers c
LEFT JOIN orders o 
	ON c.customer_id=o.customer_id
LEFT JOIN shippers sh 
	ON sh.shipper_id=o.shipper_id
ORDER BY c.customer_id;

SELECT o.order_id, 
		o.order_date, 
        c.first_name, 
        sh.name, 
        o.status
FROM orders o
JOIN customers c 
	ON o.customer_id=c.customer_id
LEFT JOIN shippers sh
		ON o.shipper_id=sh.shipper_id;
        
SELECT *
FROM orders o
JOIN customers c USING (customer_id)
JOIN shippers sh USING (shipper_id);

SELECT o.order_id,
		c.first_name,
        sh.name AS 배송지
FROM orders o
JOIN customers c USING(customer_id)
LEFT JOIN shippers sh USING(shipper_id);  

SELECT *
FROM order_items oi
JOIN order_item_notes oin
 USING ( order_id,product_id );
 
USE sql_invoicing;

SELECT p.date,
		c.name AS client_name,
        p.amount,
        pm.name AS 결제방법
FROM payments p
JOIN clients c
	USING (client_id)
JOIN payment_methods pm
	ON pm.payment_method_id=p.payment_method;
    
SELECT o.order_id,
		c.first_name
FROM orders o
NATURAL JOIN customers c;

SELECT c.first_name AS 고객,
		P.NAME AS 상품
FROM customers c
CROSS JOIN products p
ORDER BY c.first_name;

SELECT order_id,
		order_date,
        '최신주문' AS 상태
FROM orders
WHERE order_date>='2019-01-01'
UNION
SELECT order_id,
		order_date,
        '이전주문' AS 상태
FROM orders
WHERE order_date <'2019-01-01';

SELECT customer_id,
		first_name,
        points,
        'Bronze' AS 등급
FROM customers
WHERE points<2000
UNION
SELECT customer_id,
		first_name,
        points,
        'Silver' AS 등급
FROM customers
WHERE points BETWEEN 2000 AND 3000
UNION
SELECT customer_id,
		first_name,
        points,
        'Gold' AS 등급
FROM customers
WHERE points >3000
ORDER BY first_name;

INSERT INTO shippers (name)
VALUES ('Shipper1'),
		('Shipper2'),
        ('Shipper3');
        
        
INSERT INTO products
VALUES (11,'Product1',10,1.90),
		(12,'Product2',11,1.95),
        (13,'Product3',12,2.00);
        
SELECT * FROM products;

        
INSERT INTO orders(customer_id,order_date)
VALUES (1,'2019-01-02');

SELECT last_insert_id();

INSERT INTO order_items
VALUES(last_insert_id(),1,1,2.95),
		(last_insert_id(),2,1,3.95);
        
CREATE TABLE orders_copy AS
SELECT * FROM orders;

SELECT * FROM orders_copy;

INSERT INTO orders (customer_id, order_date)
VALUES (1, '2019-01-02');

SELECT * FROM orders;

DELETE FROM orders WHERE customer_id = 1;

ROLLBACK;
COMMIT;

UPDATE customers
SET
	points=points+50
WHERE birth_date<'1990-01-01';

SELECT * FROM customers;

UPDATE invoices
SET 
	payment_total = invoice_total*0.5,
    payment_date = due_date
WHERE client_id = 3;

SELECT * FROM invoices;