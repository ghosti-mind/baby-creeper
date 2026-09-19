package ghosti.babycreeper;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;

public class BabyCreeperEntity extends Creeper {
    // hooks for drawing synchronization
    public final AnimationState idle = new AnimationState();
    public final AnimationState walk = new AnimationState();
    public final AnimationState attack = new AnimationState();
    public final AnimationState death = new AnimationState();

    public BabyCreeperEntity(EntityType<? extends Creeper> type, Level level) {
        super(type, level);

        // impact some attributes to account for BABY
        // this.getAttribute(Attributes.MOVEMENT_SPEED).apply(Attributes.MOVEMENT_SPEED);
    }

    @Override 
	public void tick() {
        super.tick();

        this.syncAnimations();
    }

    private void syncAnimations() {
        if (this.isDeadOrDying()) {
            this.idle.stop();
            this.walk.stop();
            this.attack.stop();
            this.death.startIfStopped(this.tickCount);
        } else if (this.getSwellDir() > 0 || this.isIgnited()) {
            this.idle.stop();
            this.walk.stop();
            this.attack.startIfStopped(this.tickCount);
            this.death.stop();
        } else if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
            this.idle.stop();
            this.walk.startIfStopped(this.tickCount);
            this.attack.stop();
            this.death.stop();
        } else {
            this.idle.startIfStopped(this.tickCount);
            this.walk.stop();
            this.attack.stop();
            this.death.stop();
        }
    }
}
