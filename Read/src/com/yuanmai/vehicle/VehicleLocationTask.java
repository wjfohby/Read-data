package com.yuanmai.vehicle;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class VehicleLocationTask implements Runnable
{
	//  ����Ŀ¼
	private File dirName;
	
	// ���������ۼ�ֵmap��city->times
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
		
		//TODO:�ǵ��������IO��һ��Ҫ�ر�
		
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
		// TODO:ȥ�ط���
		return null;
	}
	
	// latLon  ����,γ��
	private String getCity(String latLon)
	{
		//TODO:���ðٶȻ��߸ߵµ�ͼ��ȡ����
		return null;
	}
	
	

}
