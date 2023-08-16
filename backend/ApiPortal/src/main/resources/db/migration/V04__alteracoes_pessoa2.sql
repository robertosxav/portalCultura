ALTER TABLE public.pessoa ADD pessoa_razao_social varchar(120) NULL;
ALTER TABLE public.pessoa ADD pessoa_insc_estadual varchar(20) NULL;
ALTER TABLE public.pessoa ADD pessoa_insc_municipal varchar(20) NULL;
ALTER TABLE public.pessoa ADD pessoa_nome_fantasia varchar(120) NULL;
ALTER TABLE public.pessoa ADD pessoa_mei boolean NULL DEFAULT false;

ALTER TABLE public.pessoa ALTER COLUMN pessoa_nome DROP NOT NULL;
ALTER TABLE public.pessoa ALTER COLUMN pessoa_cpf DROP NOT NULL;

ALTER TABLE public.pessoa ADD tipo_pessoa varchar NULL;
ALTER TABLE public.pessoa ADD pessoa_cnpj varchar(40) NULL;