package DTO;

import java.sql.Date;

public class MuonTraDTO {
	
	private String maDocGia;
	private String maSach;
	private Date ngayMuon;
	private Date ngayTra;
	private String TrangThai;
	
	public MuonTraDTO() {
		super();
	}
	public MuonTraDTO(String maDocGia,  String maSach, Date ngayMuon,Date ngayTra,String TrangThai) {
		super();
		
		this.maDocGia = maDocGia;
		this.maSach=maSach;
		this.ngayMuon = ngayMuon;
		this.ngayTra=ngayTra;
		this.TrangThai=TrangThai;
	}
	
	public String getMaDocGia() {
		return maDocGia;
	}
	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}
	
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String TrangThai) {
		this.TrangThai = TrangThai;
	}
}
