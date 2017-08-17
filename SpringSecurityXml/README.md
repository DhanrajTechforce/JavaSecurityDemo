# SpringSecurityXml

This projects is small example Spring security having static user name and password and role ,to access specific urls.
Username ,password,roles and url settings are defined in configuration file of spring 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

 - Spring tools suite or Eclipse.
 - Knowledge of Spring MVC.
 - Java 1.8
 - Tomcat 
 - Maven
 
### Step-by-step

Clone this project and import as maven project in your IDE.

1 > Folder Structure 

[![solarized dualmode](https://raw.githubusercontent.com/DhanrajTechforce/JavaSecurityDemo/master/SpringSecurityXml/image/folders.png)](#features)

2 > Add spring mvc and spring security required dependencies in your pom.xml file
	spring security dependencies are ..
	
			<!-- spring security -->
			<dependency>
				<groupId>org.springframework.security</groupId>
				<artifactId>spring-security-web</artifactId>
				<version>${spring-security-web-version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework.security</groupId>
				<artifactId>spring-security-config</artifactId>
				<version>${spring-security-web-version}</version>
			</dependency>
3 > add spring-security.xml in your WEB-INF/spring/appServlet folder 
	spring-security.xml is configuration descriptor for spring security.
		- 
		
		// to enable spring security annotation 
		<global-method-security pre-post-annotations="enabled"/>
		
		-
		
		//Responsible for setting up spring security deafult setting and setting role on different urls.
		<http auto-config="true">
			<intercept-url pattern="/" access="permitAll"/>
			<intercept-url pattern="/admin**" access="hasRole('ROLE_ADMIN')"/>
			<intercept-url pattern="/user**" access="hasRole('ROLE_USER')"/>
			<intercept-url pattern="/manager**" access="hasRole('ROLE_MANAGER')"/>
		</http>	
		
		-
		Above roles and users are defined below 
		
		<authentication-manager>
			  <authentication-provider>
				<user-service>
					<user name="user" password="123" authorities="ROLE_USER" />
					<user name="admin" password="123" authorities="ROLE_ADMIN"/>
					<user name="manager" password="123" authorities="ROLE_MANAGER"/>
				</user-service>
			  </authentication-provider>
		</authentication-manager>

4 > we also have to set some configuration web.xml file as below 

	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring/root-context.xml,/WEB-INF/spring/appServlet/spring-security.xml</param-value>
	</context-param>

	<filter>
		<filter-name>springSecurityFilterChain</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	<listener>
		<listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
	</listener>

	<!-- Processes application requests -->
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
	
4 > Create one controller which returs jsp pages based on url mappings
	in this example HomeController is responsible for mapping urls
	
	
## Run example

- Start tomcat server and 
	Try to open below links
	/admin
	/user
	/manager
	
	It will ask you for username and password.
	
	- username = user,admin,or manager 
	- password = 123



