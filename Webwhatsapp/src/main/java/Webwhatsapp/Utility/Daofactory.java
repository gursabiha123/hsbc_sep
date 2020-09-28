package Webwhatsapp.Utility;

//import com.Webwhatsapp.dao.whatsappDAOInterface;
import com.Webwhatsapp.dao.whatsappwebDAO;
import com.Webwhatsapp.dao.whatsappwebDAOInterface;




public class Daofactory {
	private Daofactory()
	{
		
	}
	
	public static whatsappwebDAOInterface createObject(String nn) {
		whatsappwebDAOInterface is=null;
		if(nn.equals("admindaoservice")) {
			is=new whatsappwebDAO();
		}
		return is;//return object
	}
}
