CREATE USER furmaxtemplate WITH
 LOGIN
 SUPERUSER
 CREATEDB
 CREATEROLE
 REPLICATION;

GRANT postgres TO furmaxtemplate;

COMMENT ON ROLE furmaxtemplate IS 'utente furmaxtemplate';

CREATE DATABASE furmaxtemplate ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';

ALTER DATABASE furmaxtemplate OWNER TO furmaxtemplate;

