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

	private void checkData(String maDocGia, String maSach, String ngayMuon, String ngayTra) throws MyNullException, MyException{
		if (maDocGia.equals(""))
			throw new MyNullException("Mã độc giả đang bị trống");
		if(maSach.equals(""))
			throw new MyNullException("Mã độc giả đang bị trống");
		try {
			java.util.Date nm = new java.util.Date(ngayMuon);
			java.util.Date nt = new java.util.Date(ngayTra);
			
			SachDTO s = SachDAL.getInstance().getSach(maSach);	
			
			if(nm.compareTo(nt) > 0) {
				throw new MyException("Ngày mượn phải bé hơn ngày trả");
			}
			
			java.util.Date nn = new java.util.Date(s.getNgayNhap().toString());
			
			if(nm.compareTo(nn) < 0) {
				throw new MyException("Ngày mượn đang bé hơn ngày nhập sách vào");
			}
		}
		catch(Exception e) {
			System.out.println("insert into quanlymuonsach values(\"" + maDocGia + "\", \"" + maSach + "\", \"" + ngayMuon + "\", \"" + ngayTra+"\", \"0\")");
			throw new MyException("Ngày tháng bị lỗi");
		}
		
	}
	
	public String addProcessing(String maDocGia, String maSach, String ngayMuon, String ngayTra) {
		try {
			checkData(maDocGia, maSach, ngayMuon, ngayTra);
			boolean trong = SachDAL.getInstance().isTrong(maSach);
			if (!trong)
				return "Sách nhập vào đang được mượn! Vui lòng kiểm tra lại";
			int result = MuonTraDAL.getInstance().addProcessing(maSach, maDocGia, ngayMuon, ngayTra);
			if (result> 0)
				return "Thêm thành công";
			else
				return "Thêm thất bại";
		}catch(MyNullException e1) {
			return e1.getMessage();
		}catch(MyException e2) {
			return e2.getMessage();
		}
	}

	public String changeProcessing(String maDocGia, String maSach, String ngayMuon, String ngayTra) {
		
		try {
			checkData(maDocGia, maSach, ngayMuon, ngayTra);
			if(!maDocGia.equals(muonTra.getMaDocGia())) {
				return "Mã độc giả không được thay đổi";
				
			}
			if(!maSach.equalsIgnoreCase(muonTra.getMaSach())) {
				return "Mã sách không được thay đổi";
			}
			int result = MuonTraDAL.getInstance().changeProcessing(maDocGia, maSach, ngayMuon, ngayTra);
			if(result>0)
				return "Thay đổi thành công";
			else
				return "Thay đổi không thành công";
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
	
	

}