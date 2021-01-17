package Site.Spring.Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@Entity
public class Client implements Serializable {

	/**
	 * @taha
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "IdClient")
	private long id;

	@NotNull
	@Column(name = "NomClient")
	private String nom;

	@NotNull
	@Column(name = "PrénomClient")
	private String prenom;

	@NotNull
	@Column(name = "NuméroTéléphonne")
	private int telephone;

	@NotNull
	@Column(name = "E_mail")
	private String email;

	@NotNull
	@Column(name = "AddresseClient")
	private String addresse;
	


	// une categorie peu contenir un ensemble de produits
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Client> client = new HashSet<>();

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Client(String nom, String prenom, int telephone, String email, String addresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.addresse = addresse;
	}

	@Override
	public String toString() {
		
		return "Client {id:" + id + ", nom:" + nom + ", prenom:" + prenom + ", telephone:" + telephone + ", email:"
				+ email + ", addresse:" + addresse +"}";

	}

	public Client() {
		super();
	}
	
}
