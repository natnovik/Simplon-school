package co.simplon.biblioDao;

import java.util.List;

import co.simplon.biblioModel.*;

public interface BiblioDAO {
	
	public List<Adherent> lister();
	public void addAdherent(Adherent adherent);
	public void deleteAdherent(Adherent adherent);
	public void updateAdherent(Adherent adherent);
}