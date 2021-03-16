package co.simplon.biblioController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.simplon.biblioDao.BiblioDAO;
import co.simplon.biblioDao.BiblioDaoImpl;
import co.simplon.biblioDao.DAOContext;
import co.simplon.biblioModel.Adherent;



@WebServlet("/ServletAdherent")
public class ServletAdherent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private BiblioDAO donnebrut;

    public ServletAdherent() {
        super();
    }
 
	@Override
	public void init() throws ServletException {
		DAOContext toto = new DAOContext();
		this.donnebrut = toto.getAdherent();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		for(Adherent p:donnebrut.lister()) {
			System.out.println(p.toString()); //c'afiche doneés dans le console
		}
		request.setAttribute("listAdherent", donnebrut.lister()); // ce va etre parcuru dans le .jsp apres et ça vient de DaoIpmlet
		
		//for(Adherent a:donnebrut.lister()) {
			//System.out.println(a.toString());
		//}
			
		RequestDispatcher rs = request.getRequestDispatcher("adherent.jsp");
        rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action"); //
		
		//int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
		String formName = request.getParameter("nom");
		String formSurname = request.getParameter("prenom");
		String formMail = request.getParameter("mail");
		String formAdressePost = request.getParameter("adressePost");
		String formDateOfB = request.getParameter("dateOfB");
			
		if (action.equals("delete")) {
			
			Adherent adherent = new Adherent(); // taken from JSP
			adherent.setId(Integer.parseInt(request.getParameter("idAdherent")));
			donnebrut.deleteAdherent(adherent);
		}else if (action.equals("create")) {
			
			Adherent createdAdherent = new Adherent();
				
			createdAdherent.setNom(formName);
			createdAdherent.setPrenom(formSurname);
			createdAdherent.setMail(formMail);
			createdAdherent.setAdressePost(formAdressePost);
			createdAdherent.setDateOfB(formDateOfB);
			donnebrut.addAdherent(createdAdherent);
				
		}else if(action.equals("modify") || action.equals("save")){
			int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
			Adherent adherent = new Adherent (idAdherent,formName, formSurname, formMail, formAdressePost, formDateOfB);
			request.setAttribute("nata", adherent);	
		
			System.out.println("je suis dans la boucle save ");
			
			Adherent updatedAdherent = new Adherent();
			updatedAdherent.setId(idAdherent);
			updatedAdherent.setNom(formName);
			updatedAdherent.setPrenom(formSurname);
			updatedAdherent.setMail(formMail);
			updatedAdherent.setAdressePost(formAdressePost);
			updatedAdherent.setDateOfB(formDateOfB);
			donnebrut.updateAdherent(updatedAdherent);		
			System.out.println("An existing user was updated successfully!");
		
		}else {
			System.out.println("nothing is going on ...");
		}
			System.out.println("mon action est:"+action);
			request.setAttribute("listAdherent", donnebrut.lister());
			RequestDispatcher rs = request.getRequestDispatcher("adherent.jsp");
			rs.forward(request, response);
	}
}
