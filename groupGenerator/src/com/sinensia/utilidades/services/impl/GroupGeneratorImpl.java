package com.sinensia.utilidades.services.impl;

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collections;
import java.util.List;

import com.sinensia.utilidades.services.GroupGenerator;

public class GroupGeneratorImpl implements GroupGenerator{

	@Override
	public List<String[]> generate(int groupSize, String... members) {
		
		int diffGroups = members.length/groupSize;
		
		if(diffGroups<=1)
			throw new IllegalArgumentException("No hay suficientes miembros para formar al menos dos grupos");
		
		List<String>membersv2 = Arrays.asList(members);
		Collections.shuffle(membersv2);
		List<String[]>groups = new ArrayList<>();
		String[]group = null;
		
		int leftovers = members.length%groupSize;
		int x = 1;

			
		for(int i=0;i<diffGroups;i++) {
				
			if(leftovers>0) {
				group = new String[groupSize+1];
				leftovers--;
			}else group = new String[groupSize];
				
			for(int j=0;j<group.length;j++) {
				group[(x-1)%group.length ] = members[ x-1 ];
				x++;
			}
				
			groups.add(group);
				
		}
		
		return groups;
		
	}

}
