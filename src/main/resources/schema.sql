CREATE TABLE household (
                           eircode VARCHAR(255) PRIMARY KEY,
                           number_of_occupants INT NOT NULL,
                           maximum_occupants INT NOT NULL,
                           owner_occupied BOOLEAN
);
CREATE TABLE pet (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(255) NOT NULL,
                     breed VARCHAR(255) NOT NULL,
                     type VARCHAR(255) NOT NULL,
                     age INT NOT NULL,
                     household_eircode VARCHAR(255) NOT NULL,
                     FOREIGN KEY (household_eircode) REFERENCES household(eircode)
);

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL,
                       county VARCHAR(255) NOT NULL,
                       locked BOOLEAN DEFAULT FALSE,
                       role VARCHAR(50) NOT NULL
);


