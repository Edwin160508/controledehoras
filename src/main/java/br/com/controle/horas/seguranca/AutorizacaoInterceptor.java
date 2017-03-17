package br.com.controle.horas.seguranca;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.controle.horas.controllers.LoginController;

@Intercepts
public class AutorizacaoInterceptor {
	
	private UsuarioLogado usuarioLogado;
	
	private Result result;
	
	private ControllerMethod method;
	
	@Accepts
	public boolean accept(){
		return !this.method.containsAnnotation(Open.class);
	}
	
	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod method){
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
	}
	
	public AutorizacaoInterceptor(){}
	
	/**A Annotation @AroundCall do VRaptor Faz com que esse método sempre
	 * será chamado para verificar autenticação do usuário logado.
	 * 
	 * Mas será nescessário criar a Annotation @Open para atribuir
	 * a lógica de acesso a aplicação caso contrário o sistema nunca
	 * sairá da tela de login.
	 * O @Open vai informar ao VRaptor que usuários deslogados também
	 * podem ter aesso ao método intercept.
	 * 
	 * @author edwin*/
	@AroundCall
	public void intercept(SimpleInterceptorStack stack){
		if(this.usuarioLogado.isLogado()){//se o usuario estiver logado então
			stack.next();
		}else{//se não estiver logado então sera redirecionado para form
			this.result.redirectTo(LoginController.class).form();
		}
	}
}
