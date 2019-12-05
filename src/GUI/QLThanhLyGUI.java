package GUI;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BLL.QLThanhLyBLL;
import MyException.MyException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class QLThanhLyGUI {
	private static QLThanhLyGUI instance;
	
	private JPanel pnMain;
	private JTable tbSach;
	private JTable tbSachThanhLy;
	private JLabel lblMaSach;
	private JTextField tfMaSach;
	private JTextField tfTenSach;
	private JLabel lblNewLabel;
	private JLabel label;
	private JButton btnThanhLy;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblMessage;
	
	private QLThanhLyGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbSach.setModel(QLThanhLyBLL.getInstance().getResources());
	}
	
	public static QLThanhLyGUI getInstance() {
		if (instance == null)
			instance = new QLThanhLyGUI();
		return instance;
	}
	
	public JPanel getPnMain() {
		return pnMain;
	}
	private void initialize() {
		pnMain = new JPanel();
		pnMain.setBackground(SystemColor.activeCaption);
		pnMain.setBounds(0, 0, 1065, 560);
		pnMain.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 75, 343, 327);
		pnMain.add(scrollPane);
		
		tbSach = new JTable();
		scrollPane.setViewportView(tbSach);
		tbSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(tbSach.getSelectedRow() < 0)
					return;
				
				tfMaSach.setText(tbSach.getValueAt(tbSach.getSelectedRow(), 0).toString());
				tfTenSach.setText(tbSach.getValueAt(tbSach.getSelectedRow(), 1).toString());
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(353, 75, 691, 327);
		pnMain.add(scrollPane_1);
		
		tbSachThanhLy = new JTable();
		scrollPane_1.setViewportView(tbSachThanhLy);
		tbSachThanhLy.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(tbSachThanhLy.getSelectedRow() < 0)
					return;
				
				tfMaSach.setText(tbSachThanhLy.getValueAt(tbSachThanhLy.getSelectedRow(), 0).toString());
				tfTenSach.setText(tbSachThanhLy.getValueAt(tbSachThanhLy.getSelectedRow(), 1).toString());
			}
		});
		
		lblMaSach = new JLabel("Mã sách:");
		lblMaSach.setBounds(10, 415, 63, 21);
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pnMain.add(lblMaSach);
		
		tfMaSach = new JTextField();
		tfMaSach.setBounds(72, 410, 271, 30);
		tfMaSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pnMain.add(tfMaSach);
		tfMaSach.setColumns(10);
		
		JLabel lblTenSach = new JLabel("Tên sách:");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTenSach.setBounds(10, 475, 58, 14);
		pnMain.add(lblTenSach);
		
		tfTenSach = new JTextField();
		tfTenSach.setBounds(72, 467, 271, 30);
		tfTenSach.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pnMain.add(tfTenSach);
		tfTenSach.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				tbSachThanhLy.setModel(QLThanhLyBLL.getInstance().addProcessing(tfMaSach.getText()));
				lblMessage.setText("Sách đã được thêm vào danh sách sách thanh lý");
				}catch(MyException e) {
					lblMessage.setText(e.getMessage());
				}
				
			}
		});
		btnThem.setBounds(72, 508, 158, 41);
		pnMain.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tbSachThanhLy.setModel(QLThanhLyBLL.getInstance().delProcessing(tfMaSach.getText()));
					lblMessage.setText("Sách đã được xóa vào danh sách sách thanh lý");
					}catch(MyException e) {
						lblMessage.setText(e.getMessage());
					}
			}
		});
		btnXoa.setBounds(485, 508, 158, 41);
		pnMain.add(btnXoa);
		
		JTextArea taLyDo = new JTextArea();
		taLyDo.setBounds(409, 412, 635, 85);
		pnMain.add(taLyDo);
		
		lblNewLabel = new JLabel("Lý do:");
		lblNewLabel.setBounds(353, 418, 46, 14);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pnMain.add(lblNewLabel);
		
		label = new JLabel("THANH LÝ SÁCH");
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		label.setBounds(434, 11, 245, 35);
		pnMain.add(label);
		
		btnThanhLy = new JButton("Thanh lý");
		btnThanhLy.setIcon(new ImageIcon("icon\\edit.png"));
		btnThanhLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = QLThanhLyBLL.getInstance().thanhLy(taLyDo.getText());
				loadResources();
				lblMessage.setText(msg);
			}
		});
		btnThanhLy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnThanhLy.setBounds(886, 508, 158, 41);
		pnMain.add(btnThanhLy);
		
		lblNewLabel_1 = new JLabel("DANH SÁCH CUỐN SÁCH");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 52, 333, 21);
		pnMain.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("DANH SÁCH CUỐN SÁCH ĐƯỢC THANH LÝ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(353, 52, 333, 21);
		pnMain.add(lblNewLabel_2);
		
		lblMessage = new JLabel();
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(692, 57, 352, 14);
		pnMain.add(lblMessage);
	}
}
