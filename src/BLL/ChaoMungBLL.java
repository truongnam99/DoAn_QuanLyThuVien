package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import GUI.QLChaoMung;

public class ChaoMungBLL {
	private static ChaoMungBLL instance;
	NhanVienDTO nv;
	
	private ChaoMungBLL() {
	
	}
	
	public static ChaoMungBLL GetInstance() {
		if (instance == null) {
			instance = new ChaoMungBLL();
		}
		return instance;
	}
	
	public void setNhanVien(NhanVienDTO nv) {
		this.nv = nv;
	}

	public void luu() {
		if (QLChaoMung.getInstance().tfMatKhau.getText().equals("")) {
			QLChaoMung.getInstance().lblMessage.setText("Mật khẩu đang bị trống");
			return;
		}
		if (QLChaoMung.getInstance().tfMatKhauMoi.getText().equals("")) {
			QLChaoMung.getInstance().lblMessage.setText("Mật khẩu mới đang bị trống");
			return;
		}
		if (QLChaoMung.getInstance().tfNhapLaiMatKhauMoi.getText().equals("")) {
			QLChaoMung.getInstance().lblMessage.setText("Nhập lại mật khẩu mới đang bị trống");
			return;
		}
		if(!QLChaoMung.getInstance().tfNhapLaiMatKhauMoi.getText().equals(QLChaoMung.getInstance().tfMatKhauMoi.getText())) {
			QLChaoMung.getInstance().lblMessage.setText("Nhập lại mật khẩu khác với Mật khẩu mới");
			return;
		}
		if (!QLChaoMung.getInstance().tfMatKhau.getText().equals(nv.getMatKhau())) {
			System.out.println(nv.getMatKhau());
			QLChaoMung.getInstance().lblMessage.setText("Mật khẩu sai");
			return;
		}
		nv.setMatKhau(QLChaoMung.getInstance().tfMatKhauMoi.getText());
		int result = NhanVienDAL.getInstance().changeProcessing(nv);
		if (result > 0) {
			QLChaoMung.getInstance().lblMessage.setText("Đổi mật khẩu thành công");
			QLChaoMung.getInstance().huyPro();
		}
		else
			QLChaoMung.getInstance().lblMessage.setText("Đổi mật khẩu thất bại");
	}
	
	public void LoadResources() {
		System.out.println(nv.getMaTaiKhoan());
		QLChaoMung.getInstance().tfMaNhanVien.setText(nv.getMaTaiKhoan());
		QLChaoMung.getInstance().tfChucVu.setText(nv.getLoaiTaiKhoan());
		QLChaoMung.getInstance().tfTenNhanVien.setText(nv.getTenNhanVien());
	}
	
	
}
