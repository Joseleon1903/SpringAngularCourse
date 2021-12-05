CREATE OR REPLACE FUNCTION get_day_between_fn(p_first_date date, p_last_date date) RETURNS INT
 LANGUAGE plpgsql
 AS $$
  DECLARE
        number_day int;
  begin

	  number_day = p_first_date- p_last_date;

  RETURN ABS(number_day);

END;
$$;