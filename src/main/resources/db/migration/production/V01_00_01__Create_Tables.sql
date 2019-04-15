--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-04-12 13:59:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 32088)
-- Name: authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority (
    id bigint NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.authority OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 32086)
-- Name: authority_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.authority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.authority_id_seq OWNER TO postgres;

--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 196
-- Name: authority_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.authority_id_seq OWNED BY public.authority.id;


--
-- TOC entry 198 (class 1259 OID 32094)
-- Name: authority_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority_role (
    role_id bigint NOT NULL,
    authority_id bigint NOT NULL
);


ALTER TABLE public.authority_role OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 32101)
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu (
    id bigint NOT NULL,
    description character varying(250),
    name character varying(100) NOT NULL,
    type smallint NOT NULL
);


ALTER TABLE public.menu OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 32099)
-- Name: menu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.menu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.menu_id_seq OWNER TO postgres;

--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 199
-- Name: menu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.menu_id_seq OWNED BY public.menu.id;


--
-- TOC entry 202 (class 1259 OID 32112)
-- Name: menuplan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menuplan (
    id bigint NOT NULL,
    calendar_week smallint
);


ALTER TABLE public.menuplan OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 32110)
-- Name: menuplan_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.menuplan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.menuplan_id_seq OWNER TO postgres;

--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 201
-- Name: menuplan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.menuplan_id_seq OWNED BY public.menuplan.id;


--
-- TOC entry 203 (class 1259 OID 32118)
-- Name: menuplan_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menuplan_menu (
    menuplan_id bigint NOT NULL,
    menu_id bigint NOT NULL
);


ALTER TABLE public.menuplan_menu OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32123)
-- Name: menuplan_orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menuplan_orders (
    menuplan_id bigint NOT NULL,
    orders_id bigint NOT NULL
);


ALTER TABLE public.menuplan_orders OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 32130)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id bigint NOT NULL,
    amount_nopork smallint NOT NULL,
    amount_normal smallint NOT NULL,
    amount_vegi smallint NOT NULL,
    notice character varying(250)
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 32128)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO postgres;

--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 205
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- TOC entry 208 (class 1259 OID 32138)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 32136)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 207
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 210 (class 1259 OID 32146)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    account_expiration_date date,
    credentials_expiration_date date,
    email character varying(75) NOT NULL,
    enabled smallint NOT NULL,
    first_name character varying(75) NOT NULL,
    last_name character varying(60) NOT NULL,
    living_goup smallint NOT NULL,
    locked smallint NOT NULL,
    password character varying(100) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 32144)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 209
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 211 (class 1259 OID 32155)
-- Name: users_orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_orders (
    user_id bigint NOT NULL,
    orders_id bigint NOT NULL
);


ALTER TABLE public.users_orders OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 32160)
-- Name: users_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_role (
    users_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.users_role OWNER TO postgres;

--
-- TOC entry 2720 (class 2604 OID 32091)
-- Name: authority id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority ALTER COLUMN id SET DEFAULT nextval('public.authority_id_seq'::regclass);


--
-- TOC entry 2721 (class 2604 OID 32104)
-- Name: menu id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu ALTER COLUMN id SET DEFAULT nextval('public.menu_id_seq'::regclass);


--
-- TOC entry 2722 (class 2604 OID 32115)
-- Name: menuplan id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan ALTER COLUMN id SET DEFAULT nextval('public.menuplan_id_seq'::regclass);


--
-- TOC entry 2723 (class 2604 OID 32133)
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- TOC entry 2724 (class 2604 OID 32141)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 2725 (class 2604 OID 32149)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 196
-- Name: authority_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.authority_id_seq', 1, false);


--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 199
-- Name: menu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.menu_id_seq', 1, false);


--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 201
-- Name: menuplan_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.menuplan_id_seq', 1, false);


--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 205
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 1, false);


--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 207
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 1, false);


--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 209
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- TOC entry 2727 (class 2606 OID 32093)
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 32098)
-- Name: authority_role authority_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT authority_role_pkey PRIMARY KEY (role_id, authority_id);


--
-- TOC entry 2731 (class 2606 OID 32109)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);


--
-- TOC entry 2735 (class 2606 OID 32122)
-- Name: menuplan_menu menuplan_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_menu
    ADD CONSTRAINT menuplan_menu_pkey PRIMARY KEY (menuplan_id, menu_id);


--
-- TOC entry 2737 (class 2606 OID 32127)
-- Name: menuplan_orders menuplan_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_orders
    ADD CONSTRAINT menuplan_orders_pkey PRIMARY KEY (menuplan_id, orders_id);


--
-- TOC entry 2733 (class 2606 OID 32117)
-- Name: menuplan menuplan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan
    ADD CONSTRAINT menuplan_pkey PRIMARY KEY (id);


--
-- TOC entry 2741 (class 2606 OID 32135)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 2743 (class 2606 OID 32143)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2747 (class 2606 OID 32168)
-- Name: users_orders uk_1njdfitph68mh7p7c6f3qc736; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_orders
    ADD CONSTRAINT uk_1njdfitph68mh7p7c6f3qc736 UNIQUE (orders_id);


--
-- TOC entry 2739 (class 2606 OID 32166)
-- Name: menuplan_orders uk_m3kqq9x5k3pe08q5xjm5failq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_orders
    ADD CONSTRAINT uk_m3kqq9x5k3pe08q5xjm5failq UNIQUE (orders_id);


--
-- TOC entry 2749 (class 2606 OID 32159)
-- Name: users_orders users_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_orders
    ADD CONSTRAINT users_orders_pkey PRIMARY KEY (user_id, orders_id);


--
-- TOC entry 2745 (class 2606 OID 32154)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2751 (class 2606 OID 32164)
-- Name: users_role users_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT users_role_pkey PRIMARY KEY (users_id, role_id);


--
-- TOC entry 2758 (class 2606 OID 32199)
-- Name: users_orders fk2lnf5jw8p8q0ytkr8dp0mlx6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_orders
    ADD CONSTRAINT fk2lnf5jw8p8q0ytkr8dp0mlx6 FOREIGN KEY (orders_id) REFERENCES public.orders(id);


--
-- TOC entry 2760 (class 2606 OID 32209)
-- Name: users_role fk3qjq7qsiigxa82jgk0i0wuq3g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fk3qjq7qsiigxa82jgk0i0wuq3g FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2753 (class 2606 OID 32174)
-- Name: authority_role fk41x42ehd4xi15gxvg9iehmel5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT fk41x42ehd4xi15gxvg9iehmel5 FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2752 (class 2606 OID 32169)
-- Name: authority_role fkbx74hejmy633p202glaq0yj8t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT fkbx74hejmy633p202glaq0yj8t FOREIGN KEY (authority_id) REFERENCES public.authority(id);


--
-- TOC entry 2755 (class 2606 OID 32184)
-- Name: menuplan_menu fkcl2pgcpb36vpsccn4s1lyhinp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_menu
    ADD CONSTRAINT fkcl2pgcpb36vpsccn4s1lyhinp FOREIGN KEY (menuplan_id) REFERENCES public.menuplan(id);


--
-- TOC entry 2757 (class 2606 OID 32194)
-- Name: menuplan_orders fkf9ksdoxc6q3y3vvcxjuwbequd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_orders
    ADD CONSTRAINT fkf9ksdoxc6q3y3vvcxjuwbequd FOREIGN KEY (menuplan_id) REFERENCES public.menuplan(id);


--
-- TOC entry 2754 (class 2606 OID 32179)
-- Name: menuplan_menu fki1cfk27qo3d4puc25enuora5b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_menu
    ADD CONSTRAINT fki1cfk27qo3d4puc25enuora5b FOREIGN KEY (menu_id) REFERENCES public.menu(id);


--
-- TOC entry 2761 (class 2606 OID 32214)
-- Name: users_role fkiu0xsee0dmwa28nffgyf4bcvc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fkiu0xsee0dmwa28nffgyf4bcvc FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 2759 (class 2606 OID 32204)
-- Name: users_orders fkms88pdhtsiuuusjpeij73f6df; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_orders
    ADD CONSTRAINT fkms88pdhtsiuuusjpeij73f6df FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2756 (class 2606 OID 32189)
-- Name: menuplan_orders fku903hym0q2at52wx8n8c27d2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_orders
    ADD CONSTRAINT fku903hym0q2at52wx8n8c27d2 FOREIGN KEY (orders_id) REFERENCES public.orders(id);


-- Completed on 2019-04-12 13:59:23

--
-- PostgreSQL database dump complete
--

