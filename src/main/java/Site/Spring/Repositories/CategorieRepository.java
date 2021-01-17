package Site.Spring.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Site.Spring.Entities.Categorie;

@Repository("CategorieRepository")
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

	public Categorie findCategorieById(long id);

	public List<Categorie> findByNom(String nom);

	public List<Categorie> findByNomContains(String partOfNom);

	public List<Categorie> findByDescriptionContains(String partOfDescription);

}
