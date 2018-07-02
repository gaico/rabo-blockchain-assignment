package nl.gst.rabo.blockbliek;

import nl.gst.rabo.blockbliek.model.token.ERC20Token;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.security.Provider;
import java.security.Security;

public class ChainServiceTest {
    private String infuraUrl = "https://ropsten.infura.io/gcU4IhOLbOMD4lbUBzdC";
    private String contractAddress = "0x06a6be20a421f568bbee64459a902e620b6d6387";

    @Test
    public void testRickToMorty() throws Exception {

        Security.addProvider(new BouncyCastleProvider());
        Provider[] myProviders = Security.getProviders();

        for (Provider prov : myProviders) {
            System.out.println("Prov:" + prov.getName());
        }

        Provider bc = Security.getProvider("BC");

        Web3j web3 = Web3j.build(new HttpService(infuraUrl));
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        System.out.println(web3ClientVersion.getWeb3ClientVersion());

//        org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator gen
//                = new org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator();

        System.out.println(WalletUtils.isValidPrivateKey("c41020702e9bfc5717b8790c1bf35d88da715c679e396be64f5ae4a3a2da23a9"));

        Credentials credentials = WalletUtils.
                loadCredentials("RickRickRick",
                        "/Users/gaico/projects/gaico/rabo-blockchain-assignment/src/main/resources/keystores/rick/UTC--2018-07-01T10-36-43.217Z--7adab81012203a75391b6673e07b7131177237b1");

//        Credentials credentials = Credentials.create("c41020702e9bfc5717b8790c1bf35d88da715c679e396be64f5ae4a3a2da23a9");

        ERC20Token blokbliek = ERC20Token.load(contractAddress, web3, credentials, BigInteger.valueOf(100000), BigInteger.valueOf(200000));

        System.out.println("Balance Rick: " + blokbliek.balanceOf("0x7aDaB81012203A75391B6673e07B7131177237B1").send());
        System.out.println("Balance Morty: " + blokbliek.balanceOf("0x7Ad11050F1e257004DEE8dac4ba50f5713c494EE").send());

        blokbliek.transfer("0x7Ad11050F1e257004DEE8dac4ba50f5713c494EE",BigInteger.valueOf(100)).send();

        System.out.println("Balance Rick: " + blokbliek.balanceOf("0x7aDaB81012203A75391B6673e07B7131177237B1").send());
        System.out.println("Balance Morty: " + blokbliek.balanceOf("0x7Ad11050F1e257004DEE8dac4ba50f5713c494EE").send());

        System.out.println("Supply: " + blokbliek.totalSupply().send());
    }

    @Test
    public void testRickToSummer(){

    }

}
