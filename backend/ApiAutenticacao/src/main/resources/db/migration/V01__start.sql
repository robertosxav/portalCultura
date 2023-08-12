CREATE TABLE public.usuario (
	user_id smallint NOT NULL,
	username VARCHAR(100),
	password VARCHAR(100), 
	account_non_expired boolean,
	account_non_locked boolean,
	credentials_non_expired boolean,
	enabled boolean,
	PRIMARY KEY(user_id)
);
CREATE TABLE public.role (role_id smallint NOT NULL, nome_role VARCHAR(20),PRIMARY KEY(role_id));

CREATE TABLE public.usuario_role (user_role_id smallint NOT NULL,user_id smallint NOT NULL,role_id smallint NOT NULL,PRIMARY KEY(user_role_id));


ALTER TABLE public.usuario_role ADD CONSTRAINT usuario_role_1_fk FOREIGN KEY (user_id) REFERENCES public.usuario (user_id);
ALTER TABLE public.usuario_role ADD CONSTRAINT usuario_role_2_fk FOREIGN KEY (role_id) REFERENCES public.role (role_id);

CREATE SEQUENCE role_id start with 1 increment by 1;
CREATE SEQUENCE usuario_id start with 1 increment by 1;
commit;