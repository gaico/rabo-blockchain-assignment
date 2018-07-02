package nl.gst.rabo.blockbliek;

import nl.gst.rabo.blockbliek.model.User;
import nl.gst.rabo.blockbliek.model.token.ERC20Token;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;



public class BlockBliekService {
    private String infuraUrl = "https://ropsten.infura.io/gcU4IhOLbOMD4lbUBzdC";
    private String contractAddress = "0x06a6be20a421f568bbee64459a902e620b6d6387";

    public BigInteger getBalance(User user) throws Exception {
        Web3j web3 = Web3j.build(new HttpService(infuraUrl));
        Credentials credentials = WalletUtils.loadCredentials(user.getWallet().getPassword(),user.getWallet().getFile());
        ERC20Token blokbliek = ERC20Token.load(contractAddress, web3, credentials, BigInteger.valueOf(100000), BigInteger.valueOf(200000));
        return blokbliek.balanceOf(user.getAddress()).send();
    }

    public void transfer(User userFrom, User userTo, BigInteger amount) throws Exception {
        Web3j web3 = Web3j.build(new HttpService(infuraUrl));
        Credentials credentials = WalletUtils.loadCredentials(userFrom.getWallet().getPassword(),userFrom.getWallet().getFile());
        ERC20Token blokbliek = ERC20Token.load(contractAddress, web3, credentials, BigInteger.valueOf(100000), BigInteger.valueOf(200000));
        blokbliek.transfer(userTo.getAddress(),amount).send();

        userFrom.setBalance(getBalance(userFrom));
        userTo.setBalance(getBalance(userTo));
    }
}
