package com.htc.listener;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.htc.model.IModel;
import com.htc.utils.MapUtils;

public class MVCContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext app = sce.getServletContext();
		String location = app.getInitParameter("contextConfigLocation");
		sce.getServletContext().getInitParameter("");
		String fileName = "mvc.xml";
		
		if(location!=null)
		{
			fileName = location;
		}
		
		String realPath = app.getRealPath("WEB-INF/classes/"+fileName);
		//解析xml
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File(realPath));
			
			Element root = document.getRootElement();//beans
			
			List<Element> elements = root.elements("model");//model 的集合
			for(Element model : elements)
			{
				Element action = model.element("action");//action
				
				String actionName = action.attributeValue("name");
				String className = action.attributeValue("class");
				
				//通过反射获取className对应的类的对象
				Class<IModel> clazz = (Class<IModel>)Class.forName(className);
				
				//创建对象
				IModel modelObj = clazz.newInstance();
				
				//key---value
				MapUtils.getMap().put(actionName, modelObj);
				
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
