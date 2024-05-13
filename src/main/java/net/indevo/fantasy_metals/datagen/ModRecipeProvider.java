package net.indevo.fantasy_metals.datagen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.block.ModBlocks;
import net.indevo.fantasy_metals.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> p_251297_) {

        //BLOCKS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MYTHRIL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADAMANT_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORICHALCUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CARMOT_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CARMOT_INGOT.get())
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SARDONYX_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SARDONYX.get())
                .unlockedBy("has_sardonyx", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.SARDONYX.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ALEXANDRITE.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TSAVORITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TSAVORITE.get())
                .unlockedBy("has_tsavorite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TSAVORITE.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TANZANITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TANZANITE.get())
                .unlockedBy("has_tanzanite", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.TANZANITE.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BLACK_OPAL.get()).build()))
                .save(p_251297_);

        //INGOTS FROM NUGGETS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MYTHRIL_NUGGET.get())
                .unlockedBy("has_mythril_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_NUGGET.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ADAMANT_NUGGET.get())
                .unlockedBy("has_adamant_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_NUGGET.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ORICHALCUM_NUGGET.get())
                .unlockedBy("has_orichalcum_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_NUGGET.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CARMOT_NUGGET.get())
                .unlockedBy("has_carmot_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_NUGGET.get()).build()))
                .save(p_251297_);

        //INGOTS FROM BLOCK

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get(), 9)
                .requires(ModBlocks.MYTHRIL_BLOCK.get())
                .unlockedBy("has_mythril_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.MYTHRIL_BLOCK.get()).build()))
                .save(p_251297_, "fantasy_metals:mythril_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADAMANT_INGOT.get(), 9)
                .requires(ModBlocks.ADAMANT_BLOCK.get())
                .unlockedBy("has_adamant_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ADAMANT_BLOCK.get()).build()))
                .save(p_251297_, "fantasy_metals:adamant_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORICHALCUM_INGOT.get(), 9)
                .requires(ModBlocks.ORICHALCUM_BLOCK.get())
                .unlockedBy("has_orichalcum_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.ORICHALCUM_BLOCK.get()).build()))
                .save(p_251297_, "fantasy_metals:orichalcum_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CARMOT_INGOT.get(), 9)
                .requires(ModBlocks.CARMOT_BLOCK.get())
                .unlockedBy("has_carmot_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CARMOT_BLOCK.get()).build()))
                .save(p_251297_, "fantasy_metals:carmot_ingot_from_block");

        //NUGGETS

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYTHRIL_NUGGET.get(), 9)
                .requires(ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADAMANT_NUGGET.get(), 9)
                .requires(ModItems.ADAMANT_INGOT.get())
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORICHALCUM_NUGGET.get(), 9)
                .requires(ModItems.ORICHALCUM_INGOT.get())
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CARMOT_NUGGET.get(), 9)
                .requires(ModItems.CARMOT_INGOT.get())
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .save(p_251297_);

        //SWORDS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" C ")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" C ")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" C ")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" C ")
                .define('A', ModItems.CARMOT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        //PICKAXES

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_PICKAXE.get())
                .pattern("AAA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_PICKAXE.get())
                .pattern("AAA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_PICKAXE.get())
                .pattern("AAA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.CARMOT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        //SHOVELS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_SHOVEL.get())
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_SHOVEL.get())
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_SHOVEL.get())
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_SHOVEL.get())
                .pattern(" A ")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.CARMOT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        //AXES

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_AXE.get())
                .pattern("AA ")
                .pattern("AC ")
                .pattern(" C ")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_AXE.get())
                .pattern("AA ")
                .pattern("AC ")
                .pattern(" C ")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_AXE.get())
                .pattern("AA ")
                .pattern("AC ")
                .pattern(" C ")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_AXE.get())
                .pattern("AA ")
                .pattern("AC ")
                .pattern(" C ")
                .define('A', ModItems.CARMOT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        //HOES

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_HOE.get())
                .pattern(" AA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_HOE.get())
                .pattern(" AA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_HOE.get())
                .pattern(" AA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_HOE.get())
                .pattern(" AA")
                .pattern(" C ")
                .pattern(" C ")
                .define('A', ModItems.CARMOT_INGOT.get())
                .define('C', Items.STICK)
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .unlockedBy("has_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.STICK).build()))
                .save(p_251297_);

        //HELMETS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.CARMOT_INGOT.get())
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .save(p_251297_);

        //CHESTPLATES

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CARMOT_INGOT.get())
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .save(p_251297_);

        //LEGGINGS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CARMOT_INGOT.get())
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .save(p_251297_);

        //BOOTS

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHRIL_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.MYTHRIL_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADAMANT_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ADAMANT_INGOT.get())
                .unlockedBy("has_adamant_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ADAMANT_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORICHALCUM_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ORICHALCUM_INGOT.get())
                .unlockedBy("has_orichalcum_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ORICHALCUM_INGOT.get()).build()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARMOT_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CARMOT_INGOT.get())
                .unlockedBy("has_carmot_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CARMOT_INGOT.get()).build()))
                .save(p_251297_);

        //INGOTS FROM BLOCK

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADAMANT_INGOT.get(), 9)
//                .requires(ModBlocks.ADAMANT_BLOCK.get())
//                .unlockedBy("has_adamant_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.ADAMANT_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:adamant_ingot_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
//                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
//                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:alexandrite_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
//                .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
//                .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:black_opal_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CARMOT_INGOT.get(), 9)
//                .requires(ModBlocks.CARMOT_BLOCK.get())
//                .unlockedBy("has_carmot_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.CARMOT_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:carmot_ingot_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TANZANITE.get(), 9)
//                .requires(ModBlocks.TANZANITE_BLOCK.get())
//                .unlockedBy("has_tanzanite_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.TANZANITE_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:tanzanite_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get(), 9)
//                .requires(ModBlocks.MYTHRIL_BLOCK.get())
//                .unlockedBy("has_mythril_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.MYTHRIL_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:mythril_ingot_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORICHALCUM_INGOT.get(), 9)
//                .requires(ModBlocks.ORICHALCUM_BLOCK.get())
//                .unlockedBy("has_orichalcum_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.ORICHALCUM_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:orichalcum_ingot_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SARDONYX.get(), 9)
//                .requires(ModBlocks.SARDONYX_BLOCK.get())
//                .unlockedBy("has_sardonyx_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.SARDONYX_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:sardonyx_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TANZANITE.get(), 9)
//                .requires(ModBlocks.TANZANITE_BLOCK.get())
//                .unlockedBy("has_tanzanite_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.TANZANITE_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:tanzanite_from_block");
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TSAVORITE.get(), 9)
//                .requires(ModBlocks.TSAVORITE_BLOCK.get())
//                .unlockedBy("has_tsavorite_block", inventoryTrigger(ItemPredicate.Builder.item()
//                        .of(ModBlocks.TSAVORITE_BLOCK.get()).build()))
//                .save(p_251297_, "fantasy_metals:tsavorite_from_block");

        //RAW THINGS

        nineBlockStorageRecipes(p_251297_,RecipeCategory.MISC, ModItems.RAW_MYTHRIL.get(),RecipeCategory.MISC, ModBlocks.RAW_MYTHRIL_BLOCK.get(),
                "fantasy_metals:raw_mythril", "mythril", "fantasy_metals:raw_mythril_block", "mythril");

        nineBlockStorageRecipes(p_251297_,RecipeCategory.MISC, ModItems.RAW_ADAMANT.get(),RecipeCategory.MISC, ModBlocks.RAW_ADAMANT_BLOCK.get(),
                "fantasy_metals:raw_adamant", "adamant", "fantasy_metals:raw_adamant_block", "adamant");

        nineBlockStorageRecipes(p_251297_,RecipeCategory.MISC, ModItems.RAW_ORICHALCUM.get(),RecipeCategory.MISC, ModBlocks.RAW_ORICHALCUM_BLOCK.get(),
                "fantasy_metals:raw_orichalcum", "orichalcum", "fantasy_metals:raw_orichalcum_block", "orichalcum");

        nineBlockStorageRecipes(p_251297_,RecipeCategory.MISC, ModItems.RAW_CARMOT.get(),RecipeCategory.MISC, ModBlocks.RAW_CARMOT_BLOCK.get(),
                "fantasy_metals:raw_carmot", "carmot", "fantasy_metals:raw_carmot_block", "carmot");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                     float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for (ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime,
                            pSerializer).group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(pFinishedRecipeConsumer, FantasyMetals.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemLike));
        }
    }
}