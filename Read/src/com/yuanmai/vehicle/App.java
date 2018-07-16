package com.yuanmai.vehicle;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) throws IOException {
		String path="F:/bishi";
		File file=new File(path);
		File[] tempList=file.listFiles();
		System.out.println("shumu:"+tempList.length);

		
		Executor executor =Executors.newFixedThreadPool(50);
		
		for(int i = 0; i < tempList.length; i++)
		{
			if (tempList[i].isDirectory()) 
			{
				executor.execute(new VehicleLocationTask(tempList[i]));
			}
		}
	}
	
	
	public static synchronized  void writeFile(Map<String, Integer> map, String plateNo)
	{
		//
	}
	
}
