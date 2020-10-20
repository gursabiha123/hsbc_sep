package com.study.DAO;

import java.util.List;


import com.study.entity.Instausers;

public interface StudydaoInterface {

	List<Instausers> viewAllprofiledao();

	Instausers createProfileDAO(Instausers iu);
	
	void  deleteProfileDAO(String email);
	
	Instausers updateProfileDAO(Instausers todo);
}
