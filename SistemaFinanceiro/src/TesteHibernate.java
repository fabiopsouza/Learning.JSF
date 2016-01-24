import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.util.HibernateUtil;

public class TesteHibernate {

	public static void main(String[] args) {

		EntityManager em = new HibernateUtil().getEntityManager();
		List<Lancamento> lancamentos = em.createQuery("SELECT lancamento FROM Lancamento lancamento INNER JOIN lancamento.pessoa pessoa"
				+ " WHERE lancamento.pessoa.codigo = pessoa.codigo").getResultList();

		for (Lancamento l : lancamentos) {
			System.out.println("Lançamento: " + l.getDescricao() + " - Pessoa: " + l.getPessoa().getNome());
		}
		
		em.close();
	}
	
}
