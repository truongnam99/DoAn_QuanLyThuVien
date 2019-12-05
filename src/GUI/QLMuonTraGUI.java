package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import BLL.QLMuonTraBLL;
import CustomControl.ButtonEditor;
import CustomControl.ButtonRenderer;
import DTO.MuonTraDTO;
import MyException.ContainException;
import MyException.MyException;
import com.toedter.calendar.JDateChooser;

public class QLMuonTraGUI {

	static QLMuonTraGUI instance = null;
	private JPanel pnMain;
	private JTable tbMuonTra;
	private JTextField tfTimKiem;
	private JTextField tfHoTen;
	private JTextField tfMaDocGia;
	private JTextField tfTenSach;
	private JTextField tfMaSach;
	private JTextField tfTrangThai;
	private JLabel lblMessage;
	private JDateChooser dcNgayTra;
	private JDateChooser dcNgayMuon;
	
	private boolean isEdit = true;
	
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
	
	private void setStateForTextfeild() {
		tfMaDocGia.setEditable(isEdit);
		tfMaSach.setEditable(isEdit);
		tfTenSach.setEditable(isEdit);
		tfHoTen.setEditable(isEdit);
		tfTrangThai.setEditable(isEdit);
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
				if(tfTimKiem.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập từ khóa cần tìm!","Thông báo",1);
				else
				{
					tbMuonTra.setModel(QLMuonTraBLL.getInstance().timKiem(tfTimKiem.getText()));
					tbMuonTra.getColumn("Trả sách").setCellRenderer(new ButtonRenderer());
					tbMuonTra.getColumn("Trả sách").setCellEditor(new  ButtonEditor(new JCheckBox()));
				}
			}
		});
		
		tbMuonTra = new JTable();
		tbMuonTra.setBounds(0, 0, 1060, 230);
		JScrollPane sc = new JScrollPane(tbMuonTra, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 44, 1055, 212);
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
		        		isEdit = false;
		        		setStateForTextfeild();
		        		// hiển thị thông tin vào trong các trường
		        		tfMaDocGia.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 1).toString());
		        		tfHoTen.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 2).toString());
		        		tfMaSach.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 3).toString());
		        		tfTenSach.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 4).toString());
		        		try {
			        		dcNgayMuon.setDate(Date.valueOf(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 5).toString()));
			        		dcNgayTra.setDate(Date.valueOf(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 6).toString()));
			        		tfTrangThai.setText(tbMuonTra.getValueAt(tbMuonTra.getSelectedRow(), 7).toString());
			        		Calendar cal = dcNgayMuon.getCalendar();
							java.util.Date date = cal.getTime();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String nm = sdf.format(date);
							cal = dcNgayTra.getCalendar();
							date = cal.getTime();
							String nt = sdf.format(date);
			        		QLMuonTraBLL.getInstance().muonTra = new MuonTraDTO(tfMaDocGia.getText(), tfMaSach.getText(), Date.valueOf(nm), Date.valueOf(nt));
		        		}catch(Exception e1) {
		        			lblMessage.setText(e1.getMessage());
		        			
		        		}
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
				String msg = null;
				MuonTraDTO mt = null;
				try {
					Calendar cal = dcNgayMuon.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String nm = sdf.format(date);
					cal = dcNgayTra.getCalendar();
					date = cal.getTime();
					String nt = sdf.format(date);
					mt=new MuonTraDTO(tfMaDocGia.getText(), tfMaSach.getText(), Date.valueOf(nm), Date.valueOf(nt));
				}catch(Exception e1) {
					lblMessage.setText("Kiểm tra ngày tháng");
				}
				if(mt==null)
					return;
				
				try {
					msg = QLMuonTraBLL.getInstance().addProcessing(mt);
				} catch (MyException e1) {
					
					e1.printStackTrace();
				} catch (ContainException e1) {
					
					e1.printStackTrace();
				};
				lblMessage.setText(msg);
				loadResources();
			}
		});
		pnThongTinMuonTra.add(btnThem);
		
		JButton btnSua = new JButton();
		btnSua.setText("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(910,94,138,41);
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MuonTraDTO mt = null;
				try {
					Calendar cal = dcNgayMuon.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String nm = sdf.format(date);
					cal = dcNgayTra.getCalendar();
					date = cal.getTime();
					String nt = sdf.format(date);
					mt = new MuonTraDTO(tfMaDocGia.getText(), tfMaSach.getText(), Date.valueOf(nm), Date.valueOf(nt));
				}catch(Exception e1) {
					lblMessage.setText("Kiểm tra ngày tháng");
				}
				if(mt==null)
					return;
				
				String msg = QLMuonTraBLL.getInstance().changeProcessing(mt);
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
		lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblHoTen.setBounds(21, 107, 114, 26);
		pnThongTinNhap.add(lblHoTen);
		
		JLabel lblMaDocGia = new JLabel("Mã độc giả:*");
		lblMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaDocGia.setBounds(21, 47, 114, 26);
		pnThongTinNhap.add(lblMaDocGia);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTrangThai.setBounds(21, 170, 114, 26);
		pnThongTinNhap.add(lblTrangThai);
		
		JLabel lblTenSach = new JLabel("Tên sách:");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTenSach.setBounds(464, 89, 87, 26);
		pnThongTinNhap.add(lblTenSach);
		
		JLabel lblMaSach = new JLabel("Mã sách:*");
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaSach.setBounds(464, 47, 87, 26);
		pnThongTinNhap.add(lblMaSach);
		
		JLabel lblNgayMuon = new JLabel("Ngày mượn:*");
		lblNgayMuon.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNgayMuon.setBounds(464, 129, 87, 26);
		pnThongTinNhap.add(lblNgayMuon);
		
		JLabel lblNgayTra = new JLabel("Ngày trả:*");
		lblNgayTra.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNgayTra.setBounds(464, 170, 87, 26);
		pnThongTinNhap.add(lblNgayTra);
		
		tfHoTen= new JTextField();
		tfHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfHoTen.setBounds(145, 106, 258, 30);
		pnThongTinNhap.add(tfHoTen);
		tfHoTen.setColumns(10);
		
		tfMaDocGia = new JTextField();
		tfMaDocGia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfMaDocGia.setBounds(145, 44, 258, 30);
		pnThongTinNhap.add(tfMaDocGia);
		tfMaDocGia.setColumns(10);
		
		tfTenSach = new JTextField();
		tfTenSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfTenSach.setBounds(561, 85, 274, 30);
		pnThongTinNhap.add(tfTenSach);
		tfTenSach.setColumns(10);
		
		tfMaSach = new JTextField();
		tfMaSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfMaSach.setBounds(561, 44, 274, 30);
		pnThongTinNhap.add(tfMaSach);
		tfMaSach.setColumns(10);
		
		tfTrangThai = new JTextField();
		tfTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfTrangThai.setBounds(145, 167, 258, 30);
		pnThongTinNhap.add(tfTrangThai);
		tfTrangThai.setColumns(10);
		
		lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblMessage.setForeground(Color.red);
		lblMessage.setBounds(145, 11, 311, 25);
		pnThongTinNhap.add(lblMessage);
		
		JLabel lblKhongBoTrong = new JLabel("(*) Không được bỏ trống");
		lblKhongBoTrong.setForeground(Color.RED);
		lblKhongBoTrong.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblKhongBoTrong.setBounds(464, 11, 235, 22);
		pnThongTinNhap.add(lblKhongBoTrong);
		
		dcNgayMuon = new JDateChooser();
		dcNgayMuon.setBounds(561, 129, 274, 30);
		dcNgayMuon.setDateFormatString("yyyy-MM-dd");
		pnThongTinNhap.add(dcNgayMuon);
		
		dcNgayTra = new JDateChooser();
		dcNgayTra.setBounds(561, 170, 274, 30);
		dcNgayTra.setDateFormatString("yyyy-MM-dd");
		pnThongTinNhap.add(dcNgayTra);
		
		JButton btnHuy = new JButton();
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setText("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(910, 149, 138, 41);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isEdit = true;
				setStateForTextfeild();
				tfHoTen.setText("");
				tfTrangThai.setText("");
				
				tfMaDocGia.setText("");
				tfMaSach.setText("");
				dcNgayMuon.setDate(null);
				dcNgayTra.setDate(null);
				tfTenSach.setText("");
				loadResources();
				
			}
		});
	
		pnThongTinMuonTra.add(btnHuy);
	}
}
