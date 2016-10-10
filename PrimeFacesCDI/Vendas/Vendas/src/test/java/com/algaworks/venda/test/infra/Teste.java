package com.algaworks.venda.test.infra;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.algaworks.venda.model.Cliente;
import com.algaworks.venda.model.Endereco;
import com.algaworks.venda.model.TipoPessoa;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Japonês da Federal");
		cliente.setEmail("japones@policiafederal.com");
		cliente.setDocumentoReceitaFederal("123.123.123-12");
		cliente.setTipo(TipoPessoa.FISICA);
		
//		Cliente cliente = manager.find(Cliente.class, new Long(1));
//		
//		Endereco endereco = new Endereco();
//		endereco.setLogradouro("Rua de brasilia");
//		endereco.setNumero("111");
//		endereco.setCidade("Uberlândia");
//		endereco.setUf("MG");
//		endereco.setCep("1233-122");
//		endereco.setCliente(cliente);
//		
//		cliente.getEnderecos().add(endereco);
		
		manager.persist(cliente);
		
		trx.commit();
		manager.close();
		
		System.out.println("Cliente cadastrado com sucesso");
	}

}
