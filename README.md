BANCO DE DADOS MYSQL 8  
username: root  
password: root  

CREATE database escoladb;  

-- TABELA: title  
INSERT INTO title (id, name) VALUES (1, 'Professor Doutor'), (2, 'Professor Associado');  

-- TABELA: department  
INSERT INTO departament (id, name) VALUES (1, 'Engenharia'), (2, 'Matemática');  

-- TABELA: professor  
INSERT INTO professor (id, department_id, title_id) VALUES (1, 1, 1), (2, 2, 2);  

-- TABELA: building  
INSERT INTO building (id, name) VALUES (1, 'Bloco A'), (2, 'Bloco B');  

-- TABELA: room  
INSERT INTO room (id, building_id) VALUES (1, 1), (2, 2);  

-- TABELA: subject  
INSERT INTO subject (id, subject_id, code, name) VALUES   
(1, 'MAT101', 'M101', 'Matemática I'),   
(2, 'MAT102', 'M102', 'Matemática II'),   
(3, 'FIS101', 'F101', 'Física I');  

-- TABELA: subject_prerequisite  
INSERT INTO subject_prerequisite (id, subject_id, prerequisite_id) VALUES   
(1, 2, 1), -- MAT102 depende de MAT101  
(2, 3, 1); -- FIS101 depende de MAT101  

-- TABELA: class  
INSERT INTO class (id, subject_id, taught_by, year, semester, code) VALUES   
(1, 1, 1, 2025, '1', 'C-MAT101'),  
(2, 2, 1, 2025, '2', 'C-MAT102'),  
(3, 3, 2, 2025, '1', 'C-FIS101');  

-- TABELA: class_schedule  
INSERT INTO class_schedule (id, class_id, room_id, day_of_week, start_time, end_time) VALUES   
(1, 1, 1, 'MONDAY', '08:00:00', '10:00:00'),  
(2, 2, 1, 'WEDNESDAY', '10:00:00', '12:00:00'),  
(3, 3, 2, 'FRIDAY', '14:00:00', '16:00:00');  




