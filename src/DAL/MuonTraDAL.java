package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.*;

public class MuonTraDAL {
	private static MuonTraDAL instance;
	private ArrayList<MuonTraDTO> dsMuonTra;
	private MuonTraDAL() {
		dsMuonTra = new ArrayList<MuonTraDTO>();
		loadResources();
	}
	
	private void loadResources() {
		try {
			DocGiaDAL.getInstance();
			SachDAL.getInstance();
			String query = new String("select * from quanlymuonsach");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
		
			
			while(resultSet.next()) {
				DocGiaDTO dg = DocGiaDAL.getInstance().getDocGia(resultSet.getObject(1).toString());
				
				dsMuonTra.add(new MuonTraDTO(dg,
				SachDAL.getInstance().getSach(resultSet.getObject(2).toString()),
				Date.valueOf(resultSet.getObject(3).toString()),
				Date.valueOf(resultSet.getObject(4).toString()),
			    resultSet.getObject(5).toString()));
			}
		}		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static MuonTraDAL getInstance() {
		if (instance == null)
			instance = new MuonTraDAL();
		return instance;
	}
	
	public ArrayList<MuonTraDTO> getResources(){
		return  dsMuonTra;
	}
}
