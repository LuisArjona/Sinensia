package com.sinensia.utilidades.services;

import java.util.List;

public interface GroupGenerator {
	
	List<String[]> generate(int groupSize, String... members);

}
