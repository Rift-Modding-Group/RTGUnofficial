package rtg.world.biome.realistic.explorercraft;

import net.minecraft.world.biome.Biome;
import rtg.api.world.biome.RealisticBiomeBase;
import rtg.api.world.surface.SurfaceBase;
import rtg.api.world.surface.SurfaceGeneric;

import javax.annotation.Nonnull;


public abstract class RealisticBiomeECBase extends RealisticBiomeBase {

    public RealisticBiomeECBase(@Nonnull final Biome baseBiome, @Nonnull final RiverType riverType, @Nonnull final BeachType beachType) {

        super(baseBiome, riverType, beachType);
    }

    public RealisticBiomeECBase(@Nonnull final Biome baseBiome) {

        this(baseBiome, RiverType.NORMAL, BeachType.NORMAL);
    }

    public RealisticBiomeECBase(@Nonnull final Biome baseBiome, @Nonnull final RiverType riverType) {

        this(baseBiome, riverType, BeachType.NORMAL);
    }

    public RealisticBiomeECBase(@Nonnull final Biome baseBiome, @Nonnull final BeachType beachType) {

        this(baseBiome, RiverType.NORMAL, beachType);
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceGeneric(getConfig(), this.baseBiome().topBlock, this.baseBiome().fillerBlock);
    }

    @Override
    public void initDecos() {

    }
}
