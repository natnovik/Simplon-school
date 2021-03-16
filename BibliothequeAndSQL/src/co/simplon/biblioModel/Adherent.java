package co.simplon.biblioModel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;


public class Adherent {	
	private int id;
	private String nom;
    private String prenom;
    private String mail;
    private String adressePost;
    private String dateOfB;
   // private ArrayList<Exemplaire>listeExampl = new ArrayList <Exemplaire>();
    
    public Adherent() {
    	
    	super();
    }
    public Adherent(int id, String nom, String prenom, String mail, String adressePost, String dateOfB) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.mail = mail;
	this.adressePost = adressePost;
	this.dateOfB = dateOfB;
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdressePost() {
		return adressePost;
	}
	public void setAdressePost(String adressePost) {
		this.adressePost = adressePost;
	}
	public String getDateOfB() {
		return dateOfB;
	}
	public void setDateOfB(String dateOfB) {
		this.dateOfB = dateOfB;
	}
	@Override
	public String toString() {
		return "Adherent [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", adressePost="
				+ adressePost + ", dateOfB=" + dateOfB + "]" + "\n";
	}
   
}
