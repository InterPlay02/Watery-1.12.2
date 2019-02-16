package com.interplay.watery.blocks.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Gerador - InterPlay
 * Created using Tabula 7.0.0
 */
public class ModelEnergyGenerator extends ModelBase
{
    public ModelRenderer CuboGrande;
    public ModelRenderer CuboFrente;
    public ModelRenderer CuboAbaixo;
    public ModelRenderer CuboTrazeiro;
    public ModelRenderer Escapamento;

    public ModelEnergyGenerator()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.CuboGrande = new ModelRenderer(this, 25, 64);
        this.CuboGrande.setRotationPoint(-8.0F, -5.0F, -8.0F);
        this.CuboGrande.addBox(0.0F, 0.0F, 0.0F, 16, 25, 32, 0.0F);
        this.CuboTrazeiro = new ModelRenderer(this, 5, 5);
        this.CuboTrazeiro.setRotationPoint(7.7F, 20.0F, 24.0F);
        this.CuboTrazeiro.addBox(0.0F, 0.0F, 0.0F, 16, 5, 7, 0.0F);
        this.setRotateAngle(CuboTrazeiro, 0.6829473363053812F, 3.141592653589793F, 0.0F);
        this.CuboFrente = new ModelRenderer(this, 5, 20);
        this.CuboFrente.setRotationPoint(-7.8F, 20.0F, -8.0F);
        this.CuboFrente.addBox(0.0F, 0.0F, 0.0F, 16, 5, 7, 0.0F);
        this.setRotateAngle(CuboFrente, 0.6829473363053812F, 0.0F, 0.0F);
        this.Escapamento = new ModelRenderer(this, 55, 5);
        this.Escapamento.setRotationPoint(-4.0F, -8.0F, 14.0F);
        this.Escapamento.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.CuboAbaixo = new ModelRenderer(this, 37, 30);
        this.CuboAbaixo.setRotationPoint(-8.0F, 20.0F, -5.0F);
        this.CuboAbaixo.addBox(0.0F, 0.0F, 0.0F, 16, 4, 26, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    { 
        this.CuboGrande.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.CuboTrazeiro.offsetX, this.CuboTrazeiro.offsetY, this.CuboTrazeiro.offsetZ);
        GlStateManager.translate(this.CuboTrazeiro.rotationPointX * f5, this.CuboTrazeiro.rotationPointY * f5, this.CuboTrazeiro.rotationPointZ * f5);
        GlStateManager.scale(0.96D, 1.0D, 1.0D);
        GlStateManager.translate(-this.CuboTrazeiro.offsetX, -this.CuboTrazeiro.offsetY, -this.CuboTrazeiro.offsetZ);
        GlStateManager.translate(-this.CuboTrazeiro.rotationPointX * f5, -this.CuboTrazeiro.rotationPointY * f5, -this.CuboTrazeiro.rotationPointZ * f5);
        this.CuboTrazeiro.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.CuboFrente.offsetX, this.CuboFrente.offsetY, this.CuboFrente.offsetZ);
        GlStateManager.translate(this.CuboFrente.rotationPointX * f5, this.CuboFrente.rotationPointY * f5, this.CuboFrente.rotationPointZ * f5);
        GlStateManager.scale(0.96D, 1.0D, 1.0D);
        GlStateManager.translate(-this.CuboFrente.offsetX, -this.CuboFrente.offsetY, -this.CuboFrente.offsetZ);
        GlStateManager.translate(-this.CuboFrente.rotationPointX * f5, -this.CuboFrente.rotationPointY * f5, -this.CuboFrente.rotationPointZ * f5);
        this.CuboFrente.render(f5);
        GlStateManager.popMatrix();
        this.Escapamento.render(f5);
        this.CuboAbaixo.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
