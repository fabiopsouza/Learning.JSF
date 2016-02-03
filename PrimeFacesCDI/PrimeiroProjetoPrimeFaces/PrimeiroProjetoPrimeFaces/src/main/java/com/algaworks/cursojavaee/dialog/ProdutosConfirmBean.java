package com.algaworks.cursojavaee.dialog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProdutosConfirmBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> produtos = new ArrayList<>();
	private String produtoSelecionado;

	public ProdutosConfirmBean() {
		produtos.add("Arroz");
		produtos.add("Feijão");
		produtos.add("Queijo");
		produtos.add("Notebook");
	}

	public void excluirProduto() {
		produtos.remove(produtoSelecionado);
	}
	
	public List<String> getProdutos() {
		return produtos;
	}

	public String getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(String produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
}