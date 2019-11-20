package DTO;

public class TheLoaiDTO {
	private String tenTheLoai;
	private String maTheLoai;
	public TheLoaiDTO(String tenTheLoai, String maTheLoai) {
		super();
		this.tenTheLoai = tenTheLoai;
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	
}
