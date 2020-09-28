package com.Webwhatsapp.service;
import java.util.List;

import com.Webwhatsapp.ENTITY.whatsappuser;
public interface WhatsappwebServiceInterface {





		int createProfile(whatsappuser fe);

		boolean loginProfile(whatsappuser fe);

		List<whatsappuser> friendProfile(whatsappuser fe);

	
}
