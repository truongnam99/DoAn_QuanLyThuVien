package DAL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.mysql.jdbc.Connection;

public class DAL {
	private static DAL instance;
	Connection con;
	private Statement st;
	private HashMap<String, String> values;
	private DAL() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("appconfig.txt"));
			String line;

			values = new HashMap<String, String>();
			while((line = br.readLine()) != null) {
				
				String []temp = line.split(":=");
				
				values.put(temp[0], temp[1]);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static DAL getInstance() {
		if(instance == null)
			instance = new DAL();
		return instance;
	}
	
	
	public boolean connectToDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(values.get("con"), values.get("user"), values.get("pass"));
			st = con.createStatement();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	// Thực hiện cho Update, delete, add
	// Return int cho so hàng bị thay đổi
	// Return 0 nếu không có hàng nào thay đổi
	public int executeQueryUpdate(String query) {
		try {

			if (con == null)
				connectToDatabase();
			return st.executeUpdate(query);
			
		}
		catch(Exception ex) {
			return -1;
		}
	}
	
	public boolean executeQuery(String query) {
		try {

			if (con == null)
				connectToDatabase();
			st.execute(query);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	// Trả về ResultSet tương ứng với bảng dữ liệu trong table
	public ResultSet executeQueryToGetData(String query) {
		try {
			if (con == null)
				connectToDatabase();
			return st.executeQuery(query);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
