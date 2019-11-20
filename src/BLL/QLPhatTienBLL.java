package BLL;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import DAL.PhatTienDAL;
import DTO.*;

public class QLPhatTienBLL {
	public static QLPhatTienBLL instance;
	
	private QLPhatTienBLL() {
		
	}
	
	public static QLPhatTienBLL getInstance() {
		if(instance==null)
			instance=new QLPhatTienBLL();
		return instance;
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
