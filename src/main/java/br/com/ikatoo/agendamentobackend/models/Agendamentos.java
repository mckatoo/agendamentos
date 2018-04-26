/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mckatoo
 */
@Entity
@Table(name = "agendamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamentos.findAll", query = "SELECT a FROM Agendamentos a")
    , @NamedQuery(name = "Agendamentos.findByIdagendamento", query = "SELECT a FROM Agendamentos a WHERE a.agendamentosPK.idagendamento = :idagendamento")
    , @NamedQuery(name = "Agendamentos.findByIdprofessor", query = "SELECT a FROM Agendamentos a WHERE a.agendamentosPK.idprofessor = :idprofessor")
    , @NamedQuery(name = "Agendamentos.findByIdturma", query = "SELECT a FROM Agendamentos a WHERE a.agendamentosPK.idturma = :idturma")
    , @NamedQuery(name = "Agendamentos.findByIdcurso", query = "SELECT a FROM Agendamentos a WHERE a.agendamentosPK.idcurso = :idcurso")
    , @NamedQuery(name = "Agendamentos.findByDia", query = "SELECT a FROM Agendamentos a WHERE a.dia = :dia")
    , @NamedQuery(name = "Agendamentos.findByPreaula", query = "SELECT a FROM Agendamentos a WHERE a.preaula = :preaula")
    , @NamedQuery(name = "Agendamentos.findByPrimeirop", query = "SELECT a FROM Agendamentos a WHERE a.primeirop = :primeirop")
    , @NamedQuery(name = "Agendamentos.findBySegundop", query = "SELECT a FROM Agendamentos a WHERE a.segundop = :segundop")
    , @NamedQuery(name = "Agendamentos.findByDatashow", query = "SELECT a FROM Agendamentos a WHERE a.datashow = :datashow")
    , @NamedQuery(name = "Agendamentos.findByAmplificador", query = "SELECT a FROM Agendamentos a WHERE a.amplificador = :amplificador")})
public class Agendamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgendamentosPK agendamentosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia")
    @Temporal(TemporalType.DATE)
    private Date dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preaula")
    private boolean preaula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "primeirop")
    private boolean primeirop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "segundop")
    private boolean segundop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datashow")
    private boolean datashow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amplificador")
    private boolean amplificador;
    @JoinColumn(name = "idprofessor", referencedColumnName = "idprofessor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Professores professores;
    @JoinColumns({
        @JoinColumn(name = "idturma", referencedColumnName = "idturma", insertable = false, updatable = false)
        , @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Turmas turmas;

    public Agendamentos() {
    }

    public Agendamentos(AgendamentosPK agendamentosPK) {
        this.agendamentosPK = agendamentosPK;
    }

    public Agendamentos(AgendamentosPK agendamentosPK, Date dia, boolean preaula, boolean primeirop, boolean segundop, boolean datashow, boolean amplificador) {
        this.agendamentosPK = agendamentosPK;
        this.dia = dia;
        this.preaula = preaula;
        this.primeirop = primeirop;
        this.segundop = segundop;
        this.datashow = datashow;
        this.amplificador = amplificador;
    }

    public Agendamentos(int idagendamento, int idprofessor, int idturma, int idcurso) {
        this.agendamentosPK = new AgendamentosPK(idagendamento, idprofessor, idturma, idcurso);
    }

    public AgendamentosPK getAgendamentosPK() {
        return agendamentosPK;
    }

    public void setAgendamentosPK(AgendamentosPK agendamentosPK) {
        this.agendamentosPK = agendamentosPK;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public boolean getPreaula() {
        return preaula;
    }

    public void setPreaula(boolean preaula) {
        this.preaula = preaula;
    }

    public boolean getPrimeirop() {
        return primeirop;
    }

    public void setPrimeirop(boolean primeirop) {
        this.primeirop = primeirop;
    }

    public boolean getSegundop() {
        return segundop;
    }

    public void setSegundop(boolean segundop) {
        this.segundop = segundop;
    }

    public boolean getDatashow() {
        return datashow;
    }

    public void setDatashow(boolean datashow) {
        this.datashow = datashow;
    }

    public boolean getAmplificador() {
        return amplificador;
    }

    public void setAmplificador(boolean amplificador) {
        this.amplificador = amplificador;
    }

    public Professores getProfessores() {
        return professores;
    }

    public void setProfessores(Professores professores) {
        this.professores = professores;
    }

    public Turmas getTurmas() {
        return turmas;
    }

    public void setTurmas(Turmas turmas) {
        this.turmas = turmas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendamentosPK != null ? agendamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamentos)) {
            return false;
        }
        Agendamentos other = (Agendamentos) object;
        if ((this.agendamentosPK == null && other.agendamentosPK != null) || (this.agendamentosPK != null && !this.agendamentosPK.equals(other.agendamentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ikatoo.agendamentobackend.models.Agendamentos[ agendamentosPK=" + agendamentosPK + " ]";
    }
    
}
