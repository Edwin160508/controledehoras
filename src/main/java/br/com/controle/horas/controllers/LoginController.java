package br.com.controle.horas.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.controle.horas.daos.UsuarioDao;
import br.com.controle.horas.modelos.Usuario;
import br.com.controle.horas.seguranca.Open;
import br.com.controle.horas.seguranca.UsuarioLogado;

@Controller
public class LoginController {

		/**Receber o UsuarioDao*/
		private UsuarioDao usuarioDao;
		
		/**Objeto de referência verificando 
		 * qual é o usuario logado*/
		private UsuarioLogado usuarioLogado;
		
		private Result result;
		
		private Validator validator;
		
		@Inject
		public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado, Result result, Validator validator){
			this.usuarioDao = usuarioDao;
			this.usuarioLogado = usuarioLogado;
			this.result = result;
			this.validator = validator;
		}
		
		public LoginController(){}
		
		/**Métodos de Rotas*/
		@Open
		public void form(){}
		
		@Open
		public void autentica(String login, String senha){
			Usuario usuario = this.usuarioDao.busca(login, senha);
			if(usuario != null){
				this.usuarioLogado.fazLogin(usuario);
				this.result.redirectTo(UsuarioController.class).lista();
			}else{
				this.validator.add(new SimpleMessage("login_invalido", "Login ou senha incorretos."));
				this.validator.onErrorRedirectTo(this).form();
			}
		}
		
		@Open
		public void desloga(){
			this.usuarioLogado.desloga();
			this.result.redirectTo(this).form();
		}
}
