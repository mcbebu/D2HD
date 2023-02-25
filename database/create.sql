CREATE TABLE waypoint
(
    w_con_address     VARCHAR NOT NULL PRIMARY KEY, -- Consignee address.
    w_con_fullname    VARCHAR NOT NULL,             -- Consignee full name.
    w_has_visited     BOOLEAN DEFAULT FALSE,        -- Driver has visited a specific waypoint.
    w_delivery_status VARCHAR DEFAULT NULL          -- Driver has attempted to deliver parcel.
);

/*
TODO Enum
pending
completed
fail
cancelled
*/

-- DB 2.0
CREATE TABLE consignee
(
    c_user_name   VARCHAR NOT NULL PRIMARY KEY, -- e.g. 'user001'.
    c_password    VARCHAR NOT NULL,             -- e.g. 'password123'.
    c_name        VARCHAR NOT NULL,             -- Full Name, e.g. 'John Doe'.
    c_address     VARCHAR NOT NULL,             -- e.g. '123 Lorong Longkang'.
    c_postal_code VARCHAR DEFAULT NULL          -- May not be an option for addresses in other countries.
);