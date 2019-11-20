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
	
	public String insert(DocGiaDTO docGia) {
		
		if(DocGiaDAL.getInstance().insert(docGia) > 0)
			return "thanhcong";
		return "thatbai";
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
			int i = 1;
			for(DocGiaDTO dg : dsDocGia) {
				Object[] row = {i++, dg.getMaDocGia(), dg.getTenDocGia(),dg.getLoaiDocGia()};
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
