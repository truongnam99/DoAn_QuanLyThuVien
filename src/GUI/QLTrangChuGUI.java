package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;





public class QLTrangChuGUI {

	private JPanel pnTongQuanQLTrangChu;
	

	static QLTrangChuGUI instance=null;
	
	public QLTrangChuGUI() {
		initialize();
	}
	
	public static QLTrangChuGUI getInstance() {
		if(instance == null)
			instance = new QLTrangChuGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLTrangChu() {
		return pnTongQuanQLTrangChu;
	}
	private void initialize() {
		
		
		pnTongQuanQLTrangChu = new JPanel();
		pnTongQuanQLTrangChu.setBounds(0, 0, 1065, 560);
		pnTongQuanQLTrangChu.setLayout(null);
		
		
		
		JPanel pnLoGoTruong = new JPanel();
		pnLoGoTruong.setBackground(SystemColor.inactiveCaptionBorder);
		pnLoGoTruong.setBounds(0, 0, 1065, 560);
		pnTongQuanQLTrangChu.add(pnLoGoTruong);
		pnLoGoTruong.setLayout(null);
		
		JLabel lblLoGoTruong = new JLabel("New label");
		lblLoGoTruong.setBounds(12, 11, 217, 224);
		lblLoGoTruong.setIcon(new ImageIcon("icon\\PTNKLogo.png"));
		pnLoGoTruong.add(lblLoGoTruong);
		
		JLabel lblTenTruong = new JLabel("TR\u01AF\u1EDCNG PT N\u0102NG KHI\u1EBEU -  \u0110HQG TP.HCM");
		lblTenTruong.setBounds(240, 82, 522, 86);
		lblTenTruong.setForeground(Color.BLUE);
		lblTenTruong.setFont(new Font("Times New Roman", Font.BOLD, 24));
		pnLoGoTruong.add(lblTenTruong);
		
		JPanel pnLich = new JPanel();
		pnLich.setBackground(SystemColor.activeCaption);
		pnLich.setBounds(729, 230, 326, 330);
		pnLoGoTruong.add(pnLich);
		pnLich.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(0, 0, 326, 330);
		pnLich.add(calendar);
		
		
		
	}
}
