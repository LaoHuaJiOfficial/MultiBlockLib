package multiblock.extend;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Eachable;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;

public class DrawRegionRotated extends DrawBlock {
    public TextureRegion[] region;
    public boolean oneSprite = false;
    public String suffix = "";
    /**
     * Any number <=0 disables layer changes.
     */
    public float layer = -1;

    public DrawRegionRotated(String suffix) {
        this.suffix = suffix;
    }

    public DrawRegionRotated() {
    }

    @Override
    public void draw(Building build) {
        float z = Draw.z();
        if (layer > 0) Draw.z(layer);
        if (oneSprite) {
            Draw.rect(region[build.rotation], build.x, build.y, build.rotdeg());
        } else {
            Draw.rect(region[build.rotation], build.x, build.y);
        }
        Draw.z(z);
    }

    @Override
    public void drawPlan(Block block, BuildPlan plan, Eachable<BuildPlan> list) {
        if (oneSprite) {
            Draw.rect(region[plan.rotation], plan.drawx(), plan.drawy(), plan.rotation * 90);
        } else {
            Draw.rect(region[plan.rotation], plan.drawx(), plan.drawy());
        }
    }

    @Override
    public TextureRegion[] icons(Block block) {
        return super.icons(block);
    }

    @Override
    public void load(Block block) {
        region = new TextureRegion[4];
        if (oneSprite) {
            for (int i = 0; i < 4; i++) {
                region[i] = Core.atlas.find(block.name + suffix);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                region[i] = Core.atlas.find(block.name + suffix + "-" + i);
            }
        }
    }
}
