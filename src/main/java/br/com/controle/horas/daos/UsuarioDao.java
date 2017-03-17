package br.com.controle.horas.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.controle.horas.modelos.Usuario;

@RequestScoped //Classe de componente CDI que vai injetar para o controller
public class UsuarioDao {
	
	
	private EntityManager manager;
	
	@Inject 
	public UsuarioDao(EntityManager manager){
		this.manager = manager;
	}
	
	/**Para o CDI operar corretamente 
	 * é necessário ter um construtor vazio**/
	public UsuarioDao(){} 
	
	/**Métodos Crud**/
	public void adiciona(Usuario usuario){
		this.manager.getTransaction().begin();//Iniciar Transação
		this.manager.persist(usuario);//persistir na base
		this.manager.getTransaction().commit();//Commitando na base e finalizando transação.
	}
	
	public List<Usuario> lista(){
		TypedQuery<Usuario> query = this.manager.createQuery("select u from Usuario u", Usuario.class);//Passando PQL
		return query.getResultList();
	}

	public Usuario busca(String login, String senha) {
		TypedQuery<Usuario> query = this.manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		return query.getSingleResult();
	}

}
