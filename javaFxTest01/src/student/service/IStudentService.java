package student.service;

import java.util.List;

import student.vo.StudentVO;

public interface IStudentService {
	
	public int insertStudent(StudentVO stdVo);
	
	public List<StudentVO> getAllStudent();

}
