# HackDaniels
February 2017 University of Arkansas - JB Hunt Hackathon

## API Usage
To connect the API to the app and website, call this url: http://10.30.126.110/~shelby/api/index.php/  

### Base Search
This is the base address. In order to get data from it, specify which table to pull from like this: '.../index.php/{tablename}'. We have 2 tables in our database, 'businesses' and 'deals'.
calling 'index.php/businesses' will return all objects in the 'businesses' table. Same for 'deals'.

### Search for specific attribute value
In order to search for certain objects in a table based on one of the values of it's attributes, structure it like this 'index.php/{tablename}/{key}={value}'  
This will return an array of objects whose attribute {key} has the value of {value}.  
Ex:
"index.php/businesses/name=JJ's" returns the JJ's business object  
"index.php/businesses/type=bar" returns all business objects with a 'type' attribute with value 'bar'

Fields that all business objects can be expected to have include:
* name: the name in plain English
* displayName: this one can include special characters like &
* type: says if this business is a restaurant, bar, or both
* address: the business's address

Fields that all deal objects have:
* Not sure yet

### Adding new entries to the db
call 'index.php/{tablename}/create' with a POST request and pass a JSON object to it with the data you want to add to the table  
Ex: to add Grub's to the database from a bash terminal:
```bash
curl -H "Content-Type: application/json" -X POST -d '{"name" : "Damgoode Pies", "displayName" : "Damgoode Pies", "address" : "37 E Center St, Fayetteville, AR 72701", "type" : "restaurante", "description" : "Casual chain branch offering custom-made pizza with 3 crust options & draft beer, plus takeout."}' http://10.30.126.110/~shelby/api/index.php/businesses/create
```
To do this from php, you can use the built in curl function, for Javascript or Java. You will have to look into http requests and how to interact with a RESTful API to find what classes and functions will need to be called.



### Updating entries in the db
Use of the search calls above will show you an object's id number. Get the id from the object you want to update, then call 'index.php/{tablename}/update/id={id}' with a POST request and a pass a JSON object to it with the attributes you want to change and the new values for them.
Ex:
```bash
curl 'http://10.30.126.110/~shelby/api/index.php/businesses/name=Damgoode%20Pies' # %20 is a space in a url, you will need to put them in your searches or they wont work correctly
 [{"name":"Damgoode Pies","displayName":"Damgoode Pies","description":"Casual chain branch offering custom-made pizza with 3 crust options & draft beer, plus takeout.","type":"restaurante","address":"37 E Center St, Fayetteville, AR 72701","_id":{"$oid":"58a8557b3a4f8d750e2f1082"}}]

curl -H "Content-Type: application/json" -X POST -d '{"type" : "restaurante"}' http://10.30.126.110/~shelby/api/index.php/businesses/update/id=58a8557b3a4f8d750e2f1082
```