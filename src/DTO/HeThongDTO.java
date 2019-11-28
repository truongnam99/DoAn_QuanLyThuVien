package DTO;


public class HeThongDTO {
	
	private String MaQuyDinh;
	private String TenQuyDinh;
	private String GiaTri;
	private String DonVi;
	
	public HeThongDTO() {
		super();
	}

	public String getMaQuyDinh() {
		return MaQuyDinh;
	}

	public void setMaQuyDinh(String maQuyDinh) {
		MaQuyDinh = maQuyDinh;
	}

	public String getTenQuyDinh() {
		return TenQuyDinh;
	}

	public void setTenQuyDinh(String tenQuyDinh) {
		TenQuyDinh = tenQuyDinh;
	}

	public String getGiaTri() {
		return GiaTri;
	}

	public void setGiaTri(String giaTri) {
		GiaTri = giaTri;
	}

	public String getDonVi() {
		return DonVi;
	}

	public void setDonVi(String donVi) {
		DonVi = donVi;
	}

	public HeThongDTO(String maQuyDinh, String tenQuyDinh, String giaTri, String donVi) {
		super();
		MaQuyDinh = maQuyDinh;
		TenQuyDinh = tenQuyDinh;
		GiaTri = giaTri;
		DonVi = donVi;
	}
}
