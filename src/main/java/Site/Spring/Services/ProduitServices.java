package Site.Spring.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Site.Spring.Entities.Produit;
import Site.Spring.Repositories.ProduitRepository;
import Site.Spring.ServicesInterfaces.ProduitServicesInterface;


@Transactional
@Service("produitServices")
public class ProduitServices implements ProduitServicesInterface {

	@Autowired
	ProduitRepository produitRepository;

	@Override
	public Produit getProduitById(long id) {
		// TODO Auto-generated method stub
		return produitRepository.findProduitById(id);
	}

	@Override
	public String ajouterProduit(Produit produit) {
		// TODO Auto-generated method stub
		produitRepository.save(produit);
		return "Produit Enregistré";
	}

	@Override
	public String updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduit(Produit produit) {
		// TODO Auto-generated method stub
		produitRepository.delete(produit);
		return "Produit supprimé";
	}

	@Override
	public String deleteProduitById(long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
		return "Produit supprimé";
	}

	@Override
	public List<Produit> findProduitByNom(String partOfNom) {
		return (List<Produit>) produitRepository.findByNomContains(partOfNom);

	}

	@Override
	public List<Produit> findByDescriptionContains(String partOfDescription) {
		// TODO Auto-generated method stub
		return (List<Produit>) produitRepository.findByDescriptionContains(partOfDescription);
	}

	@Override
	public List<Produit> findByStatusContains(String partOfStatus) {
		// TODO Auto-generated method stub
		return (List<Produit>) produitRepository.findByStatusContains(partOfStatus);
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		List<Produit> produits = new ArrayList<Produit>();
		for (Produit produit : produitRepository.findAll())
			produits.add(produit);
		return produits;
	}



}
