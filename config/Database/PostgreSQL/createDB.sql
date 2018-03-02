
CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.topo (
                id INTEGER NOT NULL DEFAULT nextval('public.topo_id_seq'),
                name VARCHAR(50) NOT NULL,
                edition_date DATE NOT NULL,
                description VARCHAR(256),
                CONSTRAINT topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;

CREATE INDEX topo_idx
 ON public.topo
 ( name );

CREATE SEQUENCE public.user_table_id_seq;

CREATE TABLE public.user_table (
                id INTEGER NOT NULL DEFAULT nextval('public.user_table_id_seq'),
                username VARCHAR(32) NOT NULL,
                password VARCHAR(16) NOT NULL,
                CONSTRAINT user_table_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.user_table_id_seq OWNED BY public.user_table.id;

CREATE SEQUENCE public.topo_ownedby_user_id_seq;

CREATE TABLE public.topo_ownedby_user (
                id INTEGER NOT NULL DEFAULT nextval('public.topo_ownedby_user_id_seq'),
                owner_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                CONSTRAINT topo_ownedby_user_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.topo_ownedby_user_id_seq OWNED BY public.topo_ownedby_user.id;

CREATE INDEX topo_ownedby_utilisateur_idx
 ON public.topo_ownedby_user
 ( topo_id );

CREATE SEQUENCE public.message_id_seq;

CREATE TABLE public.message (
                id INTEGER NOT NULL DEFAULT nextval('public.message_id_seq'),
                receiver_id INTEGER NOT NULL,
                sender_id INTEGER,
                previous_message_id INTEGER,
                date_time TIMESTAMP NOT NULL,
                message_read BOOLEAN DEFAULT false NOT NULL,
                subject VARCHAR(32) NOT NULL,
                content VARCHAR(1024) NOT NULL,
                CONSTRAINT message_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.message_id_seq OWNED BY public.message.id;

CREATE SEQUENCE public.comment_id_seq;

CREATE TABLE public.comment (
                id INTEGER NOT NULL DEFAULT nextval('public.comment_id_seq'),
                user_id INTEGER,
                post_type INTEGER NOT NULL,
                post_id INTEGER NOT NULL,
                date_time TIMESTAMP NOT NULL,
                comment VARCHAR(256) NOT NULL,
                CONSTRAINT comment_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.comment_id_seq OWNED BY public.comment.id;

CREATE INDEX commentaire_idx
 ON public.comment
 ( post_id );

CREATE SEQUENCE public.lending_topo_id_seq;

CREATE TABLE public.lending_topo (
                id INTEGER NOT NULL DEFAULT nextval('public.lending_topo_id_seq'),
                topo_owned_id INTEGER NOT NULL,
                borrower_id INTEGER NOT NULL,
                lending_start DATE NOT NULL,
                lending_end DATE NOT NULL,
                CONSTRAINT lending_topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.lending_topo_id_seq OWNED BY public.lending_topo.id;

CREATE INDEX pret_topo_idx
 ON public.lending_topo
 ( topo_owned_id, lending_end );

CREATE SEQUENCE public.site_id_seq;

CREATE TABLE public.site (
                id INTEGER NOT NULL DEFAULT nextval('public.site_id_seq'),
                name VARCHAR(50) NOT NULL,
                date DATE NOT NULL,
                photo_name VARCHAR(70),
                place VARCHAR(128) NOT NULL,
                path_indication VARCHAR(256) NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.site_id_seq OWNED BY public.site.id;

CREATE INDEX site_idx
 ON public.site
 ( name );

CREATE TABLE public.site_topo (
                topo_id INTEGER NOT NULL,
                site_id INTEGER NOT NULL
);


CREATE SEQUENCE public.secteur_id_seq;

CREATE TABLE public.secteur (
                id INTEGER NOT NULL DEFAULT nextval('public.secteur_id_seq'),
                name VARCHAR(50) NOT NULL,
                site_id INTEGER NOT NULL,
                photo_name VARCHAR(70),
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;

CREATE INDEX secteur_idx
 ON public.secteur
 ( site_id );

CREATE SEQUENCE public.voie_id_seq;

CREATE TABLE public.voie (
                id INTEGER NOT NULL DEFAULT nextval('public.voie_id_seq'),
                name VARCHAR(50) NOT NULL,
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;

CREATE INDEX voie_idx
 ON public.voie
 ( secteur_id );

CREATE SEQUENCE public.longueur_id_seq;

CREATE TABLE public.longueur (
                id INTEGER NOT NULL DEFAULT nextval('public.longueur_id_seq'),
                voie_id INTEGER NOT NULL,
                previous_longueur_id INTEGER,
                height SMALLINT NOT NULL,
                nombre_points SMALLINT NOT NULL,
                cotation VARCHAR(10) NOT NULL,
                CONSTRAINT longueur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.longueur_id_seq OWNED BY public.longueur.id;

CREATE INDEX longueur_idx
 ON public.longueur
 ( voie_id );

CREATE INDEX longueur_search_idx
 ON public.longueur
 ( height, nombre_points, cotation );

ALTER TABLE public.topo_ownedby_user ADD CONSTRAINT topo_topo_ownedby_utilisateur_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.site_topo ADD CONSTRAINT topo_site_topo_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.lending_topo ADD CONSTRAINT utilisateur_pret_topo_fk1
FOREIGN KEY (borrower_id)
REFERENCES public.user_table (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.comment ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (user_id)
REFERENCES public.user_table (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.message ADD CONSTRAINT utilisateur_message_fk1
FOREIGN KEY (receiver_id)
REFERENCES public.user_table (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.message ADD CONSTRAINT utilisateur_message_fk
FOREIGN KEY (sender_id)
REFERENCES public.user_table (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_ownedby_user ADD CONSTRAINT utilisateur_topo_ownedby_utilisateur_fk
FOREIGN KEY (owner_id)
REFERENCES public.user_table (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.lending_topo ADD CONSTRAINT topo_ownedby_utilisateur_pret_topo_fk
FOREIGN KEY (topo_owned_id)
REFERENCES public.topo_ownedby_user (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.message ADD CONSTRAINT message_message_fk
FOREIGN KEY (previous_message_id)
REFERENCES public.message (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.site_topo ADD CONSTRAINT site_site_topo_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.longueur ADD CONSTRAINT voie_longueur_fk
FOREIGN KEY (voie_id)
REFERENCES public.voie (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.longueur ADD CONSTRAINT longueur_longueur_fk
FOREIGN KEY (previous_longueur_id)
REFERENCES public.longueur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;