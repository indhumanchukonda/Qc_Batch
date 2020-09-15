package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class DBReturn extends QCStore{

	public static void  FirstInstproc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;
		Statement stmt2 = null;
		

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QC_AUTOM_DEC1019"," QCautoMDEC216");
			test.log(LogStatus.PASS, "Connecting to DB ");
			*/
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_APR0820"," QCautoApR028");
			test.log(LogStatus.PASS, "Connecting to DB ");
*/
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_29JUN20"," QCHautoJUN29241");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCH_WILDFLYAUTO_JUL1220"," QCHWilDflYaUtOjul1220");
			test.log(LogStatus.PASS, "Connecting to DB ");

			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_APR0820_REP"," QCHautoaprrep2241");
			test.log(LogStatus.PASS, "Connecting to DB ");
*/
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QC_AUTOM_JAN3020","QcAUTOjaN3020");
			test.log(LogStatus.PASS, "Connecting to DB ");
		*/
			
		/*	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCAUTOM_FEB1720_19C"," QCautomFeb172");
			test.log(LogStatus.PASS, "Connecting to DB ");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		stmt2 = conn.createStatement();
		//loan_nbr="10864347";
		String schedule_id="1220";
		try {
			
			stmt.executeQuery("update REPAY_DEPOSIT_SCHEDULE set CC_info_key='123456789126' where installment_nbr=1 and loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Executing the query with loan number"+loan_nbr);
			test.log(LogStatus.PASS, "Updating the CC_info_key to 123456789126");
			
			stmt.executeQuery("update SCHEDULE_ATTR set IS_PROCESSED='NOP' where SCHEDULE_ID="+schedule_id);
			test.log(LogStatus.PASS, "Updating the Is_Processed to NOP");
			
			resultSet =stmt2.executeQuery("select loan_code,status_id,response_code,CC_info_key from REPAY_DEPOSIT_SCHEDULE where CC_info_key='123456789126' and loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Verifying where LOAN is returned or not");
			test.log(LogStatus.PASS, "Waiting for records to be updated");
			Thread.sleep(60000);
	
			
			
			
			while (resultSet .next()){
			
				rowValues.add(resultSet.getString(2)); 
				
				 test.log(LogStatus.PASS, "Getting values from the tables Response_code with the loan number"+loan_nbr);
				 for(String value: rowValues)
					{
				 
				 if(value.equalsIgnoreCase("ERROR"))
					{
						System.out.println("Value of Response_code is ERROR");
						test.log(LogStatus.PASS, "Value of Response_code is ERROR");
						test.log(LogStatus.PASS, "Loan returned successfully");
						
					}
					else 
					{
						System.out.println("Value of Response_code is "+ value);
						test.log(LogStatus.PASS, "Value of Response_code is "+value);
						test.log(LogStatus.PASS, "Loan not returned");
						
					}
			}
				 }
			 
			 
			
			
			
				
				
		

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	public static void  SecondInstproc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;
		Statement stmt2 = null;
		

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCAUTOM_FEB1720_19C"," QCautomFeb172");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QC_AUTOM_DEC1019",
					"QCautoMDEC216");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_APR0820_REP"," QCHautoaprrep2241");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_APR0820"," QCautoApR028");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_29JUN20"," QCHautoJUN29241");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCH_WILDFLYAUTO_JUL1220"," QCHWilDflYaUtOjul1220");
			test.log(LogStatus.PASS, "Connecting to DB ");
			
			/*
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QC_AUTOM_JAN3020","QcAUTOjaN3020");
			test.log(LogStatus.PASS, "Connecting to DB ");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		stmt2 = conn.createStatement();
		//loan_nbr="10863894";
		String schedule_id="1220";
		try {
			
			stmt.executeQuery("update REPAY_DEPOSIT_SCHEDULE set CC_info_key='123456789126' where installment_nbr=2 and loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Executing the query with loan number"+loan_nbr);
			test.log(LogStatus.PASS, "Updating the CC_info_key to 123456789126");
			
			stmt.executeQuery("update SCHEDULE_ATTR set IS_PROCESSED='NOP' where SCHEDULE_ID="+schedule_id);
			test.log(LogStatus.PASS, "Updating the Is_Processed to NOP");
			
			resultSet =stmt2.executeQuery("select loan_code,status_id,response_code,CC_info_key from REPAY_DEPOSIT_SCHEDULE where CC_info_key='123456789126' and loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Verifying where LOAN is returned or not");
			test.log(LogStatus.PASS, "Waiting for records to be updated");
			Thread.sleep(75000);
	
			
			
			
			while (resultSet .next()){
			
				rowValues.add(resultSet.getString(2)); 
				
				 test.log(LogStatus.PASS, "Getting values from the tables Response_code with the loan number"+loan_nbr);
				 for(String value: rowValues)
					{
				 
				 if(value.equalsIgnoreCase("ERROR"))
					{
						System.out.println("Value of Response_code is ERROR");
						test.log(LogStatus.PASS, "Value of Response_code is ERROR");
						test.log(LogStatus.PASS, "Loan returned successfully");
						
					}
					else 
					{
						System.out.println("Value of Response_code is "+ value);
						test.log(LogStatus.PASS, "Value of Response_code is "+value);
						test.log(LogStatus.PASS, "Loan not returned");
						
					}
			}
				 }
			 			 																			

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	
	public static void  Redepositproc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;
		Statement stmt2 = null;
		//Statement stmt3 = null;
		
		

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QC_AUTOM_DEC1019",
					"QCautoMDEC216");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_APR0820_REP"," QCHautoaprrep2241");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_APR0820"," QCautoApR028");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCHAUTO_29JUN20"," QCHautoJUN29241");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCH_WILDFLYAUTO_JUL1220"," QCHWilDflYaUtOjul1220");
			test.log(LogStatus.PASS, "Connecting to DB ");

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QC_AUTOM_JAN3020","QcAUTOjaN3020");
			test.log(LogStatus.PASS, "Connecting to DB ");*/

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1","QCAUTOM_FEB1720_19C"," QCautomFeb172");
			test.log(LogStatus.PASS, "Connecting to DB ");*/
		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		stmt2 = conn.createStatement();
		//stmt3 = conn.createStatement();
		//loan_nbr="10864338";
		//String schedule_id="1220";
		try {
			
			stmt.executeQuery("update repay_deposit_schedule set IS_REPRESENTMENT_NEXT='N',IS_AUTO_REPRESENTMENT='N' where cc_info_key=123456789126 and loan_code="+loan_nbr);
			test.log(LogStatus.PASS, "Executing the query with loan number"+loan_nbr);
			test.log(LogStatus.PASS, "Updating the CC_info_key to 123456789126");
			
			resultSet =stmt2.executeQuery("select bo_code from REPAY_DEPOSIT_SCHEDULE where CC_info_key='123456789126' and loan_code="+loan_nbr);
			
			Thread.sleep(75000);
			while (resultSet.next()){
			
			bo_code= resultSet.getString(1);
			test.log(LogStatus.PASS, "Bo_code is "+bo_code);	
			
			}
			
			stmt.executeQuery("update BO_CARD_DETAILS set EPAY_TOKEN_NUMBER ='123456789126' where bo_code="+bo_code);
			test.log(LogStatus.PASS, "Executing the query with bo_code"+bo_code);
			test.log(LogStatus.PASS, "Updating the EPAY_TOKEN_NUMBER to 123456789126");
			Thread.sleep(75000);
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

}
