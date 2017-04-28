package edu.uoc.elc.tsugi.security.example.controller;

import edu.uoc.elc.tsugi.security.UserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Example controller
 * @author Xavi Aracil <xaracil@uoc.edu>
 */
@Controller
@RequestMapping("/lti")
@PreAuthorize("hasRole('ROLE_USER')")
public class LtiController {

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView init() throws UnsupportedEncodingException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return new ModelAndView("main", "user", userDetails);
	}
}
