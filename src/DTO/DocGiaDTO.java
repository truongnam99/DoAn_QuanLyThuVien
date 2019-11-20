package DTO;

import java.sql.Date;

public class DocGiaDTO {
	
	private String maDocGia;
	private String tenDocGia;
	private LoaiDocGiaDTO loaiDocGia;
	private String lopMon;
	private Date ngaySinh;
	private String sdt;
	private String Email;
	
	public DocGiaDTO() {
		super();
	}
	public DocGiaDTO(String maDocGia, String tenDocGia, LoaiDocGiaDTO loaiDocGia, String lopMon, Date ngaySinh, String sdt) {
		super();
		this.maDocGia = maDocGia;
		this.tenDocGia = tenDocGia;
		this.loaiDocGia = loaiDocGia;
		this.lopMon = lopMon;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
	}
	public String getMaDocGia() {
		return maDocGia;
	}
	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}
	public String getTenDocGia() {
		return tenDocGia;
	}
	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
	}
	public LoaiDocGiaDTO getLoaiDocGia() {
		return loaiDocGia;
	}
	public void setLoaiDocGia(LoaiDocGiaDTO loaiDocGia) {
		this.loaiDocGia = loaiDocGia;
	}
	public String getLopMon() {
		return lopMon;
	}
	public void setLopMon(String lopMon) {
		this.lopMon = lopMon;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
