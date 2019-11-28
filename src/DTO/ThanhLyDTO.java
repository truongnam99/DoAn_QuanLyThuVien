package DTO;

import java.sql.Date;

public class ThanhLyDTO {
	private String maThanhLy;
	private Date ngayThanhLy;
	private String lyDo;
	public String getMaThanhLy() {
		return maThanhLy;
	}
	public void setMaThanhLy(String maThanhLy) {
		this.maThanhLy = maThanhLy;
	}
	public Date getNgayThanhLy() {
		return ngayThanhLy;
	}
	public void setNgayThanhLy(Date ngayThanhLy) {
		this.ngayThanhLy = ngayThanhLy;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public ThanhLyDTO(String maThanhLy, Date ngayThanhLy, String lyDo) {
		super();
		this.maThanhLy = maThanhLy;
		this.ngayThanhLy = ngayThanhLy;
		this.lyDo = lyDo;
	}
}
