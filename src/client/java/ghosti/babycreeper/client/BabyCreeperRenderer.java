package ghosti.babycreeper.client;

import ghosti.babycreeper.BabyCreeper;
import ghosti.babycreeper.BabyCreeperEntity;
import ghosti.babycreeper.client.BabyCreeperModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class BabyCreeperRenderer extends MobRenderer<BabyCreeperEntity, BabyCreeperRenderState, BabyCreeperModel> {
	private static final Identifier CREEPER_LOCATION = Identifier.fromNamespaceAndPath(BabyCreeper.MOD_ID, "resources/baby-creeper/baby_creeper.png");

    public BabyCreeperRenderer(Context context) {
        // model
        var model = new BabyCreeperModel(context.bakeLayer(BabyCreeperClient.BABY_CREEPER_LAYER));
        super(context, model, 0.5F);
    }

    @Override 
    public Identifier getTextureLocation(BabyCreeperRenderState state) {
        return CREEPER_LOCATION;
    }

    @Override 
    public BabyCreeperRenderState createRenderState() {
        return new BabyCreeperRenderState();
    }
}
