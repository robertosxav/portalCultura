ALTER TABLE public.acao_categoria DROP COLUMN acao_categoria_ativo;
ALTER TABLE public.area_cultural DROP COLUMN area_cultural_ativo;
ALTER TABLE public.linha_acao DROP COLUMN linha_acao_ativo;
ALTER TABLE public.macro_regiao DROP COLUMN macro_regiao_ativo;
ALTER TABLE public.micro_regiao DROP COLUMN micro_regiao_ativo;
ALTER TABLE public.producao DROP COLUMN producao_ativo;
ALTER TABLE public.tipo_documento DROP COLUMN tipo_documento_ativo;

COMMIT;


ALTER TABLE public.acao_categoria ADD COLUMN acao_categoria_ativo numeric default 1;
ALTER TABLE public.area_cultural ADD COLUMN area_cultural_ativo  numeric default 1;
ALTER TABLE public.linha_acao ADD COLUMN linha_acao_ativo numeric default 1;
ALTER TABLE public.macro_regiao ADD COLUMN macro_regiao_ativo numeric default 1;
ALTER TABLE public.micro_regiao ADD COLUMN micro_regiao_ativo numeric default 1;
ALTER TABLE public.producao ADD COLUMN producao_ativo numeric default 1;
ALTER TABLE public.tipo_documento ADD COLUMN tipo_documento_ativo numeric default 1;
