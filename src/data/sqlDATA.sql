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
    severity INT,
    PRIMARY KEY (doctor_GMAIL, patient_name),
	FOREIGN KEY (doctor_GMAIL) REFERENCES doctor_login_information(doctor_GMAIL)
);

-- Doctor Information Patients
INSERT INTO doctor_information_patients(doctor_GMAIL, patient_name, patient_age, patient_sickness, patient_contact, severity)
VALUES
('doctor1@gmail.com', 'Cassian Thorne', 27, 'Head Truma', '1989-5981-3136', 3),
('doctor1@gmail.com', 'Elara Vance', 78, 'Leg Fracture', '2341-5231-3811', 2),
('doctor1@gmail.com', 'Julian Sterling', 67, 'Bruised Knee', '0856-1321-6413',  1),
('doctor1@gmail.com', 'Mira Holloway', 23, 'Heart Attack', '9575-1657-5723', 9),
('doctor1@gmail.com', 'Timothy Cath', 31, 'Internal Bleeding', '4821-5824-1837', 9);

