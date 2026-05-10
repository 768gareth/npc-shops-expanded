package ShopsExpanded;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.PirateHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = PirateHumanMob.class, arguments = {})
public class BrokenPiratePatch 
{
  @OnMethodExit
  static void onExit(@This PirateHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      Mob.shop.addSellingItem("handcannon", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 1000, 100);
      Mob.shop.addSellingItem("cutlass", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 1000, 100);
      Mob.shop.addSellingItem("flintlock", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 1000, 100);
      Mob.shop.addSellingItem("spareboatparts", new SellingShopItem()).setStaticPriceBasedOnHappiness(400, 800, 100);
      Mob.shop.addSellingItem("lifeline", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 900, 100);
      Mob.shop.addSellingItem("piratebanner", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 5);
      Mob.shop.addSellingItem("largepiratebanner", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 5);
  }
}
