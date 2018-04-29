--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: agendamentos; Type: TABLE; Schema: public; Owner: mckatoo; Tablespace: 
--

CREATE TABLE agendamentos (
    idagendamento integer NOT NULL,
    idprofessor integer NOT NULL,
    idturma integer NOT NULL,
    idcurso integer NOT NULL,
    dia date NOT NULL,
    preaula boolean DEFAULT false NOT NULL,
    primeirop boolean DEFAULT false NOT NULL,
    segundop boolean DEFAULT false NOT NULL,
    datashow boolean DEFAULT false NOT NULL,
    amplificador boolean DEFAULT false NOT NULL
);


ALTER TABLE public.agendamentos OWNER TO mckatoo;

--
-- Name: agendamentos_idagendamento_seq; Type: SEQUENCE; Schema: public; Owner: mckatoo
--

CREATE SEQUENCE agendamentos_idagendamento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.agendamentos_idagendamento_seq OWNER TO mckatoo;

--
-- Name: agendamentos_idagendamento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mckatoo
--

ALTER SEQUENCE agendamentos_idagendamento_seq OWNED BY agendamentos.idagendamento;


--
-- Name: agendamentos_idagendamento_seq; Type: SEQUENCE SET; Schema: public; Owner: mckatoo
--

SELECT pg_catalog.setval('agendamentos_idagendamento_seq', 1, false);


--
-- Name: cursos; Type: TABLE; Schema: public; Owner: mckatoo; Tablespace: 
--

CREATE TABLE cursos (
    idcurso integer NOT NULL,
    curso character varying(50) NOT NULL
);


ALTER TABLE public.cursos OWNER TO mckatoo;

--
-- Name: cursos_idcurso_seq; Type: SEQUENCE; Schema: public; Owner: mckatoo
--

CREATE SEQUENCE cursos_idcurso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cursos_idcurso_seq OWNER TO mckatoo;

--
-- Name: cursos_idcurso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mckatoo
--

ALTER SEQUENCE cursos_idcurso_seq OWNED BY cursos.idcurso;


--
-- Name: cursos_idcurso_seq; Type: SEQUENCE SET; Schema: public; Owner: mckatoo
--

SELECT pg_catalog.setval('cursos_idcurso_seq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: mckatoo
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO mckatoo;

--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: mckatoo
--

SELECT pg_catalog.setval('hibernate_sequence', 16, true);


--
-- Name: professores; Type: TABLE; Schema: public; Owner: mckatoo; Tablespace: 
--

CREATE TABLE professores (
    idprofessor integer NOT NULL,
    professor character varying(50) NOT NULL
);


ALTER TABLE public.professores OWNER TO mckatoo;

--
-- Name: professores_idprofessor_seq; Type: SEQUENCE; Schema: public; Owner: mckatoo
--

CREATE SEQUENCE professores_idprofessor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.professores_idprofessor_seq OWNER TO mckatoo;

--
-- Name: professores_idprofessor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mckatoo
--

ALTER SEQUENCE professores_idprofessor_seq OWNED BY professores.idprofessor;


--
-- Name: professores_idprofessor_seq; Type: SEQUENCE SET; Schema: public; Owner: mckatoo
--

SELECT pg_catalog.setval('professores_idprofessor_seq', 7, true);


--
-- Name: turmas; Type: TABLE; Schema: public; Owner: mckatoo; Tablespace: 
--

CREATE TABLE turmas (
    idturma integer NOT NULL,
    idcurso integer NOT NULL,
    turma character varying(100) NOT NULL
);


ALTER TABLE public.turmas OWNER TO mckatoo;

--
-- Name: idagendamento; Type: DEFAULT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY agendamentos ALTER COLUMN idagendamento SET DEFAULT nextval('agendamentos_idagendamento_seq'::regclass);


--
-- Name: idcurso; Type: DEFAULT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY cursos ALTER COLUMN idcurso SET DEFAULT nextval('cursos_idcurso_seq'::regclass);


--
-- Name: idprofessor; Type: DEFAULT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY professores ALTER COLUMN idprofessor SET DEFAULT nextval('professores_idprofessor_seq'::regclass);


--
-- Data for Name: agendamentos; Type: TABLE DATA; Schema: public; Owner: mckatoo
--



--
-- Data for Name: cursos; Type: TABLE DATA; Schema: public; Owner: mckatoo
--

INSERT INTO cursos VALUES (9, 'Ciência da Computação');
INSERT INTO cursos VALUES (10, 'Administração');
INSERT INTO cursos VALUES (11, 'Pedagogia');


--
-- Data for Name: professores; Type: TABLE DATA; Schema: public; Owner: mckatoo
--

INSERT INTO professores VALUES (6, 'TESTE DAO');
INSERT INTO professores VALUES (8, 'TESTE');


--
-- Data for Name: turmas; Type: TABLE DATA; Schema: public; Owner: mckatoo
--



--
-- Name: agendamentos_pk; Type: CONSTRAINT; Schema: public; Owner: mckatoo; Tablespace: 
--

ALTER TABLE ONLY agendamentos
    ADD CONSTRAINT agendamentos_pk PRIMARY KEY (idagendamento, idprofessor, idturma, idcurso);


--
-- Name: cursos_pk; Type: CONSTRAINT; Schema: public; Owner: mckatoo; Tablespace: 
--

ALTER TABLE ONLY cursos
    ADD CONSTRAINT cursos_pk PRIMARY KEY (idcurso);


--
-- Name: professores_pk; Type: CONSTRAINT; Schema: public; Owner: mckatoo; Tablespace: 
--

ALTER TABLE ONLY professores
    ADD CONSTRAINT professores_pk PRIMARY KEY (idprofessor);


--
-- Name: turmas_pk; Type: CONSTRAINT; Schema: public; Owner: mckatoo; Tablespace: 
--

ALTER TABLE ONLY turmas
    ADD CONSTRAINT turmas_pk PRIMARY KEY (idturma, idcurso);


--
-- Name: cursos_turmas_fk; Type: FK CONSTRAINT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY turmas
    ADD CONSTRAINT cursos_turmas_fk FOREIGN KEY (idcurso) REFERENCES cursos(idcurso);


--
-- Name: fk12ra9ua8pg60a61wxqlh5f4ya; Type: FK CONSTRAINT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY turmas
    ADD CONSTRAINT fk12ra9ua8pg60a61wxqlh5f4ya FOREIGN KEY (idcurso) REFERENCES cursos(idcurso);


--
-- Name: fk3sqhmllkmkti1ljfi32sbpha3; Type: FK CONSTRAINT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY agendamentos
    ADD CONSTRAINT fk3sqhmllkmkti1ljfi32sbpha3 FOREIGN KEY (idprofessor) REFERENCES professores(idprofessor);


--
-- Name: fk8swsra77nxnpbj8jg4174ip16; Type: FK CONSTRAINT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY agendamentos
    ADD CONSTRAINT fk8swsra77nxnpbj8jg4174ip16 FOREIGN KEY (idcurso, idturma) REFERENCES turmas(idturma, idcurso);


--
-- Name: professores_agendamentos_fk; Type: FK CONSTRAINT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY agendamentos
    ADD CONSTRAINT professores_agendamentos_fk FOREIGN KEY (idprofessor) REFERENCES professores(idprofessor);


--
-- Name: turmas_agendamentos_fk; Type: FK CONSTRAINT; Schema: public; Owner: mckatoo
--

ALTER TABLE ONLY agendamentos
    ADD CONSTRAINT turmas_agendamentos_fk FOREIGN KEY (idturma, idcurso) REFERENCES turmas(idturma, idcurso);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

