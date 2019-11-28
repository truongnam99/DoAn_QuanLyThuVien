package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.naming.ldap.Rdn;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.QLDocGiaBLL;
import BLL.QLSachBLL;
import DTO.DocGiaDTO;
import DTO.LoaiDocGiaDTO;
import DTO.SachDTO;

public class QLSachGUI {
	private JTable tbQLSach;
	private JTextField tfMaSach;
	private JTextField tfTenSach;
	private JTextField tfTacGia;
	private JTextField tfTheLoai;
	private JTextField tfNhaXuatBan;
	private JTextField tfNamXuatBan;
	private JTextField tfNgayNhap;
	private JTextField tfTriGia;
	private JPanel pnTongQuanQLSach;
	private JLabel lblMessage;
	private JRadioButton rdbtnTrong;
	
	private boolean isChanging = false;
	
	static QLSachGUI instance=null;
	
	private QLSachGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbQLSach.setModel(QLSachBLL.getInstance().getResources());
	}
	
	public static QLSachGUI getInstance() {
		if(instance == null)
			instance = new QLSachGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLSach() {
		return pnTongQuanQLSach;
	}
	
	public void reloadResources() {
		tbQLSach.setModel(QLSachBLL.getInstance().getResources());
	}
	
	private void clearField() {
		tfMaSach.setText("");
		tfNamXuatBan.setText("");
		tfNgayNhap.setText("");
		tfNhaXuatBan.setText("");
		tfTacGia.setText("");
		tfTenSach.setText("");
		tfTheLoai.setText("");
		tfTriGia.setText("");
		rdbtnTrong.setSelected(true);
	}
	
	private void setStateForTextfield() {
			tfMaSach.setEditable(isChanging);
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
		
		JLabel lblQLSach = new JLabel("QUÁN LÝ SÁCH");
		lblQLSach.setForeground(Color.RED);
		lblQLSach.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLSach.setBounds(448, 11, 219, 35);
		pnTieuDeQLSach.add(lblQLSach);
		
		JPanel pnQLSach = new JPanel();
		pnQLSach.setBounds(0, 52, 1065, 212);
		pnTongQuanQLSach.add(pnQLSach);
		pnQLSach.setLayout(new BorderLayout());
		
		
		JPanel pnThongTinSach = new JPanel();
		pnThongTinSach.setBackground(SystemColor.activeCaption);
		pnThongTinSach.setBounds(0, 265, 1065, 295);
		pnTongQuanQLSach.add(pnThongTinSach);
		pnThongTinSach.setLayout(null);
		
		JLabel lblThongTinSach = new JLabel("THÔNG TIN SÁCH");
		lblThongTinSach.setBounds(10, 5, 178, 28);
		pnThongTinSach.add(lblThongTinSach);
		lblThongTinSach.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 32, 855, 252);
		pnThongTinSach.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblMaSach = new JLabel("Mã sách:*");
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaSach.setBounds(24, 58, 66, 14);
		pnThongTinNhap.add(lblMaSach);
		
		tfMaSach = new JTextField();
		tfMaSach.setBounds(115, 49, 258, 32);
		pnThongTinNhap.add(tfMaSach);
		tfMaSach.setColumns(10);
		
		JLabel lblTenSach = new JLabel("Tên sách:*");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenSach.setBounds(24, 100, 66, 14);
		pnThongTinNhap.add(lblTenSach);
		
		tfTenSach = new JTextField();
		tfTenSach.setBounds(115, 92, 258, 31);
		pnThongTinNhap.add(tfTenSach);
		tfTenSach.setColumns(10);
		
		JLabel lblTacGia = new JLabel("Tác giả:");
		lblTacGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTacGia.setBounds(24, 142, 66, 14);
		pnThongTinNhap.add(lblTacGia);
		
		tfTacGia = new JTextField();
		tfTacGia.setBounds(115, 134, 258, 31);
		pnThongTinNhap.add(tfTacGia);
		tfTacGia.setColumns(10);
		
		JLabel lblTheLoai = new JLabel("Thể loại:");
		lblTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTheLoai.setBounds(24, 184, 66, 14);
		pnThongTinNhap.add(lblTheLoai);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng:");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTinhTrang.setBounds(24, 226, 74, 14);
		pnThongTinNhap.add(lblTinhTrang);
		
		tfTheLoai = new JTextField();
		tfTheLoai.setBounds(115, 176, 258, 31);
		pnThongTinNhap.add(tfTheLoai);
		tfTheLoai.setColumns(10);
		
		rdbtnTrong = new JRadioButton("Trống");
		rdbtnTrong.setFont(new Font("Times New Roman", Font.BOLD, 12));
		rdbtnTrong.setBounds(115, 222, 57, 23);
		pnThongTinNhap.add(rdbtnTrong);
		
		JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản:");
		lblNhaXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNhaXuatBan.setBounds(454, 58, 74, 14);
		pnThongTinNhap.add(lblNhaXuatBan);
		
		tfNhaXuatBan = new JTextField();
		tfNhaXuatBan.setBounds(551, 49, 258, 31);
		pnThongTinNhap.add(tfNhaXuatBan);
		tfNhaXuatBan.setColumns(10);
		
		JLabel lblNamXuatBan = new JLabel("Năm xuất bản:*");
		lblNamXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNamXuatBan.setBounds(455, 100, 86, 14);
		pnThongTinNhap.add(lblNamXuatBan);
		
		tfNamXuatBan = new JTextField();
		tfNamXuatBan.setBounds(551, 91, 258, 31);
		pnThongTinNhap.add(tfNamXuatBan);
		tfNamXuatBan.setColumns(10);
		
		JLabel lblNgayNhap = new JLabel("Ngày nhập:*");
		lblNgayNhap.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayNhap.setBounds(455, 142, 66, 14);
		pnThongTinNhap.add(lblNgayNhap);
		
		tfNgayNhap = new JTextField();
		tfNgayNhap.setBounds(551, 133, 258, 31);
		pnThongTinNhap.add(tfNgayNhap);
		tfNgayNhap.setColumns(10);
		
		JLabel lblTriGia = new JLabel("Giá sách:*");
		lblTriGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTriGia.setBounds(455, 184, 73, 14);
		pnThongTinNhap.add(lblTriGia);
		
		tfTriGia = new JTextField();
		tfTriGia.setBounds(551, 175, 258, 31);
		pnThongTinNhap.add(tfTriGia);
		tfTriGia.setColumns(10);
		
		lblMessage = new JLabel("(*) Không được để trống");
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblMessage.setBounds(115, 11, 694, 23);
		pnThongTinNhap.add(lblMessage);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(902, 32, 138, 41);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tinhTrang;
				if (rdbtnTrong.isSelected())
					tinhTrang = "Trống";
				else
					tinhTrang = "Đang được mượn";
				try {
					SachDTO s = new SachDTO(tfMaSach.getText(), tfTacGia.getText(), tfTenSach.getText(), tfTheLoai.getText(), tfNhaXuatBan.getText(), 
						Date.valueOf(tfNgayNhap.getText()), tfTriGia.getText(), tinhTrang, Date.valueOf(tfNamXuatBan.getText()));
					String result = QLSachBLL.getInstance().addProcessing(s);
					lblMessage.setText(result);
					reloadResources();
				}
				catch(Exception ex) {
					lblMessage.setText("Kiểm tra lại các thông tin của bạn, đặc biệt là ngày tháng");
				}
			}
		});
		pnThongTinSach.add(btnThem);
		
		JButton btnSua = new JButton("Sửa\r\n");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String tinhTrang;
					if (rdbtnTrong.isSelected())
						tinhTrang = "Trống";
					else
						tinhTrang = "Đang được mượn";
					SachDTO s = new SachDTO(tfMaSach.getText(), tfTacGia.getText(), tfTenSach.getText(), tfTheLoai.getText(), tfNhaXuatBan.getText(), 
							Date.valueOf(tfNgayNhap.getText()), tfTriGia.getText(), tinhTrang, Date.valueOf(tfNamXuatBan.getText()));
					String result = QLSachBLL.getInstance().changeProcessing(s);
					lblMessage.setText(result);
					reloadResources();
				}
				catch(Exception ex) {
					lblMessage.setText("Kiểm tra lại các thông tin của bạn, đặc biệt là ngày tháng");
				}
			}
		});
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(902, 103, 138, 41);
		pnThongTinSach.add(btnSua);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(902, 173, 138, 41);
		pnThongTinSach.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearField();
				isChanging = true;
				setStateForTextfield();
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(902, 243, 138, 41);
		pnThongTinSach.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = QLSachBLL.getInstance().deleteProcessing(tfMaSach.getText());
				lblMessage.setText(msg);
				reloadResources();
				clearField();
			}
		});
		
		tbQLSach = new JTable();
		tbQLSach.setBounds(0, 0, 1060, 167);
		JScrollPane sc = new JScrollPane(tbQLSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnQLSach.add(sc);
		sc.setBounds(10, 65, 1065, 195);
		tbQLSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tbQLSach.getSelectedRow()< 0)
					return;
				isChanging = false;
				setStateForTextfield();
				tfMaSach.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 1).toString());
				tfTenSach.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 2).toString());
				tfTheLoai.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 3).toString());
				tfTacGia.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 4).toString());
				tfNhaXuatBan.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 5).toString());
				tfNgayNhap.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 6).toString());
				tfTriGia.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 7).toString());
				if (tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 8).toString().equals("Trống"))
					rdbtnTrong.setSelected(true);
				else 
					rdbtnTrong.setSelected(false);
				tfNamXuatBan.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 9).toString());
			}
		});
	}
}
