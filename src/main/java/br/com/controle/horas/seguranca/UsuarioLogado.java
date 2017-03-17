package br.com.controle.horas.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.controle.horas.modelos.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable{

	private Usuario usuario;
	
	public void fazLogin(Usuario usuario){
		this.usuario = usuario;
	}
	public void desloga(){
		this.usuario = null;
	}
	public boolean isLogado(){
		return this.getUsuario() != null;
	}
	
	/**Get e set*/
	public Usuario getUsuario() {
		return usuario;
	}
	/**Set não foi necessário nesse caso
	 * por causa da autenticação que está 
	 * sendo feita na tela de login...
	 * 
	 * */
	
	
}
