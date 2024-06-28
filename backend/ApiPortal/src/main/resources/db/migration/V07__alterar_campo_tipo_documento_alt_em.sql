alter table public.tipo_documento DROP COLUMN tipo_documento_alt_em;
COMMIT;
alter table public.tipo_documento ADD COLUMN tipo_documento_alt_em timestamp without time zone;
