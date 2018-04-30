/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author mckatoo
 */
@Entity
public class Agendamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idagendamento;
    @ManyToOne
    @JoinColumn(name = "idprofessor")
    private Professores professor;
    @ManyToOne
    @JoinColumn(name = "idturma")
    private Turmas turma;
    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Cursos curso;
    private Date dia;
    private Boolean preaula;
    private Boolean primeirop;
    private Boolean segundop;
    private Boolean datashow;
    private Boolean amplificador;
    private String observacao;

    public Integer getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(Integer idagendamento) {
        this.idagendamento = idagendamento;
    }

    public Professores getProfessor() {
        return professor;
    }

    public void setProfessor(Professores professor) {
        this.professor = professor;
    }

    public Turmas getTurma() {
        return turma;
    }

    public void setTurma(Turmas turma) {
        this.turma = turma;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Boolean getPreaula() {
        return preaula;
    }

    public void setPreaula(Boolean preaula) {
        this.preaula = preaula;
    }

    public Boolean getPrimeirop() {
        return primeirop;
    }

    public void setPrimeirop(Boolean primeirop) {
        this.primeirop = primeirop;
    }

    public Boolean getSegundop() {
        return segundop;
    }

    public void setSegundop(Boolean segundop) {
        this.segundop = segundop;
    }

    public Boolean getDatashow() {
        return datashow;
    }

    public void setDatashow(Boolean datashow) {
        this.datashow = datashow;
    }

    public Boolean getAmplificador() {
        return amplificador;
    }

    public void setAmplificador(Boolean amplificador) {
        this.amplificador = amplificador;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
