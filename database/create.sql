CREATE
DATABASE db_ninja_van;

CREATE
USER ninja_van WITH PASSWORD 'passwordis123';

GRANT ALL PRIVILEGES ON DATABASE
db_ninja_van TO ninja_van;

-- Sprint Boot

CREATE TABLE waypoint
(
    w_address  VARCHAR PRIMARY KEY,
    w_delivery BOOLEAN
)


CREATE TABLE location_zone
(
    z_name       CHAR NOT NULL PRIMARY KEY,
    z_num_parcel INT
);

-- TBA

CREATE TABLE location_subzone
(
    sz_name        CHAR NOT NULL PRIMARY KEY,
    sz_num_parcel  INT,
    sz_parent_zone CHAR
);

CREATE TABLE route
(
    r_name           CHAR NOT NULL PRIMARY KEY,
    r_num_parcel     INT,
    r_parent_zone    CHAR,
    r_parent_subzone CHAR
);

CREATE TABLE driver
(
    d_id   VARCHAR NOT NULL PRIMARY KEY,
    d_name VARCHAR NOT NULL
);