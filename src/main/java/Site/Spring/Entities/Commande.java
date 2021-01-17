package Site.Spring.Entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Timer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;


@Entity
public class Commande implements Serializable {
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "IdCommande")
	private long id;
	
	@Column(name = "DateCommande")
	private Date date;

	//@ManyToMany
	//Set<Produit> produits;

	//Categorie 
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Client client; 
	
	@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable(name = "PRODUITS_COMMANDES" )
	private Collection<Produit> produits=new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	

	public Commande(Date date, Client clients) {
		super();
		this.date = date;
		
		this.client= clients;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande() {
		super();
	}
	
	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + ", clients=" + client + "]";
	}




	

	
	

	
}
