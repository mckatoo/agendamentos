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
public class TurmasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idturma")
    private int idturma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcurso")
    private int idcurso;

    public TurmasPK() {
    }

    public TurmasPK(int idturma, int idcurso) {
        this.idturma = idturma;
        this.idcurso = idcurso;
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
        hash += (int) idturma;
        hash += (int) idcurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurmasPK)) {
            return false;
        }
        TurmasPK other = (TurmasPK) object;
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
        return "br.com.ikatoo.agendamentobackend.models.TurmasPK[ idturma=" + idturma + ", idcurso=" + idcurso + " ]";
    }
    
}
