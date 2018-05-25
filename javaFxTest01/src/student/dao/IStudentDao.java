package student.dao;

import java.util.List;

import student.vo.StudentVO;

public interface IStudentDao {
	
	public int insertStudent(StudentVO stdVo);
	
	public List<StudentVO> getAllStudent();

}
