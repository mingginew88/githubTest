package student.service;

import java.util.List;

import student.dao.IStudentDao;
import student.dao.StudentDaoImpl;
import student.vo.StudentVO;

public class StudentServiceImpl implements IStudentService {
	private static StudentServiceImpl stdService;
	
	private IStudentDao stdDao;
	
	private StudentServiceImpl() {
		stdDao = StudentDaoImpl.getInstance();
	} 
	
	public static StudentServiceImpl getInstance() {
		if(stdService==null) stdService = new StudentServiceImpl();
		
		return stdService;
	}
	
	
	
	@Override
	public int insertStudent(StudentVO stdVo) {
		return stdDao.insertStudent(stdVo);
	}

	@Override
	public List<StudentVO> getAllStudent() {
		return stdDao.getAllStudent();
	}

}
