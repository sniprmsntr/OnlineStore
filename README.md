#Online Store CLI Application
This is a simple command line Online Store application, where users can browse and purchase products from the store.

#Requirements
Java (JDK 8 or later)
#Setup
Ensure Java is installed on your system. If not, download and install it from the official website.

#Compile the Java files using the following command:

bash
Copy code
javac Main.java Product.java Cart.java Store.java
Create a Inventory.csv file in the same directory as the compiled Java files and add the desired products in the following format:
Copy code
ID|Name|Price
For example:

#objectivec
Copy code
AV1051|JBL Bluetooth Speaker|89.95
AV1312|Mini 1000Lumens Projector|149.95
Running the Application
Run the application using the following command:

bash
Copy code
java Main
Usage
The application will display the main menu with the following options:

Show Products
Show Cart
Exit
Show Products
Selecting this option will display a list of available products. You can enter the product ID to add it to the cart or type "X" to go back to the main menu.

#Show Cart
This option will display the list of items in the cart along with the total amount. You can choose to check out by typing "C" or return to the main menu by typing "X".

#Check Out
During the check out process, you will be prompted to enter the payment amount in cash. The application will then:

Verify if the payment amount is enough to cover the cost of the items.
If the payment is insufficient, return the full amount to the customer.
If the payment is sufficient, calculate the change owed to the customer, display the list of items sold, clear the shopping cart, and return to the main menu.
Exit
Selecting this option will close the application.

That's it! Enjoy shopping at the Online Store CLI application.
