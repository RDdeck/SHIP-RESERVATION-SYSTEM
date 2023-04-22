package com.sp.pract.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.pract.app.bean.CredentialsBean;
import com.sp.pract.app.bean.ShipBean;
import com.sp.pract.app.dao.ShipDao;

@Service
public class ShipService {
	@Autowired 
	private ShipDao  sdao;
	public boolean authenticate(CredentialsBean user) {
		try {
			return sdao.authenticate(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public String addShip(ShipBean shipBean) {
		return sdao.addShip(shipBean);
	}
	public String updateShip(ShipBean shipBean) {
		return sdao.updateShip(shipBean);
	}

	public ShipBean viewShipByshipId(int shipID ) {
		return sdao.viewShipByshipId(shipID);
	};
	
	public String deleteship(int shipID) {
		return sdao.deleteship(shipID);
	}
	
	public ArrayList<ShipBean> viewShips(){
		return sdao.viewShips();
	}
	

}

