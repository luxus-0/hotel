DROP TABLE IF EXISTS reservation;

CREATE TABLE reservation (
id LONG AUTO_INCREMENT PRIMARY KEY,
adultNumber INTEGER NOT NULL,
childrenNumber INTEGER NOT NULL,
extraBedNumber INTEGER NOT NULL,
isPayment Boolean NOT NULL
);
