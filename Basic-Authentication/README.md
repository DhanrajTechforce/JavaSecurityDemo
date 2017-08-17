# JavaSecurityDemo

This projects is small example of Java Basic Authentication.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

 - Spring tools suite or Eclipse.
 - Java 1.8
 - Tomcat 
 - Maven
 

Clone this project and import as maven project in your IDE.

### Installing

1 > HelloWorld
	
	This is servlet class which retuns "Served at: " Text .
	
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello with security");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

2 > WEB-INF/web.xml
	
	This file consist mapping of servlet HelloWorld, 
	
		<servlet>
			<servlet-name>HelloWorld</servlet-name>
			<display-name>HelloWorld</display-name>
			<servlet-class>com.basic.authentication.HelloWorld</servlet-class>
		</servlet>
  
	    <servlet-mapping>
			<servlet-name>HelloWorld</servlet-name>
			<url-pattern>/hello</url-pattern>
	    </servlet-mapping>
	
	And configuration for Basic Authentication
	
	<security-constraint>
		<web-resource-collection>
			<web-resource-name>Wildcard means whole app requires authentication</web-resource-name>
			<url-pattern>/hello</url-pattern>
			<http-method>GET</http-method>
			<http-method>POST</http-method>
		</web-resource-collection>
		<auth-constraint>
			<role-name>tomcat</role-name>
		</auth-constraint>

		<user-data-constraint>
			<!-- transport-guarantee can be CONFIDENTIAL, INTEGRAL, or NONE -->
			<transport-guarantee>NONE</transport-guarantee>
		</user-data-constraint>
	</security-constraint>

	<login-config>
		<auth-method>BASIC</auth-method>
	</login-config>	
	
3 > 
	here we had use role in web.xml file as below .
	
	<auth-constraint>
			<role-name>tomcat</role-name>
	</auth-constraint>

	tomcat role is defined in tomcat-users.xml file .
	
	you can edit tomcat-users.xml as 
	<role rolename="system"></role>
	<user username="system" passsword="123" roles="system" ></user>

## Run example

- Start tomcat server and 
	Try to open below link 
	http://localhost:8080/Basic-Authentication/hello
	
	It will ask you for username and password.
	
	here if you had provided tomcat role in web.xml you have to login with 
	- username = tomcat 
	- password = tomcat



