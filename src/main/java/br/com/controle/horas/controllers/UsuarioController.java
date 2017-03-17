package br.com.controle.horas.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.controle.horas.daos.UsuarioDao;
import br.com.controle.horas.modelos.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDao usuarioDao;
	
	/** Atributo resposável para fazer redirecinamentos 
	 * de páginas quando nescessário.VRaptor.*/
	private Result result;
	
	/** Atributo responsavel para realizar validações
	 *  através do VRaptor*/
	private Validator validator;
	
	@Inject //Annotation que farar um inject no Dao
	public UsuarioController(UsuarioDao usuarioDao, Result result, Validator validator) {
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.validator = validator;
	}
	public UsuarioController() {}
	
	/**Métodos gerenciadores de Rotas**/
	@Path("/usuario")
	public void form(){}//metodo que abre pagina form.jsp Formulario de cadastro de usuario
	
	/**Annotation @Valid do bin validation valida atributos no model
	 * essa Annotation informa ao Hibernate que o objeto tem atributos com regras
	 * 
	 * Annotation @IncludeParameters pertence ao VRaptor ela server para salvar
	 * valores do form em memória caso ocorra algum erro que faça ser redirecionaod ao form 
	 * os dados estarão preenchidos.*/
	@IncludeParameters
	public void adiciona(@Valid Usuario usuario){
		/*Antes de persistir será feita validação
		 * caso ocorra erro retorna ao form*/
		this.validator.onErrorRedirectTo(this).form();
		this.usuarioDao.adiciona(usuario);
		/*apos adicionar usuario redirecione 
		 * para lista de usuarios*/
		this.result.redirectTo(this).lista();
	}
	
	public void lista(){
		List<Usuario> usuarios = this.usuarioDao.lista();
		this.result.include("usuarios", usuarios);
	}
}
