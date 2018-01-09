CREATE TABLE address
(
  id                    INTEGER SERIAL NOT NULL
    CONSTRAINT address_pkey
    PRIMARY KEY,
  line_1                VARCHAR        NOT NULL,
  line_2                VARCHAR,
  line_3                VARCHAR,
  line_4                VARCHAR,
  city                  VARCHAR        NOT NULL,
  county_province       VARCHAR,
  postcode              VARCHAR        NOT NULL,
  country               VARCHAR        NOT NULL,
  other_address_details VARCHAR
);

CREATE TABLE collaborator
(
  id          INTEGER SERIAL NOT NULL
    CONSTRAINT collaborator_pkey
    PRIMARY KEY,
  firstname   VARCHAR(25),
  lastname    VARCHAR(50),
  function    VARCHAR(50),
  gravatar    VARCHAR(75),
  addresse_id INTEGER
    CONSTRAINT collaborator_address_id_fk
    REFERENCES address
);

CREATE UNIQUE INDEX collaborator_id_uindex
  ON collaborator (id);


CREATE TABLE activity_type
(
  id    INTEGER SERIAL NOT NULL
    CONSTRAINT activity_pkey
    PRIMARY KEY,
  label VARCHAR        NOT NULL
);


CREATE TABLE activity_report
(
  id              INTEGER SERIAL NOT NULL
    CONSTRAINT activity_report_pkey
    PRIMARY KEY,
  month           SMALLINT       NOT NULL,
  year            SMALLINT       NOT NULL,
  collaborator_id INTEGER        NOT NULL
    CONSTRAINT activity_report_collaborator_id_fk
    REFERENCES collaborator
);

CREATE TABLE activity
(
  id                 INTEGER SERIAL NOT NULL
    CONSTRAINT activity_pkey1
    PRIMARY KEY,
  "date"             DATE           NOT NULL,
  duration_in_hour   SMALLINT       NOT NULL,
  activity_report_id INTEGER        NOT NULL
    CONSTRAINT activity_activity_report_id_fk
    REFERENCES activity_report,
  activity_type_id   INTEGER        NOT NULL
    CONSTRAINT activity_activity_type_id_fk
    REFERENCES activity_type
);

CREATE TABLE client
(
  id         INTEGER SERIAL NOT NULL
    CONSTRAINT client_pkey
    PRIMARY KEY,
  name       VARCHAR        NOT NULL,
  address_id INTEGER
    CONSTRAINT client_address_id_fk
    REFERENCES address
);

CREATE TABLE IF NOT EXISTS mission_order
(
  id              INTEGER SERIAL NOT NULL
    CONSTRAINT misison_order_pkey
    PRIMARY KEY,
  collaborator_id INTEGER        NOT NULL
    CONSTRAINT misison_order_collaborator_id_fk
    REFERENCES collaborator,
  client_id       INTEGER        NOT NULL,
  start_date      DATE           NOT NULL,
  end_date        DATE,
  address_id      INTEGER
    CONSTRAINT mission_order_address_id_fk
    REFERENCES address
);
