package BLL;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAL.DocGiaDAL;
import DTO.*;

public class QLDocGiaBLL {
	public static QLDocGiaBLL instance;
	
	private QLDocGiaBLL(){
		
	}
	
	public static QLDocGiaBLL getInstance() {
		if (instance == null)
			instance = new QLDocGiaBLL();
		return instance;
	}
	
	
	
	public DefaultTableModel getResources() {
		ArrayList<DocGiaDTO> dsDocGia = new ArrayList<DocGiaDTO>();
		dsDocGia = DocGiaDAL.getInstance().getResources();
		DefaultTableModel dtm = new DefaultTableModel();
		try {
			dtm.addColumn("STT");
			dtm.addColumn("Mã độc giả");
			dtm.addColumn("Họ và tên");
			dtm.addColumn("Loại độc giả");
			dtm.addColumn("Lớp/Môn");
			dtm.addColumn("Ngày sinh");
			dtm.addColumn("SDT");
			dtm.addColumn("Email");
			int i = 1;
			for(DocGiaDTO dg : dsDocGia) {
				Object[] row = {i++, dg.getMaDocGia(), dg.getTenDocGia(),dg.getLoaiDocGia().getTenLoaiDocGia(),
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
	
	
}
