package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import MyException.ContainException;

public class SachDAL {
	
	private static SachDAL instance;
	private ArrayList<SachDTO> dsSach;
	private SachDAL() {
		dsSach=new ArrayList<SachDTO>();
		loadResources();
	}
	
	public static SachDAL getInstance() {
		if(instance==null)
			instance = new SachDAL();
		return instance;
	}
	
	private void loadResources() {
		try {
			String query = new String("select * from sach");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			while(resultSet.next()) {
				dsSach.add(new SachDTO(
						resultSet.getObject(1).toString(), 
						resultSet.getObject(3).toString(), 
						resultSet.getObject(2).toString(), 
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
	}
	
	private boolean isContain(SachDTO s) {
		for (SachDTO item: dsSach)
			if (item.getMaSach().equals(s.getMaSach()))
				return true;
		return false;
	}
	
	public int addProcessing(SachDTO s) throws ContainException{
		if (isContain(s))
			throw new  ContainException("Sách đã tồn tại, hoặc mã sách đang bị trùng!");
		String query = "insert into sach values(\"" 
			+ s.getMaSach() +"\", \""
			+ s.getTacGia() +"\", \""
			+ s.getTenSach() +"\", \""
			+ s.getTheLoai() +"\", \""
			+ s.getNhaXuatBan() +"\", \""
			+ s.getNgayNhap() +"\", \""
			+ s.getGiaSach() +"\", \""
			+ s.getTrangThai() +"\", \""
			+ s.getNamXuatBan()+"\")";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if (result>0)
			dsSach.add(s);
		return result;
	}
	
	public SachDTO getSach(String maSach) {
		for (SachDTO item:dsSach) {
			if (item.getMaSach().equals(maSach))
				return item;
		}
		return null;
	}
	
	public String getTenSach(String maSach) {
		for (SachDTO s: dsSach) {
			if (maSach.equals(s.getMaSach()))
				return s.getTenSach();
		}
		return "";
	}
	public ArrayList<SachDTO> getResources(){
		return  dsSach;
	}

	public int deleteProcessing(String s) {
		int result = DAL.getInstance().executeQueryUpdate("delete from sach where MaSach=\""+ s +"\"");
		if (result > 0)
			for (int i = 0; i <dsSach.size(); i++) {
				if (dsSach.get(i).getMaSach().equals(s))
					dsSach.remove(i);
			}
		return result;
	}

	public int changeProcessing(SachDTO s) {
		int result;
		String query = "update sach set TenSach=\"" + s.getTenSach() 
		+"\", GiaSach=\""  + s.getGiaSach() 
		+"\", TacGia=\"" + s.getTacGia() 
		+"\",  TheLoai=\"" + s.getTheLoai()
		+"\", NhaXuatBan=\"" + s.getNhaXuatBan() 
		+"\",  NgayNhap=\"" + s.getNgayNhap()
		+ "\", TrangThai=\"" + s.getTrangThai() 
		+ "\", NamXuatBan=\"" + s.getNamXuatBan() 
		+ "\" where MaSach=\"" + s.getMaSach()+"\"";
		System.out.println("Query = "+ query);
		result = DAL.getInstance().executeQueryUpdate(query);
		
		if (result > 0)
			for (int i = 0; i<dsSach.size(); i++) {
				SachDTO e = dsSach.get(i);
				if (e.getMaSach().equals(s.getMaSach()))
				{
					dsSach.set(i, s);
					break;
				}
			}
		return result;
	}
}
