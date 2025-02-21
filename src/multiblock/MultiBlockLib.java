package multiblock;

import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import multiblock.extend.LinkBlock;
import multiblock.extend.PlaceholderBlock;

public class MultiBlockLib extends Mod{

    public static final int maxsize = 4;
    public static LinkBlock[] linkEntity, linkEntityLiquid;
    public static PlaceholderBlock[] placeholderEntity;

    public static void loadBlock(){
        linkEntity = new LinkBlock[maxsize];
        linkEntityLiquid = new LinkBlock[maxsize];
        placeholderEntity = new PlaceholderBlock[maxsize];
        for (int i = 0; i < maxsize; i++){
            int s = i + 1;
            linkEntity[i] = new LinkBlock("link-entity-" + s){{size = s;}};
            linkEntityLiquid[i] = new LinkBlock("link-entity-liquid-" + s){{size = s; outputsLiquid = true;}};
            placeholderEntity[i] = new PlaceholderBlock("placeholder-entity-" + s){{size = s;}};
        }
    }

    @Override
    public void loadContent(){
        ClassMapRegister.load();
        loadBlock();
    }

}
