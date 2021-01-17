package Site.Spring.ServicesInterfaces;

import java.util.List;

import Site.Spring.Entities.Produit;



public interface ProduitServicesInterface {

	public Produit getProduitById(long id);

	public String ajouterProduit(Produit produit);

	public String updateProduit(Produit produit);

	public String deleteProduit(Produit produit);

	public String deleteProduitById(long id);

	public List<Produit> findProduitByNom(String nom);

	public List<Produit> findByDescriptionContains(String partOfDescription);

	public List<Produit> findByStatusContains(String partOfStatus);

	public List<Produit> findAll();

}
