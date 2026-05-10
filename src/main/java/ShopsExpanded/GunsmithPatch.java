package ShopsExpanded;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.registries.GameRegistry;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.GunsmithHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = GunsmithHumanMob.class, arguments = {})
public class GunsmithPatch 
{
  @OnMethodExit
  static void onExit(@This GunsmithHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      Mob.shop.addSellingItem("ammobox", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 750, 50);
      Mob.shop.addSellingItem("ammopouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("ammobag", new SellingShopItem()).setStaticPriceBasedOnHappiness(1500, 2000, 50);
      Mob.shop.addSellingItem("handgun", new SellingShopItem()).setStaticPriceBasedOnHappiness(200, 250, 5);
      Mob.shop.addSellingItem("machinegun", new SellingShopItem()).setStaticPriceBasedOnHappiness(500, 800, 100).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("shotgun", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 1000, 100).addKilledMobRequirement("voidwizard");
      Mob.shop.addSellingItem("sixshooter", new SellingShopItem()).setStaticPriceBasedOnHappiness(650, 1050, 100).addKilledMobRequirement("swampguardian");
      Mob.shop.addSellingItem("sniperrifle", new SellingShopItem()).setStaticPriceBasedOnHappiness(700, 1100, 100).addKilledMobRequirement("ancientvulture");
      Mob.shop.addSellingItem("deathripper", new SellingShopItem()).setStaticPriceBasedOnHappiness(800, 900, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("antiquerifle", new SellingShopItem()).setStaticPriceBasedOnHappiness(1200, 1500, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("simplebullet", new SellingShopItem()).setStaticPriceBasedOnHappiness(1, 2, 0);
      Mob.shop.addSellingItem("bouncingbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(3, 4, 0);
      Mob.shop.addSellingItem("voidbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(4, 5, 0);
      Mob.shop.addSellingItem("frostbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(4, 5, 0);
      Mob.shop.addSellingItem("crystalbullet", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(10, 12, 0).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("cannonball", new SellingShopItem(200, 25)).setStaticPriceBasedOnHappiness(15, 20, 0).addKilledMobRequirement("piratecaptain");

      Mob.shop.addBuyingItem("sapphire", new BuyingShopItem()).setPriceBasedOnHappiness(30, 20, 2);
      Mob.shop.addBuyingItem("amethyst", new BuyingShopItem()).setPriceBasedOnHappiness(30, 20, 2);
      Mob.shop.addBuyingItem("ruby", new BuyingShopItem()).setPriceBasedOnHappiness(30, 20, 2);
      Mob.shop.addBuyingItem("emerald", new BuyingShopItem()).setPriceBasedOnHappiness(30, 20, 2);
      Mob.shop.addBuyingItem("topaz", new BuyingShopItem()).setPriceBasedOnHappiness(30, 20, 2);
      Mob.shop.addBuyingItem("glacialshard", new BuyingShopItem()).setPriceBasedOnHappiness(20, 12, 2).addKilledMobRequirement("piratecaptain");
      Mob.shop.addBuyingItem("amber", new BuyingShopItem()).setPriceBasedOnHappiness(25, 15, 2).addKilledMobRequirement("piratecaptain");
      Mob.shop.addBuyingItem("phantomdust", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("nightswarm");
      Mob.shop.addBuyingItem("slimematter", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("motherslime");
      Mob.shop.addBuyingItem("spidervenom", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("spiderempress");
      Mob.shop.addBuyingItem("nightsteelbar", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 2).addKilledMobRequirement("nightswarm");
      Mob.shop.addBuyingItem("spideritebar", new BuyingShopItem()).setPriceBasedOnHappiness(50, 25, 2).addKilledMobRequirement("spiderempress");
      Mob.shop.addBuyingItem("slimeum", new BuyingShopItem()).setPriceBasedOnHappiness(30, 20, 2).addKilledMobRequirement("motherslime");
      Mob.shop.addBuyingItem("omnicrystal", new BuyingShopItem()).setPriceBasedOnHappiness(60, 40, 2).addKilledMobRequirement("crystaldragon");
      Mob.shop.addBuyingItem("pearlescentdiamond", new BuyingShopItem()).setPriceBasedOnHappiness(60, 40, 2).addKilledMobRequirement("crystaldragon");
  }
}