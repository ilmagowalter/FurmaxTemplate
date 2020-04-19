-------TABELLA UTENTI
CREATE TABLE public.ana_users (
	id int8 NOT NULL,
	username varchar(255) NOT NULL,
	email varchar(4000) NOT NULL,
	firstname varchar(255) NOT NULL,
	lastname varchar(255) NOT NULL,
	phone varchar(255) NULL,
	"password" varchar(255) NOT NULL,
	enabled bool NOT NULL DEFAULT true,
	last_change_pwd timestamptz NULL,
	last_connect_time timestamptz NULL,
	"version" int8 NOT NULL DEFAULT 1,
	insert_time timestamptz NOT NULL,
	update_time timestamptz NOT NULL,
	id_user_insert int8 NOT NULL,
	id_user_update int8 NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY (id),
	CONSTRAINT uk_email UNIQUE (email),
	CONSTRAINT uk_username UNIQUE (username),
	CONSTRAINT fk_user_insert FOREIGN KEY (id_user_insert) REFERENCES ana_users(id),
	CONSTRAINT fk_user_update FOREIGN KEY (id_user_update) REFERENCES ana_users(id)
);
CREATE INDEX fki_fk_user ON public.ana_users USING btree (id_user_insert);
CREATE INDEX fki_fk_user_update ON public.ana_users USING btree (id_user_update);

CREATE SEQUENCE public.seq_ana_users
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 3
	CACHE 1
	NO CYCLE;

COMMENT ON SEQUENCE seq_ana_users IS 'per tabella ana_users';

INSERT INTO public.ana_users
(id, username, email, firstname, lastname, phone, "password", enabled, last_change_pwd, last_connect_time, "version", insert_time, update_time, id_user_insert, id_user_update)
VALUES(1, 'mfurnari', 'massimo.furnari@gpi.it', 'Massimo', 'Furnari', NULL, '8f225ddd400f8a0d6b36b85c6ccecc0436cea6a8e32f203fc5cef7932ffe5a0788eef1a1faf4acb307c5f831292574d6d05d3cad23f2468577b41c4c31ffc37a', true, current_timestamp, current_timestamp, 1, current_timestamp, current_timestamp, 1, 1);

-----TABELLA PARAMETRI DI SISTEMA
CREATE TABLE public.cfg_system_parameters (
	id int8 NOT NULL,
	param_code varchar(255) NOT NULL,
	param_value varchar(4000) NOT NULL,
	description varchar(4000) NOT NULL,
	"version" int8 NOT NULL,
	insert_time timestamptz NOT NULL,
	update_time timestamptz NOT NULL,
	id_user_insert int8 NULL,
	id_user_update int8 NULL,
	CONSTRAINT "CFG_SYSTEM_PARAMETERS_PKV1" PRIMARY KEY (id),
	CONSTRAINT "CFG_SYSTEM_PARAMETERS_UK" UNIQUE (param_code)
);
CREATE UNIQUE INDEX cfg_system_parameters_pkv1 ON public.cfg_system_parameters USING btree (id);
CREATE UNIQUE INDEX cfg_system_parameters_uk ON public.cfg_system_parameters USING btree (param_code);

CREATE SEQUENCE public.seq_cfg_system_parameters
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

COMMENT ON SEQUENCE seq_cfg_system_parameters IS 'per tabella cfg_system_parameters';

INSERT INTO public.cfg_system_parameters
(id, param_code, param_value, description, "version", insert_time, update_time, id_user_insert, id_user_update)
VALUES(nextval('seq_cfg_system_parameters'), 'TOKEN_TIME', '18000', 'Durata del token espressa in millisecondi', 1, current_timestamp, current_timestamp, 1, 1);

------TABELLA MESSAGGI DI SISTEMA

CREATE TABLE public.cfg_system_messages (
	id int8 NOT NULL,
	code varchar(255) NOT NULL,
	message varchar(4000) NOT NULL,
	"version" int8 NOT NULL DEFAULT 1,
	insert_time timestamptz NOT NULL,
	update_time timestamptz NOT NULL,
	id_user_insert int8 NULL,
	id_user_update int8 NULL,
	CONSTRAINT pk_cfg_system_messages PRIMARY KEY (id),
	CONSTRAINT uk_code_message UNIQUE (code)
);

CREATE SEQUENCE public.seq_cfg_system_messages
	INCREMENT BY 1
	NO MINVALUE
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

COMMENT ON SEQUENCE seq_cfg_system_messages IS 'per tabella cfg_system_messages';

INSERT INTO public.cfg_system_messages
(id, code, message, "version", insert_time, update_time, id_user_insert, id_user_update)
VALUES(nextval('seq_cfg_system_messages'), '001', 'Errore generico', 1, current_timestamp, current_timestamp, 1, 1);

INSERT INTO public.cfg_system_messages
(id, code, message, "version", insert_time, update_time, id_user_insert, id_user_update)
VALUES(nextval('seq_cfg_system_messages'), '100', 'Credenziali non valide', 1, current_timestamp, current_timestamp, 1, 1);

INSERT INTO public.cfg_system_messages 
(id, code, message, "version", insert_time, update_time, id_user_insert, id_user_update)
VALUES (
nextval('public.seq_cfg_system_messages'),
'101', -- Inserire il proprio codice
'Username esistente',
1,
current_timestamp,
current_timestamp,
1,
1);

INSERT INTO public.cfg_system_messages 
(id, code, message, "version", insert_time, update_time, id_user_insert, id_user_update)
VALUES (
nextval('public.seq_cfg_system_messages'),
'102', -- Inserire il proprio codice
'Email esistente',
1,
current_timestamp,
current_timestamp,
1,
1);

INSERT INTO public.cfg_system_messages 
(id, code, message, "version", insert_time, update_time, id_user_insert, id_user_update)
VALUES (
nextval('public.seq_cfg_system_messages'),
'103', -- Inserire il proprio codice
'Utente non trovato, id: ',
1,
current_timestamp,
current_timestamp,
1,
1);

