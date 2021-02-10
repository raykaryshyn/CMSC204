/** A class that maintains a shopping cart for an online store.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public class OnlineShopper
{
	public static void main(String[] args) 
	{
      Item[] items = {new Item("Bird feeder", 2050),
                      new Item("Squirrel guard", 1547),
                      new Item("Bird bath", 4499),
                      new Item("Sunflower seeds", 1295)};
                      
      BagInterface<Item> shoppingCart = new ArrayBag<>();
      int totalCost = 0;
      
      // Statements that add selected items to the shopping cart:
      for (int index = 0; index < items.length; index++)
      {
         Item nextItem = items[index]; // Simulate getting item from shopper
         shoppingCart.add(nextItem);
         totalCost = totalCost + nextItem.getPrice();  
      } // end for

      // Simulate checkout
      while (!shoppingCart.isEmpty())
         System.out.println(shoppingCart.remove());
      
		System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." +
                         totalCost % 100);

                         
      // Custom test for ArrayBag
      customTest();
	} // end main

   
   /**
    * Custom test for ArrayBag
    *
    * @author Raymond Karyshyn
    */
   private static void customTest() {
      System.out.println("\n\n" +
         "\\/\\/\\/ - - - Custom Test - - - \\/\\/\\/"
      );
      Item apple = new Item("Apple", 2998);
      Item banana = new Item("Banana", 2998);
      Item orange = new Item("Orange", 2998);
      Item pear = new Item("Pear", 2998);
      Item hat = new Item("hat", 5000);
      Item[] shoppingList = {
         apple,
         apple,
         banana,
         orange,
         orange,
         orange,
         orange,
         pear,
         pear
      };

      BagInterface<Item> shoppingCart2 = new ArrayBag<>();
      int totalCost = 0;

      System.out.println("Adding shopping list items to shopping cart...");
      for (int i = 0; i < shoppingList.length; i++) {
         Item nextItem = shoppingList[i];
         shoppingCart2.add(nextItem);
         totalCost += nextItem.getPrice();
      }

      System.out.println(
         "My shopping cart has " +
         shoppingCart2.getCurrentSize() +
         " items and is" +
         (shoppingCart2.isEmpty() ? "" : " NOT") +
         " empty."
      );

      System.out.println("\nHere is what is in my shopping cart:");
      Object[] shoppingCart2Array = shoppingCart2.toArray();
      for (int i = 0; i < shoppingCart2Array.length; i++) {
         System.out.println(shoppingCart2Array[i]);
      }

      System.out.println("\n" +
         "As you can see, my shopping cart does" +
         (shoppingCart2.contains(banana) ? "" : " NOT") +
         " contain a Banana.\n" +

         "My shopping cart does" +
         (shoppingCart2.contains(hat) ? "" : " NOT") +
         " contain a Hat."
      );

      System.out.println("\n" +
         "Furthermore, my shopping cart has " +
         shoppingCart2.getFrequencyOf(apple) + " Apples, " +
         shoppingCart2.getFrequencyOf(banana) + " Banana, " +
         shoppingCart2.getFrequencyOf(orange) + " Oranges, and " +
         shoppingCart2.getFrequencyOf(pear) + " Pears."
      );

      System.out.println("\nCurrently checking out...");
      while (!shoppingCart2.isEmpty())
         shoppingCart2.remove();
      System.out.println(
         "My shopping cart has " +
         shoppingCart2.getCurrentSize() +
         " items and is indeed" +
         (shoppingCart2.isEmpty() ? "" : " NOT") +
         " empty."
      );
      System.out.println(
         "Paying a total of $" + 
         totalCost / 100 + "." + totalCost % 100 + 
         " with a debit card."
      );
      System.out.println("Success.");
   } // end customTest
} // end OnlineShopper

/*
Sunflower seeds $12.95
Bird bath	    $44.99
Squirrel guard	 $15.47
Bird feeder	    $20.50
Total cost: 	 $93.91
*/