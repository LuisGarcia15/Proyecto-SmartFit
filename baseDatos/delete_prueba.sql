UPDATE client_plan_training_unit
SET id_plan_cpl = NULL, id_training_unit_cpl = NULL
WHERE id_client_cpl = 1;
DELETE FROM client WHERE id_clt = 1;