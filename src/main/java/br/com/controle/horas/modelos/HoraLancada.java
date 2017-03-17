package br.com.controle.horas.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hora_lancada")
public class HoraLancada {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(name="hora_inicial")
	private String horaInicial;
	
	@Column(name="hora_final")
	private String horaFinal;
	
	@ManyToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getDuracao(){
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			Date fim = format.parse(this.horaFinal);
			Date inicio = format.parse(this.horaInicial);
			long millis = fim.getTime() - inicio.getTime();
								  //hora * minuto * segundo	
			return ((double)millis)/(60*60*1000);
			
		} catch (ParseException e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
}
