package com.shinhan.spring.springjwt;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(MemberRoleEnum.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MemberRoleTypeHandler extends BaseTypeHandler<MemberRoleEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, MemberRoleEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name()); // Enum �� ���ڿ� ����
    }

    @Override
    public MemberRoleEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return MemberRoleEnum.valueOf(rs.getString(columnName)); // ���ڿ� �� Enum
    }

    @Override
    public MemberRoleEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return MemberRoleEnum.valueOf(rs.getString(columnIndex));
    }

    @Override
    public MemberRoleEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return MemberRoleEnum.valueOf(cs.getString(columnIndex));
    }
}