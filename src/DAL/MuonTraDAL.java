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
	}
	
	public static MuonTraDAL getInstance() {
		if (instance == null)
			instance = new MuonTraDAL();
		return instance;
	}
	
	public int insert(MuonTraDTO muonTra) {
		
		try {
			String query = "insert into quanlymuonsach values(\""  + muonTra.getMaDocGia() + "\",  \"" + muonTra.getMaSach() + "\", \"" + muonTra.getNgayMuon().toString() + "\", \"" + muonTra.getNgayTra().toString() + "\", \"" + muonTra.getTrangThai() + "\", \"null\")";
			return DAL.getInstance().executeQueryUpdate(query);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	public int update(MuonTraDTO muonTra) {
		try {
			String query = "update quanlymuonsach set 'maDocGia'='"+muonTra.getMaDocGia()+"' ,  'maSach'='"+muonTra.getMaSach()+"' , 'ngayMuon'='"+muonTra.getNgayMuon()+"' , 'ngayTra'='"+muonTra.getNgayTra()+"','TrangThai'='"+muonTra.getTrangThai()+"' where 'maDocGia'='"+muonTra.getMaDocGia()+"' ";
			return DAL.getInstance().executeQueryUpdate(query);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	public int delete(MuonTraDTO muonTra) {
		try {
			String query = "delete from muontra  where 'maDocGia'='"+muonTra.getMaDocGia()+"' ";
			return DAL.getInstance().executeQueryUpdate(query);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public ArrayList<MuonTraDTO> getResources(){
		try {
			String query = new String("select * from quanlymuonsach");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
		
			while(resultSet.next()) {
			dsMuonTra.add(new MuonTraDTO(resultSet.getObject(1).toString(),
					resultSet.getObject(2).toString(),
					Date.valueOf(resultSet.getObject(3).toString()),
					Date.valueOf(resultSet.getObject(4).toString()),
				    resultSet.getObject(5).toString()));
					}
		}		catch(Exception ex){
			ex.printStackTrace();
		}
	return  dsMuonTra;
	}
}
