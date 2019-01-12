package com.interplay.watery.items.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelOxygenMask - _InterPlay_
 * Created using Tabula 7.0.0
 */
public class ModelOxygenMask extends ModelBiped
{
    public ModelRenderer tecido_head;
    public ModelRenderer lens_right_down;
    public ModelRenderer lens_left_down;
    public ModelRenderer lens_left_up;
    public ModelRenderer lens_right_up;
    public ModelRenderer lens_middle;
    public ModelRenderer lens_left_left;
    public ModelRenderer lens_right_right;
    public ModelRenderer lens_right;
    public ModelRenderer lens_left;
    public ModelRenderer filter_top;
    public ModelRenderer filter_middle;
    public ModelRenderer filter_front;
    public ModelRenderer filter_down;
    public ModelRenderer oxytube1;
    public ModelRenderer oxytube2;
    public ModelRenderer oxytube3;
    public ModelRenderer oxytube4;
    public ModelRenderer oxytube5;
    public ModelRenderer oxytube6;
    public ModelRenderer oxytube7;
    public ModelRenderer tank_in;
    public ModelRenderer tank;
    public ModelRenderer oxytube8;

    public ModelOxygenMask()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.lens_right_down = new ModelRenderer(this, 120, 22);
        this.lens_right_down.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_right_down.addBox(0.8F, 5.0F, -2.0F, 2, 1, 1, 0.0F);
        this.filter_top = new ModelRenderer(this, 100, 20);
        this.filter_top.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.filter_top.addBox(3.0F, 6.0F, -2.0F, 2, 1, 1, 0.0F);
        this.filter_middle = new ModelRenderer(this, 100, 24);
        this.filter_middle.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.filter_middle.addBox(2.0F, 7.0F, -2.0F, 4, 1, 1, 0.0F);
        this.lens_right_up = new ModelRenderer(this, 120, 28);
        this.lens_right_up.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_right_up.addBox(1.0F, 2.0F, -2.0F, 2, 1, 1, 0.0F);
        this.oxytube3 = new ModelRenderer(this, 100, 44);
        this.oxytube3.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.oxytube3.addBox(-1.0F, 9.0F, -1.0F, 3, 2, 2, 0.0F);
        this.lens_middle = new ModelRenderer(this, 120, 30);
        this.lens_middle.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_middle.addBox(3.0F, 3.0F, -2.0F, 2, 2, 1, 0.0F);
        this.oxytube5 = new ModelRenderer(this, 76, 52);
        this.oxytube5.setRotationPoint(-3.0F, -8.0F, -4.0F);
        this.oxytube5.addBox(-4.0F, 6.0F, 1.0F, 2, 2, 6, 0.0F);
        this.lens_right = new ModelRenderer(this, 120, 42);
        this.lens_right.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_right.addBox(1.0F, 3.0F, -2.0F, 2, 2, 1, 0.0F);
        this.tecido_head = new ModelRenderer(this, 87, 0);
        this.tecido_head.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.tecido_head.addBox(-0.9F, -0.8F, -1.0F, 10, 9, 10, 0.0F);
        this.oxytube8 = new ModelRenderer(this, 100, 48);
        this.oxytube8.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.oxytube8.addBox(3.0F, 1.0F, 5.0F, 2, 1, 2, 0.0F);
        this.oxytube1 = new ModelRenderer(this, 100, 36);
        this.oxytube1.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.oxytube1.addBox(3.0F, 9.0F, -3.0F, 2, 2, 2, 0.0F);
        this.lens_left_down = new ModelRenderer(this, 120, 24);
        this.lens_left_down.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_left_down.addBox(4.5F, 5.0F, -2.0F, 2, 1, 1, 0.0F);
        this.lens_left_up = new ModelRenderer(this, 120, 26);
        this.lens_left_up.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_left_up.addBox(4.5F, 2.0F, -2.0F, 2, 1, 1, 0.0F);
        this.filter_front = new ModelRenderer(this, 100, 28);
        this.filter_front.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.filter_front.addBox(3.0F, 7.0F, -3.0F, 2, 1, 1, 0.0F);
        this.lens_left_left = new ModelRenderer(this, 120, 34);
        this.lens_left_left.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_left_left.addBox(7.0F, 3.0F, -2.0F, 1, 2, 1, 0.0F);
        this.lens_left = new ModelRenderer(this, 120, 46);
        this.lens_left.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_left.addBox(5.0F, 3.0F, -2.0F, 2, 2, 1, 0.0F);
        this.tank_in = new ModelRenderer(this, 100, 64);
        this.tank_in.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.tank_in.addBox(3.0F, 2.0F, 5.0F, 2, 1, 2, 0.0F);
        this.filter_down = new ModelRenderer(this, 100, 32);
        this.filter_down.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.filter_down.addBox(3.0F, 8.0F, -2.0F, 2, 1, 3, 0.0F);
        this.oxytube2 = new ModelRenderer(this, 100, 40);
        this.oxytube2.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.oxytube2.addBox(1.0F, 10.0F, -2.0F, 3, 2, 2, 0.0F);
        this.lens_right_right = new ModelRenderer(this, 120, 38);
        this.lens_right_right.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.lens_right_right.addBox(0.0F, 3.0F, -2.0F, 1, 2, 1, 0.0F);
        this.tank = new ModelRenderer(this, 75, 35);
        this.tank.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.tank.addBox(2.0F, 3.0F, 4.0F, 4, 8, 4, 0.0F);
        this.oxytube6 = new ModelRenderer(this, 100, 56);
        this.oxytube6.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.oxytube6.addBox(-3.0F, -1.0F, 4.0F, 2, 2, 2, 0.0F);
        this.oxytube4 = new ModelRenderer(this, 100, 48);
        this.oxytube4.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.oxytube4.addBox(-3.0F, 7.0F, 0.0F, 2, 3, 2, 0.0F);
        this.oxytube7 = new ModelRenderer(this, 100, 60);
        this.oxytube7.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.oxytube7.addBox(-2.0F, 0.0F, 5.0F, 6, 2, 2, 0.0F);
        
      //para grudar na cabeça
        this.bipedHead.addChild(tecido_head);
        this.bipedHead.addChild(lens_right_down);
        this.bipedHead.addChild(lens_left_down);
        this.bipedHead.addChild(lens_left_up);
        this.bipedHead.addChild(lens_right_up);
        this.bipedHead.addChild(lens_middle);
        this.bipedHead.addChild(lens_left_left);
        this.bipedHead.addChild(lens_right_right);
        this.bipedHead.addChild(lens_right);
        this.bipedHead.addChild(lens_left);
        this.bipedHead.addChild(filter_top);
        this.bipedHead.addChild(filter_middle);
        this.bipedHead.addChild(filter_front);
        this.bipedHead.addChild(filter_down);
        this.bipedHead.addChild(oxytube1);
        this.bipedHead.addChild(oxytube2);
        this.bipedHead.addChild(oxytube3);
        this.bipedHead.addChild(oxytube4);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
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
