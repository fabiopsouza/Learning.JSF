package com.algaworks.venda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.algaworks.venda.model.Categoria;
import com.algaworks.venda.model.Produto;
import com.algaworks.venda.repository.Categorias;
import com.algaworks.venda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categorias categorias;
	
	private Produto produto;
	
	private Categoria categoriaPai;
	
	//private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;

	public CadastroProdutoBean(){
		this.produto = new Produto();
	}
	
	public void inicializar(){
		//categoriasRaizes = em.createQuery("from Categoria", Categoria.class).getResultList();
	}
	
	public void carregarSubCategorias(){
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	
	public void salvar(){
		System.out.println("Categoria pai seleceionada: " + categoriaPai.getDescricao());
		System.out.println("Sub-categoria selecionada: " + produto.getCategoria().getDescricao());
	}

	public Produto getProduto() {
		return produto;
	}
	
	public List<Categoria> getCategoriasRaizes() {		
		return categorias.raizes();
	}
	
	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

}
