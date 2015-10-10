package com.coral.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Servlet implementation class WechatServlet
 */
public class OldWechatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldWechatServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*MyWechat myWechat = new MyWechat(request);
		String result = myWechat.execute();
		response.getOutputStream().write(result.getBytes());*/
		System.out.println("[doGet] " + request.getParameterMap());
		System.out.println("signature: " + request.getParameter("signature"));
		System.out.println("echostr: " + request.getParameter("echostr"));
		System.out.println("timestamp: " + request.getParameter("timestamp"));
		System.out.println("nonce: " + request.getParameter("nonce"));
		String result = request.getParameter("echostr");
		response.getOutputStream().write(result.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*MyWechat myWechat = new MyWechat(request);
		String result = myWechat.execute();
		response.getOutputStream().write(result.getBytes());*/
		System.out.println("[doPost]" + request.getParameterMap());
		System.out.println("signature: " + request.getParameter("signature"));
		System.out.println("timestamp: " + request.getParameter("timestamp"));
		System.out.println("nonce: " + request.getParameter("nonce"));
		String inputXML = readStreamParameter(request.getInputStream());
		System.out.println("XML: " + inputXML);

		String result = request.getParameter("echostr");
		response.getOutputStream().write(result.getBytes());
	}

	public String readStreamParameter(ServletInputStream in){
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader=null;
		try{
			reader = new BufferedReader(new InputStreamReader(in));
			String line=null;
			while((line = reader.readLine())!=null){
				buffer.append(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!= reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
	}

}
