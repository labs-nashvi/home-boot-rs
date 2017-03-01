alter table "ACCOUNTS" drop column "MODIFIED_ON"

alter table "ACCOUNTS" add column "MODIFIED_ON" timestamp without time zone
alter table "ACCOUNTS" alter column "OPENED_ON" set default now()

------

INSERT INTO public."ACCOUNTS"(
	"ACCOUNT_TYPE", "ACCOUNT_NAME", "OPENING_BALANCE", "OPENED_ON")
	VALUES ( 'SAVINGS', 'BOA', 100, '2017-03-01T16:00:00' );



select * from "ACCOUNTS"

1,'SAVINGS','BOA','$100.00',,'2017-03-01 16:00:00',
2,'CHECKING','BOA','$100.00',,'2017-03-01 17:47:31.277056',
