package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;

public class PhatTienDAL {
	
	private static PhatTienDAL instance;
	private ArrayList<PhatTienDTO> dsPhatTien;
	private PhatTienDAL() {
		dsPhatTien=new ArrayList<PhatTienDTO>();
	}
	
	public static PhatTienDAL getInstance() {
		if(instance==null)
			instance=new PhatTienDAL();
		return instance;
	}
	
	public ArrayList<PhatTienDTO> getResources(){
		try {
			String query=new String("select * from quanlytienphat");
			ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
			while(resultSet.next()) {
				dsPhatTien.add(new PhatTienDTO(
						resultSet.getObject(1).toString(),
						resultSet.getObject(2).toString(),
						resultSet.getObject(3).toString(),
						Date.valueOf(resultSet.getObject(4).toString()),
						resultSet.getObject(5).toString()));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return dsPhatTien;
	}
}
