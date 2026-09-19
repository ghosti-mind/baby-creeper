package ghosti.babycreeper.client;

import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.world.entity.AnimationState;


public class BabyCreeperRenderState extends CreeperRenderState {
    public final AnimationState idle = new AnimationState();
    public final AnimationState walk = new AnimationState();
    public final AnimationState attack = new AnimationState();
    public final AnimationState death = new AnimationState();
}
