CREATE OR REPLACE FUNCTION db_insert_log(p_texto text, p_service_name text, p_class_name text, p_reference text) RETURNS INT
 LANGUAGE plpgsql
 AS $$
  DECLARE
        d_log_date timestamp = now();
        number_log_id int;
  BEGIN

  select nextval('db_application_log_sequence') into number_log_id;
  insert into db_application_log(log_id, time, content, service_name, class_name,reference)
  values(number_log_id, d_log_date,p_texto,p_service_name,p_class_name,p_reference) RETURNING log_id INTO number_log_id;

  RETURN number_log_id;

END;
$$;