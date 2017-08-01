package com.spring.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final Locale locale, final Model model) {
		HomeController.logger.info("Welcome home! The client locale is {}.", locale);

		final Date date = new Date();
		final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		final String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	/**
	 * The <code>user</code> is responsible for display user page.
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(final Locale locale, final Model model) {
		HomeController.logger.info("Welcome home! The client locale is {}.", locale);

		final Date date = new Date();
		final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		final String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "userPage";
	}

	/**
	 * The <code>admin</code> is responsible for for display admin page.
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(final Locale locale, final Model model) {
		HomeController.logger.info("Welcome home! The client locale is {}.", locale);

		final Date date = new Date();
		final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		final String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "adminPage";
	}

	/**
	 * The <code>admin</code> is responsible for display manager page.
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String manager(final Locale locale, final Model model) {
		HomeController.logger.info("Welcome home! The client locale is {}.", locale);

		final Date date = new Date();
		final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		final String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "managerPage";
	}

}
