package com.sclw.dto;

import java.io.Serializable;

public class FotoNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer laudoId;
	private Integer laudoItem;
	private Integer id;
	private String path;
	private Short pagina1;
	private Short grande;
	private String tema;
	private String frase;
	
	public FotoNewDTO() {
		super();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getLaudoId() {
		return laudoId;
	}

	public void setLaudoId(Integer laudoId) {
		this.laudoId = laudoId;
	}

	public Integer getLaudoItem() {
		return laudoItem;
	}

	public void setLaudoItem(Integer laudoItem) {
		this.laudoItem = laudoItem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getPagina1() {
		return pagina1;
	}

	public void setPagina1(Short pagina1) {
		this.pagina1 = pagina1;
	}

	public Short getGrande() {
		return grande;
	}

	public void setGrande(Short grande) {
		this.grande = grande;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
}
