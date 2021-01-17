package Site.Spring.ServicesInterfaces;

import java.util.List;

import Site.Spring.Entities.Categorie;

public interface CategorieServicesInterface {
	public Categorie getCategorieById(long id);

	public String ajouterCategorie(Categorie categorie);

	public String updateCategorie(Categorie categorie);

	public String deleteCategorie(Categorie categorie);

	public String deleteCategorieById(long id);

	public List<Categorie> findCategorieByNom(String nom);

	public List<Categorie> findByDescriptionContains(String partOfDescription);

	public List<Categorie> findAll();

}
