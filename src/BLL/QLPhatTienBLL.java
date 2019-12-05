package BLL;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import DAL.DocGiaDAL;
import DAL.PhatTienDAL;
import DTO.*;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;

public class QLPhatTienBLL {
	public static QLPhatTienBLL instance;
	
	private QLPhatTienBLL() {
		
	}
	
	public static QLPhatTienBLL getInstance() {
		if(instance==null)
			instance=new QLPhatTienBLL();
		return instance;
	}
	
	private boolean checkData(PhatTienDTO pt) throws MyNullException, MyException{
		if(pt.getMaLanPhat().equals(""))
		{
			throw new MyNullException("Mã lần phạt không được bỏ trống");
		}
		if(pt.getSoTien().equals(""))
		{
			throw new MyNullException("Số tiền không được bỏ trống");
		}
		if(pt.getMaDocGia().equals(""))
		{
			throw new MyNullException("Mã độc giả không được bỏ trống");
		}
		if(pt.getNgayPhat().equals(""))
		{
			throw new MyNullException("Ngày phạt không được bỏ trống");
		}
		try {
			int t = Integer.parseInt(pt.getSoTien());
			if (t < 0)
				throw new MyException("Số tiền phạt phải lớn hơn 0");
		}catch(Exception e) {
			throw new MyException("Số tiền phải là số");
		}
		
		
		return true;
	}
	
	public String addProcessing(PhatTienDTO pt) {
		try {
			checkData(pt);
			String msg;
			int result=PhatTienDAL.getInstance().addProcessing(pt);
			if(!DocGiaDAL.getInstance().isContain(pt.getMaDocGia()))
				return "Mã độc giả không tồn tại";
			switch(result)
			{
			case -1:
			case 0:
				msg="Thêm không thành công! Vui lòng thử lại";
				break;
				default:
					msg="Đã thêm";
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
		catch(MyException e) {
			return e.getMessage();
		}
	}
	
	public String changeProcessing (PhatTienDTO pt) {
		String msg;
		try {
			checkData(pt);
			int result = PhatTienDAL.getInstance().changeProcessing(pt);
			switch(result) {
			case -1:
				
			case 0:
				msg="Sửa không thành công! Vui lòng thử lại";
				break;
				default:
					msg="Đã chỉnh sửa";
			}
			return msg;
		}
		catch(MyNullException e) {
			return e.toString();
		}
		catch(MyException e) {
			return e.getMessage();
		}
	}
	
	public String deleteProcessing(String malp) {
		if(malp.equals(""))
			return "Không có độc giả vi phạm nào được chọn để xóa";
		int result =PhatTienDAL.getInstance().deleteProcessing(malp);
		if(result>0)
			return "Xóa thành công";
		else
			return "Xóa không thành công! Vui lòng kiểm tra lại";
	}
	
	public DefaultTableModel reloadResources() {
		ArrayList<PhatTienDTO> dsPhatTien = new ArrayList<PhatTienDTO>();
		dsPhatTien = PhatTienDAL.getInstance().reloadResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã lần phạt");
			dtm.addColumn("Số tiền");
			dtm.addColumn("Mã độc giả");
			dtm.addColumn("Ngày phạt");
			dtm.addColumn("Lý do");
			int i = 1;
			for(PhatTienDTO phat : dsPhatTien) {
				Object[] row = {i++, phat.getMaLanPhat(),phat.getSoTien(),phat.getMaDocGia(),phat.getNgayPhat(),phat.getLyDo()};
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
		ArrayList<PhatTienDTO> dsPhatTien = new ArrayList<PhatTienDTO>();
		dsPhatTien = PhatTienDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã lần phạt");
			dtm.addColumn("Số tiền");
			dtm.addColumn("Mã độc giả");
			dtm.addColumn("Ngày phạt");
			dtm.addColumn("Lý do");
			int i = 1;
			for(PhatTienDTO phat : dsPhatTien) {
				Object[] row = {i++, phat.getMaLanPhat(),phat.getSoTien(),phat.getMaDocGia(),phat.getNgayPhat(),phat.getLyDo()};
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
