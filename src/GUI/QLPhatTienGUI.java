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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.QLPhatTienBLL;
import DTO.PhatTienDTO;

import javax.swing.ScrollPaneConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;


public class QLPhatTienGUI {
	private JTable tbQLViPham;
	private JTextField tfSoTien;
	private JPanel pnTongQuanQLViPham;

	static QLPhatTienGUI instance=null;
	private JTextField tfMaDocGia;
	private JDateChooser dcNgayPhat;
	JTextArea taLyDo;
	
	private boolean isEdit = true;
	
	private QLPhatTienGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbQLViPham.setModel(QLPhatTienBLL.getInstance().getResources());
	}
	
	
	
	public static QLPhatTienGUI getInstance() {
		if(instance == null)
			instance = new QLPhatTienGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLPhatTien() {
		return pnTongQuanQLViPham;
	}
	
	private void setStateForTextfeild() {
	}
	
	private void reloadResources() {
		DefaultTableModel dm=(DefaultTableModel) tbQLViPham.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
		tbQLViPham.setModel(QLPhatTienBLL.getInstance().reloadResources());
	}
	
	private void clearField() {
		tfSoTien.setText("");
		tfMaDocGia.setText("");
		dcNgayPhat.setDate(null);
		taLyDo.setText("");
	}
	
	private void initialize() {
		
		pnTongQuanQLViPham = new JPanel();
		pnTongQuanQLViPham.setBackground(SystemColor.activeCaption);
		pnTongQuanQLViPham.setBounds(0, 0, 1065, 560);
		pnTongQuanQLViPham.setLayout(null);
		
		JPanel pnTieuDeQLViPham = new JPanel();
		pnTieuDeQLViPham.setBackground(SystemColor.activeCaption);
		pnTieuDeQLViPham.setBounds(0, 0, 1065, 62);
		pnTongQuanQLViPham.add(pnTieuDeQLViPham);
		pnTieuDeQLViPham.setLayout(null);
		
		JLabel lblQLViPham = new JLabel("QUẢN LÝ VI PHẠM");
		lblQLViPham.setForeground(Color.RED);
		lblQLViPham.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLViPham.setBounds(434, 13, 221, 33);
		pnTieuDeQLViPham.add(lblQLViPham);
		
		JPanel pnQLViPham = new JPanel();
		pnQLViPham.setBounds(0, 67, 1065, 237);
		pnTongQuanQLViPham.add(pnQLViPham);
		pnQLViPham.setLayout(null);
		
		tbQLViPham = new JTable();
		tbQLViPham.setBounds(0, 0, 1050, 170);
		JScrollPane sc = new JScrollPane(tbQLViPham, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1055, 237);
		tbQLViPham.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(tbQLViPham.getSelectedRow()<0)
					return;
				isEdit = false;
				setStateForTextfeild();
				tfSoTien.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 2).toString());
				tfMaDocGia.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 3).toString());
				dcNgayPhat.setDate(Date.valueOf(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 4).toString()));
				taLyDo.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 5).toString());
			}
		});
		pnQLViPham.add(sc,BorderLayout.CENTER);
		
		JPanel pnThongTinDocGia = new JPanel();
		pnThongTinDocGia.setBackground(SystemColor.activeCaption);
		pnThongTinDocGia.setBounds(0, 304, 1065, 256);
		pnTongQuanQLViPham.add(pnThongTinDocGia);
		pnThongTinDocGia.setLayout(null);
		
		JLabel lblThongTinDocGia = new JLabel("THÔNG TIN VI PHẠM");
		lblThongTinDocGia.setBounds(10, 5, 187, 22);
		lblThongTinDocGia.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pnThongTinDocGia.add(lblThongTinDocGia);
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBounds(10, 34, 862, 208);
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinDocGia.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblMaDocGia = new JLabel("Mã độc giả:*");
		lblMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		lblMaDocGia.setBounds(30, 52, 80, 30);
		pnThongTinNhap.add(lblMaDocGia);
		
		JLabel lblSoTien = new JLabel("Số tiền:*");
		lblSoTien.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		lblSoTien.setBounds(30, 109, 72, 30);
		pnThongTinNhap.add(lblSoTien);
		
		JLabel lblNgayPhat = new JLabel("Ngày phạt:*");
		lblNgayPhat.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		lblNgayPhat.setBounds(30, 167, 72, 30);
		pnThongTinNhap.add(lblNgayPhat);
		
		tfSoTien = new JTextField();
		tfSoTien.setBounds(112, 109, 263, 31);
		tfSoTien.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		pnThongTinNhap.add(tfSoTien);
		tfSoTien.setColumns(10);
		
		JLabel lblLyDo = new JLabel("Lý do:");
		lblLyDo.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		lblLyDo.setBounds(441, 52, 59, 30);
		pnThongTinNhap.add(lblLyDo);
		
		tfMaDocGia = new JTextField();
		tfMaDocGia.setBounds(112, 52, 263, 31);
		tfMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		pnThongTinNhap.add(tfMaDocGia);
		tfMaDocGia.setColumns(10);
		
		JLabel lblMessage = new JLabel("(*) Không được để trống");
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 13 ));
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(112, 11, 683, 30);
		pnThongTinNhap.add(lblMessage);
		
		dcNgayPhat = new JDateChooser();
		dcNgayPhat.setBounds(112, 166, 263, 31);
		dcNgayPhat.setDateFormatString("yyyy-MM-dd");
		dcNgayPhat.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		pnThongTinNhap.add(dcNgayPhat);
		
		taLyDo = new JTextArea();
		taLyDo.setBounds(510, 55, 308, 142);
		taLyDo.setFont(new Font("Times New Roman", Font.BOLD, 13 ));
		taLyDo.setLineWrap(true);
		pnThongTinNhap.add(taLyDo);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setBounds(897, 37, 138, 41);
		pnThongTinDocGia.add(btnThem);
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Calendar cal = dcNgayPhat.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngayPhat = sdf.format(date);
					
					String maLanPhat;
					if(tbQLViPham.getRowCount() == 0)
						maLanPhat = "P0";
					else {
						maLanPhat = "P" + (1+Integer.parseInt(tbQLViPham.getValueAt(tbQLViPham.getRowCount()-1, 1).toString().substring(1)));
					}
					
					PhatTienDTO pt=new PhatTienDTO(maLanPhat,tfSoTien.getText(),tfMaDocGia.getText(),Date.valueOf(ngayPhat),taLyDo.getText());
					String result =QLPhatTienBLL.getInstance().addProcessing(pt);
					lblMessage.setText(result);
					reloadResources();
				}catch(Exception ex) {
					lblMessage.setText("Ngày phạt phải đúng định dạng ngày");
				}
				
			}
		});
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(897, 148, 138, 41);
		pnThongTinDocGia.add(btnHuy);
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearField();
				isEdit = true;
				setStateForTextfeild();
			}
		});
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(897, 201, 138, 41);
		pnThongTinDocGia.add(btnXoa);
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg=QLPhatTienBLL.getInstance().deleteProcessing(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 1).toString());
				lblMessage.setText(msg);
				reloadResources();
				clearField();
			}
		});
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(897, 93, 138, 41);
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Calendar cal = dcNgayPhat.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngayPhat = sdf.format(date);
					PhatTienDTO pt=new PhatTienDTO(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 1).toString(),tfSoTien.getText(),tfMaDocGia.getText(),Date.valueOf(ngayPhat),taLyDo.getText());
					String result=QLPhatTienBLL.getInstance().changeProcessing(pt);
					lblMessage.setText(result);
					reloadResources();
				}
				catch(Exception ex) {
					lblMessage.setText("Kiểm tra lại các thông tin của bạn, đặc biệt là ngày tháng");
				}
			}
		});
		pnThongTinDocGia.add(btnSua);
	}
}
