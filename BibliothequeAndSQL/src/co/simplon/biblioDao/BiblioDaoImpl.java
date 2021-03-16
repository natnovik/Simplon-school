package co.simplon.biblioDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
//import java.time.LocalDate;

import co.simplon.biblioModel.Adherent;


public class BiblioDaoImpl implements BiblioDAO{
	
	private DAOContext daoContext = new DAOContext();
	private Connection connection = null;
	
	//constructor
	
	public BiblioDaoImpl(DAOContext daoContext) {
		super();
		this.daoContext = daoContext;
	}
	
	//method from the Interface

	@Override
	public List<Adherent> lister() {
		
		ArrayList<Adherent>listOfAdherents = new ArrayList <Adherent>();
		Adherent adherentExistEntry = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			
			connection = DAOContext.get_Connection();
			statement = connection.createStatement();
			result = statement.executeQuery("select * from biblioteque.Adherent;");
			
			while (result.next()) {
			
				int id = result.getInt("id_adherent");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String mail = result.getString("mail");
				String adressePost = result.getString("adresse");
				String dateofB = result.getString("dateofB"); 
				
				adherentExistEntry = new Adherent(id, nom, prenom, mail, adressePost, dateofB);
				listOfAdherents.add(adherentExistEntry);
			}	
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return listOfAdherents;
	}

	@Override
	public void addAdherent(Adherent newAdherent) { // Adherent newAdherent = null;
		
		PreparedStatement prestatement = null;
		
		try {
			
			connection = DAOContext.get_Connection();
			prestatement = this.connection.prepareStatement("insert into biblioteque.Adherent(id_adherent, nom, prenom,mail,adresse, dateOfB) values (?, ?, ?, ?, ?, ?);");
					
			prestatement.setInt(1,newAdherent.getId());
			prestatement.setString(2,newAdherent.getNom());
			prestatement.setString(3,newAdherent.getPrenom());
			prestatement.setString(4,newAdherent.getMail());
			prestatement.setString(5,newAdherent.getAdressePost());
			prestatement.setString(6,newAdherent.getDateOfB());
			    
			prestatement.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Second method");
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteAdherent(Adherent newAdherent) {
		PreparedStatement prestatement = null;
		
		try {
			
			connection = DAOContext.get_Connection();
			prestatement = this.connection.prepareStatement("delete from biblioteque.Adherent where id_adherent=?");
					
			prestatement.setInt(1,newAdherent.getId());
		   
			prestatement.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Third method");
			e.printStackTrace();
		}		
	}

	@Override
	public void updateAdherent(Adherent adherent) {
PreparedStatement prestatement = null;
		
		try {
			
			connection = DAOContext.get_Connection();
			prestatement = this.connection.prepareStatement("update biblioteque.Adherent set nom=?, prenom=?, mail=?, adresse = ?, dateOfB=? where id_adherent=?");
			
					
			prestatement.setString(1,adherent.getNom());
			prestatement.setString(2,adherent.getPrenom());
			prestatement.setString(3,adherent.getMail());
			prestatement.setString(4,adherent.getAdressePost());
			prestatement.setString(5,adherent.getDateOfB());
			prestatement.setInt(6,adherent.getId());
			    
			prestatement.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Forth method");
			e.printStackTrace();
		}	
		
	}
}
