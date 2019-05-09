--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-04-17 15:33:05

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
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 35361)
-- Name: authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.authority OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 35359)
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
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 196
-- Name: authority_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.authority_id_seq OWNED BY public.authority.id;


--
-- TOC entry 198 (class 1259 OID 35367)
-- Name: authority_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority_role (
    role_id bigint NOT NULL,
    authority_id bigint NOT NULL
);


ALTER TABLE public.authority_role OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 35374)
-- Name: menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menu (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(255),
    type integer
);


ALTER TABLE public.menu OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 35372)
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
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 199
-- Name: menu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.menu_id_seq OWNED BY public.menu.id;


--
-- TOC entry 202 (class 1259 OID 35385)
-- Name: menuplan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menuplan (
    id bigint NOT NULL,
    calendar_week integer
);


ALTER TABLE public.menuplan OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 35383)
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
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 201
-- Name: menuplan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.menuplan_id_seq OWNED BY public.menuplan.id;


--
-- TOC entry 203 (class 1259 OID 35391)
-- Name: menuplan_menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.menuplan_menu (
    menuplan_id bigint NOT NULL,
    menu_id bigint NOT NULL
);


ALTER TABLE public.menuplan_menu OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 35398)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id bigint NOT NULL,
    amount_nopork integer,
    amount_normal integer,
    amount_vegi integer,
    notice character varying(255),
    menuplan_id bigint,
    users_id bigint
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 35396)
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
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 204
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- TOC entry 207 (class 1259 OID 35406)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 35404)
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
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 206
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 209 (class 1259 OID 35414)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    account_expiration_date date,
    credentials_expiration_date date,
    email character varying(255),
    enabled integer,
    first_name character varying(255),
    last_name character varying(255),
    living_goup integer,
    locked integer,
    password character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 35412)
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
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 208
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 210 (class 1259 OID 35423)
-- Name: users_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_role (
    users_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.users_role OWNER TO postgres;

--
-- TOC entry 2714 (class 2604 OID 35364)
-- Name: authority id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority ALTER COLUMN id SET DEFAULT nextval('public.authority_id_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 35377)
-- Name: menu id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu ALTER COLUMN id SET DEFAULT nextval('public.menu_id_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 35388)
-- Name: menuplan id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan ALTER COLUMN id SET DEFAULT nextval('public.menuplan_id_seq'::regclass);


--
-- TOC entry 2717 (class 2604 OID 35401)
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- TOC entry 2718 (class 2604 OID 35409)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 2719 (class 2604 OID 35417)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);

--
-- TOC entry 2721 (class 2606 OID 35366)
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 35371)
-- Name: authority_role authority_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT authority_role_pkey PRIMARY KEY (role_id, authority_id);


--
-- TOC entry 2725 (class 2606 OID 35382)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 35395)
-- Name: menuplan_menu menuplan_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_menu
    ADD CONSTRAINT menuplan_menu_pkey PRIMARY KEY (menuplan_id, menu_id);


--
-- TOC entry 2727 (class 2606 OID 35390)
-- Name: menuplan menuplan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan
    ADD CONSTRAINT menuplan_pkey PRIMARY KEY (id);


--
-- TOC entry 2731 (class 2606 OID 35403)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 2733 (class 2606 OID 35411)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2735 (class 2606 OID 35422)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2737 (class 2606 OID 35427)
-- Name: users_role users_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT users_role_pkey PRIMARY KEY (users_id, role_id);


--
-- TOC entry 2742 (class 2606 OID 35448)
-- Name: orders fk1gdt2i664rnli1u00rriqrale; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk1gdt2i664rnli1u00rriqrale FOREIGN KEY (menuplan_id) REFERENCES public.menuplan(id);


--
-- TOC entry 2744 (class 2606 OID 35458)
-- Name: users_role fk3qjq7qsiigxa82jgk0i0wuq3g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fk3qjq7qsiigxa82jgk0i0wuq3g FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2739 (class 2606 OID 35433)
-- Name: authority_role fk41x42ehd4xi15gxvg9iehmel5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT fk41x42ehd4xi15gxvg9iehmel5 FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2738 (class 2606 OID 35428)
-- Name: authority_role fkbx74hejmy633p202glaq0yj8t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT fkbx74hejmy633p202glaq0yj8t FOREIGN KEY (authority_id) REFERENCES public.authority(id);


--
-- TOC entry 2741 (class 2606 OID 35443)
-- Name: menuplan_menu fkcl2pgcpb36vpsccn4s1lyhinp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_menu
    ADD CONSTRAINT fkcl2pgcpb36vpsccn4s1lyhinp FOREIGN KEY (menuplan_id) REFERENCES public.menuplan(id);


--
-- TOC entry 2743 (class 2606 OID 35453)
-- Name: orders fke6k45xxoin4fylnwg2jkehwjf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fke6k45xxoin4fylnwg2jkehwjf FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 2740 (class 2606 OID 35438)
-- Name: menuplan_menu fki1cfk27qo3d4puc25enuora5b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.menuplan_menu
    ADD CONSTRAINT fki1cfk27qo3d4puc25enuora5b FOREIGN KEY (menu_id) REFERENCES public.menu(id);


--
-- TOC entry 2745 (class 2606 OID 35463)
-- Name: users_role fkiu0xsee0dmwa28nffgyf4bcvc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fkiu0xsee0dmwa28nffgyf4bcvc FOREIGN KEY (users_id) REFERENCES public.users(id);


-- Completed on 2019-04-17 15:33:05

--
-- PostgreSQL database dump complete
--

