package BLL;

import java.util.ArrayList;
import DAL.HeThongDAL;
import DTO.HeThongDTO;


public class QLHeThongBLL {

	public static QLHeThongBLL instance;

	private QLHeThongBLL() {

	}

	public static QLHeThongBLL getInstance() {
		if (instance == null)
			instance = new QLHeThongBLL();
		return instance;
	}
	

	public ArrayList<HeThongDTO> getResources() { 
		ArrayList<HeThongDTO> dsHeThong = new ArrayList<HeThongDTO>();
		try {
			  dsHeThong = HeThongDAL.getInstance().getResources(); 
			  
		 } catch(Exception ex) { ex.printStackTrace(); } 
		finally {
			
		}
		return dsHeThong;
	}

	public void luu() {
		// TODO Auto-generated method stub
		
	} 
}
