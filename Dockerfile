From openjdk:8-jre-alpine
copy ./target/foodInventory.war foodInventory.war
CMD ["java","-jar","foodInventory.war"]