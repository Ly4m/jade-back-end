INSERT INTO Collaborator (firstname, lastname) values ('William', 'Leemans');
INSERT INTO Collaborator (firstname, lastname) values ('Theo', 'Berkhout');
INSERT INTO Collaborator (firstname, lastname) values ('Florian', 'Lemaire');
INSERT INTO Collaborator (firstname, lastname) values ('Maxime', 'Buguel');
INSERT INTO Collaborator (firstname, lastname) values ('Ramzi', 'Achouri');

INSERT INTO activity_type (label) values ('Congé');
INSERT INTO activity_type (label) values ('Arrêt maladie');
INSERT INTO activity_type (label) values ('Prestation');

INSERT INTO activity_report (month, year, collaborator_id) values (1, 2018, 1);

INSERT INTO activity ("date", duration_in_hour, activity_report_id, activity_type_id) values ('2018-01-01', 8, 1, 3);
INSERT INTO activity ("date", duration_in_hour, activity_report_id, activity_type_id) values ('2018-01-02', 4, 1, 1);
INSERT INTO activity ("date", duration_in_hour, activity_report_id, activity_type_id) values ('2018-01-02', 4, 1, 2);
