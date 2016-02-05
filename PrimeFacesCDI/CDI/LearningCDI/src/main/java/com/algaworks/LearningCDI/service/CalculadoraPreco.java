package com.algaworks.LearningCDI.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculadoraPreco {

	@PostConstruct
	public void init(){
		//Alternativa para evitar inserir processamento no construtor, pois no CDI o construtor é chamado várias vêzes
		
		System.out.println("Init CalculadoraPreco");
	}
	
	public double CalcularPreco(int quantidade, double precoUnitario){
		return quantidade * precoUnitario;
	}
	
}
