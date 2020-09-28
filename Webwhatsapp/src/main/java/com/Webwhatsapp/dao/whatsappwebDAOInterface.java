package com.Webwhatsapp.dao;

import java.util.List;

import com.Webwhatsapp.ENTITY.whatsappuser;

public interface whatsappwebDAOInterface {

	

//public interface FacebookDAOInterface {

	int createProfile(whatsappuser fe);

	boolean loginProfile(whatsappuser fe);

	List<whatsappuser> friendlistdao(whatsappuser fe);
	
}
