package Site.Spring.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Site.Spring.Entities.Produit;

@Repository("ProduitRepository")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	public Produit findProduitById(long id);

	public List<Produit> findByNom(String nom);

	public List<Produit> findByPrix(float prix);

	public List<Produit> findByNomContains(String partOfNom);

	public List<Produit> findByDescriptionContains(String partOfDescription);

	public List<Produit> findByStatusContains(String partOfStatus);

}
