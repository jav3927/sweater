delete
from user_role;
delete
from usr;

insert into usr(id, active, password, username)
values (1, true, '$2a$08$XX0pqvICwnh9R1e8LrAuYOBDw6mapZ2twwJeeoBBXtijGzYqjGX4i', 'jav'),
       (2, true, '$2a$08$XX0pqvICwnh9R1e8LrAuYOBDw6mapZ2twwJeeoBBXtijGzYqjGX4i', 'akira');

insert into user_role(user_id, roles)
values (1, 'USER'),
       (1, 'ADMIN'),
       (2, 'USER');