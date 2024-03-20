# ShopSphere-Cart
MicroService in Keystone project ShopSphere.


In folder to store java maven projects execute in terminal:
git clone https://github.com/Josephebj3/ShopSphere-Cart.git -b master
git clone https://github.com/Josephebj3/ShopSphere-Config.git -b master
git clone https://github.com/Josephebj3/ShopSphere-Discount.git -b master
git clone https://github.com/Josephebj3/ShopSphere-Discovery.git -b master
git clone https://github.com/Josephebj3/ShopSphere-Gateway.git -b master
git clone https://github.com/Josephebj3/ShopSphere-Order.git -b master
git clone https://github.com/Josephebj3/ShopSphere-Product.git -b master
git clone https://github.com/Josephebj3/ShopSphere-User.git -b master
git clone https://github.com/Josephebj3/ShopSphere-Wishlist.git -b master

Open projects in eclipse

In Microsevice Config/src/main/resources/configurations/: 
	configure spring.datasource to your local MySQL.

Ports to be used:
Config - 8888
Discovery - 8761
GateWay - 8080
Cart - 8083
Discount - 8086
Order - 8085
Product - 8082
User - 8081
Wishlist - 8084
Frontend - 4200

Run projects in order:
1. Config
2. Discovery
3. GateWay, Cart, Discount, Order, Product, User, Wishlist


Open terminal and copy paste the following commands in folder to store project:
git clone https://github.com/Josephebj3/ShopSphere-Frontend.git -b master
cd ShopSphere-Frontend
npm install
ng serve

Use link in terminal to open web page.
Enjoy 
