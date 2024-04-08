package net.eganmakela.compmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.eganmakela.compmod.CompMod;
import net.eganmakela.compmod.entity.custom.WizardEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WizardRenderer extends MobRenderer<WizardEntity, WizardModel<WizardEntity>> {
    public WizardRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WizardModel<>(pContext.bakeLayer(ModModelLayers.WIZARD_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(WizardEntity pEntity) {
        return new ResourceLocation(CompMod.MOD_ID, "textures/entity/wizard.png");
    }

    @Override
    public void render(WizardEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}