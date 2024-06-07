SET NAMES 'latin1';
DROP DATABASE IF EXISTS smartfit;
CREATE DATABASE IF NOT EXISTS smartfit DEFAULT CHARACTER SET utf8;
USE smartfit;
/*------------------------------------------------- 5*/
CREATE TABLE user(
id_usr				INTEGER NOT NULL AUTO_INCREMENT,
role_usr			VARCHAR(20) NOT NULL,
user_usr			VARCHAR(50) NOT NULL, 
password_usr		VARCHAR(16) NOT NULL,
PRIMARY KEY (id_usr),
CONSTRAINT MINIMUM_7_CHARACTERS CHECK(CHAR_LENGTH(role_usr)>=7),
CONSTRAINT ONLY_LETTERS CHECK(role_usr REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(role_usr REGEXP '^[a-zA-Z]+$'),
CONSTRAINT EMAIL CHECK(user_usr REGEXP '^[a-z0-9!#$%&*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$'),
CONSTRAINT EXCLUSIVE_USER UNIQUE(user_usr),
CONSTRAINT PASS_STRUCTURE CHECK(password_usr REGEXP '^[A-Z]{1}[a-z0-9]+[a-z0-9ñ@!¡#$%&¿?+*-]+'),
CONSTRAINT PASS_SIZE CHECK(CHAR_LENGTH(password_usr)>=8 AND CHAR_LENGTH(password_usr)<=16)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE contact_person(
id_cpn	INTEGER NOT NULL AUTO_INCREMENT,
name_cpn VARCHAR(15) NOT NULL,
paternal_surname_cpn VARCHAR(15) NOT NULL,
maternal_surname_cpn VARCHAR(15) NOT NULL,
phone_number_cpn VARCHAR(15) NOT NULL,
PRIMARY KEY (id_cpn),
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_cpn)>=4 AND CHAR_LENGTH(paternal_surname_cpn)>=4 AND CHAR_LENGTH(maternal_surname_cpn)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_cpn REGEXP '[^0-9]' AND paternal_surname_cpn REGEXP '[^0-9]' AND maternal_surname_cpn REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_cpn REGEXP '^[a-zA-Z]+$' AND paternal_surname_cpn REGEXP '^[a-zA-Z]+$' AND maternal_surname_cpn REGEXP '^[a-zA-Z]+$'),
CONSTRAINT ONLY_UPPERCASE_LETTERS CHECK(name_cpn REGEXP '^[A-ZÑ]+$' AND paternal_surname_cpn REGEXP '^[A-ZÑ]+$' AND maternal_surname_cpn REGEXP '^[A-ZÑ]+$'),
CONSTRAINT ONLY_PHONE_NUMBER CHECK(phone_number_cpn REGEXP'^[0-9]{10}$')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE client_address(
id_cls	INTEGER NOT NULL AUTO_INCREMENT,
name_cls VARCHAR(70) NOT NULL,
outer_number_cls INTEGER(15) NOT NULL,
inside_number_cls INTEGER(15),
state_cls VARCHAR(40) NOT NULL,
city_cls VARCHAR(40) NOT NULL,
PRIMARY KEY (id_cls)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE payment_method(
id_pmd	INTEGER NOT NULL AUTO_INCREMENT,
full_name_pmd VARCHAR(15) NOT NULL,
number_d_pmd VARCHAR(15) NOT NULL,
flag_pmd VARCHAR(15) NOT NULL,
date_d_pmd VARCHAR(15) NOT NULL,
PRIMARY KEY (id_pmd)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE training_unit_address(
id_tru	INTEGER NOT NULL AUTO_INCREMENT,
name_tru VARCHAR(70) NOT NULL,
outer_number_tru INTEGER(15) NOT NULL,
inside_number_tru INTEGER(15),
state_tru VARCHAR(40) NOT NULL,
city_tru VARCHAR(40) NOT NULL,
PRIMARY KEY (id_tru)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE benefits(
id_bns	INTEGER NOT NULL AUTO_INCREMENT,
name_bns VARCHAR(15) NOT NULL,
PRIMARY KEY (id_bns)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE training_unit(
id_tru	INTEGER NOT NULL AUTO_INCREMENT,
name_place VARCHAR(15) NOT NULL,
id_training_unit_address INTEGER NOT NULL,
PRIMARY KEY (id_tru),
FOREIGN KEY (id_training_unit_address) REFERENCES training_unit_address(id_tru)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE plan(
id_pln INTEGER NOT NULL AUTO_INCREMENT,
name_pln VARCHAR(15) NOT NULL,
star_date_pln VARCHAR(15) NOT NULL,
benefits_pln VARCHAR(15) NOT NULL,
id_training_unit_pln INTEGER NOT NULL,
PRIMARY KEY (id_pln),
FOREIGN KEY (id_training_unit_pln) REFERENCES training_unit(id_tru)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE plan_benefits(
id_plan_plb	INTEGER NOT NULL,
id_benefits_plb	INTEGER NOT NULL,
FOREIGN KEY (id_plan_plb) REFERENCES plan(id_pln),
FOREIGN KEY (id_benefits_plb) REFERENCES benefits(id_bns)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE client(
id_clt INTEGER NOT NULL AUTO_INCREMENT,
name_clt VARCHAR(30) NOT NULL,
paternal_surname_clt VARCHAR(30) NOT NULL,
maternal_surname_clt VARCHAR(30) NOT NULL,
curp_clt VARCHAR(18) NOT NULL,
id_contact_person INTEGER NOT NULL,
phone_number_clt INTEGER(10) NOT NULL,
email_clt VARCHAR(50) NOT NULL,
id_address INTEGER NOT NULL,
id_plan_clt INTEGER NOT NULL,
id_payment_method_clt INTEGER NOT NULL,
PRIMARY KEY (id_clt),
FOREIGN KEY (id_contact_person) REFERENCES contact_person(id_cpn),
FOREIGN KEY (id_address) REFERENCES client_address(id_cls),
FOREIGN KEY (id_payment_method_clt) REFERENCES payment_method(id_pmd),
FOREIGN KEY (id_plan_clt) REFERENCES plan(id_pln)
)DEFAULT CHARACTER SET utf8;