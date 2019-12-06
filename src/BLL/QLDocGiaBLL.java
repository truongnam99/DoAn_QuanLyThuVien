package BLL;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.DocGiaDAL;
import DTO.*;
import MyException.ContainException;
import MyException.MyNullException;

public class QLDocGiaBLL {
	public static QLDocGiaBLL instance;
	
	private QLDocGiaBLL(){
		
	}
	
	public static QLDocGiaBLL getInstance() {
		if (instance == null)
			instance = new QLDocGiaBLL();
		return instance;
	}
	
	private boolean checkData(DocGiaDTO dg) throws MyNullException{
		if (dg.getMaDocGia().equals(""))
			throw new MyNullException("Mã đọc giả đang bị trống");
		if(dg.getLoaiDocGia().toString().equals(""))
			throw new MyNullException("Loại đọc giả đang bị trống");
		if(dg.getLopMon().equals(""))
			throw new MyNullException("Lớp/Môn đang bị bỏ trống");
		if(dg.getTenDocGia().equals(""))
			throw new MyNullException("Tên đọc giả không được bỏ trống");
		try {
			dg.getNgaySinh().toString();
		}catch(NullPointerException e) {
			throw new MyNullException("Ngày sinh đang bị bỏ trống");
		}
		return true;
	}
	
	public String addProcessing(DocGiaDTO dg) {
		try {
			checkData(dg);
			String msg;
			int result = DocGiaDAL.getInstance().addProcessing(dg);
			if (result > 0) {
				msg = "Đã thêm thành công";
			}
			else
				msg = "Thêm lỗi! Vui lòng thử lại";
			return msg;
		}
		catch(MyNullException e1) {
			return e1.getMessage();
		}
		catch (ContainException e2) {
			return e2.getMessage();
		}
		
	}
	
	public String changeProcessing(DocGiaDTO dg) {
		try {
			String msg;
			checkData(dg);
			
			int result = DocGiaDAL.getInstance().changeProcessing(dg);
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
	
	public DefaultTableModel reloadResources() {
		ArrayList<DocGiaDTO> dsDocGia = new ArrayList<DocGiaDTO>();
		dsDocGia = DocGiaDAL.getInstance().reloadResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã độc giả");
			dtm.addColumn("Họ và tên");
			dtm.addColumn("Loại độc giả");
			dtm.addColumn("Lớp/Chuyên môn");
			dtm.addColumn("Ngày sinh");
			dtm.addColumn("SĐT");
			dtm.addColumn("Email");
			int i = 1;
			for(DocGiaDTO dg : dsDocGia) {
				Object[] row = {i++, dg.getMaDocGia(), dg.getTenDocGia(),dg.getLoaiDocGia().toString(),
						dg.getLopMon(), dg.getNgaySinh(), dg.getSdt(), dg.getEmail()};
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
	
	public String deleteProcessing(String madg) {
		if(madg.equals("")) 
			return "Không có tài khoản nào được chọn";
		
		int result = DocGiaDAL.getInstance().deleteProcessing(madg);
		if (result > 0)
			return "Xóa thành công";
		else
			return "Xóa không thành công! Vui lòng thử lại";
	}
	
	public DefaultTableModel getResources(JComboBox<LoaiDocGiaDTO> cbbLoaiDocGia) {
		ArrayList<DocGiaDTO> dsDocGia = new ArrayList<DocGiaDTO>();
		dsDocGia = DocGiaDAL.getInstance().getResources(cbbLoaiDocGia);
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã độc giả");
			dtm.addColumn("Họ và tên");
			dtm.addColumn("Loại độc giả");
			dtm.addColumn("Lớp/ Chuyên môn");
			dtm.addColumn("Ngày sinh");
			dtm.addColumn("SĐT");
			dtm.addColumn("Email");
			int i = 1;
			for(DocGiaDTO dg : dsDocGia) {
				Object[] row = {i++, dg.getMaDocGia(), dg.getTenDocGia(),dg.getLoaiDocGia().toString(),
						dg.getLopMon(), dg.getNgaySinh(), dg.getSdt(), dg.getEmail()};
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

	public int SoDocGia() {
		return DocGiaDAL.getInstance().getSodocgia();
	}
	
	public TableModel timKiem(String key) {
		DefaultTableModel dtm=new DefaultTableModel();
		ArrayList<DocGiaDTO> dsDocGia=new ArrayList<DocGiaDTO>();
		dsDocGia=DocGiaDAL.getInstance().reloadResources();
		dtm.addColumn("STT");
		dtm.addColumn("Mã độc giả");
		dtm.addColumn("Họ và tên");
		dtm.addColumn("Loại độc giả");
		dtm.addColumn("Lớp/ Chuyên môn");
		dtm.addColumn("Ngày sinh");
		dtm.addColumn("SĐT");
		dtm.addColumn("Email");
		int i=0;
		System.out.println(key);
		for(DocGiaDTO dg:dsDocGia) {
			String thongTin=DocGiaDAL.getInstance().thongTin(dg.getMaDocGia());
			thongTin=thongTin.toLowerCase();
			key=key.toLowerCase();
			if(thongTin.contains(key)) {
				Object[] row= {i++,dg.getMaDocGia(),
						dg.getTenDocGia(),
						dg.getLoaiDocGia(),
						dg.getLopMon(),
						dg.getNgaySinh(),
						dg.getSdt(),
						dg.getEmail()};
				dtm.addRow(row);
				}
			}
		return dtm;
		}
	
}
