SET NAMES 'latin1';
DROP DATABASE IF EXISTS smartfit;
CREATE DATABASE IF NOT EXISTS smartfit DEFAULT CHARACTER SET utf8;
USE smartfit;
/*------------------------------------------------- 5*/
CREATE TABLE client(
id_clt INTEGER NOT NULL AUTO_INCREMENT,
name_clt VARCHAR(30) NOT NULL,
paternal_surname_clt VARCHAR(30) NOT NULL,
maternal_surname_clt VARCHAR(30) NOT NULL,
curp_clt VARCHAR(18) NOT NULL,
phone_number_clt VARCHAR(10) NOT NULL,
email_clt VARCHAR(50) NOT NULL,
PRIMARY KEY (id_clt),
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_clt)>=4 AND CHAR_LENGTH(paternal_surname_clt)>=4 AND CHAR_LENGTH(maternal_surname_clt)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_clt REGEXP '[^0-9]' AND paternal_surname_clt REGEXP '[^0-9]' AND maternal_surname_clt REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_clt REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND paternal_surname_clt REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND maternal_surname_clt REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$'),
CONSTRAINT EXCLUSIVE_CURP UNIQUE(curp_clt),
CONSTRAINT CURP_FORMAT CHECK(curp_clt REGEXP '^[A-ZÑ0-9]{18}'),
CONSTRAINT ONLY_PHONE_NUMBER CHECK(phone_number_clt REGEXP'^[0-9]{10}$'),
CONSTRAINT EMAIL CHECK(email_clt REGEXP '^[a-z0-9!#$%&*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$'),
CONSTRAINT EXCLUSIVE_MAIL UNIQUE(email_clt)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE contact_person(
id_cpn	INTEGER NOT NULL AUTO_INCREMENT,
name_cpn VARCHAR(15) NOT NULL,
paternal_surname_cpn VARCHAR(15) NOT NULL,
maternal_surname_cpn VARCHAR(15) NOT NULL,
phone_number_cpn VARCHAR(10) NOT NULL,
id_client_cpn INTEGER NOT NULL,
PRIMARY KEY (id_cpn),
FOREIGN KEY (id_client_cpn) REFERENCES client(id_clt) ON DELETE CASCADE,
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_cpn)>=4 AND CHAR_LENGTH(paternal_surname_cpn)>=4 AND CHAR_LENGTH(maternal_surname_cpn)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_cpn REGEXP '[^0-9]' AND paternal_surname_cpn REGEXP '[^0-9]' AND maternal_surname_cpn REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_cpn REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND paternal_surname_cpn REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND maternal_surname_cpn REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$'),
CONSTRAINT ONLY_PHONE_NUMBER CHECK(phone_number_cpn REGEXP'^[0-9]{10}$')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE client_address(
id_cls	INTEGER NOT NULL AUTO_INCREMENT,
name_cls VARCHAR(70) NOT NULL,
outer_number_cls VARCHAR(5) NOT NULL,
inside_number_cls VARCHAR(5),
state_cls VARCHAR(40) NOT NULL,
city_cls VARCHAR(40) NOT NULL,
id_client_cls INTEGER NOT NULL,
PRIMARY KEY (id_cls),
FOREIGN KEY (id_client_cls) REFERENCES client(id_clt) ON DELETE CASCADE,
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_cls)>=4 AND CHAR_LENGTH(state_cls)>=4 AND CHAR_LENGTH(city_cls)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_cls REGEXP '[^0-9]' AND state_cls REGEXP '[^0-9]' AND city_cls REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_cls REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND state_cls REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND city_cls REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$'),
CONSTRAINT NUMBER_FORMTAT CHECK(outer_number_cls REGEXP '^[0-9]+' AND inside_number_cls REGEXP '^[0-9]+')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE payment_method(
id_pmd	INTEGER NOT NULL AUTO_INCREMENT,
full_name_pmd VARCHAR(80) NOT NULL,
number_card_pmd VARCHAR(16) NOT NULL,
number_cvc_pmd VARCHAR(3) NOT NULL,
date_card_pmd VARCHAR(5) NOT NULL,
flag_pmd VARCHAR(15) NOT NULL,
id_client_pmd INTEGER NOT NULL,
PRIMARY KEY (id_pmd),
FOREIGN KEY (id_client_pmd) REFERENCES client(id_clt) ON DELETE CASCADE,
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(full_name_pmd)>=4),
CONSTRAINT ONLY_LETTERS CHECK(full_name_pmd REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(full_name_pmd REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$'),
CONSTRAINT CARD_NUMBER_SIZE CHECK(number_card_pmd REGEXP '^[0-9]{16}'),
CONSTRAINT CV_SIZE CHECK(number_cvc_pmd REGEXP '^[0-9]{3}'),
CONSTRAINT FORMAT_DATE CHECK(date_card_pmd REGEXP '^[0-9]{2}-[0-9]{2}')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE payment(
id_pyt	INTEGER NOT NULL AUTO_INCREMENT,
payment_description_pyt VARCHAR(80) NOT NULL,
due_date_pyt VARCHAR(15) NOT NULL,
star_date_pyt VARCHAR(15) NULL,
end_date_pyt VARCHAR(15) NULL,
total_balance_pyt DOUBLE NOT NULL,
flag_pmd VARCHAR(15) NULL,
id_client_pyt INTEGER NOT NULL,
PRIMARY KEY (id_pyt),
FOREIGN KEY (id_client_pyt) REFERENCES client(id_clt) ON DELETE CASCADE,
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(payment_description_pyt)>=4),
CONSTRAINT ONLY_LETTERS CHECK(payment_description_pyt REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(payment_description_pyt REGEXP '^[A-ZÑÁÉÍÓÚÜ ]+$'),
CONSTRAINT DUE_DATE_FORMAT CHECK(due_date_pyt REGEXP '^[0-9]{2}[-]{1}[A-Z]{3}[-]{1}[0-9]{4}$'),
CONSTRAINT DATE_MONTH_FORMAT CHECK(star_date_pyt REGEXP '^[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}$' AND end_date_pyt REGEXP '^[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}$')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE training_unit_address(
id_tru	INTEGER NOT NULL AUTO_INCREMENT,
name_tru VARCHAR(70) NOT NULL,
outer_number_tru INTEGER(5) NOT NULL,
inside_number_tru INTEGER(5) NULL,
state_tru VARCHAR(40) NOT NULL,
city_tru VARCHAR(40) NOT NULL,
PRIMARY KEY (id_tru),
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_tru)>=4 AND CHAR_LENGTH(state_tru)>=4 AND CHAR_LENGTH(city_tru)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_tru REGEXP '[^0-9]' AND state_tru REGEXP '[^0-9]' AND city_tru REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_tru REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND state_tru REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$' AND city_tru REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$'),
CONSTRAINT NUMBER_SIZE CHECK(outer_number_tru REGEXP '^[0-9]+' AND inside_number_tru REGEXP '^[0-9]+')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE benefits(
id_bns	INTEGER NOT NULL AUTO_INCREMENT,
name_bns VARCHAR(150) NOT NULL,
PRIMARY KEY (id_bns),
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_bns)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_bns REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_bns REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE training_unit(
id_tru	INTEGER NOT NULL AUTO_INCREMENT,
name_place_tu VARCHAR(80) NOT NULL,
id_training_unit_address INTEGER NOT NULL,
PRIMARY KEY (id_tru),
FOREIGN KEY (id_training_unit_address) REFERENCES training_unit_address(id_tru),
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_place_tu)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_place_tu REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_place_tu REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE plan(
id_pln INTEGER NOT NULL AUTO_INCREMENT,
name_pln VARCHAR(15) NOT NULL,
price_pln DOUBLE NOT NULL,
PRIMARY KEY (id_pln),
CONSTRAINT MINIMUM_4_CHARACTERS_NAME CHECK(CHAR_LENGTH(name_pln)>=4),
CONSTRAINT ONLY_LETTERS CHECK(name_pln REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(name_pln REGEXP '[A-ZÑÁÉÍÓÚÜ ]+$')
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE plan_benefits(
id_plan_plb	INTEGER NOT NULL,
id_benefits_plb	INTEGER NOT NULL,
PRIMARY KEY(id_plan_plb, id_benefits_plb),
FOREIGN KEY (id_plan_plb) REFERENCES plan(id_pln),
FOREIGN KEY (id_benefits_plb) REFERENCES benefits(id_bns)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE user(
id_usr				INTEGER NOT NULL AUTO_INCREMENT,
role_usr			VARCHAR(20) NOT NULL,
user_usr			VARCHAR(50) NOT NULL, 
password_usr		VARCHAR(16) NOT NULL,
id_client_usr		INTEGER NOT NULL,
PRIMARY KEY (id_usr),
FOREIGN KEY (id_client_usr) REFERENCES client(id_clt) ON DELETE CASCADE,
CONSTRAINT MINIMUM_7_CHARACTERS CHECK(CHAR_LENGTH(role_usr)>=5),
CONSTRAINT ONLY_LETTERS CHECK(role_usr REGEXP '[^0-9]'),
CONSTRAINT NO_SIMBOLS CHECK(role_usr REGEXP '^[A-Z ]+$'),
CONSTRAINT EMAIL CHECK(user_usr REGEXP '^[a-z0-9!#$%&*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$'),
CONSTRAINT EXCLUSIVE_USER UNIQUE(user_usr),
CONSTRAINT PASS_STRUCTURE CHECK(password_usr REGEXP '^[A-Z]{1}[a-z0-9]+[a-z0-9ñ@!¡#$%&¿?+*-]+'),
CONSTRAINT PASS_SIZE CHECK(CHAR_LENGTH(password_usr)>=8 AND CHAR_LENGTH(password_usr)<=16)
)DEFAULT CHARACTER SET utf8;
/*------------------------------------------------- 5*/
CREATE TABLE client_plan_training_unit(
id_client_cpl INTEGER NOT NULL,
start_date_cpl VARCHAR(15) NOT NULL,
id_plan_cpl	INTEGER,
id_training_unit_cpl INTEGER,
PRIMARY KEY(id_client_cpl, start_date_cpl),
FOREIGN KEY (id_client_cpl) REFERENCES client(id_clt) ON DELETE CASCADE,
FOREIGN KEY (id_plan_cpl) REFERENCES plan(id_pln),
FOREIGN KEY (id_training_unit_cpl) REFERENCES training_unit(id_tru),
CONSTRAINT FORMAT_DATE CHECK(start_date_cpl REGEXP '^[A-Z]{1}[a-z]+[[:space:]]{1}de[[:space:]]{1}[0-9]{4}')
)DEFAULT CHARACTER SET utf8;