package DTO;

import java.sql.Date;

public class MuonTraDTO {
	
	private DocGiaDTO docGia;
	private SachDTO sach;
	private Date ngayMuon;
	private Date ngayTra;
	private String TrangThai;
	
	public MuonTraDTO() {
		super();
	}
	public MuonTraDTO(DocGiaDTO docGia,  SachDTO sach, Date ngayMuon,Date ngayTra,String TrangThai) {
		super();
		
		this.docGia = docGia;
		this.sach=sach;
		this.ngayMuon = ngayMuon;
		this.ngayTra=ngayTra;
		this.TrangThai=TrangThai;
	}
	public DocGiaDTO getDocGia() {
		return docGia;
	}
	public void setDocGia(DocGiaDTO docGia) {
		this.docGia = docGia;
	}
	public SachDTO getSach() {
		return sach;
	}
	public void setSach(SachDTO sach) {
		this.sach = sach;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
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
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
}
