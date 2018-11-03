--
-- PostgreSQL database dump
--

-- Dumped from database version 11.0 (Debian 11.0-1.pgdg90+2)
-- Dumped by pg_dump version 11.0 (Debian 11.0-1.pgdg90+2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: permission; Type: TABLE; Schema: public; Owner: recipe
--

CREATE TABLE public.permission (
    id integer NOT NULL,
    name character varying(1000) NOT NULL,
    description character varying(10000)
);


ALTER TABLE public.permission OWNER TO recipe;

--
-- Name: TABLE permission; Type: COMMENT; Schema: public; Owner: recipe
--

COMMENT ON TABLE public.permission IS 'permission of application''s user';


--
-- Name: permission_id_seq; Type: SEQUENCE; Schema: public; Owner: recipe
--

CREATE SEQUENCE public.permission_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permission_id_seq OWNER TO recipe;

--
-- Name: permission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: recipe
--

ALTER SEQUENCE public.permission_id_seq OWNED BY public.permission.id;


--
-- Name: recipe_user; Type: TABLE; Schema: public; Owner: recipe
--

CREATE TABLE public.recipe_user (
    last_name character varying(100),
    first_name character varying(100),
    login character varying(100) NOT NULL,
    password character varying(1000) NOT NULL,
    email character varying(100) NOT NULL,
    id integer NOT NULL,
    role integer NOT NULL
);


ALTER TABLE public.recipe_user OWNER TO recipe;

--
-- Name: recipe_user_id_seq; Type: SEQUENCE; Schema: public; Owner: recipe
--

CREATE SEQUENCE public.recipe_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recipe_user_id_seq OWNER TO recipe;

--
-- Name: recipe_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: recipe
--

ALTER SEQUENCE public.recipe_user_id_seq OWNED BY public.recipe_user.id;


--
-- Name: role; Type: TABLE; Schema: public; Owner: recipe
--

CREATE TABLE public.role (
    id integer NOT NULL,
    value character varying(100) NOT NULL
);


ALTER TABLE public.role OWNER TO recipe;

--
-- Name: TABLE role; Type: COMMENT; Schema: public; Owner: recipe
--

COMMENT ON TABLE public.role IS 'User role';


--
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: recipe
--

CREATE SEQUENCE public.role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO recipe;

--
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: recipe
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- Name: roles_permissions; Type: TABLE; Schema: public; Owner: recipe
--

CREATE TABLE public.roles_permissions (
    id integer NOT NULL,
    role_id integer NOT NULL,
    permission_id integer NOT NULL
);


ALTER TABLE public.roles_permissions OWNER TO recipe;

--
-- Name: TABLE roles_permissions; Type: COMMENT; Schema: public; Owner: recipe
--

COMMENT ON TABLE public.roles_permissions IS 'Mapping for role to it''s permissions';


--
-- Name: roles_permissions_id_seq; Type: SEQUENCE; Schema: public; Owner: recipe
--

CREATE SEQUENCE public.roles_permissions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_permissions_id_seq OWNER TO recipe;

--
-- Name: roles_permissions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: recipe
--

ALTER SEQUENCE public.roles_permissions_id_seq OWNED BY public.roles_permissions.id;


--
-- Name: permission id; Type: DEFAULT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.permission ALTER COLUMN id SET DEFAULT nextval('public.permission_id_seq'::regclass);


--
-- Name: recipe_user id; Type: DEFAULT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.recipe_user ALTER COLUMN id SET DEFAULT nextval('public.recipe_user_id_seq'::regclass);


--
-- Name: role id; Type: DEFAULT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- Name: roles_permissions id; Type: DEFAULT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.roles_permissions ALTER COLUMN id SET DEFAULT nextval('public.roles_permissions_id_seq'::regclass);


--
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: recipe
--

COPY public.permission (id, name, description) FROM stdin;
\.


--
-- Data for Name: recipe_user; Type: TABLE DATA; Schema: public; Owner: recipe
--

COPY public.recipe_user (last_name, first_name, login, password, email, id, role) FROM stdin;
ivanov	vasya	vasya	1111111	vasya@ivanov.com	1	1
tusik	tusik	tusik	111111	tusik@tusik.com	2	2
guest	loh	loh	111111	loh@loh.com	3	3
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: recipe
--

COPY public.role (id, value) FROM stdin;
1	ADMIN
2	REGULAR_USER
3	GUEST
\.


--
-- Data for Name: roles_permissions; Type: TABLE DATA; Schema: public; Owner: recipe
--

COPY public.roles_permissions (id, role_id, permission_id) FROM stdin;
\.


--
-- Name: permission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: recipe
--

SELECT pg_catalog.setval('public.permission_id_seq', 1, false);


--
-- Name: recipe_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: recipe
--

SELECT pg_catalog.setval('public.recipe_user_id_seq', 1, false);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: recipe
--

SELECT pg_catalog.setval('public.role_id_seq', 1, false);


--
-- Name: roles_permissions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: recipe
--

SELECT pg_catalog.setval('public.roles_permissions_id_seq', 1, false);


--
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: roles_permissions roles_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.roles_permissions
    ADD CONSTRAINT roles_permissions_pkey PRIMARY KEY (id);


--
-- Name: permission_id_uindex; Type: INDEX; Schema: public; Owner: recipe
--

CREATE UNIQUE INDEX permission_id_uindex ON public.permission USING btree (id);


--
-- Name: permission_name_uindex; Type: INDEX; Schema: public; Owner: recipe
--

CREATE UNIQUE INDEX permission_name_uindex ON public.permission USING btree (name);


--
-- Name: recipe_user_id_uindex; Type: INDEX; Schema: public; Owner: recipe
--

CREATE UNIQUE INDEX recipe_user_id_uindex ON public.recipe_user USING btree (id);


--
-- Name: role_id_uindex; Type: INDEX; Schema: public; Owner: recipe
--

CREATE UNIQUE INDEX role_id_uindex ON public.role USING btree (id);


--
-- Name: role_value_uindex; Type: INDEX; Schema: public; Owner: recipe
--

CREATE UNIQUE INDEX role_value_uindex ON public.role USING btree (value);


--
-- Name: roles_permissions_id_uindex; Type: INDEX; Schema: public; Owner: recipe
--

CREATE UNIQUE INDEX roles_permissions_id_uindex ON public.roles_permissions USING btree (id);


--
-- Name: roles_permissions fki7yl8w2oqulf7o64jop5bekgr; Type: FK CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.roles_permissions
    ADD CONSTRAINT fki7yl8w2oqulf7o64jop5bekgr FOREIGN KEY (permission_id) REFERENCES public.permission(id);


--
-- Name: roles_permissions fkj0m3rcoe2nlyliujy3i9fw2pq; Type: FK CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.roles_permissions
    ADD CONSTRAINT fkj0m3rcoe2nlyliujy3i9fw2pq FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: recipe_user recipe_user_role_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.recipe_user
    ADD CONSTRAINT recipe_user_role_id_fk FOREIGN KEY (role) REFERENCES public.role(id);


--
-- Name: roles_permissions roles_permissions_permission_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.roles_permissions
    ADD CONSTRAINT roles_permissions_permission_id_fk FOREIGN KEY (permission_id) REFERENCES public.permission(id);


--
-- Name: roles_permissions roles_permissions_role_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: recipe
--

ALTER TABLE ONLY public.roles_permissions
    ADD CONSTRAINT roles_permissions_role_id_fk FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- PostgreSQL database dump complete
--

