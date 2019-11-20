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


public class QLHeThongGUI {
	private JTextField txtfSoSachMuonHS;
	private JTextField txtfThoiGianMuonHocSinh;
	private JTextField txtfTienPhatHS;
	private JTextField txtfSoSachMuonGV;
	private JTextField txtfThoiGianMuonGV;
	private JTextField textField_5;
	private JPanel pnTongQuanQLQuyDinh;
	
	static QLHeThongGUI instance=null;
	private JTextField txtSachHongHS;
	private JTextField txtMatSachHS;
	private JTextField textField;
	private JTextField textField_1;
	
	private QLHeThongGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		
	}
	
	private void refreshDataTable() {
		
	}
	
	public static QLHeThongGUI getInstance() {
		if(instance == null)
			instance = new QLHeThongGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLHeThong() {
		return pnTongQuanQLQuyDinh;
	}
	private void initialize() {
		
		pnTongQuanQLQuyDinh = new JPanel();
		pnTongQuanQLQuyDinh.setBackground(SystemColor.inactiveCaptionBorder);
		pnTongQuanQLQuyDinh.setBounds(0, 0, 1065, 560);
		pnTongQuanQLQuyDinh.setLayout(null);
		
		JPanel pnTieuDeQuyDinh = new JPanel();
		pnTieuDeQuyDinh.setBackground(SystemColor.activeCaption);
		pnTieuDeQuyDinh.setBounds(0, 0, 1065, 46);
		pnTongQuanQLQuyDinh.add(pnTieuDeQuyDinh);
		pnTieuDeQuyDinh.setLayout(null);
		
		JLabel lblQuyDinh = new JLabel("QU\u1EA2N L\u00DD QUY \u0110\u1ECANH");
		lblQuyDinh.setForeground(Color.RED);
		lblQuyDinh.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQuyDinh.setBounds(435, 5, 236, 35);
		pnTieuDeQuyDinh.add(lblQuyDinh);
		
		JPanel pnThongTinQuyDinh = new JPanel();
		pnThongTinQuyDinh.setBackground(SystemColor.activeCaption);
		pnThongTinQuyDinh.setBounds(0, 49, 1065, 511);
		pnTongQuanQLQuyDinh.add(pnThongTinQuyDinh);
		pnThongTinQuyDinh.setLayout(null);
		
		JLabel lblThongTinQuyDinh = new JLabel("TH\u00D4NG TIN QUY \u0110\u1ECANH");
		lblThongTinQuyDinh.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblThongTinQuyDinh.setBounds(5, 5, 219, 22);
		pnThongTinQuyDinh.add(lblThongTinQuyDinh);
		
		JPanel pnHocSinh = new JPanel();
		pnHocSinh.setBounds(82, 46, 396, 336);
		pnThongTinQuyDinh.add(pnHocSinh);
		pnHocSinh.setLayout(null);
		
		JLabel lblHocSinh = new JLabel("H\u1ECDc sinh");
		lblHocSinh.setBounds(5, 0, 59, 23);
		pnHocSinh.add(lblHocSinh);
		lblHocSinh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JPanel pnThongTinHocSinh = new JPanel();
		pnThongTinHocSinh.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinHocSinh.setBounds(0, 22, 396, 314);
		pnHocSinh.add(pnThongTinHocSinh);
		pnThongTinHocSinh.setLayout(null);
		
		JLabel lblSoSachMuonHS = new JLabel("S\u1ED1 s\u00E1ch m\u01B0\u1EE3n t\u1ED1i \u0111a:");
		lblSoSachMuonHS.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSoSachMuonHS.setBounds(10, 41, 144, 14);
		pnThongTinHocSinh.add(lblSoSachMuonHS);
		
		txtfSoSachMuonHS = new JTextField();
		txtfSoSachMuonHS.setBounds(181, 33, 205, 30);
		pnThongTinHocSinh.add(txtfSoSachMuonHS);
		txtfSoSachMuonHS.setColumns(10);
		
		JLabel lblThoiGianMuonHS = new JLabel("Th\u1EDDi gian m\u01B0\u1EE3n t\u1ED1i \u0111a:");
		lblThoiGianMuonHS.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblThoiGianMuonHS.setBounds(10, 99, 144, 14);
		pnThongTinHocSinh.add(lblThoiGianMuonHS);
		
		txtfThoiGianMuonHocSinh = new JTextField();
		txtfThoiGianMuonHocSinh.setBounds(181, 91, 205, 30);
		pnThongTinHocSinh.add(txtfThoiGianMuonHocSinh);
		txtfThoiGianMuonHocSinh.setColumns(10);
		
		JLabel lblTienPhatHS = new JLabel("Tiền phạt mượn trễ:");
		lblTienPhatHS.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTienPhatHS.setBounds(10, 158, 144, 14);
		pnThongTinHocSinh.add(lblTienPhatHS);
		
		txtfTienPhatHS = new JTextField();
		txtfTienPhatHS.setBounds(181, 150, 205, 30);
		pnThongTinHocSinh.add(txtfTienPhatHS);
		txtfTienPhatHS.setColumns(10);
		
		JLabel lblSachHongHS = new JLabel("Sách bị hư hỏng:");
		lblSachHongHS.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSachHongHS.setBounds(10, 219, 122, 14);
		pnThongTinHocSinh.add(lblSachHongHS);
		
		JLabel lblMatSachHS = new JLabel("Mất sách:");
		lblMatSachHS.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMatSachHS.setBounds(10, 280, 122, 14);
		pnThongTinHocSinh.add(lblMatSachHS);
		
		txtSachHongHS = new JTextField();
		txtSachHongHS.setBounds(181, 211, 205, 30);
		pnThongTinHocSinh.add(txtSachHongHS);
		txtSachHongHS.setColumns(10);
		
		txtMatSachHS = new JTextField();
		txtMatSachHS.setBounds(181, 272, 205, 30);
		pnThongTinHocSinh.add(txtMatSachHS);
		txtMatSachHS.setColumns(10);
		
		JPanel pnGiaoVien = new JPanel();
		pnGiaoVien.setBounds(596, 46, 392, 336);
		pnThongTinQuyDinh.add(pnGiaoVien);
		pnGiaoVien.setLayout(null);
		
		JLabel lblGiaoVien = new JLabel("Gi\u00E1o vi\u00EAn");
		lblGiaoVien.setBounds(5, 0, 76, 22);
		pnGiaoVien.add(lblGiaoVien);
		lblGiaoVien.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JPanel pnThongTinGiaoVien = new JPanel();
		pnThongTinGiaoVien.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinGiaoVien.setBounds(0, 24, 392, 312);
		pnGiaoVien.add(pnThongTinGiaoVien);
		pnThongTinGiaoVien.setLayout(null);
		
		JLabel lblSoSachMuonGV = new JLabel("S\u1ED1 s\u00E1ch m\u01B0\u1EE3n t\u1ED1i \u0111a:");
		lblSoSachMuonGV.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSoSachMuonGV.setBounds(10, 42, 144, 14);
		pnThongTinGiaoVien.add(lblSoSachMuonGV);
		
		txtfSoSachMuonGV = new JTextField();
		txtfSoSachMuonGV.setColumns(10);
		txtfSoSachMuonGV.setBounds(178, 33, 205, 30);
		pnThongTinGiaoVien.add(txtfSoSachMuonGV);
		
		JLabel lblThoiGianMuonGV = new JLabel("Th\u1EDDi gian m\u01B0\u1EE3n t\u1ED1i \u0111a:");
		lblThoiGianMuonGV.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblThoiGianMuonGV.setBounds(10, 99, 144, 14);
		pnThongTinGiaoVien.add(lblThoiGianMuonGV);
		
		txtfThoiGianMuonGV = new JTextField();
		txtfThoiGianMuonGV.setColumns(10);
		txtfThoiGianMuonGV.setBounds(178, 91, 205, 30);
		pnThongTinGiaoVien.add(txtfThoiGianMuonGV);
		
		JLabel lblTienPhatGV = new JLabel("Tiền phạt mượn trễ:");
		lblTienPhatGV.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTienPhatGV.setBounds(10, 158, 127, 14);
		pnThongTinGiaoVien.add(lblTienPhatGV);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(178, 150, 205, 30);
		pnThongTinGiaoVien.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("Sách bị hư hỏng:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 219, 127, 14);
		pnThongTinGiaoVien.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(178, 211, 205, 30);
		pnThongTinGiaoVien.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mất sách:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 280, 108, 14);
		pnThongTinGiaoVien.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 272, 205, 30);
		pnThongTinGiaoVien.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.setBounds(223, 426, 139, 41);
		pnThongTinQuyDinh.add(btnLuu);
		btnLuu.setIcon(new ImageIcon("icon\\save.png"));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setBounds(725, 426, 139, 41);
		pnThongTinQuyDinh.add(btnSua);
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}
}
