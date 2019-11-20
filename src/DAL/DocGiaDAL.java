package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;

public class DocGiaDAL {

	private static DocGiaDAL instance;
	private ArrayList<DocGiaDTO> dsDocGia;
	private DocGiaDAL() {
		dsDocGia = new ArrayList<DocGiaDTO>();
	}
	
	public static DocGiaDAL getInstance() {
		if (instance == null)
			instance = new DocGiaDAL();
		return instance;
	}
	
	public int insert(DocGiaDTO docGia) {
		
		try {
			
			String query = "insert into docgia values(\"" + docGia.getMaDocGia() + "\", \"" + docGia.getTenDocGia() + "\", \"" 
					+ docGia.getLoaiDocGia() + "\", \"" + docGia.getLopMon() + "\", \"" + docGia.getNgaySinh().toString() + "\", \"" + docGia.getSdt() + "\", \"null\")";
			return DAL.getInstance().executeQueryUpdate(query);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("");
			return -1;
		}
	}
	
	public ArrayList<DocGiaDTO> getResources(){
		try {
			String query = new String("select * from docgia");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			while(resultSet.next()) {
				dsDocGia.add(new DocGiaDTO(resultSet.getObject(1).toString(), 
						resultSet.getObject(2).toString(), 
						resultSet.getObject(3).toString(), 
						resultSet.getObject(4).toString(),
						Date.valueOf(resultSet.getObject(5).toString()),
						resultSet.getObject(6).toString()));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return  dsDocGia;
	}
}
