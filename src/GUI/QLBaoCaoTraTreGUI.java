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
import java.awt.SystemColor;



public class QLBaoCaoTraTreGUI {
	private JTextField txtfNgay;
	private JTextField txtfMaBaoCao;
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
		lblNgay.setBounds(71, 52, 46, 23);
		pnTieuDeTK.add(lblNgay);
		
		txtfNgay = new JTextField();
		txtfNgay.setBounds(127, 49, 68, 26);
		pnTieuDeTK.add(txtfNgay);
		txtfNgay.setColumns(10);
		
		JLabel lblMaBaoCao = new JLabel("M\u00E3 b\u00E1o c\u00E1o:");
		lblMaBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMaBaoCao.setBounds(323, 52, 77, 23);
		pnTieuDeTK.add(lblMaBaoCao);
		
		txtfMaBaoCao = new JTextField();
		txtfMaBaoCao.setBounds(400, 49, 86, 26);
		pnTieuDeTK.add(txtfMaBaoCao);
		txtfMaBaoCao.setColumns(10);
		
		JButton btnThongKe = new JButton("Th\u1ED1ng k\u00EA");
		btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThongKe.setIcon(new ImageIcon("icon\\edit.png"));
		btnThongKe.setBounds(589, 40, 157, 41);
		pnTieuDeTK.add(btnThongKe);
		
		JButton btnLapBaoCao = new JButton("L\u1EADp b\u00E1o c\u00E1o");
		btnLapBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLapBaoCao.setIcon(new ImageIcon("icon\\print.png"));
		btnLapBaoCao.setBounds(808, 40, 157, 41);
		pnTieuDeTK.add(btnLapBaoCao);
		
		JPanel pnThongKe = new JPanel();
		pnThongKe.setBounds(0, 88, 1065, 472);
		pnTongQuanTKSach.add(pnThongKe);
		pnThongKe.setLayout(new BorderLayout());
		
		tbThongKe = new JTable();
		tbThongKe.setBounds(0, 0, 624, 352);
		JScrollPane sc = new JScrollPane(tbThongKe, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tbThongKe.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Tên sách", "Mã sách", "Ngày mượn", "Số ngày trả trễ"
			}
		));
		pnThongKe.add(sc,BorderLayout.CENTER);
		
		
	}
}
