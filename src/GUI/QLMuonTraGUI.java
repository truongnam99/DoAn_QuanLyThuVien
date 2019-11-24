package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BLL.QLDocGiaBLL;
import BLL.QLMuonTraBLL;
import CustomControl.ButtonEditor;
import CustomControl.ButtonRenderer;
import DTO.MuonTraDTO;

public class QLMuonTraGUI {

	static QLMuonTraGUI instance = null;
	private JPanel pnMain;
	private JTable tbMuonTra;
	private JTextField tfTimKiem;
	private JTextField tfHoTen;
	private JTextField tfMaDocGia;
	private JTextField tfLopChuyenMon;
	private JTextField tfTenSach;
	private JTextField tfMaSach;
	private JTextField tfNgayMuon;
	private JTextField tfNgayTra;
	private JTextField tfLoaiDocGia;
	private JLabel lblMessage;
	private QLMuonTraGUI() {
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbMuonTra.setModel(QLMuonTraBLL.getInstance().getResources());
		tbMuonTra.getColumn("Trả sách").setCellRenderer(new ButtonRenderer());
		tbMuonTra.getColumn("Trả sách").setCellEditor(new  ButtonEditor(new JCheckBox()));
	}
	
	public static QLMuonTraGUI getInstance() {
		if (instance == null)
			instance = new QLMuonTraGUI();
		return instance;
	}
	
	public JPanel getPnMain() {
		return pnMain;
	}
	public JTextField getText() {
		return tfTimKiem;
	}
	private void initialize() {
		pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 0, 1065, 560);
		pnMain.setBackground(Color.WHITE);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(null);
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.setBounds(0, 0, 1065, 51);
		pnMain.add(pnTitle);
		
		JPanel pnDanhSachMuon = new JPanel();
		pnDanhSachMuon.setLayout(null);
		pnDanhSachMuon.setBackground(SystemColor.activeCaption);
		pnDanhSachMuon.setBounds(0, 51, 1065, 256);
		pnMain.add(pnDanhSachMuon);
		
		JPanel pnThongTinMuonTra = new JPanel();
		pnThongTinMuonTra.setLayout(null);
		pnThongTinMuonTra.setBackground(SystemColor.activeCaption);
		pnThongTinMuonTra.setBounds(0, 304, 1065, 256);
		pnMain.add(pnThongTinMuonTra);
		
		//them tieu de
		JLabel lblTitle = new JLabel("QUẢN LÝ MƯỢN TRẢ SÁCH");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTitle.setBounds(349, 11, 377, 39);
		pnTitle.add(lblTitle);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfTimKiem.setBounds(559, 5, 337,30);
		pnDanhSachMuon.add(tfTimKiem);
		
		JButton btnTimKiem = new JButton();
		btnTimKiem.setIcon(new ImageIcon("icon\\find.png"));
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTimKiem.setBounds(919, 4, 134, 35);
		pnDanhSachMuon.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfTimKiem.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập từ khóa cần tìm!","Thông báo",1);
				else
				{
					//String sql1="select *from muontra where maDocGia like'%"+tfTimKiem.getText()+"%'or hoTen like'%%'";
				}
			}
		});
		
		tbMuonTra = new JTable();
		tbMuonTra.setBounds(0, 0, 1060, 230);
		JScrollPane sc = new JScrollPane(tbMuonTra, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 44, 1065, 212);
		tbMuonTra.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = tbMuonTra.rowAtPoint(evt.getPoint());
		        int col = tbMuonTra.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	if (col == 8) {
		        		String msg = QLMuonTraBLL.getInstance().traSach(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 1).toString(),
		        				tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 3).toString());
						lblMessage.setText(msg);
						loadResources();
		        	}
		        	else {
		        		// hiển thị thông tin vào trong các trường
		        		tfMaDocGia.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 1).toString());
		        		tfHoTen.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 2).toString());;
		        		tfLopChuyenMon.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 1).toString());;
		        		tfTenSach.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 4).toString());;
		        		tfMaSach.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 3).toString());;
		        		tfNgayMuon.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 5).toString());;
		        		tfNgayTra.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 6).toString());;
		        		tfLoaiDocGia.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 7).toString());;
		        		QLMuonTraBLL.getInstance().muonTra = new MuonTraDTO(tfMaDocGia.getText(), tfMaSach.getText(), Date.valueOf(tfNgayMuon.getText()), Date.valueOf(tfNgayTra.getText()));
		        	}
		        }
		    }
		});
		pnDanhSachMuon.add(sc,BorderLayout.CENTER);
		
		JLabel lblThongTinMuonTra = new JLabel("THÔNG TIN MƯỢN TRẢ");
		lblThongTinMuonTra.setBounds(10, 5, 199, 28);
		pnThongTinMuonTra.add(lblThongTinMuonTra);
		lblThongTinMuonTra.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton btnThem = new JButton();
		btnThem.setText("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(910,39,138,41);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = QLMuonTraBLL.getInstance().addProcessing(tfMaDocGia.getText(), tfMaSach.getText(), tfNgayMuon.getText(), tfNgayTra.getText());;
				lblMessage.setText(msg);
				loadResources();
			}
		});
		pnThongTinMuonTra.add(btnThem);
		
		JButton btnSua = new JButton();
		btnSua.setText("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(910,95,138,41);
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = QLMuonTraBLL.getInstance().changeProcessing(tfMaDocGia.getText(), tfMaSach.getText(), tfNgayMuon.getText(), tfNgayTra.getText());;
				lblMessage.setText(msg);
				loadResources();
			}
		});
		pnThongTinMuonTra.add(btnSua);
				
		JButton btnTra = new JButton();
		btnTra.setText("Trả");
		btnTra.setIcon(new ImageIcon("icon\\reset.png"));
		btnTra.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTra.setBounds(910,204,138,41);
		btnTra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = QLMuonTraBLL.getInstance().traSach(tfMaDocGia.getText(), tfMaSach.getText());
				lblMessage.setText(msg);
				loadResources();
			}
		});
		pnThongTinMuonTra.add(btnTra);
		
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 37, 862, 208);
		pnThongTinMuonTra.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ và tên:");
		lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHoTen.setBounds(21, 92, 114, 26);
		pnThongTinNhap.add(lblHoTen);
		
		JLabel lblMaDocGia = new JLabel("Mã độc giả:*");
		lblMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaDocGia.setBounds(21, 47, 114, 26);
		pnThongTinNhap.add(lblMaDocGia);
		
		JLabel lblLoaiDocGia = new JLabel("Loại độc giả:");
		lblLoaiDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLoaiDocGia.setBounds(21, 129, 114, 26);
		pnThongTinNhap.add(lblLoaiDocGia);
		
		JLabel lblTenSach = new JLabel("Tên sách:");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenSach.setBounds(464, 92, 87, 26);
		pnThongTinNhap.add(lblTenSach);
		
		JLabel lblMaSach = new JLabel("Mã sách:*");
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaSach.setBounds(464, 47, 87, 26);
		pnThongTinNhap.add(lblMaSach);
		
		JLabel lblNgayMuon = new JLabel("Ngày mượn:*");
		lblNgayMuon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayMuon.setBounds(464, 129, 87, 26);
		pnThongTinNhap.add(lblNgayMuon);
		
		JLabel lblNgayTra = new JLabel("Ngày trả:*");
		lblNgayTra.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayTra.setBounds(464, 170, 87, 26);
		pnThongTinNhap.add(lblNgayTra);
		
		JLabel lblLopChuyenMon = new JLabel("Lớp/Chuyên môn:");
		lblLopChuyenMon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLopChuyenMon.setBounds(21, 170, 114, 26);
		pnThongTinNhap.add(lblLopChuyenMon);
		
		tfHoTen= new JTextField();
		tfHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfHoTen.setBounds(145, 85, 258, 30);
		pnThongTinNhap.add(tfHoTen);
		tfHoTen.setColumns(10);
		
		tfMaDocGia = new JTextField();
		tfMaDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfMaDocGia.setBounds(145, 44, 258, 30);
		pnThongTinNhap.add(tfMaDocGia);
		tfMaDocGia.setColumns(10);
		
		tfLopChuyenMon = new JTextField();
		tfLopChuyenMon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfLopChuyenMon.setBounds(145, 167, 258, 30);
		pnThongTinNhap.add(tfLopChuyenMon);
		tfLopChuyenMon.setColumns(10);
		
		tfTenSach = new JTextField();
		tfTenSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfTenSach.setBounds(561, 89, 274, 30);
		pnThongTinNhap.add(tfTenSach);
		tfTenSach.setColumns(10);
		
		tfMaSach = new JTextField();
		tfMaSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfMaSach.setBounds(561, 44, 274, 30);
		pnThongTinNhap.add(tfMaSach);
		tfMaSach.setColumns(10);
		
		tfNgayMuon = new JTextField();
		tfNgayMuon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfNgayMuon.setBounds(561, 126, 274, 30);
		pnThongTinNhap.add(tfNgayMuon);
		tfNgayMuon.setColumns(10);
		
		tfNgayTra = new JTextField();
		tfNgayTra.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfNgayTra.setBounds(561, 167, 274, 30);
		pnThongTinNhap.add(tfNgayTra);
		tfNgayTra.setColumns(10);
		
		tfLoaiDocGia = new JTextField();
		tfLoaiDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfLoaiDocGia.setBounds(145, 126, 258, 30);
		pnThongTinNhap.add(tfLoaiDocGia);
		tfLoaiDocGia.setColumns(10);
		
		lblMessage = new JLabel("(*) Không bỏ trống");
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblMessage.setForeground(Color.red);
		lblMessage.setBounds(145, 11, 690, 25);
		pnThongTinNhap.add(lblMessage);
		
		JButton btnHuy = new JButton();
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setText("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(910, 150, 138, 41);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfHoTen.setText("");
				tfLoaiDocGia.setText("");
				tfLopChuyenMon.setText("");
				tfMaDocGia.setText("");
				tfMaSach.setText("");
				tfNgayMuon.setText("");
				tfNgayTra.setText("");
				tfTenSach.setText("");
				
			}
		});
	
		pnThongTinMuonTra.add(btnHuy);
	}
}
