package net.withrage.wildlifejournal.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class WildlifeJournalTrophyBlock extends Block {

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(18) != 0) {
            return;
        }

        double x = pos.getX() + 0.25 + random.nextDouble() * 0.5;
        double y = pos.getY() + 0.75 + random.nextDouble() * 0.35;
        double z = pos.getZ() + 0.25 + random.nextDouble() * 0.5;

        world.addParticle(
                ParticleTypes.END_ROD,
                x, y, z,
                0.0, 0.01, 0.0
        );
    }

    private static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 4, 12, 4, 12),
            Block.createCuboidShape(6, 4, 6, 10, 10, 10),
            Block.createCuboidShape(3, 10, 3, 13, 14, 13)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public WildlifeJournalTrophyBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }
}
