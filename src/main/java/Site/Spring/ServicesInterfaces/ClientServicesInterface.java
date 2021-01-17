package Site.Spring.ServicesInterfaces;

import java.util.List;

import Site.Spring.Entities.Client;

public interface ClientServicesInterface {

	public Client getClientById(long id);

	public String ajouterClient(Client client);

	public String updateClient(Client client);

	public String deleteClient(Client client);

	public String deleteClientById(long id);

	public List<Client> findClientByNom(String nom);

	public List<Client> findClientByPrenom(String nom);

	public List<Client> findByNomContains(String partOfNom);

	public List<Client> findByPrenomContains(String partOfPrenom);

	public List<Client> findAll();

}
