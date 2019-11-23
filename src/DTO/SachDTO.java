package DTO;

import java.util.Date;

public class SachDTO {
	private String maSach;
	private String tacGia;
	private String tenSach;
	private String theLoai;
	private String nhaXuatBan;
	private Date ngayNhap;
	private String giaSach;
	private String trangThai;
	private Date namXuatBan;
	
	public SachDTO() {
		super();
	}

	public SachDTO(String maSach, String tacGia, String tenSach, String theLoai, String nhaXuatBan, Date ngayNhap,
			String giaSach, String trangThai, Date namXuatBan) {
		super();
		this.maSach = maSach;
		this.tacGia = tacGia;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.nhaXuatBan = nhaXuatBan;
		this.ngayNhap = ngayNhap;
		this.giaSach = giaSach;
		this.trangThai = trangThai;
		this.namXuatBan = namXuatBan;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
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

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getGiaSach() {
		return giaSach;
	}

	public void setGiaSach(String giaSach) {
		this.giaSach = giaSach;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(Date namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	@Override
	public String toString() {
		return tenSach;
	}
}
