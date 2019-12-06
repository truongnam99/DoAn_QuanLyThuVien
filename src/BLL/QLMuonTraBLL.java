package BLL;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.DocGiaDAL;
import DAL.HeThongDAL;
import DAL.MuonTraDAL;
import DAL.SachDAL;
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
		if(!SachDAL.getInstance().isTrong(mt.getMaSach()))
			throw new MyException("Sách này đang được mượn");
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
			throw new MyException("Ngày tháng bị lỗi hoặc sách không tồn tại");
		}
		
	}
	
	

	
	public String addProcessing(MuonTraDTO mt) throws MyException, ContainException  {
		try {
			checkData(mt);
			int soSachDangMuon = MuonTraDAL.getInstance().soSachDangMuon(mt.getMaDocGia());
			if (DocGiaDAL.getInstance().getDocGia(mt.getMaDocGia()).getLoaiDocGia().toString().equalsIgnoreCase("Học sinh")) {
				if(soSachDangMuon >= Integer.parseInt(HeThongDAL.getInstance().getResources().get(0).getGiaTri()))
					return "Độc giả này đã mượn đủ số cuốn được quy định";
			}
			else
				if(soSachDangMuon >= Integer.parseInt(HeThongDAL.getInstance().getResources().get(5).getGiaTri()))
					return "Độc giả này đã mượn đủ số cuốn được quy định";
			
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
		try{
			int result = MuonTraDAL.getInstance().traSach(maDocGia, maSach);
			if (result > 0)
				return "Trả sách thành công";
			else
				return "Trả sách không thành công";
		}catch(Exception e1) {
			return e1.getMessage();
		}
		
		
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

	
	public TableModel timKiem(String key) {
		DefaultTableModel dtm = new DefaultTableModel();
		ArrayList<MuonTraDTO> dsMuonTra = new ArrayList<MuonTraDTO>();
		dsMuonTra = MuonTraDAL.getInstance().reloadResources();
		dtm.addColumn("STT");
		dtm.addColumn("Mã độc giả");
		dtm.addColumn("Họ và tên");
		dtm.addColumn("Mã sách");
		dtm.addColumn("Tên sách");
		dtm.addColumn("Ngày mượn");
		dtm.addColumn("Ngày trả");
		dtm.addColumn("Trạng thái");
		dtm.addColumn("Trả sách");
		int i = 0;
		System.out.println(key);
		for(MuonTraDTO mt : dsMuonTra) {
			if (mt.getTrangThai().equals("-1"))//đã trả
				continue;
			String thongTin = SachDAL.getInstance().getThongTin(mt.getMaSach())+ DocGiaDAL.getInstance().thongTin(mt.getMaDocGia());
			thongTin = thongTin.toLowerCase();
			key = key.toLowerCase();
			if(thongTin.contains(key)) {
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
		
		return dtm;
	}

	
	
	

}