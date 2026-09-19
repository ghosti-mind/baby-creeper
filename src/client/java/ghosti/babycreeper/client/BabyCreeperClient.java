package ghosti.babycreeper.client;

import ghosti.babycreeper.BabyCreeper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;

public class BabyCreeperClient implements ClientModInitializer {
	public static final ModelLayerLocation BABY_CREEPER_LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath(BabyCreeper.MOD_ID, "babycreeper"), "main");

	@Override
	public void onInitializeClient() {
		ModelLayerRegistry.registerModelLayer(BABY_CREEPER_LAYER, BabyCreeperModel::createBodyLayer);

		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityRenderers.register(BabyCreeper.BABY_CREEPER, BabyCreeperRenderer::new);
	}
}
