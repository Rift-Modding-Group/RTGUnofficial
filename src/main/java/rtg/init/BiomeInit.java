package rtg.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import rtg.RTGConfig;
import rtg.api.RTGAPI;
import rtg.api.util.UtilityClass;
import rtg.api.world.biome.RealisticBiomeBase;
import rtg.compat.ModCompat.Mods;
import rtg.world.biome.realistic.abyssalcraft.*;
import rtg.world.biome.realistic.auxiliarybiomes.*;
import rtg.world.biome.realistic.betteragriculture.RealisticBiomeBAFarmlandBiome;
import rtg.world.biome.realistic.biomesoplenty.*;
import rtg.world.biome.realistic.biomesyougo.*;
import rtg.world.biome.realistic.bionisation.RealisticBiomeBIOInfectedForest;
import rtg.world.biome.realistic.buildcraft.RealisticBiomeBCDesertOilField;
import rtg.world.biome.realistic.buildcraft.RealisticBiomeBCOceanOilField;
import rtg.world.biome.realistic.candyworld.RealisticBiomeCWChocolateForest;
import rtg.world.biome.realistic.candyworld.RealisticBiomeCWCottonCandyPlains;
import rtg.world.biome.realistic.candyworld.RealisticBiomeCWGummySwamp;
import rtg.world.biome.realistic.defiledlands.*;
import rtg.world.biome.realistic.douglasforest.RealisticBiomeDFDouglasForest;
import rtg.world.biome.realistic.douglasforest.RealisticBiomeDFMapleForest;
import rtg.world.biome.realistic.environs.*;
import rtg.world.biome.realistic.explorercraft.RealisticBiomeECBambooForest;
import rtg.world.biome.realistic.explorercraft.RealisticBiomeECForestedMountain;
import rtg.world.biome.realistic.explorercraft.RealisticBiomeECSnowdonia;
import rtg.world.biome.realistic.floricraft.RealisticBiomeFLORIRoseLand;
import rtg.world.biome.realistic.floricraft.RealisticBiomeFLORITulipLand;
import rtg.world.biome.realistic.fyrecraft.*;
import rtg.world.biome.realistic.gravityfalls.RealisticBiomeGFGravityFalls;
import rtg.world.biome.realistic.gravityfalls.RealisticBiomeGFNightmareRealm;
import rtg.world.biome.realistic.mistbiomes.*;
import rtg.world.biome.realistic.novamterram.*;
import rtg.world.biome.realistic.odioita.RealisticBiomeODIOOrangeBlancoaForest;
import rtg.world.biome.realistic.odioita.RealisticBiomeODIOPinkBlancoaForest;
import rtg.world.biome.realistic.odioita.RealisticBiomeODIORedBlancoaForest;
import rtg.world.biome.realistic.odioita.RealisticBiomeODIOWhiteBlancoaForest;
import rtg.world.biome.realistic.plants.RealisticBiomePLANTSCrystalForest;
import rtg.world.biome.realistic.projectvibrantjourneys.*;
import rtg.world.biome.realistic.realworld.*;
import rtg.world.biome.realistic.redwoods.*;
import rtg.world.biome.realistic.rockhounding.RealisticBiomeRHWhiteSands;
import rtg.world.biome.realistic.spookybiomes.RealisticBiomeSBGhostlyForest;
import rtg.world.biome.realistic.spookybiomes.RealisticBiomeSBWitchwoodForest;
import rtg.world.biome.realistic.subaquatic.*;
import rtg.world.biome.realistic.sugiforest.RealisticBiomeSFSugiForest;
import rtg.world.biome.realistic.terscraft.RealisticBiomeTERSBiomeDemonite;
import rtg.world.biome.realistic.thaumcraft.RealisticBiomeTCEerie;
import rtg.world.biome.realistic.thaumcraft.RealisticBiomeTCMagicalForest;
import rtg.world.biome.realistic.traverse.*;
import rtg.world.biome.realistic.vampirism.RealisticBiomeVAMPVampireForest;
import rtg.world.biome.realistic.vanilla.*;
import rtg.world.biome.realistic.zoesteria.*;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@UtilityClass
public final class BiomeInit {

    private BiomeInit() {

    }

    public static void init() {

        init_minecraft();
        if (Mods.abyssalcraft.isLoaded()) {
            init_abyssalcraft();
        }
        if (Mods.auxbiomes.isLoaded()) {
            init_auxiliarybiomes();
        }
        if (Mods.betteragriculture.isLoaded()) {
            init_betteragriculture();
        }
        if (Mods.biomesoplenty.isLoaded()) {
            init_biomesoplenty();
        }
        if (Mods.byg.isLoaded()) {
            init_biomesyougo();
        }
        if (Mods.bionisation3.isLoaded()) {
            init_bionisation();
        }
        if (Mods.buildcraftenergy.isLoaded()) {
            init_buildcraft();
        }
        if (Mods.candymod.isLoaded()) {
            init_candymod();
        }
        if (Mods.defiledlands.isLoaded()) {
            init_defiledlands();
        }
        if (Mods.douglas_forest.isLoaded()) {
            init_douglasforest();
        }
        if (Mods.environs.isLoaded()) {
            init_environs();
        }
        if (Mods.explorercraft.isLoaded()) {
            init_explorercraft();
        }
        if (Mods.floricraft.isLoaded()) {
            init_floricraft();
        }
        if (Mods.fyrecraft.isLoaded()) {
            init_fyrecraft();
        }
        if (Mods.gravityfalls.isLoaded()) {
            init_gravityfalls();
        }
        if (Mods.mistbiomes.isLoaded()) {
            init_mistbiomes();
        }
        //if (Mods.nt.isLoaded()) {
        //    init_novamterram();
        //}
        if (Mods.odioitamod.isLoaded()) {
            init_odioitamod();
        }
        if (Mods.plants2.isLoaded()) {
            init_plants();
        }
        if (Mods.pvj.isLoaded()) {
            init_pvj();
        }
        if (Mods.realworld.isLoaded()) {
            init_realworld();
        }
        if (Mods.redwoods.isLoaded()) {
            init_redwoods();
        }
        if (Mods.rockhounding_surface.isLoaded()) {
            init_rockhounding();
        }
        if (Mods.spookybiomes.isLoaded()) {
            init_spookybiomes();
        }
        if (Mods.subaquatic.isLoaded()) {
            init_subaquatic();
        }
        if (Mods.sugiforest.isLoaded()) {
            init_sugiforest();
        }
        if (Mods.terscraft.isLoaded()) {
            init_terscraft();
        }
        if (Mods.thaumcraft.isLoaded()) {
            init_thaumcraft();
        }
        if (Mods.traverse.isLoaded()) {
            init_traverse();
        }
        if (Mods.valoegheses_be.isLoaded()) {
            init_zoesteria();
        }
        if (Mods.vampirism.isLoaded()) {
            init_vampirism();
        }

        // This must be done after all biomes have been initialised so that they are all available.
        RTGAPI.initPatchBiome(RTGConfig.patchBiome());
    }

    public static void preInit() {
        RTGAPI.addRTGBiomes(
                RealisticBiomeBase.RiverType.NORMAL.setRTGBiome(new RealisticBiomeVanillaRiver()),
                RealisticBiomeBase.RiverType.FROZEN.setRTGBiome(new RealisticBiomeVanillaFrozenRiver()),
                RealisticBiomeBase.BeachType.NORMAL.setRTGBiome(new RealisticBiomeVanillaBeach()),
                RealisticBiomeBase.BeachType.STONE.setRTGBiome(new RealisticBiomeVanillaStoneBeach()),
                RealisticBiomeBase.BeachType.COLD.setRTGBiome(new RealisticBiomeVanillaColdBeach())
        );
    }

    private static void init_minecraft() {
        // vanilla rivers and beaches are initialised to enum fields during #preInit
        RTGAPI.addRTGBiomes(
                new RealisticBiomeVanillaBirchForest(),
                new RealisticBiomeVanillaBirchForestHills(),
                new RealisticBiomeVanillaBirchForestHillsM(),
                new RealisticBiomeVanillaBirchForestM(),
                new RealisticBiomeVanillaColdTaiga(),
                new RealisticBiomeVanillaColdTaigaHills(),
                new RealisticBiomeVanillaColdTaigaM(),
                new RealisticBiomeVanillaDeepOcean(),
                new RealisticBiomeVanillaDesert(),
                new RealisticBiomeVanillaDesertHills(),
                new RealisticBiomeVanillaDesertM(),
                new RealisticBiomeVanillaExtremeHills(),
                new RealisticBiomeVanillaExtremeHillsEdge(),
                new RealisticBiomeVanillaExtremeHillsM(),
                new RealisticBiomeVanillaExtremeHillsPlus(),
                new RealisticBiomeVanillaExtremeHillsPlusM(),
                new RealisticBiomeVanillaFlowerForest(),
                new RealisticBiomeVanillaForest(),
                new RealisticBiomeVanillaForestHills(),
                new RealisticBiomeVanillaFrozenOcean(),
                new RealisticBiomeVanillaIceMountains(),
                new RealisticBiomeVanillaIcePlains(),
                new RealisticBiomeVanillaIcePlainsSpikes(),
                new RealisticBiomeVanillaJungle(),
                new RealisticBiomeVanillaJungleEdge(),
                new RealisticBiomeVanillaJungleEdgeM(),
                new RealisticBiomeVanillaJungleHills(),
                new RealisticBiomeVanillaJungleM(),
                new RealisticBiomeVanillaMegaSpruceTaiga(),
                new RealisticBiomeVanillaMegaTaiga(),
                new RealisticBiomeVanillaMegaTaigaHills(),
                new RealisticBiomeVanillaMesa(),
                new RealisticBiomeVanillaMesaBryce(),
                new RealisticBiomeVanillaMesaPlateau(),
                new RealisticBiomeVanillaMesaPlateauF(),
                new RealisticBiomeVanillaMesaPlateauFM(),
                new RealisticBiomeVanillaMesaPlateauM(),
                new RealisticBiomeVanillaMushroomIsland(),
                new RealisticBiomeVanillaMushroomIslandShore(),
                new RealisticBiomeVanillaOcean(),
                new RealisticBiomeVanillaPlains(),
                new RealisticBiomeVanillaRedwoodTaigaHills(),
                new RealisticBiomeVanillaRoofedForest(),
                new RealisticBiomeVanillaRoofedForestM(),
                new RealisticBiomeVanillaSavanna(),
                new RealisticBiomeVanillaSavannaM(),
                new RealisticBiomeVanillaSavannaPlateau(),
                new RealisticBiomeVanillaSavannaPlateauM(),
                new RealisticBiomeVanillaSunflowerPlains(),
                new RealisticBiomeVanillaSwampland(),
                new RealisticBiomeVanillaSwamplandM(),
                new RealisticBiomeVanillaTaiga(),
                new RealisticBiomeVanillaTaigaHills(),
                new RealisticBiomeVanillaTaigaM()
        );
    }

    private static void init_abyssalcraft() {

        Biome biome;
        if ((biome = getBiome(Mods.abyssalcraft.getResourceLocation("coralium_infested_swamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeACCoraliumInfestedSwamp(biome));
        }
        if ((biome = getBiome(Mods.abyssalcraft.getResourceLocation("darklands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeACDarklands(biome));
        }
        if ((biome = getBiome(Mods.abyssalcraft.getResourceLocation("darklands_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeACDarklandsForest(biome));
        }
        if ((biome = getBiome(Mods.abyssalcraft.getResourceLocation("darklands_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeACDarklandsHills(biome));
        }
        if ((biome = getBiome(Mods.abyssalcraft.getResourceLocation("darklands_mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeACDarklandsMountains(biome));
        }
        if ((biome = getBiome(Mods.abyssalcraft.getResourceLocation("darklands_plains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeACDarklandsPlains(biome));
        }
    }

    private static void init_auxiliarybiomes() {

        Biome biome;
        if ((biome = getBiome(Mods.auxbiomes.getResourceLocation("marsh"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeAUXMarsh(biome));
        }
        if ((biome = getBiome(Mods.auxbiomes.getResourceLocation("wasteland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeAUXWasteland(biome));
        }
        if ((biome = getBiome(Mods.auxbiomes.getResourceLocation("ice_wasteland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeAUXIceWasteland(biome));
        }
        if ((biome = getBiome(Mods.auxbiomes.getResourceLocation("forested_island"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeAUXForestedIsland(biome));
        }
        if ((biome = getBiome(Mods.auxbiomes.getResourceLocation("white_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeAUXWhiteForest(biome));
        }
    }

    private static void init_betteragriculture() {

        final Biome biome;
        if ((biome = getBiome(Mods.betteragriculture.getResourceLocation("farmlandbiome"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBAFarmlandBiome(biome));
        }
    }

    private static void init_biomesoplenty() {

        Biome biome;
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPAlps(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("alps_foothills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPAlpsFoothills(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("bamboo_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPBambooForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("bayou"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPBayou(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("bog"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPBog(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("boreal_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPBorealForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("brushland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPBrushland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("chaparral"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPChaparral(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("cherry_blossom_grove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPCherryBlossomGrove(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("cold_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPColdDesert(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("coniferous_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPConiferousForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("coral_reef"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPCoralReef(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("crag"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPCrag(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("dead_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPDeadForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("dead_swamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPDeadSwamp(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("eucalyptus_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPEucalyptusForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("fen"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPFen(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("flower_field"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPFlowerField(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("flower_island"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPFlowerIsland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("glacier"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPGlacier(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("grassland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPGrassland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("gravel_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPGravelBeach(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("grove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPGrove(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("highland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPHighland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("kelp_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPKelpForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("land_of_lakes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPLandOfLakes(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("lavender_fields"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPLavenderFields(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("lush_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPLushDesert(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("lush_swamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPLushSwamp(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("mangrove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMangrove(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("maple_woods"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMapleWoods(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("marsh"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMarsh(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("meadow"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMeadow(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("moor"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMoor(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("mountain"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMountainPeaks(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("mountain_foothills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMountainFoothills(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("mystic_grove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPMysticGrove(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("oasis"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPOasis(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("ominous_woods"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPOminousWoods(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("orchard"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPOrchard(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("origin_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPOriginBeach(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("origin_island"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPOriginIsland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("outback"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPOutback(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("overgrown_cliffs"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPOvergrownCliffs(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("pasture"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPPasture(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("prairie"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPPrairie(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("quagmire"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPQuagmire(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("rainforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPRainforest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("redwood_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPRedwoodForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("sacred_springs"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPSacredSprings(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("seasonal_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPSeasonalForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("shield"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPShield(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("shrubland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPShrubland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("snowy_coniferous_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPSnowyConiferousForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("snowy_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPSnowyForest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("steppe"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPSteppe(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("temperate_rainforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPTemperateRainforest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("tropical_island"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPTropicalIsland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("tropical_rainforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPTropicalRainforest(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("tundra"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPTundra(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("volcanic_island"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPVolcanicIsland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("wasteland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPWasteland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("wetland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPWetland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("white_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPWhiteBeach(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("woodland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPWoodland(biome));
        }
        if ((biome = getBiome(Mods.biomesoplenty.getResourceLocation("xeric_shrubland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBOPXericShrubland(biome));
        }
    }

    private static void init_biomesyougo() {

        Biome biome;
        if ((biome = getBiome(Mods.byg.getResourceLocation("balliumfields"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGAlliumFields(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("balps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGAlps(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bamaranth_fields"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGAmaranthFields(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bancientforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGAncientForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("baspenforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGAspenForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bbambooforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGBambooForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bbaobabsavanna"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGBaobabSavanna(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bbayou"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGBayou(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bbluetaiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGBlueTaiga(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bbluff_mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGBluffMountains(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bbog"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGBog(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bborealforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGBorealForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bcanyons"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGCanyons(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bchaparrallowlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGChaparralLowlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bcherrygrove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGCherryGrove(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bcikaforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGCikaForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bconiferousforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGConiferousForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bcypress_swamplands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGCyprusSwampland(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bdeadsea"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGDeadSea(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bdeciduousforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGDeciduousForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bdovermoutains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGDoverMountains(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bdunes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGDunes(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bebonywoods"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGEbonyWoods(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("benchantedforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGEnchantedForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("beucalyptustropics"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGEucalyptusTropics(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bevergreentaiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGEvergreenTaiga(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bfrostyforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGFrostyForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bfungaljungle"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGFungalJungle(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bgiant_blue_spruce_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGGiantBlueSpruceTaiga(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bgiant_seasonal_spruce_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGGiantSeasonalSpruceTaiga(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bglaciers"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGGlaciers(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bglowshroombayou"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGGlowshroomBayou(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bgrasslandplateau"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGGrasslandPlateau(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bgreatlakes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGGreatLakes(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bgreatoaklowlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGGreatOakLowlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bjacarandaforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGJacarandaForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("blushdesert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGLushDesert(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bmangrovemarshes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGMangroveMarshes(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bmapleforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGMapleForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bmeadow"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGMeadow(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("borchard"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGOrchard(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("boutback"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGOutback(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("boutlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGOutlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bpaperbirchforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGPaperBirchForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bpine_lowlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGPineLowlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bpinemountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGPineMountains(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bpraire"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGPraire(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bprairie"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGPrairie(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bquagmire"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGQuagmire(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("breddesert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGRedDesert(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bredoakforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGRedOakForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bred_outlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGRedOutlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bredwoodtropics"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGRedwoodTropics(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bsavannacanopy"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSavannaCanopy(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bseasonalbirchforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSeasonalBirchForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bseasonaldeciduous"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSeasonalDeciduous(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bseasonalforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSeasonalForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bseasonaltaiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSeasonalTaiga(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bshrublands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGShrublands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bskyrishighlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSkyrisHighlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bsnowyconiferousforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSnowyConiferousForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bsnowyevergeentaiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSnowyEvergeenTaiga(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bsnowypinemountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSnowyPineMountains(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bsonorandesert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGSonoranDesert(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bstellatapasture"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGStellataPasture(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bstone_brushlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGStoneBrushlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("btropical_islands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGTropicalIslands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("btropicalmountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGTropicalMountains(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("btropicalrainforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGTropicalRainforest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("btundra"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGTundra(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bweepingwitchforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGWeepingWitchForest(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bwhisperingwoods"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGWhisperingWoods(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bwoodlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGWoodlands(biome));
        }
        if ((biome = getBiome(Mods.byg.getResourceLocation("bzelkovaforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBYGZelkovaForest(biome));
        }
    }

    private static void init_bionisation() {

        final Biome biome;
        if ((biome = getBiome(Mods.bionisation3.getResourceLocation("infected_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBIOInfectedForest(biome));
        }
    }

    private static void init_buildcraft() {

        Biome biome;
        if ((biome = getBiome(Mods.buildcraftenergy.getResourceLocation("oil_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBCDesertOilField(biome));
        }
        if ((biome = getBiome(Mods.buildcraftenergy.getResourceLocation("oil_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeBCOceanOilField(biome));
        }
    }

    private static void init_candymod() {

        Biome biome;
        if ((biome = getBiome(Mods.candymod.getResourceLocation("biome_cotton_candy"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeCWCottonCandyPlains(biome));
        }
        if ((biome = getBiome(Mods.candymod.getResourceLocation("biome_chocolate_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeCWChocolateForest(biome));
        }
        if ((biome = getBiome(Mods.candymod.getResourceLocation("biome_gummy_swamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeCWGummySwamp(biome));
        }
    }

    private static void init_defiledlands() {

        Biome biome;
        if ((biome = getBiome(Mods.defiledlands.getResourceLocation("desert_defiled"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDLDesertDefiled(biome));
        }
        if ((biome = getBiome(Mods.defiledlands.getResourceLocation("plains_defiled"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDLPlainsDefiled(biome));
        }
        if ((biome = getBiome(Mods.defiledlands.getResourceLocation("forest_tenebra"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDLForestTenebra(biome));
        }
        if ((biome = getBiome(Mods.defiledlands.getResourceLocation("forest_vilespine"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDLForestVilespine(biome));
        }
        if ((biome = getBiome(Mods.defiledlands.getResourceLocation("hills_defiled"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDLHillsDefiled(biome));
        }
        if ((biome = getBiome(Mods.defiledlands.getResourceLocation("swamp_defiled"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDLSwampDefiled(biome));
        }
        if ((biome = getBiome(Mods.defiledlands.getResourceLocation("ice_plains_defiled"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDLIcePlainsDefiled(biome));
        }
    }

    private static void init_douglasforest() {

        Biome biome;
        if ((biome = getBiome(Mods.douglas_forest.getResourceLocation("douglas_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDFDouglasForest(biome));
        }
        if ((biome = getBiome(Mods.douglas_forest.getResourceLocation("maple_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeDFMapleForest(biome));
        }
    }

    private static void init_environs() {

        Biome biome;
        if ((biome = getBiome(Mods.environs.getResourceLocation("extreme_jungle"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVExtremeJungle(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("moor"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVMoor(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("emerald_cliffs"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVEmeraldCliffs(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("pine_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVPineTaiga(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("pine_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVPineTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("silkglades"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVSilkglades(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("stone_flats"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVStoneFlats(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("end_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVEndForest(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("sparse_end_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVSparseEndForest(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("end_shrubland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVEndShrubland(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("tall_oak_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVTallOakForest(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("tall_oak_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVTallOakForestHills(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("tall_oak_wetland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVTallOakWetland(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("wasteland_spikes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVWastelandSpikes(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("wasteland_eroded"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVWastelandEroded(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("dead_oak_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVDeadOakForest(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("dead_oak_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVDeadOakForestHills(biome));
        }
        if ((biome = getBiome(Mods.environs.getResourceLocation("icy_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeENVIcyHills(biome));
        }
    }

    private static void init_explorercraft() {

        Biome biome;
        if ((biome = getBiome(Mods.explorercraft.getResourceLocation("bamboo_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeECBambooForest(biome));
        }
        if ((biome = getBiome(Mods.explorercraft.getResourceLocation("forested_mountain"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeECForestedMountain(biome));
        }
        if ((biome = getBiome(Mods.explorercraft.getResourceLocation("snowdonia"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeECSnowdonia(biome));
        }
    }

    private static void init_floricraft() {

        Biome biome;
        if ((biome = getBiome(Mods.floricraft.getResourceLocation("tulip land"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFLORITulipLand(biome));
        }
        if ((biome = getBiome(Mods.floricraft.getResourceLocation("rose land"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFLORIRoseLand(biome));
        }
    }

    private static void init_fyrecraft() {

        Biome biome;
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("rocky wasteland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYRERockyWasteland(biome));
        }
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("mushroom grove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYREMushroomGrove(biome));
        }
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("tropical lakes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYRETropicalLakes(biome));
        }
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("mega mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYREMegaMountains(biome));
        }
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("red desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYRERedDesert(biome));
        }
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("red desert hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYRERedDesertHills(biome));
        }
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("volcanic wasteland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYREVolcanicWasteland(biome));
        }
        if ((biome = getBiome(Mods.fyrecraft.getResourceLocation("crimson grove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeFYRECrimsonGrove(biome));
        }
    }

    private static void init_gravityfalls() {

        Biome biome;
        if ((biome = getBiome(Mods.gravityfalls.getResourceLocation("gravityfalls"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeGFGravityFalls(biome));
        }
        if ((biome = getBiome(Mods.gravityfalls.getResourceLocation("nightmarerealm"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeGFNightmareRealm(biome));
        }
    }

    private static void init_mistbiomes() {

        Biome biome;
        if ((biome = getBiome(Mods.mistbiomes.getResourceLocation("mistforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeMBMistForest(biome));
        }
        if ((biome = getBiome(Mods.mistbiomes.getResourceLocation("mistplains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeMBMistPlains(biome));
        }
        if ((biome = getBiome(Mods.mistbiomes.getResourceLocation("misttaiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeMBMistTaiga(biome));
        }
        if ((biome = getBiome(Mods.mistbiomes.getResourceLocation("mistdesert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeMBMistDesert(biome));
        }
        if ((biome = getBiome(Mods.mistbiomes.getResourceLocation("coldmisttaiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeMBColdMistTaiga(biome));
        }
        if ((biome = getBiome(Mods.mistbiomes.getResourceLocation("mistswamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeMBMistSwamp(biome));
        }
        if ((biome = getBiome(Mods.mistbiomes.getResourceLocation("mistymushroomisland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeMBMistMushroomIsland(biome));
        }
    }

    @SuppressWarnings("unused")
    private static void init_novamterram() {

        Biome biome;

        /*
        NT beaches generate as normal biomes in RTG worlds for some reason, so instead of just letting the biome patcher
        replace them with Plains, let's remove them from the Biome Manager completely.
         */

        final List<Biome> ntbeaches = Stream.of(
                        Mods.nt.getResourceLocation("black_beach"),
                        Mods.nt.getResourceLocation("brown_beach"),
                        Mods.nt.getResourceLocation("iron_beach"),
                        Mods.nt.getResourceLocation("olivine_beach"),
                        Mods.nt.getResourceLocation("orange_beach"),
                        Mods.nt.getResourceLocation("pink_beach"),
                        Mods.nt.getResourceLocation("purple_beach"),
                        Mods.nt.getResourceLocation("white_beach")
                )
                .map(ForgeRegistries.BIOMES::getValue)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        Arrays.stream(BiomeManager.BiomeType.values()).forEach(type ->
                Objects.requireNonNull(BiomeManager.getBiomes(type)).stream()
                        .filter(biomeEntry -> ntbeaches.contains(biomeEntry.biome))
                        .forEach(biomeEntry -> BiomeManager.removeBiome(type, biomeEntry)));

        if ((biome = getBiome(Mods.nt.getResourceLocation("aegean_archipelago"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTAegeanArchipelago(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("alium_meadow"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTAliumMeadow(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTAlps(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("autumn_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTAutumnForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("autumn_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTAutumnForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("autumn_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTAutumnTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("autumn_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTAutumnTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("birch_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTBirchHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("black_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTBlackBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("blossom_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTBlossomForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("blossom_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTBlossomForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("blue_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTBlueTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("blue_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTBlueTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("brown_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTBrownBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("clayland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTClayland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cliffs"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTCliffs(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_birch_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdBirchForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_birch_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdBirchForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_blue_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdBlueTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_blue_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdBlueTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdDesert(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_flower_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdFlowerForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_flower_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdFlowerForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_mega_blue_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdMegaBlueTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_mega_blue_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdMegaBlueTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_mega_spruce_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdMegaSpruceTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_mega_spruce_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdMegaSpruceTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_mega_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdMegaTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_mega_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdMegaTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_roofed_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdRoofedForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("cold_roofed_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTColdRoofedForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("estuary"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTEstuary(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("fen"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTFen(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("fungal_jungle"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTFungalJungle(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("fungal_jungle_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTFungalJungleHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("glacier"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTGlacier(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("grass_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTGrassHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("green_mixed_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTGreenMixedForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("green_mixed_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTGreenMixedForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("green_swamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTGreenSwamp(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("heath"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTHeath(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("highland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTHighland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("hotspring"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTHotspring(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("icy_tundra"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTIcyTundra(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("iron_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTIronBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("lake"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTLake(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("lowland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTLowland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("lush_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTLushDesert(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("maple_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMapleForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("maple_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMapleForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("meadow"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMeadow(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mega_autumn_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMegaAutumnTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mega_autumn_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMegaAutumnTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mega_blue_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMegaBlueTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mega_blue_taiga_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMegaBlueTaigaHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mega_maple_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMegaMapleForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mega_maple_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMegaMapleForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mixed_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMixedForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mixed_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMixedForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("monsoon_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMonsoonForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("moorland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMoorland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTMountains(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("oak_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTOakForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("oak_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTOakForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("olivine_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTOlivineBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("orange_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTOrangeBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("pineland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTPineland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("pink_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTPinkBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("poppy_meadow"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTPoppyMeadow(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("purple_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTPurpleBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("red_sand_dune"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTRedSandDune(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("rockland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTRockland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("rocky_taiga"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTRockyTaiga(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("royal_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTRoyalForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("royal_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTRoyalForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("sahel"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTSahel(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("sand_dune"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTSandDune(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("sandy_mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTSandyMountains(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("scrubland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTScrubland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("shrubland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTShrubland(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("snowdune"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTSnowdune(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("stone_fields"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTStoneFields(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("stone_mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTStoneMountains(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("tall_oak_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTTallOakForest(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("tall_oak_forest_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTTallOakForestHills(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("tropical_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTTropicalDesert(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("tundra"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTTundra(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("white_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTWhiteBeach(biome));
        }
        if ((biome = getBiome(Mods.nt.getResourceLocation("white_orchard"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeNTWhiteOrchard(biome));
        }
    }

    private static void init_odioitamod() {

        Biome biome;
        if ((biome = getBiome(Mods.odioitamod.getResourceLocation("whiteblancoaforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeODIOWhiteBlancoaForest(biome));
        }
        if ((biome = getBiome(Mods.odioitamod.getResourceLocation("orangeblancoaforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeODIOOrangeBlancoaForest(biome));
        }
        if ((biome = getBiome(Mods.odioitamod.getResourceLocation("pinkblancoaforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeODIOPinkBlancoaForest(biome));
        }
        if ((biome = getBiome(Mods.odioitamod.getResourceLocation("redblancoaforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeODIORedBlancoaForest(biome));
        }
    }

    private static void init_plants() {

        final Biome biome;
        if ((biome = getBiome(Mods.plants2.getResourceLocation("crystal_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePLANTSCrystalForest(biome));
        }
    }

    private static void init_pvj() {

        Biome biome;
        if ((biome = getBiome(Mods.pvj.getResourceLocation("prairie"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJPraire(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("redwoods"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJRedwoods(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("redwood_peaks"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJRedwoodPeaks(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("willow_swamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJWillowSwamp(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("boreal_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJBorealForest(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("snowy_boreal_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJSnowyBorealForest(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("aspen_grove"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJAspenGrove(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("overgrown_spires"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJOvergrownSpires(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("blossoming_fields"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJBlossomingFields(biome));
        }
        if ((biome = getBiome(Mods.pvj.getResourceLocation("baobab_fields"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomePVJBaobabFields(biome));
        }
    }

    private static void init_realworld() {

        Biome biome;
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_bamboo_marsh"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWBambooMarsh(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_birch_autumn_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWBirchAutumnForest(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_blue_oak_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWBlueOakForest(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_bombona_beach"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWBombonaBeach(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_bur_oak_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWBurOakForest(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_flatland_thicket"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWFlatlandThicket(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_emperor_ridge"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWEmperorRidge(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_silver_birch_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWSilverBirchHills(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_spiny_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWSpinyForest(biome));
        }
        if ((biome = getBiome(Mods.realworld.getResourceLocation("rw_spruce_mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRWSpruceMountains(biome));
        }
    }

    private static void init_redwoods() {

        Biome biome;
        if ((biome = getBiome(Mods.redwoods.getResourceLocation("redwood_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeREDRedwoodForest(biome));
        }
        if ((biome = getBiome(Mods.redwoods.getResourceLocation("lush_redwood_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeREDLushRedwoodForest(biome));
        }
        if ((biome = getBiome(Mods.redwoods.getResourceLocation("temperate_rainforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeREDTemperateRainforest(biome));
        }
        if ((biome = getBiome(Mods.redwoods.getResourceLocation("snowy_rainforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeREDSnowyRainforest(biome));
        }
        if ((biome = getBiome(Mods.redwoods.getResourceLocation("alpine"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeREDAlpine(biome));
        }
    }

    private static void init_rockhounding() {

        Biome biome;
        if ((biome = getBiome(Mods.rockhounding_surface.getResourceLocation("white_sands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeRHWhiteSands(biome));
        }
    }

    private static void init_spookybiomes() {

        Biome biome;
        if ((biome = getBiome(Mods.spookybiomes.getResourceLocation("witchwood_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSBWitchwoodForest(biome));
        }
        if ((biome = getBiome(Mods.spookybiomes.getResourceLocation("ghostly_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSBGhostlyForest(biome));
        }
    }

    private static void init_subaquatic() {

        Biome biome;
        if ((biome = getBiome(Mods.subaquatic.getResourceLocation("deep_warm_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSubaquaticDeepWarmOcean(biome));
        }
        if ((biome = getBiome(Mods.subaquatic.getResourceLocation("deep_lukewarm_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSubaquaticDeepLukewarmOcean(biome));
        }
        if ((biome = getBiome(Mods.subaquatic.getResourceLocation("deep_cold_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSubaquaticDeepColdOcean(biome));
        }
        if ((biome = getBiome(Mods.subaquatic.getResourceLocation("deep_frozen_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSubaquaticDeepFrozenOcean(biome));
        }
        if ((biome = getBiome(Mods.subaquatic.getResourceLocation("warm_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSubaquaticWarmOcean(biome));
        }
        if ((biome = getBiome(Mods.subaquatic.getResourceLocation("lukewarm_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSubaquaticLukewarmOcean(biome));
        }
        if ((biome = getBiome(Mods.subaquatic.getResourceLocation("cold_ocean"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSubaquaticColdOcean(biome));
        }
    }

    private static void init_sugiforest() {

        final Biome biome;
        if ((biome = getBiome(Mods.sugiforest.getResourceLocation("sugi_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeSFSugiForest(biome));
        }
    }

    private static void init_terscraft() {

        final Biome biome;
        if ((biome = getBiome(Mods.terscraft.getResourceLocation("biomedemonite"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTERSBiomeDemonite(biome));
        }
    }

    private static void init_thaumcraft() {

        Biome biome;
        if ((biome = getBiome(Mods.thaumcraft.getResourceLocation("magical_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTCMagicalForest(biome));
        }
        if ((biome = getBiome(Mods.thaumcraft.getResourceLocation("eerie"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTCEerie(biome));
        }
    }

    private static void init_traverse() {

        Biome biome;
        if ((biome = getBiome(Mods.traverse.getResourceLocation("autumnal_woods"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVAutumnalWoods(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("woodlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVWoodlands(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("mini_jungle"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVMiniJungle(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("meadow"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVMeadow(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("green_swamp"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVGreenSwamp(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("red_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVRedDesert(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("temperate_rainforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVTemperateRainforest(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("badlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVBadlands(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("mountainous_desert"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVMountainousDesert(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("rocky_plateau"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVRockyPlateau(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("forested_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVForestedHills(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("birch_forested_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVBirchForestedHills(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("autumnal_wooded_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVAutumnalWoodedHills(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("cliffs"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVCliffs(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("glacier"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVGlacier(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("glacier_spikes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVGlacierSpikes(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("snowy_coniferous_forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVSnowyConiferousForest(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("lush_hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVLushHills(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("desert_shrubland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVDesertShrubland(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("thicket"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVThicket(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("arid_highland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVAridHighland(biome));
        }
        if ((biome = getBiome(Mods.traverse.getResourceLocation("rocky_plains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeTRAVRockyPlains(biome));
        }
    }

    private static void init_vampirism() {

        final Biome biome;
        if ((biome = getBiome(Mods.vampirism.getResourceLocation("vampireforest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeVAMPVampireForest(biome));
        }
    }

    private static void init_zoesteria() {

        Biome biome;
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("archipelago"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEArchipelago(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("australian outback"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEAustralianOutback(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("barelands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEBarelands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("bluff"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEBluff(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("brushlands hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEBrushlandsHills(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("brushlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEBrushlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("bush"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEBush(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("bushland hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEBushlandHills(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("dense brushlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEDenseBrushlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("extreme southern alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEExtremeSouthernAlps(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("forested canyon pillars"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEForestedCanyonPillars(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("forested canyon plateau m"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEForestedCanyonPlateauM(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("forested canyon plateau"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEForestedCanyonPlateau(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("ghost forest"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEGhostForest(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("grassy fen"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEGrassyFen(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("grassy marshland"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEGrassyMarshland(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("high inhabited woodlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEHighInhabitedWoodlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("high woodlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEHighWoodlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("highlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEHighlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("hot brushlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEHotBrushlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("low spruce woodlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOELowSpruceWoodlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("low tall woodlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOELowTallWoodlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("low woodlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOELowWoodlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("lowlands chapparal"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOELowlandsChapparal(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("lowlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOELowlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("mire"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEMire(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("moorlands"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEMoorlands(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("northern alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOENorthernAlps(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("northern snow alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOENorthernSnowAlps(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("northern snow subalpine alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOENorthernSnowSubalpineAlps(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("northern subalpine alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOENorthernSubalpineAlps(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("orchid fields"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEOrchidFields(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("red sand dunes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOERedSandDunes(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("sand dunes m"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESandDunesM(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("sand dunes oasis"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESandDunesOasis(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("sand dunes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESandDunes(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("snow rocks mountains"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESnowRocksMountains(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("snow rocks plateau"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESnowRocksPlateau(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("snow rocks"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESnowRocks(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("southern alps subalpine"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESouthernAlpsSubalpine(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("southern alps"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOESouthernAlps(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("stony reef"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEStonyReef(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("tropical jungle"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOETropicalJungle(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("wasteland flats oasis"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWastelandFlatsOasis(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("wasteland flats slopes"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWastelandFlatsSlopes(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("wasteland flats trees"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWastelandFlatsTrees(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("wasteland flats"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWastelandFlats(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("white oaks hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWhiteOaksHills(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("white oaks"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWhiteOaks(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("white woods hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWhiteWoodsHills(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("white woods"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWhiteWoods(biome));
        }
        if ((biome = getBiome(Mods.valoegheses_be.getResourceLocation("woodlands hills"))) != null) {
            RTGAPI.addRTGBiomes(new RealisticBiomeZOEWoodlandsHills(biome));
        }
    }

    @Nullable
    private static Biome getBiome(final ResourceLocation resloc) {
        return ForgeRegistries.BIOMES.getValue(resloc);
    }
}
