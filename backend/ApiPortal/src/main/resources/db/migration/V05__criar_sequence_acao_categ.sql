CREATE SEQUENCE public.acao_categoria_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
ALTER TABLE public.acao_categoria
	ALTER COLUMN acao_categoria_id SET DEFAULT nextval('public.acao_categoria_id');