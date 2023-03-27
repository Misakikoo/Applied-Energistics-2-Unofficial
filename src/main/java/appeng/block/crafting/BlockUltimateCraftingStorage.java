package appeng.block.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import appeng.client.texture.ExtraBlockTextures;
import appeng.tile.crafting.TileCraftingStorageTile;

public class BlockUltimateCraftingStorage extends BlockCraftingStorage {

    public BlockUltimateCraftingStorage() {
        this.setTileEntity(TileCraftingStorageTile.class);
    }

    @Override
    public IIcon getIcon(final int direction, final int metadata) {
        switch (metadata & (~4)) {
            default:
                return super.getIcon(0, -1);
            case 0:
                return ExtraBlockTextures.BlockCraftingStorage65536k.getIcon();
            case 1:
                return ExtraBlockTextures.BlockCraftingStorage262144k.getIcon();
            case 2:
                return ExtraBlockTextures.BlockCraftingStorage1048576k.getIcon();
            case 3:
                return ExtraBlockTextures.BlockCraftingStorage4194304k.getIcon();

            case FLAG_FORMED:
                return ExtraBlockTextures.BlockCraftingStorage65536kFit.getIcon();
            case 1 | FLAG_FORMED:
                return ExtraBlockTextures.BlockCraftingStorage262144kFit.getIcon();
            case 2 | FLAG_FORMED:
                return ExtraBlockTextures.BlockCraftingStorage1048576kFit.getIcon();
            case 3 | FLAG_FORMED:
                return ExtraBlockTextures.BlockCraftingStorage4194304kFit.getIcon();
        }
    }

    @Override
    public String getUnlocalizedName(final ItemStack is) {
        switch (is.getItemDamage()) {
            case 0:
                return "tile.appliedenergistics2.BlockCraftingStorage65536k";
            case 1:
                return "tile.appliedenergistics2.BlockCraftingStorage262144k";
            case 2:
                return "tile.appliedenergistics2.BlockCraftingStorage1048576k";
            case 3:
                return "tile.appliedenergistics2.BlockCraftingStorage4194304k";
            default:
                return this.getItemUnlocalizedName(is);
        }
    }
}
