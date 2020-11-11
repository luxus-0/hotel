DROP TABLE IF EXISTS address;

CREATE TABLE address (
id LONG AUTO_INCREMENT PRIMARY KEY,
street VARCHAR(255) NOT NULL,
streetNumber INTEGER NOT NULL,
apartmentNumber INTEGER NOT NULL,
postalCode VARCHAR(255) NOT NULL,
city VARCHAR(255) NOT NULL,
country VARCHAR(255) NOT NULL
);
