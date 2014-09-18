package br.senai.sc.ti2013n.pw.di.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti2013n.pw.di.entity.Divulgacao;
import br.senai.sc.ti2013n.pw.di.entity.Pessoa;
import br.senai.sc.ti2013n.pw.di.util.JpaUtil;

public class DivulgacaoDAO {

	private static EntityManager entityManager;

	public static void main(String[] args) {
		JpaUtil.iniciarPersistenceUnit();
		entityManager = JpaUtil.getEntityManager();
		// M�todo Main para testar os m�todos.
		// Aqui poem coment�rio o que n�o v�o usar

		cadastrarDivulgacao();
		excluirDivulgacao();
		editarDivulgacao();

		// N�o t� funcionando.
		listarDivulgacao();

		entityManager.close();
		JpaUtil.fecharPersistenceUnit();
	}

	private static void cadastrarDivulgacao() {
		Divulgacao divulgacao = new Divulgacao();
		divulgacao.setNomeDivulgacao("Nome");
		divulgacao.setDescricaoDivulgacao("Descri��o");
		divulgacao.setCategoriaDivulgacao("Categoria");
		divulgacao.setLocalDivulgacao("Local");
		divulgacao.setSiteDivulgacao("Site");
		divulgacao.setTelefoneDivulgacao("Telefone");

		entityManager.getTransaction().begin();
		entityManager.persist(divulgacao);
		entityManager.getTransaction().commit();
	}

	private static void listarDivulgacao() {
		Query query = entityManager
				.createQuery("From Divulgacao", Pessoa.class);
		List<Divulgacao> divulgacoes = query.getResultList();

		for (Divulgacao divulgacao : divulgacoes) {
			System.out.print("Nome: " + divulgacao.getNomeDivulgacao());
			System.out.print("Descri��o: "
					+ divulgacao.getDescricaoDivulgacao());
			System.out.print("Categoria: "
					+ divulgacao.getCategoriaDivulgacao());
			System.out.print("Local: " + divulgacao.getLocalDivulgacao());
			System.out.print("Site: " + divulgacao.getSiteDivulgacao());
			System.out.print("Telefone: " + divulgacao.getTelefoneDivulgacao());
			if (divulgacao.getId() == 1L) {
				// for (Pessoa programa : divulgacao.getNomeDivulgacao()) {
				// System.out.println("programa: " + programa.getNome());
				// }
			}
		}
	}

	private static void excluirDivulgacao() {
		entityManager.getTransaction().begin();
		Divulgacao divulgacao = entityManager.find(Divulgacao.class, 1L);
		entityManager.remove(divulgacao);
		entityManager.getTransaction().commit();
	}

	private static void editarDivulgacao() {
		entityManager.getTransaction().begin();
		Divulgacao divulgacao = entityManager.find(Divulgacao.class, 1L);
		divulgacao.setNomeDivulgacao("Nome 01");
		divulgacao.setDescricaoDivulgacao("Descri��o 01");
		divulgacao.setCategoriaDivulgacao("Categoria 01");
		divulgacao.setLocalDivulgacao("Local 01");
		divulgacao.setSiteDivulgacao("Site 01");
		divulgacao.setTelefoneDivulgacao("Telefone 01");
		entityManager.merge(divulgacao);
		entityManager.getTransaction().commit();

	}
}
