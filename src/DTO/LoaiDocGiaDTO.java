package DTO;

public class LoaiDocGiaDTO {

	private String maLoaiDocGia;
	private String tenLoaiDocGia;
	public LoaiDocGiaDTO() {
	}
	public LoaiDocGiaDTO(String maLoaiDocGia, String tenLoaiDocGia) {
		super();
		this.maLoaiDocGia = maLoaiDocGia;
		this.tenLoaiDocGia = tenLoaiDocGia;
	}
	public String getMaLoaiDocGia() {
		return maLoaiDocGia;
	}
	public void setMaLoaiDocGia(String maLoaiDocGia) {
		this.maLoaiDocGia = maLoaiDocGia;
	}
	public String getTenLoaiDocGia() {
		return tenLoaiDocGia;
	}
	public void setTenLoaiDocGia(String tenLoaiDocGia) {
		this.tenLoaiDocGia = tenLoaiDocGia;
	}
	@Override
	public String toString() {
		return tenLoaiDocGia;
	}
}