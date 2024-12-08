INSERT INTO household (eircode, number_of_occupants, maximum_occupants, owner_occupied)
VALUES
    ('D02XY45', 3, 5, true),
    ('A94B6F3', 4, 6, false),
    ('T12AB34', 2, 4, true),
    ('C15DE67', 5, 7, true),
    ('F12GH89', 1, 2, false),
    ('B78IJ01', 3, 5, true),
    ('M34KL56', 4, 6, false),
    ('P90QR78', 2, 4, true),
    ('V23ST01', 5, 7, true),
    ('X5UV67', 1, 2, false),
    ('Y67WX89', 3, 5, true),
    ('Z01YZ23', 4, 6, false),
    ('Q45AB78', 2, 4, true),
    ('R67CD01', 5, 7, true),
    ('S23EF45', 1, 2, false);

INSERT INTO pet (name, breed, type, age, household_eircode)
VALUES
    ('Luna', 'Persian', 'Cat', 4, 'D02XY45'),
    ('Charlie', 'Golden Retriever', 'Dog', 2, 'D02XY45'),
    ('Bella', 'Siamese', 'Cat', 3, 'A94B6F3'),
    ('Rocky', 'German Shepherd', 'Dog', 5, 'T12AB34'),
    ('Oliver', 'Maine Coon', 'Cat', 1, 'C15DE67'),
    ('Lucy', 'Beagle', 'Dog', 4, 'C15DE67'),
    ('Milo', 'Ragdoll', 'Cat', 2, 'B78IJ01'),
    ('Leo', 'Labrador', 'Dog', 3, 'M34KL56'),
    ('Coco', 'British Shorthair', 'Cat', 5, 'P90QR78'),
    ('Max', 'Bulldog', 'Dog', 2, 'V23ST01'),
    ('Ruby', 'Scottish Fold', 'Cat', 1, 'Y67WX89'),
    ('Tucker', 'Husky', 'Dog', 4, 'Q45AB78'),
    ('Shadow', 'Russian Blue', 'Cat', 3, 'R67CD01'),
    ('Bailey', 'Poodle', 'Dog', 5, 'R67CD01');



/*INSERT INTO users (email, password, first_name, last_name, county, role)
VALUES
    ('admin@example.com', '$2a$10$L2S4MXpANm0g4WgNqIwdA.jrKwQZH7jgr5V.QaFAFX8mI.6/CgW1C', 'Admin', 'User', 'Cork', 'ADMIN');


UPDATE users SET role = 'ROLE_ADMIN' WHERE email = 'admin@example.com';*/

