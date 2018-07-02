package nl.gst.rabo.blockbliek;


import nl.gst.rabo.blockbliek.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Credentials;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin
public class TransactionsController {

    private final UserService userService;

    public TransactionsController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping("/user/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName) throws Exception {
        return new ResponseEntity<User>(userService.getUser(userName), HttpStatus.OK);
    }

    @RequestMapping("/user/{userNameFrom}/transfer")
    public ResponseEntity<List<User>> getUser(@PathVariable String userNameFrom, @RequestParam String to, @RequestParam BigInteger amount) throws Exception {
        return new ResponseEntity<List<User>>(userService.transferFunds(userNameFrom, to, amount), HttpStatus.OK);
    }


}
