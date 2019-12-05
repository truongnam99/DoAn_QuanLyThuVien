package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import DTO.*;

public class ThanhLyDAL {

	private static ThanhLyDAL instance;
	
	private ThanhLyDAL() {
	}
	
	public static ThanhLyDAL getInstance() {
		if(instance==null)
			instance=new ThanhLyDAL();
		return instance;
	}

	public void addSach(ArrayList<SachDTO> dsSachThanhLy, String lyDo) {
		ResultSet resultSet = DAL.getInstance().executeQueryToGetData("select * from thanhly");
		int maThanhLy=0;
		if (resultSet != null) {
			try {
				while(resultSet.next()) {
					if (resultSet.isLast()){
						String temp = (String) resultSet.getObject(1);
						maThanhLy = Integer.parseInt(temp);
						maThanhLy++;
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DAL.getInstance().executeQueryUpdate("insert into thanhly values(\""+maThanhLy+"\", \""+ sdf.format(date) +"\", \""+ lyDo+"\")");
		for(SachDTO sach: dsSachThanhLy) {
			String query = "insert into sachthanhly values(\""+ sach.getMaSach()
			+"\", \"" + maThanhLy
			+ "\", \"" + sach.getTacGia()
			+ "\", \"" + sach.getTenSach()
			+ "\", \"" + sach.getTheLoai()
			+ "\", \"" + sach.getNhaXuatBan()
			+ "\", \"" + sach.getNgayNhap()
			+ "\", " + sach.getGiaSach()	
			+ ", \"" + sach.getTrangThai()
			+ "\", \"" + sach.getNamXuatBan() + "\")";
			DAL.getInstance().executeQueryUpdate(query);
			int result = SachDAL.getInstance().deleteProcessing(sach.getMaSach());
			System.out.println(result+"");
		}
	}
	
}
