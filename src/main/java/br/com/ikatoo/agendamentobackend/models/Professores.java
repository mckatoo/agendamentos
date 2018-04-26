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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "professores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professores.findAll", query = "SELECT p FROM Professores p")
    , @NamedQuery(name = "Professores.findByIdprofessor", query = "SELECT p FROM Professores p WHERE p.idprofessor = :idprofessor")
    , @NamedQuery(name = "Professores.findByProfessor", query = "SELECT p FROM Professores p WHERE p.professor = :professor")})
public class Professores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofessor")
    private Integer idprofessor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "professor")
    private String professor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professores")
    private List<Agendamentos> agendamentosList;

    public Professores() {
    }

    public Professores(Integer idprofessor) {
        this.idprofessor = idprofessor;
    }

    public Professores(Integer idprofessor, String professor) {
        this.idprofessor = idprofessor;
        this.professor = professor;
    }

    public Integer getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(Integer idprofessor) {
        this.idprofessor = idprofessor;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @XmlTransient
    public List<Agendamentos> getAgendamentosList() {
        return agendamentosList;
    }

    public void setAgendamentosList(List<Agendamentos> agendamentosList) {
        this.agendamentosList = agendamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofessor != null ? idprofessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professores)) {
            return false;
        }
        Professores other = (Professores) object;
        if ((this.idprofessor == null && other.idprofessor != null) || (this.idprofessor != null && !this.idprofessor.equals(other.idprofessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ikatoo.agendamentobackend.models.Professores[ idprofessor=" + idprofessor + " ]";
    }
    
}
