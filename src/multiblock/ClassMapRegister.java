package multiblock;

import mindustry.mod.ClassMap;
import multiblock.extend.DrawFlameRotated;
import multiblock.extend.DrawLiquidRegionRotated;
import multiblock.extend.DrawRegionRotated;
import multiblock.extend.MultiBlockCrafter;

public class ClassMapRegister {
    public static void load() {
        ClassMap.classes.put("MultiBlockCrafter", MultiBlockCrafter.class);

        ClassMap.classes.put("DrawFlameRotated", DrawFlameRotated.class);
        ClassMap.classes.put("DrawLiquidRegionRotated", DrawLiquidRegionRotated.class);
        ClassMap.classes.put("DrawRegionRotated", DrawRegionRotated.class);
    }
}
