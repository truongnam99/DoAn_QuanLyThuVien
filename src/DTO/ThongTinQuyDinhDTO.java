package DTO;

public class ThongTinQuyDinhDTO {

	private String maQuyDinh;
	private String giaTri;
	public ThongTinQuyDinhDTO(String maQuyDinh, String giaTri) {
		super();
		this.maQuyDinh = maQuyDinh;
		this.giaTri = giaTri;
	}
	public String getMaQuyDinh() {
		return maQuyDinh;
	}
	public void setMaQuyDinh(String maQuyDinh) {
		this.maQuyDinh = maQuyDinh;
	}
	public String getGiaTri() {
		return giaTri;
	}
	public void setGiaTri(String giaTri) {
		this.giaTri = giaTri;
	}
	
	
}
