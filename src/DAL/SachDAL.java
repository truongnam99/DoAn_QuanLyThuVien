package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;

public class SachDAL {
	
	private static SachDAL instance;
	private ArrayList<SachDTO> dsSach;
	private SachDAL() {
		dsSach=new ArrayList<SachDTO>();
	}
	
	public static SachDAL getInstance() {
		if(instance==null)
			instance = new SachDAL();
		return instance;
	}
	public ArrayList<SachDTO> getResources(){
		try {
			String query = new String("select * from sach");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			while(resultSet.next()) {
				dsSach.add(new SachDTO(
						resultSet.getObject(1).toString(), 
						resultSet.getObject(2).toString(), 
						resultSet.getObject(3).toString(), 
						resultSet.getObject(4).toString(),
						resultSet.getObject(5).toString(),
						Date.valueOf(resultSet.getObject(6).toString()),
						resultSet.getObject(7).toString(),
						resultSet.getObject(8).toString(),
						Date.valueOf(resultSet.getObject(9).toString())));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return  dsSach;
	}
}
