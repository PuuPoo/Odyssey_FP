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
('Nizar.Ramadhan@gmail.com', 'KansupKapan'),
('Kayla.Limaran@gmail.com', 'Snak3'),
('DoctorSigma.Agie@gmail.com', 'bestDoktor61'),
('Louis.Wibowo@gmail.com', 'GermanGlory88');


-- Doctor Information (Name)
CREATE TABLE doctor_information_name(
    doctor_GMAIL VARCHAR(50),
    doctor_USERNAME VARCHAR(50),
    PRIMARY KEY (doctor_GMAIL),
	FOREIGN KEY (doctor_GMAIL) REFERENCES doctor_login_information(doctor_GMAIL)
);

INSERT INTO doctor_information_name(doctor_GMAIL, doctor_USERNAME)
VALUES
('Nizar.Ramadhan@gmail.com', 'Dr. Nizar Ramadhan'),
('Kayla.Limaran@gmail.com', 'Dr. Kayla Limaran'),
('DoctorSigma.Agie@gmail.com', 'Dr. Agie Winata'),
('Louis.Wibowo@gmail.com', 'Dr. Louis Wibowo');

