package appeng.recipes;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import appeng.api.exceptions.MissingIngredientError;
import appeng.api.exceptions.RegistrationError;
import appeng.api.recipes.IIngredient;
import appeng.api.recipes.ResolverResultSet;

public class IngredientSet implements IIngredient
{

	int qty = 0;
	final String name;
	final List<ItemStack> items;

	public IngredientSet(ResolverResultSet rr) {
		name = rr.name;
		items = rr.results;
	}

	boolean isInside = false;

	public int getDamageValue()
	{
		return OreDictionary.WILDCARD_VALUE;
	}

	@Override
	public String getItemName()
	{
		return name;
	}

	@Override
	public ItemStack getItemStack() throws RegistrationError, MissingIngredientError
	{
		throw new RegistrationError( "Cannot pass group of items to a recipe which desires a single recipe item." );
	}

	@Override
	public ItemStack[] getItemStackSet() throws RegistrationError, MissingIngredientError
	{
		if ( isInside )
			return new ItemStack[0];

		List<ItemStack> out = new LinkedList();
		out.addAll( items );

		if ( out.size() == 0 )
			throw new MissingIngredientError( toString() + " - group could not be resolved to any items." );

		for (ItemStack is : out)
			is.stackSize = qty;

		return out.toArray( new ItemStack[out.size()] );
	}

	public String getNameSpace()
	{
		return "";
	}

	@Override
	public int getQty()
	{
		return 0;
	}

	@Override
	public boolean isAir()
	{
		return false;
	}
}