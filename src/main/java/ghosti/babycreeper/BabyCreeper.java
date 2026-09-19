package ghosti.babycreeper;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.core.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BabyCreeper implements ModInitializer {
	public static final String MOD_ID = "baby-creeper";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Add BabyCreeper entity setup itself for registration
	public static final Identifier BABY_CREEPER_ID = 
        Identifier.fromNamespaceAndPath(MOD_ID, "baby_creeper");
	public static final ResourceKey<EntityType<?>> BABY_CREEPER_KEY = ResourceKey.create(Registries.ENTITY_TYPE, BABY_CREEPER_ID);



    public static final EntityType<BabyCreeperEntity> BABY_CREEPER = Registry.register(
        BuiltInRegistries.ENTITY_TYPE,
		BABY_CREEPER_ID,
        EntityType.Builder.of(BabyCreeperEntity::new, MobCategory.MONSTER)
            .build(BABY_CREEPER_KEY)
    );

	// add spawn egg for debug
	public static final Identifier BABY_CREEPER_SPAWN_EGG_ID = 
		Identifier.fromNamespaceAndPath(MOD_ID, "baby_creeper_spawn_egg");
	public static final ResourceKey<Item> BABY_CREEPER_SPAWN_EGG_KEY = 
    	ResourceKey.create(Registries.ITEM, BABY_CREEPER_SPAWN_EGG_ID);

	// 2. Instantiate and Register SpawnEggItem
	public static final Item BABY_CREEPER_SPAWN_EGG = Registry.register(
		BuiltInRegistries.ITEM,
		BABY_CREEPER_SPAWN_EGG_ID,
		new SpawnEggItem(
			// BABY_CREEPER,
			// 0x0DA70B, // Base Creeper green color (hex)
			// 0x000000, // Spot black color (hex)
			new Item.Properties().setId(BABY_CREEPER_SPAWN_EGG_KEY).spawnEgg(BABY_CREEPER)
		)
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		FabricDefaultAttributeRegistry.register(
            BABY_CREEPER, 
            BabyCreeperEntity.createAttributes()
        );
		LOGGER.info("Baby Creeper Entity class Registered with default attributes.");

		// Add Spawn Egg to Creative Inventory Tab
		// ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
        // 	entries.add(BABY_CREEPER_SPAWN_EGG);
    	// });
		
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
