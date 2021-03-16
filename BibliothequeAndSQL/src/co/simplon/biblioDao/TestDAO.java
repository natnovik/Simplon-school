package co.simplon.biblioDao;

import co.simplon.biblioModel.Adherent;

public class TestDAO {

	public static void main(String[] args) {
		
		DAOContext toto = new DAOContext();
		BiblioDAO donnebrut = toto.getAdherent();
		
		System.out.println(donnebrut.lister());		
		Adherent lolo = new Adherent(6, "a","b","c","d","o");
		
		donnebrut.addAdherent(lolo);
		System.out.println(donnebrut.lister());
		
		lolo.setId(6);
		lolo.setNom("test via DAO");
		lolo.setPrenom("pp");
		lolo.setAdressePost("i");
		lolo.setMail("jj");
		lolo.setDateOfB("hhh");
		donnebrut.updateAdherent(lolo);
		System.out.println(donnebrut.lister());
		
				
		donnebrut.deleteAdherent(lolo);	
		System.out.println(donnebrut.lister());
	}
}
