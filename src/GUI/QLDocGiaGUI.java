package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BLL.QLDocGiaBLL;
import DTO.DocGiaDTO;
import DTO.LoaiDocGiaDTO;

import javax.swing.SwingConstants;

public class QLDocGiaGUI {
	static QLDocGiaGUI instance = null;
	private JPanel pnMain;
	private JTable tbDocGia;
	private JTextField txtHoTen;
	
	private QLDocGiaGUI() {
		initialize();
		loadResources();
	}

	private void loadResources() {
		tbDocGia.setModel(QLDocGiaBLL.getInstance().getResources());
	}
	
	private void refreshData() {
		
	}

	public static QLDocGiaGUI getInstance() {
		if (instance == null)
			instance = new QLDocGiaGUI();
		return instance;
	}
	
	public JPanel getPnMain() {
		return pnMain;
	}
	
	@SuppressWarnings("deprecation")
	private void initialize() {
		pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBounds(0, 0, 1065, 560);
		pnMain.setBackground(Color.WHITE);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(null);
		pnTitle.setBackground(SystemColor.activeCaption);
		pnTitle.setBounds(0, 0, 1078, 71);
		pnMain.add(pnTitle);
		
		JPanel pnDanhSachDocGia = new JPanel();
		pnDanhSachDocGia.setLayout(null);
		pnDanhSachDocGia.setBackground(SystemColor.activeCaption);
		pnDanhSachDocGia.setBounds(0, 71, 1065, 230);
		pnMain.add(pnDanhSachDocGia);
		
		JPanel pnThongTinDocGia = new JPanel();
		pnThongTinDocGia.setLayout(null);
		pnThongTinDocGia.setBackground(SystemColor.activeCaption);
		pnThongTinDocGia.setBounds(0, 302, 1065, 256);
		pnMain.add(pnThongTinDocGia);
		
		//add control
		//control of Title
		JLabel lblTitle = new JLabel("QUẢN LÝ ĐỘC GIẢ");
		lblTitle.setForeground(Color.RED);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTitle.setBounds(419, 11, 239, 39);
		pnTitle.add(lblTitle);
		
		//control cho danh sach
		tbDocGia = new JTable();
		tbDocGia.setBounds(0, 0, 1065, 256);
		JScrollPane sc = new JScrollPane(tbDocGia, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1065, 230);
		pnDanhSachDocGia.add(sc,BorderLayout.CENTER);
		
		JLabel lblThongTinDocGia = new JLabel("THÔNG TIN ĐỘC GIẢ");
		lblThongTinDocGia.setBounds(10, 0, 186, 28);
		pnThongTinDocGia.add(lblThongTinDocGia);
		lblThongTinDocGia.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setFocusTraversalKeysEnabled(false);
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 39, 860, 208);
		pnThongTinDocGia.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ Tên:");
		lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHoTen.setBounds(10, 34, 89, 26);
		pnThongTinNhap.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(109, 32, 258, 30);
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnThongTinNhap.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblMaDocGia = new JLabel("Mã độc giả:");
		lblMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaDocGia.setBounds(10, 83, 89, 26);
		pnThongTinNhap.add(lblMaDocGia);
		
		JTextField txtMaDocGia = new JTextField();
		txtMaDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaDocGia.setBounds(109, 87, 258, 30);
		pnThongTinNhap.add(txtMaDocGia);
		txtMaDocGia.setColumns(10);
		
		JLabel lblLoaiDocGia = new JLabel("Loại độc giả:");
		lblLoaiDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLoaiDocGia.setBounds(10, 138, 89, 26);
		pnThongTinNhap.add(lblLoaiDocGia);
		
		JComboBox<LoaiDocGiaDTO> cbbLoaiDocGia = new JComboBox<LoaiDocGiaDTO>();
		cbbLoaiDocGia.setBounds(109, 141, 258, 30);
		pnThongTinNhap.add(cbbLoaiDocGia);
		
//		JTextField txtLoaiDocGia = new JTextField();
//		txtLoaiDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		txtLoaiDocGia.setBounds(109, 141, 258, 30);
//		pnThongTinNhap.add(txtLoaiDocGia);
//		txtLoaiDocGia.setColumns(10);
		
		JLabel lblLopChuyenMon = new JLabel("Lớp/Chuyên môn:");
		lblLopChuyenMon.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLopChuyenMon.setBounds(428, 34, 133, 26);
		pnThongTinNhap.add(lblLopChuyenMon);
		
		JTextField txtLopChuyenMon = new JTextField();
		txtLopChuyenMon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtLopChuyenMon.setBounds(564, 32, 258, 30);
		pnThongTinNhap.add(txtLopChuyenMon);
		txtLopChuyenMon.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgaySinh.setBounds(428, 83, 113, 26);
		pnThongTinNhap.add(lblNgaySinh);
		
		JTextField txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNgaySinh.setBounds(564, 87, 258, 30);
		pnThongTinNhap.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSDT.setBounds(428, 138, 119, 26);
		pnThongTinNhap.add(lblSDT);
		
		JTextField txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman",Font.PLAIN, 15));
		txtSDT.setBounds(564, 141, 258, 30);
		pnThongTinNhap.add(txtSDT);
		txtSDT.setColumns(10);
		
		
		
		//Cac chuc nang them sua xoa
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		ImageIcon add = null;
		
		
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(911, 39, 138, 41);
		pnThongTinDocGia.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
//				
//				DocGiaDTO docGia = new DocGiaDTO(txtMaDocGia.getText(), txtHoTen.getText(), txtLoaiDocGia.getText(),
//						txtLopChuyenMon.getText(), Date.valueOf(txtNgaySinh.getText()),txtSDT.getText());
//	
//				
//				
//				String result = QLDocGiaBLL.getInstance().insert(docGia);
//				System.out.println(result);
//				Object[] rowData = {((DefaultTableModel) tbDocGia.getModel()).getRowCount() + 1, txtMaDocGia.getText(), txtHoTen.getText(), txtLoaiDocGia.getText()};
//				((DefaultTableModel) tbDocGia.getModel()).addRow(rowData);
				//hiển thị kết quả thêm vào
				
				
				
				refreshData();
			}
		});
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(911, 150, 138, 41);
		pnThongTinDocGia.add(btnHuy);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(911, 94, 138, 41);
		pnThongTinDocGia.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(911, 206, 138, 41);
		pnThongTinDocGia.add(btnXoa);
		
		//set tab key
		txtHoTen.setNextFocusableComponent(txtMaDocGia);
		txtMaDocGia.setNextFocusableComponent(cbbLoaiDocGia);
		cbbLoaiDocGia.setNextFocusableComponent(txtLopChuyenMon);
		txtLopChuyenMon.setNextFocusableComponent(txtNgaySinh);
		txtNgaySinh.setNextFocusableComponent(txtSDT);
		txtSDT.setNextFocusableComponent(btnThem);
		btnThem.setNextFocusableComponent(btnHuy);
		btnHuy.setNextFocusableComponent(btnXoa);
		btnXoa.setNextFocusableComponent(btnSua);
		btnSua.setNextFocusableComponent(txtHoTen);
	}
}