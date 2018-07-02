# rabo-blockchain-assignment

I created a contract on the ropsten test chain for the BlockBliek token, the Bliek is an alternative currency meant for Gorinchem. It is a time for time kind of deal.
They now have a centralized system for the administration of their coin. I kind of took the idea of putting this coin on a blockcahin as the use-case for this assignment.  

Playing around with web3j has been on my wishlist for a little while so i decided to create a frontend/backend application using spring boot and web3j at the back and ionic at the front.

### Backend
The backend is finished but could do with a little cleanup, it consists of three restful services. 
To really be useful it should have a way to add users, but i left that out of scope.
After starting the backend application they can be triggered directly from the browser at:  
- http://localhost:8080/users  
- http://server/user/Summer  
- http://server/user/Rick/transfer?to=Summer&amount=1000  

The transfers of blieken can be viewed on etherscan at: https://ropsten.etherscan.io/token/0x06a6be20a421f568bbee64459a902e620b6d6387

### Frontend
The frontend is a long way from being finished, login, security, responsiveness a nice interface, all that and much more is missing.
Only the most basic functionality has been implemented.
Users and their balances can be viewed and blieken can be transferred.  
I experienced a bit of a learning curve with Ionic an Angular, maybe for the end result it would have been better for me to have used vanilla javascript and HTML 5, but then trip would have been less educational :-)  
  
  I implemented the functionality synchronous so the whole thing is very sluggish, some async and a list of pending transactions would be very nice.

### Running the application on your local machine
Prerequisites:  
- Java 8 installed (make sure this does not have the Rabobank version Bouncy Castle)
- Node.js installed
- Ionic installed

Open a terminal window. Go to the target folder and run: "java -jar rabo-erc20-blockbliek-0.0.1-SNAPSHOT.jar".
This will start the backend.
Unzip ionic-front-end.zip. Go to the folder where you unzipped the files and run: "ionic serve". 
This will start the frontend.  
Open a browser window at: http://localhost:8100/.  

Please be patient and try to transfer some blieken! Keep in mind that a transfer can take more than a minute.




