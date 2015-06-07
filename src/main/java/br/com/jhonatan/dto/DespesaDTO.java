package br.com.jhonatan.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DespesaDTO extends BaseDTO {
	
	private String descricao;
	private Long categoriaId;
	private Long metodoPagamentoId;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date inicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fim;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public Long getMetodoPagamentoId() {
		return metodoPagamentoId;
	}
	public void setMetodoPagamentoId(Long metodoPagamentoId) {
		this.metodoPagamentoId = metodoPagamentoId;
	}
	public Date getInicio() {
		return this.inicio;
	}
	
	public Date getInicioFormatado() {
		if (inicio == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				inicio = sdf.parse("01/01/1970");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return inicio;
	}
	
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	
	public Date getFim() {
		return this.fim;
	}
	
	public Date getFimFormatado() {
		if (fim == null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				fim = sdf.parse("01/01/3000");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
}
