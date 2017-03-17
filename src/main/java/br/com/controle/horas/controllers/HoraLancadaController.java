package br.com.controle.horas.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.controle.horas.daos.HoraLancadaDao;
import br.com.controle.horas.modelos.HoraLancada;
import br.com.controle.horas.seguranca.UsuarioLogado;

@Controller
public class HoraLancadaController {
	
	private HoraLancadaDao horaLancadaDao;
	
	private Validator validator;
	
	private Result result;
	
	/**Verificar qual usuário esta logado, 
	 * no momento em que está lançando 
	 * horas no sistema.
	 * 
	 * */
	private UsuarioLogado usuarioLogado;
	
	@Inject
	public HoraLancadaController(HoraLancadaDao horaLancadaDao, Validator validator, Result result, UsuarioLogado usuarioLogado){
		this.horaLancadaDao = horaLancadaDao;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	public HoraLancadaController(){}
	
	/**Metodos de Rotas*/
	public void form(){}
	
	public void adiciona(@Valid HoraLancada horaLancada){
		this.validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(this.usuarioLogado.getUsuario());
		this.horaLancadaDao.adiciona(horaLancada);
		this.result.redirectTo(this).lista();
	}
	
	public void lista(){
		this.result.include("horas", this.horaLancadaDao.lista());
	}
	
	
}
