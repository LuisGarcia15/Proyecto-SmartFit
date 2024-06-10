SELECT * FROM user; /*disparadores, borrar cascada*/
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

/*user-client*/
SELECT * FROM user as u
INNER JOIN client as c on u.id_client_usr = id_clt;
/*client-contact person*/
SELECT * FROM client as c
INNER JOIN contact_person as cp on c.id_clt = cp.id_client_cpn;
/*client-address client*/
SELECT * FROM client as c
INNER JOIN client_address as ca on c.id_clt = ca.id_client_cls;
/*client-payment*/
SELECT * FROM client as c
INNER JOIN payment as p on c.id_clt = p.id_client_pyt;
/*client-payment method*/
SELECT * FROM client as c
INNER JOIN payment_method as pm on c.id_clt = pm.id_client_pmd;
/*client-client_plan_training_unit-plan-training_unit*/
SELECT * FROM client as c 
INNER JOIN client_plan_training_unit as cp on c.id_clt = cp.id_client_cpl
INNER JOIN plan as p on cp.id_plan_cpl = p.id_pln
INNER JOIN training_unit as tu on cp.id_training_unit_cpl = tu.id_tru;
/*training_unit-training_unit_address*/
SELECT * FROM training_unit as tu
INNER JOIN training_unit_address as tua on tu.id_training_unit_address = tua.id_tru;
/*plan-plan_benefits-benefits*/
SELECT * FROM plan as p 
INNER JOIN plan_benefits as pb on p.id_pln = pb.id_plan_plb
INNER JOIN benefits as b on pb.id_benefits_plb = b.id_bns;