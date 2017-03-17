package br.com.controle.horas.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.controle.horas.modelos.HoraLancada;

public class HoraLancadaDao {

	private EntityManager manager;
	
	@Inject
	public HoraLancadaDao(EntityManager manager){
		this.manager = manager;
	}
	public HoraLancadaDao(){}
	
	public List<HoraLancada> lista() {
		String jpql = "select h from HoraLancada h";
		TypedQuery<HoraLancada> query = this.manager.createQuery(jpql, HoraLancada.class);
		return query.getResultList();
	}
	
	public void adiciona(HoraLancada horaLancada) {
		this.manager.getTransaction().begin();
		this.manager.persist(horaLancada);
		this.manager.getTransaction().commit();
		
	}


}
