CREATE TABLE waypoint
(
    w_address       VARCHAR NOT NULL PRIMARY KEY,

    -- TODO Update this two
    w_has_visited   BOOLEAN DEFAULT FALSE, -- Driver has visited a specific waypoint.
    w_has_attempted BOOLEAN DEFAULT NULL -- Driver has attempted to deliver parcel.
);

/*
TODO Enum
pending
completed
fail
cancelled
*/