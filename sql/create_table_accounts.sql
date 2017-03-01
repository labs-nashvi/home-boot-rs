-- Table: public."ACCOUNTS"

-- DROP TABLE public."ACCOUNTS";

CREATE TABLE public."ACCOUNTS"
(
    "ACCOUNT_ID" integer NOT NULL DEFAULT nextval('"ACCOUNTS_ACCOUNT_ID_seq"'::regclass),
    "ACCOUNT_TYPE" text COLLATE pg_catalog."default" NOT NULL,
    "ACCOUNT_NAME" text COLLATE pg_catalog."default" NOT NULL,
    "OPENING_BALANCE" money,
    "CLOSING_BALANCE" money,
    "OPENED_ON" timestamp without time zone DEFAULT now(),
    "MODIFIED_ON" timestamp without time zone,
    CONSTRAINT "PRIMARY_KEY_ACCOUNT_ID" PRIMARY KEY ("ACCOUNT_ID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."ACCOUNTS"
    OWNER to nashvi;