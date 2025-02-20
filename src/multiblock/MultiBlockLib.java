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

    public MultiBlockLib(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

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
