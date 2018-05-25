package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC ==> Java Database  Connectivity
//			�ڹٸ� �̿��Ͽ� DB�� �����Ͽ� ����ϴ� ���

// JDBC�� ����Ϸ��� �ش� ������Ʈ�� build path�� JDBC���̺귯���� ����ؾ� �Ѵ�.
// JDBC ���̺귯���� �����Ϸ��� DBȸ�翡�� ������ �ش�.
//

public class JdbcTest01 {
	
	/*
	 �����ͺ��̽� ó������
	 	1. ����̹� �ε� ==> DB���� �۾��� ������ �� �ִ� Ŭ������ �޸𸮿� �ε��ϴ� �۾�
	 		Class.forName("oracle.jdbc.driver.OracleDriver");
	 		
	 	2. DB�� �����ϱ� ==> ������ �Ϸ�Ǹ� Connection��ü�� ���� �� �ִ�.
	 		DriverManager.getConnection() �޼��带 �̿��Ѵ�.
	 		
	 	3. ����(SQL���� �����Ѵ�.) ==> Statement��ü �Ǵ� PreparedStatement��ü�� �̿��Ͽ� 
	 								SQL����� DB�� �����Ͽ� �����ϰ�, ����� ����� �޾ƿ´�.
	 	
	 	4. ���� ����� �޾Ƽ� ó���ϱ�
	 		1) SQL���� 'select'���� ��� ==> ResultSet��ü�� ��������� �� ResultSet��ü�� 'select'�� ����� ����.
	 		2) SQL���� 'insert', 'update', 'delete'�� 'select'���� �ƴҰ�� 
	 			==> ó���� ����� �������� ��ȯ�ȴ�. �� �������� �ǹ̴� ó���� '���ڵ� ��'�� �ǹ��Ѵ�.
	 	
	 	5. ���� ==> ����ߴ� ��ü���� �ڿ��� �ݳ��Ѵ�.
	 			(ResultSet, Statement, PreparedStatement, Connect)
	  */
	
	public static void main(String[] args) {
		//DB�۾��� �ʿ��� ��ü ���� ����
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;	//�������� 'select'�� ��� �ʿ�
		
		try {
			//1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB���� ==> Connection��ü ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";			//localhost �ڽ��� ��ǻ��		�ٸ���ǻ���ǰ�� IP�ּ� ����ȴ�.
			String user = "pc17";
			String pass = "java";
			conn = DriverManager.getConnection(url, user, pass);
			
			//3. Statement��ü ����
			//	(Statement��ü�� Connection��ü�� �̿��ؼ� �����Ѵ�.)
			stmt = conn.createStatement();
			
			//4. SQL���� Statement��ü�� �̿��Ͽ� �����ϰ� �������� ResultSet��ü�� �����Ѵ�.
			String sql = "select * from lprod";
			rs = stmt.executeQuery(sql);
			
			 //5. ��� ó�� ==> ResultSet��ü�� ����Ǿ� �ִ� �ڷḦ �ݺ����� �̿��Ͽ� ���ʷ� �о�� ó���Ѵ�.
			System.out.println("== ���� ��� ==");
			
			//ResultSet��ü�� ����ִ� ������(���ڵ�)�� �����ϱ�����
			//���� �۾��� �����ϴ� ���ڵ带 ����Ű�� ���� �ִµ� �̰��� Ŀ��(Cursor)�� �Ѵ�.
			//next()�޼���� �� Ŀ���� ��ġ�� ���� ���ڵ� ��ġ�� �̵���Ű��
			//�� �ڸ��� �����Ͱ� ������ true, ������ false�� ��ȯ�Ѵ�.
			System.out.println("========================================================");
			while(rs.next()){
				//Į���� �����͸� �������� ���ؼ��� 'get�ڷ����̸�()'�޼��带 ����ϴµ�
				//�� �޼����� �Ű������� 'Į����' �Ǵ� 'Į����ȣ'�� �����ϸ� �ȴ�. (Į����ȥ�� 1������ �����Ѵ�.)
//				System.out.print("Lprod_id : " + rs.getInt("lprod_id") + "\t");
				System.out.print("Lprod_id : " + rs.getInt(1) + "\t");
				System.out.print("Lprod_gu : " + rs.getString("lprod_gu")+ "\t");
				System.out.print("Lprod_nm : " + rs.getString("lprod_nm")+ "\t");
				System.out.println();
			}
			System.out.println("========================================================");
			System.out.println("��³�....");
			
//			rs.afterLast();
//			rs.beforeFirst();
//			rs.first();
//			rs.last();			
//			rs.previous();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6.����ߴ� �ڿ� �ݳ�
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}

		
	}
}
