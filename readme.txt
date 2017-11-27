This a SpringBoot application to make sure that application is accessed by humans not bot. This API takes JSON input with just enough attributes to validate whether the the api has been hit by human or bot. And respond with a JSON to indicate success, failure etc. This API makes sure that clients knows to add  the numbers and respond with a sum. If the sum is incorrect, then the servers responds back saying it's incorrect answer.  


Following Technologies has been used to create this API 
* JAVA 8
* Spring Boot


RUNNING THE API
* You can run the api by simply typing 
   * java -jar target/SmartEquip-0.0.1-SNAPSHOT.jar

*You can now test the service on port 8080 by hitting the below url 
	* http://127.0.0.1:8080/user/client

* You will now get a question id and the question

* The clients responds by posting payloads on postman like below: (client has to send question id along with the response)   
	* {"questionId": 36, "question": "Sum of 638, 388, 872 and 876 is ?", "answer" :"Sum of 638, 388, 872 and 876 is 6"}

*if clients sends the wrong answer , the api responds a HTTP 400 Bad Request

*if clients sends the correct answer , the api responds a HTTP 200 OK 



TOOLS
The following tools are used to create this project :
* STS IDE
* Postman
* Maven


VERSIONING
* V 1.0 


AUTHOR  
* Johnsy Chacko