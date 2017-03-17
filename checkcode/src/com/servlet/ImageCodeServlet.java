package com.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/ImageCodeServlet")
public class ImageCodeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		/**
		 * 生成带字符串的文本图片
		 */
//		1.创建图片缓存区     传参为宽高和图片类型
		BufferedImage image = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		
//		2.创建绘制环境（拿到画笔）
		Graphics paint = image.getGraphics();
		Color c = new Color(200,150,255);
//		设置画笔
		paint.setColor(c);
//		画背景
		paint.fillRect(0, 0, 68, 22);
		
		StringBuffer codes = new StringBuffer();
//		设置文本
		char[] ch = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();
		Random r = new Random(); //随机数
		int index;
		for(int i=0;i<4;i++){
			index = r.nextInt(ch.length);//随机数位置
			paint.setColor(new Color(r.nextInt(88),r.nextInt(150),r.nextInt(255))); //设置文本颜色
//			使用此图形上下文的当前字体和颜色绘制由指定 string 给定的文本。
			paint.drawString(ch[index]+"", (i*16)+3, 18);
			codes.append(ch[index]);
		}
		req.getSession().setAttribute("codes", codes);
		
		
//		3.输出图片
		ImageIO.write(image, "JPG", resp.getOutputStream()); 
	}
}
