package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.dominio.Cliente;

@ManagedBean
@ViewScoped
public class ConsultaClienteBean {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void consultar(){
		this.getClientes().add(new Cliente(1, "Pedro Pereira", "Uberlandia"));
		this.getClientes().add(new Cliente(2, "José da Silva", "Araguai"));
		this.getClientes().add(new Cliente(3, "Joaquim Manoel", "Uberaba"));
		this.getClientes().add(new Cliente(4, "Sebastião Souza", "São Paulo"));
		this.getClientes().add(new Cliente(5, "Joana Carvalho", "Rio de Janeiro"));
		this.getClientes().add(new Cliente(6, "Maria José", "São Paulo"));
	}

	public void salvar(){
		for(Cliente cliente : this.getClientes())
			System.out.println("Codigo: " + cliente.getCodigo() + " Cliente: " + cliente.getNome());
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
