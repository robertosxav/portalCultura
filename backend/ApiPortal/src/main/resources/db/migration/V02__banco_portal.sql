CREATE TABLE public.acao_categoria (
    acao_categoria_id integer NOT NULL,
    acao_categoria_nome character varying(120) NOT NULL,
    acao_categoria_ativo boolean NOT NULL,
    acao_categoria_inc_em timestamp without time zone NOT NULL,
    acao_categoria_alt_em timestamp without time zone
);

CREATE SEQUENCE public.area_cultural_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.area_cultural (
    area_cultural_id integer DEFAULT nextval('public.area_cultural_id'::regclass) NOT NULL,
    area_cultural_nome character varying(120) NOT NULL,
    area_cultural_ativo boolean NOT NULL,
    area_cultural_inc_em timestamp without time zone NOT NULL,
    area_cultural_alt_em timestamp without time zone
);


CREATE SEQUENCE public.edital_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.edital (
    edital_id bigint DEFAULT nextval('public.edital_id'::regclass) NOT NULL,
    edital_titulo character varying(120) NOT NULL,
    edital_observacao text NOT NULL,
    edital_dta_abertura date NOT NULL,
    edital_dta_encerramento date NOT NULL,
    edital_status smallint NOT NULL
);



CREATE SEQUENCE public.linha_acao_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



CREATE TABLE public.linha_acao (
    linha_acao_id bigint DEFAULT nextval('public.linha_acao_id'::regclass) NOT NULL,
    linha_acao_nome character varying(120) NOT NULL,
    linha_acao_ativo boolean NOT NULL,
    linha_acao_inc_em timestamp without time zone NOT NULL,
    linha_acao_alt_em timestamp without time zone,
    acao_categoria_id integer NOT NULL
);


CREATE SEQUENCE public.macro_regiao_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.macro_regiao (
    macro_regiao_id bigint DEFAULT nextval('public.macro_regiao_id'::regclass) NOT NULL,
    macro_regiao_nome character varying(120) NOT NULL,
    macro_regiao_ativo boolean NOT NULL
);


CREATE SEQUENCE public.micro_regiao_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.micro_regiao (
    micro_regiao_id bigint DEFAULT nextval('public.micro_regiao_id'::regclass) NOT NULL,
    micro_regiao_nome character varying(120) NOT NULL,
    micro_regiao_ativo boolean NOT NULL,
    macro_regiao_id bigint NOT NULL
);


CREATE SEQUENCE public.pessoa_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.pessoa (
    pessoa_id bigint DEFAULT nextval('public.pessoa_id'::regclass) NOT NULL,
    pessoa_nome character varying(120) NOT NULL,
    pessoa_cpf character varying(40) NOT NULL,
    pessoa_rg character varying(40) NOT NULL,
    pessoa_orgao_expeditor character varying(40) NOT NULL,
    pessoa_data_nasc date NOT NULL,
    pessoa_email character varying(100) NOT NULL,
    pessoa_email_alter character varying(100) NOT NULL,
    pessoa_telefone character(20) NOT NULL,
    pessoa_celular character(20),
    pessoa_cep character varying(40) NOT NULL,
    pessoa_endereco character varying(120) NOT NULL,
    pessoa_numero character varying(40) NOT NULL,
    pessoa_complemento character varying(40) NOT NULL,
    pessoa_bairro character varying(40) NOT NULL,
    pessoa_municipio character varying(40) NOT NULL,
    pessoa_uf character varying(2) NOT NULL
);



CREATE SEQUENCE public.producao_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.producao (
    producao_id integer DEFAULT nextval('public.producao_id'::regclass) NOT NULL,
    producao_nome character varying(120) NOT NULL,
    producao_ativo boolean NOT NULL,
    producao_inc_em timestamp without time zone NOT NULL,
    producao_upd_em timestamp without time zone
);



CREATE SEQUENCE public.projeto_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.projeto (
    projeto_id bigint DEFAULT nextval('public.projeto_id'::regclass) NOT NULL,
    pessoa_id bigint NOT NULL,
    projeto_nome smallint NOT NULL,
    projeto_status smallint NOT NULL,
    producao_id integer NOT NULL,
    area_cultural_id integer NOT NULL,
    edital_id bigint NOT NULL
);


CREATE SEQUENCE public.projeto_abrangencia_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.projeto_abrangencia (
    projeto_abrangencia_id bigint DEFAULT nextval('public.projeto_abrangencia_id'::regclass) NOT NULL,
    projeto_id bigint NOT NULL,
    micro_regiao_id bigint NOT NULL
);

 

CREATE TABLE public.projeto_anexos (
    projeto_anexos_id smallint NOT NULL,
    tipo_documento_id bigint NOT NULL,
    projeto_anexos_venc date NOT NULL,
    projeto_anexos_blob bytea NOT NULL,
    projeto_anexos_blob_tipo character varying(40) NOT NULL,
    projeto_anexos_blob_name character varying(120) NOT NULL,
    projeto_id bigint NOT NULL
);

CREATE SEQUENCE public.projeto_coordenador_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.projeto_coordenador (
    projeto_coordenador_id integer DEFAULT nextval('public.projeto_coordenador_id'::regclass) NOT NULL,
    projeto_coordenador_nome character varying(120) NOT NULL,
    projeto_coordenador_cpf character varying(40) NOT NULL,
    projeto_coordenador_rg character varying(40) NOT NULL,
    projeto_coordenador_orgexpedit character varying(40) NOT NULL,
    projeto_coordenador_email character varying(100) NOT NULL,
    projeto_coordenador_tel character(20) NOT NULL,
    projeto_coordenador_cel character(20) NOT NULL,
    projeto_coordenador_cep character varying(40) NOT NULL,
    projeto_coordenador_end character varying(120) NOT NULL,
    projeto_coordenador_end_num character varying(40) NOT NULL,
    projeto_coordenador_end_comp character varying(40) NOT NULL,
    projeto_coordenador_end_bairro character varying(40) NOT NULL,
    projeto_coordenador_end_mun character varying(40) NOT NULL,
    projeto_coordenador_end_uf smallint NOT NULL,
    projeto_coordenador_obs text NOT NULL,
    projeto_id bigint NOT NULL
);

CREATE SEQUENCE public.projeto_dados_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.projeto_dados (
    projeto_dados_id bigint DEFAULT nextval('public.projeto_dados_id'::regclass) NOT NULL,
    projeto_id bigint NOT NULL,
    projeto_dados_resumo text NOT NULL,
    projeto_dados_descricao text NOT NULL,
    projeto_dados_objetivos text NOT NULL,
    projeto_dados_justificativa text NOT NULL,
    projeto_dados_estrategia text NOT NULL,
    projeto_dados_parcerias text NOT NULL,
    projeto_dados_acessibilidade text NOT NULL,
    projeto_dados_produto text NOT NULL
);


CREATE SEQUENCE public.projeto_equipe_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

   
CREATE TABLE public.projeto_equipe (
    projeto_equipe_id bigint DEFAULT nextval('public.projeto_equipe_id'::regclass) NOT NULL,
    projeto_equipe_nome character varying(120) NOT NULL,
    projeto_equipe_funcao character varying(120) NOT NULL,
    projeto_equipe_mini_cv text NOT NULL,
    projeto_id bigint NOT NULL
);



CREATE SEQUENCE public.projeto_linha_acao_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.projeto_linha_acao (
    projeto_linha_acao_id bigint DEFAULT nextval('public.projeto_linha_acao_id'::regclass) NOT NULL,
    projeto_id bigint NOT NULL,
    linha_acao_id bigint NOT NULL
);



CREATE SEQUENCE public.projeto_plano_dist_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.projeto_plano_dist (
    projeto_plano_dist_id integer DEFAULT nextval('public.projeto_plano_dist_id'::regclass) NOT NULL,
    projeto_plano_dist_espaco character varying(400) NOT NULL,
    projeto_plano_dist_capacidade character varying(400) NOT NULL,
    projeto_plano_dist_publico character varying(40) NOT NULL,
    projeto_plano_dist_acesso smallint NOT NULL,
    projeto_plano_dist_dta_ini date NOT NULL,
    projeto_plano_dist_dta_fim date NOT NULL,
    projeto_plano_dist_dta_rel_ini date NOT NULL,
    projeto_plano_dist_dta_rel_fim smallint NOT NULL,
    projeto_plano_dist_comu text NOT NULL,
    projeto_plano_dist_rec_bruta numeric(17,2) NOT NULL,
    projeto_plano_dist_rec_liq numeric(17,2) NOT NULL,
    projeto_plano_dist_obs text NOT NULL,
    projeto_id bigint NOT NULL
);

CREATE SEQUENCE public.projeto_recurso_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.projeto_recurso (
    projeto_recurso_id bigint DEFAULT nextval('public.projeto_recurso_id'::regclass) NOT NULL,
    projeto_recurso_pessoal numeric(17,2) NOT NULL,
    projeto_recurso_estrutura numeric(17,2) NOT NULL,
    projeto_recurso_logistica numeric(17,2) NOT NULL,
    projeto_recurso_divulgacao numeric(17,2) NOT NULL,
    projeto_recurso_despesas numeric(17,2) NOT NULL,
    projeto_recurso_imposto numeric(17,2) NOT NULL,
    projeto_recurso_total numeric(17,2) NOT NULL,
    projeto_recurso_solicitado numeric(17,2) NOT NULL,
    projeto_recurso_outrasleis numeric(17,2) NOT NULL,
    projeto_recurso_proprio numeric(17,2) NOT NULL,
    projeto_recurso_outros numeric(17,2) NOT NULL,
    projeto_recurso_prj_total numeric(17,2) NOT NULL,
    projeto_recurso_contemplado boolean NOT NULL,
    projeto_recurso_edicao text NOT NULL,
    projeto_recurso_patrocinado boolean NOT NULL,
    projeto_recurso_propjarec boolean NOT NULL,
    projeto_id bigint NOT NULL
);


CREATE SEQUENCE public.projeto_responsavel_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.projeto_responsavel (
    projeto_responsavel_id bigint DEFAULT nextval('public.projeto_responsavel_id'::regclass) NOT NULL,
    projeto_responsavel_nome character varying(120) NOT NULL,
    projeto_responsavel_cpf character varying(40) NOT NULL,
    projeto_responsavel_rg character varying(40) NOT NULL,
    projeto_responsavel_orgexpedit character varying(40) NOT NULL,
    projeto_responsavel_email character varying(40) NOT NULL,
    projeto_responsavel_tel character(20) NOT NULL,
    projeto_responsavel_cel character(20) NOT NULL,
    projeto_responsavel_cep character varying(40) NOT NULL,
    projeto_responsavel_end character varying(120) NOT NULL,
    projeto_responsavel_num character varying(40) NOT NULL,
    projeto_responsavel_comp character varying(40) NOT NULL,
    projeto_responsavel_bairro character varying(40) NOT NULL,
    projeto_responsavel_mun character varying(40) NOT NULL,
    projeto_responsavel_uf character varying(40) NOT NULL,
    projeto_responsavel_obs text NOT NULL,
    projeto_id bigint NOT NULL
);


CREATE SEQUENCE public.tipo_documento_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.tipo_documento (
    tipo_documento_id bigint DEFAULT nextval('public.tipo_documento_id'::regclass) NOT NULL,
    tipo_documento_nome character varying(120) NOT NULL,
    tipo_documento_ativo boolean NOT NULL,
    tipo_documento_inc_em timestamp without time zone NOT NULL,
    tipo_documento_alt_em timestamp without time zone NOT NULL
);


ALTER TABLE ONLY public.acao_categoria
    ADD CONSTRAINT acao_categoria_pkey PRIMARY KEY (acao_categoria_id);


ALTER TABLE ONLY public.area_cultural
    ADD CONSTRAINT area_cultural_pkey PRIMARY KEY (area_cultural_id);

   
ALTER TABLE ONLY public.edital
    ADD CONSTRAINT edital_pkey PRIMARY KEY (edital_id);


ALTER TABLE ONLY public.linha_acao
    ADD CONSTRAINT linha_acao_pkey PRIMARY KEY (linha_acao_id);


ALTER TABLE ONLY public.macro_regiao
    ADD CONSTRAINT macro_regiao_pkey PRIMARY KEY (macro_regiao_id);


ALTER TABLE ONLY public.micro_regiao
    ADD CONSTRAINT micro_regiao_pkey PRIMARY KEY (micro_regiao_id);


ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (pessoa_id);


ALTER TABLE ONLY public.producao
    ADD CONSTRAINT producao_pkey PRIMARY KEY (producao_id);


ALTER TABLE ONLY public.projeto_abrangencia
    ADD CONSTRAINT projeto_abrangencia_pkey PRIMARY KEY (projeto_abrangencia_id);


ALTER TABLE ONLY public.projeto_anexos
    ADD CONSTRAINT projeto_anexos_pkey PRIMARY KEY (projeto_anexos_id);


ALTER TABLE ONLY public.projeto_coordenador
    ADD CONSTRAINT projeto_coordenador_pkey PRIMARY KEY (projeto_coordenador_id);

   
ALTER TABLE ONLY public.projeto_dados
    ADD CONSTRAINT projeto_dados_pkey PRIMARY KEY (projeto_dados_id);


ALTER TABLE ONLY public.projeto_equipe
    ADD CONSTRAINT projeto_equipe_pkey PRIMARY KEY (projeto_equipe_id);


ALTER TABLE ONLY public.projeto_linha_acao
    ADD CONSTRAINT projeto_linha_acao_pkey PRIMARY KEY (projeto_linha_acao_id);

   
ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_pkey PRIMARY KEY (projeto_id);


ALTER TABLE ONLY public.projeto_plano_dist
    ADD CONSTRAINT projeto_plano_dist_pkey PRIMARY KEY (projeto_plano_dist_id);

   
ALTER TABLE ONLY public.projeto_recurso
    ADD CONSTRAINT projeto_recurso_pkey PRIMARY KEY (projeto_recurso_id);


ALTER TABLE ONLY public.projeto_responsavel
    ADD CONSTRAINT projeto_responsavel_pkey PRIMARY KEY (projeto_responsavel_id);


ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_pkey PRIMARY KEY (tipo_documento_id);


CREATE INDEX ilinha_acao1 ON public.linha_acao USING btree (acao_categoria_id);


CREATE INDEX imicro_regiao1 ON public.micro_regiao USING btree (macro_regiao_id);


CREATE INDEX iprojeto1 ON public.projeto USING btree (pessoa_id);


CREATE INDEX iprojeto2 ON public.projeto USING btree (area_cultural_id);


CREATE INDEX iprojeto3 ON public.projeto USING btree (producao_id);


CREATE INDEX iprojeto4 ON public.projeto USING btree (edital_id);


CREATE INDEX iprojeto_abrangencia1 ON public.projeto_abrangencia USING btree (micro_regiao_id);


CREATE INDEX iprojeto_abrangencia2 ON public.projeto_abrangencia USING btree (projeto_id);


CREATE INDEX iprojeto_anexos1 ON public.projeto_anexos USING btree (tipo_documento_id);


CREATE INDEX iprojeto_anexos2 ON public.projeto_anexos USING btree (projeto_id);


CREATE INDEX iprojeto_coordenador1 ON public.projeto_coordenador USING btree (projeto_id);


CREATE INDEX iprojeto_dados1 ON public.projeto_dados USING btree (projeto_id);


CREATE INDEX iprojeto_equipe1 ON public.projeto_equipe USING btree (projeto_id);


CREATE INDEX iprojeto_linha_acao1 ON public.projeto_linha_acao USING btree (linha_acao_id);


CREATE INDEX iprojeto_linha_acao2 ON public.projeto_linha_acao USING btree (projeto_id);


CREATE INDEX iprojeto_plano_dist1 ON public.projeto_plano_dist USING btree (projeto_id);


CREATE INDEX iprojeto_recurso1 ON public.projeto_recurso USING btree (projeto_id);


CREATE INDEX iprojeto_responsavel1 ON public.projeto_responsavel USING btree (projeto_id);


ALTER TABLE ONLY public.linha_acao
    ADD CONSTRAINT ilinha_acao1 FOREIGN KEY (acao_categoria_id) REFERENCES public.acao_categoria(acao_categoria_id);


ALTER TABLE ONLY public.micro_regiao
    ADD CONSTRAINT imicro_regiao1 FOREIGN KEY (macro_regiao_id) REFERENCES public.macro_regiao(macro_regiao_id);



ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT iprojeto1 FOREIGN KEY (pessoa_id) REFERENCES public.pessoa(pessoa_id);


ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT iprojeto2 FOREIGN KEY (area_cultural_id) REFERENCES public.area_cultural(area_cultural_id);


ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT iprojeto3 FOREIGN KEY (producao_id) REFERENCES public.producao(producao_id);


ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT iprojeto4 FOREIGN KEY (edital_id) REFERENCES public.edital(edital_id);


ALTER TABLE ONLY public.projeto_abrangencia
    ADD CONSTRAINT iprojeto_abrangencia1 FOREIGN KEY (micro_regiao_id) REFERENCES public.micro_regiao(micro_regiao_id);

   
ALTER TABLE ONLY public.projeto_abrangencia
    ADD CONSTRAINT iprojeto_abrangencia2 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);


ALTER TABLE ONLY public.projeto_anexos
    ADD CONSTRAINT iprojeto_anexos1 FOREIGN KEY (tipo_documento_id) REFERENCES public.tipo_documento(tipo_documento_id);


ALTER TABLE ONLY public.projeto_anexos
    ADD CONSTRAINT iprojeto_anexos2 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);


ALTER TABLE ONLY public.projeto_coordenador
    ADD CONSTRAINT iprojeto_coordenador1 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);

   
ALTER TABLE ONLY public.projeto_dados
    ADD CONSTRAINT iprojeto_dados1 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);


ALTER TABLE ONLY public.projeto_equipe
    ADD CONSTRAINT iprojeto_equipe1 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);

   
ALTER TABLE ONLY public.projeto_linha_acao
    ADD CONSTRAINT iprojeto_linha_acao1 FOREIGN KEY (linha_acao_id) REFERENCES public.linha_acao(linha_acao_id);


ALTER TABLE ONLY public.projeto_linha_acao
    ADD CONSTRAINT iprojeto_linha_acao2 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);


ALTER TABLE ONLY public.projeto_plano_dist
    ADD CONSTRAINT iprojeto_plano_dist1 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);

   
ALTER TABLE ONLY public.projeto_recurso
    ADD CONSTRAINT iprojeto_recurso1 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);


ALTER TABLE ONLY public.projeto_responsavel
    ADD CONSTRAINT iprojeto_responsavel1 FOREIGN KEY (projeto_id) REFERENCES public.projeto(projeto_id);


