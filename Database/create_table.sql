CREATE TABLE "user" (
  "user_id" serial NOT NULL,
  PRIMARY KEY ("user_id"),
  "user_name" character varying(25) NOT NULL,
  "hit_counter" integer NOT NULL
);

CREATE TABLE "repository" (
  "repository_id" serial NOT NULL,
  PRIMARY KEY ("repository_id"),
  "user_name" character varying(25) NOT NULL,
  "repository_name" character varying(40) NOT NULL,
  "hit_counter" integer NOT NULL
);

ALTER TABLE "repository"
ADD FOREIGN KEY ("user_name") REFERENCES "user" ("user_name") ON DELETE NO ACTION ON UPDATE NO ACTION;
