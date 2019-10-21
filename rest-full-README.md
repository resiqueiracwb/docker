##What makes something RESTful?
###### So far, you have a web-based service that handles the core operations involving employee data. But that’s not enough to make things "RESTful".

 - Pretty URLs like /employees/3 aren’t REST.

 - Merely using GET, POST, etc. aren’t REST.

 - Having all the CRUD operations laid out aren’t REST.

###### In fact, what we have built so far is better described as RPC (Remote Procedure Call). That’s because there is no way to know how to interact with this service. If you published this today, you’d also have to write a document or host a developer’s portal somewhere with all the details.

######This statement of Roy Fielding may further lend a clue to the difference between REST and RPC:


#####markdown
[HATEOS](https://spring.io/guides/gs/rest-service/)

[REST](https://spring.io/guides/tutorials/rest/)