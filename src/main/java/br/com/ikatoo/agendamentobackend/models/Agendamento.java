/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models;

import java.util.Date;

/**
 *
 * @author mckatoo
 */
public class Agendamento {
    
    private long idAgendamento;
    private long idTurma;
    private long idProfessor;
    private boolean primeirop;
    private Date dia;
    private long idCurso;
    private boolean segundop;
    private boolean preaula;
    private boolean datashow;
    private boolean amplificador;

    public long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    public long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public boolean isPrimeirop() {
        return primeirop;
    }

    public void setPrimeirop(boolean primeirop) {
        this.primeirop = primeirop;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public boolean isSegundop() {
        return segundop;
    }

    public void setSegundop(boolean segundop) {
        this.segundop = segundop;
    }

    public boolean isPreaula() {
        return preaula;
    }

    public void setPreaula(boolean preaula) {
        this.preaula = preaula;
    }

    public boolean isDatashow() {
        return datashow;
    }

    public void setDatashow(boolean datashow) {
        this.datashow = datashow;
    }

    public boolean isAmplificador() {
        return amplificador;
    }

    public void setAmplificador(boolean amplificador) {
        this.amplificador = amplificador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.idAgendamento ^ (this.idAgendamento >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (this.idAgendamento != other.idAgendamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "idAgendamento=" + idAgendamento + ", idTurma=" + idTurma + ", idProfessor=" + idProfessor + ", primeirop=" + primeirop + ", dia=" + dia + ", idCurso=" + idCurso + ", segundop=" + segundop + ", preaula=" + preaula + ", datashow=" + datashow + ", amplificador=" + amplificador + '}';
    }
    
}
