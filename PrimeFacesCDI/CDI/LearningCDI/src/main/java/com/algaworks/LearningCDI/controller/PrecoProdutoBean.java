package com.algaworks.LearningCDI.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.LearningCDI.service.CalculadoraPreco;

//Usar import enterprise (CDI)
//@Dependent - (Default) -> Instancia e morre na mesma hora
//@RequestScoped -> Por request
//@SessionScoped -> Exige serialização
//@ApplicationScoped

@Named
@SessionScoped
public class PrecoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@Inject
	private CalculadoraPreco calculadora;
	
//	@Inject
//	public void setCalculadora(CalculadoraPreco calculadora){
//		this.calculadora = calculadora;
//	}
	
	public PrecoProdutoBean() { //É obrigatorio ter o construtor padrão!
	}
	
	@Inject
	public PrecoProdutoBean(CalculadoraPreco calculadora) {
		this.calculadora = calculadora;
	}
	
	@PostConstruct
	public void init(){
		//Alternativa para evitar inserir processamento no construtor, pois no CDI o construtor é chamado várias vêzes
		
		System.out.println("Init PrecoProdutoBean");
	}
	
	public double getValue(){
		System.out.println(calculadora);
		return calculadora.CalcularPreco(12, 44.55);
	}
	
}
