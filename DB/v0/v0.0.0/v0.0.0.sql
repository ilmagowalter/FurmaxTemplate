CREATE ROLE furmaxtemplate WITH LOGIN SUPERUSER CREATEDB CREATEROLE INHERIT REPLICATION CONNECTION LIMIT -1 PASSWORD 'furmaxtemplate';
GRANT postgres TO furmaxtemplate;

COMMENT ON ROLE furmaxtemplate IS 'utente furmaxtemplate';

CREATE DATABASE furmaxtemplate ENCODING = 'UTF8' LC_COLLATE = 'Italian_Italy.1252' LC_CTYPE = 'Italian_Italy.1252';

ALTER DATABASE furmaxtemplate OWNER TO furmaxtemplate;

