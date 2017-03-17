package br.com.controle.horas.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**Classe responsável para produzir 
 * "Entity manager" para componentes CDI "Classes Dao"**
 * 
 * @author edwin lima
 */

@ApplicationScoped /*trata-se de componente criado apenas uma vez na aplicação*/
public class EntityManagerProduce {
	
	/**Passando apara a factory 
	 * a persistence-unit declarado no "persistence.xml" 
	 * com nome "default" onde é passado 
	 * informações de acesso a Base de Dados
	 * 
	 * @author edwin lima
	 */
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	
	/**Método que faz o processo das criações
	 * das EntityManager
	 *
	 *@author edwin lima
	 */
	@Produces /*Informando que esse é o método que vai ser utilizado para produção do EnetityManager*/
	@RequestScoped /*Gerar EntityManar por Requisição*/
	public EntityManager getEntityManager(){
		
		return this.factory.createEntityManager();
	}
	
	/**Método para fechar o EntityManager
	 * quando ele é criado precisa ser
	 * fechado.
	 * 
	 * Para avisar ao CDI "DAO" que este
	 * é o método que fecha o EntityManager
	 * colocando Annotation "@Dispose" no parametro
	 *
	 * @author edwin lima
	 */
	public void close(@Disposes EntityManager manager){
		manager.close();
	}
	
	
}
