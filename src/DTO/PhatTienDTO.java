package DTO;

import java.util.Date;

public class PhatTienDTO {
	private String maLanPhat;
	private String soTien;
	private String maDocGia;
	private Date ngayPhat;
	private String lyDo;
	
	public PhatTienDTO() {
		super();
	}
	
	public PhatTienDTO(String maLanPhat, String soTien, String maDocGia, Date ngayPhat, String lyDo) {
		super();
		this.maLanPhat = maLanPhat;
		this.soTien = soTien;
		this.maDocGia = maDocGia;
		this.ngayPhat = ngayPhat;
		this.lyDo = lyDo;
	}

	public String getMaLanPhat() {
		return maLanPhat;
	}

	public void setMaLanPhat(String maLanPhat) {
		this.maLanPhat = maLanPhat;
	}

	public String getSoTien() {
		return soTien;
	}

	public void setSoTien(String soTien) {
		this.soTien = soTien;
	}

	public String getMaDocGia() {
		return maDocGia;
	}

	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}

	public Date getNgayPhat() {
		return ngayPhat;
	}

	public void setNgayPhat(Date ngayPhat) {
		this.ngayPhat = ngayPhat;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
}
