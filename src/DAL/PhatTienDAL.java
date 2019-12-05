package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.*;
import MyException.ContainException;

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
	public boolean isContain(PhatTienDTO pt) {
		for(PhatTienDTO p:dsPhatTien)
			if(p.getMaLanPhat().equals(pt.getMaLanPhat()))
				return true;
		return false;
	}
	
	public int addProcessing(PhatTienDTO pt) throws ContainException{
		if(isContain(pt))
			throw new ContainException("Mã lần phạt đã tồn tại");
		String query="insert into quanlytienphat values(\"" +pt.getMaLanPhat()+"\",\""+pt.getSoTien()+"\",\""+pt.getMaDocGia()+"\",\""+pt.getNgayPhat()+"\",\""+pt.getLyDo()+"\")";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if(result>0)
			dsPhatTien.add(pt);
		return result;
	}
	
	public int deleteProcessing(String malp) {
		int result = DAL.getInstance().executeQueryUpdate("delete from quanlytienphat where MaLanPhat=\""+malp+"\"");
		if(result>0)
			for(int i=0;i<dsPhatTien.size();i++)
			{
				if(dsPhatTien.get(i).getMaLanPhat().equals(malp))
					dsPhatTien.remove(i);
			}
		return result;
	}
	
	public int changeProcessing(PhatTienDTO pt) {
		int result;
		String query="update quanlytienphat set SoTien=\""+pt.getSoTien()+"\", MaDocGia=\""+pt.getMaDocGia()+"\", NgayPhat=\""+pt.getNgayPhat()+"\", LyDo=\""+pt.getLyDo()+"\" where MaLanPhat=\"" +pt.getMaLanPhat()+"\"";
		System.out.println(query);
		result=DAL.getInstance().executeQueryUpdate(query);
		if(result>0)
			for(int i=0;i<dsPhatTien.size();i++) {
				PhatTienDTO p=dsPhatTien.get(i);
				if(p.getMaLanPhat().equals(pt.getMaLanPhat()))
				{
					dsPhatTien.set(i, pt);
					break;
				}
			}
		return result;
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
	
	public ArrayList<PhatTienDTO> reloadResources(){
		return dsPhatTien;
	}
}
