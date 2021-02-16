# spmccity
Welcome to spmccity plugin!
Here is how to edit the code...

.
# VanillaItems:
Get eclipse or a java coding program.
Download and edit my code.
Make a new class in city/spmc/utils/vanillaitems
Call it the item you want (space is replaced with _ )
# IMPORTANT!
In the class, next to Your item name, put extends (NoLore or lore) VanillaItemCreator or NoLoreVanillaItemCReator (no lore mean no the thing below item name or description)
like this

`public class Stick extends NoLoreVanillaItemCreator {
    public Stick(RarityMain rarity, Material m) {
        super(rarity, m);
    }
}`

Click on the error and get the super thing.
Then go to SpiritualCity.java, 
type noloreor vanillaitem depends

` public void registerVanillaItems() {
        putVanillaItem(new Barrier(RarityMain.ELITE, Material.BARRIER, Arrays.asList("get gone in 10 secs"))); // for lore items
        putNoLore(new Stick(RarityMain.COMMON, Material.STICK)); // no lore items`
        
# CustomItems:
Do the same but put the class at city/spmc/items
# IMPORTANT 2
In the class next to the item name put extends ItemCreator and click on error to get the super thing and the stuff

`public class SpecialBedrock extends ItemCreator {
    public SpecialBedrock(int id, RarityMain rarity, String name_of_item, Material m, List ability) {
        super(id, rarity, name_of_item, m, ability);
    }

    @Override
    public void leftClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void leftClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void rightClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void rightClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void shiftLeftClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void shiftLeftClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void shiftRightClickAirAction(Player var1, ItemStack var2) {

    }

    @Override
    public void shiftRightClickBlockAction(Player var1, PlayerInteractEvent var2, Block var3, ItemStack var4) {

    }

    @Override
    public void hitEntityAction(Player var1, EntityDamageByEntityEvent var2, Entity var3, ItemStack var4) {

    }
}
`
And do the same thing (put in spiritualcity)
but put it here

`   public void registerItems() {
      putItem("name", new SClass(id, RarityMain.EAGLE, Material.BEDROCK, Arrays.asList("first lore", "second lore", "add more")));
    }`
