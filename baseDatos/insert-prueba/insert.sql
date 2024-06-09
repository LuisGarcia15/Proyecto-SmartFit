INSERT INTO contact_person (name_cpn, paternal_surname_cpn, maternal_surname_cpn, phone_number_cpn) VALUES 
('JUAN', 'PEREZ', 'GOMEZ', '1234567890'),
('MARIA', 'RODRIGUEZ', 'LOPEZ', '2345678901'),
('CARLOS', 'HERNANDEZ', 'MARTINEZ', '3456789012'),
('LAURA', 'GONZALEZ', 'GARCIA', '4567890123'),
('JOSE', 'MARTINEZ', 'LOPEZ', '5678901234'),
('LUIS', 'RAMIREZ', 'RODRIGUEZ', '6789012345'),
('ELENA', 'FERNANDEZ', 'SANCHEZ', '7890123456'),
('ALBERTO', 'TORRES', 'CASTRO', '8901234567'),
('PABLO', 'DIAZ', 'MORALES', '9012345678'),
('SOFIA', 'MENDOZA', 'GUTIERREZ', '0123456789');

INSERT INTO client_address (name_cls, outer_number_cls, inside_number_cls, state_cls, city_cls) VALUES 
('CALLE UNO', '1', '1', 'ESTADO UNO', 'CIUDAD UNO'),
('CALLE DOS', '2', '2', 'ESTADO DOS', 'CIUDAD DOS'),
('CALLE TRES', '3', '3', 'ESTADO TRES', 'CIUDAD TRES'),
('CALLE CUATRO', '4', '4', 'ESTADO CUATRO', 'CIUDAD CUATRO'),
('CALLE CINCO', '5', '5', 'ESTADO CINCO', 'CIUDAD CINCO'),
('CALLE SEIS', '6', '6', 'ESTADO SEIS', 'CIUDAD SEIS'),
('CALLE SIETE', '7', '7', 'ESTADO SIETE', 'CIUDAD SIETE'),
('CALLE OCHO', '8', '8', 'ESTADO OCHO', 'CIUDAD OCHO'),
('CALLE NUEVE', '9', '9', 'ESTADO NUEVE', 'CIUDAD NUEVE'),
('CALLE DIEZ', '10', '10', 'ESTADO DIEZ', 'CIUDAD DIEZ');

INSERT INTO payment_method (full_name_pmd, number_card_pmd, number_cvc_pmd, date_card_pmd, flag_pmd) VALUES 
('JUAN PEREZ GOMEZ', '1234567812345678', '123', '12-24', 'VISA'),
('MARIA RODRIGUEZ LOPEZ', '2345678923456789', '234', '11-23', 'MASTERCARD'),
('CARLOS HERNANDEZ MARTINEZ', '3456789034567890', '345', '10-22', 'AMEX'),
('ANA GONZALEZ GARCIA', '4567890145678901', '456', '09-21', 'VISA'),
('JOSE MARTINEZ LOPEZ', '5678901256789012', '567', '08-20', 'MASTERCARD'),
('LUIS RAMIREZ RODRIGUEZ', '6789012367890123', '678', '07-19', 'AMEX'),
('ELENA FERNANDEZ SANCHEZ', '7890123478901234', '789', '06-18', 'VISA'),
('ALBERTO TORRES CASTRO', '8901234589012345', '890', '05-17', 'MASTERCARD'),
('PABLO RIAZ MORALES', '9012345690123456', '901', '04-16', 'AMEX'),
('SOFIA MENDOZA GUTIERREZ', '0123456701234567', '012', '03-15', 'VISA');

INSERT INTO training_unit_address (name_tru, outer_number_tru, inside_number_tru, state_tru, city_tru) VALUES 
('CALLE UNO', 1, 1, 'ESTADO UNO', 'CIUDAD UNO'),
('CALLE DOS', 2, 2, 'ESTADO DOS', 'CIUDAD DOS'),
('CALLE TRES', 3, 3, 'ESTADO TRES', 'CIUDAD TRES'),
('CALLE CUATRO', 4, 4, 'ESTADO CUATRO', 'CIUDAD CUATRO'),
('CALLE CINCO', 5, 5, 'ESTADO CINCO', 'CIUDAD CINCO'),
('CALLE SEIS', 6, 6, 'ESTADO SEIS', 'CIUDAD SEIS'),
('CALLE SIETE', 7, 7, 'ESTADO SIETE', 'CIUDAD SIETE'),
('CALLE OCHO', 8, 8, 'ESTADO OCHO', 'CIUDAD OCHO'),
('CALLE NUEVE', 9, 9, 'ESTADO NUEVE', 'CIUDAD NUEVE'),
('CALLE DIEZ', 10, 10, 'ESTADO DIEZ', 'CIUDAD DIEZ');

INSERT INTO benefits (name_bns) VALUES 
('ACCESO TODOS HORARIOS'),
('CLASES GRUPALES'),
('ENTRENADOR PERSONAL'),
('ACCESO AREAS VIP'),
('DESCUENTOS EN PRODUCTOS'),
('ESTACIONAMIENTO');

INSERT INTO training_unit (name_place_tu, id_training_unit_address) VALUES 
('GYM UNO', 1),
('GYM DOS', 2),
('GYM TRES', 3),
('GYM CUATRO', 4),
('GYM CINCO', 5),
('GYM SEIS', 6),
('GYM SIETE', 7),
('GYM OCHO', 8),
('GYM NUEVE', 9),
('GYM DIEZ', 10);

INSERT INTO plan (name_pln) VALUES 
('PLAN BASICO'),
('PLAN PREMIUM'),
('PLAN ELITE');

INSERT INTO plan_benefits (id_plan_plb, id_benefits_plb) VALUES 
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6);

INSERT INTO plan_training_unit (id_plan_plb, id_training_unit_plb) VALUES 
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 7),
(3, 8),
(3, 9),
(3, 10);

INSERT INTO client (name_clt, paternal_surname_clt, maternal_surname_clt, curp_clt, id_contact_person, phone_number_clt, email_clt, id_address,id_payment_method_clt) VALUES 
('JUAN', 'PEREZ', 'GOMEZ', 'JPGO870101HDFLNS09', 1, '1234567890', 'juan.perez@example.com', 1, 1),
('MARIA', 'RODRIGUEZ', 'LOPEZ', 'MRLO890202MDFLRS08', 2, '2345678901', 'maria.rodriguez@example.com', 2, 2),
('CARLOS', 'HERNANDEZ', 'MARTINEZ', 'CHMA900303HDFLRS09', 3, '3456789012', 'carlos.hernandez@example.com', 3, 3),
('LAURA', 'GONZALEZ', 'GARCIA', 'ANGG910404HDFLRS07', 4, '4567890123', 'laura.gonzalez@example.com', 4, 4),
('JOSE', 'MARTINEZ', 'LOPEZ', 'JMLL920505HDFLRS06', 5, '5678901234', 'jose.martinez@example.com', 5, 5),
('LUIS', 'RAMIREZ', 'RODRIGUEZ', 'LRRR930606HDFLRS05', 6, '6789012345', 'luis.ramirez@example.com', 6, 6),
('ELENA', 'FERNANDEZ', 'SANCHEZ', 'EFSN940707HDFLRS04', 7, '7890123456', 'elena.fernandez@example.com', 7, 7),
('ALBERTO', 'TORRES', 'CASTRO', 'ATCS950808HDFLRS03', 8, '8901234567', 'alberto.torres@example.com', 8, 8),
('PABLO', 'DIAZ', 'MORALES', 'PDMO960909HDFLRS02', 9, '9012345678', 'pablo.diaz@example.com', 9, 9),
('SOFIA', 'MENDOZA', 'GUTIERREZ', 'SMGG971010HDFLRS01', 10, '1234567890', 'sofia.mendoza@example.com', 10, 10);

INSERT INTO user (role_usr, user_usr, password_usr, id_client_usr) VALUES 
('CUSTOMER', 'customer1@example.com', 'Apassword1@', 1),
('CUSTOMER', 'customer2@example.com', 'Bpassword2@', 2),
('CUSTOMER', 'customer3@example.com', 'Cpassword3@', 3),
('CUSTOMER', 'customer4@example.com', 'Dpassword4@', 4),
('CUSTOMER', 'customer5@example.com', 'Epassword5@', 5),
('CUSTOMER', 'customer6@example.com', 'Fpassword6@', 6),
('CUSTOMER', 'customer7@example.com', 'Gpassword7@', 7),
('CUSTOMER', 'customer8@example.com', 'Hpassword8@', 8),
('CUSTOMER', 'customer9@example.com', 'Ipassword9@', 9),
('CUSTOMER', 'customer10@example.com', 'Jpassword10@', 10);

INSERT INTO client_plan (id_client_cpl, id_plan_cpl, start_date_cpl) VALUES
(1, 1, 'Enero de 2020'),
(2, 1, 'Enero de 2021'),
(3, 2, 'Enero de 2022'),
(4, 2, 'Enero de 2023'),
(5, 2, 'Enero de 2024'),
(6, 3, 'Febrero de 2022'),
(7, 3, 'Marzo de 2022'),
(8, 3, 'Abril de 2022'),
(9, 3, 'Mayo de 2022'),
(10, 3, 'Junio de 2022');