package DTO;

public class SachTacGiaDTO {
	private String maSach;
	private String maTacGia;
	public SachTacGiaDTO(String maSach, String maTacGia) {
		super();
		this.maSach = maSach;
		this.maTacGia = maTacGia;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	
	
}
