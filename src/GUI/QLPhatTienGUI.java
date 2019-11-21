package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.QLDocGiaBLL;
import BLL.QLPhatTienBLL;
import DTO.PhatTienDTO;

import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;


public class QLPhatTienGUI {
	private JTable tbQLViPham;
	private JTextField txtfMaLanPhat;
	private JTextField txtfSoTien;
	private JTextField txtfNgayPhat;
	private JPanel pnTongQuanQLViPham;

	static QLPhatTienGUI instance=null;
	private JTextField txtfLyDo;
	private JTextField txtfMaDocGia;
	
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
	
	private void reloadResources() {
		DefaultTableModel dm=(DefaultTableModel) tbQLViPham.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
		tbQLViPham.setModel(QLPhatTienBLL.getInstance().reloadResources());
	}
	
	private void clearField() {
		txtfMaLanPhat.setText("");
		txtfSoTien.setText("");
		txtfMaDocGia.setText("");
		txtfNgayPhat.setText("");
		txtfLyDo.setText("");
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
		
		JLabel lblQLViPham = new JLabel("QU\u1EA2N L\u00DD VI PH\u1EA0M");
		lblQLViPham.setForeground(Color.RED);
		lblQLViPham.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLViPham.setBounds(434, 13, 221, 33);
		pnTieuDeQLViPham.add(lblQLViPham);
		
		JPanel pnQLViPham = new JPanel();
		pnQLViPham.setBounds(0, 67, 1065, 230);
		pnTongQuanQLViPham.add(pnQLViPham);
		pnQLViPham.setLayout(new BorderLayout());
		
		tbQLViPham = new JTable();
		tbQLViPham.setBounds(0, 0, 1050, 170);
		JScrollPane sc = new JScrollPane(tbQLViPham, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1078, 180);
		tbQLViPham.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				if(tbQLViPham.getSelectedRow()<0)
					return;
				txtfMaLanPhat.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 1).toString());
				txtfSoTien.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 2).toString());
				txtfMaDocGia.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 3).toString());
				txtfNgayPhat.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 4).toString());
				txtfLyDo.setText(tbQLViPham.getValueAt(tbQLViPham.getSelectedRow(), 5).toString());
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
		pnThongTinNhap.setBounds(10, 34, 843, 208);
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinDocGia.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblMaLanPhat = new JLabel("Mã lần phạt:*");
		lblMaLanPhat.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaLanPhat.setBounds(32, 36, 80, 14);
		pnThongTinNhap.add(lblMaLanPhat);
		
		JLabel lblMaDocGia = new JLabel("Mã độc giả:*");
		lblMaDocGia.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaDocGia.setBounds(32, 161, 80, 14);
		pnThongTinNhap.add(lblMaDocGia);
		
		JLabel lblSoTien = new JLabel("Số tiền:*");
		lblSoTien.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSoTien.setBounds(32, 97, 72, 14);
		pnThongTinNhap.add(lblSoTien);
		
		JLabel lblNgayPhat = new JLabel("Ngày phạt:*");
		lblNgayPhat.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgayPhat.setBounds(459, 36, 72, 14);
		pnThongTinNhap.add(lblNgayPhat);
		
		txtfMaLanPhat = new JTextField();
		txtfMaLanPhat.setBounds(116, 28, 258, 31);
		pnThongTinNhap.add(txtfMaLanPhat);
		txtfMaLanPhat.setColumns(10);
		
		txtfSoTien = new JTextField();
		txtfSoTien.setBounds(116, 89, 258, 31);
		pnThongTinNhap.add(txtfSoTien);
		txtfSoTien.setColumns(10);
		
		txtfNgayPhat = new JTextField();
		txtfNgayPhat.setBounds(541, 28, 258, 31);
		pnThongTinNhap.add(txtfNgayPhat);
		txtfNgayPhat.setColumns(10);
		
		JLabel lblLyDo = new JLabel("Lý do:");
		lblLyDo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLyDo.setBounds(459, 97, 59, 14);
		pnThongTinNhap.add(lblLyDo);
		
		txtfLyDo = new JTextField();
		txtfLyDo.setBounds(541, 89, 258, 31);
		pnThongTinNhap.add(txtfLyDo);
		txtfLyDo.setColumns(10);
		
		txtfMaDocGia = new JTextField();
		txtfMaDocGia.setBounds(116, 147, 258, 31);
		pnThongTinNhap.add(txtfMaDocGia);
		txtfMaDocGia.setColumns(10);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(116, 3, 683, 22);
		pnThongTinNhap.add(lblMessage);
		
		JLabel lblNewLabel = new JLabel("(*) Không được bỏ trống");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel.setBounds(457, 161, 144, 14);
		pnThongTinNhap.add(lblNewLabel);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setBounds(897, 37, 138, 41);
		pnThongTinDocGia.add(btnThem);
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhatTienDTO pt=new PhatTienDTO(txtfMaLanPhat.getText(),txtfSoTien.getText(),txtfMaDocGia.getText(),Date.valueOf(txtfNgayPhat.getText().toString()),txtfLyDo.getText());
				String result =QLPhatTienBLL.getInstance().addProcessing(pt);
				lblMessage.setText(result);
				reloadResources();
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
			}
		});
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setBounds(897, 201, 138, 41);
		pnThongTinDocGia.add(btnXoa);
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String msg=QLPhatTienBLL.getInstance().deleteProcessing(txtfMaLanPhat.getText());
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
				// TODO Auto-generated method stub
				PhatTienDTO pt=new PhatTienDTO(txtfMaLanPhat.getText(),txtfSoTien.getText(),txtfMaDocGia.getText(),Date.valueOf(txtfNgayPhat.getText().toString()),txtfLyDo.getText());
				String result=QLPhatTienBLL.getInstance().changeProcessing(pt);
				lblMessage.setText(result);
				reloadResources();
			}
		});
		pnThongTinDocGia.add(btnSua);
	}
}
