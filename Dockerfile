From openjdk:8
copy ./target/foodInventory.war foodInventory.war
CMD ["java","-jar","foodInventory.war"]