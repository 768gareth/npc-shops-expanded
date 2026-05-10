package ShopsExpanded;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.ExplorerHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;
;

@ModConstructorPatch(target = ExplorerHumanMob.class, arguments = {})
public class ExplorerPatch 
{
  @OnMethodExit
  static void onExit(@This ExplorerHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      Mob.shop.addSellingItem("mapfragment", new SellingShopItem(25, 5)).setStaticPriceBasedOnHappiness(40, 60, 5);
      Mob.shop.addSellingItem("villagemap", new SellingShopItem()).setStaticPriceBasedOnHappiness(80, 100, 5);
      Mob.shop.addSellingItem("dungeonmap", new SellingShopItem()).setStaticPriceBasedOnHappiness(80, 100, 5).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("chieftainmap", new SellingShopItem()).setStaticPriceBasedOnHappiness(125, 150, 5).addKilledMobRequirement("voidwizard");
      Mob.shop.addSellingItem("piratemap", new SellingShopItem()).setStaticPriceBasedOnHappiness(125, 150, 5).addKilledMobRequirement("ancientvulture");
      Mob.shop.addSellingItem("cronemap", new SellingShopItem()).setStaticPriceBasedOnHappiness(125, 150, 5).addKilledMobRequirement("cryoqueen");
      Mob.shop.addSellingItem("sagegritmap", new SellingShopItem()).setStaticPriceBasedOnHappiness(125, 150, 5).addKilledMobRequirement("pestwarden");
  }
}
