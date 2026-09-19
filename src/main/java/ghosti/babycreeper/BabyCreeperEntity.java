package ghosti.babycreeper;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;

public class BabyCreeperEntity extends Creeper {
    public BabyCreeperEntity(EntityType<? extends Creeper> type, Level level) {
        super(type, level);
    }

    @Override 
	public void tick() {
        super.tick();
    }
}
