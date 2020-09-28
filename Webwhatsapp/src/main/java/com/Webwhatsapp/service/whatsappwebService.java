package com.Webwhatsapp.service;
import java.util.List;

import com.Webwhatsapp.ENTITY.whatsappuser;
import com.Webwhatsapp.dao.whatsappwebDAOInterface;

import Webwhatsapp.Utility.Daofactory;
public class whatsappwebService implements WhatsappwebServiceInterface {

		private whatsappwebDAOInterface fd;
		
		public whatsappwebService() {
			fd=Daofactory.createObject("admindaoservice");
		}

		@Override
		public int createProfile(whatsappuser fe) {
			// TODO Auto-generated method stub
			return fd.createProfile(fe);
		}

		@Override
		public boolean loginProfile(whatsappuser fe) {
			// TODO Auto-generated method stub
			return fd.loginProfile(fe);
		}

		@Override
		public List<whatsappuser> friendProfile(whatsappuser fe) {
			// TODO Auto-generated method stub
			return fd.friendlistdao(fe);
		}



}
