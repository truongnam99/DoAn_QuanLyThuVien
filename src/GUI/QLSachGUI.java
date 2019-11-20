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
import BLL.QLSachBLL;



public class QLSachGUI {
	private JTable tbQLSach;
	private JTextField txtfMaSach;
	private JTextField txtfTenSach;
	private JTextField txtfTacGia;
	private JTextField txtfTheLoai;
	private JTextField txtfNhaXuatBan;
	private JTextField txtfNamXuatBan;
	private JTextField txtfNgayNhap;
	private JTextField txtfTriGia;
	private JPanel pnTongQuanQLSach;
	
	static QLSachGUI instance=null;
	
	private QLSachGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbQLSach.setModel(QLSachBLL.getInstance().getResources());
	}
	
	private void refreshDataTable() {
		
	}
	
	public static QLSachGUI getInstance() {
		if(instance == null)
			instance = new QLSachGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLSach() {
		return pnTongQuanQLSach;
	}
	private void initialize() {
		
		pnTongQuanQLSach = new JPanel();
		pnTongQuanQLSach.setBackground(SystemColor.activeCaption);
		pnTongQuanQLSach.setBounds(0, 0, 1065, 560);
		pnTongQuanQLSach.setLayout(null);
		
		JPanel pnTieuDeQLSach = new JPanel();
		pnTieuDeQLSach.setBackground(SystemColor.activeCaption);
		pnTieuDeQLSach.setBounds(0, 0, 1065, 48);
		pnTongQuanQLSach.add(pnTieuDeQLSach);
		pnTieuDeQLSach.setLayout(null);
		
		JLabel lblQLSach = new JLabel("QU\u1EA2N L\u00DD S\u00C1CH");
		lblQLSach.setForeground(Color.RED);
		lblQLSach.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLSach.setBounds(448, 11, 219, 35);
		pnTieuDeQLSach.add(lblQLSach);
		
		JPanel pnQLSach = new JPanel();
		pnQLSach.setBounds(0, 52, 1065, 230);
		pnTongQuanQLSach.add(pnQLSach);
		pnQLSach.setLayout(new BorderLayout());
		
		tbQLSach = new JTable();
		tbQLSach.setBounds(0, 0, 1060, 167);
		JScrollPane sc = new JScrollPane(tbQLSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1078, 197);
		pnQLSach.add(sc,BorderLayout.CENTER);
		
		
		JPanel pnThongTinSach = new JPanel();
		pnThongTinSach.setBackground(SystemColor.activeCaption);
		pnThongTinSach.setBounds(0, 293, 1065, 267);
		pnTongQuanQLSach.add(pnThongTinSach);
		pnThongTinSach.setLayout(null);
		
		JLabel lblThongTinSach = new JLabel("THÔNG TIN SÁCH");
		lblThongTinSach.setBounds(10, 5, 178, 28);
		pnThongTinSach.add(lblThongTinSach);
		lblThongTinSach.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 32, 855, 223);
		pnThongTinSach.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblMaSach = new JLabel("Mã sách:");
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaSach.setBounds(29, 27, 66, 14);
		pnThongTinNhap.add(lblMaSach);
		
		txtfMaSach = new JTextField();
		txtfMaSach.setBounds(120, 18, 258, 32);
		pnThongTinNhap.add(txtfMaSach);
		txtfMaSach.setColumns(10);
		
		JLabel lblTenSach = new JLabel("Tên sách:");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenSach.setBounds(29, 69, 66, 14);
		pnThongTinNhap.add(lblTenSach);
		
		txtfTenSach = new JTextField();
		txtfTenSach.setBounds(120, 61, 258, 31);
		pnThongTinNhap.add(txtfTenSach);
		txtfTenSach.setColumns(10);
		
		JLabel lblTacGia = new JLabel("Tác giả:");
		lblTacGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTacGia.setBounds(29, 111, 66, 14);
		pnThongTinNhap.add(lblTacGia);
		
		txtfTacGia = new JTextField();
		txtfTacGia.setBounds(120, 103, 258, 31);
		pnThongTinNhap.add(txtfTacGia);
		txtfTacGia.setColumns(10);
		
		JLabel lblTheLoai = new JLabel("Thể loại:");
		lblTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTheLoai.setBounds(29, 153, 66, 14);
		pnThongTinNhap.add(lblTheLoai);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng:");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTinhTrang.setBounds(29, 195, 74, 14);
		pnThongTinNhap.add(lblTinhTrang);
		
		txtfTheLoai = new JTextField();
		txtfTheLoai.setBounds(120, 145, 258, 31);
		pnThongTinNhap.add(txtfTheLoai);
		txtfTheLoai.setColumns(10);
		
		JRadioButton rdbtnTrong = new JRadioButton("Trống");
		rdbtnTrong.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnTrong.setBounds(120, 191, 57, 23);
		pnThongTinNhap.add(rdbtnTrong);
		
		JRadioButton rdbtnDangMuon = new JRadioButton("Đang mượn");
		rdbtnDangMuon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnDangMuon.setBounds(236, 191, 96, 23);
		pnThongTinNhap.add(rdbtnDangMuon);
		
		JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản:");
		lblNhaXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNhaXuatBan.setBounds(459, 27, 74, 14);
		pnThongTinNhap.add(lblNhaXuatBan);
		
		txtfNhaXuatBan = new JTextField();
		txtfNhaXuatBan.setBounds(556, 18, 258, 31);
		pnThongTinNhap.add(txtfNhaXuatBan);
		txtfNhaXuatBan.setColumns(10);
		
		JLabel lblNamXuatBan = new JLabel("Năm xuất bản:");
		lblNamXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNamXuatBan.setBounds(460, 69, 86, 14);
		pnThongTinNhap.add(lblNamXuatBan);
		
		txtfNamXuatBan = new JTextField();
		txtfNamXuatBan.setBounds(556, 60, 258, 31);
		pnThongTinNhap.add(txtfNamXuatBan);
		txtfNamXuatBan.setColumns(10);
		
		JLabel lblNgayNhap = new JLabel("Ngày nhập:");
		lblNgayNhap.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayNhap.setBounds(460, 111, 66, 14);
		pnThongTinNhap.add(lblNgayNhap);
		
		txtfNgayNhap = new JTextField();
		txtfNgayNhap.setBounds(556, 102, 258, 31);
		pnThongTinNhap.add(txtfNgayNhap);
		txtfNgayNhap.setColumns(10);
		
		JLabel lblTriGia = new JLabel("Giá sách:");
		lblTriGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTriGia.setBounds(460, 153, 73, 14);
		pnThongTinNhap.add(lblTriGia);
		
		txtfTriGia = new JTextField();
		txtfTriGia.setBounds(556, 144, 258, 31);
		pnThongTinNhap.add(txtfTriGia);
		txtfTriGia.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(902, 32, 138, 41);
		pnThongTinSach.add(btnThem);
		
		JButton btnSua = new JButton("Sửa\r\n");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(902, 93, 138, 41);
		pnThongTinSach.add(btnSua);
		
		JButton btnLuu = new JButton("Hủy");
		btnLuu.setIcon(new ImageIcon("icon\\del.png"));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLuu.setBounds(902, 154, 138, 41);
		pnThongTinSach.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(902, 214, 138, 41);
		pnThongTinSach.add(btnXoa);
	}
}
