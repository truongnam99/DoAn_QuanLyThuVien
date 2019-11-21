package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;

import DTO.*;
import MyException.ContainException;

public class DocGiaDAL {

	private static DocGiaDAL instance;
	private ArrayList<DocGiaDTO> dsDocGia;
	private ArrayList<LoaiDocGiaDTO> dsLoaiDocGia;
	private DocGiaDAL() {
		dsDocGia = new ArrayList<DocGiaDTO>();
		dsLoaiDocGia = new ArrayList<LoaiDocGiaDTO>();
	}
	
	public static DocGiaDAL getInstance() {
		if (instance == null)
			instance = new DocGiaDAL();
		return instance;
	}
	
	public boolean isContain(DocGiaDTO dg) {
		for (DocGiaDTO item: dsDocGia)
			if (item.getMaDocGia().equals(dg.getMaDocGia()))
				return true;
		return false;
	}
	
	public int addProcessing(DocGiaDTO dg) throws ContainException{
		if (isContain(dg))
			throw new ContainException("Độc giả đã tồn tại");
		String query = "insert into docgia values(\"" + dg.getMaDocGia()+"\", \""+ dg.getTenDocGia()+"\", \""+ dg.getLoaiDocGia().getMaLoaiDocGia()+"\", \""+ 
				dg.getLopMon()+ "\", \""+ dg.getNgaySinh()+"\", \"" + dg.getSdt() +"\", \""+ dg.getEmail()+"\")";
		int result = DAL.getInstance().executeQueryUpdate(query);
		if (result>0)
			dsDocGia.add(dg);
		return result;
	}
	
	public int changeProcessing(DocGiaDTO dg) {
		int result;
		String query = "update docgia set LopMon=\"" + dg.getLopMon()+"\", MaLoaiDocGia=\"" + dg.getLoaiDocGia().getMaLoaiDocGia()+"\", Email=\""
				+dg.getEmail()+"\",  std=\""+dg.getSdt()+"\", TenDocGia=\""+dg.getTenDocGia() +"\",  ngaySinh=\""+dg.getNgaySinh()+"\" where MaDocGia=\"" +dg.getMaDocGia()+"\"";
		System.out.println("Query = "+ query);
		result = DAL.getInstance().executeQueryUpdate(query);
		
		if (result > 0)
			for (int i = 0; i<dsDocGia.size(); i++) {
				DocGiaDTO e = dsDocGia.get(i);
				if (e.getMaDocGia().equals(dg.getMaDocGia()))
				{
					dsDocGia.set(i, dg);
					break;
				}
			}
		return result;
	}
	
	public int deleteProcessing(String madg) {
		int result = DAL.getInstance().executeQueryUpdate("delete from docgia where MaDocGia=\""+ madg +"\"");
		if (result > 0)
			for (int i = 0; i <dsDocGia.size(); i++) {
				if (dsDocGia.get(i).getMaDocGia().equals(madg))
					dsDocGia.remove(i);
			}
		return result;
	}
	public ArrayList<DocGiaDTO> getResources(JComboBox<LoaiDocGiaDTO> cbbLoaiDocGia){
		try {			
			String query = new String("select * from loaidocgia");
			ResultSet resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			cbbLoaiDocGia.addItem(new LoaiDocGiaDTO("", ""));
			while(resultSet.next()) {
				LoaiDocGiaDTO item = new LoaiDocGiaDTO(resultSet.getObject(1).toString(), resultSet.getObject(2).toString());
				dsLoaiDocGia.add(item);
				cbbLoaiDocGia.addItem(item);
			}
			
			query = new String("select * from docgia");
			resultSet = DAL.getInstance().executeQueryToGetData(query);
			
			while (resultSet.next()) {
				String maLoaiDocGia = resultSet.getObject(3).toString();
				LoaiDocGiaDTO ldg = null;
				
				for(LoaiDocGiaDTO item: dsLoaiDocGia) {
					if (item.getMaLoaiDocGia().equals(maLoaiDocGia)){
						ldg = item;
						break;
					}
				}
				
				String tmpEmail;
				try{
					tmpEmail = resultSet.getObject(7).toString();
				}catch(NullPointerException e) {
					tmpEmail = "";
				}
				dsDocGia.add(new DocGiaDTO(resultSet.getObject(1).toString(), resultSet.getObject(2).toString(), ldg, resultSet.getObject(4).toString(), 
						Date.valueOf(resultSet.getObject(5).toString()),
						resultSet.getObject(6).toString(),
						tmpEmail));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return dsDocGia;
	}
	
	public ArrayList<DocGiaDTO> reloadResources(){
		return dsDocGia;
	}
}
