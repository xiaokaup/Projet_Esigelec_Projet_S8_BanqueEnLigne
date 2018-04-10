package fr.OnlineBank.jee;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SendEmail.EmailSend;
import dao.CompteDao;

/**
 * Servlet implementation class creerCompte
 */
@WebServlet("/CreerCompte")
public class CreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CompteDao monDAO= new CompteDao();
	EmailSend monEmail = new EmailSend();
	
//	  SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
//	     sdfrmt.setLenient(false);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerCompte() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int min = 0001, max =9999 ;
		int nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		String code = ""+nombreAleatoire;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email= request.getParameter("email");
		String date_transaction= request.getParameter("date");
		int telephone = 0;
		try {
			telephone = Integer.parseInt(request.getParameter("telephone"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_transaction2 = null;
		java.sql.Date sDate = null;
		try {
			date_transaction2 = (Date) sdf.parse(date_transaction);// convertir date_transaction(string) en (date) qui respecte le format pr�d�finie
			 sDate = convertUtilToSql(date_transaction2);// recupere dans une nouvelle variable "sDate" la valeur convertie qui pourra etre ins�rer dans la base de donn�es
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		monEmail.envoie_mail(email, code);
		
		monDAO.creerCompteBancaire(nom, prenom, telephone, email, adresse, sDate, ville, pays,code);
	}
	
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {// Fonction qui permet de convertir la date en une version ins�rable dans la BDD
		
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;//objet convertie

    }

}
