package katas;

import framework.Item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart
{
   List<Item> items;

   public ShoppingCart()
   {
      items = new ArrayList<>();
   }

   public boolean isEmpty()
   {
      return items.isEmpty();
   }

   public void addItem( Item item )
   {
      items.add( item );
   }

   public int totalPrice()
   {
      return items.stream().map( Item::getCost ).reduce( 0, Integer::sum );
   }

   /**
    * <ol> Algorithm:
    *    <li> Store in map grouped by name with list of items belonging to that category
    *    <li> Reduce each group to string reducing on cost and list count for quantity
    */
   public List<String> getItems()
   {
      return this.items.stream()
                       .collect( Collectors.groupingBy( Item::getName,
                                                        LinkedHashMap::new,
                                                        Collectors.toList() ) )
                       .entrySet()
                       .stream()
                       .map( list -> String.format(
                             "%d %s For %d Dollars",
                             list.getValue().size(),
                             list.getKey(),
                             list.getValue().stream().map( Item::getCost ).reduce( 0, Integer::sum ) ) )
                       .collect( Collectors.toList() );

   }
}
