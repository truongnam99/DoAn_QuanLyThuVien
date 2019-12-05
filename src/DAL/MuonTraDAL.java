package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.*;
import MyException.ContainException;
import MyException.MyException;

public class MuonTraDAL {
	private static MuonTraDAL instance;
	private ArrayList<MuonTraDTO> dsMuonTra;
	
	private MuonTraDAL() {
		dsMuonTra = new ArrayList<MuonTraDTO>();
		loadResources();
	}
	
	public static MuonTraDAL getInstance() {
		if (instance == null)
			instance = new MuonTraDAL();
		return instance;
	}
	
	private void loadResources(){
		try {
			String query = new String("select * from quanlymuonsach");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			while(resultSet.next()) {
				dsMuonTra.add(new MuonTraDTO(
						resultSet.getObject(1).toString(), 
						resultSet.getObject(2).toString(), 
						Date.valueOf(resultSet.getObject(3).toString()), 
						Date.valueOf(resultSet.getObject(4).toString()),
						resultSet.getObject(5).toString()));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int soSachDangMuon(String maDocGia) {
		int count = 0;
		for (MuonTraDTO item: dsMuonTra) {
			if (item.getMaDocGia().equals(maDocGia) && Integer.parseInt(item.getTrangThai())>= 0)
				count++;
		}
		return count;
	}
	
	public ArrayList<MuonTraDTO> getResources() {
		return dsMuonTra;
	}

	public int addProcessing(MuonTraDTO mt) throws ContainException{
		try {
			String query = "insert into quanlymuonsach values(\"" + mt.getMaDocGia() + "\", \"" + mt.getMaSach() + "\", \"" + mt.getNgayMuon() + "\", \"" + mt.getNgayTra()+"\", \"0\")";
			int result = DAL.getInstance().executeQueryUpdate(query);
			
			if(result > 0) {
				SachDAL.getInstance().changeTrangThai(mt.getMaSach(), "Đang được mượn");
				dsMuonTra.add(new MuonTraDTO(mt.getMaDocGia(), mt.getMaSach(), mt.getNgayMuon(), mt.getNgayTra(), 0+""));
			}
			return result;
		}catch(MyException e) {
			return 0;
		}
	}

	public int changeProcessing(MuonTraDTO mt) {
		int result;
		String query = "update quanlymuonsach set NgayMuon=\""+mt.getNgayMuon()+"\", NgayTra=\""+mt.getNgayTra()+"\" where MaSach=\""+mt.getMaSach()+"\" and MaDocGia=\""+mt.getMaDocGia()+"\"";
		System.out.println("update quanlymuonsach set NgayMuon=\""+mt.getNgayMuon()+"\", NgayTra=\""+mt.getNgayTra()+"\" where MaSach=\""+mt.getMaSach()+"\" and MaDocGia=\""+mt.getMaDocGia()+"\"");
		result = DAL.getInstance().executeQueryUpdate(query);
		if (result > 0)
			try {
				SachDAL.getInstance().changeTrangThai(mt.getMaSach(), "Trống");
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (MuonTraDTO item:dsMuonTra) {
				if (item.getMaDocGia().equals(mt.getMaDocGia()) && item.getMaSach().equals(mt.getMaSach()))
					{
						item.setNgayMuon(mt.getNgayMuon());
						item.setNgayTra(mt.getNgayTra());
						break;
					}
			}
		return result;
	}

	public int traSach(String maDocGia, String maSach) throws MyException {
		int result;
		String query = "update quanlymuonsach set TrangThai = -1 where MaSach=\""+maSach+"\" and MaDocGia=\"" +maDocGia+"\"";
		result = DAL.getInstance().executeQueryUpdate(query);
		if (result >0) {
			for (MuonTraDTO item:dsMuonTra) {
				if(item.getMaDocGia().equals(maDocGia)&& item.getMaSach().equals(maSach))
					item.setTrangThai("-1");
			}
			SachDAL.getInstance().changeTrangThai(maSach, "Trống");
		}
		return result;
		
	}

	public ArrayList<MuonTraDTO> reloadResources() {
		// TODO Auto-generated method stub
		return dsMuonTra;
	}
}
