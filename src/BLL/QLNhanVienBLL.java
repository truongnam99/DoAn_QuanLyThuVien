package BLL;

import java.util.ArrayList;

import MyException.ContainException;
import MyException.MyNullException;

import javax.swing.table.DefaultTableModel;

import DAL.NhanVienDAL;
import DTO.*;

public class QLNhanVienBLL {
	
	public static QLNhanVienBLL instance;
	private QLNhanVienBLL(){
		
	}
	
	private boolean checkData(NhanVienDTO nv) throws MyNullException {
		if (nv.getMaTaiKhoan().equals(""))
		{
			throw new MyNullException("Mã tài khoản không được bỏ trống");
		}
		if (nv.getTenTaiKhoan().equals(""))
		{
			throw new MyNullException("Tên tài khoản không được bỏ trống");
		}
		if (nv.getTenNhanVien().equals(""))
		{
			throw new MyNullException("Tên nhân viên không được bỏ trống");
		}
		if (nv.getMatKhau().equals(""))
		{
			throw new MyNullException("Mật khẩu không được bỏ trống");
		}
		if (nv.getLoaiTaiKhoan().equals(""))
		{
			throw new MyNullException("Loại tài khoản không được bỏ trống");
		}
		return true;
	}
	
	public static QLNhanVienBLL getInstance() {
		if (instance == null)
			instance = new QLNhanVienBLL();
		return instance;
	}
	
	public String addProcessing(NhanVienDTO nv) {
		try{
			checkData(nv);
		
			String msg;
			int result = NhanVienDAL.getInstance().addProcessing(nv);
			switch(result)
			{
			case -1:
				//msg = "Error";
			case 0:
				msg = "Thêm không thành công! Vui lòng thử lại";
				break;
				default:
					msg = "Đã thêm";
			}
			return msg;
		}
		catch(MyNullException ex1) {
			System.out.println(ex1);
			return ex1.getMessage();
		}
		catch(ContainException ex2) {
			return ex2.getMessage();
		}
	}
	
	public DefaultTableModel reloadResources() {
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		dsNhanVien = NhanVienDAL.getInstance().reloadResource();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã tài khoản");
			dtm.addColumn("Tên tài khoản");
			dtm.addColumn("Mật khẩu");
			dtm.addColumn("Tên nhân viên");
			dtm.addColumn("Loại tài khoản");
			dtm.addColumn("Email");
			int i = 1;
			for(NhanVienDTO nv : dsNhanVien) {
				Object[] row = {i++,nv.getMaTaiKhoan(),nv.getTenTaiKhoan(),nv.getMatKhau(),nv.getTenNhanVien(),nv.getLoaiTaiKhoan(),nv.getEmail() };
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
	
	public DefaultTableModel getResources() {
		ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
		dsNhanVien = NhanVienDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã nhân viên");
			dtm.addColumn("Tên tài khoản");
			dtm.addColumn("Mật khẩu");
			dtm.addColumn("Tên nhân viên");
			dtm.addColumn("Loại "
					+ "tài khoản");
			dtm.addColumn("Email");
			int i = 1;
			for(NhanVienDTO nv : dsNhanVien) {
				Object[] row = {i++,nv.getMaTaiKhoan(),nv.getTenTaiKhoan(),nv.getMatKhau(),nv.getTenNhanVien(),nv.getLoaiTaiKhoan(),nv.getEmail() };
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
	
	public String changeProcessing(NhanVienDTO nv) {
		String msg;
		try {
			checkData(nv);
			
			int result = NhanVienDAL.getInstance().changeProcessing(nv);
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
	
	public String deleteProcessing(String matk) {
		
		if (matk.equals(""))
			return "Không có tài khoản nào được chọn để xóa";
		
		int result = NhanVienDAL.getInstance().deleteProcessing(matk);
		if (result > 0)
			return "Xóa thành công";
		else
			return "Xóa không thành công! Vui lòng kiểm tra lại";
	}
}
