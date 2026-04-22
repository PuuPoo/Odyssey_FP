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
    severity INT,
    PRIMARY KEY (doctor_GMAIL, patient_name),
	FOREIGN KEY (doctor_GMAIL) REFERENCES doctor_login_information(doctor_GMAIL)
);

-- Doctor Information Patients
INSERT INTO doctor_information_patients(doctor_GMAIL, patient_name, severity)
VALUES
('doctor1@gmail.com', 'Cassian Thorne', 3),
('doctor1@gmail.com', 'Elara Vance', 2),
('doctor1@gmail.com', 'Julian Sterling', 1),
('doctor1@gmail.com', 'Mira Holloway', 9),
('doctor1@gmail.com', 'Timothy Cath', 9);

