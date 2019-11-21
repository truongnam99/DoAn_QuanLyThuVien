package GUI;

import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuanTriHeThongGUI {

	private JFrame frmMain;
	private JPanel pnMain;
	private static QuanTriHeThongGUI instance = null;
	private JPanel pnFunc;
	
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
		pnFunc = QLNhanVienGUI.getInstance().getPnTongQuanQLNhanVien();
		frmMain.setBounds(100, 100, 1065, 650);//595
		frmMain.getContentPane().add(pnMain);
		pnMain.add(pnFunc);
		//frmMain.setBounds(100, 595, 1065, 55);
	}
	
}
