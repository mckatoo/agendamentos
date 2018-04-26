/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mckatoo
 */
@Entity
@Table(name = "turmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turmas.findAll", query = "SELECT t FROM Turmas t")
    , @NamedQuery(name = "Turmas.findByIdturma", query = "SELECT t FROM Turmas t WHERE t.turmasPK.idturma = :idturma")
    , @NamedQuery(name = "Turmas.findByIdcurso", query = "SELECT t FROM Turmas t WHERE t.turmasPK.idcurso = :idcurso")
    , @NamedQuery(name = "Turmas.findByTurma", query = "SELECT t FROM Turmas t WHERE t.turma = :turma")})
public class Turmas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurmasPK turmasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "turma")
    private String turma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turmas")
    private List<Agendamentos> agendamentosList;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cursos cursos;

    public Turmas() {
    }

    public Turmas(TurmasPK turmasPK) {
        this.turmasPK = turmasPK;
    }

    public Turmas(TurmasPK turmasPK, String turma) {
        this.turmasPK = turmasPK;
        this.turma = turma;
    }

    public Turmas(int idturma, int idcurso) {
        this.turmasPK = new TurmasPK(idturma, idcurso);
    }

    public TurmasPK getTurmasPK() {
        return turmasPK;
    }

    public void setTurmasPK(TurmasPK turmasPK) {
        this.turmasPK = turmasPK;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @XmlTransient
    public List<Agendamentos> getAgendamentosList() {
        return agendamentosList;
    }

    public void setAgendamentosList(List<Agendamentos> agendamentosList) {
        this.agendamentosList = agendamentosList;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turmasPK != null ? turmasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turmas)) {
            return false;
        }
        Turmas other = (Turmas) object;
        if ((this.turmasPK == null && other.turmasPK != null) || (this.turmasPK != null && !this.turmasPK.equals(other.turmasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ikatoo.agendamentobackend.models.Turmas[ turmasPK=" + turmasPK + " ]";
    }
    
}
