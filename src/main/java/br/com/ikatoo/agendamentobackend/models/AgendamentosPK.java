/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mckatoo
 */
@Embeddable
public class AgendamentosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idagendamento")
    private int idagendamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofessor")
    private int idprofessor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idturma")
    private int idturma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcurso")
    private int idcurso;

    public AgendamentosPK() {
    }

    public AgendamentosPK(int idagendamento, int idprofessor, int idturma, int idcurso) {
        this.idagendamento = idagendamento;
        this.idprofessor = idprofessor;
        this.idturma = idturma;
        this.idcurso = idcurso;
    }

    public int getIdagendamento() {
        return idagendamento;
    }

    public void setIdagendamento(int idagendamento) {
        this.idagendamento = idagendamento;
    }

    public int getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
    }

    public int getIdturma() {
        return idturma;
    }

    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idagendamento;
        hash += (int) idprofessor;
        hash += (int) idturma;
        hash += (int) idcurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgendamentosPK)) {
            return false;
        }
        AgendamentosPK other = (AgendamentosPK) object;
        if (this.idagendamento != other.idagendamento) {
            return false;
        }
        if (this.idprofessor != other.idprofessor) {
            return false;
        }
        if (this.idturma != other.idturma) {
            return false;
        }
        if (this.idcurso != other.idcurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ikatoo.agendamentobackend.models.AgendamentosPK[ idagendamento=" + idagendamento + ", idprofessor=" + idprofessor + ", idturma=" + idturma + ", idcurso=" + idcurso + " ]";
    }
    
}
