package com.shinhan.spring.model.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shinhan.spring.util.DBUtil;

 


@Repository //@Componet + DAO���� 
//@Setter
public class DeptDAO_JDBC implements DeptDAOInterface{
	
	
	//Ÿ���� ������ �ڵ����� �����Ѵ�. 
	@Autowired
	//@Qualifier("dataSourceOriginal")  
	DataSource ds;
	
	//DB����, ������ ���
	Connection conn;
	//SQL���� DB�� ����
	Statement st;
	PreparedStatement pst;
	//Select���
	ResultSet rs;
	//insert,delete,update����� ������� �Ǽ� 
	int resultCount;
	
	static final String SELECT_ALL = "select * from departments order by 1";
	static final String SELECT_DETAIL = "select * from departments where department_id=?";
	static final String INSERT = "insert into departments values(?,?,?,?)";
	static final String UPDATE = "update departments set "
								+ " department_name=?,manager_id=?,location_id=? "
								+ " where department_id=?";
	static final String DELETE = "delete from departments where department_id=?";
	
	//1.Select(Read)..��κ��� 
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		//conn = DBUtil.getConnection();
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return deptlist;
	}
	//2.Select(Read)..�󼼺���
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		//conn = DBUtil.getConnection();
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(SELECT_DETAIL);
			pst.setInt(1, deptid);
			rs = pst.executeQuery();
			while(rs.next()) {
			 dept = makeDept(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return dept;
	}
	
	//3.Inert
	public int insertDept(DeptDTO dept) {
		//conn = DBUtil.getConnection();
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(INSERT);
			pst.setInt(1, dept.getDepartment_id());
			pst.setString(2, dept.getDepartment_name());
			pst.setObject(3, dept.getManager_id());
			pst.setObject(4, dept.getLocation_id());
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		return resultCount;
	}
	//4.Update
	public int updateDept(DeptDTO dept) {
		//conn = DBUtil.getConnection();
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(UPDATE);
			pst.setInt(4, dept.getDepartment_id());
			pst.setString(1, dept.getDepartment_name());
			pst.setObject(2, dept.getManager_id());
			pst.setObject(3, dept.getLocation_id());
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		return resultCount;
	}
	
	//5.Delete
	public int deleteDept(int deptid) {
		//conn = DBUtil.getConnection();
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(DELETE);
			pst.setInt(1, deptid);
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		return resultCount;
	}
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		 
		DeptDTO dept = DeptDTO.builder()
			.department_id(rs.getInt(1))
			.department_name(rs.getString(2))
			.manager_id(rs.getInt(3))
			.location_id(rs.getInt(4))
			.build();
	 
//		Object obj = rs.getObject(1);
//		Integer dept_id = obj == null? null : ((Number)obj).intValue();
//		obj = rs.getObject(3);
//		Integer manaer_id = obj == null? null : ((Number)obj).intValue();
//		obj = rs.getObject(3);
//		Integer location_id = obj == null? null : ((Number)obj).intValue();
//		DeptDTO dept = DeptDTO.builder()
//				.department_id(dept_id)
//				.department_name(rs.getString(2))
//				.manager_id(manaer_id)
//				.location_id(location_id)
//				.build();
		return dept;
	}
	@Override
	public List<DeptDTO> selectAlldeptWithemp() {
		// TODO Auto-generated method stub
		return null;
	}
	
}






