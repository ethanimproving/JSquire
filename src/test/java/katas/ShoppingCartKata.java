package katas;

import framework.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <ul>
 *    <li>isEmptyReturnsTrueForAnEmptyCart() ::: return true
 *    <li>isEmptyReturnsFalseAfterWeAddAnItem() ::: introduce "isEmpty" field and change when addItem is called
 *    <li>totalPriceReturnsTheTotalCostOfItemsInTheCart() ::: refactor into list of Items in cart
 *    <li>getItemsReturnsAListOfItemsAndPrices() ::: return hardcoded string
 *    <li>getItemsIncludesTotalPriceAndQuantityForMultipleItems() ::: refactor into list strings
 */
class ShoppingCartKata
{
   ShoppingCart shoppingCart;

   @BeforeEach
   public void setUp()
   {
      shoppingCart = new ShoppingCart();
   }

   @Test
   public void isEmptyReturnsTrueForAnEmptyCart()
   {
      assertTrue( shoppingCart.isEmpty() );
   }

   @Test
   public void isEmptyReturnsFalseAfterWeAddAnItem()
   {
      shoppingCart.addItem( new Item( "Banana", "Yum", 15 ) );

      assertFalse( shoppingCart.isEmpty() );
   }

   @Test
   public void totalPriceReturnsTheTotalCostOfItemsInTheCart()
   {
      shoppingCart.addItem( new Item( "Banana", "Yum", 5 ) );
      shoppingCart.addItem( new Item( "Orange", "Yum", 3 ) );
      shoppingCart.addItem( new Item( "Coconut", "Yum", 7 ) );

      assertEquals( 15, shoppingCart.totalPrice() );

      shoppingCart.addItem( new Item( "Coconut", "Yum", 7 ) );
      assertEquals( 22, shoppingCart.totalPrice() );
   }

   @Test
   public void getItemsReturnsAStringOfItemsAndPrices()
   {
      shoppingCart.addItem( new Item( "Mango", "Yum", 5 ) );

      assertEquals( "1 Mango For 5 Dollars", shoppingCart.getItems().get( 0 ) );
   }

   @Test
   public void getItemsReturnsAListOfItemsAndPrices()
   {
      shoppingCart.addItem( new Item( "Mango", "Yum", 5 ) );
      shoppingCart.addItem( new Item( "Guava", "Yum", 3 ) );
      shoppingCart.addItem( new Item( "Apple", "Yum", 2 ) );

      assertArrayEquals( new String[] { "1 Mango For 5 Dollars","1 Guava For 3 Dollars","1 Apple For 2 Dollars"}, shoppingCart.getItems().toArray() );
   }

   @Test
   public void getItemsIncludesTotalPriceAndQuantityForMultipleItems()
   {
      shoppingCart.addItem( new Item( "Mango", "Yum", 5 ) );
      shoppingCart.addItem( new Item( "Guava", "Yum", 3 ) );
      shoppingCart.addItem( new Item( "Apple", "Yum", 2 ) );
      shoppingCart.addItem( new Item( "Apple", "Yum", 2 ) );

      assertArrayEquals( new String[] { "1 Mango For 5 Dollars","1 Guava For 3 Dollars","2 Apple For 4 Dollars"}, shoppingCart.getItems().toArray() );
   }

   }