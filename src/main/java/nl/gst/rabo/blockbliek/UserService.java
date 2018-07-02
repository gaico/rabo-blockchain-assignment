package nl.gst.rabo.blockbliek;

import nl.gst.rabo.blockbliek.model.User;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final BlockBliekService blockBliekService;

    public UserService(UserRepository userRepository, BlockBliekService blockBliekService) {
        this.userRepository = userRepository;
        this.blockBliekService = blockBliekService;
    }

    public List<User> getUsers() throws Exception {
        List<User> out = new ArrayList<>();
        for(User user: userRepository.getUsers()){
            user.setBalance(blockBliekService.getBalance(user));
            out.add(user);
        }
        return out;
    }

    public User getUser(String userName) throws Exception {
        User user = userRepository.getUser(userName);
        user.setBalance(blockBliekService.getBalance(user));
        return user;
    }

    public List<User> transferFunds(String userNameFrom, String userNameTo, BigInteger amount) throws Exception {
        User userFrom = this.getUser(userNameFrom);
        User userTo = this.getUser(userNameTo);

        blockBliekService.transfer(userFrom, userTo, amount);

        return getUsers();

        //return out;

    }
}
