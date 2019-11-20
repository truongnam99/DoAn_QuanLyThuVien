package DTO;

public class QuyDinhDTO {
	private String maQuyDinh;
	private String tenQuyDinh;
	public QuyDinhDTO(String maQuyDinh, String tenQuyDinh) {
		super();
		this.maQuyDinh = maQuyDinh;
		this.tenQuyDinh = tenQuyDinh;
	}
	public String getMaQuyDinh() {
		return maQuyDinh;
	}
	public void setMaQuyDinh(String maQuyDinh) {
		this.maQuyDinh = maQuyDinh;
	}
	public String getTenQuyDinh() {
		return tenQuyDinh;
	}
	public void setTenQuyDinh(String tenQuyDinh) {
		this.tenQuyDinh = tenQuyDinh;
	}
	
	
}
