package DTO;

public class TacGiaDTO {
	private String maTacGia;
	private String tenTacGia;
	public TacGiaDTO(String maTacGia, String tenTacGia) {
		super();
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	
	
}
