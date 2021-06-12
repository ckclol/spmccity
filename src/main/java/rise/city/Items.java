package rise.city;

public enum Items {
  ;
  private String name;
  private ItemStack item;
  
  Items(String name, ItemStack item) {
    this.name = name;
    this.item = item;    
  }

  public String getName(Items items) {
    return items.name;
  }
  
  public ItemStack getItem(Items items) {
    return items.item;
  }
  
}
