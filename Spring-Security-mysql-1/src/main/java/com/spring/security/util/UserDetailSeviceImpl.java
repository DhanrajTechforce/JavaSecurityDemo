package com.spring.security.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.dao.UserDao;
import com.spring.security.pojo.AuthenticatedUser;

/**
 * The <code>UserDetailSeviceImpl</code> is a Service which contains methods
 * related to Spring Context used by Spring Security filter in <b>eWis</b>
 * application.
 *
 *
 * @author Ankit
 * @Service UserDetailsService
 *
 */
@Service
public class UserDetailSeviceImpl  implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailSeviceImpl.class);
	@Autowired
	private UserDao userDao;

	/**
	 * The method <code>loadUserByUsername</code> is used to load the user data by user name and
	 * send it to Spring security context.
	 *
	 * @param username
	 */

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		UserDetailSeviceImpl.LOGGER.info(this.getClass().getName() + "==> Method : loadUserByUsername ==> Enter "+username);

		AuthenticatedUser authenticatedUser = null;
		try {

			authenticatedUser = userDao.getByUserNamer(username);

			if (authenticatedUser !=null) {
				return authenticatedUser;
			} else {
				authenticatedUser = null;
			}

		} catch (final Exception e) {
			UserDetailSeviceImpl.LOGGER.error(this.getClass().getName() + "==> Exception : ClientProtocolException ==> " + e);
		}

		UserDetailSeviceImpl.LOGGER.info(this.getClass().getName() + "==> Method : loadUserByUsername ==> Exit");

		return authenticatedUser;
	}

}
