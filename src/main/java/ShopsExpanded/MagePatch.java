package ShopsExpanded;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.engine.network.server.ServerClient;
import necesse.engine.registries.GameRegistry;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.friendly.human.humanShop.BuyingShopItem;
import necesse.entity.mobs.friendly.human.humanShop.HumanShop;
import necesse.entity.mobs.friendly.human.humanShop.MageHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.placeableItem.objectItem.WaystoneObjectItem;
import necesse.level.maps.levelData.settlementData.ServerSettlementData;
import net.bytebuddy.asm.Advice.OnMethodExit;
import net.bytebuddy.asm.Advice.This;

@ModConstructorPatch(target = MageHumanMob.class, arguments = {})
public class MagePatch 
{
  @OnMethodExit
  static void onExit(@This MageHumanMob Mob) 
  {
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.sellingShop);
      ClearRegistry.Clear((GameRegistry<?>)Mob.shop.buyingShop);
      Mob.shop.addSellingItem("voidpouch", new SellingShopItem()).setStaticPriceBasedOnHappiness(750, 1000, 50);
      Mob.shop.addSellingItem("voidbag", new SellingShopItem()).setStaticPriceBasedOnHappiness(2500, 3000, 100);
      Mob.shop.addSellingItem("recallflask", new SellingShopItem()).setStaticPriceBasedOnHappiness(1000, 1200, 50).addKilledMobRequirement("ancientvulture");
      Mob.shop.addSellingItem("portalflask", new SellingShopItem()).setStaticPriceBasedOnHappiness(1600, 2400, 50).addKilledMobRequirement("pestwarden");
      Mob.shop.addSellingItem("homestone", new SellingShopItem()).setItem(MagePatch::GenerateHomestone).setStaticPriceBasedOnHappiness(1000, 1250, 100);
      Mob.shop.addSellingItem("waystone", new SellingShopItem()).setItem(MagePatch::GenerateWaystone).setStaticPriceBasedOnHappiness(250, 500, 100);
      Mob.shop.addSellingItem("recallscroll", new SellingShopItem()).setStaticPriceBasedOnHappiness(25, 50, 5);
      Mob.shop.addSellingItem("teleportationscroll", new SellingShopItem()).setStaticPriceBasedOnHappiness(30, 55, 5);
      Mob.shop.addSellingItem("bloodbolt", new SellingShopItem()).setStaticPriceBasedOnHappiness(70, 100, 5);
      Mob.shop.addSellingItem("brainonastick", new SellingShopItem()).setStaticPriceBasedOnHappiness(425, 500, 15);
      Mob.shop.addSellingItem("voidstaff", new SellingShopItem()).setStaticPriceBasedOnHappiness(400, 600, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("shadowbeam", new SellingShopItem()).setStaticPriceBasedOnHappiness(800, 900, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("reaperscall", new SellingShopItem()).setStaticPriceBasedOnHappiness(725, 800, 25).addKilledMobRequirement("reaper");
      Mob.shop.addSellingItem("venomshower", new SellingShopItem()).setStaticPriceBasedOnHappiness(1200, 1500, 50).addKilledMobRequirement("sageandgrit");
      Mob.shop.addSellingItem("manapotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(10, 25, 5);
      Mob.shop.addSellingItem("greatermanapotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(40, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("superiormanapotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(80, 100, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("manaregenpotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(10, 25, 5);
      Mob.shop.addSellingItem("greatermanaregenpotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(50, 100, 5).addKilledMobRequirement("fallenwizard");
      Mob.shop.addSellingItem("wisdompotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("minionpotion", new SellingShopItem()).setStaticPriceBasedOnHappiness(25, 50, 5).addKilledMobRequirement("piratecaptain");
      Mob.shop.addSellingItem("magicmanual", new SellingShopItem()).setStaticPriceBasedOnHappiness(300, 400, 10).addKilledMobRequirement("evilsprotector");
      Mob.shop.addSellingItem("inducingamulet", new SellingShopItem()).setStaticPriceBasedOnHappiness(600, 800, 10).addKilledMobRequirement("piratecaptain");
      
      Mob.shop.addBuyingItem("firemone", new BuyingShopItem()).setPriceBasedOnHappiness(12, 3, 3);
      Mob.shop.addBuyingItem("sunflower", new BuyingShopItem()).setPriceBasedOnHappiness(12, 3, 3);
      Mob.shop.addBuyingItem("iceblossom", new BuyingShopItem()).setPriceBasedOnHappiness(12, 3, 3);
      Mob.shop.addBuyingItem("book", new BuyingShopItem()).setPriceBasedOnHappiness(15, 10, 2);
      Mob.shop.addBuyingItem("ectoplasm", new BuyingShopItem()).setPriceBasedOnHappiness(18, 10, 2);
      Mob.shop.addBuyingItem("lifequartz", new BuyingShopItem()).setPriceBasedOnHappiness(20, 12, 2);
      Mob.shop.addBuyingItem("upgradeshard", new BuyingShopItem()).setPriceBasedOnHappiness(15, 8, 1).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("shadowessence", new BuyingShopItem()).setPriceBasedOnHappiness(25, 15, 2).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("cryoessence", new BuyingShopItem()).setPriceBasedOnHappiness(25, 15, 2).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("bioessence", new BuyingShopItem()).setPriceBasedOnHappiness(25, 15, 2).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("primordialessence", new BuyingShopItem()).setPriceBasedOnHappiness(25, 15, 2).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("slimeessence", new BuyingShopItem()).setPriceBasedOnHappiness(40, 20, 2).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("bloodessence", new BuyingShopItem()).setPriceBasedOnHappiness(40, 20, 2).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("spideressence", new BuyingShopItem()).setPriceBasedOnHappiness(40, 20, 2).addKilledMobRequirement("fallenwizard");
      Mob.shop.addBuyingItem("phantomdust", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("nightswarm");
      Mob.shop.addBuyingItem("slimematter", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("motherslime");
      Mob.shop.addBuyingItem("spidervenom", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("spiderempress");
      Mob.shop.addBuyingItem("omnicrystal", new BuyingShopItem()).setPriceBasedOnHappiness(35, 20, 2).addKilledMobRequirement("crystaldragon");
      Mob.shop.addBuyingItem("pearlescentdiamond", new BuyingShopItem()).setPriceBasedOnHappiness(40, 20, 2).addKilledMobRequirement("crystaldragon");
  }
  
  public static InventoryItem GenerateHomestone(GameRandom random, ServerClient client, HumanShop mob) {
    ServerSettlementData Settlement = mob.getSettlerSettlementServerData();
    return (Settlement != null) ? 
      new InventoryItem("homestone") : null;
  }
  
  public static InventoryItem GenerateWaystone(GameRandom random, ServerClient client, HumanShop mob) {
    ServerSettlementData Settlement = mob.getSettlerSettlementServerData();
    return (Settlement != null) ?  
      WaystoneObjectItem.setupWaystoneItem(new InventoryItem("waystone"), mob.getSettlementUniqueID()) : 
      null;
  }
}
