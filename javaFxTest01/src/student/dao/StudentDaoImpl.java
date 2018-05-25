package student.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import student.vo.StudentVO;

public class StudentDaoImpl implements IStudentDao {
	private static StudentDaoImpl stdDao;
	
	private SqlMapClient smc;		//sql
	
	private StudentDaoImpl() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static StudentDaoImpl getInstance() {
		if(stdDao==null) stdDao = new StudentDaoImpl();
		
		return stdDao;
	}
	
	
	
	// insert작업
	@Override
	public int insertStudent(StudentVO stdVo) {
		Object obj = null;
		int cnt = 0;
		try {
			obj = smc.insert("student.insertStudent", stdVo);   	//	"namespace.관련 쿼리문"
			if(obj==null) {				//Integer는 성공하면 null 로 뜨기때문에 Object로 해준다.
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<StudentVO> getAllStudent() {
		List<StudentVO> stdList = null;
		try {
			stdList = smc.queryForList("student.getAllStudent");
		} catch (SQLException e) {
			stdList = null;
			e.printStackTrace();
		}
		return stdList;
	}

}





