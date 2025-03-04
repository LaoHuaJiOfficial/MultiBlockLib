package multiblock;

import mindustry.mod.ClassMap;
import multiblock.extend.*;

public class ClassMapRegister {
    public static void load() {
        ClassMap.classes.put("MultiBlock-GenericCrafter", MultiBlockGenericCrafter.class);
        ClassMap.classes.put("MultiBlock-AttributeCrafter", MultiBlockAttributeCrafter.class);

        ClassMap.classes.put("DrawFlameRotated", DrawFlameRotated.class);
        ClassMap.classes.put("DrawLiquidRegionRotated", DrawLiquidRegionRotated.class);
        ClassMap.classes.put("DrawRegionCenterSymmetry", DrawRegionCenterSymmetry.class);
        ClassMap.classes.put("DrawRegionRotated", DrawRegionRotated.class);
    }
}
