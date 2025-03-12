-- create table todo (done, id, target_date, description, username, primary key (id))

insert into todo(id, username, description, target_date, done) values
(1001, 'nafiz', 'Learn Java', CURRENT_DATE(), false),
(1002, 'kamal', 'Learn Spring', CURRENT_DATE(), false);

ALTER TABLE todo ALTER COLUMN id RESTART WITH 1004;

