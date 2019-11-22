package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import MyException.ContainException;

public class ThanhLyDAL {

	private static ThanhLyDAL instance;
	private ArrayList<ThanhLyDTO> dsThanhLy;
	
	private ThanhLyDAL() {
		dsThanhLy=new ArrayList<ThanhLyDTO>();
	}
	
	public static ThanhLyDAL getInstance() {
		if(instance==null)
			instance=new ThanhLyDAL();
		return instance;
	}
	
	public boolean isContain(ThanhLyDTO tl) {
		for(ThanhLyDTO e:dsThanhLy)
			if(e.getMaSach().equals(tl.getMaSach()))
				return true;
		return false;
	}
	
	public int addProcessing(ThanhLyDTO tl) throws ContainException{
		if(isContain(tl))
			throw new ContainException("Sách thanh lý đã tồn tại");
		String query ="insert into sachthanhly values(\""+tl.getMaSach()+"\",\""+tl.getTenSach()+"\",\""+tl.getTheLoai()+"\",\""+tl.getTacGia()+"\",\""+tl.getNhaXuatBan()+"\",\""+tl.getLyDo()+"\",\""+tl.getThoiGianLuuKho()+"\",\""+tl.getNgayThanhLy()+"\")";
		int result=DAL.getInstance().executeQueryUpdate(query);
		if(result>0)
			dsThanhLy.add(tl);
		return result;
	}
	
	public int deleteProcessing(String masach) {
		int result =DAL.getInstance().executeQueryUpdate("delete from sachthanhly where MaSach=\""+masach+"\"");
		if(result>0)
			for(int i=0;i<dsThanhLy.size();i++)
			{
				if(dsThanhLy.get(i).getMaSach().equals(masach))
					dsThanhLy.remove(i);
			}
		return result;
	}
	
	public int changeProcessing(ThanhLyDTO tl) {
		int result;
		String query="update sachthanhly set TenSach=\""+tl.getTenSach()+"\", TheLoai=\""+tl.getTheLoai()+"\", TacGia=\""+tl.getTacGia()+"\", NhaXuatBan=\""+tl.getNhaXuatBan()+"\",LyDo=\""+tl.getLyDo()+"\", ThoiGianLuuKho=\""+tl.getThoiGianLuuKho()+"\", NgayThanhLy=\""+tl.getNgayThanhLy()+"\"where MaSach=\""+tl.getMaSach()+"\"";
		System.out.println(query);
		result=DAL.getInstance().executeQueryUpdate(query);
		if(result>0)
			for(int i=0;i<dsThanhLy.size();i++) {
				ThanhLyDTO e=dsThanhLy.get(i);
				if(e.getMaSach().equals(tl.getMaSach()))
				{
					dsThanhLy.set(i, tl);
					break;
				}
			}
		return result;
	}
	
	public ArrayList<ThanhLyDTO> getResources(){
		try {
			String query=new String("selet * from sachthanhly");
			ResultSet resultSet=DAL.getInstance().executeQueryToGetData(query);
			while(resultSet.next()) {
				dsThanhLy.add(new ThanhLyDTO(resultSet.getObject(1).toString(),
						resultSet.getObject(2).toString(),
						resultSet.getObject(3).toString(),
						resultSet.getObject(4).toString(),
						resultSet.getObject(5).toString(),
						resultSet.getObject(6).toString(),
						Date.valueOf(resultSet.getObject(7).toString()),
						Date.valueOf(resultSet.getObject(8).toString())));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return dsThanhLy;
	}
	public ArrayList<ThanhLyDTO> reloadResources(){
		return dsThanhLy;
	}
}
