package DAL;

import java.sql.ResultSet;
import java.util.ArrayList;


import DTO.*;

public class HeThongDAL {

	private static HeThongDAL instance;
	private ArrayList<HeThongDTO> dsHeThong;
	private HeThongDAL() {
		dsHeThong = new ArrayList<HeThongDTO>();
	}
	
	public static HeThongDAL getInstance() {
		if (instance == null)
			instance = new HeThongDAL();
		return instance;
	}
	
	public ArrayList<HeThongDTO> getResources(){
		try {
			String query = new String("select *from quydinh");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
		
			while(resultSet.next()) {
			dsHeThong.add(new HeThongDTO(
					resultSet.getObject(1).toString(),
					resultSet.getObject(2).toString(),
					resultSet.getObject(3).toString(),
					resultSet.getObject(4).toString()
					));
			}
		}		catch(Exception ex){
				ex.printStackTrace();
				}
		return dsHeThong;
	}
	public void changeProcessing(HeThongDTO ht) {
		//String query ="update quydinh set GiaTri=\""+ht.getGiaTri()+"\"where ";
	}
}
