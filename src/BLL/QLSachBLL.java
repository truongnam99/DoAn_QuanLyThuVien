package BLL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAL.DocGiaDAL;
import DAL.SachDAL;
import DTO.*;
import MyException.ContainException;
import MyException.MyNullException;
public class QLSachBLL {
public static QLSachBLL instance;
	
	private QLSachBLL(){
		
	}
	
	public static QLSachBLL getInstance() {
		if (instance == null)
			instance = new QLSachBLL();
		return instance;
	}
	private boolean checkData(SachDTO s) throws MyNullException{
		if (s.getMaSach().equals(""))
			throw new MyNullException("Mã đọc giả đang bị trống");
		if(s.getTenSach().toString().equals(""))
			throw new MyNullException("Loại đọc giả đang bị trống");
		if(s.getGiaSach().equals(""))
			throw new MyNullException("Lớp/Môn đang bị bỏ trống");
		
		return true;
	}
	
	public String addProcessing(SachDTO s) {
		try {
			checkData(s);
			String msg;
			int result = SachDAL.getInstance().addProcessing(s);
			if (result > 0)
				msg = "Đã thêm thành công";
			else
				msg = "Thêm lỗi! Vui lòng thử lại";
			return msg;
		}
		catch(MyNullException e1) {
			return e1.getMessage();
		}
		catch(ContainException e2) {
			return e2.getMessage();
		}
		
	}
	
	public DefaultTableModel getResources() {
		ArrayList<SachDTO> dsSach = new ArrayList<SachDTO>();
		dsSach = SachDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã sách");
			dtm.addColumn("Tên sách");
			dtm.addColumn("Thể loại");
			dtm.addColumn("Tác giả");
			dtm.addColumn("Nhà xuất bản");
			dtm.addColumn("Ngày nhập");
			dtm.addColumn("Giá sách");
			dtm.addColumn("Trạng thái");
			dtm.addColumn("Năm xuất bản");
			
			int i = 1;
			for(SachDTO sach : dsSach) {
				Object[] row = {i++, sach.getMaSach(),sach.getTenSach(),sach.getTheLoai(),sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getNgayNhap(), sach.getGiaSach(),sach.getTrangThai(),sach.getNamXuatBan()};
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

	public String deleteProcessing(String s) {
		if(s.equals("")) 
			return "Không có tài khoản nào được chọn";
		
		int result = SachDAL.getInstance().deleteProcessing(s);
		if (result > 0)
			return "Xóa thành công";
		else
			return "Xóa không thành công! Vui lòng thử lại";
	}

	public String changeProcessing(SachDTO s) {
		try {
			String msg;
			checkData(s);
			
			int result = SachDAL.getInstance().changeProcessing(s);
			switch(result)
			{
			case -1:
				//msg = "Error";
			case 0:
				msg = "Sửa không thành công! Vui lòng thử lại";
				break;
				default:
					msg = "Đã chỉnh sửa";
			}
			return msg;
		}
		catch(MyNullException e) {
			return e.toString();
		}
	}
}
