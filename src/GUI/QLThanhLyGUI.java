package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.QLDocGiaBLL;
import BLL.QLThanhLyBLL;
import DTO.ThanhLyDTO;


public class QLThanhLyGUI {
	private JTable tbQLThanhLy;
	private JTextField txtfMaSach;
	private JTextField txtfTenSach;
	private JTextField txtfTheLoai;
	private JTextField txtfTacGia;
	private JTextField txtfNhaXuatBan;
	private JTextField txtfLyDo;
	private JTextField txtfThoiGianLuuKho;
	private JTextField txtfNgayThanhLy;
	private JPanel pnTongQuanQLThanhLy;

	static QLThanhLyGUI instance=null;
	
	private QLThanhLyGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbQLThanhLy.setModel(QLThanhLyBLL.getInstance().getResources());
	}
	
	public static QLThanhLyGUI getInstance() {
		if(instance == null)
			instance = new QLThanhLyGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLThanhly() {
		return pnTongQuanQLThanhLy;
	}
	
	private void reloadResources() {
		DefaultTableModel dm=(DefaultTableModel) tbQLThanhLy.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
		tbQLThanhLy.setModel(QLThanhLyBLL.getInstance().reloadResources());
	}
	
	private void cleadField() {
		txtfMaSach.setText("");
		txtfTenSach.setText("");
		txtfTheLoai.setText("");
		txtfTacGia.setText("");
		txtfNhaXuatBan.setText("");
		txtfLyDo.setText("");
		txtfThoiGianLuuKho.setText("");
		txtfNgayThanhLy.setText("");
	}
	private void initialize() {
		
		pnTongQuanQLThanhLy = new JPanel();
		pnTongQuanQLThanhLy.setBackground(SystemColor.activeCaption);
		pnTongQuanQLThanhLy.setBounds(0, 0, 1065, 560);
		pnTongQuanQLThanhLy.setLayout(null);
		
		JPanel pnTieuDeQLThanhLy = new JPanel();
		pnTieuDeQLThanhLy.setBackground(SystemColor.activeCaption);
		pnTieuDeQLThanhLy.setBounds(0, 0, 1065, 62);
		pnTongQuanQLThanhLy.add(pnTieuDeQLThanhLy);
		pnTieuDeQLThanhLy.setLayout(null);
		
		JLabel lblQLThanhLy = new JLabel("QU\u1EA2N L\u00DD THANH L\u00DD S\u00C1CH");
		lblQLThanhLy.setForeground(Color.RED);
		lblQLThanhLy.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLThanhLy.setBounds(390, 15, 313, 27);
		pnTieuDeQLThanhLy.add(lblQLThanhLy);
		
		JPanel pnQLThanhLy = new JPanel();
		pnQLThanhLy.setBounds(0, 67, 1065, 230);
		pnTongQuanQLThanhLy.add(pnQLThanhLy);
		pnQLThanhLy.setLayout(new BorderLayout());
		
		tbQLThanhLy = new JTable();
		tbQLThanhLy.setBounds(0, 0, 1050, 170);
		JScrollPane sc = new JScrollPane(tbQLThanhLy, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1050, 180);
		tbQLThanhLy.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(tbQLThanhLy.getSelectedRow()<0)
					return;
				txtfMaSach.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(), 1).toString());
				txtfTenSach.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(), 2).toString());
				txtfTheLoai.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(), 3).toString());
				txtfTacGia.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(), 4).toString());
				txtfNhaXuatBan.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(),5).toString());
				txtfLyDo.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(), 6).toString());
				txtfThoiGianLuuKho.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(), 7).toString());
				txtfNgayThanhLy.setText(tbQLThanhLy.getValueAt(tbQLThanhLy.getSelectedRow(), 8).toString());
			}
		});
		pnQLThanhLy.add(sc,BorderLayout.CENTER);
		
		JPanel pnThongTinThanhLy = new JPanel();
		pnThongTinThanhLy.setBackground(SystemColor.activeCaption);
		pnThongTinThanhLy.setBounds(0, 304, 1065, 256);
		pnTongQuanQLThanhLy.add(pnThongTinThanhLy);
		pnThongTinThanhLy.setLayout(null);
		
		JLabel lblThongTinThanhLy = new JLabel("TH\u00D4NG TIN THANH L\u00DD");
		lblThongTinThanhLy.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblThongTinThanhLy.setBounds(10, 5, 211, 25);
		pnThongTinThanhLy.add(lblThongTinThanhLy);
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 37, 854, 208);
		pnThongTinThanhLy.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblTenSach = new JLabel("Tên sách:*");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenSach.setBounds(23, 85, 69, 14);
		pnThongTinNhap.add(lblTenSach);
		
		JLabel lblMaSach = new JLabel("Mã sách:*");
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaSach.setBounds(23, 40, 54, 14);
		pnThongTinNhap.add(lblMaSach);
		
		JLabel lblTheLoai = new JLabel("Th\u1EC3 lo\u1EA1i:");
		lblTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTheLoai.setBounds(23, 130, 54, 14);
		pnThongTinNhap.add(lblTheLoai);
		
		JLabel lblNhaXuatBan = new JLabel("Nh\u00E0 xu\u1EA5t b\u1EA3n:");
		lblNhaXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNhaXuatBan.setBounds(434, 40, 83, 14);
		pnThongTinNhap.add(lblNhaXuatBan);
		
		txtfMaSach = new JTextField();
		txtfMaSach.setBounds(87, 32, 258, 30);
		pnThongTinNhap.add(txtfMaSach);
		txtfMaSach.setColumns(10);
		
		txtfTenSach = new JTextField();
		txtfTenSach.setBounds(87, 78, 258, 30);
		pnThongTinNhap.add(txtfTenSach);
		txtfTenSach.setColumns(10);
		
		txtfTheLoai = new JTextField();
		txtfTheLoai.setBounds(87, 123, 258, 30);
		pnThongTinNhap.add(txtfTheLoai);
		txtfTheLoai.setColumns(10);
		
		txtfTacGia = new JTextField();
		txtfTacGia.setBounds(87, 168, 258, 30);
		pnThongTinNhap.add(txtfTacGia);
		txtfTacGia.setColumns(10);
		
		JLabel lblTacGia = new JLabel("T\u00E1c gi\u1EA3:");
		lblTacGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTacGia.setBounds(23, 175, 54, 17);
		pnThongTinNhap.add(lblTacGia);
		
		txtfNhaXuatBan = new JTextField();
		txtfNhaXuatBan.setBounds(551, 32, 258, 30);
		pnThongTinNhap.add(txtfNhaXuatBan);
		txtfNhaXuatBan.setColumns(10);
		
		JLabel lblLyDo = new JLabel("Lý do:*");
		lblLyDo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLyDo.setBounds(434, 85, 46, 14);
		pnThongTinNhap.add(lblLyDo);
		
		txtfLyDo = new JTextField();
		txtfLyDo.setBounds(551, 77, 258, 30);
		pnThongTinNhap.add(txtfLyDo);
		txtfLyDo.setColumns(10);
		
		JLabel lblThoiGianLuuKho = new JLabel("Thời gian lưu kho:*");
		lblThoiGianLuuKho.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblThoiGianLuuKho.setBounds(434, 130, 107, 14);
		pnThongTinNhap.add(lblThoiGianLuuKho);
		
		txtfThoiGianLuuKho = new JTextField();
		txtfThoiGianLuuKho.setBounds(551, 122, 258, 30);
		pnThongTinNhap.add(txtfThoiGianLuuKho);
		txtfThoiGianLuuKho.setColumns(10);
		
		JLabel lblNgayThanhLy = new JLabel("Ngày thanh lý:*");
		lblNgayThanhLy.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayThanhLy.setBounds(434, 176, 86, 14);
		pnThongTinNhap.add(lblNgayThanhLy);
		
		txtfNgayThanhLy = new JTextField();
		txtfNgayThanhLy.setBounds(551, 168, 258, 30);
		pnThongTinNhap.add(txtfNgayThanhLy);
		txtfNgayThanhLy.setColumns(10);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblMessage.setBounds(87, 5, 318, 25);
		pnThongTinNhap.add(lblMessage);
		
		JLabel lblKhongBoTrong = new JLabel("(*) Không được bỏ trống");
		lblKhongBoTrong.setForeground(Color.RED);
		lblKhongBoTrong.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblKhongBoTrong.setBounds(551, 5, 258, 25);
		pnThongTinNhap.add(lblKhongBoTrong);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(905, 37, 133, 41);
		pnThongTinThanhLy.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ThanhLyDTO tl=new ThanhLyDTO(txtfMaSach.getText(),txtfTenSach.getText(),txtfTheLoai.getText(),txtfTacGia.getText(),txtfNhaXuatBan.getText(),txtfLyDo.getText(),Date.valueOf(txtfThoiGianLuuKho.getText().toString()),Date.valueOf(txtfNgayThanhLy.getText().toString()));
				String result =QLThanhLyBLL.getInstance().addProcessing(tl);
				lblMessage.setText(result);
				reloadResources();
			}
		});
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(905, 92, 133, 41);
		pnThongTinThanhLy.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ThanhLyDTO tl=new ThanhLyDTO(txtfMaSach.getText(),txtfTenSach.getText(),txtfTheLoai.getText(),txtfTacGia.getText(),txtfNhaXuatBan.getText(),txtfLyDo.getText(),Date.valueOf(txtfThoiGianLuuKho.getText().toString()),Date.valueOf(txtfNgayThanhLy.getText().toString()));
				String result=QLThanhLyBLL.getInstance().changeProcessing(tl);
				lblMessage.setText(result);
				reloadResources();
			}
		});
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(905, 148, 133, 41);
		pnThongTinThanhLy.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cleadField();
			}
		});
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(905, 202, 133, 41);
		pnThongTinThanhLy.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String msg=QLThanhLyBLL.getInstance().deleteProcessing(txtfMaSach.getText());
				lblMessage.setText(msg);
				reloadResources();
				cleadField();
			}
		});
	}
}
