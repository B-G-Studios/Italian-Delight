package net.crow.italiandelight.init;

import net.crow.italiandelight.ItalianDelightMain;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.fluid.AlcoholFluidType;
import umpaz.brewinandchewin.common.registry.BnCFluids;


public class FluidInit {

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ItalianDelightMain.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ItalianDelightMain.MODID);


    public static final RegistryObject<FluidType> GLOWBERRY_WINE_FLUID_TYPE = FLUID_TYPES.register("glowberry_wine_type", () -> new AlcoholFluidType(0xFFf9a41d));
    public static final RegistryObject<FlowingFluid> GLOWBERRY_WINE = FLUIDS.register("glowberry_wine", () -> new ForgeFlowingFluid.Source(FluidInit.GLOWBERRY_WINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GLOWBERRY_WINE = FLUIDS.register("flowing_glowberry_wine", () -> new ForgeFlowingFluid.Flowing(FluidInit.GLOWBERRY_WINE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties GLOWBERRY_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(GLOWBERRY_WINE_FLUID_TYPE, GLOWBERRY_WINE, FLOWING_GLOWBERRY_WINE);

    public static final RegistryObject<FluidType> ROSE_WINE_FLUID_TYPE = FLUID_TYPES.register("rose_wine_type", () -> new AlcoholFluidType(0xF3ff908c));
    public static final RegistryObject<FlowingFluid> ROSE_WINE = FLUIDS.register("rose_wine", () -> new ForgeFlowingFluid.Source(FluidInit.ROSE_WINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ROSE_WINE = FLUIDS.register("flowing_rose_wine", () -> new ForgeFlowingFluid.Flowing(FluidInit.ROSE_WINE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ROSE_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(ROSE_WINE_FLUID_TYPE, ROSE_WINE, FLOWING_ROSE_WINE);

    public static final RegistryObject<FluidType> HELLHOUND_WINE_FLUID_TYPE = FLUID_TYPES.register("hellhound_wine_type", () -> new AlcoholFluidType(0xF3fa6a38));
    public static final RegistryObject<FlowingFluid> HELLHOUND_WINE = FLUIDS.register("hellhound_wine", () -> new ForgeFlowingFluid.Source(FluidInit.HELLHOUND_WINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HELLHOUND_WINE = FLUIDS.register("flowing_hellhound_wine", () -> new ForgeFlowingFluid.Flowing(FluidInit.HELLHOUND_WINE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties HELLHOUND_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(HELLHOUND_WINE_FLUID_TYPE, HELLHOUND_WINE, FLOWING_HELLHOUND_WINE);

    public static final RegistryObject<FluidType> DRAGONBORN_WINE_FLUID_TYPE = FLUID_TYPES.register("dragonborn_wine_type", () -> new AlcoholFluidType(0xF3393434));
    public static final RegistryObject<FlowingFluid> DRAGONBORN_WINE = FLUIDS.register("dragonborn_wine", () -> new ForgeFlowingFluid.Source(FluidInit.DRAGONBORN_WINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_DRAGONBORN_WINE = FLUIDS.register("flowing_dragonborn_wine", () -> new ForgeFlowingFluid.Flowing(FluidInit.DRAGONBORN_WINE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties DRAGONBORN_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(DRAGONBORN_WINE_FLUID_TYPE, DRAGONBORN_WINE, FLOWING_DRAGONBORN_WINE);

    public static final RegistryObject<FluidType> HASTING_WINE_FLUID_TYPE = FLUID_TYPES.register("hasting_wine_type", () -> new AlcoholFluidType(0xFFffc500));
    public static final RegistryObject<FlowingFluid> HASTING_WINE = FLUIDS.register("hasting_wine", () -> new ForgeFlowingFluid.Source(FluidInit.HASTING_WINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HASTING_WINE = FLUIDS.register("flowing_hasting_wine", () -> new ForgeFlowingFluid.Flowing(FluidInit.HASTING_WINE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties HASTING_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(HASTING_WINE_FLUID_TYPE, HASTING_WINE, FLOWING_HASTING_WINE);

    public static final RegistryObject<FluidType> SWEETBERRY_WINE_FLUID_TYPE = FLUID_TYPES.register("sweetberry_wine_type", () -> new AlcoholFluidType(0xF3ff0000));
    public static final RegistryObject<FlowingFluid> SWEETBERRY_WINE = FLUIDS.register("sweetberry_wine", () -> new ForgeFlowingFluid.Source(FluidInit.SWEETBERRY_WINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SWEETBERRY_WINE = FLUIDS.register("flowing_sweetberry_wine", () -> new ForgeFlowingFluid.Flowing(FluidInit.SWEETBERRY_WINE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SWEETBERRY_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(SWEETBERRY_WINE_FLUID_TYPE, SWEETBERRY_WINE, FLOWING_SWEETBERRY_WINE);

    public static final RegistryObject<FluidType> SPUMANTE_FLUID_TYPE = FLUID_TYPES.register("spumante_type", () -> new AlcoholFluidType(0xF3d8fdfe));
    public static final RegistryObject<FlowingFluid> SPUMANTE = FLUIDS.register("spumante", () -> new ForgeFlowingFluid.Source(FluidInit.SPUMANTE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SPUMANTE = FLUIDS.register("flowing_spumante", () -> new ForgeFlowingFluid.Flowing(FluidInit.SPUMANTE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SPUMANTE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(SPUMANTE_FLUID_TYPE, SPUMANTE, FLOWING_SPUMANTE);

}
