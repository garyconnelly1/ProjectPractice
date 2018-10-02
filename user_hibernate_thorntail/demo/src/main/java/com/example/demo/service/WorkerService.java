package com.example.demo.service;


import com.example.demo.model.Worker;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class WorkerService {

	@PersistenceContext(name = "MyPU")
	EntityManager em;

	public Worker save(Worker worker) {
		em.persist(worker.getAddress());
		em.persist(worker);
		return worker;
	}
	
	public List<Worker> findAll() {
        return em.createNamedQuery("Worker.findAll", Worker.class).getResultList();
    }
	
	 public Worker findById(int id) {
	        try {
	            return em.createQuery("select u from Worker w where w.workerId = " + id, Worker.class).getSingleResult();
	        } catch (Exception e) {
	            System.err.println(e);
	            return null;
	        }
	    }
	 
	 public Worker update(Worker worker) {
	        try {
	            em.merge(worker.getAddress());
	            return em.merge(worker);
	        } catch (Exception e) {
	            System.err.println(e);
	            return null;
	        }
	    }
	 
	 public boolean delete(int id) {
	        try {
	            Worker worker = findById(id);
	            em.remove(worker.getAddress());
	            em.remove(worker);
	            return true;
	        } catch(Exception  e) {
	            System.err.println(e);
	            return false;
	        }
	    }

}
