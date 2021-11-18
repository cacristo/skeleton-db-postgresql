-- PostgreSQL 9.5         ---------------------------------------------------------------------------------------------
-- --------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS db1001_transport.roles CASCADE;
CREATE TABLE db1001_transport.roles
(
    code   VARCHAR(10)  NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    CONSTRAINT ROLE_PKEY PRIMARY KEY (code)
);

DROP TABLE IF EXISTS db1001_transport.users CASCADE;
CREATE TABLE db1001_transport.users
(
    id               BIGSERIAL    NOT NULL,
    first_name       VARCHAR(255) NOT NULL,
    last_name        VARCHAR(255) NOT NULL,
    email            VARCHAR(255) NOT NULL,
    phone            VARCHAR(255) NOT NULL,
    activity         VARCHAR(255) NOT NULL,
    role_code        VARCHAR(10)  NOT NULL,
    "version"        INT8         NOT NULL,
    creation_date    TIMESTAMP    NULL,
    creation_user    VARCHAR(255) NULL,
    last_update_date TIMESTAMP    NULL,
    last_update_user VARCHAR(255) NULL,
    CONSTRAINT USERS_PKEY PRIMARY KEY (id),
    CONSTRAINT USER_ROLE_ID_FK FOREIGN KEY (role_code) REFERENCES db1001_transport.roles (code)
);


-- ---------------------------------------------------------------------------------------------
--    Tables Configuration      ----------------------------------------------------------------
DROP TABLE IF EXISTS db1001_transport.parameters_configuration CASCADE;
CREATE TABLE db1001_transport.parameters_configuration
(
    id               BIGSERIAL    NOT NULL,
    name             VARCHAR(255) NOT NULL,
    value            VARCHAR(255) NOT NULL,
    type             VARCHAR(255) NOT NULL,
    description      VARCHAR(255) NULL,
    "version"        INT8         NOT NULL,
    creation_date    TIMESTAMP    NULL,
    creation_user    VARCHAR(255) NULL,
    last_update_date TIMESTAMP    NULL,
    last_update_user VARCHAR(255) NULL,
    CONSTRAINT parameters_configuration_pkey PRIMARY KEY (id)
);

-- key_expire_parameter (Save token FID) -----------------------
DROP TABLE IF EXISTS db1001_transport.key_expire_parameter CASCADE;
CREATE TABLE db1001_transport.key_expire_parameter
(
    timestamp  TIMESTAMP NOT NULL DEFAULT NOW(),
    id_token   TEXT      NOT NULL,
    token_type TEXT      NOT NULL
);


-- ---------------------------------------------------------------------------------------------
-- Trigger key_expire_parameters         -------------------------------------------------------
-- ---------------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION db1001_transport.key_expire_parameter_table_delete_old_rows()
    RETURNS trigger
    LANGUAGE plpgsql
AS $function$
BEGIN
    DELETE FROM db1001_transport.key_expire_parameter;
    RETURN NEW;
END;
$function$
;

DROP TRIGGER IF EXISTS key_expire_parameter_table_delete_old_rows_trigger ON db1001_transport.key_expire_parameter;
CREATE TRIGGER key_expire_parameter_table_delete_old_rows_trigger
    BEFORE INSERT ON db1001_transport.key_expire_parameter
    FOR EACH STATEMENT EXECUTE PROCEDURE db1001_transport.key_expire_parameter_table_delete_old_rows();

COMMIT;