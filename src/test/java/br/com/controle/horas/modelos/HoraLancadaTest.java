package br.com.controle.horas.modelos;

import org.junit.Assert;
import org.junit.Test;

public class HoraLancadaTest {
	
	@Test
	public void calculaDuracaoQuandoHoraInicialMenorDoQueHoraFinal(){
		HoraLancada hora = new HoraLancada();
		
		hora.setHoraFinal("19:00");
		hora.setHoraInicial("09:00");
		
		Assert.assertEquals(10.0, hora.getDuracao(), 0.01);
	}
}
