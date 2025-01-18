CREATE DATABASE IF NOT EXISTS simple_pay;
USE simple_pay;

GRANT ALL PRIVILEGES ON simple_pay.* TO 'mysqluser'@'%';
FLUSH PRIVILEGES;