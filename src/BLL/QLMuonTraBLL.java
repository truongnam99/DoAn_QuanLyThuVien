package BLL;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAL.DocGiaDAL;
import DAL.MuonTraDAL;
import DAL.SachDAL;
import DTO.MuonTraDTO;

public class QLMuonTraBLL {
public static QLMuonTraBLL instance;
	
	private QLMuonTraBLL(){
		
	}
	
	public static QLMuonTraBLL getInstance() {
		if (instance == null)
			instance = new QLMuonTraBLL();
		return instance;
	}
	
	public String insert(MuonTraDTO muonTra) {
		
//		if(MuonTraDAL.getInstance().insert(muonTra) > 0)
//			return "Thêm thành công!";
		return "Thêm Thất bại, các thuộc tính trước khi thêm";
	}
	public String update(MuonTraDTO muonTra) {
		
//		if(MuonTraDAL.getInstance().update(muonTra) > 0)
//			return "Chỉnh sửa thành công!";
		return "Chỉnh sửa thất bại, các thuộc tính trước khi chỉnh sửa";
	}
	public String delete(MuonTraDTO muonTra) {
		
//		if(MuonTraDAL.getInstance().delete(muonTra) > 0)
//			return "Xóa thành công!";
		return "Xóa thất bại, các thuộc tính trước khi xóa";
	}
	public DefaultTableModel getResources() {
		ArrayList<MuonTraDTO> dsMuonTra = new ArrayList<MuonTraDTO>();
		dsMuonTra = MuonTraDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Tên độc giả");
			dtm.addColumn("Tên sách");
			dtm.addColumn("Ngày mượn");
			dtm.addColumn("Ngày trả");
			dtm.addColumn("Trạng thái");
			dtm.addColumn("TRẢ SÁCH");
			int i = 1;
			for(MuonTraDTO dg : dsMuonTra) {
				Object[] row = {i++, dg.getDocGia(), dg.getSach(),
						dg.getNgayMuon(),dg.getNgayTra(),dg.getTrangThai(), "Trả"};
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
