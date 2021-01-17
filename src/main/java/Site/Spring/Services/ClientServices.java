package Site.Spring.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Site.Spring.Entities.Client;
import Site.Spring.Entities.Client;
import Site.Spring.Entities.Client;
import Site.Spring.Repositories.ClientRepository;
import Site.Spring.ServicesInterfaces.ClientServicesInterface;

@Transactional
@Service("clientServices")
public class ClientServices implements ClientServicesInterface {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client getClientById(long id) {
		// TODO Auto-generated method stub
		return clientRepository.findClientById(id);
	}

	@Override
	public String ajouterClient(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
		return "Client Enregistré";
	}

	@Override
	public String updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClient(Client client) {
		// TODO Auto-generated method stub
				clientRepository.delete(client);
				return "Client supprimé";
	}

	@Override
	public String deleteClientById(long id) {
		// TODO Auto-generated method stub
				clientRepository.deleteById(id);
				return "Client supprimé";
	}

	@Override
	public List<Client> findClientByNom(String nom) {
		// TODO Auto-generated method stub
		return (List<Client>) clientRepository.findByNom(nom);
	}

	@Override
	public List<Client> findClientByPrenom(String prenom) {
		// TODO Auto-generated method stub
		return (List<Client>) clientRepository.findByPrenom(prenom);
	}



	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
				List<Client> clients = new ArrayList<Client>();
				for (Client client : clientRepository.findAll())
					clients.add(client);
				return clients;
	}

	@Override
	public List<Client> findByNomContains(String partOfNom) {
		// TODO Auto-generated method stub
		return (List<Client>) clientRepository.findByNomContains(partOfNom);
	}

	@Override
	public List<Client> findByPrenomContains(String partOfPrenom) {
		// TODO Auto-generated method stub
		return (List<Client>) clientRepository.findByPrenom(partOfPrenom);
	}

	
}
