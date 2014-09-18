package br.senai.sc.ti2013n.pw.di.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.ti2013n.pw.di.entity.Pessoa;
import br.senai.sc.ti2013n.pw.di.util.JpaUtil;

public class PessoaDAO {

	private static EntityManager entityManager;

	public static void main(String[] args) {
		JpaUtil.iniciarPersistenceUnit();
		entityManager = JpaUtil.getEntityManager();
		// Método Main para testar os métodos.
		// Aqui poem comentário o que não vão usar

		cadastrarCliente();
		excluirCliente();
		editarCliente();

		// Não tá funcionando.
		listarCliente();
		entityManager.close();
		JpaUtil.fecharPersistenceUnit();
	}

	private static void cadastrarCliente() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Nome");
		pessoa.setSobreNome("Sobre Nome");
		pessoa.seteMail("E-Mail");
		pessoa.setTelefone("Telefone");
		entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		entityManager.getTransaction().commit();
	}

	private static void listarCliente() {
		Query query = entityManager.createQuery("From Pessoa", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();
		for (Pessoa pessoa : pessoas) {
			System.out.print("Nome: " + pessoa.getNome());
			System.out.print("Sobre Nome: " + pessoa.getSobreNome());
			System.out.print("E-Mail: " + pessoa.geteMail());
			System.out.print("Telefone: " + pessoa.getTelefone());
			if (pessoa.getId() == 1L) {
				// for Pessoa pe : pessoa.getNome())) {
				// System.out.println("Nome: " + pe.getNome());
				// }
			}
		}
	}

	private static void excluirCliente() {
		entityManager.getTransaction().begin();
		Pessoa pessoa = entityManager.find(Pessoa.class, 1L);
		entityManager.remove(pessoa);
		entityManager.getTransaction().commit();
	}

	private static void editarCliente() {
		entityManager.getTransaction().begin();
		Pessoa pessoa = entityManager.find(Pessoa.class, 1L);
		pessoa.setNome("Nome 01");
		pessoa.setSobreNome("Sobre Nome 01");
		pessoa.seteMail("E-Mail 01");
		pessoa.setTelefone("Telefone 01");
		entityManager.merge(pessoa);
		entityManager.getTransaction().commit();

	}
}
