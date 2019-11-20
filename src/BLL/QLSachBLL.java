package BLL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import DAL.SachDAL;
import DTO.*;
public class QLSachBLL {
public static QLSachBLL instance;
	
	private QLSachBLL(){
		
	}
	
	public static QLSachBLL getInstance() {
		if (instance == null)
			instance = new QLSachBLL();
		return instance;
	}
	
	
	
	public DefaultTableModel getResources() {
		ArrayList<SachDTO> dsSach = new ArrayList<SachDTO>();
		dsSach = SachDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã sách");
			dtm.addColumn("Mã tác giả");
			dtm.addColumn("Mã thể loại");
			dtm.addColumn("Tên sách");
			dtm.addColumn("Nhà xuất bản");
			dtm.addColumn("Ngày nhập");
			dtm.addColumn("Giá sách");
			dtm.addColumn("Trạng thái");
			dtm.addColumn("Năm xuất bản");
			
			int i = 1;
			for(SachDTO sach : dsSach) {
				Object[] row = {i++, sach.getMaSach(),sach.getTenSach(),sach.getMaTheLoai(),sach.getMaTacGia(),sach.getNhaXuatBan(),sach.getNgayNhap(),sach.getGiaSach(),sach.getTrangThai(),sach.getNamXuatBan()};
				dtm.addRow(row);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
		}
		return dtm;
	}
}
