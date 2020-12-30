package team.chisel.ctm.client.texture.type;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import team.chisel.ctm.api.client.CTMTexture;
import team.chisel.ctm.api.client.TextureContext;
import team.chisel.ctm.api.client.TextureInfo;
import team.chisel.ctm.api.client.TextureType;
import team.chisel.ctm.client.texture.AbstractConnectingTexture;
import team.chisel.ctm.client.texture.TextureEdgesFull;
import team.chisel.ctm.client.texture.context.TextureContextConnecting;

public class TextureTypeEdgesFull implements TextureType {
	@Override
	public CTMTexture<TextureTypeEdgesFull> makeTexture(TextureInfo info) {
		return new TextureEdgesFull(this, info);
	}

	@Override
	public TextureContext getTextureContext(BlockState state, BlockView world, BlockPos pos, CTMTexture<?> texture) {
		return new TextureContextConnecting.TextureContextConnectingObscured(state, world, pos, (AbstractConnectingTexture<?>) texture);
	}

	@Override
	public int requiredTextures() {
		return 2;
	}

	@Override
	public int getQuadsPerSide() {
		return 1;
	}
}
