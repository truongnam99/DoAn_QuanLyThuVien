package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class QLDangNhapGUI {

	private JFrame frame;
	private JTextField txtfTaiKhoan;
	private JTextField txtfMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDangNhapGUI window = new QLDangNhapGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Create the application.
	 */
	public QLDangNhapGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(370, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel pnTongQuanDangNhap = new JPanel();
		pnTongQuanDangNhap.setBounds(0, 0, 624, 441);
		frame.getContentPane().add(pnTongQuanDangNhap);
		pnTongQuanDangNhap.setLayout(null);
		
		JPanel pnHinh = new JPanel();
		pnHinh.setBounds(0, 0, 327, 441);
		pnTongQuanDangNhap.add(pnHinh);
		pnHinh.setLayout(null);
		
		JLabel lblHinh = new JLabel("New label");
		lblHinh.setIcon(new ImageIcon("icon\\Untitled.png"));
		lblHinh.setBounds(0, 0, 327, 441);
		pnHinh.add(lblHinh);
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setBounds(326, 0, 298, 441);
		pnTongQuanDangNhap.add(pnDangNhap);
		pnDangNhap.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("T\u00C0I KHO\u1EA2N");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTaiKhoan.setBounds(36, 140, 76, 20);
		pnDangNhap.add(lblTaiKhoan);
		
		txtfMatKhau = new JTextField();
		txtfMatKhau.setBounds(141, 195, 86, 20);
		pnDangNhap.add(txtfMatKhau);
		txtfMatKhau.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("M\u1EACT KH\u1EA8U");
		lblMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMatKhau.setBounds(36, 195, 76, 27);
		pnDangNhap.add(lblMatKhau);
		
		JButton btnDangNhap = new JButton("\u0110\u0102NG NH\u1EACP");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TrangChuGUI trangchu=TrangChuGUI.getInstance();
				trangchu.getFrmTrangChu().setVisible(true);
			}
		});
		btnDangNhap.setBackground(SystemColor.textHighlight);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDangNhap.setBounds(10, 293, 120, 41);
		pnDangNhap.add(btnDangNhap);
		
		JButton btnThoat = new JButton("THO\u00C1T");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThoat.setBackground(SystemColor.textHighlight);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnThoat.setBounds(158, 293, 120, 41);
		pnDangNhap.add(btnThoat);
		
		txtfTaiKhoan = new JTextField();
		txtfTaiKhoan.setBounds(141, 137, 86, 20);
		pnDangNhap.add(txtfTaiKhoan);
		txtfTaiKhoan.setColumns(10);
		
		JLabel lblDangNhap = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblDangNhap.setBounds(80, 57, 149, 35);
		pnDangNhap.add(lblDangNhap);
		lblDangNhap.setForeground(Color.BLUE);
		lblDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 24));
	}

}
