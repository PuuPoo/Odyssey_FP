CREATE DATABASE `Odyssey_Data`;
USE `Odyssey_Data`;


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
