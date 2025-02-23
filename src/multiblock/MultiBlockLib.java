package multiblock;

import arc.Core;
import arc.Events;
import arc.func.Cons;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import arc.util.ArcRuntimeException;
import arc.util.Log;
import mindustry.core.ContentLoader;
import mindustry.ctype.Content;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import multiblock.extend.LinkBlock;
import multiblock.extend.PlaceholderBlock;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

import static arc.Core.assets;
import static mindustry.Vars.content;
import static mindustry.Vars.logicVars;

public class MultiBlockLib extends Mod {

    public static final Seq<Block> mirrorList = new Seq<>();
    public static Block block;

    public static final int maxsize = 4;
    public static LinkBlock[] linkEntity, linkEntityLiquid;
    public static PlaceholderBlock[] placeholderEntity;

    public MultiBlockLib() {
        //idk if this is a valid way to create content in last priority, hope this wont goes wrong
        //ok i tested and the result is no so dont do this
        //postLoad();
    }

    public void postLoad(){
        Events.on(EventType.ContentInitEvent.class, e -> {
            mirrorList.each(block -> {
                Block mirror = new Block(block.name + "-mirror");
                Field[] fields = Block.class.getFields();
                for (Field field : fields) {
                    try {
                        if (field.getModifiers() == Modifier.PUBLIC && !(field.getName().equals("name") || field.getName().equals("mirror"))) {
                            field.set(mirror, field.get(block));
                        }

                        if (field.getModifiers() == Modifier.PUBLIC && field.getName().equals("mirror")){
                            field.set(mirror, true);
                        }
                    }catch (IllegalAccessException ex) {
                        throw new ArcRuntimeException(ex);
                    }
                }
                mirror.init();
                mirror.loadIcon();
                mirror.load();
            });
        });
    }

    public static void loadBlock() {
        linkEntity = new LinkBlock[maxsize];
        linkEntityLiquid = new LinkBlock[maxsize];
        placeholderEntity = new PlaceholderBlock[maxsize];
        for (int i = 0; i < maxsize; i++) {
            int s = i + 1;
            linkEntity[i] = new LinkBlock("link-entity-" + s) {{
                size = s;
            }};
            linkEntityLiquid[i] = new LinkBlock("link-entity-liquid-" + s) {{
                size = s;
                outputsLiquid = true;
            }};
            placeholderEntity[i] = new PlaceholderBlock("placeholder-entity-" + s) {{
                size = s;
            }};
        }
    }

    @Override
    public void loadContent() {
        super.loadContent();
        ClassMapRegister.load();
        loadBlock();
    }

}
