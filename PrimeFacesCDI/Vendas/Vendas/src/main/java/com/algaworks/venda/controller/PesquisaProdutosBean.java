package com.algaworks.venda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped //Extensão do Steve Taylor entende que ViewScoped é do CDI e não do JSF, então sobrescreve
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Integer> produtosFiltrados;
	
	public PesquisaProdutosBean() {
		produtosFiltrados = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			produtosFiltrados.add(i);
		}
	}

	public List<Integer> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
}