package pro01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalcPage")
public class Calc extends HttpServlet {
    public Calc() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String exp = "0";
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>동적 계산기</title>\r\n"
				+ "<style>\r\n"
				+ "	input{\r\n"
				+ "		width:50px;\r\n"
				+ "		height: 50px;\r\n"
				+ "	}\r\n"
				+ "	.output{\r\n"
				+ "		height:50px;\r\n"
				+ "		background: #e9e9e9;\r\n"
				+ "		font-size: 24px;\r\n"
				+ "		font-weight: bold;\r\n"
				+ "		text-align: right;\r\n"
				+ "		padding:0px 5px;\r\n"
				+ "	}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<form action=\"CalcAction\" method=\"post\">\r\n"
				+ "		<table>\r\n"
				+ "			<tr>\r\n"
				+ "				<td class=\"output\" colspan=\"4\">" + exp +"</td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"7\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"8\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"9\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"4\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"5\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"6\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"1\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"2\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"3\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"0\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"value\" value=\"dot\"></td>\r\n"
				+ "				<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "		</table>\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
