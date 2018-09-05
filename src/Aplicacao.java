import dao.ClienteDAO;
import entidades.Cliente;
import entidades.Endereco;

public class Aplicacao {

	public static void main(String[] args) {
		
		Endereco endereco = new Endereco("Brasil", "Paraíba", "João Pessoa", "Bessa", "666", "casa", "58035-192");
		Cliente cliente = new Cliente("Lincoln", 1, endereco);
		ClienteDAO c = new ClienteDAO();
		
		c.adicionarCliente(cliente);		
		c.AtualizarCliente(1,"Lincoln Modificado",2 );
		cliente = c.BuscarClientePorIdEager(1);
		System.out.println(cliente.toString());
		cliente = c.BuscarClientePorIdLazy (1);
		System.out.println(cliente.toString());
		System.out.println(c.findAll().toString());
		//c.RemoverCliente(1);
		c.DesvincularCliente(cliente);
	}

}
