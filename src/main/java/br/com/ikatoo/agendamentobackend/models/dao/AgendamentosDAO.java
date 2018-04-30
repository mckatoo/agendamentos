/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models.dao;

import br.com.ikatoo.agendamentobackend.connection.ConnectionFactory;
import br.com.ikatoo.agendamentobackend.models.Agendamentos;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mckatoo
 */
public class AgendamentosDAO {

    private EntityManager em = new ConnectionFactory().getConnection();

    public Agendamentos save(Agendamentos agendamentos) {

        try {
            em.getTransaction().begin();
            if (agendamentos.getIdagendamento() == null) {
                em.persist(agendamentos);
            } else {
                em.merge(agendamentos);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return agendamentos;

    }

    public Agendamentos remove(Integer id) {

        Agendamentos agendamentos = null;

        try {
            agendamentos = em.find(Agendamentos.class, id);
            em.getTransaction().begin();
            em.remove(agendamentos);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return agendamentos;

    }

    public Agendamentos findById(Integer id) {

        Agendamentos agendamentos = null;

        try {
            agendamentos = em.find(Agendamentos.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return agendamentos;

    }

    public List<Agendamentos> findAll() {

        List<Agendamentos> agendamentos = null;

        try {
            agendamentos = em.createQuery("from Agendamentos p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        
        System.out.println("listando agendamentos");

        return agendamentos;

    }

}
