
CREATE TABLE file_cron(
  id int primary key auto_increment,
  filename VARCHAR(255),
  cron VARCHAR(50)
);

INSERT INTO file_cron (id, filename, cron) VALUES (DEFAULT , "a.txt", "0 30 10 * * *" ),
  (DEFAULT, "b.txt", "0 40 10 * * *"),
  (DEFAULT, "c.txt", "0 50 10 * * *");

SELECT * FROM file_cron;

CREATE TABLE file_check_result(
id int primary key auto_increment,
time DATETIME,
res VARCHAR(2) CHECK (res IN ("Y", "N")),
fc_id int,
constraint c_fk foreign key(fc_id) references file_cron(id)
);
# drop TABLE  file_check_result;
INSERT INTO file_check_result (id, time, res, fc_id) VALUES (DEFAULT, "2019-2-27 11:50:00", "Y", 1);
SELECT * FROM file_check_result LEFT JOIN file_cron ON file_check_result.fc_id=file_cron.id;
