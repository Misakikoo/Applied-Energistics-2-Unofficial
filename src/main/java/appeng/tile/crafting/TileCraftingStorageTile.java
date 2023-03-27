/*
 * This file is part of Applied Energistics 2. Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved. Applied
 * Energistics 2 is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version. Applied Energistics 2 is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details. You should have received a copy of the GNU Lesser General Public License along with
 * Applied Energistics 2. If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.tile.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import appeng.api.AEApi;
import appeng.api.definitions.IBlocks;
import appeng.block.crafting.BlockAdvancedCraftingStorage;
import appeng.block.crafting.BlockUltimateCraftingStorage;

public class TileCraftingStorageTile extends TileCraftingTile {

    private static final int KILO_SCALAR = 1024;

    @Override
    protected ItemStack getItemFromTile(final Object obj) {
        final IBlocks blocks = AEApi.instance().definitions().blocks();
        final int storage = ((TileCraftingTile) obj).getStorageBytes();

        switch (storage) {
            case 4:
                for (final ItemStack stack : blocks.craftingStorage4k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 16:
                for (final ItemStack stack : blocks.craftingStorage16k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 64:
                for (final ItemStack stack : blocks.craftingStorage64k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 256:
                for (final ItemStack stack : blocks.craftingStorage256k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 1024:
                for (final ItemStack stack : blocks.craftingStorage1024k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 4096:
                for (final ItemStack stack : blocks.craftingStorage4096k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 16384:
                for (final ItemStack stack : blocks.craftingStorage16384k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 65536:
                for (final ItemStack stack : blocks.craftingStorage16384k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 262144:
                for (final ItemStack stack : blocks.craftingStorage16384k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 1048576:
                for (final ItemStack stack : blocks.craftingStorage16384k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
            case 4194304:
                for (final ItemStack stack : blocks.craftingStorage16384k().maybeStack(1).asSet()) {
                    return stack;
                }
                break;
        }

        return super.getItemFromTile(obj);
    }

    @Override
    public boolean isAccelerator() {
        return false;
    }

    @Override
    public boolean isStorage() {
        return true;
    }

    @Override
    public int getStorageBytes() {
        if (this.worldObj == null || this.notLoaded()) {
            return 0;
        }
        Block block = this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
        int blockMultiplier = block instanceof BlockUltimateCraftingStorage ? 65536
                : (block instanceof BlockAdvancedCraftingStorage ? 256 : 1);

        return blockMultiplier << (2 * (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) & 3));
    }
}
