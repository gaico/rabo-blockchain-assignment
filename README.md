# rabo-blockchain-assignment

I created a contract on the ropsten test chain for the BlockBliek token, the Bliek is an alternative currency meant for Gorinchem. It is a time for time kind of deal.
They now have a centralized system for the administration of their coin. I kind of took the idea of putting this coin on a blockcahin as the use-case for this assignment.  

Playing around with web3j has been on my wishlist for a little while so i decided to create a frontend/backend application using spring boot and web3j at the back and ionic at the front.

##Backend
The backend consits of three restfull services:  
http://server/users  
http://server/user/Summer  
http://server/user/Rick/transfer?to=Summer&amount=1000

The transfers can be viewed at the here: https://ropsten.etherscan.io/address/0x06a6be20a421f568bbee64459a902e620b6d6387

##Status
The backend is finished but could do with a little cleanup.  
The frontend is a long way from being finished, login, security a nice interface, all that and more is missing.
Only the most basic functionality has been implemented.
Users and their balances can be viewed and blieken can be transferred.  
I had a lot of trouble with Ionic an Angular, I probably would be a lot further if i would have used vanilla javascript and htlm 5, but the trip was fun and educational :-)  
  
  I implemented the functionality synchronous so the whole thing is very sluggish, some async and a list of pending transactions would be very nice.


##Running the application on your local machine
Prerequisites:  
Java 8 installed (make sure this does not have the Rabobank version Bouncy Castle)
Node.js installed
Ionic installed

Open a terminal window. Go to the target folder and run: "java -jar rabo-erc20-blockbliek-0.0.1-SNAPSHOT.jar".
This will start the backend.
Unzip ionic-front-end.zip. Go to the folder where you unzipped the file and run: "ionic serve". This will start the frontend.  
Open a browser window at: http://localhost:8100/.  
Please be patient and try to transfer some blieken!




