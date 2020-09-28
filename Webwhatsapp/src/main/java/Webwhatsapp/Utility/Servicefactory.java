package Webwhatsapp.Utility;

import com.Webwhatsapp.service.WhatsappwebServiceInterface;
import com.Webwhatsapp.service.whatsappwebService;

//import com.facebookweb.service.facebookServiceInterface;

public class Servicefactory {

		private Servicefactory() {
			
		}
		
		public static WhatsappwebServiceInterface createObject(String nn) {
			WhatsappwebServiceInterface is=null;
			if(nn.equals("adminservice")) {
				is=new whatsappwebService();
			}
			return is;//return object
		}
	
	
}
