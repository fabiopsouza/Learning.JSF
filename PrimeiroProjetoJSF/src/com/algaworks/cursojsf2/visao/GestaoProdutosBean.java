package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
//@ApplicationScoped
//@SessionScoped
@ViewScoped
//@RequestScoped
public class GestaoProdutosBean implements Serializable {

	private List<Produto> produtos;
	private Produto produto;
	private Produto produtoSelecionado;
	private String fabricantePesquisa;
	private List<Produto> produtosFiltrados;
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public GestaoProdutosBean(){
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
		this.produtosFiltrados = new ArrayList<Produto>();
	}
	
	public void pesquisar(){
		System.out.println("Pesquisando...");
	}
	
	public void fabricantePesquisaAlterado(ValueChangeEvent event){
		System.out.println("Valor atual: " + this.fabricantePesquisa);
		System.out.println("Novo valor: " + event.getNewValue());
		
		this.produtosFiltrados.clear();
		
		for(Produto produto : this.produtos){
			if(produto.getNome().toLowerCase().startsWith(event.getNewValue().toString().toLowerCase()))
				this.produtosFiltrados.add(produto);
		}
		
	}
	
	public void verificarInclusao(ActionEvent event){
		System.out.println("Verificando");
		if("".equals(this.produto.getFabricante())){
			this.produto.setFabricante("Sem fabricante");
		}
	}
	
	public void incluir(){
		System.out.println("Incluindo");
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void excluir(){
		this.produtos.remove(this.produtoSelecionado);
	}
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Iniciou bean");
	}
	
	@PreDestroy
	public void finalizar(){
		System.out.println("Finalizando bean");
	}
	
	public Produto getProduto(){
		return this.produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getFabricantePesquisa() {
		return fabricantePesquisa;
	}

	public void setFabricantePesquisa(String fabricantePesquisa) {
		this.fabricantePesquisa = fabricantePesquisa;
	}
}
