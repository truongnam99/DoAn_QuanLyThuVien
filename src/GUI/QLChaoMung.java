package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLChaoMung {

	private JPanel pnTongQuanQLChaoMung;

	static QLChaoMung instance=null;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtChucVu;
	private JTextField txtTenTaiKhoan;
	private JTextField txtMatKhau;
	private JTextField txtDoiMatKhau;
	private JTextField txtDoiMatKhauMoi;
	private JTextField txtNhapLaiMatKhauMoi;
	
	public QLChaoMung() {
		initialize();
	}
	
	public static QLChaoMung getInstance() {
		if(instance == null)
			instance = new QLChaoMung();
		return instance;
	}
	
	public JPanel getPnTongQuanQLChaoMung() {
		return pnTongQuanQLChaoMung;
	}
	private void initialize() {
		
		
		pnTongQuanQLChaoMung = new JPanel();
		pnTongQuanQLChaoMung.setBounds(0, 0, 1065, 560);
		pnTongQuanQLChaoMung.setLayout(null);
		
		JPanel pnTieuDeTTCN = new JPanel();
		pnTieuDeTTCN.setBackground(SystemColor.activeCaption);
		pnTieuDeTTCN.setBounds(0, 0, 1065, 87);
		pnTongQuanQLChaoMung.add(pnTieuDeTTCN);
		pnTieuDeTTCN.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ THÔNG TIN CÁ NHÂN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(348, 11, 391, 57);
		pnTieuDeTTCN.add(lblNewLabel);
		
		JPanel pnThongTinCaNhan = new JPanel();
		pnThongTinCaNhan.setBackground(SystemColor.activeCaption);
		pnThongTinCaNhan.setBounds(0, 90, 1065, 210);
		pnTongQuanQLChaoMung.add(pnThongTinCaNhan);
		pnThongTinCaNhan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("THÔNG TIN CÁ NHÂN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 5, 226, 34);
		pnThongTinCaNhan.add(lblNewLabel_1);
		
		JPanel pnQLTTCN = new JPanel();
		pnQLTTCN.setBounds(10, 35, 1045, 164);
		pnThongTinCaNhan.add(pnQLTTCN);
		pnQLTTCN.setLayout(null);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaNhanVien.setBounds(35, 22, 90, 14);
		pnQLTTCN.add(lblMaNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên:");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenNhanVien.setBounds(35, 75, 90, 14);
		pnQLTTCN.add(lblTenNhanVien);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblChucVu.setBounds(35, 128, 90, 14);
		pnQLTTCN.add(lblChucVu);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(135, 17, 258, 31);
		pnQLTTCN.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(135, 70, 258, 31);
		pnQLTTCN.add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);
		
		txtChucVu = new JTextField();
		txtChucVu.setBounds(135, 117, 258, 36);
		pnQLTTCN.add(txtChucVu);
		txtChucVu.setColumns(10);
		
		JLabel lblTenTaiKhoan = new JLabel("Tên tài khoản:");
		lblTenTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenTaiKhoan.setBounds(562, 22, 103, 14);
		pnQLTTCN.add(lblTenTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMatKhau.setBounds(562, 75, 103, 14);
		pnQLTTCN.add(lblMatKhau);
		
		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setBounds(675, 17, 258, 31);
		pnQLTTCN.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(10);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setBounds(675, 70, 258, 31);
		pnQLTTCN.add(txtMatKhau);
		txtMatKhau.setColumns(10);
		
		JPanel pnDoiMatKhau = new JPanel();
		pnDoiMatKhau.setBackground(SystemColor.activeCaption);
		pnDoiMatKhau.setBounds(0, 303, 1065, 257);
		pnTongQuanQLChaoMung.add(pnDoiMatKhau);
		pnDoiMatKhau.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_7.setIcon(new ImageIcon("icon\\changpass.png"));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(10, 5, 174, 24);
		pnDoiMatKhau.add(lblNewLabel_7);
		
		JPanel pnQLDoiMatKhau = new JPanel();
		pnQLDoiMatKhau.setBounds(10, 40, 1045, 206);
		pnDoiMatKhau.add(pnQLDoiMatKhau);
		pnQLDoiMatKhau.setLayout(null);
		
		JLabel lblDoiMatKhau = new JLabel("Mật khẩu:");
		lblDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDoiMatKhau.setBounds(289, 27, 109, 14);
		pnQLDoiMatKhau.add(lblDoiMatKhau);
		
		JLabel lblDoiMatKhauMoi = new JLabel("Mật khẩu mới:");
		lblDoiMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDoiMatKhauMoi.setBounds(289, 71, 123, 14);
		pnQLDoiMatKhau.add(lblDoiMatKhauMoi);
		
		JLabel lblNhapLaiMatKhauMoi = new JLabel("Nhập lại mật khẩu mới:");
		lblNhapLaiMatKhauMoi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNhapLaiMatKhauMoi.setBounds(289, 116, 137, 14);
		pnQLDoiMatKhau.add(lblNhapLaiMatKhauMoi);
		
		txtDoiMatKhau = new JTextField();
		txtDoiMatKhau.setBounds(436, 19, 258, 31);
		pnQLDoiMatKhau.add(txtDoiMatKhau);
		txtDoiMatKhau.setColumns(10);
		
		txtDoiMatKhauMoi = new JTextField();
		txtDoiMatKhauMoi.setBounds(436, 63, 258, 31);
		pnQLDoiMatKhau.add(txtDoiMatKhauMoi);
		txtDoiMatKhauMoi.setColumns(10);
		
		txtNhapLaiMatKhauMoi = new JTextField();
		txtNhapLaiMatKhauMoi.setBounds(436, 108, 258, 31);
		pnQLDoiMatKhau.add(txtNhapLaiMatKhauMoi);
		txtNhapLaiMatKhauMoi.setColumns(10);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("icon\\save.png"));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLuu.setBounds(289, 154, 138, 41);
		pnQLDoiMatKhau.add(btnLuu);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(556, 154, 138, 41);
		pnQLDoiMatKhau.add(btnHuy);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChuGUI.getInstance().getFrmTrangChu().setVisible(false);
				QLDangNhapGUI.getInstance().getFrame().setVisible(true);
			}
		});
		btnDangXuat.setIcon(new ImageIcon("icon\\logout.png"));
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDangXuat.setBounds(867, 156, 168, 41);
		pnQLDoiMatKhau.add(btnDangXuat);
	}
}
