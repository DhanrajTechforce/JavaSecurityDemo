package com.spring.security.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Repository;

import com.spring.security.pojo.AuthenticatedUser;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	BasicDataSource  dataSource;

	@Override
	public AuthenticatedUser getByUserNamer(final String username) {
		final String sql = "select username,password, enabled from users where username=?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			AuthenticatedUser authenticatedUser = null;
			final ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("username") != null ){
					authenticatedUser = new AuthenticatedUser(
							rs.getString("username"),
							rs.getString("password"),
							getAuthorites(username)
							);
				}

			}
			rs.close();
			ps.close();
			return authenticatedUser;
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (final SQLException e) {}
			}
		}
	}
	private Collection<? extends GrantedAuthority> getAuthorites(final String username) {
		final List<String> auth = new ArrayList<String>();
		final String sql = "select role from user_roles where username =?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			final PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			final ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				auth.add( rs.getString(1) );
				System.out.println(rs.getString(1));
			}
			rs.close();
			ps.close();
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (final SQLException e) {}
			}
		}
		return AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", auth));
	}
}

