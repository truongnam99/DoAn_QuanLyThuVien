package DTO;

import java.sql.Date;

public class ThanhLyDTO {

	private String maSach;
	private String tenSach;
	private String theLoai;
	private String tacGia;
	private String nhaXuatBan;
	private String lyDo;
	private Date thoiGianLuuKho;
	private Date ngayThanhLy;
	public ThanhLyDTO(String maSach, String tenSach, String theLoai, String tacGia, String nhaXuatBan, String lyDo,
			Date thoiGianLuuKho, Date ngayThanhLy) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.lyDo = lyDo;
		this.thoiGianLuuKho = thoiGianLuuKho;
		this.ngayThanhLy = ngayThanhLy;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public Date getThoiGianLuuKho() {
		return thoiGianLuuKho;
	}
	public void setThoiGianLuuKho(Date thoiGianLuuKho) {
		this.thoiGianLuuKho = thoiGianLuuKho;
	}
	public Date getNgayThanhLy() {
		return ngayThanhLy;
	}
	public void setNgayThanhLy(Date ngayThanhLy) {
		this.ngayThanhLy = ngayThanhLy;
	}
	
	
}
