package BLL;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAL.SachDAL;
import DAL.ThanhLyDAL;
import DTO.*;
import MyException.MyException;

public class QLThanhLyBLL {

	public static QLThanhLyBLL instance;
	ArrayList<SachDTO> dsSach;
	ArrayList<SachDTO> dsSachThanhLy;
	DefaultTableModel dtbSachThanhLy;
	private QLThanhLyBLL() {
		dsSachThanhLy = new ArrayList<SachDTO>();
		dtbSachThanhLy = new DefaultTableModel();
		dtbSachThanhLy.addColumn("Mã sách");
		dtbSachThanhLy.addColumn("Tên sách");
		dtbSachThanhLy.addColumn("Tên tác giả");
		dtbSachThanhLy.addColumn("Thể loại");
	}
	
	public static QLThanhLyBLL getInstance() {
		if(instance==null)
			instance=new QLThanhLyBLL();
		return instance;
	}
	
	 public DefaultTableModel getResources() {
		
		DefaultTableModel dtm = new DefaultTableModel();
		
		dsSach = SachDAL.getInstance().getResources();
		dtm.addColumn("Mã sách");
		dtm.addColumn("Tên sách");
		for(SachDTO sach:dsSach) {
			if (!sach.getTrangThai().equals("Trống"))
				continue;
			Object[] sachs = {sach.getMaSach(), sach.getTenSach()};
			dtm.addRow(sachs);
		}
		
		return dtm;
	 }

	public DefaultTableModel addProcessing(String maSach) throws MyException {
		for (SachDTO sach: dsSachThanhLy) {
			if (sach.getMaSach().equals(maSach))
				throw new MyException("Sách đã tồn tại trong danh sách thanh lý");
		}
		for (SachDTO s: dsSach) {
			if (s.getMaSach().equals(maSach)) {
				dsSachThanhLy.add(s);
				Object[] rowData = {s.getMaSach(), s.getTenSach(), s.getTacGia(), s.getTheLoai()};
				dtbSachThanhLy.addRow(rowData);
				break;
			}
		}
		
		return dtbSachThanhLy;
	}

	public TableModel delProcessing(String maSach) throws MyException{
		boolean check = true;
		for (SachDTO sach: dsSachThanhLy) {
			if (sach.getMaSach().equals(maSach)) {
				dsSachThanhLy.remove(sach);
				check = false;
				break;
			}
		}
		if(check){
			throw new MyException("Sách không tồn tại trong danh sách thanh lý");
		}
		while (dtbSachThanhLy.getRowCount()> 0){
			dtbSachThanhLy.removeRow(0);
		}
		for(SachDTO s: dsSachThanhLy) {
			Object[] rowData = {s.getMaSach(), s.getTenSach(), s.getTacGia(), s.getTheLoai()};
			dtbSachThanhLy.addRow(rowData);
		}
		return dtbSachThanhLy;
	}

	public String thanhLy(String lyDo) {
		ThanhLyDAL.getInstance().addSach(dsSachThanhLy, lyDo);
		return null;
	}
}
