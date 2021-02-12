# TopKeyWordAnalyzer 
### Version 1.0.0
This is top keyword Analyzer it uses the concepts of mutiple threading in java 

## Usage <br />
- You can use it to find major keywords for a social media platform,database or a file. <br />
- It can be used to find the trending keywords of social media platform once connected to a database.
 
## Concept Used <br />
>The basic concept that i have used to develop this tool is that:<br />
>>- I have first simple taken all the words and saved them in a hashmap with their respective values but here i have applied the concept of multiple threading<br />
>>- I can add upto a 1lakhs thread and the code won't break as I have made a ThreadManager to implement it.

## How to use<br />
- Simply add the no of threads you want to manage in it.
- Then simple add the threads with the file path 
- You can create threads more than threads you want to run parllely  still it will work manage the extra threads.
- It can handle upto **1Lakh** threads without breaking the code 
``` java
ThreadManager threadManager=new ThreadManager(number of threads you want to run parllely);
        //the threads you want to add
        threadManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyzer("filepath"));
        threadManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyzer("filepath"));
        threadManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyzer("filepath"));
```    
## Updates Coming
>I will be adding interface so that you can simply add the file paths and number of threads in it rather than hardcoding it.<br />
>Happy Coding Folks.
