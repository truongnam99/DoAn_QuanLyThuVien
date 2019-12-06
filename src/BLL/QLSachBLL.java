package BLL;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.SachDAL;
import DTO.*;
import MyException.ContainException;
import MyException.MyException;
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
	private boolean checkData(SachDTO s) throws MyNullException, MyException{
		if (s.getMaSach().equals(""))
			throw new MyNullException("Mã sách đang bị trống");
		if(s.getTenSach().toString().equals(""))
			throw new MyNullException("Tên sách đang bị trống");
		if(s.getGiaSach().equals(""))
			throw new MyNullException("Giá sách đang bị bỏ trống");
		if(s.getNgayNhap().compareTo(s.getNamXuatBan()) < 0)
			throw new MyException("Ngày nhập phải lớn hơn năm xuất bản");
		try {
			if(Integer.parseInt(s.getGiaSach()) < 0)
				throw new MyException("Giá sách phải lớn hơn 0");
		}
		catch(Exception e){
			throw new MyException("Giá sách phải là số");
		}
		
		return true;
	}
	
	public boolean isTrong(String maSach) throws MyException{
		return SachDAL.getInstance().isTrong(maSach);
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
		catch(MyException e3) {
			return e3.getMessage();
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
		catch (Exception e) {
			return e.getMessage();
		}
	}

	public int SoCuonSach() {
		// TODO Auto-generated method stub
		return SachDAL.getInstance().getResources().size();
	}

	public int SoTheLoai() {
		ArrayList<SachDTO> dsSach = SachDAL.getInstance().getResources();
		ArrayList<String> theLoai = new ArrayList<String>();
		for(SachDTO s: dsSach) {
			if (!theLoai.contains(s.getTheLoai()))
				theLoai.add(s.getTheLoai());
		}
		return theLoai.size();
	}
	
	public TableModel timKiem(String key) {
		DefaultTableModel dtm=new DefaultTableModel();
		ArrayList<SachDTO> dsSach = new ArrayList<SachDTO>();
		dsSach = SachDAL.getInstance().getResources();
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
			int i=0;
			System.out.println(key);
			for(SachDTO sach:dsSach) {
				String thongTin=SachDAL.getInstance().getThongTin(sach.getMaSach());
				thongTin=thongTin.toLowerCase();
				key=key.toLowerCase();
				if(thongTin.contains(key)) {
					Object[] row= {i++,sach.getMaSach(),
							sach.getTenSach(),
							sach.getTheLoai(),
							sach.getTacGia(),
							sach.getNhaXuatBan(),
							sach.getNgayNhap(),
							sach.getGiaSach(),
							sach.getTrangThai(),
							sach.getNamXuatBan()};
					dtm.addRow(row);
					}
				}
			return dtm;
			}
	}
	

