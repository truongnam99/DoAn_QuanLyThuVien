package BLL;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import DAL.MuonTraDAL;
import DAL.SachDAL;
import DTO.MuonTraDTO;
import DTO.SachDTO;

public class BaoCaoBLL {
	
	private static BaoCaoBLL instance;
	DefaultTableModel dtm;
	private ArrayList<Object[]> dataRow;
	
	private BaoCaoBLL(){
		dataRow = new ArrayList<Object[]>();
	}
	
	public static BaoCaoBLL getInstance() {
		if (instance == null)
			instance = new BaoCaoBLL();
		return instance;
	}
	
	public DefaultTableModel thongKe(int thang, int nam) {
		dtm = new DefaultTableModel();
		dtm.addColumn("Tên thể loại");
		dtm.addColumn("Số lượt mượn");
		dtm.addColumn("Tỉ lệ");
		ArrayList<MuonTraDTO> dsMuonTra = MuonTraDAL.getInstance().getResources();
		ArrayList<SachDTO> dsSach = SachDAL.getInstance().getResources();
		ArrayList<String> dsTheLoai = new ArrayList<String>();
		for (MuonTraDTO mt: dsMuonTra) {
			if (mt.getNgayMuon().getMonth() == thang && mt.getNgayMuon().getYear() + 1900 == nam) {
				String maSach = mt.getMaSach();
				for (SachDTO sach: dsSach) {
					if (maSach.equals(sach.getMaSach())){
						String theLoai = sach.getTheLoai();
						dsTheLoai.add(theLoai);
						break;
					}
				}
				
			}
			else
				continue;
		}
		int tongLuotMuon = dsTheLoai.size();
		ArrayList<String> theLoai = new ArrayList<String>();
		for (String item: dsTheLoai) {
			if (theLoai.contains(item))
				continue;
			else
				theLoai.add(item);
		}
		
		for (String item: theLoai) {
			int count = 0;
			for (String tl: dsTheLoai)
				if (tl.equals(item))
					count++;
			
			Object[] row = {item, count, (float)count/tongLuotMuon * 100};
			dataRow.add(row);
			dtm.addRow(row);
		}
		
		return dtm;
		
	}

	public void lapBaoCao() {
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph p1 = document.createParagraph();
		p1.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun run = p1.createRun();
		run.setFontSize(20);
		run.setBold(true);
		run.setText("BÁO CÁO THỐNG KÊ");
		XWPFParagraph p2 = document.createParagraph();
		p2.setAlignment(ParagraphAlignment.CENTER);
		run = p2.createRun();
		run.setFontSize(20);
		run.setBold(true);
		run.setText("TÌNH HÌNH MƯỢN SÁCH THEO THỂ LOẠI");
		XWPFParagraph p3 = document.createParagraph();
		p3.setAlignment(ParagraphAlignment.RIGHT);
		run = p3.createRun();
		run.setFontSize(14);
		SimpleDateFormat sdfNgay = new SimpleDateFormat("dd");
		SimpleDateFormat sdfThang = new SimpleDateFormat("MM");
		SimpleDateFormat sdfNam = new SimpleDateFormat("YYYY");
		Date now = new Date();
		run.setText("Ngày "+ sdfNgay.format(now) + " tháng "+ sdfThang.format(now) + " năm "+ sdfNam.format(now));
		
		XWPFParagraph p4 = document.createParagraph();
//		run = p4.createRun();
		p4.setAlignment(ParagraphAlignment.CENTER);
	
		XWPFTable tb = document.createTable();
		XWPFTableRow row = tb.getRow(0);
		
		
		row.getCell(0).setText("Tên thể loại");
		row.addNewTableCell().setText("Số lượng mượn");
		row.addNewTableCell().setText("Tỉ lệ");
		//tb.setWidth(600);
		tb.setCellMargins(200, 200, 100, 2000);
		for (int i = 0; i< dataRow.size(); i++) {
			Object[] iRow = dataRow.get(i);
			XWPFTableRow tableRow = tb.createRow();
			tableRow.setHeight(30);
			tableRow.getCell(0).setText(iRow[0].toString());
			tableRow.getCell(1).setText(iRow[1].toString());
			tableRow.getCell(2).setText(iRow[2].toString());
		}
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		try {
			FileOutputStream out = new FileOutputStream(new File("Báo cáo ngày "+ sdf.format(now) + ".docx"));
			document.write(out);
			out.close();
			document.close();
			System.out.println("Thành công");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
