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
	private JTextField txtTimKiem;
	private QLMuonTraGUI() {
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbMuonTra.setModel(QLMuonTraBLL.getInstance().getResources());
		tbMuonTra.getColumn("TRẢ SÁCH").setCellRenderer(new ButtonRenderer());
		tbMuonTra.getColumn("TRẢ SÁCH").setCellEditor(new  ButtonEditor(new JCheckBox()));
	}
	
	private void refreshDataTable() {
		
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
		return txtTimKiem;
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
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTimKiem.setBounds(559, 5, 337,30);
		pnDanhSachMuon.add(txtTimKiem);
		
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
				if(txtTimKiem.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập từ khóa cần tìm!","Thông báo",1);
				else
				{
					String sql1="select *from muontra where maDocGia like'%"+txtTimKiem.getText()+"%'or hoTen like'%%'";
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
		        	if (col == 7) {
		        		MuonTraDTO item  = new MuonTraDTO();
		        		//item.setMaDocGia(tbMuonTra.getValueAt(row, 2).toString());
		        		//item.setMaSach(tbMuonTra.getValueAt(row, 3).toString());
		        		item.setNgayMuon(Date.valueOf(tbMuonTra.getValueAt(row, 4).toString()));
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
				
			}
		});
		pnThongTinMuonTra.add(btnThem);
		
		JButton btnSua = new JButton();
		btnSua.setText("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(910,95,138,41);
		pnThongTinMuonTra.add(btnSua);
		
		JButton btnTra = new JButton();
		btnTra.setText("Trả");
		btnTra.setIcon(new ImageIcon("icon\\reset.png"));
		btnTra.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTra.setBounds(910,204,138,41);
		pnThongTinMuonTra.add(btnTra);
		
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 37, 862, 208);
		pnThongTinMuonTra.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ và tên:");
		lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHoTen.setBounds(21, 21, 114, 26);
		pnThongTinNhap.add(lblHoTen);
		
		JLabel lblMaDocGia = new JLabel("Mã độc giả:");
		lblMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaDocGia.setBounds(21, 66, 114, 26);
		pnThongTinNhap.add(lblMaDocGia);
		
		JLabel lblLoaiDocGia = new JLabel("Loại độc giả:");
		lblLoaiDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLoaiDocGia.setBounds(21, 112, 114, 26);
		pnThongTinNhap.add(lblLoaiDocGia);
		
		JLabel lblTenSach = new JLabel("Tên sách:");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenSach.setBounds(464, 21, 87, 26);
		pnThongTinNhap.add(lblTenSach);
		
		JLabel lblMaSach = new JLabel("Mã sách:");
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaSach.setBounds(464, 66, 87, 26);
		pnThongTinNhap.add(lblMaSach);
		
		JLabel lblNgayMuon = new JLabel("Ngày mượn:");
		lblNgayMuon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayMuon.setBounds(464, 112, 87, 26);
		pnThongTinNhap.add(lblNgayMuon);
		
		JLabel lblNgayTra = new JLabel("Ngày trả:");
		lblNgayTra.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayTra.setBounds(464, 160, 87, 26);
		pnThongTinNhap.add(lblNgayTra);
		
		JLabel lblLopChuyenMon = new JLabel("Lớp/Chuyên môn:");
		lblLopChuyenMon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLopChuyenMon.setBounds(21, 160, 114, 26);
		pnThongTinNhap.add(lblLopChuyenMon);
		
		JTextField txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtHoTen.setBounds(146, 21, 258, 30);
		pnThongTinNhap.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JTextField txtMaDocGia = new JTextField();
		txtMaDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaDocGia.setBounds(146, 68, 258, 30);
		pnThongTinNhap.add(txtMaDocGia);
		txtMaDocGia.setColumns(10);
		
		JTextField txtLopChuyenMon = new JTextField();
		txtLopChuyenMon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtLopChuyenMon.setBounds(146, 160, 258, 30);
		pnThongTinNhap.add(txtLopChuyenMon);
		txtLopChuyenMon.setColumns(10);
		
		JTextField txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTenSach.setBounds(561, 21, 274, 30);
		pnThongTinNhap.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JTextField txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaSach.setBounds(561, 68, 274, 30);
		pnThongTinNhap.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JTextField txtNgayMuon = new JTextField();
		txtNgayMuon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNgayMuon.setBounds(561, 114, 274, 30);
		pnThongTinNhap.add(txtNgayMuon);
		txtNgayMuon.setColumns(10);
		
		JTextField txtNgayTra = new JTextField();
		txtNgayTra.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNgayTra.setBounds(561, 160, 274, 30);
		pnThongTinNhap.add(txtNgayTra);
		txtNgayTra.setColumns(10);
		
		JTextField txtLoaiDocGia = new JTextField();
		txtLoaiDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtLoaiDocGia.setBounds(146, 114, 258, 30);
		pnThongTinNhap.add(txtLoaiDocGia);
		txtLoaiDocGia.setColumns(10);
		
		JButton btnHuy = new JButton();
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setText("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(910, 150, 138, 41);
		pnThongTinMuonTra.add(btnHuy);
	}
}
