package hibiii.windchimes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Initializer implements ModInitializer {

	public static final Identifier IRON_CHIME_ID = new Identifier("windchimes:iron_chime");
	public static final WindchimeBlock IRON_CHIME = new WindchimeBlock(
			ChimeType.IRON, ChimeType.settingsWith(Material.METAL).sounds(BlockSoundGroup.METAL));
	
	public static final Identifier BAMBOO_CHIME_ID = new Identifier("windchimes:bamboo_chime");
	public static final WindchimeBlock BAMBOO_CHIME = new WindchimeBlock(
			ChimeType.BAMBOO, ChimeType.settingsWith(Material.BAMBOO).sounds(BlockSoundGroup.BAMBOO));
	
	public static BlockEntityType<WindchimeBlockEntity> CHIME_BLOCK_ENTITY;

	public static final Identifier CHIME_BLOCK_ENTITY_ID = new Identifier("windchimes:chime");
	
	
	@Override
	public void onInitialize() {
		
        Registry.register(Registry.BLOCK, IRON_CHIME_ID, IRON_CHIME);
        Registry.register(Registry.ITEM, IRON_CHIME_ID, new BlockItem(IRON_CHIME, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, BAMBOO_CHIME_ID, BAMBOO_CHIME);
        Registry.register(Registry.ITEM, BAMBOO_CHIME_ID, new BlockItem(BAMBOO_CHIME, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        
        CHIME_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, CHIME_BLOCK_ENTITY_ID,
        		BlockEntityType.Builder.create(WindchimeBlockEntity::new,
        			IRON_CHIME, BAMBOO_CHIME).build(null));
	}
}
