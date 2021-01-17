package Site.Spring.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;



@Entity
@Table(name = "Catégorie")
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "IdCategorie")
	private long id;

	@NotNull
	@Column(name = "NomCategorie")
	private String nom;
	@NotNull
	@Column(name = "Caractéristiques")
	private String description;
	
	// une categorie peu contenir un ensemble de produits
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Produit> produits = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Categorie(String nom, String description, Set<Produit> produits) {
		super();
		this.nom = nom;
		this.description = description;
		this.produits = produits;
	}
	

	public Categorie(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Categorie(long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public Categorie() {
		super();
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", description=" + description + ", produits=" + produits + "]";
	}
	
}
