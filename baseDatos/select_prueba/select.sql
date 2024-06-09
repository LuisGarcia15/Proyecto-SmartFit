SELECT * FROM user;
SELECT * FROM contact_person;
SELECT * FROM client_address;
SELECT * FROM payment_method;
SELECT * FROM training_unit_address;
SELECT * FROM benefits;
SELECT * FROM training_unit;
SELECT * FROM plan;
SELECT * FROM plan_benefits;
SELECT * FROM plan_training_unit;
SELECT * FROM client_plan;
SELECT * FROM client;

/*user-client*/
SELECT * FROM user as u
INNER JOIN client as c on u.id_client_usr = id_clt;
/*client-contact person*/
SELECT * FROM client as c
INNER JOIN contact_person as cp on c.id_contact_person = cp.id_cpn;
/*client-address client*/
SELECT * FROM client as c
INNER JOIN client_address as ca on c.id_address = ca.id_cls;
/*client-payment method*/
SELECT * FROM client as c
INNER JOIN payment_method as pm on id_payment_method_clt = id_pmd;
/*client-client_plan-plan*/
SELECT * FROM client as c 
INNER JOIN client_plan as cp on c.id_clt = cp.id_client_cpl
INNER JOIN plan as p on cp.id_plan_cpl = p.id_pln;
/*plan-plan_training_unit-training_unit*/
SELECT * FROM plan as p 
INNER JOIN plan_training_unit as pt on p.id_pln = pt.id_plan_plb
INNER JOIN training_unit as tu on pt.id_training_unit_plb = tu.id_tru;
/*training_unit-training_unit_address*/
SELECT * FROM training_unit as tu
INNER JOIN training_unit_address as tua on tu.id_training_unit_address = tua.id_tru;
/*plan-plan_benefits-benefits*/
SELECT * FROM plan as p 
INNER JOIN plan_benefits as pb on p.id_pln = pb.id_plan_plb
INNER JOIN benefits as b on pb.id_benefits_plb = b.id_bns;
