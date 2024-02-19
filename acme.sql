--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1 (Debian 16.1-1.pgdg120+1)
-- Dumped by pg_dump version 16.1 (Debian 16.1-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cerveja; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cerveja (
    id bigint NOT NULL,
    malt character varying(255),
    name character varying(255),
    type character varying(255)
);


ALTER TABLE public.cerveja OWNER TO postgres;

--
-- Name: cerveja_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cerveja_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cerveja_id_seq OWNER TO postgres;

--
-- Name: cerveja_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cerveja_id_seq OWNED BY public.cerveja.id;


--
-- Name: cerveja id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cerveja ALTER COLUMN id SET DEFAULT nextval('public.cerveja_id_seq'::regclass);


--
-- Data for Name: cerveja; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cerveja (id, malt, name, type) FROM stdin;
1	Roasted barley	Orval Trappist Ale	Merican Ale
2	Vienna	Oaked Arrogant Bastard Ale	India Pale Ale
3	Roasted barley	Delirium Noctorum	Amber Hybrid Beer
4	Vienna	Chimay Grande Réserve	Merican Ale
5	Chocolate malt	Storm King Stout	Light Lager
6	Wheat mal	Shakespeare Oatmeal	Merican Ale
7	Special roast	Hercules Double IPA	Stout
8	Munich	Sierra Nevada Bigfoot Barleywine Style Ale	Wood-aged Beer
9	Roasted barley	90 Minute IPA	Belgian And French Ale
10	Carapils	Two Hearted Ale	European Amber Lager
11	Caramel	Nugget Nectar	Fruit Beer
12	Roasted barley	Racer 5 India Pale Ale, Bear Republic Bre	Wood-aged Beer
13	Victory	Schneider Aventinus	Wood-aged Beer
14	Rye malt	Samuel Smith’s Oatmeal Stout	Belgian And French Ale
15	Caramel	Duvel	Porter
16	Munich	St. Bernardus Abt 12	India Pale Ale
17	Wheat mal	Ten FIDY	English Pale Ale
18	Rye malt	Weihenstephaner Hefeweissbier	Porter
19	Munich	Bourbon County Stout	English Pale Ale
20	Caramel	Chocolate St	Belgian And French Ale
21	Munich	Arrogant Bastard Ale	India Pale Ale
22	Carapils	Trappistes Rochefort 10	Fruit Beer
23	Caramel	Trois Pistoles	Smoke-flavored
24	Black malt	Bell’s Expedition	Belgian Strong Ale
25	Carapils	Oak Aged Yeti Imperial Stout	India Pale Ale
26	Chocolate malt	La Fin Du Monde	English Brown Ale
27	Munich	Yeti Imperial Stout	Sour Ale
28	Pale	Maharaj	Strong Ale
29	Carapils	Trappistes Rochefort 8	Scottish And Irish Ale
30	Caramel	Stone Imperial Russian Stout	Vegetable Beer
31	Black malt	Alpha King Pale Ale	Belgian Strong Ale
32	Munich	Kirin Inchiban	Scottish And Irish Ale
33	Victory	Sierra Nevada Celebration Ale	Porter
34	Carapils	Samuel Smith’s Imperial IPA	Belgian And French Ale
35	Carapils	Hennepin	European Amber Lager
36	Chocolate malt	Sapporo Premium	Scottish And Irish Ale
37	Carapils	Péché Mortel	German Wheat And Rye Beer
38	Rye malt	Celebrator Doppelbock	Sour Ale
39	Munich	Old Rasputin Russian Imperial Stout	Bock
40	Carapils	HopSlam Ale	Amber Hybrid Beer
41	Wheat mal	Edmund Fitzgerald Porter	Belgian And French Ale
42	Black malt	Westmalle Trappist Tripel	Dark Lager
43	Caramel	Ruination IPA	Stout
44	Pale	Sublimely Self-Righteous Ale	India Pale Ale
45	Chocolate	Stone IPA	Light Hybrid Beer
46	Vienna	Delirium Tremens	German Wheat And Rye Beer
47	Pale	Pliny The Elder	Amber Hybrid Beer
48	Carapils	Double Bastard Ale	Sour Ale
49	Rye malt	Dreadnaught IPA	German Wheat And Rye Beer
50	Carapils	Maudite	German Wheat And Rye Beer
51	Victory	Founders Kentucky Breakfast	Bock
52	Munich	Hop Rod Rye	Scottish And Irish Ale
53	Special roast	Brooklyn Black	Fruit Beer
54	Rye malt	Founders Breakfast Stout	English Brown Ale
\.


--
-- Name: cerveja_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cerveja_id_seq', 54, true);


--
-- Name: cerveja cerveja_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cerveja
    ADD CONSTRAINT cerveja_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

