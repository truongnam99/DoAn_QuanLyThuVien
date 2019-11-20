package DTO;

import java.util.Date;

public class SachDTO {
	private String maSach;
	private String tenSach;
	private String maTacGia;
	private String maTheLoai;
	private String nhaXuatBan;
	private Date namXuatBan;
	private Date ngayNhap;
	private String giaSach;
	private String trangThai;
	
	public void setNamXuatBan(Date namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	public SachDTO() {
		super();
	}
	
	public SachDTO(String maSach, String tenSach, String maTacGia,String maTheLoai, String nhaXuatBan, Date ngayNhap, String giaSach, String trangThai, Date namXuatBan)
	{
		super();
		this.maSach=maSach;
		this.tenSach=tenSach;
		this.maTacGia=maTacGia;
		this.maTheLoai=maTheLoai;
		this.nhaXuatBan=nhaXuatBan;
		this.ngayNhap=ngayNhap;
		this.giaSach=giaSach;
		this.trangThai=trangThai;
		this.namXuatBan=namXuatBan;
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
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
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	
	public Date getNamXuatBan() {
		return namXuatBan;
	}
	public Date getNgayNhap() {
		return ngayNhap;
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
	
}
