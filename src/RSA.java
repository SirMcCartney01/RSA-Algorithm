import java.math.BigInteger;
import java.util.Random;

/**
 * Created by cesar on 26/04/17.
 */
public class RSA {

    int tamPrimo;
    private BigInteger n, q, p;
    private BigInteger indicatriz;
    private BigInteger e, d;

    public RSA(int tamPrimo){
        this.tamPrimo = tamPrimo;
        genPrimes();
        genKeys();
    }

    public RSA(BigInteger p,BigInteger q,int tamPrimo) {
        this.tamPrimo=tamPrimo;
        this.p=p;
        this.q=q;
        genKeys();             //Genera e y d
    }

    public void genPrimes() {

        //Tamaño - Certeza - Aleatorio
        p = new BigInteger(tamPrimo, 100, new Random());
        do q = new BigInteger(tamPrimo, 100, new Random());
        while(q.compareTo(p)==0);
    }

    public void genKeys()
    {
        n = p.multiply(q);
        indicatriz = p.subtract(BigInteger.valueOf(1));
        indicatriz = indicatriz.multiply(q.subtract(BigInteger.valueOf(1)));
        // Elegimos un e coprimo de y menor que n
        do e = new BigInteger(2 * tamPrimo, new Random());
        while((e.compareTo(indicatriz) != -1) ||
                (e.gcd(indicatriz).compareTo(BigInteger.valueOf(1)) != 0));
        // d = e^1 mod indicatriz
        d = e.modInverse(indicatriz);
    }

    public BigInteger[] encripta(String mensaje)
    {
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        for(i=0; i<bigdigitos.length;i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        BigInteger[] encriptado = new BigInteger[bigdigitos.length];

        for(i=0; i<bigdigitos.length; i++)
            encriptado[i] = bigdigitos[i].modPow(e,n);

        return(encriptado);
    }

    public String desencripta(BigInteger[] encriptado) {
        BigInteger[] desencriptado = new BigInteger[encriptado.length];

        for(int i=0; i<desencriptado.length; i++)
            desencriptado[i] = encriptado[i].modPow(d,n);

        char[] charArray = new char[desencriptado.length];

        for(int i=0; i<charArray.length; i++)
            charArray[i] = (char) (desencriptado[i].intValue());

        return(new String(charArray));
    }




    public BigInteger getP() {return(p);}
    public BigInteger getQ() {return(q);}
    public BigInteger getIndicatriz() {return(indicatriz);}
    public BigInteger getE() {return(e);}
    public BigInteger getD() {return(d);}
}
