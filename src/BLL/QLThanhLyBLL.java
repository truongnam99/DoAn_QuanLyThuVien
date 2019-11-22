package BLL;

import java.net.ConnectException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import DAL.PhatTienDAL;
import DAL.ThanhLyDAL;
import DTO.*;
import MyException.ContainException;
import MyException.MyNullException;

public class QLThanhLyBLL {

	public static QLThanhLyBLL instance;
	
	private QLThanhLyBLL() {
		
	}
	
	public static QLThanhLyBLL getInstance() {
		if(instance==null)
			instance=new QLThanhLyBLL();
		return instance;
	}
	
	private boolean checkData(ThanhLyDTO tl) throws MyNullException{
		if(tl.getMaSach().equals(""))
		{
			throw new MyNullException("Mã sách không được bỏ trống");
		}
		if(tl.getTenSach().equals(""))
		{
			throw new MyNullException("Tên sách không được bỏ trống");
		}
//		if(tl.getTheLoai().equals(""))
//		{
//			throw new MyNullException("Thể loại không được bỏ trống");
//		}
//		if(tl.getTacGia().equals(""))
//		{
//			throw new MyNullException("Tác giả không được bỏ trống");
//		}
//		if(tl.getNhaXuatBan().equals(""))
//		{
//			throw new MyNullException("Nhà xuất bản không được bỏ trống");
//		}
		if(tl.getLyDo().equals(""))
		{
			throw new MyNullException("Lý do không được bỏ trống");
		}
		if(tl.getThoiGianLuuKho().equals(""))
		{
			throw new MyNullException("Thời gian lưu kho không được bỏ trống");
		}
		if(tl.getNgayThanhLy().equals(""))
		{
			throw new MyNullException("Ngày thanh lý không được bỏ trống");
		}
		return true;
	}
	
	public String addProcessing(ThanhLyDTO tl) {
		try {
			checkData(tl);
			String msg;
			int result=ThanhLyDAL.getInstance().addProcessing(tl);
			switch(result) {
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
	}
	
	public String changeProcessing (ThanhLyDTO tl) {
		String msg;
		try {
			checkData(tl);
			int result=ThanhLyDAL.getInstance().changeProcessing(tl);
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
		catch(MyNullException e)
		{
			return e.toString();
		}
	}
	
	public String deleteProcessing (String masach) {
		if(masach.equals(""))
			return "Không có mã sách nào được chọn để xóa";
		int result=ThanhLyDAL.getInstance().deleteProcessing(masach);
		if(result>0)
			return "Xóa thành công";
		else 
			return "Xóa không thành công! Vui lòng kiểm tra lại";
	}
	
	public DefaultTableModel reloadResources() {
		ArrayList<ThanhLyDTO> dsThanhLy=new ArrayList<ThanhLyDTO>();
		dsThanhLy=ThanhLyDAL.getInstance().reloadResources();
		DefaultTableModel dtm=new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã sách");
			dtm.addColumn("Tên sách");
			dtm.addColumn("Thể loại");
			dtm.addColumn("Tác giả");
			dtm.addColumn("Nhà xuất bản");
			dtm.addColumn("Lý do");
			dtm.addColumn("Thời gian lưu kho");
			dtm.addColumn("Ngày thanh lý");
			int i=1;
			for(ThanhLyDTO thanhly: dsThanhLy) {
				Object[] row = {i++,thanhly.getMaSach(),thanhly.getTenSach(),thanhly.getTheLoai(),thanhly.getTacGia(),thanhly.getNhaXuatBan(),thanhly.getLyDo(),thanhly.getThoiGianLuuKho(),thanhly.getNgayThanhLy()};
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
		 ArrayList<ThanhLyDTO> dsThanhLy=new ArrayList<ThanhLyDTO>();
			dsThanhLy=ThanhLyDAL.getInstance().getResources();
			DefaultTableModel dtm=new DefaultTableModel();
			try {
				dtm.addColumn("STT");
				dtm.addColumn("Mã sách");
				dtm.addColumn("Tên sách");
				dtm.addColumn("Thể loại");
				dtm.addColumn("Tác giả");
				dtm.addColumn("Nhà xuất bản");
				dtm.addColumn("Lý do");
				dtm.addColumn("Thời gian lưu kho");
				dtm.addColumn("Ngày thanh lý");
				int i=1;
				for(ThanhLyDTO thanhly: dsThanhLy) {
					Object[] row = {i++,thanhly.getMaSach(),thanhly.getTenSach(),thanhly.getTheLoai(),thanhly.getTacGia(),thanhly.getNhaXuatBan(),thanhly.getLyDo(),thanhly.getThoiGianLuuKho(),thanhly.getNgayThanhLy()};
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
