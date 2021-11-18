-- SET FOREIGN_KEY_CHECKS=0;

INSERT INTO db1001_transport.roles
(code,  name)
VALUES
('ADM', 'Administrator'),
('DPA', 'Activity reporter'),
('CTA', 'Activity Consultant'),
('CPA', 'Consultant by activity');

INSERT INTO db1001_transport.users
(id, first_name , last_name , email                     , phone              , activity            , role_code , version , creation_date , creation_user)
VALUES
(1, 'John'      , 'Doe'     , 'john_doe@gmai.com'       , '0034 77 11 00 22' , 'Administrator'     , 'ADM'     , 1       , CURRENT_DATE  , 'Script'),
(2, 'Jane'      , 'Doe'     , 'jane_doe@gmai.com'       , '0034 77 11 20 20' , 'Activity reporter' , 'DPA'     , 1       , CURRENT_DATE  , 'Script');

-- SET FOREIGN_KEY_CHECKS=1;
COMMIT;