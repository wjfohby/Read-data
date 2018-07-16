package com.yuanmai.vehicle;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class VehicleLocationTask implements Runnable
{
	//  车辆目录
	private File dirName;
	
	// 车辆地域累加值map，city->times
	private Map<String, Integer> map = new HashMap<>();
	
	public VehicleLocationTask(File dirName)
	{
		this.dirName = dirName;
	}
	
	@Override
	public void run() 
	{
		File [] files  = dirName.listFiles();
		
		List<String> list = new ArrayList<>();
		for (File file : files)
		{
			list.add("");
		}
		
		//TODO:记得上面操作IO流一定要关闭
		
		App.writeFile(callLocationApi(removeRepeate(list)), dirName.getName().replace("F:\\bishi\\", ""));
	}
	
	private Map<String, Integer> callLocationApi(List<String> removeRepeate) {
		
		// TODO:
		Map<String, Integer> map = new HashMap<>();
		
		removeRepeate.forEach(latLon -> {
			String cityName = getCity(latLon);
			if (map.containsKey(cityName))
			{
				map.put(cityName, map.get(cityName) + 1);
			}
			else
			{
				map.put(cityName, 1);
			}
		});
		
		return null;
		
	}

	private List<String> removeRepeate(List<String> list)
	{
		// TODO:去重方法
		return null;
	}
	
	// latLon  经度,纬度
	private String getCity(String latLon)
	{
		//TODO:调用百度或者高德地图获取城市
		return null;
	}
	
	

}
