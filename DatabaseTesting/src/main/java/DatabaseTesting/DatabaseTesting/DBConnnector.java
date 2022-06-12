package DatabaseTesting.DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

import ErrorThrow.OrderingErrorOccured;

public class DBConnnector {

		/**
		 * This method creates a db connection, executes given querry in the db nd return the resul set.
		 * @param url
		 * @param username
		 * @param password
		 * @param querry
		 * @return
		 * @throws SQLException
		 * @throws Exception
		 */
		private static ResultSet getResultFromPostgreSQLDb(String url, String username, String password, String querry) throws SQLException {
			Connection connection = null; 
			Statement statement = null;
			connection = DriverManager.getConnection(url, username, password); 
			statement = connection.createStatement(); 
			ResultSet result = statement.executeQuery(querry); 
			connection.close(); 
			return result;
		}

		
		/**
		 * This method is used to get supplier make code.
		 * @param make
		 * @return
		 * @throws Exception
		 */
		public static String getMakeCode(String make) throws Exception {
//			System.out.println("Db host name: " + CommonPage.getCredetialsData("orderingDbHostNameQA"));
//			System.out.println("Db username: " + CommonPage.getCredetialsData("orderingDbUsernameQA"));
//			System.out.println("Db password: " + CommonPage.getCredetialsData("orderingDbPasswordQA"));
//			String dbUrl = CommonPage.getCredetialsData("orderingDbHostNameQA");
//			String username = CommonPage.getCredetialsData("orderingDbUsernameQA");
//			String password = SimpleStringCipher.decrypt(CommonPage.getCredetialsData("orderingDbPasswordQA"));
			String makeCode = null;
			//String query = "select cv.code_value from common.code_value cv where cv.code_value_name = '"+ make +"' and cv.code_type_cd = 'SUPP';";
			String query = "select si_make_cd from ordering.manufacturer_make_xref where upper(mf_make_desc) =upper('"+ make +"') and ymm_src_id =1;";
			System.out.println("Db query: " + query);
			String dbUrl = null;
			String username = null;
			String password = null;
			ResultSet result = DBConnnector.getResultFromPostgreSQLDb(dbUrl, username, password, query);
			while (result.next()) {			
				makeCode = result.getString("si_make_cd");			
			}
			if(Objects.isNull(makeCode)) {
				throw new OrderingErrorOccured("makeCode value is null");
			}
			return makeCode.trim();
		}
		
		
		public static Map<String, ArrayList<String>> getBridgingOutput(String logNumber) throws Exception {
//			System.out.println("Db host name: " + CommonPage.getCredetialsData("orderingDbHostNameQA"));
//			System.out.println("Db username: " + CommonPage.getCredetialsData("orderingDbUsernameQA"));
//			System.out.println("Db password: " + CommonPage.getCredetialsData("orderingDbPasswordQA"));
//			String dbUrl = CommonPage.getCredetialsData("orderingDbHostNameQA");
//			String username = CommonPage.getCredetialsData("orderingDbUsernameQA");
//			String password = SimpleStringCipher.decrypt(CommonPage.getCredetialsData("orderingDbPasswordQA"));
			Map<String, ArrayList<String>> output = null ;// = new Map<>();
			String query = "SELECT bridge_action,target,status FROM bridging.bridge_record where log_no="+logNumber+" order by target asc;";
			System.out.println("Query: "+query);
			String dbUrl = null;
			String username = null;
			String password = null;
			ResultSet result = DBConnnector.getResultFromPostgreSQLDb(dbUrl, username, password, query);
			int columnCount = result.getMetaData().getColumnCount();
			for(int i =1 ; i<=columnCount;i++) {
				output.put(result.getMetaData().getColumnName(i), new ArrayList<String>());
			}
			System.out.println(output.entrySet());
			while(result.next()) {
				int j= 1;
				for(Map.Entry<String, ArrayList<String>> e : output.entrySet()) {
					e.getValue().add(result.getString(j));
					j++;
				}
			}
			output.entrySet().stream().forEach(e->System.out.println(e.getKey() + e.getValue()));
			return output;
		}
		

		/**
		 * This method verifies the target, bridge_action, status column data of bridgingTable of Ordering DB for add order..
		 * @throws Exception
		 */
		public static void addBridgingTableDataValidation() throws Exception {
//			Map<String, ArrayList<String>> output = DBConnnector.getBridgingOutput(null);
//			List<String> bridgeActionExpectedColumnData = Arrays.asList(CommonPage.getTestData("Bridge_action").split("\\|")).stream().sorted().collect(Collectors.toList());
//			List<String> targetExpectedColumnData = Arrays.asList(CommonPage.getTestData("Target").split("\\|")).stream().sorted().collect(Collectors.toList());
//			List<String> statusExpectedColumnData = Arrays.asList(CommonPage.getTestData("Status").split("\\|")).stream().sorted().collect(Collectors.toList());
//			Assert.assertEquals(output.get("target").stream().sorted().collect(Collectors.toList()),targetExpectedColumnData,"target column data dosen't match with the expected target column data");
//			Assert.assertEquals(output.get("bridge_action").stream().sorted().collect(Collectors.toList()), bridgeActionExpectedColumnData, "bridge_action column data dosen't match with the expected bridge_action column data");
//			Assert.assertEquals(output.get("status").stream().sorted().collect(Collectors.toList()),statusExpectedColumnData, "status column data dosen't match with the expected status column data");
		}
		
}
