package br.com.jhonatan.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.jhonatan.util.Constantes;

public class DespesaDTO extends BaseDTO {
	
	private String descricao;
	private Long categoriaId;
	private Long metodoPagamentoId;
	@DateTimeFormat(pattern = Constantes.FORMATO_DATA_PT_BR)
	private Date inicio;
	@DateTimeFormat(pattern = Constantes.FORMATO_DATA_PT_BR)
	private Date fim;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(final Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public Long getMetodoPagamentoId() {
		return metodoPagamentoId;
	}
	public void setMetodoPagamentoId(final Long metodoPagamentoId) {
		this.metodoPagamentoId = metodoPagamentoId;
	}
	public Date getInicio() {
		return this.inicio;
	}
	
	public Date getInicioFormatado() {
		if (inicio == null) {
			final SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_DATA_PT_BR);
			try {
				inicio = sdf.parse("01/01/1970");
			} catch (final ParseException e) {
				e.printStackTrace();
			}
		}
		return inicio;
	}
	
	public void setInicio(final Date inicio) {
		this.inicio = inicio;
	}
	
	public Date getFim() {
		return this.fim;
	}
	
	public Date getFimFormatado() {
		if (fim == null) {
			final SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_DATA_PT_BR);
			try {
				fim = sdf.parse("01/01/3000");
			} catch (final ParseException e) {
				e.printStackTrace();
			}
		}
		return fim;
	}
	public void setFim(final Date fim) {
		this.fim = fim;
	}
	
}
