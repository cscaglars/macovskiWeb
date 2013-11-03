package com.macovski.web.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.macovski.entities.Player;
import com.macovski.managers.implementation.PlayerManager;
import com.macovski.web.service.implementation.PlayerWebService;
import com.macovski.web.services.interfaces.IPlayerWebService;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private IPlayerWebService playerService;// = new PlayerService();
	@EJB
	PlayerManager playerManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("deget");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("depost");
		
		try {	
			System.out.println("depost");
			
			String username = request.getParameter("usernameTxt");
			String password = request.getParameter("passwordTxt");
			String name = request.getParameter("nameTxt");
			String surname = request.getParameter("surnameTxt");
			String city = request.getParameter("cityTxt");
			
			System.out.println("Player = " + name);
			
			playerManager.InitializeEM();
			Player p = new Player(name,surname,city);
			playerManager.Insert(p);
			
			IPlayerWebService playerService = new PlayerWebService(playerManager);
			
//			Player player = new Player(name, surname,city);
//			Login login = new Login(username, password);
//			player.setPlayerLogin(login);
	
			playerService.Insert(name, surname,city);
				
			} catch (Exception e) {
	
				e.printStackTrace();
			}
	
	}

}
