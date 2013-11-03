package com.macovski.web.service.implementation;

import com.macovski.entities.Player;
import com.macovski.managers.implementation.PlayerManager;
import com.macovski.web.services.interfaces.IPlayerWebService;


public class PlayerWebService implements IPlayerWebService {
	
	PlayerManager playerManager;
	
	public PlayerWebService(PlayerManager pm) {
		playerManager = pm;
		playerManager.InitializeEM();
	}

	public void Insert(String name, String surname, String city)
	{
		Player player = new Player(name, surname, city);
		playerManager.Insert(player);
	}
	
	

}
