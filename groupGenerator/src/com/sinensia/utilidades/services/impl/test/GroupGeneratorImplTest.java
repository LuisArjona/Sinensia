package com.sinensia.utilidades.services.impl.test;
import org.junit.Test;

import com.sinensia.utilidades.services.impl.GroupGeneratorImpl;

import static org.junit.Assert.*;

import java.util.List;

public class GroupGeneratorImplTest {

    @Test
    public void testGenerateConMiembrosSuficientes() {
        GroupGeneratorImpl generator = new GroupGeneratorImpl();
        String[] members = {"A", "B", "C", "D", "E", "F"};
        int groupSize = 2;
        List<String[]> groups = generator.generate(groupSize, members);
        assertEquals(3, groups.size());
        assertEquals(2, groups.get(0).length);
        assertEquals(2, groups.get(1).length);
        assertEquals(2, groups.get(2).length);
    }

    @Test
    public void testGenerateConMiembrosInsuficientes() {
        GroupGeneratorImpl generator = new GroupGeneratorImpl();
        String[] members = {"A", "B"};
        int groupSize = 2;
        try {
            generator.generate(groupSize, members);
            fail("Debería lanzar una excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("No hay suficientes miembros para formar al menos dos grupos", e.getMessage());
        }
    }

    @Test
    public void testGenerateConMiembrosSobrantes() {
        GroupGeneratorImpl generator = new GroupGeneratorImpl();
        String[] members = {"A", "B", "C", "D", "E", "F", "G"};
        int groupSize = 3;
        List<String[]> groups = generator.generate(groupSize, members);
        assertEquals(2, groups.size());
        assertEquals(4, groups.get(0).length);
        assertEquals(3, groups.get(1).length);
    }

    @Test
    public void testGenerateConGrupoSize1() {
        GroupGeneratorImpl generator = new GroupGeneratorImpl();
        String[] members = {"A", "B", "C", "D", "E", "F"};
        int groupSize = 1;
        List<String[]> groups = generator.generate(groupSize, members);
        assertEquals(6, groups.size());
        assertEquals(1, groups.get(0).length);
        assertEquals(1, groups.get(1).length);
        assertEquals(1, groups.get(2).length);
        assertEquals(1, groups.get(3).length);
        assertEquals(1, groups.get(4).length);
        assertEquals(1, groups.get(5).length);
    }
}

