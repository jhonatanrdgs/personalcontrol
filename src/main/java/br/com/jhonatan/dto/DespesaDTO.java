package br.com.jhonatan.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DespesaDTO {
	
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
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
}
