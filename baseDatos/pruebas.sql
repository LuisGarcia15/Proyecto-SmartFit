SELECT * FROM user; /*borrar cascada*/
SELECT * FROM contact_person; /*borrar cascada*/
SELECT * FROM client_address; /*borrar cascada*/
SELECT * FROM payment; /*borrar cascada*/
SELECT * FROM payment_method; /*borrar cascada*/
SELECT * FROM training_unit_address; /*-*/
SELECT * FROM benefits; /*-*/
SELECT * FROM training_unit; /*-*/
SELECT * FROM plan; /*-*/
SELECT * FROM plan_benefits; /*-*/
SELECT * FROM client_plan_training_unit; /*disparadores, borrar cascada*/
SELECT * FROM client; /*disparadores, borrar cascada*/

-- Pruebas de integridad de datos
-- Supongamos que tienes dos tablas: user y client
-- Primero, verifica que todas las claves foráneas en user tienen una clave primaria correspondiente en client
-- Reralizar con todas las tablas
SELECT * FROM client WHERE id_clt NOT IN (SELECT id_client_usr FROM user);
SELECT * FROM client WHERE id_clt NOT IN (SELECT id_client_cpn FROM contact_person);
SELECT * FROM client WHERE id_clt NOT IN (SELECT id_client_pyt FROM payment);
SELECT * FROM client WHERE id_clt NOT IN (SELECT id_client_pmd FROM payment_method);
SELECT * FROM client WHERE id_clt NOT IN (SELECT id_client_cls FROM client_address);
SELECT * FROM client WHERE id_clt NOT IN (SELECT id_client_cpl FROM client_plan_training_unit);
SELECT * FROM client_plan_training_unit WHERE id_training_unit_cpl NOT IN (SELECT id_tru FROM training_unit);
SELECT * FROM client_plan_training_unit WHERE id_plan_cpl NOT IN (SELECT id_pln FROM plan);
SELECT * FROM plan WHERE id_pln NOT IN (SELECT id_plan_plb FROM plan_benefits);
SELECT * FROM plan_benefits WHERE id_plan_plb NOT IN (SELECT id_pln FROM plan);
SELECT * FROM plan_benefits WHERE id_benefits_plb NOT IN (SELECT id_bns FROM benefits);
SELECT * FROM benefits WHERE id_bns NOT IN (SELECT id_benefits_plb FROM plan_benefits);
SELECT * FROM training_unit WHERE id_training_unit_address NOT IN (SELECT id_tru FROM training_unit_address);

-- Verifica que no hay valores duplicados en la columna customer_id de la tabla customers
SELECT id_usr, COUNT(*) FROM user GROUP BY id_usr HAVING COUNT(*) > 0;
SELECT id_clt, COUNT(*) FROM client GROUP BY id_clt HAVING COUNT(*) > 0;
SELECT id_cpn, COUNT(*) FROM contact_person GROUP BY id_cpn HAVING COUNT(*) > 0;
SELECT id_cls, COUNT(*) FROM client_address GROUP BY id_cls HAVING COUNT(*) > 0;
SELECT id_pyt, COUNT(*) FROM payment GROUP BY id_pyt HAVING COUNT(*) > 0;
SELECT id_pmd, COUNT(*) FROM payment_method GROUP BY id_pmd HAVING COUNT(*) > 0;
SELECT id_tru, COUNT(*) FROM training_unit_address GROUP BY id_tru HAVING COUNT(*) > 0;
SELECT id_bns, COUNT(*) FROM benefits GROUP BY id_bns HAVING COUNT(*) > 0;
SELECT id_tru, COUNT(*) FROM training_unit GROUP BY id_tru HAVING COUNT(*) > 0;
SELECT id_pln, COUNT(*) FROM plan GROUP BY id_pln HAVING COUNT(*) > 0;
SELECT id_plan_plb,id_benefits_plb, COUNT(*) FROM plan_benefits GROUP BY id_plan_plb,id_benefits_plb HAVING COUNT(*) > 0;
SELECT id_client_cpl,start_date_cpl, COUNT(*) FROM client_plan_training_unit GROUP BY id_client_cpl,start_date_cpl HAVING COUNT(*) > 0;

-- Asegúrate de que los valores en la columna email de la tabla users siguen el formato de un correo electrónico
SELECT * FROM user WHERE user_usr NOT LIKE '%@%.%';
SELECT * FROM client WHERE email_clt NOT LIKE '%@%.%';

-- Pruebas de integridad de trigger y cascada
DELETE FROM client WHERE id_clt = 1;

