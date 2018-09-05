package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ClienteDAO;
import entidades.Cliente;
/*
adicionarCliente - ok 
BuscarClientePorIdEager - (find) - ok
BuscarClientePorIdLazy- (getReference) - ok
AtualizarCliente - ok
DesvincularCliente - (detach) - ok
RemoverCliente - ok */

public class ClienteDAO {

	private static ClienteDAO instance;
	protected EntityManager entityManager;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}

		return instance;
	}

	public ClienteDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	/* Adicionar */

	public Cliente adicionarCliente(Cliente cliente) {

		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		return cliente;
	}
	
	/*Buscar tudo*/
	
	@SuppressWarnings("unchecked")
    public List<Cliente> findAll() {
              return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
    }

	/* Buscar Eager */

	public Cliente BuscarClientePorIdEager(final int id) {
		return entityManager.find(Cliente.class, id);
	}

	/* Buscar Lazy */

	public Cliente BuscarClientePorIdLazy(final int id) {
		return entityManager.getReference(Cliente.class, id);
	}

	/* Atualizar */

	public void AtualizarCliente(final int id , String nome, int prioridade) {

		try {
			Cliente cliente = BuscarClientePorIdEager(id);
			entityManager.getTransaction().begin();
			cliente.setNome(nome);
			cliente.setPrioridade(prioridade);
			entityManager.merge(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}
	
	/* Desvincular */

	public void DesvincularCliente(Cliente cliente) {
		entityManager.detach(cliente);
	}

	/* Remover */

	public void remove(Cliente cliente) {
		try {
			entityManager.getTransaction().begin();
			cliente = entityManager.find(Cliente.class, cliente.getId());
			entityManager.remove(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void RemoverCliente(final int id) {
		try {
			Cliente cliente = BuscarClientePorIdEager(id);
			remove(cliente);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
