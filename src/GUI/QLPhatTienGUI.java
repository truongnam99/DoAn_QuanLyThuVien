package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BLL.QLDocGiaBLL;
import BLL.QLPhatTienBLL;
import javax.swing.ScrollPaneConstants;


public class QLPhatTienGUI {
	private JTable tbQLViPham;
	private JTextField txtfHoTen;
	private JTextField txtfLoaiDocGia;
	private JTextField txtfSoTienThu;
	private JTextField txtfConLai;
	private JPanel pnTongQuanQLViPham;

	static QLPhatTienGUI instance=null;
	
	private QLPhatTienGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbQLViPham.setModel(QLPhatTienBLL.getInstance().getResources());
	}
	
	private void refreshDataTable() {
		
	}
	
	public static QLPhatTienGUI getInstance() {
		if(instance == null)
			instance = new QLPhatTienGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLPhatTien() {
		return pnTongQuanQLViPham;
	}
	private void initialize() {
		
		pnTongQuanQLViPham = new JPanel();
		pnTongQuanQLViPham.setBackground(SystemColor.activeCaption);
		pnTongQuanQLViPham.setBounds(0, 0, 1065, 560);
		pnTongQuanQLViPham.setLayout(null);
		
		JPanel pnTieuDeQLViPham = new JPanel();
		pnTieuDeQLViPham.setBackground(SystemColor.activeCaption);
		pnTieuDeQLViPham.setBounds(0, 0, 1065, 62);
		pnTongQuanQLViPham.add(pnTieuDeQLViPham);
		pnTieuDeQLViPham.setLayout(null);
		
		JLabel lblQLViPham = new JLabel("QU\u1EA2N L\u00DD VI PH\u1EA0M");
		lblQLViPham.setForeground(Color.RED);
		lblQLViPham.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLViPham.setBounds(434, 13, 221, 33);
		pnTieuDeQLViPham.add(lblQLViPham);
		
		JPanel pnQLViPham = new JPanel();
		pnQLViPham.setBounds(0, 67, 1065, 230);
		pnTongQuanQLViPham.add(pnQLViPham);
		pnQLViPham.setLayout(new BorderLayout());
		
		tbQLViPham = new JTable();
		tbQLViPham.setBounds(0, 0, 1050, 170);
		JScrollPane sc = new JScrollPane(tbQLViPham, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1078, 180);
		pnQLViPham.add(sc,BorderLayout.CENTER);
		
		JPanel pnThongTinDocGia = new JPanel();
		pnThongTinDocGia.setBackground(SystemColor.activeCaption);
		pnThongTinDocGia.setBounds(0, 304, 1065, 256);
		pnTongQuanQLViPham.add(pnThongTinDocGia);
		pnThongTinDocGia.setLayout(null);
		
		JLabel lblThongTinDocGia = new JLabel("THÔNG TIN VI PHẠM");
		lblThongTinDocGia.setBounds(10, 5, 187, 22);
		lblThongTinDocGia.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pnThongTinDocGia.add(lblThongTinDocGia);
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBounds(10, 37, 843, 208);
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinDocGia.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblHoten = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		lblHoten.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHoten.setBounds(32, 50, 59, 14);
		pnThongTinNhap.add(lblHoten);
		
		JLabel lblLoaiDocGia = new JLabel("Lo\u1EA1i \u0111\u1ED9c gi\u1EA3:");
		lblLoaiDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLoaiDocGia.setBounds(32, 139, 80, 14);
		pnThongTinNhap.add(lblLoaiDocGia);
		
		JLabel lblSoTienThu = new JLabel("S\u1ED1 ti\u1EC1n thu:");
		lblSoTienThu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSoTienThu.setBounds(461, 50, 72, 14);
		pnThongTinNhap.add(lblSoTienThu);
		
		JLabel lblConLai = new JLabel("C\u00F2n l\u1EA1i:");
		lblConLai.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblConLai.setBounds(461, 139, 46, 14);
		pnThongTinNhap.add(lblConLai);
		
		txtfHoTen = new JTextField();
		txtfHoTen.setBounds(116, 36, 258, 31);
		pnThongTinNhap.add(txtfHoTen);
		txtfHoTen.setColumns(10);
		
		txtfLoaiDocGia = new JTextField();
		txtfLoaiDocGia.setBounds(116, 125, 258, 31);
		pnThongTinNhap.add(txtfLoaiDocGia);
		txtfLoaiDocGia.setColumns(10);
		
		txtfSoTienThu = new JTextField();
		txtfSoTienThu.setBounds(543, 36, 258, 31);
		pnThongTinNhap.add(txtfSoTienThu);
		txtfSoTienThu.setColumns(10);
		
		txtfConLai = new JTextField();
		txtfConLai.setBounds(543, 125, 258, 31);
		pnThongTinNhap.add(txtfConLai);
		txtfConLai.setColumns(10);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setBounds(897, 37, 138, 41);
		pnThongTinDocGia.add(btnThem);
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnLuu = new JButton("Hủy");
		btnLuu.setBounds(897, 148, 138, 41);
		pnThongTinDocGia.add(btnLuu);
		btnLuu.setIcon(new ImageIcon("icon\\del.png"));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setBounds(897, 201, 138, 41);
		pnThongTinDocGia.add(btnXoa);
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(897, 93, 138, 41);
		pnThongTinDocGia.add(btnSua);
	}
	

}
