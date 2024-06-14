INSERT INTO client (name_clt, paternal_surname_clt, maternal_surname_clt, curp_clt, phone_number_clt, email_clt) VALUES 
('JUAN', 'PEREZ', 'GOMEZ', 'JPGO870101HDFLNS09', '1234567890', 'customer1@example.com'),
('MARIA', 'RODRIGUEZ', 'LOPEZ', 'MRLO890202MDFLRS08', '2345678901', 'customer2@example.com'),
('CARLOS', 'HERNANDEZ', 'MARTINEZ', 'CHMA900303HDFLRS09', '3456789012', 'customer3@example.com'),
('LAURA', 'GONZALEZ', 'GARCIA', 'ANGG910404HDFLRS07', '4567890123', 'customer4@example.com'),
('JOSE', 'MARTINEZ', 'LOPEZ', 'JMLL920505HDFLRS06', '5678901234', 'customer5@example.com'),
('LUIS', 'RAMIREZ', 'RODRIGUEZ', 'LRRR930606HDFLRS05', '6789012345', 'customer6@example.com'),
('ELENA', 'FERNANDEZ', 'SANCHEZ', 'EFSN940707HDFLRS04', '7890123456', 'customer7@example.com'),
('ALBERTO', 'TORRES', 'CASTRO', 'ATCS950808HDFLRS03', '8901234567', 'customer8@example.com'),
('PABLO', 'DIAZ', 'MORALES', 'PDMO960909HDFLRS02', '9012345678', 'customer9@example.com'),
('SOFIA', 'MENDOZA', 'GUTIERREZ', 'SMGG971010HDFLRS01', '1234567890', 'customer10@example.com');

INSERT INTO contact_person (name_cpn, paternal_surname_cpn, maternal_surname_cpn, phone_number_cpn, id_client_cpn) VALUES 
('JUAN', 'PEREZ', 'GOMEZ', '1234567890', 1),
('MARIA', 'RODRIGUEZ', 'LOPEZ', '2345678901', 2),
('CARLOS', 'HERNANDEZ', 'MARTINEZ', '3456789012', 3),
('LAURA', 'GONZALEZ', 'GARCIA', '4567890123', 4),
('JOSE', 'MARTINEZ', 'LOPEZ', '5678901234', 5),
('LUIS', 'RAMIREZ', 'RODRIGUEZ', '6789012345', 6),
('ELENA', 'FERNANDEZ', 'SANCHEZ', '7890123456', 7),
('ALBERTO', 'TORRES', 'CASTRO', '8901234567', 8),
('PABLO', 'DIAZ', 'MORALES', '9012345678', 9),
('SOFIA', 'MENDOZA', 'GUTIERREZ', '0123456789', 10);

INSERT INTO client_address (name_cls, outer_number_cls, inside_number_cls, state_cls, city_cls, id_client_cls) VALUES 
('CALLE UNO', '1', '1', 'ESTADO UNO', 'CIUDAD UNO', 1),
('CALLE DOS', '2', '2', 'ESTADO DOS', 'CIUDAD DOS', 2),
('CALLE TRES', '3', '3', 'ESTADO TRES', 'CIUDAD TRES', 3),
('CALLE CUATRO', '4', '4', 'ESTADO CUATRO', 'CIUDAD CUATRO', 4),
('CALLE CINCO', '5', '5', 'ESTADO CINCO', 'CIUDAD CINCO', 5),
('CALLE SEIS', '6', '6', 'ESTADO SEIS', 'CIUDAD SEIS', 6),
('CALLE SIETE', '7', '7', 'ESTADO SIETE', 'CIUDAD SIETE', 7),
('CALLE OCHO', '8', '8', 'ESTADO OCHO', 'CIUDAD OCHO', 8),
('CALLE NUEVE', '9', '9', 'ESTADO NUEVE', 'CIUDAD NUEVE', 9),
('CALLE DIEZ', '10', '10', 'ESTADO DIEZ', 'CIUDAD DIEZ', 10);

INSERT INTO payment_method (full_name_pmd, number_card_pmd, number_cvc_pmd, date_card_pmd, flag_pmd, id_client_pmd) VALUES 
('JUAN PEREZ GOMEZ', '1234567812345678', '123', '12-24', 'VISA', 1),
('MARIA RODRIGUEZ LOPEZ', '2345678923456789', '234', '11-23', 'MASTERCARD', 2),
('CARLOS HERNANDEZ MARTINEZ', '3456789034567890', '345', '10-22', 'AMEX', 3),
('ANA GONZALEZ GARCIA', '4567890145678901', '456', '09-21', 'VISA', 4),
('JOSE MARTINEZ LOPEZ', '5678901256789012', '567', '08-20', 'MASTERCARD', 5),
('LUIS RAMIREZ RODRIGUEZ', '6789012367890123', '678', '07-19', 'AMEX', 6),
('ELENA FERNANDEZ SANCHEZ', '7890123478901234', '789', '06-18', 'VISA', 7),
('ALBERTO TORRES CASTRO', '8901234589012345', '890', '05-17', 'MASTERCARD', 8),
('PABLO RIAZ MORALES', '9012345690123456', '901', '04-16', 'AMEX', 9),
('SOFIA MENDOZA GUTIERREZ', '0123456701234567', '012', '03-15', 'VISA', 10);

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

INSERT INTO plan (name_pln, price_pln) VALUES 
('PLAN BASICO', 200.00),
('PLAN PREMIUM', 400.00),
('PLAN ELITE', 600.00);

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

INSERT INTO payment (payment_description_pyt, due_date_pyt, star_date_pyt, end_date_pyt, total_balance_pyt, flag_pmd, id_client_pyt)
VALUES 
('MENSUALIDAD DE MAYO', '10-JUN-2024', '04/05/2024', '03/06/2024', 200.00, 'MASTERCARD', 1),
('PAGO DE MANTENIMIENTO', '11-MAY-2024', NULL, NULL, 14.99, NULL, 1),
('PAGO DE INSCRIPCIÓN', '10-MAY-2024', NULL, NULL, 0.00, NULL, 1),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 200.00, 'VISA', 1),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 200.00, 'VISA', 2),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 400.00, 'VISA', 3),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 400.00, 'MASTERCARD', 4),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 400.00, 'MASTERCARD', 5),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 600.00, 'VISA', 6),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 600.00, 'MASTERCARD', 7),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 600.00, 'VISA', 8),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 600.00, 'AMEX', 9),
('MENSUALIDAD DE JUNIO', '10-JUL-2024', '04/06/2024', '03/07/2024', 600.00, 'AMEX', 10);

INSERT INTO client_plan_training_unit (id_client_cpl, id_plan_cpl, start_date_cpl, id_training_unit_cpl) VALUES
(1, 1, 'Mayo de 2024', 1),
(2, 1, 'Junio de 2024', 2),
(3, 2, 'Junio de 2024', 3),
(4, 2, 'Junio de 2024', 4),
(5, 2, 'Junio de 2024', 5),
(6, 3, 'Junio de 2024', 6),
(7, 3, 'Junio de 2024', 7),
(8, 3, 'Junio de 2024', 8),
(9, 3, 'Junio de 2024', 9),
(10, 3, 'Junio de 2024', 10);
