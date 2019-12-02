package BLL;

import java.sql.Date;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.DocGiaDAL;
import DAL.MuonTraDAL;
import DAL.SachDAL;
import DTO.DocGiaDTO;
import DTO.MuonTraDTO;
import DTO.SachDTO;
import MyException.ContainException;
import MyException.MyException;
import MyException.MyNullException;

public class QLMuonTraBLL {

	


	public static QLMuonTraBLL instance;
	
	public MuonTraDTO muonTra;// Sách đang thao tác để thay đổi thông tin

	
	private QLMuonTraBLL(){

	}
	
	public static QLMuonTraBLL getInstance() {
		if (instance == null)
			instance = new QLMuonTraBLL();
		return instance;
	}

	
	


	public DefaultTableModel getResources() {
		
		ArrayList<MuonTraDTO> dsMuonTra = new ArrayList<MuonTraDTO>();
		dsMuonTra = MuonTraDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã độc giả");
			dtm.addColumn("Họ và tên");
			dtm.addColumn("Mã sách");
			dtm.addColumn("Tên sách");
			dtm.addColumn("Ngày mượn");
			dtm.addColumn("Ngày trả");
			dtm.addColumn("Trạng thái");
			dtm.addColumn("Trả sách");
			int i = 1;
			for(MuonTraDTO mt : dsMuonTra) {
				if (mt.getTrangThai().equals("-1"))//đã trả
					continue;
				Object[] row = {i++, mt.getMaDocGia(), 
						DocGiaDAL.getInstance().getTenDocGia(mt.getMaDocGia()), 
						mt.getMaSach(),
						SachDAL.getInstance().getTenSach(mt.getMaSach()),
						mt.getNgayMuon(),
						mt.getNgayTra(),
						mt.getTrangThai(),
						"Trả"};
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

	
	private void checkData(MuonTraDTO mt) throws MyNullException, MyException{
		if (mt.getMaDocGia().equals(""))
			throw new MyNullException("Mã độc giả đang bị trống");
		if(mt.getMaSach().equals(""))
			throw new MyNullException("Mã độc giả đang bị trống");
		try {
			Date nm;
			Date nt;
			
				 nm = mt.getNgayMuon();
				 nt = mt.getNgayTra();
				
			SachDTO s = SachDAL.getInstance().getSach(mt.getMaSach());	
			
			if(nm.compareTo(nt) > 0) {
				throw new MyException("Ngày mượn phải bé hơn ngày trả");
			}
			
			Date nn = (Date) s.getNgayNhap();
			
			if(nm.compareTo(nn) < 0) {
				throw new MyException("Ngày mượn đang bé hơn ngày nhập sách vào");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new MyException("Ngày tháng bị lỗi");
		}
		
	}
	
	

	
	public String addProcessing(MuonTraDTO mt) throws MyException, ContainException  {
		try {
			checkData(mt);
			String msg;
			boolean trong = SachDAL.getInstance().isTrong(mt.getMaSach());
			if (!trong)
				msg= "Sách nhập vào đang được mượn! Vui lòng kiểm tra lại";
			int result = MuonTraDAL.getInstance().addProcessing(mt);
			if (result> 0)
				msg= "Đã thêm thành công";
			else
				msg= "Thêm lỗi! Vui lòng thử lại";
			return msg;
		}catch(MyNullException e1) {
			return e1.getMessage();
		}catch(MyException e2) {
			return e2.getMessage();
		}
	}

		public String changeProcessing(MuonTraDTO mt) {
		
		try {
			String msg;
			checkData(mt);
			if(!mt.getMaDocGia().equals(mt.getMaDocGia())) {
				msg= "Mã độc giả không được thay đổi";
				
			}
			if(!mt.getMaSach().equalsIgnoreCase(mt.getMaSach())) {
				msg= "Mã sách không được thay đổi";
			}
			int result = MuonTraDAL.getInstance().changeProcessing(mt);
			if(result>0)
				msg= "Thay đổi thành công";
			else
				msg= "Thay đổi không thành công";
			return msg;
		}catch(MyNullException e1) {
			return e1.getMessage();
		}catch(MyException e2) {
			return e2.getMessage();
		}
	}

	public String traSach(String maDocGia, String maSach) {
		int result = MuonTraDAL.getInstance().traSach(maDocGia, maSach);
		if (result > 0)
			return "Trả sách thành công";
		else
			return "Trả sách không thành công";
		
	}

	public int SoSachMuon() {
		// TODO Auto-generated method stub
		return MuonTraDAL.getInstance().getResources().size();
	}

	public DefaultTableModel reloadResources() {
		ArrayList<MuonTraDTO> dsMuonTra = new ArrayList<MuonTraDTO>();
		dsMuonTra = MuonTraDAL.getInstance().reloadResources();
		DefaultTableModel dtm = new DefaultTableModel();
		
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã độc giả");
			dtm.addColumn("Họ và tên");
			dtm.addColumn("Mã sách");
			dtm.addColumn("Tên sách");
			dtm.addColumn("Ngày mượn");
			dtm.addColumn("Ngày trả");
			dtm.addColumn("Trạng thái");
			dtm.addColumn("Trả sách");
			int i = 1;
			for(MuonTraDTO mt : dsMuonTra) {
				if (mt.getTrangThai().equals("-1"))//đã trả
					continue;
				Object[] row = {i++, mt.getMaDocGia(), 
						DocGiaDAL.getInstance().getTenDocGia(mt.getMaDocGia()), 
						mt.getMaSach(),
						SachDAL.getInstance().getTenSach(mt.getMaSach()),
						mt.getNgayMuon(),
						mt.getNgayTra(),
						mt.getTrangThai(),
						"Trả"};
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