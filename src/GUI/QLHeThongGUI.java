package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import BLL.QLHeThongBLL;
import DAL.DAL;
import DTO.HeThongDTO;


public class QLHeThongGUI {
	private JTextField txtfSoSachMuonHS;
	private JTextField txtfThoiGianMuonHS;
	private JTextField txtfTienPhatHS;
	private JTextField txtSachHongHS;
	private JTextField txtMatSachHS;

	
	
	private JTextField txtfSoSachMuonGV;
	private JTextField txtfThoiGianMuonGV;
	private JTextField txtfTienPhatGV;
	private JTextField txtSachHongGV;
	private JTextField txtMatSachGV;
	
	private JPanel pnTongQuanQLQuyDinh;
	
	static QLHeThongGUI instance=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	
	
	void clearField() {
		txtfSoSachMuonHS.setText("");
		txtfThoiGianMuonHS.setText("");
		txtfTienPhatHS.setText("");
		txtSachHongHS.setText("");
		txtMatSachHS.setText("");

		
		
		txtfSoSachMuonGV.setText("");
		txtfThoiGianMuonGV.setText("");
		txtfTienPhatGV.setText("");
		txtSachHongGV.setText("");
		txtMatSachGV.setText("");
	}
	
	
	
	private QLHeThongGUI(){
		initialize();
		loadResources();
	}
	
	
	
	
	
	//IN LÊN MÀN HÌNH
	private void loadResources() {
		
		
		ArrayList<HeThongDTO> dsHeThong = QLHeThongBLL.getInstance().getResources();
		txtfSoSachMuonHS.setText(dsHeThong.get(0).getGiaTri());
		txtfThoiGianMuonHS.setText(dsHeThong.get(1).getGiaTri());
		txtfTienPhatHS.setText(dsHeThong.get(2).getGiaTri());
		txtSachHongHS.setText(dsHeThong.get(3).getGiaTri());
		txtMatSachHS.setText(dsHeThong.get(4).getGiaTri());
		
		txtfSoSachMuonGV.setText(dsHeThong.get(5).getGiaTri());
		txtfThoiGianMuonGV.setText(dsHeThong.get(6).getGiaTri());
		txtfTienPhatGV.setText(dsHeThong.get(7).getGiaTri());
		txtSachHongGV.setText(dsHeThong.get(8).getGiaTri());
		txtMatSachGV.setText(dsHeThong.get(9).getGiaTri());
		
		textField.setText(dsHeThong.get(0).getDonVi());
		textField_1.setText(dsHeThong.get(1).getDonVi());
		textField_2.setText(dsHeThong.get(2).getDonVi());
		textField_3.setText(dsHeThong.get(3).getDonVi());
		textField_4.setText(dsHeThong.get(4).getDonVi());
		textField_5.setText(dsHeThong.get(5).getDonVi());
		textField_6.setText(dsHeThong.get(6).getDonVi());
		textField_7.setText(dsHeThong.get(7).getDonVi());
		textField_8.setText(dsHeThong.get(8).getDonVi());
		textField_9.setText(dsHeThong.get(9).getDonVi());
		
		//CĂN LỀ CỘT BÊN TRÁI
		txtfSoSachMuonHS.setHorizontalAlignment(SwingConstants.CENTER);
		txtfThoiGianMuonHS.setHorizontalAlignment(SwingConstants.CENTER);
		txtfTienPhatHS.setHorizontalAlignment(SwingConstants.CENTER);
		txtSachHongHS.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatSachHS.setHorizontalAlignment(SwingConstants.CENTER);
		
	
		//CĂN LỀ CỘT BÊN PHẢI
		txtfSoSachMuonGV.setHorizontalAlignment(SwingConstants.CENTER);
		txtfThoiGianMuonGV.setHorizontalAlignment(SwingConstants.CENTER);
		txtfTienPhatGV.setHorizontalAlignment(SwingConstants.CENTER);
		txtSachHongGV.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatSachGV.setHorizontalAlignment(SwingConstants.CENTER);
		
		
	}
	
	public static QLHeThongGUI getInstance() {
		if(instance == null)
			instance = new QLHeThongGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLHeThong() {
		return pnTongQuanQLQuyDinh;
	}
	public static void AppearRules() {
		//txtfSoSachMuonHS
		;
	}
	private void initialize() {
		
		pnTongQuanQLQuyDinh = new JPanel();
		pnTongQuanQLQuyDinh.setBackground(SystemColor.inactiveCaptionBorder);
		pnTongQuanQLQuyDinh.setBounds(0, 0, 1065, 560);
		pnTongQuanQLQuyDinh.setLayout(null);
		
		JPanel pnTieuDeQuyDinh = new JPanel();
		pnTieuDeQuyDinh.setBackground(SystemColor.activeCaption);
		pnTieuDeQuyDinh.setBounds(0, 0, 1065, 46);
		pnTongQuanQLQuyDinh.add(pnTieuDeQuyDinh);
		pnTieuDeQuyDinh.setLayout(null);
		
		JLabel lblQuyDinh = new JLabel("QUẢN LÝ QUY ĐỊNH");
		lblQuyDinh.setForeground(Color.RED);
		lblQuyDinh.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQuyDinh.setBounds(435, 5, 236, 35);
		pnTieuDeQuyDinh.add(lblQuyDinh);
		
		JPanel pnThongTinQuyDinh = new JPanel();
		pnThongTinQuyDinh.setBackground(SystemColor.activeCaption);
		pnThongTinQuyDinh.setBounds(0, 49, 1065, 511);
		pnTongQuanQLQuyDinh.add(pnThongTinQuyDinh);
		pnThongTinQuyDinh.setLayout(null);
		
		JLabel lblThongTinQuyDinh = new JLabel("THÔNG TIN QUY ĐỊNH");
		lblThongTinQuyDinh.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblThongTinQuyDinh.setBounds(5, 5, 219, 22);
		pnThongTinQuyDinh.add(lblThongTinQuyDinh);
		
		JPanel pnHocSinh = new JPanel();
		pnHocSinh.setBounds(82, 46, 396, 336);
		pnThongTinQuyDinh.add(pnHocSinh);
		pnHocSinh.setLayout(null);
		
		JLabel lblHocSinh = new JLabel("Học sinh");
		lblHocSinh.setBounds(5, 0, 59, 23);
		pnHocSinh.add(lblHocSinh);
		lblHocSinh.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JPanel pnThongTinHocSinh = new JPanel();
		pnThongTinHocSinh.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinHocSinh.setBounds(0, 22, 396, 314);
		pnHocSinh.add(pnThongTinHocSinh);
		pnThongTinHocSinh.setLayout(null);
		
		JLabel lblSoSachMuonHS = new JLabel("Số sách mượn tối đa:");
		lblSoSachMuonHS.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSoSachMuonHS.setBounds(10, 41, 144, 14);
		pnThongTinHocSinh.add(lblSoSachMuonHS);
		
		txtfSoSachMuonHS = new JTextField();
		txtfSoSachMuonHS.setBounds(181, 33, 122, 30);
		pnThongTinHocSinh.add(txtfSoSachMuonHS);
		txtfSoSachMuonHS.setColumns(10);
	
		
		
		JLabel lblThoiGianMuonHS = new JLabel("Thời gian mượn tối đa:");
		lblThoiGianMuonHS.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblThoiGianMuonHS.setBounds(10, 99, 144, 14);
		pnThongTinHocSinh.add(lblThoiGianMuonHS);
		
		txtfThoiGianMuonHS = new JTextField();
		txtfThoiGianMuonHS.setBounds(181, 91, 122, 30);
		pnThongTinHocSinh.add(txtfThoiGianMuonHS);
		txtfThoiGianMuonHS.setColumns(10);
		
		JLabel lblTienPhatHS = new JLabel("Tiền phạt mượn trễ:");
		lblTienPhatHS.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTienPhatHS.setBounds(10, 158, 144, 14);
		pnThongTinHocSinh.add(lblTienPhatHS);
		
		txtfTienPhatHS = new JTextField();
		txtfTienPhatHS.setBounds(181, 150, 122, 30);
		pnThongTinHocSinh.add(txtfTienPhatHS);
		txtfTienPhatHS.setColumns(10);
		
		JLabel lblSachHongHS = new JLabel("Sách bị hư hỏng:");
		lblSachHongHS.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSachHongHS.setBounds(10, 219, 122, 14);
		pnThongTinHocSinh.add(lblSachHongHS);
		
		JLabel lblMatSachHS = new JLabel("Mất sách:");
		lblMatSachHS.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMatSachHS.setBounds(10, 280, 122, 14);
		pnThongTinHocSinh.add(lblMatSachHS);
		
		txtSachHongHS = new JTextField("");
		txtSachHongHS.setHorizontalAlignment(SwingConstants.CENTER);
		txtSachHongHS.setBounds(181, 211, 122, 30);
		pnThongTinHocSinh.add(txtSachHongHS);
		txtSachHongHS.setColumns(10);
		txtfSoSachMuonHS.setLayout(null);
		
		
		txtMatSachHS = new JTextField("");
		txtMatSachHS.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatSachHS.setBounds(181, 272, 122, 30);
		pnThongTinHocSinh.add(txtMatSachHS);
		txtMatSachHS.setColumns(10);
		
		textField = new JTextField();
		textField.setText((String) null);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(310, 33, 76, 30);
		pnThongTinHocSinh.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(310, 91, 76, 30);
		pnThongTinHocSinh.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(310, 150, 76, 30);
		pnThongTinHocSinh.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText((String) null);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(310, 211, 76, 30);
		pnThongTinHocSinh.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(310, 272, 76, 30);
		pnThongTinHocSinh.add(textField_4);
		
		JPanel pnGiaoVien = new JPanel();
		pnGiaoVien.setBounds(596, 46, 392, 336);
		pnThongTinQuyDinh.add(pnGiaoVien);
		pnGiaoVien.setLayout(null);
		
		JLabel lblGiaoVien = new JLabel("Giáo viên");
		lblGiaoVien.setBounds(5, 0, 76, 22);
		pnGiaoVien.add(lblGiaoVien);
		lblGiaoVien.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JPanel pnThongTinGiaoVien = new JPanel();
		pnThongTinGiaoVien.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinGiaoVien.setBounds(0, 24, 392, 312);
		pnGiaoVien.add(pnThongTinGiaoVien);
		pnThongTinGiaoVien.setLayout(null);
		
		JLabel lblSoSachMuonGV = new JLabel("Số sách mượn tối đa:");
		lblSoSachMuonGV.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSoSachMuonGV.setBounds(10, 42, 144, 14);
		pnThongTinGiaoVien.add(lblSoSachMuonGV);
		
		txtfSoSachMuonGV = new JTextField();
		txtfSoSachMuonGV.setColumns(10);
		txtfSoSachMuonGV.setBounds(178, 33, 127, 30);
		pnThongTinGiaoVien.add(txtfSoSachMuonGV);
		
		JLabel lblThoiGianMuonGV = new JLabel("Thời gian mượn tối đa:");
		lblThoiGianMuonGV.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblThoiGianMuonGV.setBounds(10, 99, 144, 14);
		pnThongTinGiaoVien.add(lblThoiGianMuonGV);
		
		txtfThoiGianMuonGV = new JTextField();
		txtfThoiGianMuonGV.setColumns(10);
		txtfThoiGianMuonGV.setBounds(178, 91, 127, 30);
		pnThongTinGiaoVien.add(txtfThoiGianMuonGV);
		
		JLabel lblTienPhatGV = new JLabel("Tiền phạt mượn trễ:");
		lblTienPhatGV.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTienPhatGV.setBounds(10, 158, 127, 14);
		pnThongTinGiaoVien.add(lblTienPhatGV);
		
		txtfTienPhatGV = new JTextField();
		txtfTienPhatGV.setColumns(10);
		txtfTienPhatGV.setBounds(178, 150, 127, 30);
		pnThongTinGiaoVien.add(txtfTienPhatGV);
		
		JLabel lblNewLabel = new JLabel("Sách bị hư hỏng:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 219, 127, 14);
		pnThongTinGiaoVien.add(lblNewLabel);
		
		txtSachHongGV = new JTextField("");
		txtSachHongGV.setBounds(178, 211, 127, 30);
		pnThongTinGiaoVien.add(txtSachHongGV);
		txtSachHongGV.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mất sách:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 280, 108, 14);
		pnThongTinGiaoVien.add(lblNewLabel_1);
		
		txtMatSachGV = new JTextField("");

		txtMatSachGV.setBounds(178, 272, 127, 30);
		pnThongTinGiaoVien.add(txtMatSachGV);
		txtMatSachGV.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText((String) null);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(307, 33, 76, 30);
		pnThongTinGiaoVien.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText((String) null);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(307, 91, 76, 30);
		pnThongTinGiaoVien.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText((String) null);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(307, 150, 76, 30);
		pnThongTinGiaoVien.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText((String) null);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		textField_8.setBounds(307, 211, 76, 30);
		pnThongTinGiaoVien.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText((String) null);
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		textField_9.setBounds(307, 272, 76, 30);
		pnThongTinGiaoVien.add(textField_9);
		
		
		//LƯU
		JButton btnLuu = 	new JButton("Lưu");
		btnLuu.setBounds(223, 426, 139, 41);
		pnThongTinQuyDinh.add(btnLuu);
		btnLuu.setIcon(new ImageIcon("icon\\save.png"));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String query0 = "update quydinh set GiaTri=\""+txtfSoSachMuonHS.getText()+"\" where MaQuyDinh=\"QD000001\"";
				String query1 = "update quydinh set GiaTri=\""+txtfThoiGianMuonHS.getText()+"\" where MaQuyDinh=\"QD000002\"";
				String query2 = "update quydinh set GiaTri=\""+txtfTienPhatHS.getText()+"\" where MaQuyDinh=\"QD000003\"";
				String query3 = "update quydinh set GiaTri=\""+txtSachHongHS.getText()+"\" where MaQuyDinh=\"QD000004\"";
				String query4 = "update quydinh set GiaTri=\""+txtMatSachHS.getText()+"\" where MaQuyDinh=\"QD000005\"";
				
				
				String query5 = "update quydinh set GiaTri=\""+txtfSoSachMuonGV.getText()+"\" where MaQuyDinh=\"QD000006\"";
				String query6 = "update quydinh set GiaTri=\""+txtfThoiGianMuonGV.getText()+"\" where MaQuyDinh=\"QD000007\"";
				String query7 = "update quydinh set GiaTri=\""+txtfTienPhatGV.getText()+"\" where MaQuyDinh=\"QD000008\"";
				String query8 = "update quydinh set GiaTri=\""+txtSachHongGV.getText()+"\" where MaQuyDinh=\"QD000009\"";
				String query9 = "update quydinh set GiaTri=\""+txtMatSachGV.getText()+"\" where MaQuyDinh=\"QD000010\"";
				System.out.println(query0);
				
				DAL.getInstance().executeQueryUpdate(query0);
				
				  DAL.getInstance().executeQueryUpdate(query1);
				  DAL.getInstance().executeQueryUpdate(query2);
				  DAL.getInstance().executeQueryUpdate(query3);
				  DAL.getInstance().executeQueryUpdate(query4);
				  DAL.getInstance().executeQueryUpdate(query5);
				  DAL.getInstance().executeQueryUpdate(query6);
				  DAL.getInstance().executeQueryUpdate(query7);
				  DAL.getInstance().executeQueryUpdate(query8);
				  DAL.getInstance().executeQueryUpdate(query9);
				 
				

			}
		} );
		
		
		
		//HỦY
		
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(725, 426, 139, 41);
		pnThongTinQuyDinh.add(btnHuy);
		btnHuy.setIcon(new ImageIcon("icon\\setting.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//clearField();
				loadResources();
			}
		});
	}
}
