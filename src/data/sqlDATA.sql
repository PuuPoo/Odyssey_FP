DROP DATABASE IF EXISTS `Odyssey_Data`;
CREATE DATABASE `Odyssey_Data`;
USE `Odyssey_Data`;


-- Login information for doctors 
CREATE TABLE doctor_login_information(
	doctor_GMAIL VARCHAR(50),
    doctor_PASSWORD VARCHAR(50),
    PRIMARY KEY (doctor_GMAIL)
);

INSERT INTO doctor_login_information(doctor_GMAIL, doctor_PASSWORD)
VALUES
('doctor1@gmail.com', 'Password'),
('doctor2@gmail.com', 'Password'),
('doctor3@gmail.com', 'Password');


-- Doctor Information (Name)
CREATE TABLE doctor_information_name(
    doctor_GMAIL VARCHAR(50),
    doctor_USERNAME VARCHAR(50),
    PRIMARY KEY (doctor_GMAIL),
	FOREIGN KEY (doctor_GMAIL) REFERENCES doctor_login_information(doctor_GMAIL)
);

INSERT INTO doctor_information_name(doctor_GMAIL, doctor_USERNAME)
VALUES
('doctor1@gmail.com', 'Dr. Nizar Ramadhan'),
('doctor2@gmail.com', 'Dr. Kayla Limaran'),
('doctor3@gmail.com', 'Dr. Agie Winata');


-- Doctor Information (Patient)
CREATE TABLE doctor_information_patients(
    doctor_GMAIL VARCHAR(50),
    patient_name VARCHAR(50),
    patient_age TINYINT,
    patient_sickness VARCHAR(50),
    patient_contact VARCHAR(50),
    patient_severity INT,
    PRIMARY KEY (doctor_GMAIL, patient_name),
	FOREIGN KEY (doctor_GMAIL) REFERENCES doctor_login_information(doctor_GMAIL)
);

-- Doctor Information Patients
INSERT INTO doctor_information_patients(doctor_GMAIL, patient_name, patient_age, patient_sickness, patient_contact, patient_severity)
VALUES
('doctor1@gmail.com', 'Cassian Thorne', 27, 'Head Truma', '1989-5981-3136', 3),
('doctor1@gmail.com', 'Elara Vance', 78, 'Leg Fracture', '2341-5231-3811', 2),
('doctor1@gmail.com', 'Julian Sterling', 67, 'Bruised Knee', '0856-1321-6413',  1),
('doctor1@gmail.com', 'Mira Holloway', 23, 'Heart Attack', '9575-1657-5723', 9),
('doctor1@gmail.com', 'Timothy Cath', 31, 'Internal Bleeding', '4821-5824-1837', 9),
('doctor2@gmail.com', 'Robinson Stewart', 58, 'Dislocated Knee', '9533-5728-5729', 4);


-- Severity Score Index
CREATE TABLE sickness_severity_score(
	sickness_name VARCHAR(50),
    sickness_severity INT
);

-- Severity Score Index
INSERT INTO sickness_severity_score(sickness_name, sickness_severity)
VALUES
('Fever', 8),
('chills', 5),
('Fatigue/Weakness', 6),
('Unexplained Weight Loss', 12),
('Night Sweats', 9),

('Headache', 7),
('Dizziness / Vertigo', 10),
('Ringing in Ears (Tinnitus)', 4),
('Sore Throat', 3),
('Swollen Glands', 6),

('Dry Cough', 4),
('Productive Cough (Phleghm)', 5),
('Shortness of Breath', 18),
('Wheezing', 14),
('Chest Tightness', 16),

('Chest Pain', 20),
('Heart Palpatations (Racing Heart)', 15),
('Irregular Heartbeat', 17),
('Fainting Spells', 19),
('Swelling in Legs or Feet', 11),

('Nausea / Vomiting', 9),
('Abdominal Pain / Cramping', 10),
('Bloating', 3),
('Heartburn / Acid Reflux', 4),
('Loss of Appetite', 5),

('Joint Pain', 7),
('Muscle Aches (Myalgia)', 6),
('Back Pain', 8),
('Stiffness', 4),
('Limited Range of Motion', 9),

('Numbness or Tingling (Pins & Needles)', 12),
('Confusion / Memory Issues', 18),
('Skin Rash', 5),
('Itching (Pruritus)', 3),
('Vision Changess (Bluriness)', 15),

('Dry / Flaky Skin', 2),
('Redness (Erythema)', 4),
('Hives', 10),
('Blisters', 8),
('Hair Loss', 2);

