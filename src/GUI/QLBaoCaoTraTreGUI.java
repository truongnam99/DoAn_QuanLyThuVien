package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BLL.QLBaoCaoTreBLL;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.swing.ScrollPaneConstants;



public class QLBaoCaoTraTreGUI {
	private JTextField txtfNgay;
	private JTable tbThongKe;
	private JPanel pnTongQuanTKSach;
	static QLBaoCaoTraTreGUI instance;
	
	
	private QLBaoCaoTraTreGUI(){
		initialize();
	}
	public static QLBaoCaoTraTreGUI getInstance() {
		if(instance == null)
			instance = new QLBaoCaoTraTreGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanTKSach() {
		return pnTongQuanTKSach;
	}
	

	
	private void initialize() {
		
		
		pnTongQuanTKSach = new JPanel();
		pnTongQuanTKSach.setBounds(0, 0, 1065, 560);
		pnTongQuanTKSach.setLayout(null);
		
		JPanel pnTieuDeTK = new JPanel();
		pnTieuDeTK.setBackground(SystemColor.activeCaption);
		pnTieuDeTK.setBounds(0, 0, 1065, 86);
		pnTongQuanTKSach.add(pnTieuDeTK);
		pnTieuDeTK.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("QUẢN LÝ THỐNG KÊ SÁCH TRẢ TRỄ");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTieuDe.setBounds(350, 5, 439, 28);
		pnTieuDeTK.add(lblTieuDe);
		
		JLabel lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNgay.setBounds(172, 50, 46, 23);
		pnTieuDeTK.add(lblNgay);
		
		txtfNgay = new JTextField();
		txtfNgay.setBounds(228, 49, 101, 25);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date= new java.util.Date();
		txtfNgay.setText(formatter.format(date));
	
		pnTieuDeTK.add(txtfNgay);
		txtfNgay.setColumns(10);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThongKe.setIcon(new ImageIcon("icon\\edit.png"));
		btnThongKe.setBounds(507, 40, 157, 41);
		btnThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm=QLBaoCaoTreBLL.getInstance().thongke();
				tbThongKe.setModel(dtm);
			}
		});
		pnTieuDeTK.add(btnThongKe);
		
		JButton btnLapBaoCao = new JButton("Lập báo cáo");
		btnLapBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLapBaoCao.setIcon(new ImageIcon("icon\\print.png"));
		btnLapBaoCao.setBounds(755, 40, 157, 41);
		btnLapBaoCao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QLBaoCaoTreBLL.getInstance().lapBaoCaoTre();
			}
		});
		pnTieuDeTK.add(btnLapBaoCao);
		
		JPanel pnThongKe = new JPanel();
		pnThongKe.setBounds(0, 88, 1065, 472);
		pnTongQuanTKSach.add(pnThongKe);
		pnThongKe.setLayout(null);
		
		tbThongKe = new JTable();
		tbThongKe.setBounds(0, 0, 1050, 452);
		JScrollPane sc = new JScrollPane(tbThongKe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(0, 0, 1055, 472);
		pnThongKe.add(sc,BorderLayout.CENTER);
		
		
	}
}
