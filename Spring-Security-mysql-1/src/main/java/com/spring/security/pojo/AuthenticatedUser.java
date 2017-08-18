package com.spring.security.pojo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedUser implements UserDetails {

	private final String username;
	private final Collection<? extends GrantedAuthority> authorities;
	private final String password;
	public AuthenticatedUser( final String userName,final String password,
			final Collection<? extends GrantedAuthority> authorities) {
		username = userName;
		this.password = password;
		this.authorities = authorities;
		System.out.println(authorities);
	}




	/**
	 * @return username
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * @return true
	 */

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * @return true
	 */

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * @return true
	 */

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * @return true
	 */

	@Override
	public boolean isEnabled() {
		return true;
	}


	/**
	 * @return authorities
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @return null
	 */

	@Override
	public String getPassword() {
		return password;
	}


}
