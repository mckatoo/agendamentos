/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.testes;

import br.com.ikatoo.agendamentobackend.models.Agendamentos;
import br.com.ikatoo.agendamentobackend.models.Cursos;
import br.com.ikatoo.agendamentobackend.models.Professores;
import br.com.ikatoo.agendamentobackend.models.Turmas;
import br.com.ikatoo.agendamentobackend.models.dao.AgendamentosDAO;
import br.com.ikatoo.agendamentobackend.models.dao.CursosDAO;
import br.com.ikatoo.agendamentobackend.models.dao.ProfessoresDAO;
import br.com.ikatoo.agendamentobackend.models.dao.TurmasDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mckatoo
 */
public class Teste {
    
    public static void main(String[] args) throws ParseException {

        Professores p = new Professores();
        ProfessoresDAO Pdao = new ProfessoresDAO();
        p.setIdprofessor(3);
//        p.setProfessor("Professor Adm");
        Pdao.save(p);
        
        Cursos c = new Cursos();
        CursosDAO Cdao = new CursosDAO();
        c.setIdcurso(12);
//        c.setCurso("Ciência da Computação");
        Cdao.save(c);
        
        Turmas t = new Turmas();
        TurmasDAO Tdao = new TurmasDAO();
        t.setIdturma(13);
//        t.setTurma("Primeiro Semestre");
        t.setCurso(c);
        Tdao.save(t);
        
        Agendamentos a = new Agendamentos();
        a.setProfessor(p);
        a.setTurma(t);
        a.setCurso(c);
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date dia = f.parse("05/06/2018");
        a.setDia(dia);
        a.setPreaula(false);
        a.setPrimeirop(false);
        a.setSegundop(false);
        a.setDatashow(false);
        a.setAmplificador(false);
        AgendamentosDAO Adao = new AgendamentosDAO();
        Adao.save(a);

        
        
//        Professores p = new Professores();
//          PARA ATUALIZAR É SÓ USAR O setIdprofessor
//        p.setIdprofessor(7);
//        p.setProfessor("TESTE");
//        
//        Cursos curso = new Cursos();
//        curso.setIdcurso(10);
        
//        Turmas t = new Turmas();
//        t.setTurma("Primeiro Semestre");
//        t.setCurso(curso);
//        TurmasDAO dao = new TurmasDAO();
//        System.out.println("ID: "+p.getIdprofessor());
//        System.out.println("Professor: "+p.getProfessor());

//        PESQUISANDO POR ID
//        Professores p = dao.findById(8);
//        System.out.println("Professor: "+p.getProfessor());

//        RETORNANDO TODOS REGISTROS
//        for(Professores p: dao.findAll()){
//            System.out.println("Professores: "+p.getProfessor());
//        }

//        REMOVENDO POR ID
//        dao.remove(7);

//        SALVANDO AGENDAMENTO
        
//        Agendamentos a = new Agendamentos();
//        AgendamentosDAO dao = new AgendamentosDAO();
        
        
        
    }
    
}
