package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

import BLL.BaoCaoBLL;

import javax.swing.SwingConstants;
import DTO.BaoCaoMuonDTO;

public class QLBaoCaoGUI {

	private JPanel pnTongQuanQLTK;
	private JTextField txtfThang;
	private JTextField txtfNam;
	private JTextField txtfMaBaoCao;
	private JTable tbQLThongKe;

	static QLBaoCaoGUI instance=null;
		
		private QLBaoCaoGUI(){
			initialize();
			loadResources();
		}
		private void loadResources() {
			
		}
		
		private void refreshDataTable() {
			
		}
		
		public static QLBaoCaoGUI getInstance() {
			if(instance == null)
				instance = new QLBaoCaoGUI();
			return instance;
		}
		
		public JPanel getPnTongQuanQLTK() {
			return pnTongQuanQLTK;
		}
	private void initialize() {
		
		
		pnTongQuanQLTK = new JPanel();
		pnTongQuanQLTK.setBounds(0, 0, 1065, 560);
		pnTongQuanQLTK.setLayout(null);
		pnTongQuanQLTK.setBackground(SystemColor.activeCaption);
		
		JPanel panelTieuDeQLTK = new JPanel();
		panelTieuDeQLTK.setBackground(SystemColor.activeCaption);
		panelTieuDeQLTK.setBounds(0, 0, 1065, 86);
		pnTongQuanQLTK.add(panelTieuDeQLTK);
		panelTieuDeQLTK.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("THỐNG KÊ MƯỢN SÁCH THEO THỂ LOẠI TỪNG THÁNG");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTieuDe.setBounds(158, 11, 748, 28);
		panelTieuDeQLTK.add(lblTieuDe);
		
		JLabel lblThang = new JLabel("Th\u00E1ng:");
		lblThang.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblThang.setBounds(81, 44, 46, 31);
		panelTieuDeQLTK.add(lblThang);
		
		txtfThang = new JTextField();
		txtfThang.setBounds(137, 49, 30, 25);
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");  
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		java.util.Date date = new java.util.Date();
		txtfThang.setText(monthFormat.format(date));
		panelTieuDeQLTK.add(txtfThang);
		txtfThang.setColumns(10);
		
		JLabel lblDauXet = new JLabel("/");
		lblDauXet.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDauXet.setBounds(174, 43, 11, 31);
		panelTieuDeQLTK.add(lblDauXet);
		
		txtfNam = new JTextField();
		txtfNam.setBounds(185, 49, 46, 25);
		panelTieuDeQLTK.add(txtfNam);
		txtfNam.setText(yearFormat.format(date));
		txtfNam.setColumns(10);
		
		JLabel lblMaBaoCao = new JLabel("M\u00E3 b\u00E1o c\u00E1o:");
		lblMaBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaBaoCao.setBounds(282, 52, 86, 14);
		panelTieuDeQLTK.add(lblMaBaoCao);
		
		txtfMaBaoCao = new JTextField();
		txtfMaBaoCao.setBounds(378, 49, 101, 25);
		panelTieuDeQLTK.add(txtfMaBaoCao);
		txtfMaBaoCao.setColumns(10);
		
		JButton btnThongKe = new JButton("Th\u1ED1ng k\u00EA");
		btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThongKe.setIcon(new ImageIcon("icon\\edit.png"));
		btnThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = BaoCaoBLL.getInstance().thongKe(Integer.parseInt(txtfThang.getText()) - 1, Integer.parseInt(txtfNam.getText()));
				tbQLThongKe.setModel(dtm);
			}
		});
		btnThongKe.setBounds(584, 40, 157, 41);
		panelTieuDeQLTK.add(btnThongKe);
		
		JButton btnLapBaoCao = new JButton("L\u1EADp b\u00E1o c\u00E1o");
		btnLapBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLapBaoCao.setIcon(new ImageIcon("icon\\print.png"));
		btnLapBaoCao.setBounds(824, 40, 157, 41);
		panelTieuDeQLTK.add(btnLapBaoCao);
		btnLapBaoCao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BaoCaoBLL.getInstance().lapBaoCao();
			}
		});
		
		JPanel pnQLThongKe = new JPanel();
		pnQLThongKe.setBounds(0, 89, 1065, 471);
		pnTongQuanQLTK.add(pnQLThongKe);
		pnQLThongKe.setLayout(new BorderLayout());
		tbQLThongKe = new JTable();
		tbQLThongKe.setBounds(0, 0, 624, 352);
		JScrollPane sc = new JScrollPane(tbQLThongKe, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnQLThongKe.add(sc);
//		tbQLThongKe.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null},
//				{null, null, null, null},
//			},
//			new String[] {"Tên thể loại", "Số lượt mượn", "Tỉ lệ"
//			}
//		));
		
	}
}

