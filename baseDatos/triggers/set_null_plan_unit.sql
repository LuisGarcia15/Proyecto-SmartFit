DELIMITER //
CREATE TRIGGER SET_NULL_PLAN_UNIT
BEFORE DELETE ON client
FOR EACH ROW
BEGIN
	UPDATE client_plan_training_unit
	SET id_plan_cpl = NULL, id_training_unit_cpl = NULL
	WHERE id_client_cpl = OLD.id_clt;
END //
DELIMITER ; 