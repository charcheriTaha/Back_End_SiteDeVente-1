package Site.Spring.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Site.Spring.Entities.Client;
@Repository("ClientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Client findClientById(long id);

	public List<Client> findByNom(String nom);

	public List<Client> findByPrenom(String prenom);

	public List<Client> findByAddresse(String adresse);

	public List<Client> findByNomContains(String partOfNom);

}
