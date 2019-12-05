package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.toedter.calendar.JDateChooser;

public class QLDocGiaGUI {
	static QLDocGiaGUI instance = null;
	private JPanel pnMain;
	private JTable tbDocGia;
	private JTextField tfHoTen;
	private JTextField tfEmail;
	private JTextField tfSDT;
	private JTextField tfLopChuyenMon;
	private JTextField tfMaDocGia;
	private JComboBox<LoaiDocGiaDTO> cbbLoaiDocGia;
	private JLabel lblMessage;
	private JDateChooser dcNgaySinh;
	
	private boolean isEdit = true;
	
	private QLDocGiaGUI() {
		initialize();
		loadResources();
	}

	private void loadResources() {
		tbDocGia.setModel(QLDocGiaBLL.getInstance().getResources(cbbLoaiDocGia));
	}
	
	public static QLDocGiaGUI getInstance() {
		if (instance == null)
			instance = new QLDocGiaGUI();
		return instance;
	}
	
	public JPanel getPnMain() {
		return pnMain;
	}
			
	public void reloadResources() {
		DefaultTableModel dm = (DefaultTableModel) tbDocGia.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
		tbDocGia.setModel(QLDocGiaBLL.getInstance().reloadResources());
	}
	
	private void setStateForTexfeild() {
		tfMaDocGia.setEditable(isEdit);
	}
	
	private void clearField() {
		tfEmail.setText("");
		tfHoTen.setText("");
		tfLopChuyenMon.setText("");
		tfMaDocGia.setText("");
		dcNgaySinh.setDate(null);
		tfSDT.setText("");
		cbbLoaiDocGia.setSelectedItem(0);
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
		pnDanhSachDocGia.setBounds(0, 71, 1065, 233);
		pnMain.add(pnDanhSachDocGia);
		
		JPanel pnThongTinDocGia = new JPanel();
		pnThongTinDocGia.setLayout(null);
		pnThongTinDocGia.setBackground(SystemColor.activeCaption);
		pnThongTinDocGia.setBounds(0, 304, 1065, 256);
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
		tbDocGia.setBounds(0, 0, 1050, 233);
		JScrollPane sc = new JScrollPane(tbDocGia, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1055, 233);
		tbDocGia.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (tbDocGia.getSelectedRow()< 0)
					return;
				
				isEdit = false;
				setStateForTexfeild();
				tfMaDocGia.setText(tbDocGia.getValueAt(tbDocGia.getSelectedRow(), 1).toString());
				tfHoTen.setText(tbDocGia.getValueAt(tbDocGia.getSelectedRow(), 2).toString());
				
				for (int i = 0; i< cbbLoaiDocGia.getItemCount();i++) {
					if(tbDocGia.getValueAt(tbDocGia.getSelectedRow(), 3).toString().equals(cbbLoaiDocGia.getItemAt(i).toString())) {
						cbbLoaiDocGia.setSelectedItem(cbbLoaiDocGia.getItemAt(i));
					}
				}
				
				tfLopChuyenMon.setText(tbDocGia.getValueAt(tbDocGia.getSelectedRow(), 4).toString());
				dcNgaySinh.setDate(Date.valueOf(tbDocGia.getValueAt(tbDocGia.getSelectedRow(), 5).toString()));
				tfSDT.setText(tbDocGia.getValueAt(tbDocGia.getSelectedRow(), 6).toString());
				tfEmail.setText(tbDocGia.getValueAt(tbDocGia.getSelectedRow(), 7).toString());
			}
			
		});
		pnDanhSachDocGia.add(sc,BorderLayout.CENTER);
		
		JLabel lblThongTinDocGia = new JLabel("THÔNG TIN ĐỘC GIẢ");
		lblThongTinDocGia.setBounds(10, 0, 186, 28);
		pnThongTinDocGia.add(lblThongTinDocGia);
		lblThongTinDocGia.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setFocusTraversalKeysEnabled(false);
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 39, 862, 208);
		pnThongTinDocGia.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ Tên:*");
		lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblHoTen.setBounds(10, 82, 89, 26);
		pnThongTinNhap.add(lblHoTen);
		
		tfHoTen = new JTextField();
		tfHoTen.setBounds(109, 81, 258, 30);
		tfHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnThongTinNhap.add(tfHoTen);
		tfHoTen.setColumns(10);
		
		JLabel lblMaDocGia = new JLabel("Mã độc giả:*");
		lblMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaDocGia.setBounds(10, 39, 89, 26);
		pnThongTinNhap.add(lblMaDocGia);
		
		tfMaDocGia = new JTextField();
		tfMaDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfMaDocGia.setBounds(109, 37, 258, 30);
		pnThongTinNhap.add(tfMaDocGia);
		tfMaDocGia.setColumns(10);
		
		JLabel lblLoaiDocGia = new JLabel("Loại độc giả:*");
		lblLoaiDocGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLoaiDocGia.setBounds(10, 125, 89, 26);
		pnThongTinNhap.add(lblLoaiDocGia);
		
		cbbLoaiDocGia = new JComboBox<LoaiDocGiaDTO>();
		cbbLoaiDocGia.setBounds(109, 125, 258, 30);
		pnThongTinNhap.add(cbbLoaiDocGia);
		
		JLabel lblLopChuyenMon = new JLabel("Lớp/Chuyên môn:*");
		lblLopChuyenMon.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLopChuyenMon.setBounds(428, 39, 133, 26);
		pnThongTinNhap.add(lblLopChuyenMon);
		
		tfLopChuyenMon = new JTextField();
		tfLopChuyenMon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfLopChuyenMon.setBounds(564, 37, 258, 30);
		pnThongTinNhap.add(tfLopChuyenMon);
		tfLopChuyenMon.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:*");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNgaySinh.setBounds(428, 82, 113, 26);
		pnThongTinNhap.add(lblNgaySinh);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSDT.setBounds(428, 125, 119, 26);
		pnThongTinNhap.add(lblSDT);
		
		tfSDT = new JTextField();
		tfSDT.setFont(new Font("Times New Roman",Font.PLAIN, 15));
		tfSDT.setBounds(564, 125, 258, 30);
		pnThongTinNhap.add(tfSDT);
		tfSDT.setColumns(10);
	
		//Cac chuc nang them sua xoa
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(911, 39, 138, 41);
		pnThongTinDocGia.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(dcNgaySinh.getDate() == null) {
					lblMessage.setText("Ngày sinh đang bị trống");
					return;
				}

				DocGiaDTO dg = null;
				try {
					Calendar cal = dcNgaySinh.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					dg = new DocGiaDTO(tfMaDocGia.getText(), tfHoTen.getText(), 
							(LoaiDocGiaDTO) cbbLoaiDocGia.getSelectedItem(), tfLopChuyenMon.getText(), Date.valueOf(sdf.format(date)), tfSDT.getText(), tfEmail.getText());
				}catch(Exception e1) {
					lblMessage.setText("Kiểm tra ngày tháng");
				}
				String result = QLDocGiaBLL.getInstance().addProcessing(dg);
				lblMessage.setText(result);
				reloadResources();
			}
		});
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(911, 149, 138, 41);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearField();
				isEdit = true;
				setStateForTexfeild();
			}
		});
		pnThongTinDocGia.add(btnHuy);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(911, 94, 138, 41);
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DocGiaDTO dg = null;
				try {
				Calendar cal = dcNgaySinh.getCalendar();
				java.util.Date date = cal.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				dg = new DocGiaDTO(tfMaDocGia.getText(), tfHoTen.getText(), 
						(LoaiDocGiaDTO) cbbLoaiDocGia.getSelectedItem(), tfLopChuyenMon.getText(), Date.valueOf(sdf.format(date)), tfSDT.getText(), tfEmail.getText());
				}catch(Exception e1) {
					lblMessage.setText("Kiểm tra ngày tháng");
				}
				String result = QLDocGiaBLL.getInstance().changeProcessing(dg);
				lblMessage.setText(result);
				reloadResources();
			}
		});
		pnThongTinDocGia.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(911, 204, 138, 41);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg = QLDocGiaBLL.getInstance().deleteProcessing(tfMaDocGia.getText());
				lblMessage.setText(msg);
				reloadResources();
				clearField();
			}
		});
		pnThongTinDocGia.add(btnXoa);
		
		//set tab key
		tfHoTen.setNextFocusableComponent(tfMaDocGia);
		tfMaDocGia.setNextFocusableComponent(cbbLoaiDocGia);
		cbbLoaiDocGia.setNextFocusableComponent(tfLopChuyenMon);
		tfSDT.setNextFocusableComponent(btnThem);
		btnThem.setNextFocusableComponent(btnHuy);
		btnHuy.setNextFocusableComponent(btnXoa);
		btnXoa.setNextFocusableComponent(btnSua);
		btnSua.setNextFocusableComponent(tfHoTen);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(109, 168, 258, 30);
		pnThongTinNhap.add(tfEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEmail.setBounds(10, 171, 81, 26);
		pnThongTinNhap.add(lblEmail);
		
		lblMessage = new JLabel();
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblMessage.setForeground(Color.red);
		lblMessage.setBounds(109, 5, 713, 26);
		pnThongTinNhap.add(lblMessage);
		
		JLabel lblKhongBoTrong = new JLabel("(*) Không được bỏ trống");
		lblKhongBoTrong.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblKhongBoTrong.setForeground(Color.red);
		lblKhongBoTrong.setBounds(429, 173, 393, 26);
		pnThongTinNhap.add(lblKhongBoTrong);
		
		dcNgaySinh = new JDateChooser();
		dcNgaySinh.setBounds(564, 82, 258, 30);
		dcNgaySinh.setDateFormatString("yyyy-MM-dd");
		pnThongTinNhap.add(dcNgaySinh);
	}
}