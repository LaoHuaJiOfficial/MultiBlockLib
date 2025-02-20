package multiblock;

import mindustry.mod.ClassMap;
import multiblock.extend.MultiBlockCrafter;

public class ClassMapRegister {
    public static void load(){
        ClassMap.classes.put("MultiBlockCrafter", MultiBlockCrafter.class);
    }
}
