package com.shinhan.spring.model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.spring.util.DBUtil;

 
@Repository
public class BoardDAO {
	
	@Autowired
	//@Qualifier("dataSourceOriginal")  
	DataSource ds;
 
	Connection conn;
 
	Statement st;
	PreparedStatement pst;
 
	ResultSet rs;
 
	int resultCount;
	
	static final String SELECT_ALL = "select * from board";
	static final String SELECT_DETAIL = "select * from board where bno=?";
	//static final String INSERT = "insert into board values(seq_board.nextval,?,?,?,?,?)";
	static final String INSERT = "insert into board(title, content, writer, pic1, pic2) values(?,?,?,?,?)";
	
	//1.Select(Read).. 
	public List<BoardDTO> selectAll() {
		List<BoardDTO> blist = new ArrayList<BoardDTO>();
		
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
				BoardDTO board = makeBoard(rs);
				blist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return blist;
	}
	//2.Select(Read).. 
	public BoardDTO selectById(int bno) {
		BoardDTO board = null;
		 
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(SELECT_DETAIL);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			while(rs.next()) {
				board = makeBoard(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return board;
	}
	
	//3.Inert
	public int insertDept(BoardDTO board) {
		 
		try {
			conn = ds.getConnection();
			pst = conn.prepareStatement(INSERT);
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriter());
			pst.setString(4, board.getPic1());
			pst.setString(5, board.getPic2());
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		return resultCount;
	}
	 
	private BoardDTO makeBoard(ResultSet rs) throws SQLException {		 
		BoardDTO board = BoardDTO.builder()
			.bno(rs.getInt("bno")) 
			.title(rs.getString("title"))
			.content(rs.getString("content"))
			.writer(rs.getString("writer"))
			.pic1(rs.getString("pic1"))
			.pic2(rs.getString("pic2"))
			.build();
	 
        return board;
	}
	
}






