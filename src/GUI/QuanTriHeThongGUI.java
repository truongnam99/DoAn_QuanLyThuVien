package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuanTriHeThongGUI {

	private JFrame frmMain;
	private JPanel pnMain;
	private static QuanTriHeThongGUI instance = null;
	
	private QuanTriHeThongGUI(){
		init();
	}
	
	public static QuanTriHeThongGUI getInstance() {
		if (instance == null)
			instance = new QuanTriHeThongGUI();
		return instance;
	}
	
	public JFrame getFrmMain() {
		return frmMain;
	}
	
	void init() {
		frmMain = new JFrame("Quản lý thư viện");
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pnMain = QLNhanVienGUI.getInstance().getPnTongQuanQLNhanVien();
		pnMain = QLDocGiaGUI.getInstance().getPnMain();
		frmMain.setBounds(100, 100, 1065, 595);
		frmMain.getContentPane().add(pnMain);
	}
	
}
