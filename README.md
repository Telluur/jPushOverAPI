jPushoverAPI
=========
No external libraries required. - This is a Work in Progress.


Usage
---------

```java
//Create Pushoverclient
PushoverClient pc = new PushoverClient(PUSHOVER_TOKEN, PUSHOVER_USER);

//Create Pushovermessage
PushoverMessage pm = new PushoverMessage("Hey, I'm a pushover message!");

//Set additional information
pm.setPriority(PushoverPriority.EMERGENCY);

//Dispatch pushover message.
pc.sendMessage(pm);
```

TODO
---------
* Proper documentation.
* Responsemessage/code handling.
* Message queueing 

![Creative Commons](http://i.creativecommons.org/l/by-sa/4.0/88x31.png)
