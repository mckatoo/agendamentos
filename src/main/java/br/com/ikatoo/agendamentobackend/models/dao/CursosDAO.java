/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models.dao;

import br.com.ikatoo.agendamentobackend.connection.ConnectionFactory;
import br.com.ikatoo.agendamentobackend.models.Cursos;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mckatoo
 */
public class CursosDAO {

    public Cursos save(Cursos cursos) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (cursos.getIdcurso() == null) {
                em.persist(cursos);
            } else {
                em.merge(cursos);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cursos;

    }

    public Cursos remove(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Cursos cursos = null;

        try {
            cursos = em.find(Cursos.class, id);
            em.getTransaction().begin();
            em.remove(cursos);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cursos;

    }

    public Cursos findById(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Cursos cursos = null;

        try {
            cursos = em.find(Cursos.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return cursos;

    }

    public List<Cursos> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();
        List<Cursos> cursos = null;

        try {
            cursos = em.createQuery("from Cursos p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return cursos;

    }

}
